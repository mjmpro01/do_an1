/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.DAO;

import quanlykhachsan.DTO.nhanvienDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author Duy Minh
 */
public class NhanvienModify {

    ConnectDataBase c;

    public NhanvienModify() throws SQLException {
        c = new ConnectDataBase();
    }

    public List<nhanvienDTO> findAll() throws SQLException {

        List<nhanvienDTO> nhanvienList = new ArrayList<>();

        String sql = "select * from nhanvien";

        ResultSet result = c.executeQuery(sql);
        while (result.next()) {
            nhanvienDTO nv;
            nv = new nhanvienDTO(result.getString("manv"),
                    result.getString("hotennv"),
                    result.getString("gioitinh"),
                    result.getString("sodt"),
                    result.getString("diachi"),
                    result.getString("cmnd"),
                    result.getString("chucvu"));
            nhanvienList.add(nv);
        }

        return nhanvienList;
    }

    public boolean insert(nhanvienDTO nv) throws SQLException {

        String sql = " { call qlsv.NV_TK(?,?,?,?,?,?,?) } ";
        String[] arr = {nv.getManv(), nv.getHotennv(), nv.getGioitinh(), nv.getSodt(), nv.getDiachi(),nv.getCmnd(), nv.getChucvu()};
        int r = c.callProcedure(sql, arr);
        return r > 0;
    }

    public boolean update(nhanvienDTO nv) throws SQLException {

        String sql = "update nhanvien set hotennv = ?,gioitinh = ?,sodt = ?,diachi = ?,cmnd = ?,chucvu = ? where manv = ?";
        String[] arr = {nv.getHotennv(), nv.getGioitinh(), nv.getSodt(), nv.getDiachi(), nv.getCmnd(), nv.getChucvu(), nv.getManv()};
        int r = c.executeUpdate(sql, arr);
        return r > 0;

    }

    public boolean delete(nhanvienDTO nv) throws SQLException {

        String sql = "call qlsv.D_NV(?)";  
        String[] arr = { nv.getManv() };
        int r = c.callProcedure(sql,arr);
        return r > 0;
        

    }

    public ArrayList<nhanvienDTO> searchFullName(String fullname) throws SQLException {
        ArrayList<nhanvienDTO> nvDTO = new ArrayList<>();
        String sql = "select * from nhanvien where hotennv like '%" + fullname + "%'";
        ResultSet r = c.executeQuery(sql);
        while (r.next()) {
            nhanvienDTO temp;
            temp = new nhanvienDTO(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6), r.getString(7));
            nvDTO.add(temp);
        }
        return nvDTO;

    }
}
