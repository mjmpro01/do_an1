/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import quanlykhachsan.DTO.datphongDTO;
import quanlykhachsan.DTO.thuephongDTO;

/**
 *
 * @author Duy Minh
 */
public class thuephongModify {
      ConnectDataBase c;
    public thuephongModify() throws SQLException {
        c = new ConnectDataBase();
    }
      public boolean insertrentroom(thuephongDTO tp) throws SQLException {

        String sql;
        sql = " { call QLKS_2.I_PTP(?,to_date(?,'dd-MM-yyyy'),to_date(?,'dd-MM-yyyy'),?,?,?,to_date(?,'dd-MM-yyyy '),?,?,?,?) } ";   
        String[] arr = {tp.getMaphong(),tp.getNgaythue(),tp.getNgaydi(),tp.getManv(),tp.getHtkh(), tp.getGioitinh(), tp.getNgaysinh(), tp.getSodt(), tp.getCmnd(), tp.getLoaikhach(), tp.getDiachi()};
        int r = c.callProcedure(sql, arr);
        return r > 0;
    }
       public List<thuephongDTO> findrentroom(String coderoom) throws SQLException {

        List<thuephongDTO> thuephongList = new ArrayList<>();

        String sql = "select a.maptp, b.maphong , to_char(a.ngaythue,'dd-MM-yyyy') , to_char(b.ngaydi,'dd-MM-yyyy') from phieuthuephong a, cttp b where b.maptp = a.maptp and b.maphong like '%" + coderoom + "%'";

        ResultSet result = c.executeQuery(sql);
        while (result.next()) {
            thuephongDTO tp;
            tp = new thuephongDTO(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );

          thuephongList.add(tp);
        }

        return thuephongList;
    }
      
}
