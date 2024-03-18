/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service;

import com.fpt.swp391_onlinelearning.convert.Converter;
import com.fpt.swp391_onlinelearning.dal.idal.IBlogViewDAO;
import com.fpt.swp391_onlinelearning.dto.BlogDTO;
import com.fpt.swp391_onlinelearning.dto.BlogViewDTO;
import com.fpt.swp391_onlinelearning.model.BlogView;
import com.fpt.swp391_onlinelearning.service.iservice.IBlogViewService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phuc2
 */
public class BlogViewService implements IBlogViewService{

    private static BlogViewService blogViewService;
    private IBlogViewDAO _iblogViewDAO;
    
    public BlogViewService(IBlogViewDAO _iblogViewDAO) {
        this._iblogViewDAO = _iblogViewDAO;
    }
    
    public static BlogViewService getInstance(IBlogViewDAO _iblogViewDAO) {
        if (blogViewService == null) {
            blogViewService = new BlogViewService(_iblogViewDAO);
        }
        return blogViewService;
    }
    
    @Override
    public Map<BlogViewDTO, Integer> getBlogViewTrend(int periodOfDays) {
        Map<BlogViewDTO, Integer> blogDTOViewTrend = new HashMap<>();
        Map<BlogView , Integer> blogViewTrend= _iblogViewDAO.getBlogTrendView(periodOfDays);
        for (Map.Entry<BlogView, Integer> entry : blogViewTrend.entrySet())
        {
            blogDTOViewTrend.put(Converter.toDTO(entry.getKey()), entry.getValue());
        }
        return blogDTOViewTrend;
    }

    @Override
    public int getRemainingBlogView(Map<BlogViewDTO, Integer> blogViewTrend ,int periodOfDays) {
        int totalBlogView= _iblogViewDAO.getTotalBlogView(periodOfDays);
        int viewTrend= 0;
        for (Map.Entry<BlogViewDTO, Integer> entry : blogViewTrend.entrySet())
        {
            viewTrend+=entry.getValue();
        }
        return totalBlogView-viewTrend;
    }

    @Override
    public void addNewBlogView(BlogViewDTO bdto) {
        BlogView b= Converter.toDomain(bdto);
        if(bdto.getUser()!=null)
        {
            _iblogViewDAO.addNewBlogView(b);
        }
        else
        {
            _iblogViewDAO.addPublicBlogView(b);
        }
        
    }

    @Override
    public List<BlogDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public BlogDTO get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(BlogDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean insert(BlogDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
    _iblogViewDAO.delete(id);
    return true;
    }
    
}
