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
public class khachhangDTO {
    String htkh;
    String gioitinh,ngaysinh,sodt,cmnd,loaikhach,diachi,sokhach;
    public khachhangDTO(){}

    public khachhangDTO(String htkh, String gioitinh, String ngaysinh, String sodt, String cmnd, String loaikhach, String diachi,String sokhach) {
        this.htkh = htkh;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sodt = sodt;
        this.cmnd = cmnd;
        this.loaikhach = loaikhach;
        this.diachi = diachi;
        this.sokhach = sokhach;
    }

    public String getHtkh() {
        return htkh;
    }

    public String getSokhach() {
        return sokhach;
    }

    public void setSokhach(String sokhach) {
        this.sokhach = sokhach;
    }

    public void setHtkh(String htkh) {
        this.htkh = htkh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getSodt() {
        return sodt;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getLoaikhach() {
        return loaikhach;
    }

    public void setLoaikhach(String loaikhach) {
        this.loaikhach = loaikhach;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
}
