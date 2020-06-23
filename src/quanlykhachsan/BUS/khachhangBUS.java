/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.BUS;

import java.sql.SQLException;
import quanlykhachsan.DAO.khachhangModify;
import quanlykhachsan.DTO.khachhangDTO;

/**
 *
 * @author Duy Minh
 */
public class khachhangBUS {
    khachhangModify kh ;
    public khachhangBUS() throws SQLException {
        kh = new khachhangModify();
    }
    public boolean themkhachhang(khachhangDTO khDTO) throws SQLException {
        return kh.insert(khDTO);
    }
}
