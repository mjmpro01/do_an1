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
public class chisoDTO {
    String machiso,tenchiso,chiso;
    public chisoDTO(){}

    public chisoDTO(String machiso, String tenchiso, String chiso) {
        this.machiso = machiso;
        this.tenchiso = tenchiso;
        this.chiso = chiso;
    }

    public chisoDTO(String tenchiso, String chiso) {
        this.tenchiso = tenchiso;
        this.chiso = chiso;
    }

    public String getMachiso() {
        return machiso;
    }

    public void setMachiso(String machiso) {
        this.machiso = machiso;
    }

    public String getTenchiso() {
        return tenchiso;
    }

    public void setTenchiso(String tenchiso) {
        this.tenchiso = tenchiso;
    }

    public String getChiso() {
        return chiso;
    }

    public void setChiso(String chiso) {
        this.chiso = chiso;
    }
     public String[] to_array1() {
        return new String[]{ tenchiso, chiso};
    }
}
