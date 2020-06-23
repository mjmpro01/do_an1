/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.BUS;

import java.sql.SQLException;
import java.util.ArrayList;
import quanlykhachsan.DAO.taikhoanModify;
import quanlykhachsan.DTO.taikhoanDTO;

/**
 *
 * @author Duy Minh
 */
public class taikhoanBUS {

    taikhoanModify tk;
    public taikhoanBUS() throws SQLException{
        tk = new taikhoanModify();
    }
    public boolean dangnhap(taikhoanDTO tkDTO) throws SQLException {
        
        return tk.login(tkDTO) != null;

    }
     public taikhoanDTO kiemtraphanquyen(String manv) throws SQLException {
        
        return tk.checkPQ(manv);

    }
}
