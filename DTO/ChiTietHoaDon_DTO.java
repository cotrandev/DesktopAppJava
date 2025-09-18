package DTO;

public class ChiTietHoaDon_DTO {
    private int maHD, maSP, soLuong;
    private String maSize, tenSP;
    private double donGia, thanhTien;

    public ChiTietHoaDon_DTO() {
    }

    public ChiTietHoaDon_DTO(int maSP, int soLuong, String maSize, String tenSP, double donGia,
            double thanhTien) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maSize = maSize;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public ChiTietHoaDon_DTO(int maHD, int maSP, int soLuong, String maSize, String tenSP, double donGia,
            double thanhTien) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.maSize = maSize;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
    }

    public ChiTietHoaDon_DTO(int maHD, int maSP, int soLuong, String maSize, double donGia) {
        this.maHD = maHD;
        this.maSP = maSP;
        this.maSize = maSize;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.thanhTien = soLuong * donGia;
    }

    // getter
    public int getMaHD() {
        return maHD;
    }

    public int getMaSP() {
        return maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public String getMaSize() {
        return maSize;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    // setter
    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

}
