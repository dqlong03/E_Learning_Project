/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.dal.idal.ICourseRegistrationDAO;
import com.fpt.swp391_onlinelearning.dal.idal.ITempEnrollmentDAO;
import com.fpt.swp391_onlinelearning.service.iservice.ITempEnrollService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public class TempEnrollmentService implements ITempEnrollService {

    private static TempEnrollmentService service;
    private ITempEnrollmentDAO tempEnrollmentDAO;
    private ICourseRegistrationDAO courseRegistrationDAO;

    public TempEnrollmentService(ITempEnrollmentDAO tempEnrollmentDAO, ICourseRegistrationDAO courseRegistrationDAO) {
        this.tempEnrollmentDAO = tempEnrollmentDAO;
        this.courseRegistrationDAO = courseRegistrationDAO;
    }

    public static TempEnrollmentService getInstance(ITempEnrollmentDAO tempEnrollmentDAO, ICourseRegistrationDAO courseRegistrationDAO) {
        if (service == null) {
            service = new TempEnrollmentService(tempEnrollmentDAO, courseRegistrationDAO);
        }
        return service;
    }

    @Override
    public boolean addTempEnrollment(int userId, String[] courseIds, int staffId) {
        List<String> courseIdAvalible = new ArrayList<>();
        for (String courseIdString : courseIds) {
            int courseId = Integer.parseInt(courseIdString);
            if (courseRegistrationDAO.canJoin(courseId, userId) && tempEnrollmentDAO.canJoin(userId, courseId)) {
                courseIdAvalible.add(courseIdString);
            }

        }
        if (!courseIdAvalible.isEmpty()) {
            String[] courseIdCanAdd = new String[courseIdAvalible.size()];
            for (int i = 0; i < courseIdAvalible.size(); i++) {
                courseIdCanAdd[i] = courseIdAvalible.get(i);
            }
            tempEnrollmentDAO.addTempEnrollment(userId, courseIdCanAdd, staffId);
            return true;
        }
        return false;
    }

    @Override
    public void deleteTimeoutEnrollment(int userId) {
        tempEnrollmentDAO.deleteTimeoutEnrollment(userId);
    }

}
