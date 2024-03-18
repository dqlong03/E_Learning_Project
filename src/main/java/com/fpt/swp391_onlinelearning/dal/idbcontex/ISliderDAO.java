/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idbcontex;

import com.fpt.swp391_onlinelearning.model.Slider;
import java.util.List;

/**
 *
 * @author phuc2
 */
public interface ISliderDAO extends IDAO<Slider> {
    public List<Slider> getListOfSlider(String link);
}
