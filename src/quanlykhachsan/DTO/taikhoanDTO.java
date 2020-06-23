/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.DTO;

/**
 *
 * @author Duy Minh
 */
public class taikhoanDTO {

    String manv;
    String matkhau;
    String chucvu;

    public taikhoanDTO() {
    }

    public taikhoanDTO(String manv, String matkhau, String chucvu) {
        this.manv = manv;
        this.matkhau = matkhau;
        this.chucvu = chucvu;
    }

    public taikhoanDTO(String manv, String matkhau) {
        this.manv = manv;
        this.matkhau = matkhau;
    }

    public taikhoanDTO(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }



    public String[] to_array() {
        return new String[]{manv, matkhau, chucvu};
    }
}
