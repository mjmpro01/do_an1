/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Duy Minh
 */
public class iReportDAO {
    ConnectDataBase c;
    public iReportDAO() throws SQLException{
        c = new ConnectDataBase(); 
    }
    public void baobieuphong() throws JRException{
       
        String dir = "C:\\\\Users\\\\Duy Minh\\\\Desktop\\\\do_an-master\\\\src\\\\iReport\\\\baobieuphong.jrxml";
        JasperDesign jd = JRXmlLoader.load(dir);
        JasperReport jr = JasperCompileManager.compileReport(dir);
        JasperPrint jp;
        jp = JasperFillManager.fillReport(jr, new HashMap<>(), c.getConnection());
        JasperViewer jv;
        jv = new JasperViewer(jp, false);
        jv.setVisible(true);
    }
    public void hoadon(String maphong1) throws JRException{
        
        
        String maphong = maphong1;
        HashMap hasmap = new HashMap();
        hasmap.put("maphong", maphong);
        
        String dir = "C:\\\\Users\\\\Duy Minh\\\\Desktop\\\\do_an-master\\\\src\\\\iReport\\\\hoadon3.jrxml";
        JasperDesign jd = JRXmlLoader.load(dir);
        JasperReport jr = JasperCompileManager.compileReport(dir);
        JasperPrint jp;
        jp = JasperFillManager.fillReport(jr, hasmap, c.getConnection());
        JasperViewer jv;
        jv = new JasperViewer(jp, false);
        jv.setVisible(true);
    }
     public void baobieunhanvien() throws JRException{
       
        String dir = "C:\\\\Users\\\\Duy Minh\\\\Desktop\\\\do_an-master\\\\src\\\\iReport\\\\danhsachnhanvien.jrxml";
        JasperDesign jd = JRXmlLoader.load(dir);
        JasperReport jr = JasperCompileManager.compileReport(dir);
        JasperPrint jp;
        jp = JasperFillManager.fillReport(jr, new HashMap<>(), c.getConnection());
        JasperViewer jv;
        jv = new JasperViewer(jp, false);
        jv.setVisible(true);
    }
      public void doanhso(String thang1, String nam1) throws JRException{
        
        
        int thang = Integer.valueOf(thang1);
        int nam = Integer.valueOf(nam1);
        HashMap hasmap = new HashMap();
        hasmap.put("thang", thang);
        hasmap.put("nam", nam);
        
        String dir = "C:\\\\Users\\\\Duy Minh\\\\Desktop\\\\do_an-master\\\\src\\\\iReport\\\\doanhthu1.jrxml";
        JasperDesign jd = JRXmlLoader.load(dir);
        JasperReport jr = JasperCompileManager.compileReport(dir);
        JasperPrint jp;
        jp = JasperFillManager.fillReport(jr, hasmap, c.getConnection());
        JasperViewer jv;
        jv = new JasperViewer(jp, false);
        jv.setVisible(true);
    }
}

