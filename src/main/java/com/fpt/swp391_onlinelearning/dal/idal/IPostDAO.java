/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Post;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author quang
 */
public interface IPostDAO extends IDAO<Post> {

    public List<Post> getAllShowPost();

    public List<Post> searchListPost(String searchInput, Date timeFrom, Date timeTo, int pageIndex,int postCategoryId);

    public int countNumberOfPageSearchPost(String searchInput, Date timeFrom, Date timeTo, int postCategoryId);
}
