/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.BUS;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.lang.model.SourceVersion;
import javax.swing.table.DefaultTableModel;
import quanlykhachsan.DAO.phongModify;
import quanlykhachsan.DTO.phongDTO;

/**
 *
 * @author Duy Minh
 */
public class phongBUS {

    phongModify p;

    public phongBUS() throws SQLException {
        p = new phongModify();
    }

    public void showphong(DefaultTableModel tb) throws SQLException {

        List<phongDTO> phongList = p.findAll();
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        phongList.forEach((phong) -> {
            tb.addRow(phong.to_array());
            System.out.println(Arrays.toString(phong.to_array()));
        });
    }

    public boolean themphong(phongDTO pDTO) throws SQLException {
        return p.insert(pDTO);
    }
    public boolean xoaphong(phongDTO pDTO) throws SQLException {
        return p.delete(pDTO);
    }
    public boolean suaphong(phongDTO pDTO) throws SQLException {
        return p.update(pDTO);
    }
    public void timkiemphong(String loaiphong,DefaultTableModel tb) throws SQLException
    {
        List<phongDTO> phongList = p.searchloaiphong(loaiphong);
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        phongList.forEach((phong) -> {
            tb.addRow(phong.to_array());
            System.out.println(Arrays.toString(phong.to_array()));
        });
    
    }
     public void showphongtrong(DefaultTableModel tb) throws SQLException {

        List<phongDTO> phongList = p.findEmptyRoom();
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        phongList.forEach((phong) -> {
            tb.addRow(phong.to_array1());
            System.out.println(Arrays.toString(phong.to_array1()));
        });
    }
     public void showphongtrongvadadat(DefaultTableModel tb) throws SQLException {

        List<phongDTO> phongList = p.findEmptyBookingRoom();
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        phongList.forEach((phong) -> {
            tb.addRow(phong.to_array());
            System.out.println(Arrays.toString(phong.to_array()));
        });
    }
    public void timkiemloaiphongvatinhtrang (String loaiphong,String tinhtrang,DefaultTableModel tb) throws SQLException
    {
        List<phongDTO> phongList = p.searchtyperoomandstatus(loaiphong,tinhtrang);
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        phongList.forEach((phong) -> {
            tb.addRow(phong.to_array());
            System.out.println(Arrays.toString(phong.to_array()));
        });
    
    }

  
}
