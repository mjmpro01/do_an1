/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.GUI;

import com.formdev.flatlaf.FlatLightLaf;
import quanlykhachsan.DTO.nhanvienDTO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import quanlykhachsan.BUS.chisoBUS;
import quanlykhachsan.BUS.dichvuBUS;
import quanlykhachsan.BUS.giaphongBUS;
import quanlykhachsan.BUS.nhanvienBUS;
import quanlykhachsan.BUS.phongBUS;
import quanlykhachsan.DAO.ConnectDataBase;
import quanlykhachsan.DTO.chisoDTO;
import quanlykhachsan.DTO.dichvuDTO;
import quanlykhachsan.DTO.giaphongDTO;
import quanlykhachsan.DTO.phongDTO;

/**
 *
 * @author Duy Minh
 */
public final class GiamdocGUI extends javax.swing.JFrame {

    CardLayout cl;
    ConnectDataBase c;

    public GiamdocGUI() throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        cl = (CardLayout) (jPanel3.getLayout());
        cl.show(jPanel3, "card1");
        autoID();
        load_table_nv();

    }

    public void load_table_nv() throws SQLException {

        nhanvienBUS nvBUS = new nhanvienBUS();
        nvBUS.shownhanvien((DefaultTableModel) tblnhanvien.getModel());

    }

    public void load_table_phong() throws SQLException {

        phongBUS pBUS = new phongBUS();
        pBUS.showphong((DefaultTableModel) tblroom.getModel());

    }

    public void load_table_dichvu() throws SQLException {

        dichvuBUS dvBUS = new dichvuBUS();
        dvBUS.showdichvu((DefaultTableModel) tbldichvu.getModel());

    }

    public void load_table_chiso() throws SQLException {

        chisoBUS csBUS = new chisoBUS();
        csBUS.showchiso((DefaultTableModel) tblchiso.getModel());

    }

    public void load_table_giaphong() throws SQLException {

        giaphongBUS gpBUS = new giaphongBUS();
        gpBUS.showloaiphong((DefaultTableModel) tblgiaphong.getModel());

    }
    public void load_table_chucvu_luong() throws SQLException {

        nhanvienBUS nvBUS = new nhanvienBUS();
        nvBUS.showchucvu_luong((DefaultTableModel) tblchucvu_luong.getModel());

    }
    public void autoID() throws SQLException {
        c = new ConnectDataBase();

        String sql = "select max(manv) from nhanvien";

        ResultSet rs = c.executeQuery(sql);
        rs.next();
        rs.getString("max(manv)");
        if (rs.getString("max(manv)") == null) {
            manv1.setText("NV001");
        } else {
            long id = Long.parseLong(rs.getString("max(manv)").substring(2, rs.getString("max(manv)").length()));
            id++;
            manv1.setText("NV" + String.format("%03d", id));
        }

    }

    public void autoID_dichvu() throws SQLException {
        c = new ConnectDataBase();

        String sql = "select max(madv) from dichvu";

        ResultSet rs = c.executeQuery(sql);
        rs.next();
        rs.getString("max(madv)");
        if (rs.getString("max(madv)") == null) {
            madichvu1.setText("DV001");
        } else {
            long id = Long.parseLong(rs.getString("max(madv)").substring(2, rs.getString("max(madv)").length()));
            id++;
            madichvu1.setText("DV" + String.format("%03d", id));
        }

    }

    public void autoID_room() throws SQLException {
        c = new ConnectDataBase();

        String sql = "select max(maphong) from phong";

        ResultSet rs = c.executeQuery(sql);
        rs.next();
        rs.getString("max(maphong)");
        if (rs.getString("max(maphong)") == null) {
            coderoom1.setText("R001");
        } else {
            long id = Long.parseLong(rs.getString("max(maphong)").substring(2, rs.getString("max(maphong)").length()));
            id++;
            coderoom1.setText("R" + String.format("%03d", id));
        }

    }

    public void autoID_loaiphong() throws SQLException {
        c = new ConnectDataBase();

        String sql = "select max(maloaiphong) from loaiphong";

        ResultSet rs = c.executeQuery(sql);
        rs.next();
        rs.getString("max(maloaiphong)");
        if (rs.getString("max(maloaiphong)") == null) {
            maloaiphong1.setText("LP01");
        } else {
            long id = Long.parseLong(rs.getString("max(maloaiphong)").substring(2, rs.getString("max(maloaiphong)").length()));
            id++;
            maloaiphong1.setText("LP" + String.format("%02d", id));
        }

    }
