/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De6.Cau2;

/**
 *
 * @author Admin
 */
public class Nha {
    private int soNha;
    private float giaBan;
    private String tinhTrang;

    public Nha() {
    }

    public Nha(int soNha, float giaBan, String tinhTrang) {
        this.soNha = soNha;
        this.giaBan = giaBan;
        this.tinhTrang = tinhTrang;
    }

    public int getSoNha() {
        return soNha;
    }

    public void setSoNha(int soNha) {
        this.soNha = soNha;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "Nha{" + "soNha=" + soNha + ", giaBan=" + giaBan + ", tinhTrang=" + tinhTrang + '}';
    }
    
}
