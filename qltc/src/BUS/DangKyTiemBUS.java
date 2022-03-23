package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.DangKyTiemDAL;

import DTO.DangKyTiemDTO;

public class DangKyTiemBUS {
	private ArrayList<DangKyTiemDTO> listncc = new ArrayList<DangKyTiemDTO>();
	DangKyTiemDAL tg = new DangKyTiemDAL(); 
	public ArrayList<DangKyTiemDTO> getdanhsachtacgia() {

		return DangKyTiemDAL.getdanhsachtacgia();
	}
	public void showmess(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
	public int themtacgia(DangKyTiemDTO tacgia) {
		if(tacgia.getTenTacGia().isEmpty()) {
			showmess("không được để trống");
			return -1;
		}
		if(tacgia.getNamSinh().isEmpty()) {
			showmess("không được để trống");
			return -1;
		}
		if(tacgia.getQueQuan().isEmpty()) {
			showmess("không được để trống");
			return -1;
		}
		if(DangKyTiemDAL.themtacgia(tacgia) > 0) {
			showmess("Thêm thành công");
			return 1;
		}
		showmess("Thêm thất bại");
		return -1;
	}

	public int suatacgia(DangKyTiemDTO tacgia) {
		if(tacgia.getTenTacGia().isEmpty()) {
			showmess(" không được để trống");
			return -1;
		}
		if(tacgia.getNamSinh().isEmpty()) {
			showmess(" không được để trống");
			return -1;
		}
		if(tacgia.getQueQuan().isEmpty()) {
			showmess(" không được để trống");
			return -1;
		}
		if(DangKyTiemDAL.suatacgia(tacgia) > 0) {
			showmess("Sửa thành công");
			return 1;
		}
		showmess("Sửa thất bại");
		return -1;
	}

	public int xoatacgia(DangKyTiemDTO tacgia) {
		if(DangKyTiemDAL.xoatacgia(tacgia) > 0) {
			showmess("Xoa thành công");
			return 1;
		}
		showmess("Xoá thất bại");
		return -1;
	}
	public DangKyTiemDTO timtacgia(int ma) {
		return tg.timtacgia(ma); 
		
	}
	public static DangKyTiemBUS iBus = null;

	public static DangKyTiemBUS gI() {
		if (iBus == null) {
			iBus = new DangKyTiemBUS();
		}

		return iBus;
	}
}
