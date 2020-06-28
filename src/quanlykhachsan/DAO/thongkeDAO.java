/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import quanlykhachsan.DTO.hoadonDTO;

/**
 *
 * @author Duy Minh
 */
public class thongkeDAO {

    ConnectDataBase c;

    public thongkeDAO() throws SQLException {
        c = new ConnectDataBase();
    }

    public ArrayList<hoadonDTO> searchhoadon(String thang1, String nam1) throws SQLException, JRException {
//        c.autoCommitFalse();
        // bắt đầu Transaction 1
        ArrayList<hoadonDTO> hdDTO = new ArrayList<>();
        String sql = "SELECT SS.TENLOAIPHONG, S.MAPHONG, S.TONG\n"
                + "    FROM\n"
                + "        (SELECT DP.MAPHONG, SUM(HD.TONGHOADON) TONG\n"
                + "        FROM PHIEUDATPHONG DP JOIN HOADON HD ON DP.MADP = HD.MADP\n"
                + "        WHERE extract(month from ngayhd) = '"+thang1+"' and extract (year from ngayhd) = '"+nam1+"'\n"
                + "        GROUP BY MAPHONG) S\n"
                + "    LEFT JOIN\n"
                + "        (SELECT PH.MAPHONG, LP.TENLOAIPHONG\n"
                + "        FROM PHONG PH JOIN LOAIPHONG LP ON LP.MALOAIPHONG = PH.MALOAIPHONG) SS\n"
                + "    ON SS.MAPHONG = S.MAPHONG\n"
                + "    ORDER BY TENLOAIPHONG, MAPHONG";
        //c.setTransactionIsolation1();
        c.setTransactionIsolation2();
        ResultSet r = c.executeQuery(sql);
        while (r.next()) {
            hoadonDTO temp;
            temp = new hoadonDTO(r.getString(1), r.getString(2), r.getString(3));
            hdDTO.add(temp);
        }
        return hdDTO;

    }
}
