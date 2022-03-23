package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.ChiTieuPMDTO;
import DTO.KeDTO;
import DTO.GoiTiemDTO;

public class GoiTiemDAL {
	public static ArrayList<GoiTiemDTO> getdanhsachphieuphat(){
		try {
			String sql = "select * from goitiem";
			Connection conn = DBConnect.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql) ; 
			ResultSet rs = stmt.executeQuery();
			
			
            ArrayList<GoiTiemDTO> dsl = new ArrayList<>();
            while(rs.next()) {
            	System.out.println("Db connect");
            	GoiTiemDTO ke = new GoiTiemDTO();
            	ke.setMaphieuphat(rs.getInt(1));
            	ke.setMapm(rs.getInt(2));
            	ke.setLydo(rs.getString(3));
            	ke.setTienphat(rs.getString(4));
            	dsl.add(ke);
            
            }
            
            return dsl;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	//@SuppressWarnings("null")
	public static int themphieuphat(GoiTiemDTO ke) {
		int i  = -1 ;
		String sql = "insert into goitiem (mapt,lydo,tien) values(?,?,?)";
		
			try {
				
				Connection conn = DBConnect.getConnection(); 
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, ke.getMapm());
				pstm.setString(2,ke.getLydo());
				pstm.setString(3,ke.getTienphat());
				i = pstm.executeUpdate();
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				//dreturn null;
			}
		
		return i ; 
	}
	
	public static int suaphieuphat(GoiTiemDTO ke) {
		int i  = -1 ;
		String sql = "update goitiem set mapt = ? , lydo =? , tien = ? where mapp = ?";
		 
			try {
					
				Connection conn = DBConnect.getConnection(); 
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, ke.getMapm());
				pstm.setString(2,ke.getLydo());
				pstm.setString(3,ke.getTienphat());
				pstm.setInt(4, ke.getMaphieuphat());
				//System.out.println(ke.getViTri());
				i = pstm.executeUpdate();
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				//dreturn null;
			}
		
		return i ; 
	}
	public static int xoaphieuphat(GoiTiemDTO ke) {
		int i  = -1 ;
		String sql = "delete from goitiem where mapt = ?";
		 
			try {
					
				Connection conn = DBConnect.getConnection(); 
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, ke.getMaphieuphat());
				//System.out.println(ke.getViTri());
				i = pstm.executeUpdate();
				conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				//dreturn null;
			}
		
		return i ; 
	}
}
