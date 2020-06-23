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
import quanlykhachsan.DAO.chisoModify;
import quanlykhachsan.DTO.chisoDTO;

/**
 *
 * @author Duy Minh
 */
public class chisoBUS {
     chisoModify cs;

    public chisoBUS() throws SQLException {
        cs = new chisoModify();
    }

    public void showchiso(DefaultTableModel tb) throws SQLException {

        List<chisoDTO> chisoList = cs.findAll();
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        chisoList.forEach((chiso) -> {
            tb.addRow(chiso.to_array1());
            System.out.println(Arrays.toString(chiso.to_array1()));
        });
    }

    public boolean themchiso(chisoDTO csDTO) throws SQLException {
        return cs.insert(csDTO);
    }

    public boolean xoachiso(chisoDTO csDTO) throws SQLException {
        return cs.delete(csDTO);
    }
     public boolean suachiso(chisoDTO csDTO) throws SQLException {
        return cs.update(csDTO);
    }
}
