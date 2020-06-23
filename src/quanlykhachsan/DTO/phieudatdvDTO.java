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
public class phieudatdvDTO {
    
    String maphong, tendv, gia, soluong, ngaysudung,masddv;

    public phieudatdvDTO() {
    }

    public phieudatdvDTO(String maphong, String tendv, String gia, String ngaysudung, String masddv) {
        this.maphong = maphong;
        this.tendv = tendv;
        this.gia = gia;
        String substring = ngaysudung.substring(0, 10);
        System.err.println(substring);
        String ngay = substring.substring(8, 10);
        System.err.println(ngay);
        String thang = substring.substring(5, 7);
        System.err.println(thang);
        String nam = substring.substring(0, 4);
        System.err.println(nam);
        String ngaythangnam = ngay + '-' + thang + '-' + nam;
        this.ngaysudung = ngaythangnam;
        
        this.masddv = masddv;
    }

    public phieudatdvDTO(String maphong, String tendv, String gia, String soluong) {
        this.maphong = maphong;
        this.tendv = tendv;
        this.gia = gia;
        this.soluong = soluong;
    }

    public phieudatdvDTO(String masddv) {
        this.masddv = masddv;
    }

    public String getMaphong() {
        return maphong;
    }

    public void setMaphong(String maphong) {
        this.maphong = maphong;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getNgaysudung() {
        return ngaysudung;
    }

    public String getMasddv() {
        return masddv;
    }

    public void setMasddv(String masddv) {
        this.masddv = masddv;
    }

    public void setNgaysudung(String ngaysudung) {
        this.ngaysudung = ngaysudung;
    }
    public String[] to_array() {
        return new String[]{masddv, maphong,tendv, ngaysudung, gia};
    }
}
