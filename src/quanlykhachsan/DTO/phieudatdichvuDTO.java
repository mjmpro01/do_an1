package quanlykhachsan.DTO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duy Minh
 */
public class phieudatdichvuDTO {

    String maphong, tendv, gia, soluong, ngaysudung;

    public phieudatdichvuDTO() {
    }

    public phieudatdichvuDTO(String maphong, String tendv, String gia, String soluong, String ngaysudung) {
        this.maphong = maphong;
        this.tendv = tendv;
        this.gia = gia;
        this.soluong = soluong;
        this.ngaysudung = ngaysudung;
    }
    
}
