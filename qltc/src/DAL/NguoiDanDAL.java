package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.NguoiDan;
import DTO.LoaiDTO;

public class NguoiDanDAL {
	public static ArrayList<NguoiDan> getdanhsachdocgia() {
		try {
			String sql = "select * from nguoidan where trangthai =1";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			ArrayList<NguoiDan> dsl = new ArrayList<>();
			while (rs.next()) {
				// System.out.println("Db connect");
				NguoiDan ke = new NguoiDan();
				ke.setMaDocGia(rs.getInt(1));
				ke.setDiachi(rs.getString(4));
				ke.setTenDocGia(rs.getString(2));
				ke.setGioiTinh(rs.getString(3));
				ke.setSdt(rs.getString(5));
				////////////
				ke.setNamSinh(rs.getString(7));
				/////////
				dsl.add(ke);

			}

			return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	// @SuppressWarnings("null")
	public static int themdocgia(NguoiDan ke) {
		int i = -1;
		String sql = "insert into nguoidan (tennguoidan,gioitinh,diachi,sdt,trangthai,manguoidan,namsinh) values(?,?,?,?,?,?,?)";

		try {
			
			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getTenDocGia());
			pstm.setString(2, ke.getGioiTinh());

			pstm.setString(3, ke.getDiachi());
			pstm.setString(4, ke.getSdt());
			pstm.setInt(5, 1);
			///////////////
			pstm.setInt(6, ke.getMaDocGia());
			pstm.setString(7, ke.getNamSinh());
			//pstm.setString(7,ke.getngaySinh());
			//////////
			
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int suadocgia(NguoiDan ke) {
		int i = -1;
		String sql = "update nguoidan set tennguoidan = ?,diachi =? ,gioitinh = ?,sdt = ?, namsinh =? where manguoidan = ?";

		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, ke.getTenDocGia());
			
			pstm.setString(2, ke.getDiachi());
			pstm.setString(3, ke.getGioiTinh());
			pstm.setString(4, ke.getSdt());
			
			/////////////
			pstm.setString(5, ke.getNamSinh());
			pstm.setInt(6, ke.getMaDocGia());
			/////////////
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}

	public static int xoadocgia(NguoiDan ke) {
		int i = -1;
	
		String sql = "update nguoidan set trangthai = 0 where manguoidan = ?" ;
		try {

			Connection conn = DBConnect.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ke.getMaDocGia());
			// System.out.println(ke.getViTri());
			i = pstm.executeUpdate();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			// dreturn null;
		}

		return i;
	}
	public NguoiDan timdocgia(int ma) {
		String sql = "select * from nguoidan where manguoidan = ? and trangthai = 1 ";
		NguoiDan docgia = new NguoiDan();
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ma);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				docgia.setMaDocGia(rs.getInt(1));
				docgia.setDiachi(rs.getString(4));
				docgia.setTenDocGia(rs.getString(2));
				docgia.setGioiTinh(rs.getString(3));
				docgia.setSdt(rs.getString(5));
				////////
				
				docgia.setNamSinh(rs.getString(7));
				////////////
			}
			return docgia; 
		} catch (Exception e) {
			e.printStackTrace();
			return null ; 
		}
		
	}
}
