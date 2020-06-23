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
import quanlykhachsan.DTO.dichvuDTO;

/**
 *
 * @author Duy Minh
 */
public class dichvuModify {

    ConnectDataBase c;

    public dichvuModify() throws SQLException {
        c = new ConnectDataBase();
    }

    public List<dichvuDTO> findAll() throws SQLException {

        List<dichvuDTO> dichvuList = new ArrayList<>();

        String sql = "select * from dichvu";

        ResultSet result = c.executeQuery(sql);
        while (result.next()) {
            dichvuDTO dv;
            dv = new dichvuDTO(result.getString("madv"),
                    result.getString("tendv"),
                    result.getString("dvt"),
                    result.getString("gia")
                  
            );

            dichvuList.add(dv);
        }

        return dichvuList;
    }

    public boolean insert(dichvuDTO dv) throws SQLException {

        String sql = "insert into dichvu(madv,tendv,dvt,gia) values (?,?,?,?)";
        String[] arr = {dv.getMadv(), dv.getTendv(), dv.getDvt(), dv.getGia()};
        int r = c.executeUpdate(sql, arr);
        return r > 0;
    }

    public boolean update(dichvuDTO dv) throws SQLException {

        String sql = "update dichvu set tendv = ?, dvt = ?,gia = ? where madv = ?";
        String[] arr = {dv.getTendv(), dv.getDvt(), dv.getGia(), dv.getMadv()};
        int r = c.executeUpdate(sql, arr);
        return r > 0;

    }

    public boolean delete(dichvuDTO dv) throws SQLException {

        String sql = "delete from dichvu where madv = '" + dv.getMadv() + "'";
        int r = c.executeUpdate(sql);
        return r > 0;

    }

    public ArrayList<dichvuDTO> searchDichVu(String tendv) throws SQLException {
        ArrayList<dichvuDTO> dvDTO = new ArrayList<>();
        String sql = "select * from dichvu where tendv like '%" + tendv + "%'";
        ResultSet r = c.executeQuery(sql);
        while (r.next()) {
            dichvuDTO temp;
            temp = new dichvuDTO(r.getString(1), r.getString(2), r.getString(3), r.getString(4));
            dvDTO.add(temp);
        }
        return dvDTO;

    }
}
