package BUS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAL.PhieuTiemDAL;

import DTO.PhieuTiem;


public class PhieuTiemBus {
	PhieuTiemDAL pmdal = new PhieuTiemDAL();
	private ArrayList<PhieuTiem> listpm = new ArrayList<PhieuTiem>();

	public ArrayList<PhieuTiem> getdanhsachpm() {

		return listpm = pmdal.getdanhsachphieumuon();
	}

	public void showmess(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	public int thempm(PhieuTiem pm) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			
			if(pm.getMaNV() < 0) {
				showmess("Mã nhân viên sai");
				return -1;
			}
			if(sdf.parse(pm.getNgayMuon()).after(date) ) {
				showmess("Ngày mượn sai");
				return -1;
			}
			if(PhieuTiemDAL.thempm(pm) > 0) {
				showmess("Đã thêm phiếu tiêm thành công");
				return 1;
			}
			showmess("Đã thêm phiếu tiêm thất bại");
			return -1;
			
		} catch (Exception e) {
			return -1;
		}
	}

	public int suapm(PhieuTiem pm) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			
			if(pm.getMaNV() < 0) {
				showmess("Mã nhân viên sai");
				return -1;
			}
			if(sdf.parse(pm.getNgayMuon()).after(date) ) {
				showmess("Ngày tiêm sai");
				return -1;
			}
			if(PhieuTiemDAL.suapm(pm) > 0) {
				showmess("Đã sửa phiếu Tiêm thành công");
				return 1;
			}
			showmess("Đã sửa phiếu Tiêm thất bại");
			return -1;
			
		} catch (Exception e) {
			return -1;
		}
	}

	public int xoapm(PhieuTiem pm) {
		if(PhieuTiemDAL.xoapm(pm) > 0) {
			showmess("Đã xoá phiếu Tiêm thành công");
			return 1;
		}
		showmess("Đã xoa phiếu tiêm thất bại");
		return -1;
	}

	public PhieuTiem timphieumuon(int ma) {
		if(ma > 0 ) {
			return pmdal.timphieumuon(ma);
		}
		return null;
	}

	public static PhieuTiemBus iBus = null;

	public static PhieuTiemBus gI() {
		if (iBus == null) {
			iBus = new PhieuTiemBus();
		}

		return iBus;
	}
}
