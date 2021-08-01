/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De9.Cau2;

/**
 *
 * @author Admin
 */
public class Sach {
    private String maS;
    private String tenS;
    private String nguoiMuon;

    public Sach() {
    }

    public Sach(String maS, String tenS, String nguoiMuon) {
        this.maS = maS;
        this.tenS = tenS;
        this.nguoiMuon = nguoiMuon;
    }

    public String getMaS() {
        return maS;
    }

    public void setMaS(String maS) {
        this.maS = maS;
    }

    public String getTenS() {
        return tenS;
    }

    public void setTenS(String tenS) {
        this.tenS = tenS;
    }

    public String getNguoiMuon() {
        return nguoiMuon;
    }

    public void setNguoiMuon(String nguoiMuon) {
        this.nguoiMuon = nguoiMuon;
    }

    @Override
    public String toString() {
        return "Sach{" + "maS=" + maS + ", tenS=" + tenS + ", nguoiMuon=" + nguoiMuon + '}';
    }
    
    
}
