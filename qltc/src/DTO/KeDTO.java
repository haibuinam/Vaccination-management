package DTO;

public class KeDTO {
	private int MaKeSach;
	private String ViTri;
	public int getMaKeSach() {
		return MaKeSach;
	}
	public void setMaKeSach(int maKeSach) {
		MaKeSach = maKeSach;
	}
	public String getViTri() {
		return ViTri;
	}
	public void setViTri(String viTri) {
		ViTri = viTri;
	}
	public KeDTO(int maKeSach, String viTri) {
		super();
		MaKeSach = maKeSach;
		ViTri = viTri;
	}
	public KeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "" + MaKeSach +"-" +ViTri;
	} 
	
}
