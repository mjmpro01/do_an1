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
import quanlykhachsan.DTO.phongDTO;

/**
 *
 * @author Duy Minh
 */
public class phongModify {

    ConnectDataBase c;

    public phongModify() throws SQLException {
        c = new ConnectDataBase();
    }

    public List<phongDTO> findAll() throws SQLException {

        List<phongDTO> phongList = new ArrayList<>();

        String sql = "select a.maphong,b.tenloaiphong, b.gia from phong a, loaiphong b where a.maloaiphong = b.maloaiphong ";

        ResultSet result = c.executeQuery(sql);
        while (result.next()) {
            phongDTO p;
            p = new phongDTO(result.getString(1),
                    result.getString(2),
                    result.getString(3)
                
            );

            phongList.add(p);
        }

        return phongList;
    }

    public boolean insert(phongDTO p) throws SQLException {

        String sql = " { call qlsv.I_ROOM(?,?) } ";
        String[] arr = {p.getMaphong(), p.getLoaiphong()};
        int r = c.callProcedure(sql, arr);
        return r > 0;
    }

    public boolean update(phongDTO p) throws SQLException {

        String sql = "call qlsv.U_ROOM(?,?)";
        String[] arr = {p.getMaphong(), p.getLoaiphong()};
        int r = c.callProcedure(sql, arr);
        return r > 0;

    }

    public boolean delete(phongDTO p) throws SQLException {

        String sql = "delete phong where maphong = '" + p.getMaphong() + "'";
        int r = c.executeUpdate(sql);
        return r > 0;

    }

    public ArrayList<phongDTO> searchloaiphong(String loaiphong) throws SQLException {
        ArrayList<phongDTO> pDTO = new ArrayList<>();
        String sql = "select a.maphong,b.tenloaiphong, b.gia from phong a, loaiphong b where a.maloaiphong = b.maloaiphong and b.tenloaiphong like '%" + loaiphong + "%'";
        ResultSet r = c.executeQuery(sql);
        while (r.next()) {
            phongDTO temp;
            temp = new phongDTO(r.getString(1), r.getString(2), r.getString(3));
            pDTO.add(temp);
        }
        return pDTO;

    }

    public List<phongDTO> findEmptyRoom() throws SQLException {

        List<phongDTO> phongList = new ArrayList<>();

        String sql = "select a.maphong,b.tenloaiphong, b.dongia from phong a, loaiphong b where a.maloaiphong = b.maloaiphong and a.matinhtrang = c.matinhtrang and c.tentinhtrang = 'Empty'";

        ResultSet result = c.executeQuery(sql);
        while (result.next()) {
            phongDTO p;
            p = new phongDTO(result.getString(1),
                    result.getString(3),
                    result.getString(2)
            );

            phongList.add(p);
        }

        return phongList;
    }

    public ArrayList<phongDTO> searchphongtrong(String loaiphong) throws SQLException {
        ArrayList<phongDTO> pDTO = new ArrayList<>();
        String sql = "select a.maphong,b.tenloaiphong, b.dongia from phong a, loaiphong b, tinhtrang c where a.maloaiphong = b.maloaiphong and a.matinhtrang = c.matinhtrang and b.tenloaiphong like '%" + loaiphong + "%'";
        ResultSet r = c.executeQuery(sql);
        while (r.next()) {
            phongDTO temp;
            temp = new phongDTO(r.getString(1), r.getString(2), r.getString(3));
            pDTO.add(temp);
        }
        return pDTO;

    }

    public List<phongDTO> findEmptyBookingRoom() throws SQLException {

        List<phongDTO> phongList = new ArrayList<>();

        String sql = "select a.maphong,b.tenloaiphong, b.dongia,c.tentinhtrang \n"
                + "from phong a, loaiphong b, tinhtrang c \n"
                + "where a.maloaiphong = b.maloaiphong and a.matinhtrang = c.matinhtrang and c.matinhtrang not in( select matinhtrang  from tinhtrang where matinhtrang = 'TT001' )";

        ResultSet result = c.executeQuery(sql);
        while (result.next()) {
            phongDTO p;
            p = new phongDTO(
                  result.getString(1),
                  result.getString(2),
                  result.getString(3)
               
            );

            phongList.add(p);
        }

        return phongList;
    }

    public ArrayList<phongDTO> searchtyperoomandstatus(String loaiphong,String tinhtrang) throws SQLException {
       
        ArrayList<phongDTO> pDTO = new ArrayList<>();
        String sql = "select a.maphong,b.tenloaiphong, b.dongia,c.tentinhtrang from phong a, loaiphong b, tinhtrang c where a.maloaiphong = b.maloaiphong and a.matinhtrang = c.matinhtrang and c.tentinhtrang = '" + tinhtrang + "'  and  b.tenloaiphong = '" + loaiphong + "'";
        ResultSet r = c.executeQuery(sql);
        while (r.next()) {
            phongDTO temp;
            temp = new phongDTO(r.getString(1), r.getString(2), r.getString(3));
            pDTO.add(temp);
        }
        return pDTO;
    }
}
