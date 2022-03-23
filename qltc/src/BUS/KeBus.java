package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.KeDAL;
import DAL.NhaCungCapDAL;
import DTO.KeDTO;
import DTO.NhaCungCapDTO;
import GUI.MainFrame;

public class KeBus {
	KeDAL keSachDAL = new KeDAL();

	public ArrayList<KeDTO> getdanhsachke() {

		return KeDAL.getdanhsachke();
	}

	public int themke(KeDTO kesach) {
		for (KeDTO ke2 : getdanhsachke()) {
			if (ke2.getViTri().equals(kesach.getViTri())) {
				JOptionPane.showMessageDialog(null, "Kệ đã có");
				return -1 ;
			}
		}
		if(kesach.getViTri().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống");
			return -1;
		}
		if( keSachDAL.themkesach(kesach) > 0 ) {
			JOptionPane.showMessageDialog(null, "Thêm thành công");
			return 1;
		}
		JOptionPane.showMessageDialog(null, "Thêm thất bại");
		return -1;
		//return keSachDAL.themkesach(kesach);
	}

	public int suake(KeDTO kesach) {
		if(kesach.getViTri().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Không được để trống");
			return -1;
		}
		for (KeDTO ke2 : getdanhsachke()) {
			if (ke2.getViTri().equals(kesach.getViTri())) {
				JOptionPane.showMessageDialog(null, "Kệ đã có");
				return -1 ;
			}
		}
		if(KeDAL.suakesach(kesach) > 0) {
			JOptionPane.showMessageDialog(null, "Sửa thành công");
			return 1;
		}
		return -1;
	}

	public int xoake(KeDTO kesach) {
		if(keSachDAL.xoakesach(kesach) > 0) {
			JOptionPane.showMessageDialog(null, "Xoá thành công");
			return 1;
		}
		return -1;
	}
	
	public static KeBus gI() {
		return new KeBus();
	}
}
