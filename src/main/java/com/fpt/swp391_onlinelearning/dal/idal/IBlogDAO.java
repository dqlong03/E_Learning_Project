/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Blog;
import com.fpt.swp391_onlinelearning.model.BlogCategory;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author phuc2
 */
public interface IBlogDAO extends IDAO<Blog>{

    public List<Blog> getRecentlyBlog(int numOfBlogs);

    public List<Blog> searchBlog(String title, int blogCategoryId, int pageIndex, int order);

    public List<Blog> getRecentBlog();

    public int countNumberOfPageSearchBlog(String title, int blogCategoryId);

    public Blog getBlogDetail(int blogId);

    public List<BlogCategory> getAllBlogCategory();
    //    public List<BlogCategory> getAllBlogCategory();

    public List<Blog> getSearchList(String title, int blogCategoryId, int pageIndex, String author, Date from, Date to);

    public int countRecordOfSearchList(String title, int blogCategoryId, String author, Date from, Date to);

    public Blog getDetail(int blogId);

    public void changeStatus(int blogId, boolean status);

    public List<Blog> getSearchList(String title, int blogCategoryId, int pageIndex, int authorId, Date from, Date to);

    public int countRecordOfSearchList(String title, int blogCategoryId, int authorId, Date from, Date to);
}
