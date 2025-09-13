public class thuoc {
	private String tenThuoc;
	private int soLuong;
	private double donGia;
	private String bietDuoc;

	public thuoc() {
	}

	public thuoc(String tenThuoc, int soLuong, double donGia, String bietDuoc) {
		if (tenThuoc.length() > 30)
			throw new IllegalArgumentException("Ten thuoc khong duoc vuot qua 30 ky tu!");
		if (bietDuoc.length() > 15)
			throw new IllegalArgumentException("Ten biet duoc khong duoc vuot qua 15 ky tu!");
		this.tenThuoc = tenThuoc;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.bietDuoc = bietDuoc;
	}

	public double thanhTien() {
		return soLuong * donGia;
	}

	// getter
	public String getTenThuoc() {
		return tenThuoc;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public String getBietDuoc() {
		return bietDuoc;
	}

	// setter
	public void setTenThuoc(String tenThuocMoi) {
		tenThuoc = tenThuocMoi;
	}

	public void setSoLuong(int soLuongMoi) {
		soLuong = soLuongMoi;
	}

	public void setDonGia(double donGiaMoi) {
		donGia = donGiaMoi;
	}

	public void setBietDuoc(String bietDuocMoi) {
		bietDuoc = bietDuocMoi;
	}

	/*
	 * @Override
	 * public String toString() {
	 * return String.format("%-20s %-15s %-10d %-10.2f %-10.2f", tenThuoc, bietDuoc,
	 * soLuong, donGia, thanhTien());
	 * }
	 */
}
