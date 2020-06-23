/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.Main;

import com.formdev.flatlaf.FlatLightLaf;
import quanlykhachsan.GUI.LoginGUI;

/**
 *
 * @author Duy Minh
 */
public class QuanLyKhachSan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FlatLightLaf.install();
        java.awt.EventQueue.invokeLater(() -> {
            new LoginGUI().setVisible(true);
        });
    }
    
}