//    public void autoID_chiso() throws SQLException {
//        c = new ConnectDataBase();
//
//        String sql = "select max(machiso) from loaikhach";
//
//        ResultSet rs = c.executeQuery(sql);
//        rs.next();
//        rs.getString("max(machiso)");
//        if (rs.getString("max(machiso)") == null) {
//            machiso1.setText("CS001");
//        } else {
//            long id = Long.parseLong(rs.getString("max(machiso)").substring(2, rs.getString("max(machiso)").length()));
//            id++;
//            machiso1.setText("CS" + String.format("%03d", id));
//        }
//
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblnhanvien = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cmnd1 = new javax.swing.JTextField();
        phonenumber1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        gioitinh1 = new javax.swing.JComboBox<>();
        timkiemnv = new javax.swing.JLabel();
        fullname1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        chucvu2 = new javax.swing.JComboBox<>();
        timkiemText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        address1 = new javax.swing.JEditorPane();
        manv1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        addroom1 = new javax.swing.JLabel();
        deleteroom1 = new javax.swing.JLabel();
        updateroom1 = new javax.swing.JLabel();
        searchroom1 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblroom = new javax.swing.JTable();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        roomtype1 = new javax.swing.JComboBox<>();
        coderoom1 = new javax.swing.JLabel();
        timkiemText1 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        adddichvu = new javax.swing.JLabel();
        deletedichvu = new javax.swing.JLabel();
        updatedichvu = new javax.swing.JLabel();
        timkiemdichvu = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tbldichvu = new javax.swing.JTable();
        tendichvu1 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        timkiemtext1 = new javax.swing.JTextField();
        lamtrangdichvu = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        madichvu1 = new javax.swing.JLabel();
        donvitinh1 = new javax.swing.JComboBox<>();
        gia1 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        delete1 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblchiso = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        chiso1 = new javax.swing.JTextField();
        chiso2 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        delete2 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblgiaphong = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        loaiphong1 = new javax.swing.JTextField();
        gia2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        maloaiphong1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblchucvu_luong = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        luong4 = new javax.swing.JTextField();
        chucvu4 = new javax.swing.JComboBox<>();

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Fullname: ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 255, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(102, 0, 102));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/back_to_40px.png"))); // NOI18N
        jLabel6.setText("Back");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel6MouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Manager");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/employee_48px.png"))); // NOI18N
        jLabel2.setText("   Manage employee");
        jLabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 0, 51)));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/service_bell_40px.png"))); // NOI18N
        jLabel3.setText("        Manage service");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 0, 51)));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/key_48px.png"))); // NOI18N
        jLabel35.setText("        Manage room");
        jLabel35.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 0, 51)));
        jLabel35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel35MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel35MouseExited(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/adjust_64px.png"))); // NOI18N
        jLabel37.setText("           Adjust index");
        jLabel37.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 0, 51)));
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel37MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel37MouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/exit_100px.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/adjust_64px.png"))); // NOI18N
        jLabel40.setText("  Adjust room rates");
        jLabel40.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 0, 51)));
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel40MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel40MouseExited(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/adjust_64px.png"))); // NOI18N
        jLabel41.setText("Adjust emp's salary");
        jLabel41.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(51, 0, 51)));
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel41MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel41MouseExited(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jPanel3.setLayout(new java.awt.CardLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        jLabel15.setFont(new java.awt.Font("Rage Italic", 2, 36)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 153, 0));
        jLabel15.setText("Romance hotel ");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/add_new_64px.png"))); // NOI18N
        jLabel18.setText("Add");
        jLabel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });

        delete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/delete_bin_64px.png"))); // NOI18N
        delete.setText("Delete");
        delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/update_64px.png"))); // NOI18N
        jLabel21.setText("Update");
        jLabel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });

        tblnhanvien.setAutoCreateRowSorter(true);
        tblnhanvien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblnhanvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MaNV", "Fullname", "Gender", "Phone number", "Address", "CMND", "Officials", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblnhanvien.setAlignmentX(2.0F);
        tblnhanvien.setAlignmentY(2.0F);
        tblnhanvien.setDoubleBuffered(true);
        tblnhanvien.setDragEnabled(true);
        tblnhanvien.setFillsViewportHeight(true);
        tblnhanvien.setGridColor(new java.awt.Color(51, 0, 255));
        tblnhanvien.setInheritsPopupMenu(true);
        tblnhanvien.setName(""); // NOI18N
        tblnhanvien.setRowHeight(30);
        tblnhanvien.setSurrendersFocusOnKeystroke(true);
        tblnhanvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblnhanvienMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblnhanvien);
        tblnhanvien.getAccessibleContext().setAccessibleDescription("");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Fullname:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("CMND:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("Address: ");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setText("Phone number:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setText("Gender");

        cmnd1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmnd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmnd1ActionPerformed(evt);
            }
        });

        phonenumber1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phonenumber1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonenumber1ActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setText("Officials: ");

        gioitinh1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        gioitinh1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        gioitinh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gioitinh1ActionPerformed(evt);
            }
        });

        timkiemnv.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        timkiemnv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timkiemnv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/search_48px (2).png"))); // NOI18N
        timkiemnv.setText("Search fullname");
        timkiemnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timkiemnvMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                timkiemnvMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                timkiemnvMouseExited(evt);
            }
        });

        fullname1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        fullname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullname1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("MaNV:");

        chucvu2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        chucvu2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Receptionist", "Accountant" }));
        chucvu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chucvu2ActionPerformed(evt);
            }
        });

        timkiemText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        timkiemText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemTextActionPerformed(evt);
            }
        });
        timkiemText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                timkiemTextKeyPressed(evt);
            }
        });

        address1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(address1);

        manv1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        manv1.setText("jLabel4");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/broom_64px.png"))); // NOI18N
        jLabel26.setText("Clear");
        jLabel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel26MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel26MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel16)
                            .addComponent(jLabel7)
                            .addComponent(jLabel17)
                            .addComponent(jLabel24)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(chucvu2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cmnd1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(phonenumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(gioitinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fullname1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(55, 55, 55))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(manv1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(timkiemnv, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timkiemText, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 25, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(manv1))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                        .addComponent(fullname1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(gioitinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22)
                                    .addComponent(phonenumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(cmnd1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(0, 24, Short.MAX_VALUE)
                                        .addComponent(jLabel24))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(chucvu2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jScrollPane6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(timkiemnv, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(timkiemText, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(1, 1, 1)))
                            .addComponent(delete, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel26))))
                .addGap(26, 26, 26))
        );

        jPanel3.add(jPanel5, "card3");

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel36.setFont(new java.awt.Font("Rage Italic", 2, 36)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 153, 0));
        jLabel36.setText("Romance hotel ");

        jPanel15.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 71, Short.MAX_VALUE)
        );

        addroom1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        addroom1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addroom1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/add_new_64px.png"))); // NOI18N
        addroom1.setText("Add");
        addroom1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addroom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addroom1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addroom1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addroom1MouseExited(evt);
            }
        });

        deleteroom1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deleteroom1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteroom1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/delete_bin_64px.png"))); // NOI18N
        deleteroom1.setText("Delete");
        deleteroom1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteroom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteroom1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteroom1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteroom1MouseExited(evt);
            }
        });

        updateroom1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        updateroom1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateroom1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/update_64px.png"))); // NOI18N
        updateroom1.setText("Update");
        updateroom1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updateroom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateroom1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateroom1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateroom1MouseExited(evt);
            }
        });

        searchroom1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        searchroom1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        searchroom1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/search_48px (2).png"))); // NOI18N
        searchroom1.setText("Search room type");
        searchroom1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchroom1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchroom1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchroom1MouseExited(evt);
            }
        });

        tblroom.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblroom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Code room", "Room type", "Unit Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblroom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblroomMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblroom);

        jLabel51.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel51.setText("Code room:");

        jLabel52.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel52.setText("Room type:");

        roomtype1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        roomtype1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vip", "Luxury", "Afordable" }));
        roomtype1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomtype1ActionPerformed(evt);
            }
        });

        coderoom1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        coderoom1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        coderoom1.setText("jLabel4");

        timkiemText1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        timkiemText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemText1ActionPerformed(evt);
            }
        });
        timkiemText1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                timkiemText1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(addroom1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addComponent(deleteroom1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(updateroom1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(searchroom1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(timkiemText1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52))
                        .addGap(100, 100, 100)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(coderoom1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(roomtype1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel36)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51)
                            .addComponent(coderoom1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel52)
                            .addComponent(roomtype1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(deleteroom1)
                        .addComponent(updateroom1)
                        .addComponent(addroom1))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timkiemText1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchroom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(28, 28, 28))
        );

        jPanel3.add(jPanel14, "card4");

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel38.setFont(new java.awt.Font("Rage Italic", 2, 36)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 153, 0));
        jLabel38.setText("Romance hotel ");

        jPanel17.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 65, Short.MAX_VALUE)
        );

        adddichvu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        adddichvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adddichvu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/add_new_64px.png"))); // NOI18N
        adddichvu.setText("Add");
        adddichvu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        adddichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adddichvuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                adddichvuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                adddichvuMouseExited(evt);
            }
        });

        deletedichvu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deletedichvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deletedichvu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/delete_bin_64px.png"))); // NOI18N
        deletedichvu.setText("Delete");
        deletedichvu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deletedichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletedichvuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletedichvuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deletedichvuMouseExited(evt);
            }
        });

        updatedichvu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        updatedichvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updatedichvu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/update_64px.png"))); // NOI18N
        updatedichvu.setText("Update");
        updatedichvu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updatedichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatedichvuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updatedichvuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updatedichvuMouseExited(evt);
            }
        });

        timkiemdichvu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        timkiemdichvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timkiemdichvu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/search_48px (2).png"))); // NOI18N
        timkiemdichvu.setText("Search service name");
        timkiemdichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                timkiemdichvuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                timkiemdichvuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                timkiemdichvuMouseExited(evt);
            }
        });

        tbldichvu.setAutoCreateRowSorter(true);
        tbldichvu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tbldichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Service code", "Service name", "Unit of calculation", "Unit Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbldichvu.setDoubleBuffered(true);
        tbldichvu.setDragEnabled(true);
        tbldichvu.setFillsViewportHeight(true);
        tbldichvu.setFocusCycleRoot(true);
        tbldichvu.setFocusTraversalPolicyProvider(true);
        tbldichvu.setInheritsPopupMenu(true);
        tbldichvu.setRowHeight(30);
        tbldichvu.setRowMargin(3);
        tbldichvu.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tbldichvuAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tbldichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldichvuMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tbldichvu);

        tendichvu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tendichvu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tendichvu1ActionPerformed(evt);
            }
        });

        jLabel59.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel59.setText("Service name:");

        jLabel60.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel60.setText("Unit of calculation:");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel61.setText("Unit Price: ");

        timkiemtext1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        timkiemtext1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemtext1ActionPerformed(evt);
            }
        });
        timkiemtext1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                timkiemtext1KeyPressed(evt);
            }
        });

        lamtrangdichvu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lamtrangdichvu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lamtrangdichvu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/broom_64px.png"))); // NOI18N
        lamtrangdichvu.setText("Clear");
        lamtrangdichvu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lamtrangdichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lamtrangdichvuMouseClicked(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel64.setText("Service code:");

        madichvu1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        madichvu1.setText("jLabel4");

        donvitinh1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        donvitinh1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day", "Kg", "H" }));

        gia1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gia1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel38)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(adddichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(deletedichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(updatedichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(lamtrangdichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(timkiemdichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(timkiemtext1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61)
                            .addComponent(jLabel60)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(madichvu1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(donvitinh1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tendichvu1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(gia1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(madichvu1))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tendichvu1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(donvitinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gia1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updatedichvu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adddichvu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deletedichvu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lamtrangdichvu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timkiemtext1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(timkiemdichvu)))
                .addGap(28, 28, 28))
        );

        jPanel3.add(jPanel16, "card5");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        jLabel19.setFont(new java.awt.Font("Rage Italic", 2, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 153, 0));
        jLabel19.setText("Romance hotel ");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/add_new_64px.png"))); // NOI18N
        jLabel20.setText("Add");
        jLabel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
        });

        delete1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        delete1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/delete_bin_64px.png"))); // NOI18N
        delete1.setText("Delete");
        delete1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete1MouseExited(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/update_64px.png"))); // NOI18N
        jLabel27.setText("Update");
        jLabel27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });

        tblchiso.setAutoCreateRowSorter(true);
        tblchiso.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblchiso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Type customer", "Index"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblchiso.setAlignmentX(2.0F);
        tblchiso.setAlignmentY(2.0F);
        tblchiso.setDoubleBuffered(true);
        tblchiso.setDragEnabled(true);
        tblchiso.setFillsViewportHeight(true);
        tblchiso.setGridColor(new java.awt.Color(51, 0, 255));
        tblchiso.setInheritsPopupMenu(true);
        tblchiso.setName(""); // NOI18N
        tblchiso.setRowHeight(30);
        tblchiso.setSurrendersFocusOnKeystroke(true);
        tblchiso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblchisoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblchiso);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Index name:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/broom_64px.png"))); // NOI18N
        jLabel34.setText("Clear");
        jLabel34.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel34MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel34MouseExited(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Index:");

        chiso1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chiso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chiso1ActionPerformed(evt);
            }
        });

        chiso2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chiso2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chiso2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(679, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chiso1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chiso2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(chiso1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(chiso2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                        .addGap(35, 35, 35)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete1)
                    .addComponent(jLabel27)
                    .addComponent(jLabel20)
                    .addComponent(jLabel34))
                .addGap(32, 32, 32))
        );

        jPanel3.add(jPanel6, "card10");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        jLabel25.setFont(new java.awt.Font("Rage Italic", 2, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 153, 0));
        jLabel25.setText("Romance hotel ");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/add_new_64px.png"))); // NOI18N
        jLabel28.setText("Add");
        jLabel28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel28MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel28MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel28MouseExited(evt);
            }
        });

        delete2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        delete2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/delete_bin_64px.png"))); // NOI18N
        delete2.setText("Delete");
        delete2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delete2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete2MouseExited(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/update_64px.png"))); // NOI18N
        jLabel29.setText("Update");
        jLabel29.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel29MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel29MouseExited(evt);
            }
        });

        tblgiaphong.setAutoCreateRowSorter(true);
        tblgiaphong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblgiaphong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code type room", "Type room", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblgiaphong.setAlignmentX(2.0F);
        tblgiaphong.setAlignmentY(2.0F);
        tblgiaphong.setDoubleBuffered(true);
        tblgiaphong.setDragEnabled(true);
        tblgiaphong.setFillsViewportHeight(true);
        tblgiaphong.setGridColor(new java.awt.Color(51, 0, 255));
        tblgiaphong.setInheritsPopupMenu(true);
        tblgiaphong.setName(""); // NOI18N
        tblgiaphong.setRowHeight(30);
        tblgiaphong.setSurrendersFocusOnKeystroke(true);
        tblgiaphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblgiaphongMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblgiaphong);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Type room:");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/broom_64px.png"))); // NOI18N
        jLabel39.setText("Clear");
        jLabel39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel39MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel39MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel39MouseExited(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Price:");

        loaiphong1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        loaiphong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loaiphong1ActionPerformed(evt);
            }
        });

        gia2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gia2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gia2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Type room:");

        maloaiphong1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        maloaiphong1.setText("jLabel14");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel25)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(delete2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(loaiphong1, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                                .addComponent(gia2))
                            .addComponent(maloaiphong1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(maloaiphong1))
                        .addGap(67, 67, 67)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(loaiphong1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(gia2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                        .addGap(35, 35, 35)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete2)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28)
                    .addComponent(jLabel39))
                .addGap(32, 32, 32))
        );

        jPanel3.add(jPanel7, "card11");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 66, Short.MAX_VALUE)
        );

        jLabel30.setFont(new java.awt.Font("Rage Italic", 2, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 153, 0));
        jLabel30.setText("Romance hotel ");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/update_64px.png"))); // NOI18N
        jLabel32.setText("Update");
        jLabel32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel32MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel32MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel32MouseExited(evt);
            }
        });

        tblchucvu_luong.setAutoCreateRowSorter(true);
        tblchucvu_luong.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblchucvu_luong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Officials", "Salary"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblchucvu_luong.setAlignmentX(2.0F);
        tblchucvu_luong.setAlignmentY(2.0F);
        tblchucvu_luong.setDoubleBuffered(true);
        tblchucvu_luong.setDragEnabled(true);
        tblchucvu_luong.setFillsViewportHeight(true);
        tblchucvu_luong.setGridColor(new java.awt.Color(51, 0, 255));
        tblchucvu_luong.setInheritsPopupMenu(true);
        tblchucvu_luong.setName(""); // NOI18N
        tblchucvu_luong.setRowHeight(30);
        tblchucvu_luong.setSurrendersFocusOnKeystroke(true);
        tblchucvu_luong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblchucvu_luongMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblchucvu_luong);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Officials");

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlykhachsan/HinhAnh/broom_64px.png"))); // NOI18N
        jLabel42.setText("Clear");
        jLabel42.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel42MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel42MouseExited(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setText("Salary");

        luong4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        luong4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luong4ActionPerformed(evt);
            }
        });

        chucvu4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        chucvu4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Director", "Receptionist", "Accountant" }));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel33))
                .addGap(110, 110, 110)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(luong4, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(chucvu4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(183, 183, 183)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel14))
                            .addComponent(chucvu4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(luong4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                        .addGap(35, 35, 35)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jLabel42))
                .addGap(32, 32, 32))
        );

        jPanel3.add(jPanel11, "card15");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        LoginGUI lg = new LoginGUI();
        lg.setVisible(true);
        this.dispose();      // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
        jLabel6.setBackground(Color.LIGHT_GRAY);
        jLabel6.setOpaque(true);
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jLabel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseExited
        jLabel6.setBackground(new Color(98, 9, 107));    // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        cl.show(jPanel3, "card3");                 // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        jLabel2.setBackground(Color.LIGHT_GRAY);
        jLabel2.setOpaque(true);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        jLabel2.setBackground(new Color(84, 43, 128));
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked

        cl.show(jPanel3, "card5");
        try {
            autoID_dichvu();
            load_table_dichvu();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
        jLabel3.setBackground(Color.LIGHT_GRAY);
        jLabel3.setOpaque(true);

    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        // TODO add your handling code here:
        jLabel3.setBackground(new Color(76, 63, 140));
    }//GEN-LAST:event_jLabel3MouseExited

    private void jLabel35MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseClicked
        // TODO add your handling code here:
        cl.show(jPanel3, "card4");
        try {
            autoID_room();
            load_table_phong();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel35MouseClicked

    private void jLabel35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseEntered
        // TODO add your handling code here:
        jLabel35.setBackground(Color.LIGHT_GRAY);
        jLabel35.setOpaque(true);
    }//GEN-LAST:event_jLabel35MouseEntered

    private void jLabel35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel35MouseExited
        // TODO add your handling code here:
        jLabel35.setBackground(new Color(69, 80, 150));
    }//GEN-LAST:event_jLabel35MouseExited

    private void addroom1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addroom1MouseEntered
        // TODO add your handling code here:
        addroom1.setBackground(Color.LIGHT_GRAY);
        addroom1.setOpaque(true);
    }//GEN-LAST:event_addroom1MouseEntered

    private void addroom1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addroom1MouseExited
        // TODO add your handling code here:
        addroom1.setBackground(Color.WHITE);
    }//GEN-LAST:event_addroom1MouseExited

    private void deleteroom1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteroom1MouseEntered
        // TODO add your handling code here:
        deleteroom1.setBackground(Color.LIGHT_GRAY);
        deleteroom1.setOpaque(true);
    }//GEN-LAST:event_deleteroom1MouseEntered

    private void deleteroom1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteroom1MouseExited
        // TODO add your handling code here:
        deleteroom1.setBackground(Color.WHITE);
    }//GEN-LAST:event_deleteroom1MouseExited

    private void updateroom1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateroom1MouseEntered
        // TODO add your handling code here:
        updateroom1.setBackground(Color.LIGHT_GRAY);
        updateroom1.setOpaque(true);
    }//GEN-LAST:event_updateroom1MouseEntered

    private void updateroom1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateroom1MouseExited
        // TODO add your handling code here:
        updateroom1.setBackground(Color.WHITE);
    }//GEN-LAST:event_updateroom1MouseExited

    private void searchroom1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchroom1MouseEntered
        // TODO add your handling code here:
        searchroom1.setBackground(Color.LIGHT_GRAY);
        searchroom1.setOpaque(true);
    }//GEN-LAST:event_searchroom1MouseEntered

    private void searchroom1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchroom1MouseExited
        // TODO add your handling code here:
        searchroom1.setBackground(Color.WHITE);
    }//GEN-LAST:event_searchroom1MouseExited

    private void adddichvuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adddichvuMouseEntered
        // TODO add your handling code here:
        adddichvu.setBackground(Color.LIGHT_GRAY);
        adddichvu.setOpaque(true);

    }//GEN-LAST:event_adddichvuMouseEntered

    private void adddichvuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adddichvuMouseExited
        // TODO add your handling code here:
        adddichvu.setBackground(Color.WHITE);
    }//GEN-LAST:event_adddichvuMouseExited

    private void deletedichvuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletedichvuMouseEntered
        // TODO add your handling code here:
        deletedichvu.setBackground(Color.LIGHT_GRAY);
        deletedichvu.setOpaque(true);
    }//GEN-LAST:event_deletedichvuMouseEntered

    private void deletedichvuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletedichvuMouseExited
        // TODO add your handling code here:
        deletedichvu.setBackground(Color.WHITE);
    }//GEN-LAST:event_deletedichvuMouseExited

    private void updatedichvuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedichvuMouseEntered
        // TODO add your handling code here:
        updatedichvu.setBackground(Color.LIGHT_GRAY);
        updatedichvu.setOpaque(true);
    }//GEN-LAST:event_updatedichvuMouseEntered

    private void updatedichvuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedichvuMouseExited
        // TODO add your handling code here:
        updatedichvu.setBackground(Color.WHITE);
    }//GEN-LAST:event_updatedichvuMouseExited

    private void timkiemdichvuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiemdichvuMouseEntered
        // TODO add your handling code here:
        timkiemdichvu.setBackground(Color.LIGHT_GRAY);
        timkiemdichvu.setOpaque(true);
    }//GEN-LAST:event_timkiemdichvuMouseEntered

    private void timkiemdichvuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiemdichvuMouseExited
        // TODO add your handling code here:
        timkiemdichvu.setBackground(Color.WHITE);
    }//GEN-LAST:event_timkiemdichvuMouseExited

    private void tendichvu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tendichvu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tendichvu1ActionPerformed

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        // TODO add your handling code here:
        jLabel21.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        // TODO add your handling code here:
        jLabel21.setBackground(Color.LIGHT_GRAY);
        jLabel21.setOpaque(true);
    }//GEN-LAST:event_jLabel21MouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        // TODO add your handling code here:
        delete.setBackground(Color.WHITE);
    }//GEN-LAST:event_deleteMouseExited

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        // TODO add your handling code here:
        delete.setBackground(Color.LIGHT_GRAY);
        delete.setOpaque(true);
    }//GEN-LAST:event_deleteMouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        // TODO add your handling code here:
        jLabel18.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        // TODO add your handling code here:
        jLabel18.setBackground(Color.LIGHT_GRAY);
        jLabel18.setOpaque(true);
    }//GEN-LAST:event_jLabel18MouseEntered

    private void timkiemnvMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiemnvMouseEntered
        timkiemnv.setBackground(Color.LIGHT_GRAY);
        timkiemnv.setOpaque(true);// TODO add your handling code here:
    }//GEN-LAST:event_timkiemnvMouseEntered

    private void timkiemnvMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiemnvMouseExited
        timkiemnv.setBackground(Color.WHITE);

    }//GEN-LAST:event_timkiemnvMouseExited

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked

        String manv = manv1.getText();
        String hotennv = fullname1.getText();
        String gioitinh = gioitinh1.getSelectedItem().toString();
        String sodt = phonenumber1.getText();
        String diachi = address1.getText();
        String cmnd = cmnd1.getText();
        String chucvu = chucvu2.getSelectedItem().toString();
        if (hotennv.isEmpty() || sodt.isEmpty() || diachi.isEmpty() || cmnd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Incomplete information", "Notice", JOptionPane.INFORMATION_MESSAGE);
        } else {
            nhanvienDTO nv = new nhanvienDTO(manv, hotennv, gioitinh, sodt, diachi, cmnd, chucvu);
            nhanvienBUS nvBUS;
            try {
                nvBUS = new nhanvienBUS();
                int q = JOptionPane.showConfirmDialog(null, "Do you want to add data", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (q == 0) {
                    if (nvBUS.themnhanvien(nv) == true) {
                        JOptionPane.showMessageDialog(null, "Add success", "Notice", JOptionPane.NO_OPTION);
                    } else {
                        JOptionPane.showMessageDialog(null, "Add failed", "Notice", JOptionPane.NO_OPTION);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);

                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                load_table_nv();
                autoID();
            } catch (SQLException ex) {
                Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jLabel18MouseClicked

    private void phonenumber1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonenumber1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonenumber1ActionPerformed

    private void cmnd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmnd1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmnd1ActionPerformed

    private void gioitinh1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gioitinh1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gioitinh1ActionPerformed

    private void chucvu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chucvu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chucvu2ActionPerformed

    private void fullname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullname1ActionPerformed

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        String manv = manv1.getText();
        String hotennv = fullname1.getText();
        String gioitinh = gioitinh1.getSelectedItem().toString();
        String sodt = phonenumber1.getText();
        String diachi = address1.getText();
        String cmnd = cmnd1.getText();
        String chucvu = chucvu2.getSelectedItem().toString();
        nhanvienDTO nv = new nhanvienDTO(manv, hotennv, gioitinh, sodt, diachi, cmnd, chucvu);
        nhanvienBUS nvBUS;
        try {
            nvBUS = new nhanvienBUS();
            int q;
            q = JOptionPane.showConfirmDialog(null, "Do you want to delete data", "Confirm", JOptionPane.YES_NO_OPTION);
            if (q == 0) {
                if (nvBUS.xoanhanvien(nv) == false) {
                    JOptionPane.showMessageDialog(null, "Deleted successfully", "Notice", JOptionPane.NO_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, "Delete failed", "Notice", JOptionPane.NO_OPTION);
                }
            }

        } catch (SQLException ex) {
            //Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Employees are working", "Error messages", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            load_table_nv();
        } catch (SQLException ex) {
            //  Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteMouseClicked

    private void tblnhanvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblnhanvienMouseClicked
        // TODO add your handling code here:
        int row = tblnhanvien.rowAtPoint(evt.getPoint());
        int col = tblnhanvien.columnAtPoint(evt.getPoint());
        int numcols = tblnhanvien.getColumnCount();
        // String a=""; 
        for (int i = 0; i < numcols; i++) {
            String str = (String) tblnhanvien.getValueAt(row, i);
            if (i == 0) {
                manv1.setText(str);
            }
            if (i == 1) {
                fullname1.setText(str);
            }
            if (i == 2) {
                gioitinh1.setSelectedItem(str);
            }
            //a+=str;
            if (i == 3) {
                phonenumber1.setText(str);
            }
            if (i == 5) {
                cmnd1.setText(str);
            }
            if (i == 4) {
                address1.setText(str);
            }
            if (i == 6) {
                chucvu2.setSelectedItem(str);
            }

        }
    }//GEN-LAST:event_tblnhanvienMouseClicked

    private void timkiemTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemTextActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_timkiemTextActionPerformed

    private void timkiemnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiemnvMouseClicked
        nhanvienBUS nvBUS;
        try {
            nvBUS = new nhanvienBUS();
            nvBUS.timkiemnhanvien(timkiemText.getText(), (DefaultTableModel) tblnhanvien.getModel());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_timkiemnvMouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked

        String manv = manv1.getText();
        String hotennv = fullname1.getText();
        String gioitinh = gioitinh1.getSelectedItem().toString();
        String sodt = phonenumber1.getText();
        String diachi = address1.getText();
        String cmnd = cmnd1.getText();
        String chucvu = chucvu2.getSelectedItem().toString();
        nhanvienDTO nv = new nhanvienDTO(manv, hotennv, gioitinh, sodt, diachi, cmnd, chucvu);
        nhanvienBUS nvBUS;
        try {
            nvBUS = new nhanvienBUS();

            int q = JOptionPane.showConfirmDialog(null, "Do you want to edit the data", "Confirm", JOptionPane.YES_NO_OPTION);
            if (q == 0) {
                if (nvBUS.suanhanvien(nv) == true) {
                    JOptionPane.showMessageDialog(null, "Edit successful", "Notice", JOptionPane.NO_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, "Edit failed", "Notice", JOptionPane.NO_OPTION);
                }

            }

        } catch (SQLException ex) {
            //Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Employees are working", "Error messages", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            load_table_nv(); //  Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel21MouseClicked

    private void timkiemText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemText1ActionPerformed
        // TODO add your handling code here:
        phongBUS pBUS;
        try {
            pBUS = new phongBUS();
            pBUS.timkiemphong(timkiemText1.getText(), (DefaultTableModel) tblroom.getModel());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_timkiemText1ActionPerformed

    private void roomtype1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomtype1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomtype1ActionPerformed

    private void timkiemtext1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemtext1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timkiemtext1ActionPerformed

    private void jLabel26MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseExited
        // TODO add your handling code here:
        jLabel26.setBackground(Color.WHITE);

    }//GEN-LAST:event_jLabel26MouseExited

    private void jLabel26MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseEntered
        // TODO add your handling code here:
        jLabel26.setBackground(Color.LIGHT_GRAY);
        jLabel26.setOpaque(true);

    }//GEN-LAST:event_jLabel26MouseEntered

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        try {
            // TODO add your handling code here:
            autoID();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        fullname1.setText(null);
        phonenumber1.setText(null);
        cmnd1.setText(null);
        address1.setText(null);

    }//GEN-LAST:event_jLabel26MouseClicked

    private void tbldichvuAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tbldichvuAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tbldichvuAncestorAdded

    private void adddichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adddichvuMouseClicked
        // TODO add your handling code here:

        String madv = madichvu1.getText();
        String tendv = tendichvu1.getText();
        String dvt = donvitinh1.getSelectedItem().toString();
        String gia = gia1.getText();

        if (tendv.isEmpty() || gia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Incomplete information ", "Notice", JOptionPane.NO_OPTION);
        } else {
            dichvuDTO dv = new dichvuDTO(madv, tendv, dvt, gia);
            dichvuBUS dvBUS;
            try {
                dvBUS = new dichvuBUS();
                int q = JOptionPane.showConfirmDialog(null, "Do you want to add the data", "Confirm", JOptionPane.YES_NO_OPTION);
                if (q == 0) {
                    if (dvBUS.themdichvu(dv) == true) {

                        JOptionPane.showMessageDialog(null, "Add success", "Notice", JOptionPane.NO_OPTION);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Add failed", "Notice", JOptionPane.NO_OPTION);
                }

            } catch (SQLException ex) {
                //Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);

                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                load_table_dichvu();
            } catch (SQLException ex) {
                Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                autoID_dichvu();
            } catch (SQLException ex) {
                Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_adddichvuMouseClicked

    private void gia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gia1ActionPerformed

    private void deletedichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletedichvuMouseClicked
        // TODO add your handling code here:
        String madv = madichvu1.getText();
        String tendv = tendichvu1.getText();
        String dvt = donvitinh1.getSelectedItem().toString();
        String gia = gia1.getText();

        dichvuDTO dv = new dichvuDTO(madv, tendv, dvt, gia);
        dichvuBUS dvBUS;
        try {
            dvBUS = new dichvuBUS();
            int d = JOptionPane.showConfirmDialog(null, "Do you want to delete the data", "Confirm", JOptionPane.YES_NO_OPTION);
            if (d == 0) {
                if (dvBUS.xoadichvu(dv) == true) {
                    JOptionPane.showMessageDialog(null, "deleted successfully", "Notice", JOptionPane.NO_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, "Delete failed", "Notice", JOptionPane.NO_OPTION);
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            load_table_dichvu();
            autoID_dichvu();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletedichvuMouseClicked

    private void tbldichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldichvuMouseClicked
        // TODO add your handling code here:
        int row = tbldichvu.rowAtPoint(evt.getPoint());
        int col = tbldichvu.columnAtPoint(evt.getPoint());
        int numcols = tbldichvu.getColumnCount();
        // String a=""; 
        for (int i = 0; i < numcols; i++) {
            String str = (String) tbldichvu.getValueAt(row, i);
            if (i == 0) {
                madichvu1.setText(str);
            }
            if (i == 1) {
                tendichvu1.setText(str);
            }
            if (i == 2) {
                donvitinh1.setSelectedItem(str);
            }
            //a+=str;
            if (i == 3) {
                gia1.setText(str);
            }

        }

    }//GEN-LAST:event_tbldichvuMouseClicked

    private void updatedichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedichvuMouseClicked
        // TODO add your handling code here:
        String madv = madichvu1.getText();
        String tendv = tendichvu1.getText();
        String dvt = donvitinh1.getSelectedItem().toString();
        String gia = gia1.getText();

        dichvuDTO dv = new dichvuDTO(madv, tendv, dvt, gia);
        dichvuBUS dvBUS;
        try {
            dvBUS = new dichvuBUS();
            int q = JOptionPane.showConfirmDialog(null, "Do you want to edit the data", "Confirm", JOptionPane.YES_NO_OPTION);
            if (q == 0) {
                if (dvBUS.suadichvu(dv) == true) {

                    JOptionPane.showMessageDialog(null, "Edit successful", "Notice", JOptionPane.NO_OPTION);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Edit failed", "Notice", JOptionPane.NO_OPTION);
            }

        } catch (SQLException ex) {
            //Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            load_table_dichvu();
            //  Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_updatedichvuMouseClicked

    private void lamtrangdichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lamtrangdichvuMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            autoID_dichvu();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        tendichvu1.setText(null);
        gia1.setText(null);

    }//GEN-LAST:event_lamtrangdichvuMouseClicked

    private void timkiemdichvuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_timkiemdichvuMouseClicked
        // TODO add your handling code here:
        dichvuBUS dvBUS;
        try {
            dvBUS = new dichvuBUS();
            dvBUS.timkiemdichvu(timkiemtext1.getText(), (DefaultTableModel) tbldichvu.getModel());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_timkiemdichvuMouseClicked

    private void timkiemTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timkiemTextKeyPressed
        // TODO add your handling code here:
        nhanvienBUS nvBUS;
        try {
            nvBUS = new nhanvienBUS();
            nvBUS.timkiemnhanvien(timkiemText.getText(), (DefaultTableModel) tblnhanvien.getModel());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_timkiemTextKeyPressed

    private void timkiemtext1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timkiemtext1KeyPressed
        // TODO add your handling code here:
        dichvuBUS dvBUS;
        try {
            dvBUS = new dichvuBUS();
            dvBUS.timkiemdichvu(timkiemtext1.getText(), (DefaultTableModel) tbldichvu.getModel());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_timkiemtext1KeyPressed

    private void addroom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addroom1MouseClicked
        // TODO add your handling code here:
        String maphong = coderoom1.getText();
        String tenloaiphong = roomtype1.getSelectedItem().toString();

        phongDTO p = new phongDTO(maphong, tenloaiphong);
        phongBUS pBUS;
        try {
            pBUS = new phongBUS();
            int q = JOptionPane.showConfirmDialog(null, "Do you want to add the data", "Confirm", JOptionPane.YES_NO_OPTION);
            if (q == 0) {
                if (pBUS.themphong(p) == true) {

                    if (q == 0) {
                        JOptionPane.showMessageDialog(null, "Add success", "Notice", JOptionPane.NO_OPTION);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Add failed", "Notice", JOptionPane.NO_OPTION);
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            load_table_phong();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            autoID_room();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_addroom1MouseClicked

    private void deleteroom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteroom1MouseClicked
        // TODO add your handling code here:
        String maphong = coderoom1.getText();
        String tenlp = roomtype1.getSelectedItem().toString();

        phongDTO p = new phongDTO(maphong, tenlp);
        phongBUS pBUS;
        try {
            pBUS = new phongBUS();
            int d = JOptionPane.showConfirmDialog(null, "Do you want to delete the data", "Confirm", JOptionPane.YES_NO_OPTION);
            if (d == 0) {
                if (pBUS.xoaphong(p) == true) {
                    JOptionPane.showMessageDialog(null, "deleted successfully", "Notice", JOptionPane.NO_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, "Delete failed", "Notice", JOptionPane.NO_OPTION);
                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            load_table_phong();
            autoID_room();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_deleteroom1MouseClicked

    private void tblroomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblroomMouseClicked
        // TODO add your handling code here:
        int row = tblroom.rowAtPoint(evt.getPoint());
        int col = tblroom.columnAtPoint(evt.getPoint());
        int numcols = tblroom.getColumnCount();
        // String a=""; 
        for (int i = 0; i < numcols; i++) {
            String str = (String) tblroom.getValueAt(row, i);
            if (i == 0) {
                coderoom1.setText(str);
            }
            if (i == 1) {
                roomtype1.setSelectedItem(str);

            }
            if (i == 3) {
                System.out.print(str);
            }

        }
    }//GEN-LAST:event_tblroomMouseClicked

    private void updateroom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateroom1MouseClicked
        // TODO add your handling code here:
        String maphong = coderoom1.getText();
        String loaiphong = roomtype1.getSelectedItem().toString();

        phongDTO p = new phongDTO(maphong, loaiphong);
        phongBUS pBUS;
        try {
            pBUS = new phongBUS();
            int d = JOptionPane.showConfirmDialog(null, "Do you want to update the data", "Confirm", JOptionPane.YES_NO_OPTION);
            if (d == 0) {
                if (pBUS.suaphong(p) == true) {
                    JOptionPane.showMessageDialog(null, "Edit successful", "Notice", JOptionPane.NO_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, "Edit failed", "Notice", JOptionPane.NO_OPTION);
                }
            }

        } catch (SQLException ex) {
            //Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, "Room is being used", "Error messages", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            load_table_phong();
            //  Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_updateroom1MouseClicked

    private void timkiemText1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timkiemText1KeyPressed
        // TODO add your handling code here:
        phongBUS pBUS;
        try {
            pBUS = new phongBUS();
            pBUS.timkiemphong(timkiemText1.getText(), (DefaultTableModel) tblroom.getModel());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_timkiemText1KeyPressed

    private void searchroom1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchroom1MouseClicked
        // TODO add your handling code here:
        phongBUS pBUS;
        try {
            pBUS = new phongBUS();
            pBUS.timkiemphong(timkiemText1.getText(), (DefaultTableModel) tblroom.getModel());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchroom1MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        // TODO add your handling code here:
        cl.show(jPanel3, "card10");
        try {
            // autoID_chiso();
            load_table_chiso();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseEntered
        // TODO add your handling code here:
        jLabel37.setBackground(Color.LIGHT_GRAY);
        jLabel37.setOpaque(true);
    }//GEN-LAST:event_jLabel37MouseEntered

    private void jLabel37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseExited
        // TODO add your handling code here:
        jLabel37.setBackground(new Color(62, 98, 161));
    }//GEN-LAST:event_jLabel37MouseExited

    private void jLabel34MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseExited
        // TODO add your handling code here:
        jLabel34.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLabel34MouseExited

    private void jLabel34MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseEntered
        // TODO add your handling code here:
        jLabel34.setBackground(Color.LIGHT_GRAY);
        jLabel34.setOpaque(true);

    }//GEN-LAST:event_jLabel34MouseEntered

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked

        chiso1.setText(null);
        chiso2.setText(null);
    }//GEN-LAST:event_jLabel34MouseClicked

    private void tblchisoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblchisoMouseClicked
        // TODO add your handling code here:
        int row = tblchiso.rowAtPoint(evt.getPoint());
        int col = tblchiso.columnAtPoint(evt.getPoint());
        int numcols = tblchiso.getColumnCount();
        // String a=""; 
        for (int i = 0; i < numcols; i++) {
            String str = (String) tblchiso.getValueAt(row, i);
            if (i == 0) {
                chiso1.setText(str);
            }
            if (i == 1) {
                chiso2.setText(str);
            }

        }
    }//GEN-LAST:event_tblchisoMouseClicked

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
        // TODO add your handling code here:
        jLabel27.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLabel27MouseExited

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
        // TODO add your handling code here:
        jLabel27.setBackground(Color.LIGHT_GRAY);
        jLabel27.setOpaque(true);
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
        //String machiso = machiso1.getText();
        String tenchiso = chiso1.getText();
        String chiso = chiso2.getText();

        chisoDTO cs = new chisoDTO(tenchiso, chiso);
        chisoBUS csBUS;
        try {
            csBUS = new chisoBUS();
            int q = JOptionPane.showConfirmDialog(null, "Do you want to edit the data", "Confirm", JOptionPane.YES_NO_OPTION);
            if (q == 0) {
                if (csBUS.suachiso(cs) == true) {
                    csBUS = new chisoBUS();

                    if (csBUS.suachiso(cs) == true) {
                        JOptionPane.showMessageDialog(null, "Edit successful", "Notice", JOptionPane.NO_OPTION);
                    } else {
                        JOptionPane.showMessageDialog(null, "Edit failed", "Notice", JOptionPane.NO_OPTION);
                    }
                }
            }

        } catch (SQLException ex) {
            //Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            load_table_chiso();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jLabel27MouseClicked

    private void delete1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete1MouseExited
        // TODO add your handling code here:
        delete1.setBackground(Color.WHITE);
    }//GEN-LAST:event_delete1MouseExited

    private void delete1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete1MouseEntered
        delete1.setBackground(Color.LIGHT_GRAY);
        delete1.setOpaque(true);        // TODO add your handling code here:

    }//GEN-LAST:event_delete1MouseEntered

    private void delete1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete1MouseClicked
        // TODO add your handling code here:
        // String machiso = machiso1.getText();
        String tenchiso = chiso1.getText();
        String chiso = chiso2.getText();

        chisoDTO cs = new chisoDTO(tenchiso, chiso);
        chisoBUS csBUS;
        try {
            csBUS = new chisoBUS();
            int q = JOptionPane.showConfirmDialog(null, "Do you want to delete the data", "Notice", JOptionPane.NO_OPTION);
            if (q == 0) {
                if (csBUS.xoachiso(cs) == true) {

                    JOptionPane.showMessageDialog(null, "deleted successfully", "Notice", JOptionPane.NO_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, "Delete failed", "Notice", JOptionPane.NO_OPTION);
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Room is being rented", "Notice", JOptionPane.ERROR);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            load_table_chiso();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
//        try {
//            autoID_chiso();
//        } catch (SQLException ex) {
//            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
//        }


    }//GEN-LAST:event_delete1MouseClicked

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        // TODO add your handling code here:
        jLabel20.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        // TODO add your handling code here:
        jLabel20.setBackground(Color.LIGHT_GRAY);
        jLabel20.setOpaque(true);
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        // TODO add your handling code here:
        // String machiso = machiso1.getText();
        String tenchiso = chiso1.getText();
        String chiso = chiso2.getText();

        chisoDTO cs = new chisoDTO(tenchiso, chiso);
        chisoBUS csBUS;
        try {
            csBUS = new chisoBUS();
            int q = JOptionPane.showConfirmDialog(null, "Do you want to add the data", "Notice", JOptionPane.NO_OPTION);
            if (q == 0) {
                if (csBUS.themchiso(cs) == true) {

                    JOptionPane.showMessageDialog(null, "Add success", "Notice", JOptionPane.NO_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, "Add failed", "Notice", JOptionPane.NO_OPTION);
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            load_table_chiso();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
////        try {
////            autoID_chiso();
////        } catch (SQLException ex) {
////            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
////        }

    }//GEN-LAST:event_jLabel20MouseClicked

    private void chiso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chiso1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chiso1ActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        // TODO add your handling code here:
        jLabel4.setBackground(Color.LIGHT_GRAY);
        jLabel4.setOpaque(true);
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        // TODO add your handling code here:
        jLabel4.setBackground(new Color(27, 186, 213));
    }//GEN-LAST:event_jLabel4MouseExited

    private void chiso2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chiso2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chiso2ActionPerformed

    private void jLabel28MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseClicked
        // TODO add your handling code here:
        String maloaiphong = maloaiphong1.getText();
        String loaiphong = loaiphong1.getText();
        String gia = gia2.getText();
        if (maloaiphong.isEmpty() || loaiphong.isEmpty() || gia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Incomplete information", "Notice", JOptionPane.INFORMATION_MESSAGE);
        } else {
            giaphongDTO gp = new giaphongDTO(maloaiphong, loaiphong, gia);

            giaphongBUS gpBUS;
            try {
                gpBUS = new giaphongBUS();
                int q = JOptionPane.showConfirmDialog(null, "Do you want to add data", "Xác nhận", JOptionPane.YES_NO_OPTION);
                if (q == 0) {
                    if (gpBUS.themloaiphong(gp) == true) {
                        JOptionPane.showMessageDialog(null, "Add success", "Notice", JOptionPane.NO_OPTION);
                    } else {
                        JOptionPane.showMessageDialog(null, "Add failed", "Notice", JOptionPane.NO_OPTION);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);

                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                load_table_giaphong();
                autoID_loaiphong();
            } catch (SQLException ex) {
                Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_jLabel28MouseClicked

    private void jLabel28MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseEntered
        // TODO add your handling code here:
        jLabel28.setBackground(Color.LIGHT_GRAY);
        jLabel28.setOpaque(true);
    }//GEN-LAST:event_jLabel28MouseEntered

    private void jLabel28MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel28MouseExited
        // TODO add your handling code here:
        jLabel28.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLabel28MouseExited

    private void delete2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete2MouseClicked
        // TODO add your handling code here:

        String maloaiphong = maloaiphong1.getText();
        giaphongDTO gp = new giaphongDTO(maloaiphong);
        giaphongBUS gpBUS;

        try {
            gpBUS = new giaphongBUS();
            int q = JOptionPane.showConfirmDialog(null, "Do you want to delete the data", "Notice", JOptionPane.NO_OPTION);
            if (q == 0) {
                if (gpBUS.xoaloaiphong(gp) == true) {

                    JOptionPane.showMessageDialog(null, "deleted successfully", "Notice", JOptionPane.NO_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, "Delete failed", "Notice", JOptionPane.NO_OPTION);
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            load_table_giaphong();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_delete2MouseClicked

    private void delete2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete2MouseEntered
        // TODO add your handling code here:
        delete2.setBackground(Color.LIGHT_GRAY);
        delete2.setOpaque(true);
    }//GEN-LAST:event_delete2MouseEntered

    private void delete2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete2MouseExited
        // TODO add your handling code here:
        delete2.setBackground(Color.WHITE);
    }//GEN-LAST:event_delete2MouseExited

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
        String maloaiphong = maloaiphong1.getText();
        String tenloaiphong = loaiphong1.getText();
        String gia = gia2.getText();
        giaphongDTO gp = new giaphongDTO(maloaiphong, tenloaiphong, gia);
        giaphongBUS gpBUS;
        try {
            gpBUS = new giaphongBUS();
            int q = JOptionPane.showConfirmDialog(null, "Do you want to edit the data", "Confirm", JOptionPane.YES_NO_OPTION);
            if (q == 0) {
                if (gpBUS.capnhatloaiphong(gp) == true) {
                        JOptionPane.showMessageDialog(null, "Edit successful", "Notice", JOptionPane.NO_OPTION);
                    } else {
                        JOptionPane.showMessageDialog(null, "Edit failed", "Notice", JOptionPane.NO_OPTION);
                    }
                
            }

        } catch (SQLException ex) {
            //Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error messages", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            load_table_giaphong();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel29MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseEntered
        // TODO add your handling code here:
        jLabel29.setBackground(Color.LIGHT_GRAY);
        jLabel29.setOpaque(true);
    }//GEN-LAST:event_jLabel29MouseEntered

    private void jLabel29MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseExited
        // TODO add your handling code here:
        jLabel29.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLabel29MouseExited

    private void tblgiaphongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblgiaphongMouseClicked
        // TODO add your handling code here:
        int row = tblgiaphong.rowAtPoint(evt.getPoint());
        int col = tblgiaphong.columnAtPoint(evt.getPoint());
        int numcols = tblgiaphong.getColumnCount();
        // String a=""; 
        for (int i = 0; i < numcols; i++) {
            String str = (String) tblgiaphong.getValueAt(row, i);
            if (i == 0) {
                maloaiphong1.setText(str);
            }
            if (i == 1) {
                loaiphong1.setText(str);
            }
            if (i == 2) {
                gia2.setText(str);
            }
        }
    }//GEN-LAST:event_tblgiaphongMouseClicked

    private void jLabel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseClicked
        try {
            // TODO add your handling code here:
            autoID_loaiphong();
            loaiphong1.setText(null);
            gia2.setText(null);
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel39MouseClicked

    private void jLabel39MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseEntered
        // TODO add your handling code here:
        jLabel39.setBackground(Color.LIGHT_GRAY);
        jLabel39.setOpaque(true);
    }//GEN-LAST:event_jLabel39MouseEntered

    private void jLabel39MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel39MouseExited
        // TODO add your handling code here:
        jLabel39.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLabel39MouseExited

    private void loaiphong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loaiphong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loaiphong1ActionPerformed

    private void gia2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gia2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gia2ActionPerformed

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        // TODO add your handling code here:
        cl.show(jPanel3, "card11");
        try {
            load_table_giaphong();
            autoID_loaiphong();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseEntered
        // TODO add your handling code here:
        jLabel40.setBackground(Color.LIGHT_GRAY);
        jLabel40.setOpaque(true);
    }//GEN-LAST:event_jLabel40MouseEntered

    private void jLabel40MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseExited
        // TODO add your handling code here:
        jLabel40.setBackground(new Color(60, 104, 164));

    }//GEN-LAST:event_jLabel40MouseExited

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        cl.show(jPanel3, "card15");
        try {
            // TODO add your handling code here:
            load_table_chucvu_luong();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jLabel41MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseEntered
        // TODO add your handling code here:
        jLabel41.setBackground(Color.LIGHT_GRAY);
        jLabel41.setOpaque(true);
    }//GEN-LAST:event_jLabel41MouseEntered

    private void jLabel41MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseExited
        // TODO add your handling code here:
          jLabel41.setBackground(new Color(56, 113, 170));
    }//GEN-LAST:event_jLabel41MouseExited

    private void jLabel32MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseClicked
        // TODO add your handling code here:
        String chucvu5 = chucvu4.getSelectedItem().toString();
        String luong5 = luong4.getText();
        nhanvienBUS nvBUS;
        
        try {
            nvBUS = new nhanvienBUS();
            int q = JOptionPane.showConfirmDialog(null, "Do you want to edit the data", "Confirm", JOptionPane.YES_NO_OPTION);
            if(q == 0){
                if(nvBUS.capnhatluong(chucvu5,luong5) == true)
                {
                     JOptionPane.showMessageDialog(null, "Edit successful", "Notice", JOptionPane.NO_OPTION);
                    } else {
                        JOptionPane.showMessageDialog(null, "Edit failed", "Notice", JOptionPane.NO_OPTION);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            load_table_chucvu_luong();
        } catch (SQLException ex) {
            Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

            
        
    }//GEN-LAST:event_jLabel32MouseClicked

    private void jLabel32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseEntered
        // TODO add your handling code here:
        jLabel32.setBackground(Color.LIGHT_GRAY);
        jLabel32.setOpaque(true);
    }//GEN-LAST:event_jLabel32MouseEntered

    private void jLabel32MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseExited
        // TODO add your handling code here:
        jLabel32.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLabel32MouseExited

    private void tblchucvu_luongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblchucvu_luongMouseClicked
        // TODO add your handling code here:
        int row = tblchucvu_luong.rowAtPoint(evt.getPoint());
        int col = tblchucvu_luong.columnAtPoint(evt.getPoint());
        int numcols = tblchucvu_luong.getColumnCount();
        // String a=""; 
        for (int i = 0; i < numcols; i++) {
            String str = (String) tblchucvu_luong.getValueAt(row, i);
            if (i == 0) {
                chucvu4.setSelectedItem(str);
            }
            if (i == 1) {
                luong4.setText(str);
            }
        }
    }//GEN-LAST:event_tblchucvu_luongMouseClicked

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        // TODO add your handling code here:
        luong4.setText(null);
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jLabel42MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseEntered
        // TODO add your handling code here:
        jLabel42.setBackground(Color.LIGHT_GRAY);
        jLabel42.setOpaque(true);
    }//GEN-LAST:event_jLabel42MouseEntered

    private void jLabel42MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseExited
        // TODO add your handling code here:
        jLabel42.setBackground(Color.WHITE);
    }//GEN-LAST:event_jLabel42MouseExited

    private void luong4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luong4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_luong4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        FlatLightLaf.install();


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new GiamdocGUI().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(GiamdocGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adddichvu;
    private javax.swing.JEditorPane address1;
    private javax.swing.JLabel addroom1;
    private javax.swing.JTextField chiso1;
    private javax.swing.JTextField chiso2;
    private javax.swing.JComboBox<String> chucvu2;
    private javax.swing.JComboBox<String> chucvu4;
    private javax.swing.JTextField cmnd1;
    private javax.swing.JLabel coderoom1;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel delete1;
    private javax.swing.JLabel delete2;
    private javax.swing.JLabel deletedichvu;
    private javax.swing.JLabel deleteroom1;
    private javax.swing.JComboBox<String> donvitinh1;
    private javax.swing.JTextField fullname1;
    private javax.swing.JTextField gia1;
    private javax.swing.JTextField gia2;
    private javax.swing.JComboBox<String> gioitinh1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel lamtrangdichvu;
    private javax.swing.JTextField loaiphong1;
    private javax.swing.JTextField luong4;
    private javax.swing.JLabel madichvu1;
    private javax.swing.JLabel maloaiphong1;
    private javax.swing.JLabel manv1;
    private javax.swing.JTextField phonenumber1;
    private javax.swing.JComboBox<String> roomtype1;
    private javax.swing.JLabel searchroom1;
    private javax.swing.JTable tblchiso;
    private javax.swing.JTable tblchucvu_luong;
    private javax.swing.JTable tbldichvu;
    private javax.swing.JTable tblgiaphong;
    private javax.swing.JTable tblnhanvien;
    private javax.swing.JTable tblroom;
    private javax.swing.JTextField tendichvu1;
    private javax.swing.JTextField timkiemText;
    private javax.swing.JTextField timkiemText1;
    private javax.swing.JLabel timkiemdichvu;
    private javax.swing.JLabel timkiemnv;
    private javax.swing.JTextField timkiemtext1;
    private javax.swing.JLabel updatedichvu;
    private javax.swing.JLabel updateroom1;
    // End of variables declaration//GEN-END:variables
}
