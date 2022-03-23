package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.NguoiDan;
import DTO.LoaiDTO;
import DTO.PhieuNhap;
import DTO.VaccineDTO;

public class VaccineDAL {
	public static ArrayList<VaccineDTO> getdanhsachLoai() {
		try {

			Connection conn = DBConnect.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from vaccine where trangthai =1");

			ArrayList<VaccineDTO> ds = new ArrayList<>();
			while (rs.next()) {
				System.out.println("Db connect");
				VaccineDTO ls = new VaccineDTO();
				ls.setMasosach(rs.getInt(1));
				ls.setTensach(rs.getString(2));
				ls.setMatacgia(rs.getInt(3));
				ls.setMaNXB(rs.getInt(4));
				ls.setMaloai(rs.getInt(5));
				ls.setNamxb(rs.getInt(6));
				ls.setSoluong(rs.getInt(7));
				ls.setGhichu(rs.getString("trangthai"));
				ls.setHinhanh(rs.getString("HinhAnh"));
				ls.setMake(rs.getInt("Make"));

				ds.add(ls);
			}
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.toString());
			return null;
		}

	}

	public static int themsach(VaccineDTO sach) {
		int i = -1;
		String sql = "insert into vaccine (TenVaccine,MaLoai,MaNCC,MaTacGia,NamSX,SoLuong,MaKe,HinhAnh,TrangThai) values(?,?,?,?,?,?,?,?,?)";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, sach.getTensach());
			pstm.setInt(2, sach.getMaloai());
			pstm.setInt(3, sach.getMaNXB());
			pstm.setInt(4, sach.getMatacgia());
			pstm.setInt(5, sach.getNamxb());
			pstm.setInt(6, sach.getSoluong());
			pstm.setString(7, String.valueOf(sach.getMake()));
			pstm.setString(8, sach.getHinhanh());
			pstm.setInt(9, 1);

			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int suasach(VaccineDTO sach) {
		int i = -1;
		String sql = "update vaccine set TenVaccine = ? , MaLoai = ?, MaNCC = ?, MaTacGia =? , NamSX =? ,SoLuong  =? ,MaKe  =? , HinhAnh =? where MaVaccine = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, sach.getTensach());
			pstm.setInt(2, sach.getMaloai());
			pstm.setInt(3, sach.getMaNXB());
			pstm.setInt(4, sach.getMatacgia());
			pstm.setInt(5, sach.getNamxb());
			pstm.setInt(6, sach.getSoluong());
			pstm.setString(7, String.valueOf(sach.getMake()));
			pstm.setString(8, sach.getHinhanh());
			pstm.setInt(9, sach.getMasosach());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoasach(VaccineDTO ke) {
		int i = -1;
	
		String sql = "update vaccine set TrangThai = 0  where MaVaccine = ?";
		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMasosach());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int getsoluongsach(int masach) {
		try {
			int soluong = 0;
			Connection conn = DBConnect.getConnection();
			String sql = "select soluong from vaccine where MaVaccine = ? and trangthai = 1";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, masach);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				soluong = rs.getInt("SoLuong");
			}
			return soluong;
		} catch (Exception e) {
			return -1;
		}

	}

	public VaccineDTO timsach(int ma) {
		VaccineDTO sach = new VaccineDTO();
		String sql = "select * from vaccine where MaVaccine = ? and trangthai =1";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ma);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				sach.setMasosach(rs.getInt("MaVaccine"));
				sach.setTensach(rs.getString("TenVaccine"));
				sach.setMaloai(rs.getInt("Maloai"));
				sach.setMaNXB(rs.getInt("MaNCC"));
				sach.setMatacgia(rs.getInt("Matacgia"));
				sach.setNamxb(rs.getInt("NamSX"));
				sach.setSoluong(rs.getInt("soluong"));
				sach.setMake(rs.getInt("Make"));
				sach.setHinhanh(rs.getString("hinhanh"));
				sach.setGhichu(rs.getString("trangthai"));
			}
			return sach;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static int getsoluongallsach() {
		try {
			int soluong = 0;
			Connection conn = DBConnect.getConnection();
			String sql = "select soluong from vaccine where trangthai = 1";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				soluong += rs.getInt("soluong");
			}
			conn.close();
			return soluong;
		} catch (Exception e) {
			return -1;
		}
	}

}
