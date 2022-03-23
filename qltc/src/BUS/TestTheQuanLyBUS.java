package BUS;

import java.util.ArrayList;

import DAL.DangKyTiemDAL;
import DAL.TestTheQuanLyDAL;
import DTO.DangKyTiemDTO;
import DTO.TestTheQuanLyDTO;

public class TestTheQuanLyBUS {
	private ArrayList<TestTheQuanLyDTO> listncc = new ArrayList<TestTheQuanLyDTO>();
	TestTheQuanLyDAL tg = new TestTheQuanLyDAL(); 
	public ArrayList<TestTheQuanLyDTO> getdanhsachth() {

		return tg.getdanhsachthethuvien();
	}

	public int themtacgia(TestTheQuanLyDTO tacgia) {
		return tg.themthetv(tacgia); 
	}

	public int suatacgia(TestTheQuanLyDTO tacgia) {
		return tg.suanthethuvien(tacgia)
;	}

	public int xoatacgia(TestTheQuanLyDTO tacgia) {
		return tg.xoathethuvien(tacgia);
	}
	public TestTheQuanLyDTO timtacgia(int ma) {
		return tg.timthethuvien(ma);
		
	}
	public static TestTheQuanLyBUS iBus = null;

	public static TestTheQuanLyBUS gI() {
		if (iBus == null) {
			iBus = new TestTheQuanLyBUS();
		}

		return iBus;
	}
	public int giahanthe(int mathe, String ngayketthuc) {
		return tg.giahanthe(mathe, ngayketthuc);
		
	}
}
