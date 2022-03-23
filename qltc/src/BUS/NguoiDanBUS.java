package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.NguoiDanDAL;
import DTO.NguoiDan;
import DTO.DangKyTiemDTO;

public class NguoiDanBUS {
	NguoiDanDAL docgia = new NguoiDanDAL();

	public static NguoiDanBUS docgia1 = null;

	public static NguoiDanBUS gI() {
		if (docgia1 == null) {
			docgia1 = new NguoiDanBUS();
		}
		return docgia1;
	}
	public void showmess(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
	public boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public ArrayList<NguoiDan> getdanhsachdocgia() {

		return docgia.getdanhsachdocgia();
	}
	

	public int themdocgia(NguoiDan docgia) {
		if(docgia.getTenDocGia().isEmpty()) {
			showmess("Không được bỏ trống tên người dân");
			return -1;
		}
		if(docgia.getDiachi().isEmpty()) {
			showmess("Không được bỏ trống địa chỉ");
			return -1;
		}
		if(docgia.getSdt().isEmpty()) {
			showmess("Số điện thoại không được bỏ trống");
			return -1;
		}
		if(!isNumber(docgia.getSdt())) {
			showmess("Số điện thoại phải là số , không được nhập chữ");
			return -1;
		}
		if(docgia.getGioiTinh().isEmpty()) {
			showmess("Giới tính không được bỏ trống");
			return -1;
		}
		if(NguoiDanDAL.themdocgia(docgia) > 0 ) {
			showmess("Thêm người dân thành công");
			return 1;
		}
		showmess("Thêm người dân thất bại");
		return -1;

	}

	public int suadocgia(NguoiDan docgia) {
		if(docgia.getTenDocGia().isEmpty()) {
			showmess("Không được bỏ trống tên người dân");
			return -1;
		}
		if(docgia.getDiachi().isEmpty()) {
			showmess("Không được bỏ trống địa chỉ");
			return -1;
		}
		if(docgia.getSdt().isEmpty()) {
			showmess("Số điện thoại không được bỏ trống");
			return -1;
		}
		if(!isNumber(docgia.getSdt())) {
			showmess("Số điện thoại phải là số , không được nhập chữ");
			return -1;
		}
		if(docgia.getGioiTinh().isEmpty()) {
			showmess("Giới tính không được bỏ trống");
			return -1;
		}
		if(NguoiDanDAL.suadocgia(docgia) > 0 ) {
			showmess("Sửa người dân thành công");
			return 1;
		}
		showmess("Sửa người dân thất bại");
		return -1;
	}

	public int xoadocgia(NguoiDan docgia) {
		if(NguoiDanDAL.xoadocgia(docgia) > 0 ) {
			showmess("Xoá người dân thành công");
			return 1;
		}
		showmess("Xoá người dân thất bại");
		return -1;

	}

	public NguoiDan timdocgia(int ma) {
		return docgia.timdocgia(ma);
	}

}
