package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.DangKyTiemDTO;
import DTO.TestTheQuanLyDTO;

public class TestTheQuanLyDAL {
	public static ArrayList<TestTheQuanLyDTO> getdanhsachthethuvien() {
		try {
			String sql = "select * from testthenv";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<TestTheQuanLyDTO> dsl = new ArrayList<TestTheQuanLyDTO>();
			while (rs.next()) {
				TestTheQuanLyDTO tv = new TestTheQuanLyDTO();
				tv.setMaTheThuVien(rs.getInt(1));
				tv.setNgayBatDau(rs.getString(2));
				tv.setNgayKetThuc(rs.getString(3));
				tv.setGhiChu(rs.getString(4));
				dsl.add(tv);
			}

			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public static ArrayList<TestTheQuanLyDTO> getdanhsachthongtinthethuvien() {
		try {
			String sql = "SELECT testthenv.MaThe,testthenv.NgayBatDau,testthenv.NgayKetThuc,docgia.tendocgia, docgia.madocgia FROM testthenv INNER JOIN docgia ON docgia.madocgia = testthenv.MaThe";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<TestTheQuanLyDTO> dsl = new ArrayList<TestTheQuanLyDTO>();
			while (rs.next()) {
				TestTheQuanLyDTO tv = new TestTheQuanLyDTO();
				tv.setMaTheThuVien(rs.getInt(1));
				tv.setNgayBatDau(rs.getString(2));
				tv.setNgayKetThuc(rs.getString(3));
				tv.setTendocgia(rs.getString("tendocgia"));
				tv.setMadocgia(rs.getInt("madocgia"));

				dsl.add(tv);
			}

			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	// @SuppressWarnings("null")
	public static int themthetv(TestTheQuanLyDTO ke) {
		int i = -1;
		String sql = "insert into testthenv (NgayBatDau ,NgayKetThuc,GhiChu,MaThe) values(?,?,?,?)";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getNgayBatDau());
			pstm.setString(2, ke.getNgayKetThuc());
			pstm.setString(3, ke.getGhiChu());
			pstm.setInt(4, ke.getMaTheThuVien());

			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int suanthethuvien(TestTheQuanLyDTO ke) {
		int i = -1;
		String sql = "update testthenv set NgayBatDau = ? , NgayKetThuc = ?, GhiChu = ?  where MaThe = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getNgayBatDau());
			pstm.setString(2, ke.getNgayKetThuc());
			pstm.setString(3, ke.getGhiChu());
			pstm.setInt(4, ke.getMaTheThuVien());

			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoathethuvien(TestTheQuanLyDTO ke) {
		int i = -1;
		String sql = "delete from testthenv where MaThe = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaTheThuVien());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public TestTheQuanLyDTO timthethuvien(int ma) {

		String sql = "select * from testthenv where MaThe = ?";
		try {
			TestTheQuanLyDTO tv = new TestTheQuanLyDTO();
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ma);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tv.setMaTheThuVien(rs.getInt(1));
				tv.setNgayBatDau(rs.getString(2));
				tv.setNgayKetThuc(rs.getString(3));
				tv.setGhiChu(rs.getString(4));
			}
			return tv;
		} catch (Exception e) {
			return null;
		}
	}

	public static TestTheQuanLyDTO thongtinthe(int ma) {

		String sql = "SELECT testthenv.MaThe,testthenv.NgayBatDau,testthenv.NgayKetThuc,docgia.tendocgia, docgia.madocgia FROM testthenv INNER JOIN docgia ON docgia.madocgia = testthenv.MaThe WHERE docgia.madocgia = ?";
		try {
			TestTheQuanLyDTO tv = new TestTheQuanLyDTO();
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ma);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				tv.setMaTheThuVien(rs.getInt(1));
				tv.setNgayBatDau(rs.getString(2));
				tv.setNgayKetThuc(rs.getString(3));
				tv.setTendocgia(rs.getString("tendocgia"));
				tv.setMadocgia(rs.getInt("madocgia"));
			}
			return tv;
		} catch (Exception e) {
			return null;
		}
	}

	public static boolean check(int mathe) {
		try {
			String sql = "SELECT testthenv.MaThe,docgia.madocgia FROM testthenv INNER JOIN docgia ON testthenv.MaThe = ?";
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, mathe);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public static int giahanthe(int mathe, String ngay) {
		int i = -1;
		String sql = "update testthenv set NgayKetThuc = ? where MaThe = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ngay);
			pstm.setInt(2, mathe);
			
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return i;
	}

}
