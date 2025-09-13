public class main {
	public static void main(String[] args) throws Exception {
		qlnhathuoc ql = new qlnhathuoc();
		ql.nhapTuFileText("donthuoc.txt");
		ql.xuatDanhSach();
		System.out.println("tong thu: " + ql.tongThu());

		ql.sapXepTheoTongTien();
		ql.xuatDanhSach();
		ql.lieKeDonThuocTheoBenhNhan("Nguyen Van A");
		ql.doiTenBacSiChoBenhNhan("Nguyen Van A", "Bac Si B");
		ql.themThuocVaoDon("DT01", new thuoc("Vitamin C", 3, 7000, "BD3"));
		ql.thongTinDonThuocMax();
		ql.lietKeTheoBacSi("Bac Si B");
		ql.hoaHong();
		ql.thuocBanNhieuNhat();
		ql.thongKeTheoBenhNhan();
	}
}