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
import quanlykhachsan.DTO.phongDTO;

/**
 *
 * @author Duy Minh
 */
public class datphongModify {

    ConnectDataBase c;

    public datphongModify() throws SQLException {
        c = new ConnectDataBase();
    }

    public List<datphongDTO> findAll() throws SQLException {

        List<datphongDTO> datphongList = new ArrayList<>();

        String sql = "select madp, maphong , to_char(ngaythue,'dd-MM-yyyy') , to_char(ngaydi,'dd-MM-yyyy') from phieudatphong where trangthai = 0  ";

        ResultSet result = c.executeQuery(sql);
        while (result.next()) {
            datphongDTO dp;
            dp = new datphongDTO(result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4)
            );

            datphongList.add(dp);
        }

        return datphongList;
    }

    public boolean insert(datphongDTO dp) throws SQLException {

        String sql;
        sql = " { call qlsv.I_PDP(?,to_date(?,'dd-MM-yyyy'),to_date(?,'dd-MM-yyyy'),?,to_date(?,'dd-MM-yyyy '),?,?,?,?,?,?,?) } ";
        System.out.println(sql);

        String[] arr = {dp.getMaphong(), dp.getNgaydat(), dp.getNgaynhan(), dp.getHtkh(), dp.getNgaysinh(), dp.getGioitinh(), dp.getSodt(), dp.getCmnd(), dp.getDiachi(), dp.getLoaikhach(),dp.getSokhach(), dp.getManv()};
        int r = c.callProcedure(sql, arr);
        return r > 0;
    }

    public boolean delete(String madp) throws SQLException {

        String sql = "delete from phieudatphong where madp = '" + madp + "'";
        int r = c.executeUpdate(sql);
        return r > 0;
    }

    public ArrayList<datphongDTO> searchcoderoom(String coderoom) throws SQLException {
        ArrayList<datphongDTO> dpDTO = new ArrayList<>();
        String sql = "select madp, maphong , to_char(ngaythue,'dd-MM-yyyy') , to_char(ngaydi,'dd-MM-yyyy') from phieudatphong  where maphong like '% " + coderoom + "%'";
        ResultSet r = c.executeQuery(sql);
        if (r.next()) {
            datphongDTO temp;
            temp = new datphongDTO(r.getString(1), r.getString(2), r.getString(3), r.getString(4));
            dpDTO.add(temp);
        }
        return dpDTO;
    }

    public List<phongDTO> showRoomAva(String typeroom, String checkin, String checkout) throws SQLException {

        List<phongDTO> phongList = new ArrayList<>();
        String sql = "select  p.maphong sp, lp.tenloaiphong, lp.gia \n"
                + "from    phong p join loaiphong lp on p.maloaiphong = lp.maloaiphong \n"
                + "where   lp.tenloaiphong = '" + typeroom + "' and p.maphong \n"
                + "        not in  (select  distinct pt.maphong\n"
                + "                from    phieudatphong pt\n"
                + "                where   trangthai = 0 and \n"
                + "                        ((to_date('" + checkin + "','dd-MM-yyyy') between pt.ngaythue and pt.ngaydi)\n"
                + "                        or (to_date('" + checkout + "','dd-MM-yyyy') between pt.ngaythue and pt.ngaydi)\n"
                + "                        or (pt.ngaythue between to_date('" + checkin + "','dd-MM-yyyy') and to_date('" + checkout + "','dd-MM-yyyy'))\n"
                + "                        or (pt.ngaydi between to_date('" + checkin + "','dd-MM-yyyy') and to_date('" + checkout + "','dd-MM-yyyy'))))\n"
                + "order by sp";
        ResultSet r = c.executeQuery(sql);
        while (r.next()) {
            phongDTO temp;
            temp = new phongDTO(r.getString(1), r.getString(2), r.getString(3));
            phongList.add(temp);
        }
        return phongList;

    }

    public datphongDTO showCusroom(String madp) throws SQLException {
        String sql = "select * from khachhang where makh in (select makh from phieudatphong where madp = '" + madp + "')";
        ResultSet r = c.executeQuery(sql);
        if (r.next()) {
            datphongDTO temp;
            temp = new datphongDTO(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getString(6), r.getString(7), r.getString(8));

            return temp;
        }
        return null;
    }

}
