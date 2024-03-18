/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.PostDTO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author quang
 */
public interface IPostService extends IService<PostDTO> {

    public List<PostDTO> getAllShowPost();

    public List<PostDTO> searchListPost(String searchInput, Date timeFrom, Date timeTo, int pageIndex,int postCategoryId);

    public int countNumberOfPageSearchPost(String searchInput, Date timeFrom, Date timeTo, int postCategoryId);
}
