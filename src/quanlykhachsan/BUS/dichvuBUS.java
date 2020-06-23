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
import quanlykhachsan.DAO.dichvuModify;
import quanlykhachsan.DTO.dichvuDTO;

/**
 *
 * @author Duy Minh
 */
public class dichvuBUS {

    dichvuModify dv;

    public dichvuBUS() throws SQLException {
        dv = new dichvuModify();
    }

    public void showdichvu(DefaultTableModel tb) throws SQLException {

        List<dichvuDTO> dichvuList = dv.findAll();
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        dichvuList.forEach((dichvu) -> {
            tb.addRow(dichvu.to_array());
        });
    }

    public boolean suadichvu(dichvuDTO dvDTO) throws SQLException {

        return dv.update(dvDTO);

    }

    public boolean xoadichvu(dichvuDTO dvDTO) throws SQLException {

        return dv.delete(dvDTO);

    }

    public void timkiemdichvu(String tendv, DefaultTableModel tb) throws SQLException {

        List<dichvuDTO> dichvuList = dv.searchDichVu(tendv);
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        dichvuList.forEach((dichvu) -> {
            tb.addRow(dichvu.to_array());
            System.out.println(Arrays.toString(dichvu.to_array()));
        });

    }

    public boolean themdichvu(dichvuDTO dvDTO) throws SQLException {
        return dv.insert(dvDTO);
    }
}
