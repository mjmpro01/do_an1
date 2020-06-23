/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.BUS;

import java.sql.SQLException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import quanlykhachsan.DAO.phieudatdvModify;
import quanlykhachsan.DTO.datphongDTO;
import quanlykhachsan.DTO.phieudatdvDTO;

/**
 *
 * @author Duy Minh
 */
public class phieudatdvBUS {

    phieudatdvModify dv;

    public phieudatdvBUS() throws SQLException {
        dv = new phieudatdvModify();
    }

    public boolean themdichvu(phieudatdvDTO dvDTO) throws SQLException {
        return dv.insertpdv(dvDTO);
    }

    public void showsddv(DefaultTableModel tb) throws SQLException {

        List<phieudatdvDTO> sddvList = dv.showSDDV();
//        DefaultTableModel tb = new DefaultTableModel();
        tb.setRowCount(0);
        sddvList.forEach((sudungdichvu) -> {
            tb.addRow(sudungdichvu.to_array());
           
        });
    }
    public boolean xoaphieudv(phieudatdvDTO pdvDTO) throws SQLException 
    {
        return dv.delete(pdvDTO);   
    }
}
