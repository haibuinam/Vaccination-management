package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.ChiTieuPMDTO;
import DTO.NhaSanXuat;
import DTO.PhieuTiem;

public class PhieuTiemDAL {
	public static ArrayList<PhieuTiem> getdanhsachphieumuon() {
		try {
			String sql = "select * from phieutiem where trangthai = 1";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<PhieuTiem> dsl = new ArrayList<PhieuTiem>();
			while (rs.next()) {

				PhieuTiem pm = new PhieuTiem();
				pm.setMaPhieuMuon(rs.getInt(1));
				pm.setMaNV(rs.getInt(2));
				pm.setMaDocGia(rs.getInt(3));
				pm.setNgayMuon(rs.getString(4));
				pm.setTinhtrang(rs.getString(5));
				dsl.add(pm);

			}

			return dsl;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// @SuppressWarnings("null")
	public static int thempm(PhieuTiem ke) {
		int i = -1;
		String sql = "insert into phieutiem (manv,MaNguoiDan,NgayTiem,TinhTrang,Trangthai) values(?,?,?,?,?)";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaNV());
			pstm.setInt(2, ke.getMaDocGia());
			pstm.setString(3, ke.getNgayMuon());
			pstm.setString(4, ke.getTinhtrang());
			pstm.setInt(5, 1);
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static ArrayList<ChiTieuPMDTO> listctpm(int ke) {
		try {
			Connection conn = DBConnect.getConnection();
			////nghi ngờ chitietphieumuon
			String sql2 = "SELECT * FROM `chitietphieutiem` WHERE mapt = ?";
			ArrayList<ChiTieuPMDTO> list = new ArrayList<ChiTieuPMDTO>();
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, ke);
			ResultSet rs = pstm2.executeQuery();

			while (rs.next()) {
				ChiTieuPMDTO pm = new ChiTieuPMDTO();
				pm.setMaChiTietPhieuMuon(rs.getInt(1));
				pm.setMaPhieuMuon(rs.getInt(2));
				pm.setMaSach(rs.getInt(3));
				list.add(pm);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int suapm(PhieuTiem ke) {
		int i = -1;
		String sql = "update phieutiem set manv = ? , MaNguoiDan = ?, NgayTiem =? , TinhTrang =?  where mapt = ?";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaNV());
			pstm.setInt(2, ke.getMaDocGia());
			pstm.setString(3, ke.getNgayMuon());
			pstm.setString(4, ke.getTinhtrang());
			pstm.setInt(5, ke.getMaPhieuMuon());
			if (ke.getTinhtrang().contains("Đã Trả")) {
				ArrayList<ChiTieuPMDTO> list = listctpm(ke.getMaPhieuMuon());
				if (list != null) {
					for (ChiTieuPMDTO ctpm : list) {
						//nghi ngờ: update sach?
						String sql2 = "update vaccine set soluong = ? where MaVaccine = ?";
						PreparedStatement stm2 = conn.prepareStatement(sql2);
						stm2.setInt(1, VaccineDAL.getsoluongsach(ctpm.getMaSach()) + 1);
						stm2.setInt(2, ctpm.getMaSach());
						stm2.executeUpdate();
						System.out.println("Phiếu tiêm DAL : Update số lượng thành công");
					}
				}
			}
//			
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoapm(PhieuTiem ke) {
		int i = -1;
		
		String sql = "update phieutiem set TrangThai = 0 where mapt = ?";
		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaPhieuMuon());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public PhieuTiem timphieumuon(int ma) {
		String sql = "select * from phieutiem where mapt = ? and trangthai = 1";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma);
			PhieuTiem pm = new PhieuTiem();
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				pm.setMaPhieuMuon(rs.getInt(1));
				pm.setMaNV(rs.getInt(2));
				pm.setMaDocGia(rs.getInt(3));
				pm.setNgayMuon(rs.getString(4));
				pm.setTinhtrang(rs.getString(5));
			}
			conn.close();
			return pm;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
