package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAL.NhaCungCapDAL;
import DAL.NhaSanXuatDAL;
import DTO.NhaCungCapDTO;
import DTO.NhaSanXuat;

public class NhaSanXuatBUS {
	public void showmess(String s) {
		JOptionPane.showMessageDialog(null, s);
	}
	private ArrayList<NhaSanXuat> listncc = new ArrayList<NhaSanXuat>();

	public ArrayList<NhaSanXuat> getdanhsachnxb() {

		return NhaSanXuatDAL.getdanhnxb();
	}
	
	public int themnxb(NhaSanXuat nxb) {
		if(nxb.getTenNXB().isEmpty()) {
			showmess("Không được để trống tên nsx");
			return -1 ;
		}
		if(nxb.getDiaChi().isEmpty()) {
			showmess("Không được để trống địa chỉ");
			return -1;
		}
		if(nxb.getSdt().isEmpty()) {
			showmess("Không được để trống số điện thoại");
			return -1;
		}
		if(NhaSanXuatDAL.themnxb(nxb) > 0) {
			showmess("Thêm thành công");
			return 1;
		}
		showmess("Thêm thất bại");
		return -1;
	}

	public int suanxb(NhaSanXuat nxb) {
		if(nxb.getTenNXB().isEmpty()) {
			showmess("Không được để trống tên nsx");
			return -1 ;
		}
		if(nxb.getDiaChi().isEmpty()) {
			showmess("Không được để trống địa chỉ");
			return -1;
		}
		if(nxb.getSdt().isEmpty()) {
			showmess("Không được để trống số điện thoại");
			return -1;
		}
		if(NhaSanXuatDAL.suanxb(nxb) > 0) {
			showmess("Sửa thành công");
			return 1;
		}
		showmess("Sửa thất bại");
		return -1;
	}

	public int xoanxb(NhaSanXuat nxb) {
		if(NhaSanXuatDAL.xoanxb(nxb) > 0) {
			showmess("Xoá thành công");
			return 1;
		}
		showmess("Xoá thất bại");
		return -1;
	}

	public static NhaSanXuatBUS gI() {
		return new NhaSanXuatBUS();
	}

	public NhaSanXuat timnxb(int ma) {

		return new NhaSanXuatDAL().timnxb(ma);
	}
}
