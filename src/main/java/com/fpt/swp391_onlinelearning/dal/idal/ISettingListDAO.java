/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpt.swp391_onlinelearning.dal.idal;

import com.fpt.swp391_onlinelearning.model.Setting;
import com.fpt.swp391_onlinelearning.model.SettingType;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ISettingListDAO {
    public List<Setting> getAll(int pageindex, int pagesize,String info,int typeid,int status);
    
    public List<SettingType> getAllType();
    
    public int getCount(String info ,int typeid,int status);
    
    public void update(int typeid,int id,String name,int status);
    
    public void insert(int typeid,String name,int status);
    
    
}
