/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import quanlykhachsan.DTO.taikhoanDTO;

/**
 *
 * @author Duy Minh
 */
public class taikhoanModify {

    ConnectDataBase c;

    public taikhoanModify() throws SQLException {
        c = new ConnectDataBase();
    }

    public taikhoanDTO login(taikhoanDTO tk) throws SQLException {
       
        String sql = "select b.manv,b.matkhau,a.tenpq from PHANQUYEN A JOIN TAIKHOAN B ON A.MAPQ = B.MAPQ where B.MANV = '" + tk.getManv() + "' and B.MATKHAU =  '" + tk.getMatkhau() + "'";

        ResultSet r = c.executeQuery(sql);
        if (r.next()) {
            taikhoanDTO temp;
            temp = new taikhoanDTO(r.getString(1), r.getString(2));
            return temp;

        }
        return null;

    }
    public taikhoanDTO checkPQ(String manv ) throws SQLException {
        String sql = "select a.tenpq from PHANQUYEN A JOIN TAIKHOAN B ON A.MAPQ = B.MAPQ where B.MANV = '" + manv + "'";
        ResultSet r = c.executeQuery(sql);
        if (r.next()) {
            taikhoanDTO temp;
            temp = new taikhoanDTO(r.getString(1));
            return temp;

        }
        return null;
    }
}
