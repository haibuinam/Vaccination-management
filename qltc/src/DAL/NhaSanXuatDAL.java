package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.KeDTO;
import DTO.NhaSanXuat;
import DTO.KeDTO;

public class NhaSanXuatDAL {
	public static ArrayList<NhaSanXuat> getdanhnxb() {
		try {
			String sql = "select * from nhasanxuat where trangthai = 1";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<NhaSanXuat> dsl = new ArrayList<NhaSanXuat>();
			while (rs.next()) {

				NhaSanXuat nxb = new NhaSanXuat();
				nxb.setMaNXB(rs.getInt(1));
				nxb.setTenNXB(rs.getString(2));
				nxb.setDiaChi(rs.getString(3));
				nxb.setSdt(rs.getString(4));
				dsl.add(nxb);
			}

			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	// @SuppressWarnings("null")
	public static int themnxb(NhaSanXuat ke) {
		int i = -1;
		String sql = "insert into nhasanxuat (TenNhaSx,diachi,sdt,trangthai) values(?,?,?,?)";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getTenNXB());
			pstm.setString(2, ke.getDiaChi());
			pstm.setString(3, ke.getSdt());
			pstm.setInt(4, 1);
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int suanxb(NhaSanXuat ke) {
		int i = -1;
		String sql = "update nhasanxuat set TenNhaSx = ? , diachi = ?, sdt = ?  where MaNhaSX = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getTenNXB());
			pstm.setString(2, ke.getDiaChi());
			pstm.setString(3, ke.getSdt());
			pstm.setInt(4, ke.getMaNXB());

			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoanxb(NhaSanXuat ke) {
		int i = -1;
		String sql = "update nhasanxuat set trangthai = 0  where MaNhaSX = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaNXB());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public NhaSanXuat timnxb(int ma) {
		String sql = "select * from nhasanxuat where MaNhaSX = ?";
		NhaSanXuat nxb = new NhaSanXuat();
		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ma);
			// System.out.println(ke.getViTri());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				nxb.setMaNXB(rs.getInt(1));
				nxb.setTenNXB(rs.getString(2));
				nxb.setDiaChi(rs.getString(3));
				nxb.setSdt(rs.getString(4));
			}
			conn.close();
			return nxb;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
