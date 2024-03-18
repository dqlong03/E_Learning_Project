/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.SliderDAO;
import com.fpt.swp391_onlinelearning.dal.idal.ISliderDAO;
import com.fpt.swp391_onlinelearning.dto.SliderDTO;
import com.fpt.swp391_onlinelearning.model.Slider;
import com.fpt.swp391_onlinelearning.service.iservice.ISliderService;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author phuc2
 */
public class SliderService implements ISliderService {

    private static SliderService sliderService;
    private ISliderDAO sliderDAO;

    public static SliderService getInstance(SliderDAO sliderDAO) {
        if (sliderService == null) {
            sliderService = new SliderService(sliderDAO);
        }
        return sliderService;
    }

    public SliderService(SliderDAO sliderDAO) {
        this.sliderDAO = sliderDAO;
    }

    @Override
    public List<SliderDTO> getListOfSliderDTO() {
        List<Slider> sliderList = sliderDAO.getListOfSlider();
        return Converter.toSliderListDTO(sliderList);
    }

    @Override
    public SliderDTO get(int id) {
        Slider slider = sliderDAO.get(id);
        return Converter.toDTO(slider);
    }

    @Override
    public boolean update(SliderDTO t) {
        Slider slider = Converter.toSliderUpdateDomain(t);
        sliderDAO.update(slider);
        return true;
    }

    @Override
    public boolean insert(SliderDTO t) {
        Slider slider = Converter.toSliderInsertDomain(t);
        sliderDAO.insert(slider);
        return true;
    }

    @Override
    public boolean delete(int id) {
        sliderDAO.delete(id);
        return true;
    }

    @Override
    public List<SliderDTO> searchListSlider(String searchInput, Date timeFrom, Date timeTo, int pageIndex) {
        List<Slider> sliders = sliderDAO.searchListSlider(searchInput, timeFrom, timeTo, pageIndex);
        return Converter.toDto4(sliders);
    }

    @Override
    public int countNumberOfPageSearchSlider(String searchInput, Date timeFrom, Date timeTo) {
        int count = sliderDAO.countNumberOfPageSearchSlider(searchInput, timeFrom, timeTo);
        return count;
    }

    @Override
    public boolean updatePostId(int postId) {
        sliderDAO.updatePostId(postId);
        return true;
    }

    @Override
    public List<SliderDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
