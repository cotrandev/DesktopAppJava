import java.util.*;

public class donThuoc {
	private String maDonThuoc;
	private String tenBenhNhan;
	private String tenBacSi;
	private List<thuoc> DSThuoc;

	public donThuoc() {
	}

	public donThuoc(String maDonThuoc, String tenBenhNhan, String tenBacSi) {
		if (maDonThuoc.length() > 10)
			throw new IllegalArgumentException("Ma don thuoc khong duoc vuot qua 10 ky tu!");
		if (tenBenhNhan.length() > 30)
			throw new IllegalArgumentException("Ten benh nhan khong duoc vuot qua 30 ky tu!");
		if (tenBacSi.length() > 30)
			throw new IllegalArgumentException("Ten bac si khong duoc vuot qua 30 ky tu!");
		this.maDonThuoc = maDonThuoc;
		this.tenBenhNhan = tenBenhNhan;
		this.tenBacSi = tenBacSi;
		this.DSThuoc = new ArrayList<>();
	}

	public void themThuoc(thuoc Thuoc) {
		DSThuoc.add(Thuoc);
	}

	public double tongTien() {
		double tong = 0;
		for (thuoc i : DSThuoc)
			tong += i.thanhTien();
		return tong;
	}

	// getter
	public String getMaDonThuoc() {
		return maDonThuoc;
	}

	public String getTenBenhNhan() {
		return tenBenhNhan;
	}

	public String getTenBacSi() {
		return tenBacSi;
	}

	public List<thuoc> getDSThuoc() {
		return DSThuoc;
	}

	// setter
	public void setMaDonThuoc(String NMaDonThuoc) {
		maDonThuoc = NMaDonThuoc;
	}

	public void setTenBenhNhan(String NTenBenhNhan) {
		tenBenhNhan = NTenBenhNhan;
	}

	public void setTenBacSi(String NTenBacSi) {
		tenBacSi = NTenBacSi;
	}

	public void setDSThuoc(List<thuoc> NDSThuoc) {
		this.DSThuoc = new ArrayList<>(NDSThuoc);
	}

	// goi them 1 phuong thuc nhap maDonThuoc
	public void updateThuoc(String tenThuocM, int soLuongM, double donGiaM, String bietDuocM) {
		for (thuoc i : DSThuoc) {
			i.setTenThuoc(tenThuocM);
			i.setSoLuong(soLuongM);
			i.setDonGia(donGiaM);
			i.setBietDuoc(bietDuocM);
		}
	}

	/*
	 * @Override
	 * public String toString() {
	 * StringBuilder sb = new StringBuilder();
	 * sd.append(String.format("%-10s %-20s %-20s %-10.2f", maDonThuoc, tenBenhNhan,
	 * tenBacSi, tongTien()));
	 * 
	 * int stt = 1;
	 * for(thuoc t: DSThuoc) {
	 * sb.append(String.format("%02d. %5\n", stt++, t.toString()));
	 * }
	 * return sb.toString();
	 * }
	 */
}