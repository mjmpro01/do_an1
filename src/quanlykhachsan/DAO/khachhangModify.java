/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.DAO;

import java.sql.SQLException;
import quanlykhachsan.DTO.khachhangDTO;

/**
 *
 * @author Duy Minh
 */
public class khachhangModify {

    ConnectDataBase c;

    public khachhangModify() throws SQLException {
        c = new ConnectDataBase();
    }

    public boolean insert(khachhangDTO kh) throws SQLException {

        String sql;
        sql = " { call QLKS.I_KH(?,?,to_date(?,'dd-MM-yyyy'),?,?,?,?,?) } ";
        String[] arr = {kh.getHtkh(), kh.getGioitinh(), kh.getNgaysinh(), kh.getSodt(), kh.getCmnd(), kh.getLoaikhach(), kh.getDiachi(),kh.getSokhach()};
        int r = c.callProcedure(sql, arr);
        return r > 0;
    }
}
