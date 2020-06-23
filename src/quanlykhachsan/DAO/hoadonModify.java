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
import quanlykhachsan.DTO.hoadondichvuDTO;
import quanlykhachsan.DTO.hoadonphongDTO;

/**
 *
 * @author Duy Minh
 */
public class hoadonModify {
    ConnectDataBase c; 
    public hoadonModify() throws SQLException{
        c = new ConnectDataBase();
    }
    public List<hoadonphongDTO> showbillroom(String maphong) throws SQLException {
          List<hoadonphongDTO> hoadonphongList = new ArrayList<>();

        String sql = "select * from HD where maphong = '"+maphong+"'";

        ResultSet result = c.executeQuery(sql);
        while (result.next()) {
            hoadonphongDTO dp;
            dp = new hoadonphongDTO(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)                   
            );

            hoadonphongList.add(dp);
        }

        return hoadonphongList;
        
    }
     public List<hoadonphongDTO> findAll() throws SQLException {

        List<hoadonphongDTO> hdphongList = new ArrayList<>();

        String sql = "select phong.maphong ,loaiphong. tenloaiphong \n" +
"from phong left join loaiphong on phong.maloaiphong = loaiphong.maloaiphong";

        ResultSet result = c.executeQuery(sql);
        while (result.next()) {
            hoadonphongDTO hd;
            hd = new hoadonphongDTO(result.getString(1),
                    result.getString(2)
            );

          hdphongList.add(hd);
        }

        return hdphongList;
    }
     
     public List<hoadondichvuDTO> findhddv(String maphong) throws SQLException {

        List<hoadondichvuDTO> hddichvuList = new ArrayList<>();

        String sql = "select * from SDDV where maphong  = '"+maphong+"'";

        ResultSet result = c.executeQuery(sql);
        while (result.next()) {
            hoadondichvuDTO hd;
            hd = new hoadondichvuDTO(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
                    
            );

          hddichvuList.add(hd);
        }

        return hddichvuList;
    }
    public boolean insertBill(String maphong) throws SQLException 
    {
        String str = "call qlsv.TienHD(?)";
        String[] arr = {maphong};
        int r = c.callProcedure(str, arr);
        return r > 0;
    
    }
}
