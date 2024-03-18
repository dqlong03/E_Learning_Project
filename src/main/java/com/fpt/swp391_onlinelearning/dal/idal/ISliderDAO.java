/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Slider;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author phuc2
 */
public interface ISliderDAO extends IDAO<Slider> {
    public List<Slider> getListOfSlider();
    public List<Slider> searchListSlider(String searchInput, Date timeFrom, Date timeTo, int pageIndex);

    public int countNumberOfPageSearchSlider(String searchInput, Date timeFrom, Date timeTo);

    public boolean updatePostId(int postId);
}
