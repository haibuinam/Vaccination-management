package DTO;

public class LoaiDTO {
	public int maloai;
	public String tenloai;
	public int TrangThai;

	public LoaiDTO(int maloai, String tenloai, int trangThai) {
		super();
		this.maloai = maloai;
		this.tenloai = tenloai;
		TrangThai = trangThai;
	}

	public int getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(int trangThai) {
		TrangThai = trangThai;
	}

	public LoaiDTO(int maloai, String tenloai) {
		super();
		this.maloai = maloai;
		this.tenloai = tenloai;
	}

	public int getMaloai() {
		return maloai;
	}

	public void setMaloai(int maloai) {
		this.maloai = maloai;
	}

	@Override
	public String toString() {
		return maloai + "-" + tenloai;
	}

	public LoaiDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}
}
