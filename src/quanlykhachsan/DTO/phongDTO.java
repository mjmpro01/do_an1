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
public class phongDTO {

    String maphong;
    String loaiphong;
    String gia;
    String tentinhtrang;

    public phongDTO() {
    }

    public phongDTO(String maphong, String loaiphong, String gia) {
        this.maphong = maphong;
        this.loaiphong = loaiphong;
        this.gia = gia;
        
    }

    /**
     *
     * @param maphong
     * @param tentinhtrang
     * @param loaiphong
     */
    public phongDTO(String maphong, String loaiphong) {
        this.maphong = maphong;
        this.loaiphong = loaiphong;

    }
   
    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
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

    public String getTentinhtrang() {
        return tentinhtrang;
    }

    public void setTentinhtrang(String tentinhtrang) {
        this.tentinhtrang = tentinhtrang;
    }

    public String[] to_array() {
        return new String[]{maphong, loaiphong, gia, tentinhtrang};
    }
     public String[] to_array1() {
        return new String[]{maphong, loaiphong, tentinhtrang};
    }
     public String[] to_array2() {
        return new String[]{maphong, loaiphong, gia};
    }
       public String[] to_array3() {
        return new String[]{maphong, loaiphong};
    }
}
