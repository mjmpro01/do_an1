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
public class nhanvienDTO {

    String manv;
    String hotennv, gioitinh, sodt, diachi, trangthai, chucvu,luong;
    String cmnd;

    nhanvienDTO() {
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHotennv() {
        return hotennv;
    }

    public void setHotennv(String hotennv) {
        this.hotennv = hotennv;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }



    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public nhanvienDTO(String manv, String hotennv, String gioitinh, String sodt, String diachi, String cmnd, String chucvu, String luong) {
        this.manv = manv;
        this.hotennv = hotennv;
        this.gioitinh = gioitinh;
        this.sodt = sodt;
        this.diachi = diachi;
        this.chucvu = chucvu;
        this.cmnd = cmnd;
        this.luong = luong;
    }
public nhanvienDTO(String manv, String hotennv, String gioitinh, String sodt, String diachi, String cmnd, String chucvu) {
        this.manv = manv;
        this.hotennv = hotennv;
        this.gioitinh = gioitinh;
        this.sodt = sodt;
        this.diachi = diachi;
        this.chucvu = chucvu;
        this.cmnd = cmnd;
    
    }

    public nhanvienDTO(String chucvu, String luong) {
        this.chucvu = chucvu;
        this.luong = luong;
    }

    public String[] to_array() {
        return new String[]{ manv, hotennv,  gioitinh,  sodt,  diachi, cmnd, chucvu,luong};
    }
    public String[] to_array1(){
        return new String[]{chucvu,luong };
    }
}
