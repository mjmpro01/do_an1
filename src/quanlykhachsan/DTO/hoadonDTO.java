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
public class hoadonDTO {
    String mahdString,madpString,ngayhdString,tienphongString,tiendvString,tonghoadonString,loaiphongString,maphong;
    public hoadonDTO(){}
    public hoadonDTO(String mahdString, String madpString, String ngayhdString, String tonghoadonString) {
        this.mahdString = mahdString;
        this.madpString = madpString;
        this.ngayhdString = ngayhdString;
        this.tonghoadonString = tonghoadonString;
    }

    public hoadonDTO( String loaiphongString, String maphong, String tonghoadonString) {
        this.tonghoadonString = tonghoadonString;
        this.loaiphongString = loaiphongString;
        this.maphong = maphong;
    }

    public String getMahdString() {
        return mahdString;
    }

    public void setMahdString(String mahdString) {
        this.mahdString = mahdString;
    }

    public String getMadpString() {
        return madpString;
    }

    public void setMadpString(String madpString) {
        this.madpString = madpString;
    }

    public String getNgayhdString() {
        return ngayhdString;
    }

    public void setNgayhdString(String ngayhdString) {
        this.ngayhdString = ngayhdString;
    }

    public String getTienphongString() {
        return tienphongString;
    }

    public void setTienphongString(String tienphongString) {
        this.tienphongString = tienphongString;
    }

    public String getTiendvString() {
        return tiendvString;
    }

    public void setTiendvString(String tiendvString) {
        this.tiendvString = tiendvString;
    }

    public String getTonghoadonString() {
        return tonghoadonString;
    }

    public void setTonghoadonString(String tonghoadonString) {
        this.tonghoadonString = tonghoadonString;
    }

    public String getLoaiphongString() {
        return loaiphongString;
    }

    public void setLoaiphongString(String loaiphongString) {
        this.loaiphongString = loaiphongString;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }
    
     public String[] to_array() {
        return new String[]{loaiphongString,maphong,tonghoadonString};
    }
}
