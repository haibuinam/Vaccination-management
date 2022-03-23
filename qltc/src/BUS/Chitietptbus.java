package BUS;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAL.PhieuTiemDAL;
import DAL.ChitietptDAL;
import DTO.ChiTieuPMDTO;
import DTO.PhieuTiem;
import GUI.MainFrame;

public class Chitietptbus {
			
	ChiTieuPMDTO pmdal = new ChiTieuPMDTO(); 
	private ArrayList<PhieuTiem> listpm = new ArrayList<PhieuTiem>();

	public ArrayList<ChiTieuPMDTO> getdanhsachpm() {
		return ChitietptDAL.getdanhsachphieumuon();
	}
	public ArrayList<ChiTieuPMDTO> thongkephieumuon() {

		return ChitietptDAL.thongkephieumuon();
	}

	public int themctpm(ChiTieuPMDTO pm) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			if (!kiemtrasoluongphieumuon(pm.getMaPhieuMuon())) {
				JOptionPane.showMessageDialog(null, "Bạn không được chọn quá 5");
				return 2;
			}
			if(pm.getMaSach()< 0 ) {
				JOptionPane.showMessageDialog(null, "Mã Vaccine không được bỏ trống");
				return -1;
			}
			if(sdf.parse(pm.getNgayTra()).before(sdf.parse(pm.getNgayMuon()))) {
				JOptionPane.showMessageDialog(null, "Ngày trả không được bé hơn ngày mượn");
				return -1;
			}
			if(sdf.parse(pm.getNgayMuon()).after(sdf.parse(pm.getNgayTra()))) {
				JOptionPane.showMessageDialog(null, "Ngày mượn không được lớn hơn ngày trả");
				return -1;
			}
			if(ChitietptDAL.themctpm(pm) > 0) {
				JOptionPane.showMessageDialog(null, "Thêm chi tiết thành công");
				return 1;
			}
			JOptionPane.showMessageDialog(null, "Thêm chi tiết thất bại");
			return -1;
		
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}	
	}

	public int suactpm(ChiTieuPMDTO pm) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			if (!kiemtrasoluongphieumuon(pm.getMaPhieuMuon())) {
				JOptionPane.showMessageDialog(null, "quá 5");
				return 2;
			}
			if(pm.getMaSach()< 0 ) {
				JOptionPane.showMessageDialog(null, "Mã Vaccine không được bỏ trống");
				return -1;
			}
			if(sdf.parse(pm.getNgayTra()).before(sdf.parse(pm.getNgayMuon()))) {
				JOptionPane.showMessageDialog(null, "Ngày tiêm không được bé hơn ngày theo dõi");
				return -1;
			}
			if(sdf.parse(pm.getNgayMuon()).after(sdf.parse(pm.getNgayTra()))) {
				JOptionPane.showMessageDialog(null, "Ngày theo dõi không được lớn hơn ngày tiêm");
				return -1;
			}
			if(ChitietptDAL.suactpm(pm) > 0) {
				JOptionPane.showMessageDialog(null, "Sửa chi tiết thành công");
				return 1;
			}
			JOptionPane.showMessageDialog(null, "Sửa chi tiết thất bại");
			return -1;
		
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}	
	}

	public int xoactpm(ChiTieuPMDTO pm) {
		if(ChitietptDAL.xoactpm(pm) > 0) {
			JOptionPane.showMessageDialog(null, "Xoá chi tiết thành công");
			return 1;
		}
		JOptionPane.showMessageDialog(null, "Xoá chi tiết thất bại");
		return -1;
	}
	
	public int getsoluongsachdamuon() {
		return ChitietptDAL.getsoluongsachdamuon();
		
	}
	
	public static Chitietptbus iBus = null;

	public static Chitietptbus gI() {
		if (iBus == null) {
			iBus = new Chitietptbus();
		}

		return iBus;
	}
	protected boolean kiemtrasoluongphieumuon(int PM) {
		int i = 0;
		for (ChiTieuPMDTO ctpm : MainFrame.ctpm) {
			if (ctpm.getMaPhieuMuon() == PM) {
				System.out.println(ctpm.getMaPhieuMuon());
				i++;
			}
			if (i > 5) {
				// JOptionPane.showMessageDialog(null, "Bạn không được mượn quá 5 ");
				return false;

			}

		}
		return true;
	}
}
