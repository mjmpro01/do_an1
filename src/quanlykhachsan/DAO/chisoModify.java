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
import quanlykhachsan.DTO.chisoDTO;

/**
 *
 * @author Duy Minh
 */
public class chisoModify {
    ConnectDataBase c;
    
    public chisoModify() throws SQLException{
        c= new ConnectDataBase();
    }
     public List<chisoDTO> findAll() throws SQLException {

        List<chisoDTO> chisoList = new ArrayList<>();

        String sql = "select * from loaikhach";

        ResultSet result = c.executeQuery(sql);
        while (result.next()) {
            chisoDTO cs;
            cs = new chisoDTO(result.getString(1),
                    result.getString(2));
            chisoList.add(cs);
        }

        return chisoList;
    }

    public boolean insert(chisoDTO cs) throws SQLException {

        String sql = "insert into loaikhach values (?,?) ";
        String[] arr = {cs.getTenchiso(),cs.getChiso()};
        int r = c.executeUpdate(sql, arr);
        return r > 0;
    }

    public boolean update(chisoDTO cs) throws SQLException {

        String sql = "update loaikhach set chiso = ? where tenloaikhach like '%"+cs.getTenchiso()+"%' ";
        String[] arr = {cs.getChiso()};
        int r = c.executeUpdate(sql,arr);
        return r > 0;

    }

    public boolean delete(chisoDTO cs) throws SQLException {

        String sql = "delete from loaikhach where tenloaikhach like '%"+cs.getTenchiso()+"%'";  
        int r = c.executeUpdate(sql);
        return r>0;
    } 
}
