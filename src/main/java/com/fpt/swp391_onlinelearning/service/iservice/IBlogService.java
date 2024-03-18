/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.BlogCategoryDTO;
import com.fpt.swp391_onlinelearning.dto.BlogDTO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author phuc2
 */
public interface IBlogService {

    public List<BlogDTO> getRecentlyBlog(int numOfBlogs);

    public List<BlogDTO> searchBlog(String title, int categoryId, int pageIndex, int orderTime);

    public List<BlogDTO> getRecentBlog();

    public int countNumberOfPageSearchBlog(String title, int categoryId);

    public BlogDTO getBlogDetail(int blogId);

    public List<BlogDTO> getSearchList(String title, int blogCategoryId, int pageIndex, String author, Date from, Date to);

    public BlogDTO getDetail(int blogId);

    public int countNumberOfPageSearch(String title, int blogCategoryId, String author, Date from, Date to);

    public void changeStatus(String blogId, String status);

}
