package DTO;

public class NguoiDan {
	private int MaDocGia;
	private String TenDocGia;
	private String GioiTinh ;
	private String diachi;
	private String sdt;
	
	

	
	///////////////////////////////
	
	private String NamSinh;
	public String getNamSinh() {
		return NamSinh;
	}
	public void setNamSinh(String namSinh) {
		NamSinh = namSinh;
	}
	
	//////////////////////////////
	
	
	
	public int getMaDocGia() {
		return MaDocGia;
	}
	public void setMaDocGia(int maDocGia) {
		MaDocGia = maDocGia;
	}
	public String getTenDocGia() {
		return TenDocGia;
	}
	public void setTenDocGia(String tenDocGia) {
		TenDocGia = tenDocGia;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public NguoiDan(int maDocGia, String tenDocGia, String gioiTinh, String diachi, String sdt, String namSinh) {
		super();
		MaDocGia = maDocGia;
		TenDocGia = tenDocGia;
		GioiTinh = gioiTinh;
		this.diachi = diachi;
		this.sdt = sdt;
		
		///////////
		NamSinh = namSinh;
		//////////
	}
	public NguoiDan() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return MaDocGia + "-" +TenDocGia; 
	} 
	
	
}
