/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Blog;
import com.fpt.swp391_onlinelearning.model.BlogView;
import java.util.Map;

/**
 *
 * @author phuc2
 */
public interface IBlogViewDAO extends IDAO<Blog>{
    public Map<BlogView , Integer> getBlogTrendView(int periodOfDays);
    public int getTotalBlogView(int periodOfDays);
    public void addNewBlogView(BlogView b);
    public void addPublicBlogView(BlogView b);
}
