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
import quanlykhachsan.DAO.giaphongModify;
import quanlykhachsan.DTO.chisoDTO;
import quanlykhachsan.DTO.giaphongDTO;

/**
 *
 * @author Duy Minh
 */
public class giaphongBUS {
    
    giaphongModify gpModify;
    public giaphongBUS() throws SQLException{
        gpModify = new giaphongModify();
    }
     public void showloaiphong(DefaultTableModel tb) throws SQLException {

        List<giaphongDTO> giaphongList = gpModify.showoomRates();
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        giaphongList.forEach((giaphong) -> {
            tb.addRow(giaphong.to_array1());
            System.out.println(Arrays.toString(giaphong.to_array1()));
        });
    }
     public boolean themloaiphong(giaphongDTO gp) throws SQLException{
        return gpModify.insert(gp);
     }
      public boolean xoaloaiphong(giaphongDTO gp) throws SQLException{
        return gpModify.delete(gp);
     }
        public boolean capnhatloaiphong(giaphongDTO gp) throws SQLException{
        return gpModify.update(gp);
     }
}
