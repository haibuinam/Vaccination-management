package DTO;

public class DangKyTiemDTO {
	private int MaTacGia;
	private String TenTacGia;
	private String NamSinh;
	private String QueQuan;
	
	////////////////////////
	private String NgayMuonTiem;
	
	public String getNgayMuonTiem() {
		return NgayMuonTiem;
	}
	public void setNgayMuonTiem(String ngayMuonTiem) {
		NgayMuonTiem = ngayMuonTiem;
	}
	
	private int MaDocGia;
	
	public int getMaDocGia() {
		return MaDocGia;
	}
	public void setMaDocGia(int maDocGia) {
		MaDocGia = maDocGia;
	}
	///////////////////
	
	public int getMaTacGia() {
		return MaTacGia;
	}
	public void setMaTacGia(int maTacGia) {
		MaTacGia = maTacGia;
	}
	public String getTenTacGia() {
		return TenTacGia;
	}
	public void setTenTacGia(String tenTacGia) {
		TenTacGia = tenTacGia;
	}
	public DangKyTiemDTO(int maTacGia, String tenTacGia, String namSinh, String queQuan, int maDocGia, String ngayMuonTiem) {
		super();
		MaTacGia = maTacGia;
		TenTacGia = tenTacGia;
		NamSinh = namSinh;
		QueQuan = queQuan;
		/////////////////////
		MaDocGia = maDocGia;
		NgayMuonTiem = ngayMuonTiem;
		///////////////////
	}
	public DangKyTiemDTO() {
		// TODO Auto-generated constructor stub
	}
	public String getNamSinh() {
		return NamSinh;
	}
	public void setNamSinh(String namSinh) {
		NamSinh = namSinh;
	}
	public String getQueQuan() {
		return QueQuan;
	}
	public void setQueQuan(String queQuan) {
		QueQuan = queQuan;
	}
	@Override
	public String toString() {
		return MaTacGia + "-" + TenTacGia ;
	}
	
}
