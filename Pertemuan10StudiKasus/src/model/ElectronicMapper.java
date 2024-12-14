/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import org.apache.ibatis.annotations.*;
import java.util.List;
/**
 *
 * @author thega
 */
public interface ElectronicMapper {
    @Select("SELECT * FROM electronics")
    List<Electronic> getAllElectronics();

    @Insert("INSERT INTO electronics (name, brand, price, stock) VALUES (#{name}, #{brand}, #{price}, #{stock})")
    void insertElectronic(Electronic electronic);

    @Update("UPDATE electronics SET name = #{name}, brand = #{brand}, price = #{price}, stock = #{stock} WHERE id = #{id}")
    void updateElectronic(Electronic electronic);

    @Delete("DELETE FROM electronics WHERE id = #{id}")
    void deleteElectronic(int id);
}
