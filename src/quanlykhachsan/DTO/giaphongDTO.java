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
public class giaphongDTO {
    String maloaiphong,loaiphong, gia; 
    public giaphongDTO(){}
    public giaphongDTO(String loaiphong, String gia) {
        this.loaiphong = loaiphong;
        this.gia = gia;
    }

    public giaphongDTO(String maloaiphong, String loaiphong, String gia) {
        this.maloaiphong = maloaiphong;
        this.loaiphong = loaiphong;
        this.gia = gia;
    }

    public giaphongDTO(String maloaiphong) {
        this.maloaiphong = maloaiphong;
    }

    public String getMaloaiphong() {
        return maloaiphong;
    }

    public void setMaloaiphong(String maloaiphong) {
        this.maloaiphong = maloaiphong;
    }

    public String getLoaiphong() {
        return loaiphong;
    }

    public void setLoaiphong(String loaiphong) {
        this.loaiphong = loaiphong;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
      public String[] to_array1() {
        return new String[]{maloaiphong, loaiphong, gia};
    }
}
