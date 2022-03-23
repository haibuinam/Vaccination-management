package BUS;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import DTO.VaccineDTO;
import DAL.VaccineDAL;

public class VaccineBus {
	private VaccineDAL SachDAL = new VaccineDAL();
	private ArrayList<VaccineDTO> listloai = new ArrayList<VaccineDTO>();

	public void showmess(String s) {
		JOptionPane.showMessageDialog(null, s);
	}

	public ArrayList<VaccineDTO> getLoaisachLoai() {

		return DAL.VaccineDAL.getdanhsachLoai();
	}

	public int themsach(VaccineDTO pm) {
		Date d = new Date();
		int year = d.getYear() + 1900;
		if (pm.getTensach().isEmpty()) {
			showmess("Không được để trống tên Vaccine");
			return -1;
		}
		if (pm.getSoluong() <= 0) {
			showmess("Số lượng Vaccine phải lớn hơn 0");
			return -1;
		}
		if (pm.getNamxb() > year) {
			showmess("Năm sản xuất Vaccine sai");
			return -1;
		}
		if (pm.getMatacgia() < 0) {
			showmess("Mã tác giả sai");
			return -1;
		}
		if (pm.getHinhanh().isEmpty()) {
			showmess("Bạn chưa chọn hình ảnh");
			return -1;
		}
		if (SachDAL.themsach(pm) > 0) {
			showmess("Đã thêm Vaccine thành công");
			return 1;
		}
		showmess("Thêm Vaccine thât bại");
		return -1;
	}

	public int suasach(VaccineDTO pm) {
		Date d = new Date();
		int year = d.getYear() + 1900;
		if (pm.getTensach().isEmpty()) {
			showmess("Không được để trống tên Vaccine");
			return -1;
		}
		if (pm.getSoluong() <= 0) {
			showmess("Số lượgn Vaccine phải lớn hơn 0");
			return -1;
		}
		if (pm.getNamxb() > year) {
			showmess("Năm sản xuất sai");
			return -1;
		}
		if (pm.getMatacgia() < 0) {
			showmess("Mã tác giả sai");
			return -1;
		}
		if (pm.getHinhanh().isEmpty()) {
			showmess("Bạn chưa chọn hình ảnh");
			return -1;
		}
		if (SachDAL.suasach(pm) > 0) {
			showmess("Đã sửa Vaccine thành công");
			return 1;
		}
		showmess("Sửa Vaccine thât bại");
		return -1;
	}

	public int xoasach(VaccineDTO pm) {
		if (SachDAL.xoasach(pm) > 0) {
			showmess("Đã Xoá Vaccine thành công");
			return 1;
		}
		showmess("Xoá Vaccine thât bại");
		return -1;
	}

	public int soluongsach() {
		return SachDAL.getsoluongallsach();
	}

	public VaccineDTO timsach(int ma) {
		return SachDAL.timsach(ma);

	}

	public static VaccineBus iBus = null;

	public static VaccineBus gI() {
		if (iBus == null) {
			iBus = new VaccineBus();
		}

		return iBus;
	}

}
