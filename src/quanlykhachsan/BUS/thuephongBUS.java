/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.BUS;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import quanlykhachsan.DAO.thuephongModify;
import quanlykhachsan.DTO.thuephongDTO;

/**
 *
 * @author Duy Minh
 */
public class thuephongBUS {
    thuephongModify tpModify;
    public thuephongBUS() throws SQLException {
        tpModify = new thuephongModify();
    }
    public boolean themthuephong(thuephongDTO tpDTO) throws SQLException {
        return tpModify.insertrentroom(tpDTO);
    }
//    public void showphong(DefaultTableModel tb) throws SQLException {
//
//        List<thuephongDTO> thuephongList = tpModify.findAll();
////        DefaultTableModel tb = new DefaultTableModel();
//        tb.setRowCount(0);
//        thuephongList.forEach((thuephong) -> {
//            tb.addRow(thuephong.to_array());
//            System.out.println(Arrays.toString(thuephong.to_array()));
//        });
//    }
     public void searchrentroom(String coderoom,DefaultTableModel tb) throws SQLException {

        List<thuephongDTO> thuephongList = tpModify.findrentroom(coderoom);
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        thuephongList.forEach((thuephong) -> {
            tb.addRow(thuephong.to_array());
            System.out.println(Arrays.toString(thuephong.to_array()));
        });
    }
}
