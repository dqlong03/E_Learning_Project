/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.BlogViewDTO;
import java.util.Map;

/**
 *
 * @author phuc2
 */
public interface IBlogViewService {
    public Map<BlogViewDTO, Integer> getBlogViewTrend(int periodOfDays); 
    public int getRemainingBlogView(Map<BlogViewDTO, Integer> blogViewTrend,int periodOfDays);
    public void addNewBlogView(BlogViewDTO bdto);
}
