/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.swp391_onlinelearning.service.iservice;

import java.util.List;

/**
 *
 * @author tran Hoang Phuc
 */
public interface IService<T> {
    public List<T> getAll();

    public T get(int id);

    public boolean update(T t);

    public boolean insert(T t);

    public boolean delete(int id);
}
