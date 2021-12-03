package NhapSapXepTimKiemHienThiDanhSachSanPham;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class DanhSachSanPham {
	private ArrayList<SanPham> list = new ArrayList<>();

	public void Nhap() {
		int i = 1;
		System.out.println(" Nhập danh sách sản phẩm ");
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(" Nhập vào tên sản phâm thứ " + i);
			String st = sc.nextLine();
			if (st == null || st.equals("")) {
				break;
			}
			System.out.println(" Giá sản phẩm :");
			double gia = sc.nextDouble();
			list.add(new SanPham(st, gia));
			sc.nextLine();
			i++;
		} while (true);
	}

	public void HienThi() {
		System.out.println(" Danh sách sản phẩm ");
		System.out.println("Ten\t\t|Gia\t\t");
		for(SanPham sanPham : list) {
			System.out.printf("%2s\t\t|-> %.2f\n",sanPham.getTen(),sanPham.getGia());
			
		}		
	}
	public void SapXep() {
		Collections.sort(list,(a,b)->(int)(a.getGia()-b.getGia()));
		System.out.println(" Danh sách sau khi sắp xếp :");
		HienThi();
	}
	public void TimKiem() {
		Scanner s = new Scanner(System.in);
		System.out.println(" Nhập tên sản phẩm cần tìm và xóa :");
		String ten = s.nextLine();
		SanPham found= null;
		for(SanPham sanPham : list) {
			if(sanPham.getTen().equals(ten)) {
				found = sanPham;
				break;
			}
		}
		if(found!=null) {
			list.remove(found);
			System.out.println("Sản phẩm đã được xóa khỏi danh sách !!");
			HienThi();
		}
		else {
			System.out.println(" Không tìm thấy sản phẩm !!!");
		}
	}
	public void TinhGiaTB() {
		double avg=0, sum=0;
	 for(SanPham samPham :list) {
		 sum+=samPham.getGia();
	 }
	 avg=(double)sum/list.size();
	 System.out.println(" Giá tiền trung bình là :"+avg);
	}
	public void menu() {
		do {
		System.out.println("**********************************");
		System.out.println("*       MENU CHƯƠNG TRÌNH         *");
		System.out.println("* 1. Nhập sản phẩm                *");
		System.out.println("* 2. Xuất sản phẩm                *");
		System.out.println("* 3. Sắp xếp sản phẩm theo giá    *");
		System.out.println("* 4. Tìm kiếm và xóa  sản phẩm    *");
		System.out.println("* 5. Tính giá tiền trung bình     *");
		System.out.println("* 6. Thoát                        *");
		System.out.println("***********************************");
		System.out.println(" Nhập lựa chọn của bạn :");
		int luachon;
		Scanner scanner = new Scanner(System.in);
		luachon=scanner.nextInt();
		switch (luachon) {
		case 1: Nhap();break;
		case 2: HienThi();break;
		case 3: SapXep();break;
		case 4: TimKiem();break;
		case 5: TinhGiaTB();break;
		case 6: System.exit(0);break;
		default: System.out.println(" Vui lòng nhập đúng trong menu");
			
		}		
		}
		while (true);
	}
}
