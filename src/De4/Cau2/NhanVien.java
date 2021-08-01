/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De4.Cau2;

/**
 *
 * @author Admin
 */
public class NhanVien {
    private String hoTen;
    private String ngaySinh;
    private String chucDanh;

    public NhanVien() {
    }

    public NhanVien(String hoTen, String ngaySinh, String chucDanh) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.chucDanh = chucDanh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getChucDanh() {
        return chucDanh;
    }

    public void setChucDanh(String chucDanh) {
        this.chucDanh = chucDanh;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", chucDanh=" + chucDanh + '}';
    }
    
    
}
