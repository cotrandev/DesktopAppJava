package DTO;

import java.time.LocalDateTime;

public class MGG_DTO {
    private int maMGG;
    private float phanTramGiam;
    private LocalDateTime ngayBatDau, ngayKetThuc;
    private String trangThai;

    public MGG_DTO() {
    }

    public MGG_DTO(int maMGG, float phanTramGiam, LocalDateTime ngayBD, LocalDateTime ngayKT, String trangThai) {
        this.maMGG = maMGG;
        this.phanTramGiam = phanTramGiam;
        this.ngayBatDau = ngayBD;
        this.ngayKetThuc = ngayKT;
        this.trangThai = trangThai;
    }

    public int getMaGG() {
        return maMGG;
    }

    public float getPhanTramGiam() {
        return phanTramGiam;
    }

    public LocalDateTime getNgayBatDau() {
        return ngayBatDau;
    }

    public LocalDateTime getNgayKetThuc() {
        return ngayKetThuc;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setMaGG(int maGG) {
        this.maMGG = maGG;
    }

    public void setPhanTramGiam(float phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public void setNgayBatDau(LocalDateTime ngayBD) {
        this.ngayBatDau = ngayBD;
    }

    public void setMaGG(LocalDateTime ngayKT) {
        this.ngayKetThuc = ngayKT;
    }

    public void setMaGG(String trangThai) {
        this.trangThai = trangThai;
    }

}