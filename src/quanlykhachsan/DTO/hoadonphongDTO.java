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
public class hoadonphongDTO {
    String maphong,tenloaiphongString,gia,songayString,thanhtien;
    public hoadonphongDTO(){}

    public hoadonphongDTO(String maphong, String tenloaiphongString, String gia, String songayString, String thanhtien) {
        this.maphong = maphong;
        this.tenloaiphongString = tenloaiphongString;
        this.gia = gia;
        this.songayString = songayString;
        this.thanhtien = thanhtien;
    }

    public hoadonphongDTO(String maphong, String tenloaiphongString) {
        this.maphong = maphong;
        this.tenloaiphongString = tenloaiphongString;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getTenloaiphongString() {
        return tenloaiphongString;
    }

    public void setTenloaiphongString(String tenloaiphongString) {
        this.tenloaiphongString = tenloaiphongString;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getSongayString() {
        return songayString;
    }

    public void setSongayString(String songayString) {
        this.songayString = songayString;
    }

    public String getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(String thanhtien) {
        this.thanhtien = thanhtien;
    }
     public String[] to_array() {
        return new String[]{maphong,tenloaiphongString,gia,songayString,thanhtien};
    }
      public String[] to_array1() {
        return new String[]{maphong,tenloaiphongString};
    }
}
