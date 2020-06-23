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
public class dichvuDTO {
    String madv,tendv,dvt,gia,trangthai;
    public dichvuDTO(){}

    public dichvuDTO(String madv, String tendv, String dvt, String gia) {
        this.madv = madv;
        this.tendv = tendv;
        this.dvt = dvt;
        this.gia = gia;
       
    }

    public String getMadv() {
        return madv;
    }

    public void setMadv(String madv) {
        this.madv = madv;
    }

    public String getTendv() {
        return tendv;
    }

    public void setTendv(String tendv) {
        this.tendv = tendv;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }
    public String[] to_array(){
        return new String[]{madv, tendv, dvt, gia}; 
    }
}
