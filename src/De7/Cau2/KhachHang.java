/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De7.Cau2;

/**
 *
 * @author Admin
 */
public class KhachHang {
    private String maKH;
    private String tenKH;
    private String loaiP;

    public KhachHang() {
    }

    public KhachHang(String maKH, String tenKH, String loaiP) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.loaiP = loaiP;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getLoaiP() {
        return loaiP;
    }

    public void setLoaiP(String loaiP) {
        this.loaiP = loaiP;
    }
    public float tinhTien(float n){
        float tien=0;
        if(loaiP.equalsIgnoreCase("A")){
            tien=250000*n;
        }else if(loaiP.equalsIgnoreCase("B")){
            tien=100000*n;
        }else{
            tien=500000*n;
        }
        return tien;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", loaiP=" + loaiP +  '}';
    }
    
    
}
