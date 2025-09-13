import java.util.*;
import java.io.*; //BufferedReader

public class qlnhathuoc {
	private List<donThuoc> DSDonThuoc;

	public qlnhathuoc() {
		DSDonThuoc = new ArrayList<>();
	}

	// nhap danh sach don thuoc tu file text
	public void nhapTuFileText(String fileName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		donThuoc current = null;
		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.startsWith("DONTHUOC")) {
				String[] parts = line.split(",");
				current = new donThuoc(parts[1], parts[2], parts[3]);
				DSDonThuoc.add(current);
			} else if (line.startsWith("THUOC") && current != null) {
				String[] parts = line.split(",");
				thuoc t = new thuoc(parts[1], Integer.parseInt(parts[2]), Double.parseDouble(parts[2]), parts[4]);
				current.themThuoc(t);
			}
		}
		br.close();
	}

	// xuat thong tin ra man hinh
	public void xuatDanhSach() {
		int stt = 1;
		for (donThuoc d : DSDonThuoc) {
			System.out.printf("%d. %-10s %-20s %-20s %.2f\n", stt++, d.getMaDonThuoc(), d.getTenBenhNhan(),
					d.getTenBacSi(), d.tongTien());
			int sttT = 1;
			for (thuoc t : d.getDSThuoc()) {
				System.out.printf("	%d. %-20s %-15s %-5s %-10.2f %10.2f\n", sttT++, t.getTenThuoc(),
						t.getBietDuoc(), t.getSoLuong(), t.getDonGia(), t.thanhTien());
			}
		}
	}

	// tinh tong tien thu duoc
	public double tongThu() {
		double sum = 0;
		for (donThuoc d : DSDonThuoc)
			sum += d.tongTien();
		return sum;
	}

	// sap xep theo tong tien
	public void sapXepTheoTongTien() {
		DSDonThuoc.sort(Comparator.comparingDouble(donThuoc::tongTien));
		/*
		 * Comparator là một interface dùng để định nghĩa cách so sánh 2 đối tượng.
		 * Comparator.comparingDouble(...) là hàm dựng sẵn giúp tạo comparator để so
		 * sánh các đối tượng dựa trên một giá trị double nào đó.
		 * Nó cần một function trả về double.
		 * 
		 * 3. donThuoc::tongTien
		 * Đây là cú pháp method reference trong Java.
		 * Nó tương đương với d -> d.tongTien().
		 * Nghĩa là: lấy mỗi đối tượng donThuoc trong danh sách, gọi phương thức
		 * tongTien() để lấy giá trị double.
		 */
	}

	// liet ke don thuoc cua benh nhan X
	public void lieKeDonThuocTheoBenhNhan(String ten) {
		for (donThuoc d : DSDonThuoc) {
			if (d.getTenBenhNhan().equalsIgnoreCase(ten)) // equalsIgnoreCase không phân biệt hoa thưởng
				System.out.println("Ma: " + d.getMaDonThuoc() + ", tong tien: " + d.tongTien());
		}
	}

	// dieu chinh ten bac si
	public void doiTenBacSiChoBenhNhan(String tenBN, String tenBS) {
		for (donThuoc d : DSDonThuoc) {
			if (d.getTenBenhNhan().equalsIgnoreCase(tenBN))
				d.setTenBacSi(tenBS);
		}
	}

	// them thuoc vao don thuoc co ma X
	public void themThuocVaoDon(String maDon, thuoc t) {
		for (donThuoc d : DSDonThuoc) {
			if (d.getMaDonThuoc().equalsIgnoreCase(maDon))
				d.themThuoc(t);
		}
	}

	// xoa cac don thuoc ma benh nhan X da mua
	public void xoaDonThuocCuaBenhNhan(String tenBN) {
		DSDonThuoc.removeIf(t -> t.getTenBenhNhan().equalsIgnoreCase(tenBN));
	}

	// Don thuoc co nhieu loai thuoc nhat va co tong tien cao nhat
	public void thongTinDonThuocMax() {
		donThuoc maxThuoc = Collections.max(DSDonThuoc, Comparator.comparingInt(d -> d.getDSThuoc().size()));
		donThuoc maxTien = Collections.max(DSDonThuoc, Comparator.comparingDouble(donThuoc::tongTien));
		System.out.println("Don thuoc co nhieu thuoc nhat: " + maxThuoc.getMaDonThuoc());
		System.out.println("Don thuoc co tong tien cao nhat: " + maxTien.getMaDonThuoc());
	}

	// liet ke cac don thuoc cua bac si Y
	public void lietKeTheoBacSi(String tenBS) {
		for (donThuoc d : DSDonThuoc) {
			if (d.getTenBacSi().equalsIgnoreCase(tenBS))
				System.out.println("Ma: " + d.getMaDonThuoc() + ", Benh nhan: " + d.getTenBenhNhan());
		}
	}

	// tinh hoa hong
	public void hoaHong() {
		for (donThuoc d : DSDonThuoc) {
			double tong = d.tongTien();
			double hh;
			if (tong < 1000)
				hh = tong * 0.1;
			else if (tong > 1000 && tong <= 10000)
				hh = tong * 0.08;
			else
				hh = tong * 0.05;
			System.out.println("Don " + d.getMaDonThuoc() + ", hoa hong: " + hh);
		}
	}

	// loai don thuoc ban nhieu nhat
	public void thuocBanNhieuNhat() {
		Map<String, Integer> map = new HashMap<>();
		/*
		 * 👉 Tạo một HashMap với:
		 * String: tên thuốc (t.getTenThuoc()).
		 * Integer: tổng số lượng bán ra của thuốc đó.
		 */
		for (donThuoc d : DSDonThuoc) {
			for (thuoc t : d.getDSThuoc())
				map.put(t.getTenThuoc(), map.getOrDefault(t.getTenThuoc(), 0) + t.getSoLuong());
			/*
			 * Nếu map đã có thuốc này thì lấy số lượng cũ.
			 * Nếu chưa có thì mặc định là 0.
			 * Sau đó cộng thêm số lượng t.getSoLuong() vừa bán.
			 */
		}
		String maxThuoc = null;
		int maxSL = 0;
		for (var e : map.entrySet()) {
			// map.entrySet() trả về tập hợp các cặp (key, value).
			// Với mỗi cặp (tên thuốc, tổng số lượng):
			if (e.getValue() > maxSL) {
				maxSL = e.getValue();
				maxThuoc = e.getKey();
			}
		}
		System.out.println("Thuoc ban nhieu nhat: " + maxThuoc + ", so luong: " + maxSL);
	}
	/*
	 * 1. Kiến thức về Map
	 * Map<K, V> là một cấu trúc dữ liệu ánh xạ (key → value).
	 * K (Key): khóa, duy nhất.
	 * V (Value): giá trị, có thể trùng lặp.
	 * Bạn có thể hiểu Map giống như một cái từ điển:
	 * Mỗi từ (key) ánh xạ đến một nghĩa (value).
	 * Nếu thêm key trùng → giá trị cũ sẽ bị thay thế.
	 * 
	 * vd:
	 * Map<String, Integer> map = new HashMap<>();
	 * map.put("Paracetamol", 10); // thuốc Paracetamol bán 10 viên
	 * map.put("Aspirin", 5); // thuốc Aspirin bán 5 viên
	 * System.out.println(map.get("Paracetamol")); // 10
	 * System.out.println(map.getOrDefault("Amoxicillin", 0)); // 0 (vì chưa có thì
	 * trả mặc định)
	 * 
	 */

	// thong ke theo benh nhan
	public void thongKeTheoBenhNhan() {
		Map<String, Double> tienMap = new HashMap<>();
		Map<String, Integer> soDonMap = new HashMap<>();
		for (donThuoc d : DSDonThuoc) {
			tienMap.put(d.getTenBenhNhan(), tienMap.getOrDefault(d.getTenBenhNhan(), 0.0) + d.tongTien());
			soDonMap.put(d.getTenBenhNhan(), soDonMap.getOrDefault(d.getTenBenhNhan(), 0) + 1);
		}
		for (String bn : tienMap.keySet()) {
			System.out.println(bn + " - so don: " + soDonMap.get(bn) + " - tong tien: " + tienMap.get(bn));
		}
	}
}