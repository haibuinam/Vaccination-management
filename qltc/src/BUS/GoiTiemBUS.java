package BUS;

import java.util.ArrayList;


import DAL.GoiTiemDAL;

import DTO.GoiTiemDTO;

public class GoiTiemBUS {
	GoiTiemDTO phatDAL = new GoiTiemDTO();

	public ArrayList<GoiTiemDTO> getdanhsachphat() {

		return GoiTiemDAL.getdanhsachphieuphat();
	}

	public int themke(GoiTiemDTO phat) {
		return GoiTiemDAL.themphieuphat(phat);
	}

	public int suake(GoiTiemDTO phat) {
		return GoiTiemDAL.suaphieuphat(phat);
	}

	public int xoake(GoiTiemDTO phat) {
		return GoiTiemDAL.xoaphieuphat(phat);
	}
	
	public static GoiTiemBUS gI() {
		return new GoiTiemBUS();
	}
}
