/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.DTO;

import java.util.Date;

/**
 *
 * @author Duy Minh
 */
public class thuephongDTO {
    String madatphong,maphong,ngaythue,ngaydi,manv;
    String htkh;
    String gioitinh,ngaysinh,sodt,cmnd,loaikhach,diachi;
    public thuephongDTO(){}

    public thuephongDTO(String maphong, String ngaythue, String ngaydi, String manv, String htkh, String gioitinh, String ngaysinh, String sodt, String cmnd, String loaikhach, String diachi) {
        this.maphong = maphong;
        this.ngaythue = ngaythue;
        this.ngaydi = ngaydi;
        this.manv = manv;
        this.htkh = htkh;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.sodt = sodt;
        this.cmnd = cmnd;
        this.loaikhach = loaikhach;
        this.diachi = diachi;
    }

    public thuephongDTO(String madatphong, String maphong, String ngaythue, String ngaydi) {
        this.madatphong = madatphong;
        this.maphong = maphong;
    }

    

    public String getMadatphong() {
        return madatphong;
    }

    public void setMadatphong(String madatphong) {
        this.madatphong = madatphong;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getNgaythue() {
        return ngaythue;
    }

    public void setNgaythue(String ngaythue) {
        this.ngaythue = ngaythue;
    }

    public String getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHtkh() {
        return htkh;
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

   public String[] to_array() {
        return new String[]{madatphong, maphong, ngaythue, ngaydi};
    }
     public String[] to_array1() {
        return new String[]{madatphong, maphong};
    }
}