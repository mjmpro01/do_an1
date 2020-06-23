/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.BUS;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import quanlykhachsan.DAO.hoadonModify;
import quanlykhachsan.DAO.thuephongModify;
import quanlykhachsan.DTO.hoadondichvuDTO;
import quanlykhachsan.DTO.hoadonphongDTO;
import quanlykhachsan.DTO.phongDTO;
import quanlykhachsan.DTO.thuephongDTO;

/**
 *
 * @author Duy Minh
 */
public class hoadonBUS {

    hoadonModify hdModify;

    public hoadonBUS() throws SQLException {
        hdModify = new hoadonModify();
    }

    public void showphong(DefaultTableModel tb) throws SQLException {

        List<hoadonphongDTO> hdphongList;
        hdphongList = hdModify.findAll();
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        hdphongList.forEach((phong) -> {
            tb.addRow(phong.to_array1());
        });
    }
    public void showhoadonphong(String maphongString,DefaultTableModel tb) throws SQLException {

        List<hoadonphongDTO> hdphongList;
        hdphongList = hdModify.showbillroom(maphongString);
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        hdphongList.forEach((phong) -> {
            tb.addRow(phong.to_array());
        });
    }
    public void showhoadondichvu(String maphongString,DefaultTableModel tb) throws SQLException {

        List<hoadondichvuDTO> hddvList;
        hddvList = hdModify.findhddv(maphongString);
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        hddvList.forEach((hddichvu) -> {
            tb.addRow(hddichvu.to_array());
        });
    }
    public boolean themhoadon(String maphong) throws SQLException
    {
        return hdModify.insertBill(maphong);
    }
}
