/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import model.MyBatisUtil; 
import model.ElectronicMapper;
import org.apache.ibatis.session.SqlSession; 
import view.ElectronicsView;
import controller.ElectronicsController;
/**
 *
 * @author thega
 */
public class Main {
    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSession(); 
        ElectronicMapper mapper = session.getMapper(ElectronicMapper.class);
        
        ElectronicsView view = new ElectronicsView(); 
        new ElectronicsController(view, mapper);
        
        view.setVisible(true);
    }
}

