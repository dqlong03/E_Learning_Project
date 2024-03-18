/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import com.fpt.swp391_onlinelearning.dto.SettingDTO;
import com.fpt.swp391_onlinelearning.dto.SettingTypeDTO;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ISettingListService {
    public List<SettingDTO> getAll(int pageindex, int pagesize, String info, int typeid, int status);
    
    public List<SettingTypeDTO> getAllType();
    
    public int getCount(String info ,int typeid,int status);
    
    public void update(int typeid,int id,String name,int status);
    
    public void insert(int typeid,String name,int status);
}
