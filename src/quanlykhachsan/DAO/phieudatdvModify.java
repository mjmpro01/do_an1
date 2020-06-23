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
import quanlykhachsan.DTO.phieudatdvDTO;
/**
 *
 * @author Duy Minh
 */
public class phieudatdvModify {
    ConnectDataBase c;

    public phieudatdvModify() throws SQLException {
        c = new ConnectDataBase();
    }
    public boolean insertpdv(phieudatdvDTO dv) throws SQLException{
        String sql = "call qlsv.I_SDDV(?,?,?,?)";
        String[] arr = {dv.getMaphong(),dv.getTendv(),dv.getGia(),dv.getSoluong()};
        int r = c.callProcedure(sql, arr);
        return r > 0;
    }
  
     public ArrayList<phieudatdvDTO> showSDDV() throws SQLException {
        ArrayList<phieudatdvDTO> sddvDTO = new ArrayList<>();
        String sql = "select b.masddv, a.maphong, c.tendv,to_date(b.ngaysd,'dd-MM-yyyy'), b.thanhtien from datphong a, sudungdichvu b, dichvu c  where b.madp = a.madp and b.madv = c.madv";
        ResultSet r = c.executeQuery(sql);
        while (r.next()) {
            phieudatdvDTO temp;
            temp = new phieudatdvDTO(r.getString(2), r.getString(3), r.getString(5), r.getString(4), r.getString(1));
            sddvDTO.add(temp);
        }
        return sddvDTO;

    }
      public boolean delete(phieudatdvDTO pdv) throws SQLException {

        String sql = "delete from sudungdichvu where masddv = '" + pdv.getMasddv() + "'";
        int r = c.executeUpdate(sql);
        return r > 0;
    }
}
