/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.SliderDAO;
import com.fpt.swp391_onlinelearning.dal.idbcontex.ISliderDAO;
import com.fpt.swp391_onlinelearning.dto.SliderDTO;
import com.fpt.swp391_onlinelearning.model.Slider;
import com.fpt.swp391_onlinelearning.service.iservice.ISliderService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author phuc2
 */
public class SliderService implements ISliderService{

    private static SliderService sliderService;
    private ISliderDAO sliderDAO;
    
    public static SliderService getInstance(SliderDAO sliderDAO)
    {
        if(sliderService==null)
        {
            sliderService=new SliderService(sliderDAO);
        }
        return sliderService;
    }
    
    public SliderService(SliderDAO sliderDAO)
    {
        this.sliderDAO=sliderDAO;
    }
    
    @Override
    public List<SliderDTO> getListOfSliderDTO(String link) {
        List<Slider> sliderList= sliderDAO.getListOfSlider(link);
        return Converter.toSliderListDTO(sliderList);
    }
    
    @Override
    public List<SliderDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SliderDTO get(int id) {
        Slider slider= sliderDAO.get(id);
        return Converter.toDTO(slider);
    }

    @Override
    public boolean update(SliderDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(SliderDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
