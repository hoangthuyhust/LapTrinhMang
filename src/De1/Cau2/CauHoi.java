/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De1.Cau2;

/**
 *
 * @author Admin
 */
public class CauHoi {
    private String cauHoi;
    private String luaChon;
    private String dapAn;

    public CauHoi() {
    }

    public CauHoi(String cauHoi, String luaChon, String dapAn) {
        this.cauHoi = cauHoi;
        this.luaChon = luaChon;
        this.dapAn = dapAn;
    }

    public String getCauHoi() {
        return cauHoi;
    }

    public void setCauHoi(String cauHoi) {
        this.cauHoi = cauHoi;
    }

    public String getLuaChon() {
        return luaChon;
    }

    public void setLuaChon(String luaChon) {
        this.luaChon = luaChon;
    }

    public String getDapAn() {
        return dapAn;
    }

    public void setDapAn(String dapAn) {
        this.dapAn = dapAn;
    }

    @Override
    public String toString() {
        return "CauHoi{" + "cauHoi=" + cauHoi + ", luaChon=" + luaChon + ", dapAn=" + dapAn + '}';
    }
    
    
}
