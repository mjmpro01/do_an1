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
import quanlykhachsan.DAO.datphongModify;
import quanlykhachsan.DTO.datphongDTO;
import quanlykhachsan.DTO.phongDTO;

/**
 *
 * @author Duy Minh
 */
public class datphongBUS {

    datphongModify dp;
    
    public datphongBUS() throws SQLException {
        dp = new datphongModify();
    }

    public void showphong(DefaultTableModel tb) throws SQLException {

        List<datphongDTO> datphongList = dp.findAll();
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        datphongList.forEach((datphong) -> {
            tb.addRow(datphong.to_array1());
            System.out.println(Arrays.toString(datphong.to_array1()));
        });
    }

    public boolean themdatphong(datphongDTO dpDTO) throws SQLException {
        return dp.insert(dpDTO);
    }

    public boolean xoadatphong(String madp) throws SQLException {
        return dp.delete(madp);
    }

    public datphongDTO timkiemphongdat(String coderoom, DefaultTableModel tb) throws SQLException {
        List<datphongDTO> datphongList = dp.searchcoderoom(coderoom);
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        datphongList.forEach((datphong) -> {
            tb.addRow(datphong.to_array1());      
            System.out.println(Arrays.toString(datphong.to_array1()));
        });
        return null;
    }
     public phongDTO showkhachdadatphong(String coderoom,String checkin,String checkout,DefaultTableModel tb ) throws SQLException {
         List<phongDTO> phongList = dp.showRoomAva(coderoom, checkin, checkout);
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        phongList.forEach((phong) -> {
            tb.addRow(phong.to_array2());
            System.out.println(Arrays.toString(phong.to_array2()));
        });
        return null;
    
     }
}
