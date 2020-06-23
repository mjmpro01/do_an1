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
public class hoadondichvuDTO {
    String maphongString,tendichvuString,soluongString,thanhtienString;

    public hoadondichvuDTO() {
        
    }

    public hoadondichvuDTO(String maphongString, String tendichvuString, String soluongString, String thanhtienString) {
        this.maphongString = maphongString;
        this.tendichvuString = tendichvuString;
        this.soluongString = soluongString;
        this.thanhtienString = thanhtienString;
    }

    public String getMaphongString() {
        return maphongString;
    }

    public void setMaphongString(String maphongString) {
        this.maphongString = maphongString;
    }

    public String getTendichvuString() {
        return tendichvuString;
    }

    public void setTendichvuString(String tendichvuString) {
        this.tendichvuString = tendichvuString;
    }

    public String getSoluongString() {
        return soluongString;
    }

    public void setSoluongString(String soluongString) {
        this.soluongString = soluongString;
    }

    public String getThanhtienString() {
        return thanhtienString;
    }

    public void setThanhtienString(String thanhtienString) {
        this.thanhtienString = thanhtienString;
    }
    public String[] to_array() {
        return new String[]{ maphongString,tendichvuString,soluongString,thanhtienString};
    }
    
}
