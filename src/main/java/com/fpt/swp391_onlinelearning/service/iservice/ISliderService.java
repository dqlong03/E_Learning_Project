/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.SliderDTO;
import java.util.List;

/**
 *
 * @author phuc2
 */
public interface ISliderService extends IService<SliderDTO>{
    public List<SliderDTO> getListOfSliderDTO(String link);
}
