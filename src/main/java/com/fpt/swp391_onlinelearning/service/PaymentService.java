/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.dal.idbcontex.IDAO;
import com.fpt.swp391_onlinelearning.dal.idbcontex.IUserDAO;
import com.fpt.swp391_onlinelearning.dto.AccountDTO;
import com.fpt.swp391_onlinelearning.dto.CourseDTO;
import com.fpt.swp391_onlinelearning.dto.UserDTO;
import com.fpt.swp391_onlinelearning.model.Course;
import com.fpt.swp391_onlinelearning.model.CourseRegisteration;
import com.fpt.swp391_onlinelearning.model.Transaction;
import com.fpt.swp391_onlinelearning.model.User;
import com.fpt.swp391_onlinelearning.service.iservice.IPaymentService;
import com.fpt.swp391_onlinelearning.util.VnpayUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

/**
 *
 * @author tran Hoang Phuc
 */
public class PaymentService implements IPaymentService {

    private static PaymentService paymentService;
    private IUserDAO _iUserDAO;
    private IDAO<CourseRegisteration> _iCourseRegisterationDAO;
    private IDAO<Transaction> _iTransactionDAO;

    public static PaymentService getInstance(IUserDAO _iUserDAO , IDAO<CourseRegisteration> _iCourseRegisterationDAO, IDAO<Transaction> _iTransactionDAO) {
        if (paymentService == null) {
            paymentService = new PaymentService(_iUserDAO, _iCourseRegisterationDAO, _iTransactionDAO);
        }
        return paymentService;
    }

    public PaymentService(IUserDAO _iUserDAO, IDAO<CourseRegisteration> _iCourseRegisterationDAO, IDAO<Transaction> _iTransactionDAO) {
        this._iUserDAO = _iUserDAO;
        this._iCourseRegisterationDAO = _iCourseRegisterationDAO;
        this._iTransactionDAO = _iTransactionDAO;
    }

    @Override
    public String payForCourse(HttpServletRequest req, long price, AccountDTO dto, CourseDTO course) throws ServletException, IOException {
        long amount = price * 100;
        User user = _iUserDAO.getUserByAccountId(dto.getAccId());
        if (user.getBalance() >= course.getPrice()) {
           user.setBalance(user.getBalance() - price);
           // update lại user's price
           _iUserDAO.updateBalance(user);
           // insert bang courseRegisteration
           Course c = new Course();
           c.setCourseId(course.getCourseId());
//           CourseRegisteration cr = new CourseRegisteration();
//           cr.setCourse(c);
//           cr.setUser(user);
//           _iCourseRegisterationDAO.insert(cr);
           return "true";
        } else {
            String vnp_Version = "2.1.0";
            String vnp_Command = "pay";
            String orderType = "other";
            String bankCode = "";
            String vnp_TxnRef = VnpayUtil.getRandomNumber(8);
            String vnp_IpAddr = VnpayUtil.getIpAddress(req);
            String vnp_TmnCode = VnpayUtil.vnp_TmnCode;
            Map<String, String> vnp_Params = new HashMap<>();
            vnp_Params.put("vnp_Version", vnp_Version);
            vnp_Params.put("vnp_Command", vnp_Command);
            vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
            vnp_Params.put("vnp_Amount", String.valueOf(amount));
            vnp_Params.put("vnp_CurrCode", "VND");

            if (bankCode != null && !bankCode.isEmpty()) {
                vnp_Params.put("vnp_BankCode", bankCode);
            }
            vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
            vnp_Params.put("vnp_OrderInfo", "Thanh toan don hang:" + vnp_TxnRef);
            vnp_Params.put("vnp_OrderType", orderType);

            String locate = req.getParameter("language");
            if (locate != null && !locate.isEmpty()) {
                vnp_Params.put("vnp_Locale", locate);
            } else {
                vnp_Params.put("vnp_Locale", "vn");
            }
            vnp_Params.put("vnp_ReturnUrl", VnpayUtil.vnp_ReturnUrl);
            vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

            Calendar cld = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
            String vnp_CreateDate = formatter.format(cld.getTime());
            vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

            cld.add(Calendar.MINUTE, 15);
            String vnp_ExpireDate = formatter.format(cld.getTime());
            vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate);

            List fieldNames = new ArrayList(vnp_Params.keySet());
            Collections.sort(fieldNames);
            StringBuilder hashData = new StringBuilder();
            StringBuilder query = new StringBuilder();
            Iterator itr = fieldNames.iterator();
            while (itr.hasNext()) {
                String fieldName = (String) itr.next();
                String fieldValue = (String) vnp_Params.get(fieldName);
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    //Build hash data
                    hashData.append(fieldName);
                    hashData.append('=');
                    hashData.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    //Build query
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                    query.append('=');
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    if (itr.hasNext()) {
                        query.append('&');
                        hashData.append('&');
                    }
                }
            }
            String queryUrl = query.toString();
            String vnp_SecureHash = VnpayUtil.hmacSHA512(VnpayUtil.secretKey, hashData.toString());
            queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
            String paymentUrl = VnpayUtil.vnp_PayUrl + "?" + queryUrl;
            JsonObject job = new JsonObject();
            job.addProperty("code", "00");
            job.addProperty("message", "success");
            job.addProperty("data", paymentUrl);
            Gson gson = new Gson();
            //resp.getWriter().write(gson.toJson(job));
            String a = gson.toJson(job);
            a = a.replace("\\u003d", "=");
            a = a.replace("\\u0026", "&");
            JSONObject jsonObject = new JSONObject(a);
            return jsonObject.getString("data");
        }

    }

    @Override
    public void paymentReturn(String transactionId, long amount, Date createdTime, boolean status, UserDTO user) {
        Transaction transaction = new Transaction(transactionId, amount, createdTime, status);
        _iTransactionDAO.insert(transaction);
        User u = new User();
        u.setUserId(user.getUserId());
        u.setBalance(user.getBalance() + amount);
        _iUserDAO.updateBalance(u);
    }

    @Override
    public void pay(long amount, CourseDTO course, UserDTO user) {
        user.setBalance(amount);
        Course c = new Course();
        c.setCourseId(course.getCourseId());
        User u = new User();
        u.setUserId(user.getUserId());
        u.setBalance(user.getBalance());
        _iUserDAO.updateBalance(u);
        CourseRegisteration courseRegisteration = new CourseRegisteration();
        courseRegisteration.setCourse(c);
        courseRegisteration.setUser(u);
        _iCourseRegisterationDAO.insert(courseRegisteration);
    }

}
