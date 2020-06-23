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
import quanlykhachsan.DAO.NhanvienModify;
import quanlykhachsan.DTO.nhanvienDTO;

/**
 *
 * @author Duy Minh
 */
public class nhanvienBUS {

    NhanvienModify nv;

    public nhanvienBUS() throws SQLException {
        nv = new NhanvienModify();
    }

    public void shownhanvien(DefaultTableModel tb) throws SQLException {

        List<nhanvienDTO> nhanvienList = nv.findAll();
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        nhanvienList.forEach((nhanvien) -> {
            tb.addRow(nhanvien.to_array());
            System.out.println(Arrays.toString(nhanvien.to_array()));
        });
    }

    public boolean suanhanvien(nhanvienDTO nvDTO) throws SQLException {

        return nv.update(nvDTO);

    }

    public boolean xoanhanvien(nhanvienDTO nvDTO) throws SQLException {

        return nv.delete(nvDTO);

    }
    public void timkiemnhanvien(String fullname,DefaultTableModel tb) throws SQLException
    {
        List<nhanvienDTO> nhanvienList = nv.searchFullName(fullname);
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        nhanvienList.forEach((nhanvien) -> {
            tb.addRow(nhanvien.to_array());
            System.out.println(Arrays.toString(nhanvien.to_array()));
        });
    
    }
    public boolean themnhanvien(nhanvienDTO nvDTO) throws SQLException{
        return nv.insert(nvDTO);
    }
}
