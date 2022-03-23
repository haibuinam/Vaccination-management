package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.DangKyTiemDTO;


public class DangKyTiemDAL {
	public static ArrayList<DangKyTiemDTO> getdanhsachtacgia() {
		try {
			String sql = "select * from bangdangkytiem where trangthai = 1 ";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<DangKyTiemDTO> dsl = new ArrayList<DangKyTiemDTO>();
			while (rs.next()) {

				DangKyTiemDTO tg = new DangKyTiemDTO();
				tg.setMaTacGia(rs.getInt(1));
				//tg.setMaDocGia(rs.getInt()); 
				tg.setTenTacGia(rs.getString("ngaydangky"));
				tg.setQueQuan(rs.getString("LoaiVaccineDangKy"));
				tg.setNamSinh(rs.getString("goitiem")) ; 
				////////////
				tg.setMaDocGia(rs.getInt(6)); 
				tg.setNgayMuonTiem(rs.getString(7)); 
				///////////
				
				dsl.add(tg);
			}

			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	// @SuppressWarnings("null")
	public static int themtacgia(DangKyTiemDTO ke) {
		int i = -1;
		String sql = "insert into bangdangkytiem (ngaydangky,goitiem,LoaiVaccineDangKy,maCCCD,ngayMuonTiem, trangthai) values(?,?,?,?,?,?)";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getTenTacGia());
			pstm.setString(2, ke.getNamSinh());
			pstm.setString(3, ke.getQueQuan());
			/////////////////////
			pstm.setInt(4, ke.getMaDocGia());
			pstm.setString(5, ke.getNgayMuonTiem());
			/////////////////////
			pstm.setInt(6, 1);
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int suatacgia(DangKyTiemDTO ke) {
		int i = -1;
		String sql = "update bangdangkytiem set ngaydangky = ? , goitiem = ?, LoaiVaccineDangKy = ? ,maCCCD =?, ngayMuonTiem = ? where MaDangKyTiem = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getTenTacGia());
			pstm.setString(2, ke.getNamSinh());
			pstm.setString(3, ke.getQueQuan());
			pstm.setInt(6, ke.getMaTacGia());
			pstm.setString(5, ke.getNgayMuonTiem());
			pstm.setInt(4, ke.getMaDocGia());

			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoatacgia(DangKyTiemDTO ke) {
		int i = -1;
		//String sql = "delete from tacgia where matacgia = ?";
		String sql = "update bangdangkytiem set trangthai = 0 where MaDangKyTiem = ?";
		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaTacGia());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}
	
	public DangKyTiemDTO timtacgia(int ma) {
		
		String sql = "select * from bangdangkytiem where MaDangKyTiem = ?";
		try {
			DangKyTiemDTO tg = new DangKyTiemDTO(); 
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps  = conn.prepareStatement(sql);
			ps.setInt(1, ma);
			ResultSet rs = ps.executeQuery() ;
			if(rs.next()) {
				tg.setMaTacGia(rs.getInt(1));
				tg.setTenTacGia(rs.getString("ngaydangky"));
				tg.setQueQuan(rs.getString("LoaiVaccineDangKy"));
				tg.setNamSinh(rs.getString("goitiem")) ; 
				////////////
				tg.setMaDocGia(rs.getInt(6));
				tg.setNgayMuonTiem(rs.getString("ngaymuontiem")) ; 
				//////////////
			}
			return tg ;
		} catch (Exception e) {
			return null;
		}
	}

}
