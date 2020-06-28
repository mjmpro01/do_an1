/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import quanlykhachsan.DTO.giaphongDTO;
import quanlykhachsan.DTO.phieudatdvDTO;

/**
 *
 * @author Duy Minh
 */
public class giaphongModify {
    ConnectDataBase c;
    public giaphongModify() throws SQLException{
        c = new ConnectDataBase();
    }
   public ArrayList<giaphongDTO> showoomRates() throws SQLException, SQLException{
       ArrayList<giaphongDTO> gpDTO = new ArrayList<>();
       String sql = "select * from loaiphong";
       ResultSet r = c.executeQuery(sql);
        while (r.next()) {
            giaphongDTO temp;
            temp = new giaphongDTO(r.getString(1),r.getString(2),r.getString(3));
            gpDTO.add(temp);
        }
        return gpDTO;
   
   }  
    public boolean insert(giaphongDTO gp) throws SQLException {

        String sql = "insert into loaiphong(maloaiphong,tenloaiphong,gia) values (?,?,?)";
        String[] arr = {gp.getMaloaiphong(),gp.getLoaiphong(),gp.getGia()};
        int r = c.executeUpdate(sql, arr);
        return r > 0;
    }
     public boolean delete(giaphongDTO gp) throws SQLException {

        String sql = "delete from loaiphong where maloaiphong = '" + gp.getMaloaiphong() + "'";
        int r = c.executeUpdate(sql);
        return r > 0;
    }
     
    public boolean update(giaphongDTO gp) throws SQLException {

        String sql = "update loaiphong set tenloaiphong = ?, gia = ? where maloaiphong = '"+gp.getMaloaiphong()+"' ";
        String[] arr = {gp.getLoaiphong(),gp.getGia()};
        int r = c.executeUpdate(sql,arr);
        return r > 0;

    }
}
