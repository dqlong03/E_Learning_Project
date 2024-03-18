/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idbcontex;

import com.fpt.swp391_onlinelearning.model.Blog;
import com.fpt.swp391_onlinelearning.model.BlogCategory;
import java.util.List;

/**
 *
 * @author phuc2
 */
public interface IBlogDAO {
    public List<Blog> getRecentlyBlog(int numOfBlogs); 
    public List<Blog> searchBlog(String title, int blogCategoryId, int pageIndex, int order);

    public List<Blog> getRecentBlog();

    public int countNumberOfPageSearchBlog(String title, int blogCategoryId);

    public Blog getBlogDetail(int blogId);

    public List<BlogCategory> getAllBlogCategory();
}
