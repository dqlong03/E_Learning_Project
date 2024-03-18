/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.util;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tran Hoang Phuc
 */
public class EmailUtil {

    private static final String email = "trang841687325742@gmail.com";
    private static final String password = "cujlizqqszjsezct";
    private static EmailUtil emailUtil;
    private static Thread thread;

    // gửi nhiều, chạy trên 1 luồng khác sẽ tối ưu hệ thống
    public void sendMailAll(List<String> lstMailTo, String titleMail, String body) throws MessagingException {
        final int[] i = {0};
        thread = new Thread(() -> {
            for (i[0] = 0; i[0] < lstMailTo.size(); i[0]++) {
                sendMail(lstMailTo.get(i[0]), titleMail, body);
            }
        });
        thread.start();
    }

    public void sendMailAll(String mailTo, String titleMail, List<String> bodies) throws MessagingException {
        final int[] i = {0};
        thread = new Thread(() -> {
            for (i[0] = 0; i[0] < bodies.size(); i[0]++) {
                sendMail(mailTo, titleMail, bodies.get(i[0]));
            }
        });
        thread.start();
    }

    public boolean sendMail(String emailTo, String titleMail, String body) {
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.setProperty("mail.smtp.port", "587");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        });
        MimeMessage mimeMessage = new MimeMessage(session);
        try {
            mimeMessage.setFrom(new InternetAddress("email"));
            mimeMessage.setRecipients(Message.RecipientType.TO, emailTo);
            mimeMessage.setSubject(titleMail, "utf-8");
            mimeMessage.setContent(body, "text/html; charset=UTF-8");
            mimeMessage.setReplyTo(mimeMessage.getFrom());
            Transport.send(mimeMessage);
            return true;
        } catch (AddressException ex) {
            Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (MessagingException ex) {
            Logger.getLogger(EmailUtil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public static EmailUtil getMailUtils() {
        if (emailUtil == null) {
            emailUtil = new EmailUtil();
        }
        return emailUtil;
    }
}
