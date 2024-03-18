/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.SliderDTO;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author phuc2
 */
public interface ISliderService extends IService<SliderDTO> {

    public List<SliderDTO> getListOfSliderDTO();

    public List<SliderDTO> searchListSlider(String searchInput, Date timeFrom, Date timeTo, int pageIndex);

    public int countNumberOfPageSearchSlider(String searchInput, Date timeFrom, Date timeTo);

    public boolean updatePostId(int postId);
}
