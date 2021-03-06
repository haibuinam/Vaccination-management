package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.JobAttributes;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.DefaultCategoryItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import BUS.ChiTietPhieuNhapBUS;
import BUS.NguoiDanBUS;
import BUS.KeBus;
import BUS.LoaiBUS;
import BUS.NhaCungcapbus;
import BUS.NhaSanXuatBUS;
import BUS.NhanVienBus;
import BUS.PhieuTiemBus;
import BUS.PhieuNhapBUS;
import BUS.VaccineBus;
import BUS.DangKyTiemBUS;
import BUS.TaiKhoanBus;
import BUS.Chitietptbus;
import DAL.PhieuTiemDAL;
import DAL.VaccineDAL;
import DAL.TestTheQuanLyDAL;
import DTO.ChiTietPhieuNhap;
import DTO.ChiTieuPMDTO;
import DTO.NguoiDan;
import DTO.KeDTO;
import DTO.LoaiDTO;

import DTO.NhaCungCapDTO;
import DTO.NhaSanXuat;
import DTO.NhanVien;
import DTO.PhieuTiem;
import DTO.PhieuNhap;
import DTO.VaccineDTO;
import DTO.DangKyTiemDTO;
import DTO.TestTheQuanLyDTO;
import Export.ExportExcel;
import Export.ImportExcel;
import Export.WritePDF;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JMenuItem;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.LineBorder;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import com.toedter.components.JSpinField;
import javax.swing.DefaultComboBoxModel;

public class MainFrame extends JFrame {
	public static String Ma;
	public static boolean isdangxuat;
	DangKyTiemDTO tacgiasl;
	LoaiDTO loaisl;
	NhaSanXuat nxbsl;
	KeDTO kesl;
	NhanVien nvsl;
	NguoiDan dgsl;
	public static TestTheQuanLyDTO tv;

	private JPanel contentPane;
	private JLabel iconsgu;
	private JLabel exit;
	private JLabel lblTitle;
	private JLabel title;
	private JPanel menuleft;
	private JLabel quanLyTiem;
	private JLabel lblQuanLyTiem;
	private JPanel PanelChinh;
	private JPanel CardLayout;

	private JPanel vaccinePanel;
	private JPanel loaiVaccine;
	private JPanel Sach;
	public static JPanel pnVaccine;
	private JPanel pnNguoiDan;
	private JPanel pnnhaSanXuat;
	private JPanel pnDangKyTiem;
	private JPanel pnTrangChu;
	private JPanel pnnhanvien;
	private JLabel lblTenVaccine;
	private JLabel lblMaLoai;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblHinhAnh;
	private JLabel lbltitlepnVaccine;
	private JLabel lblnamSx;
	private JLabel lblSLng;
	private JLabel lblMaKe;
	private JTextField txttenVaccine;
	private JTextField txtsoluongVaccine;
	private JTextField txtnamSx;
	private JTable tableVaccine;
	private DefaultTableModel dtmVAccine;
	private JLabel lblNewLabel;
	private JLabel lblTrangchu;
	private JLabel lblVaccine1;
	private JLabel lbl;
	private JLabel lbltacgia;
	private JLabel lblnhaSx;
	private JLabel lblnhanvien;
	private JPanel panelthongtinnguoidan;
	private JLabel lblTenNguoiDan;
	
	private JLabel lblDoTuoi;
	private JLabel lblDonViPhuTrachTiem;
	//private JComboBox cmbMaDangKyTiem;
	private JComboBox cmbngaydangky;
	private JDateChooser dateChooser_dangkytiem;
	private JDateChooser dateChooser_dangkyngaymuontiem;
	private JTextField txtnamsinhnguoidan;
	
	private JTextField txtmaCCCD;
	private JTextField txtdonvitiem;
	
	private JComboBox cmbnguoidandangky;
	private JComboBox cmbnguoidan_vaccine;
	private JLabel lbldiadiemmuontiem;
	private JLabel lblCCCD;
	//txt ????? h??nh ?????ng th??m s???a x??a
	
	private JLabel lbldiachiNguoidan;
	private JLabel lblgioitinhNguoiDan;
	private JLabel lblSdtnguoidan;
	private JTextField txtTennguoidan;
	private JTextField txtdiachinguoidan;
	private JTextField txtgioitinhnguoidan;
	private JTextField txtsdtnguoidan;
	private JTextField txtTimkiemnguoidan;
	private JButton btnTimkiemnguoidan;
	private JLabel lblTimKiem;
	private JScrollPane scrollPane_1;
	private JTable tablenguoidan;
	private DefaultTableModel dtmnguoidan;
	private JPanel pnthongtinDangKyTiem;
	private JLabel lblTentacgia;
	private JTextField txtTentacgia;
	private JLabel lblnamsinh;
	private JTextField txtnamsinhtacgia;
	private JLabel lblTentacgia_2;
	private JTextField txtQueQuan;
	private JScrollPane scrollPane_2;
	private JTable tabletacgia;
	private DefaultTableModel dtmtacgia;
	private JButton btnThemTacgia;
	private JButton btnsuatacgia;
	private JButton btnreloadtacgia;
	private JButton btnxoatacgia;
	private JPanel panel_1;
	private JLabel lblTennhaSanXuat;
	private JLabel lblaCh;
	private JLabel lblTennhaSx_2;
	private JTextField txtTennhaSx;
	private JTextField txtdiachinhaSx;
	private JTextField txtsdtnSx;
	private JButton btnThemnSX;
	private JButton btnsuaNhaSx;
	private JButton btnxoaNhaSx;
	private JButton btnreloadnSX;
	private JLabel lblTimKiemnSx;
	private JTextField txttimnSx;
	private JScrollPane scrollPane_3;
	private JTable tablenhaSx;
	private DefaultTableModel dtmnhaSx;
	public static JPanel pnPhieuTiem;
	private JPanel pnPhieuNhap;
	private JPanel panel_2;
	private JLabel lbltennv;
	private JLabel lblnamsinhnv;
	private JLabel lblaCh_1;
	private JLabel lbltennv_3;
	private JLabel lbltennv_4;
	private JTextField txttennv;
	private JTextField txtnamsinhnv;
	private JTextField txtdiachinv;
	private JTextField txtsodienthoainv;
	private JTextField txtgioitinhnv;
	private JButton btnthemnv;
	private JButton btnsuanv;
	private JButton btnxoanv;
	private JButton btnreloadnv;
	private JLabel lbltimkiem;
	private JTextField txtTimKiemnv;
	private JScrollPane scrollPane_4;
	private JTable tablenhanvien;
	private DefaultTableModel dtmnhanvien;
	protected int y_mouse;
	protected int x_mouse;
	private JPanel pnchung;
	private JPanel panel_3;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtmapt;
	private JButton btnthemphieuTiem;
	private JButton btnsuaphieuTiem;
	private JButton btnxoaphieuTiem;
	private JButton btnreloadphieuTiem;
	private JScrollPane scrollPane_5;
	private DefaultTableModel dtmTiem;
	private JLabel lblphieutiem;
	private JLabel lbltimkiempt;
	private JTextField txttimphieutiem;
	private JScrollPane scrollPane_6;
	private JTable tablectpt;
	private DefaultTableModel dtmctpt;
	public static JTextField txtmaVaccineTiem;
	private JTextField txtghichuctpt;
	private JTextField txttenloai;
	private JTable tableloai;
	private JButton btnsualoai;
	private JButton btnxoaloai;
	private DefaultTableModel dtmloai;
	private JLabel lbltenncc;
	private JTextField txtNcc;
	private JButton btnThemncc;
	private JButton btnsuancc;
	private JButton btnxoancc;
	private JScrollPane scrollPane_7;
	private JTable tablencc;
	private DefaultTableModel dtmncc;
	private JLabel lblNewLabel_10;
	private JTextField txtKe;
	private JButton btnthemke;
	private JButton btnsuake;
	private JButton btnxoake;
	private JScrollPane scrollPane_8;
	private JTable tableke;
	private JLabel lblchung;
	private JLabel lbldangxuat;
	private DefaultTableModel dtmke;
	private JButton btnThemloai;
	private JButton btnthemnguoidan;
	private JButton btnsuanguoidan;
	private JButton btnxoanguoidan;
	private JComboBox cmbmaloai;
	private JComboBox cmbmanhaSx;
	private JComboBox cmbmatg;
	private JComboBox cmbmake;
	private String hinhanh = null;
	private JComboBox cmbnhanvienpm;
	private JComboBox cmbmaVaccinephieuTiem;
	private JDateChooser dateChooser;
	private JButton btnthemctptiem;
	private JButton btnsuactpm;
	private JButton btnxoactpm;
	private JButton bnttailaictpm;
	private JDateChooser dateChooser_ngaytra;
	private JLabel lblthongke;
	private JTable tablephieunhap;
	private DefaultTableModel dtmphieunhap;
	private DefaultTableModel dtmchitietphieunhap;
	private JDateChooser NgayNhapPhieuNhap;
	private JLabel lblphieunhap;
	private JButton btnmanvphieunhap;
	private JButton btnmanccphieunhap;
	private JRadioButton rdTiem;
	private JRadioButton rdtra;
	private JButton btnthemphieuphat;
	private JButton btndanhsachphat;
	private JButton btnthemphieunhap;
	private JButton btnsuaphieunhap;
	private JButton btnxoaphieunhap;
	protected int mapn;
	private JPopupMenu popupThemtaikhoanv;
	private JMenuItem mnthemtaikhoan;
	private DefaultTableModel dtmthongkeVaccineTiem;
	private DefaultTableModel dtmthongkenhaphang;
	private ButtonGroup g;
	private JButton btnlocthongke;
	private JComboBox comboBox;
	protected String namselect = "";
	private JDateChooser ngaybd;
	private JDateChooser ngayketthuc;
	private JLabel lbltongtien;
	private JRadioButton rdloctheonam;
	private JRadioButton rdloctheongay;
	private ButtonGroup group;
	public static JLabel lblUser;
	public static NguoiDan  thethanhvien = null;
	public static int idtaikhoan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 1280, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		thanhtitle();
		menuleft();
		addEvent();
		loadloaiVaccine();
		loadnhacungcap();
		loadkesach();
		loadnhanvien();
		loadnxb();
		loadtacgia();
		loadnguoidan();
		loadVaccine();
		loadphieuTiem();
		loadctphieuTiem();
		loadphieunhap();
		loadctphieunhap();
		loadthongkephieunhap();
	}

	public void thanhtitle() {
		iconsgu = new JLabel("");
		iconsgu.setIcon(null);
		iconsgu.setBounds(0, 0, 30, 34);
		contentPane.add(iconsgu);

		exit = new JLabel("");

		exit.setIcon(new ImageIcon("img\\exiticon.png"));
		exit.setBounds(1244, 7, 24, 24);
		contentPane.add(exit);

		lblTitle = new JLabel("Qu\u1EA3n L\u00FD Ti\u00eam Ch\u1ee7ng");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setBounds(535, 0, 200, 34);
		contentPane.add(lblTitle);

		title = new JLabel("");
		title.setOpaque(true);
		title.setBackground(new Color(64, 64, 64));
		title.setBounds(0, 0, 1280, 34);
		contentPane.add(title);

	}

	public void menuleft() {

		PanelChinh = new JPanel();
		PanelChinh.setBounds(187, 33, 1093, 735);
		contentPane.add(PanelChinh);
		PanelChinh.setLayout(new CardLayout(0, 0));
		pnVaccine();
		/* PN ?????C GI??? */
		nguoidan();
		/* PANEL NH?? XU???T B???N */
		nhaxuatban();
		/* PANEL T??C GI??? */
		pntacgia();
		/*
		 * // PANEL TRANG CH???
		 */
		trangchu();

		nhanvien();

		pnPhieuTiem = new JPanel();

		pnPhieuNhap = new JPanel();

		menuleft = new JPanel();
		menuleft.setBounds(0, 33, 187, 734);
		menuleft.setBackground(new Color(64, 64, 64));
		contentPane.add(menuleft);
		menuleft.setLayout(null);

		lblQuanLyTiem = new JLabel("????n v??? qu???n l?? ??HBKHN");
		lblQuanLyTiem.setForeground(Color.WHITE);
		lblQuanLyTiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuanLyTiem.setIcon(new ImageIcon("img\\iconthuvien.png"));
		lblQuanLyTiem.setBounds(0, 13, 187, 40);
		menuleft.add(lblQuanLyTiem);

		quanLyTiem = new JLabel("");
		quanLyTiem.setBackground(new Color(255, 127, 80));
		quanLyTiem.setOpaque(true);
		quanLyTiem.setIcon(null);
		quanLyTiem.setBounds(0, 0, 187, 62);
		menuleft.add(quanLyTiem);

		lblTrangchu = new JLabel("  Trang Ch???");
		lblTrangchu.setBackground(new Color(64, 64, 64));
		lblTrangchu.setOpaque(true);
		lblTrangchu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTrangchu.setIcon(new ImageIcon(
				"C:\\Users\\ASUS\\Pictures\\14-145167_home-icon-home-icon-png-green-removebg-preview.png"));
		lblTrangchu.setForeground(Color.WHITE);
		lblTrangchu.setBounds(0, 74, 187, 46);

		menuleft.add(lblTrangchu);

		lblVaccine1 = new JLabel(" Vaccine");
		lblVaccine1.setIcon(new ImageIcon("img\\VaccineCam.png"));
		lblVaccine1.setBackground(new Color(64, 64, 64));
		lblVaccine1.setOpaque(true);
		lblVaccine1.setForeground(Color.WHITE);
		lblVaccine1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblVaccine1.setBounds(0, 133, 187, 46);

		menuleft.add(lblVaccine1);

		lbl = new JLabel("  Ng?????i D??n");
		lbl.setIcon(new ImageIcon("img\\nguoiDan.png"));
		lbl.setBackground(new Color(64, 64, 64));
		lbl.setOpaque(true);
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl.setBounds(0, 192, 187, 46);

		menuleft.add(lbl);

		lbltacgia = new JLabel("   ????ng K?? Ti??m");
		lbltacgia.setIcon(new ImageIcon("img\\dangkytiem.png"));
		lbltacgia.setBackground(new Color(64, 64, 64));
		lbltacgia.setOpaque(true);
		lbltacgia.setForeground(Color.WHITE);
		lbltacgia.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbltacgia.setBounds(2, 251, 187, 46);

		menuleft.add(lbltacgia);

		lblnhaSx = new JLabel(" Nh?? S???n Xu???t");
		lblnhaSx.setIcon(new ImageIcon("img\\Company.png"));
		lblnhaSx.setBackground(new Color(64, 64, 64));
		lblnhaSx.setOpaque(true);
		lblnhaSx.setForeground(Color.WHITE);
		lblnhaSx.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblnhaSx.setBounds(0, 310, 187, 46);

		menuleft.add(lblnhaSx);

		lblnhanvien = new JLabel("Nh??n Vi??n");
		lblnhanvien.setIcon(new ImageIcon("img\\Staff.png"));
		lblnhanvien.setBackground(new Color(64, 64, 64));
		lblnhanvien.setOpaque(true);
		lblnhanvien.setForeground(Color.WHITE);
		lblnhanvien.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblnhanvien.setBounds(0, 369, 187, 46);

		menuleft.add(lblnhanvien);

		lblphieutiem = new JLabel(" Phi???u Ti??m");
		lblphieutiem.setIcon(new ImageIcon("img\\Note.png"));
		lblphieutiem.setOpaque(true);
		lblphieutiem.setForeground(Color.WHITE);
		lblphieutiem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblphieutiem.setBackground(Color.DARK_GRAY);
		lblphieutiem.setBounds(0, 428, 187, 46);
		menuleft.add(lblphieutiem);

		lblchung = new JLabel(" Chung");
		lblchung.setIcon(new ImageIcon("img\\chungpng.png"));
		lblchung.setOpaque(true);
		lblchung.setForeground(Color.WHITE);
		lblchung.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblchung.setBackground(Color.DARK_GRAY);
		lblchung.setBounds(0, 601, 187, 46);
		menuleft.add(lblchung);

		lbldangxuat = new JLabel("????ng Xu???t");
		lbldangxuat.setIcon(new ImageIcon("img\\Exit.png"));
		lbldangxuat.setOpaque(true);
		lbldangxuat.setForeground(Color.WHITE);
		lbldangxuat.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbldangxuat.setBackground(Color.DARK_GRAY);
		lbldangxuat.setBounds(0, 675, 187, 46);
		menuleft.add(lbldangxuat);

		lblthongke = new JLabel("Th???ng K??");
		lblthongke.setIcon(new ImageIcon("img\\Combo Chart.png"));
		lblthongke.setOpaque(true);
		lblthongke.setForeground(Color.WHITE);
		lblthongke.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblthongke.setBackground(Color.DARK_GRAY);
		lblthongke.setBounds(0, 542, 187, 46);
		menuleft.add(lblthongke);

		lblphieunhap = new JLabel("   Phi???u Nh???p");
		lblphieunhap.setIcon(new ImageIcon("img\\phieunhap.png"));
		lblphieunhap.setOpaque(true);
		lblphieunhap.setForeground(Color.WHITE);
		lblphieunhap.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblphieunhap.setBackground(Color.DARK_GRAY);
		lblphieunhap.setBounds(0, 487, 187, 46);
		menuleft.add(lblphieunhap);
		PanelChinh.add(pnTrangChu, "name_890335498390600");

		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setIcon(new ImageIcon("img\\iconsgu 3.png"));
		lblNewLabel_17.setBounds(346, 177, 401, 397);
		pnTrangChu.add(lblNewLabel_17);

		lblUser = new JLabel("");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblUser.setForeground(Color.RED);
		lblUser.setBounds(458, 594, 159, 83);
		pnTrangChu.add(lblUser);
		lblUser.setText("Hi  " + LoginForm.username);
		PanelChinh.add(pnVaccine, "name_890193837575500");

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "H\u00ECnh \u1EA2nh", TitledBorder.LEADING, TitledBorder.ABOVE_BOTTOM,
				null, null));
		panel_5.setBounds(856, 71, 177, 279);
		pnVaccine.add(panel_5);
		panel_5.setLayout(null);

		lblhinhanhpre = new JLabel("");
		lblhinhanhpre.setOpaque(true);
		lblhinhanhpre.setBounds(864, 77, 158, 252);
		pnVaccine.add(lblhinhanhpre);

		JLabel lblNewLabel_3_1 = new JLabel("T??m ki???m");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(77, 387, 112, 34);
		pnVaccine.add(lblNewLabel_3_1);

		txttimsach = new JTextField();
		txttimsach.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttimsach.setColumns(10);
		txttimsach.setBounds(221, 387, 292, 34);
		pnVaccine.add(txttimsach);

		JButton btnTm_1 = new JButton("T??m");
		btnTm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("T??m theo m??");
				if (!isNumber(txttimsach.getText())) {
					JOptionPane.showMessageDialog(null, "T??m Ki???m Theo M?? Vaccine");
					return;
				}
				int masach = Integer.parseInt(txttimsach.getText());
				VaccineDTO sach = VaccineBus.gI().timsach(masach);
				dtmVAccine.setRowCount(0);
				if (sach != null) {
					Vector<Object> vec = new Vector<Object>();
					vec.add(sach.getMasosach());
					vec.add(sach.getTensach());
					vec.add(sach.getMaloai());
					vec.add(sach.getMaNXB());
					vec.add(sach.getMatacgia());
					vec.add(sach.getNamxb());
					vec.add(sach.getSoluong());
					vec.add(sach.getMake());
					vec.add(sach.getHinhanh());
					dtmVAccine.addRow(vec);
				}
			}
		});
		btnTm_1.setIcon(new ImageIcon("img\\Search.png"));
		btnTm_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTm_1.setBounds(554, 380, 112, 51);
		pnVaccine.add(btnTm_1);

		PanelChinh.add(pnNguoiDan, "name_890203323464100");
		PanelChinh.add(pnDangKyTiem, "name_890226525489300");

		lblTmKim = new JLabel("T??m Ki???m");
		lblTmKim.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTmKim.setBounds(168, 380, 152, 37);
		pnDangKyTiem.add(lblTmKim);

		txttimtacgia = new JTextField();
		txttimtacgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttimtacgia.setColumns(10);
		txttimtacgia.setBounds(301, 380, 267, 37);
		pnDangKyTiem.add(txttimtacgia);

		btnTm_2 = new JButton("T??m ");
		btnTm_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isNumber(txttimtacgia.getText())) {
					JOptionPane.showMessageDialog(null, "L???i ! T??m theo m?? t??c gi???...");
					return;
				}
				int ma = Integer.parseInt(txttimtacgia.getText());
				DangKyTiemDTO tg = DangKyTiemBUS.gI().timtacgia(ma);
				if (tg != null) {
					dtmtacgia.setRowCount(0);
					Vector<Object> vec = new Vector<Object>();
					vec.add(tg.getMaTacGia());
					vec.add(tg.getTenTacGia());
					vec.add(tg.getNamSinh());
					vec.add(tg.getQueQuan());
					
					vec.add(tg.getMaDocGia());
					vec.add(tg.getNgayMuonTiem());

					dtmtacgia.addRow(vec);
				} else {
					JOptionPane.showMessageDialog(null, "Kh??ng t??m th???y nh?? khoa h???c");
				}
			}
		});
		btnTm_2.setIcon(new ImageIcon("img\\Search.png"));
		btnTm_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTm_2.setBounds(617, 371, 126, 54);
		pnDangKyTiem.add(btnTm_2);
		PanelChinh.add(pnnhaSanXuat, "name_890210577532500");

		JButton btnTimnxb = new JButton("T??m");
		btnTimnxb.setIcon(new ImageIcon("img\\Search.png"));
		btnTimnxb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isNumber(txttimnSx.getText())) {
					JOptionPane.showMessageDialog(null, "M?? Nh?? Cung C???p ph???i l?? s???");
					return;
				}
				int ma = Integer.parseInt(txttimnSx.getText());
				NhaSanXuat nxb = NhaSanXuatBUS.gI().timnxb(ma);
				if (nxb != null) {
					dtmnhaSx.setRowCount(0);
					Vector<Object> vec = new Vector<Object>();
					vec.add(nxb.getMaNXB());
					vec.add(nxb.getTenNXB());
					vec.add(nxb.getDiaChi());
					vec.add(nxb.getSdt());

					dtmnhaSx.addRow(vec);
				}
			}
		});
		btnTimnxb.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimnxb.setBounds(770, 415, 108, 47);
		pnnhaSanXuat.add(btnTimnxb);
		PanelChinh.add(pnnhanvien, "name_890389477283600");

		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon("img\\searchbar-removebg-preview.png"));
		lblNewLabel_15.setBounds(268, 392, 532, 52);
		pnnhanvien.add(lblNewLabel_15);
		PanelChinh.add(pnPhieuTiem, "name_901238608974900");
		pnPhieuTiem.setLayout(null);

		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(12, 13, 516, 294);
		pnPhieuTiem.add(panel_3);
		panel_3.setLayout(null);

		lblNewLabel_1 = new JLabel("M?? PTi??m");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(12, 13, 82, 36);
		panel_3.add(lblNewLabel_1);

		lblNewLabel_4 = new JLabel("M?? NV");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_4.setBounds(12, 61, 82, 36);
		panel_3.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("M?? CCCD");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_5.setBounds(12, 110, 97, 36);
		panel_3.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Ng??y Ti??m");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(12, 171, 97, 36);
		panel_3.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("T??nh Tr???ng");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(12, 227, 82, 36);
		panel_3.add(lblNewLabel_7);

		txtmapt = new JTextField();
		txtmapt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtmapt.setEditable(false);
		txtmapt.setBounds(111, 14, 236, 36);
		panel_3.add(txtmapt);
		txtmapt.setColumns(10);

		btnthemphieuTiem = new JButton("Th??m");
		btnthemphieuTiem.setIcon(new ImageIcon("img\\Add.png"));
		btnthemphieuTiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnthemphieuTiem.setBounds(380, 13, 117, 49);
		panel_3.add(btnthemphieuTiem);

		btnsuaphieuTiem = new JButton("S???a");
		btnsuaphieuTiem.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuaphieuTiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsuaphieuTiem.setBounds(380, 83, 117, 49);
		panel_3.add(btnsuaphieuTiem);

		btnxoaphieuTiem = new JButton("Xo??");
		btnxoaphieuTiem.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoaphieuTiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxoaphieuTiem.setBounds(380, 155, 117, 49);
		panel_3.add(btnxoaphieuTiem);

		btnreloadphieuTiem = new JButton("T???i L???i");
		btnreloadphieuTiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadphieuTiem();
			}
		});
		btnreloadphieuTiem.setIcon(new ImageIcon("img\\update.png"));
		btnreloadphieuTiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnreloadphieuTiem.setBounds(380, 228, 117, 49);
		panel_3.add(btnreloadphieuTiem);

		cmbnhanvienpm = new JComboBox();
		cmbnhanvienpm.setBounds(111, 62, 236, 36);
		cmbnhanvienpm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbnhanvienpm.getSelectedItem() == null) {
					return;
				}

				nvsl = (NhanVien) cmbnhanvienpm.getSelectedItem();

			}
		});
		panel_3.add(cmbnhanvienpm);
//luuu
		cmbmaVaccinephieuTiem = new JComboBox();
		cmbmaVaccinephieuTiem.setBounds(111, 114, 236, 32);
		cmbmaVaccinephieuTiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cmbmaVaccinephieuTiem.getSelectedItem() == null) {
					return;
				}
				dgsl = (NguoiDan) cmbmaVaccinephieuTiem.getSelectedItem();

			}
		});
		panel_3.add(cmbmaVaccinephieuTiem);

		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setEnabled(true);
		dateChooser.setDate(Calendar.getInstance().getTime());
		dateChooser.setBounds(111, 171, 236, 36);
		panel_3.add(dateChooser);

		rdTiem = new JRadioButton("T???t\r\n");
		rdTiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdTiem.setBounds(142, 233, 88, 25);
		panel_3.add(rdTiem);

		rdtra = new JRadioButton("Theo d??i TT");
		rdtra.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdtra.setBounds(245, 233, 127, 25);
		panel_3.add(rdtra);
		g = new ButtonGroup();
		g.add(rdTiem);
		g.add(rdtra);

		scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(540, 13, 553, 294);
		pnPhieuTiem.add(scrollPane_5);
		dtmTiem = new DefaultTableModel();
		dtmTiem.addColumn("M?? PTi??m");
		dtmTiem.addColumn("M?? Nh??n Vi??n");
		dtmTiem.addColumn("M?? CCCD");
		dtmTiem.addColumn("Ng??y Ti??m");
		dtmTiem.addColumn("T??nh Tr???ng");

		tablemuon = new MyTable(dtmTiem);

		scrollPane_5.setViewportView(tablemuon);

		lbltimkiempt = new JLabel("T??m Ki???m");
		lbltimkiempt.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltimkiempt.setBounds(12, 331, 97, 39);
		pnPhieuTiem.add(lbltimkiempt);

		txttimphieutiem = new JTextField();
		txttimphieutiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttimphieutiem.setBounds(127, 340, 317, 30);
		pnPhieuTiem.add(txttimphieutiem);
		txttimphieutiem.setColumns(10);

		scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(22, 391, 736, 331);
		pnPhieuTiem.add(scrollPane_6);

		dtmctpt = new DefaultTableModel();
		//fix
		dtmctpt.addColumn("M?? CTPhi???u ti??m");
		dtmctpt.addColumn("M?? PTi??m");
		dtmctpt.addColumn("M?? Vaccine");
		dtmctpt.addColumn("Ng??y Ti??mi)");
		dtmctpt.addColumn("Ghi Ch??");
		tablectpt = new MyTable(dtmctpt);
		scrollPane_6.setViewportView(tablectpt);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(770, 391, 323, 331);
		pnPhieuTiem.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_8 = new JLabel("M?? Vaccine");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(12, 13, 91, 49);
		panel.add(lblNewLabel_8);

		txtmaVaccineTiem = new JTextField();
		txtmaVaccineTiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtmaVaccineTiem.setBounds(96, 21, 142, 35);
		panel.add(txtmaVaccineTiem);
		txtmaVaccineTiem.setColumns(10);

		JButton btnNewButton_5 = new JButton("...");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TableVaccine().setVisible(true);
			}
		});
		btnNewButton_5.setBounds(263, 26, 54, 25);
		panel.add(btnNewButton_5);

		JLabel lblNewLabel_8_1 = new JLabel("H???n theo d??i");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8_1.setBounds(12, 74, 91, 49);
		panel.add(lblNewLabel_8_1);

		JLabel lblNewLabel_8_1_1 = new JLabel("Ghi Ch??");
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8_1_1.setBounds(12, 140, 91, 49);
		panel.add(lblNewLabel_8_1_1);

		txtghichuctpt = new JTextField();
		txtghichuctpt.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtghichuctpt.setColumns(10);
		txtghichuctpt.setEditable(false);
		txtghichuctpt.setBounds(96, 148, 142, 35);
		panel.add(txtghichuctpt);

		btnthemctptiem = new JButton("Th??m");
		btnthemctptiem.setIcon(new ImageIcon("img\\Add.png"));
		btnthemctptiem.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnthemctptiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnthemctptiem.setBounds(12, 227, 124, 41);
		panel.add(btnthemctptiem);

		btnsuactpm = new JButton("S???a");
		btnsuactpm.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuactpm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnsuactpm.setBounds(193, 227, 124, 41);
		panel.add(btnsuactpm);

		btnxoactpm = new JButton("Xo??");
		btnxoactpm.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoactpm.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnxoactpm.setBounds(12, 280, 124, 41);
		panel.add(btnxoactpm);

		bnttailaictpm = new JButton("T???i L???i");
		bnttailaictpm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadctphieuTiem();
			}
		});
		bnttailaictpm.setIcon(new ImageIcon("img\\update.png"));
		bnttailaictpm.setFont(new Font("Tahoma", Font.BOLD, 13));
		bnttailaictpm.setBounds(193, 280, 121, 41);
		panel.add(bnttailaictpm);

		dateChooser_ngaytra = new JDateChooser();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(Calendar.getInstance().getTime());
		c1.roll(Calendar.DATE, 7);
		dateChooser_ngaytra.setDateFormatString("yyyy-MM-dd");
		dateChooser_ngaytra.setDate(c1.getTime());
		dateChooser_ngaytra.setBounds(96, 79, 142, 35);
		panel.add(dateChooser_ngaytra);

		btnthemphieuphat = new JButton("G??i Tr??? Ph??");
		btnthemphieuphat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnthemphieuphat.setBounds(822, 332, 117, 45);
		btnthemphieuphat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (Ma == null || Ma.isEmpty() || Ma.equals("")) {
					JOptionPane.showMessageDialog(null, "B???n ch??a ch???n m?? phi???u ti??m");
					return;
				}
				new GoiTiem().setVisible(true);
			}
		});
		pnPhieuTiem.add(btnthemphieuphat);

		btndanhsachphat = new JButton("DS Tr??? Ph??");
		btndanhsachphat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DanhSachPhat().setVisible(true);
			}
		});
		btndanhsachphat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btndanhsachphat.setBounds(964, 331, 129, 47);
		pnPhieuTiem.add(btndanhsachphat);

		JButton btnTimphieTiem = new JButton("T??m");
		btnTimphieTiem.setIcon(new ImageIcon("img\\Search.png"));
		btnTimphieTiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isNumber(txttimphieutiem.getText())) {
					JOptionPane.showMessageDialog(null, "Ph???i nh???p s???");
					return;

				}
				int ma = Integer.parseInt(txttimphieutiem.getText());
				PhieuTiem pm = PhieuTiemBus.gI().timphieumuon(ma);
				if (pm != null) {
					dtmTiem.setRowCount(0);
					Vector<Object> vec = new Vector<Object>();
					vec.add(pm.getMaPhieuMuon());
					vec.add(pm.getMaNV());
					vec.add(pm.getMaDocGia());
					vec.add(pm.getNgayMuon());
					vec.add(pm.getTinhtrang());
					dtmTiem.addRow(vec);
				}
			}
		});
		btnTimphieTiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTimphieTiem.setBounds(472, 331, 123, 47);
		pnPhieuTiem.add(btnTimphieTiem);
		PanelChinh.add(pnPhieuNhap, "name_901242535638200");
		pnPhieuNhap.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(
				new TitledBorder(null, "Phi\u1EBFu Nh\u1EADp", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(22, 13, 434, 304);
		pnPhieuNhap.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_11 = new JLabel("M?? Nh??n Vi??n");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11.setBounds(12, 42, 102, 33);
		panel_6.add(lblNewLabel_11);

		txtManhanvienphieunhap = new JTextField();
		txtManhanvienphieunhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtManhanvienphieunhap.setBounds(144, 43, 91, 33);
		panel_6.add(txtManhanvienphieunhap);
		txtManhanvienphieunhap.setColumns(10);

		btnmanvphieunhap = new JButton("...");
		btnmanvphieunhap.setBounds(241, 48, 48, 25);
		panel_6.add(btnmanvphieunhap);

		JLabel lblNewLabel_11_1 = new JLabel("M?? NCC");
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11_1.setBounds(12, 104, 102, 33);
		panel_6.add(lblNewLabel_11_1);

		txtManccPhieuNhap = new JTextField();
		txtManccPhieuNhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtManccPhieuNhap.setColumns(10);
		txtManccPhieuNhap.setBounds(144, 104, 91, 33);
		panel_6.add(txtManccPhieuNhap);

		btnmanccphieunhap = new JButton("...");

		btnmanccphieunhap.setBounds(241, 109, 48, 25);
		panel_6.add(btnmanccphieunhap);

		NgayNhapPhieuNhap = new JDateChooser();
		NgayNhapPhieuNhap.setBounds(144, 174, 145, 33);
		NgayNhapPhieuNhap.setEnabled(false);
		NgayNhapPhieuNhap.setDate(Calendar.getInstance().getTime());
		NgayNhapPhieuNhap.setDateFormatString("yyyy-MM-dd");
		panel_6.add(NgayNhapPhieuNhap);

		JLabel lblNewLabel_11_1_1 = new JLabel("Ng??y Nh???p");
		lblNewLabel_11_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_11_1_1.setBounds(12, 174, 102, 33);
		panel_6.add(lblNewLabel_11_1_1);

		btnthemphieunhap = new JButton("Th??m");
		btnthemphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnthemphieunhap.setBounds(12, 242, 97, 46);
		panel_6.add(btnthemphieunhap);

		btnsuaphieunhap = new JButton("S???a");
		btnsuaphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnsuaphieunhap.setBounds(119, 242, 97, 46);
		panel_6.add(btnsuaphieunhap);

		btnxoaphieunhap = new JButton("Xo??");
		btnxoaphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnxoaphieunhap.setBounds(226, 242, 97, 46);
		panel_6.add(btnxoaphieunhap);

		btntailai = new JButton("T???i L???i");
		btntailai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadphieunhap();
			}
		});
		btntailai.setFont(new Font("Tahoma", Font.BOLD, 15));
		btntailai.setBounds(335, 242, 97, 46);
		panel_6.add(btntailai);

		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(467, 13, 614, 304);
		pnPhieuNhap.add(scrollPane_9);
		dtmphieunhap = new DefaultTableModel();
		dtmphieunhap.addColumn("M?? PN");
		dtmphieunhap.addColumn("M?? NV");
		dtmphieunhap.addColumn("M?? NCC");
		dtmphieunhap.addColumn("Ng??y Nh???p");

		tablephieunhap = new MyTable(dtmphieunhap);

		scrollPane_9.setViewportView(tablephieunhap);

		JPanel panel_6_1 = new JPanel();
		panel_6_1.setBorder(new TitledBorder(null, "Chi Ti\u1EBFt Phi\u1EBFu Nh\u1EADp", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));

		panel_6_1.setBounds(22, 418, 422, 304);
		pnPhieuNhap.add(panel_6_1);
		panel_6_1.setLayout(null);

		lblNewLabel_12 = new JLabel("M?? Vaccine");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_12.setBounds(12, 60, 102, 33);
		panel_6_1.add(lblNewLabel_12);

		txtMaSachctpn = new JTextField();
		txtMaSachctpn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaSachctpn.setColumns(10);
		txtMaSachctpn.setBounds(152, 60, 91, 33);
		panel_6_1.add(txtMaSachctpn);

		btnmanvphieunhap_1 = new JButton("...");
		btnmanvphieunhap_1.setBounds(278, 65, 48, 25);
		panel_6_1.add(btnmanvphieunhap_1);

		lblNewLabel_13 = new JLabel("S??? L?????ng");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_13.setBounds(12, 122, 102, 33);
		panel_6_1.add(lblNewLabel_13);

		txtsoluongctpn = new JTextField();
		txtsoluongctpn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsoluongctpn.setColumns(10);
		txtsoluongctpn.setBounds(152, 122, 91, 33);
		panel_6_1.add(txtsoluongctpn);

		lblNewLabel_14 = new JLabel("Gi?? Nh???p");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_14.setBounds(12, 183, 102, 33);
		panel_6_1.add(lblNewLabel_14);

		txtgianhap = new JTextField();
		txtgianhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtgianhap.setColumns(10);
		txtgianhap.setBounds(152, 183, 91, 33);
		panel_6_1.add(txtgianhap);

		lblmaphieunhap = new JLabel("M?? Phi???u Nh???p");
		lblmaphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblmaphieunhap.setBounds(12, 13, 127, 33);
		panel_6_1.add(lblmaphieunhap);

		btnthemchitietphieunhap = new JButton("Th??m");
		btnthemchitietphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnthemchitietphieunhap.setBounds(12, 245, 97, 46);
		panel_6_1.add(btnthemchitietphieunhap);

		btnsuactpn = new JButton("S???a");
		btnsuactpn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnsuactpn.setBounds(138, 245, 97, 46);
		panel_6_1.add(btnsuactpn);

		btnxoactpn = new JButton("Xo??");
		btnxoactpn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnxoactpn.setBounds(261, 245, 97, 46);
		panel_6_1.add(btnxoactpn);

		JScrollPane scrollPane_9_1 = new JScrollPane();
		scrollPane_9_1.setBounds(456, 418, 625, 304);
		pnPhieuNhap.add(scrollPane_9_1);

		dtmchitietphieunhap = new DefaultTableModel();
		dtmchitietphieunhap.addColumn("M?? CTPN");
		dtmchitietphieunhap.addColumn("M?? PN");
		dtmchitietphieunhap.addColumn("M?? Vaccine");
		dtmchitietphieunhap.addColumn("S??? L?????ng");
		dtmchitietphieunhap.addColumn("????n Gi??");
		dtmchitietphieunhap.addColumn("Th??nh Ti???n");
		tablechitietphieunhap = new MyTable(dtmchitietphieunhap);

		scrollPane_9_1.setViewportView(tablechitietphieunhap);

		panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(253, 245, 230), 2));
		panel_7.setBounds(22, 330, 1059, 68);
		pnPhieuNhap.add(panel_7);
		panel_7.setLayout(null);

		lblNewLabel_16 = new JLabel("T??m Ki???m");
		lblNewLabel_16.setToolTipText("T??m Ki???m Theo M?? Phi???u Nh???p");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_16.setBounds(12, 17, 127, 33);
		panel_7.add(lblNewLabel_16);

		txttimphieunhap = new JTextField();
		txttimphieunhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttimphieunhap.setBounds(141, 13, 425, 42);
		panel_7.add(txttimphieunhap);
		txttimphieunhap.setColumns(10);

		btninphieunhap = new JButton("In");
		btninphieunhap.setIcon(new ImageIcon("img\\Print.png"));
		btninphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btninphieunhap.setBounds(687, 10, 97, 46);
		panel_7.add(btninphieunhap);

		btnxuatexcel = new JButton("Xu???t\r\n");
		btnxuatexcel.setIcon(new ImageIcon("img\\Export Excel.png"));
		btnxuatexcel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnxuatexcel.setBounds(796, 10, 116, 46);
		panel_7.add(btnxuatexcel);

		btnnhapexcel = new JButton("Nh???p");
		btnnhapexcel.setIcon(new ImageIcon("img\\Xls Import.png"));
		btnnhapexcel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnnhapexcel.setBounds(924, 10, 116, 46);
		panel_7.add(btnnhapexcel);

		btntimphieunhap = new JButton("");
		btntimphieunhap.setIcon(new ImageIcon("img\\Search.png"));
		btntimphieunhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isNumber(txttimphieunhap.getText())) {
					JOptionPane.showMessageDialog(null, "M?? Phi???u Nh???p Ph???i L?? S???");
					return;
				}
				int ma = Integer.parseInt(txttimphieunhap.getText());
				PhieuNhap pn = PhieuNhapBUS.gI().getPhieuNhap(ma);
				if (pn != null) {
					dtmphieunhap.setRowCount(0);
					Vector<Object> vec = new Vector<Object>();
					vec.add(pn.getMaPhieuNhap());
					vec.add(pn.getMaNhaCung());
					vec.add(pn.getMaNhanVien());
					vec.add(pn.getNgayNhap());
					dtmphieunhap.addRow(vec);

				}
			}
		});
		btntimphieunhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btntimphieunhap.setBounds(578, 10, 97, 46);
		panel_7.add(btntimphieunhap);

		pnchung();

		pnthongke();
	}

	private void pnchung() {
		pnchung = new JPanel();
		PanelChinh.add(pnchung, "name_903253398621700");
		pnchung.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Lo\u1EA1i", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(69, 33, 389, 292);
		pnchung.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("T??n Lo???i");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setBounds(12, 13, 79, 41);
		panel_4.add(lblNewLabel_9);

		txttenloai = new JTextField();
		txttenloai.setFont(new Font("Tahoma", Font.BOLD, 15));
		txttenloai.setBounds(120, 13, 225, 41);
		panel_4.add(txttenloai);
		txttenloai.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 142, 365, 137);
		panel_4.add(scrollPane);
		dtmloai = new DefaultTableModel();
		dtmloai.addColumn("M?? Lo???i");
		dtmloai.addColumn("T??n Lo???i");
		tableloai = new MyTable(dtmloai);
		scrollPane.setViewportView(tableloai);

		btnThemloai = new JButton("Th??m");
		btnThemloai.setBounds(12, 93, 97, 25);
		panel_4.add(btnThemloai);

		btnsualoai = new JButton("S???a");
		btnsualoai.setBounds(149, 93, 97, 25);
		panel_4.add(btnsualoai);

		btnxoaloai = new JButton("Xo??");
		btnxoaloai.setBounds(280, 93, 97, 25);
		panel_4.add(btnxoaloai);

		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBorder(
				new TitledBorder(null, "Nh\u00E0 Cung C\u1EA5p", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4_1.setBounds(660, 33, 389, 292);
		pnchung.add(panel_4_1);
		panel_4_1.setLayout(null);

		lbltenncc = new JLabel("T??n NCC");
		lbltenncc.setForeground(Color.BLACK);
		lbltenncc.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltenncc.setBounds(12, 13, 79, 41);
		panel_4_1.add(lbltenncc);

		txtNcc = new JTextField();
		txtNcc.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNcc.setColumns(10);
		txtNcc.setBounds(120, 13, 225, 41);
		panel_4_1.add(txtNcc);

		btnThemncc = new JButton("Th??m");
		btnThemncc.setBounds(12, 93, 97, 25);
		panel_4_1.add(btnThemncc);

		btnsuancc = new JButton("S???a");
		btnsuancc.setBounds(149, 93, 97, 25);
		panel_4_1.add(btnsuancc);

		btnxoancc = new JButton("Xo??");
		btnxoancc.setBounds(280, 93, 97, 25);
		panel_4_1.add(btnxoancc);

		scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(12, 147, 365, 132);
		panel_4_1.add(scrollPane_7);
		dtmncc = new DefaultTableModel();
		dtmncc.addColumn("M?? NCC");
		dtmncc.addColumn("T??n Nh?? Cung C???p");
		tablencc = new MyTable(dtmncc);
		scrollPane_7.setViewportView(tablencc);

		JPanel panel_4_2 = new JPanel();
		panel_4_2.setBorder(new TitledBorder(null, "K\u1EC7 S\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(255, 127, 80)));
		panel_4_2.setBounds(352, 408, 389, 292);
		pnchung.add(panel_4_2);
		panel_4_2.setLayout(null);

		lblNewLabel_10 = new JLabel("T??n K???");
		lblNewLabel_10.setForeground(Color.BLACK);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_10.setBounds(12, 23, 79, 41);
		panel_4_2.add(lblNewLabel_10);

		txtKe = new JTextField();
		txtKe.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtKe.setColumns(10);
		txtKe.setBounds(120, 23, 225, 41);
		panel_4_2.add(txtKe);

		btnthemke = new JButton("Th??m");
		btnthemke.setBounds(12, 86, 97, 25);
		panel_4_2.add(btnthemke);

		btnsuake = new JButton("S???a");
		btnsuake.setBounds(149, 86, 97, 25);
		panel_4_2.add(btnsuake);

		btnxoake = new JButton("Xo??");
		btnxoake.setBounds(280, 86, 97, 25);
		panel_4_2.add(btnxoake);

		scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(12, 143, 365, 136);
		panel_4_2.add(scrollPane_8);
		dtmke = new DefaultTableModel();
		dtmke.addColumn("M?? K???");
		dtmke.addColumn("T??n K???");
		tableke = new MyTable(dtmke);
		scrollPane_8.setViewportView(tableke);

	}

	private void pnthongke() {
		panelThongKe = new JPanel();

		DefaultPieDataset p = new DefaultPieDataset();

		int tongVaccine = VaccineBus.gI().soluongsach() + Chitietptbus.gI().getsoluongsachdamuon();
		System.out.println("T???ng Vaccine" + tongVaccine);
		System.out.println("Vaccine ???? Ti??m " + Chitietptbus.gI().getsoluongsachdamuon());
		int vacccinedatiem = Chitietptbus.gI().getsoluongsachdamuon();
		System.out.println(vacccinedatiem);
		float phantramVaccinedatiem = (float) (vacccinedatiem * 1.0 / tongVaccine * 100);
		System.out.println("Ph???n Tr??m Vaccine ???? ti??m :" + phantramVaccinedatiem);

		p.setValue("Vaccine ???? Ti??m ", phantramVaccinedatiem);
		p.setValue("Vaccine C??n L???i", 100 - phantramVaccinedatiem);

		JFreeChart chart = ChartFactory.createPieChart3D("Th???ng K?? Vaccine ???? Ti??m", p);

		TextTitle tt = new TextTitle("Th???ng K?? Vaccine ???? Ti??m", new Font("Arial", Font.BOLD, 15));

		tt.setPadding(5, 5, 5, 5);
		chart.setTitle(tt);

		final PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setLabelFont(new Font("Arial", Font.PLAIN, 12));
		PanelChinh.add(panelThongKe, "name_8485672922600");
		panelThongKe.setLayout(null);

		btnthongkesachmuon = new JButton("Danh S??ch ");
		btnthongkesachmuon.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnthongkesachmuon.setBounds(155, 347, 138, 36);
		panelThongKe.add(btnthongkesachmuon);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.setBounds(397, 13, 684, 709);
		panelThongKe.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Nh???p H??ng", null, panel, null);
		panel.setLayout(null);
		dtmthongkenhaphang = new DefaultTableModel();
		dtmthongkenhaphang.addColumn("M?? CTPN");
		dtmthongkenhaphang.addColumn("M?? PN");
		dtmthongkenhaphang.addColumn("M?? Vaccine");

		dtmthongkenhaphang.addColumn("Gi?? Nh???p");
		dtmthongkenhaphang.addColumn("S??? L?????ng");
		dtmthongkenhaphang.addColumn("Th??nh Ti???n");
		dtmthongkenhaphang.addColumn("Ng??y Nh???p");
		dtmthongkenhaphang.addColumn("T??n Vaccine");
		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(12, 13, 651, 444);
		panel.add(scrollPane);

		tablethongkenhaphang = new MyTable(dtmthongkenhaphang);

		scrollPane.setViewportView(tablethongkenhaphang);

		lblNewLabel_18 = new JLabel("L???c Theo");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_18.setForeground(new Color(0, 0, 0));
		lblNewLabel_18.setBounds(27, 484, 76, 23);
		panel.add(lblNewLabel_18);

		btnlocthongke = new JButton("L???c");
		btnlocthongke.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnlocthongke.setBounds(351, 475, 64, 40);
		panel.add(btnlocthongke);

		JLabel lblNewLabel_20 = new JLabel("S??? Vaccine ???? Nh???p");
		lblNewLabel_20.setForeground(Color.RED);
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_20.setBounds(448, 485, 149, 20);
		panel.add(lblNewLabel_20);

		lblsosachdanhap = new JLabel("0");
		lblsosachdanhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblsosachdanhap.setBounds(587, 484, 76, 20);
		panel.add(lblsosachdanhap);

		JLabel lblNewLabel_20_1 = new JLabel("T???ng Ti???n");
		lblNewLabel_20_1.setForeground(Color.RED);
		lblNewLabel_20_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_20_1.setBounds(448, 546, 149, 20);
		panel.add(lblNewLabel_20_1);

		lbltongtien = new JLabel("0");
		lbltongtien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbltongtien.setBounds(547, 546, 128, 20);
		panel.add(lbltongtien);

		comboBox = new JComboBox();
		comboBox.addItem("");
		int year = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = year; i > year - 4; i--) {
			comboBox.addItem(i);
		}
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedIndex() > 0) {
					namselect = comboBox.getSelectedItem().toString();
				}

			}
		});
		comboBox.setBounds(154, 484, 149, 23);
		panel.add(comboBox);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2
				.setIcon(new ImageIcon("img\\update.png"));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loadthongkephieunhap();
			}
		});
		btnNewButton_2.setBounds(547, 605, 97, 44);
		panel.add(btnNewButton_2);

		ngaybd = new JDateChooser();
		ngaybd.setDateFormatString("yyyy-MM-dd");
		ngaybd.setBounds(154, 545, 149, 34);
		panel.add(ngaybd);

		ngayketthuc = new JDateChooser();
		ngayketthuc.setDateFormatString("yyyy-MM-dd");
		ngayketthuc.setBounds(154, 605, 149, 29);
		panel.add(ngayketthuc);

		JLabel lblNewLabel_21_1 = new JLabel("?????n");
		lblNewLabel_21_1.setForeground(Color.BLACK);
		lblNewLabel_21_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_21_1.setBounds(100, 611, 41, 23);
		panel.add(lblNewLabel_21_1);

		rdloctheonam = new JRadioButton("N??m");
		rdloctheonam.setBounds(100, 484, 92, 25);
		panel.add(rdloctheonam);

		rdloctheongay = new JRadioButton("Ng??y");
		rdloctheongay.setBounds(100, 545, 76, 25);
		panel.add(rdloctheongay);
		group = new ButtonGroup();
		group.add(rdloctheonam);
		group.add(rdloctheongay);

		ChartPanel panel1 = new ChartPanel(chart);
		panel1.setBounds(12, 25, 385, 302);
		panelThongKe.add(panel1);

		panel1.setPreferredSize(new Dimension(311, 302));
		panel1.setBackground(new Color(0, 0, 0, 0));

	}

	private void nhanvien() {

		pnnhanvien = new JPanel();
		pnnhanvien.setLayout(null);

		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(118, 51, 866, 311);
		pnnhanvien.add(panel_2);
		panel_2.setLayout(null);

		lbltennv = new JLabel("T??n");
		lbltennv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltennv.setBounds(12, 13, 138, 39);
		panel_2.add(lbltennv);

		lblnamsinhnv = new JLabel("N??m Sinh");
		lblnamsinhnv.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnamsinhnv.setBounds(12, 83, 138, 39);
		panel_2.add(lblnamsinhnv);
		
		lblaCh_1 = new JLabel("?????a Ch???");
		lblaCh_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblaCh_1.setBounds(12, 158, 138, 39);
		panel_2.add(lblaCh_1);
		
		//////////////////////////////
		//them ????n v??? ti??m
		lblDonViPhuTrachTiem = new JLabel("????n v??? ti??m");
		lblDonViPhuTrachTiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDonViPhuTrachTiem.setBounds(472, 158, 138, 39);
		panel_2.add(lblDonViPhuTrachTiem);
		
		//////////////////////////
		txtdonvitiem = new JTextField();
		txtdonvitiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtdonvitiem.setColumns(10);
		txtdonvitiem.setBounds(608, 158, 199, 39);
		panel_2.add(txtdonvitiem);
		
		
		///////////////////////////////////////
		

		lbltennv_3 = new JLabel("Gi???i T??nh");
		lbltennv_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltennv_3.setBounds(472, 13, 138, 39);
		panel_2.add(lbltennv_3);

		lbltennv_4 = new JLabel("S??? ??i???n Tho???i");
		lbltennv_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltennv_4.setBounds(472, 83, 138, 39);
		panel_2.add(lbltennv_4);

		txttennv = new JTextField();
		txttennv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttennv.setBounds(162, 13, 199, 39);
		panel_2.add(txttennv);
		txttennv.setColumns(10);

		txtnamsinhnv = new JTextField();
		txtnamsinhnv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtnamsinhnv.setColumns(10);
		txtnamsinhnv.setBounds(162, 83, 199, 39);
		panel_2.add(txtnamsinhnv);

		txtdiachinv = new JTextField();
		txtdiachinv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtdiachinv.setColumns(10);
		txtdiachinv.setBounds(162, 158, 199, 39);
		panel_2.add(txtdiachinv);

		txtsodienthoainv = new JTextField();
		txtsodienthoainv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsodienthoainv.setColumns(10);
		txtsodienthoainv.setBounds(608, 83, 199, 39);
		panel_2.add(txtsodienthoainv);

		txtgioitinhnv = new JTextField();
		txtgioitinhnv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtgioitinhnv.setColumns(10);
		txtgioitinhnv.setBounds(608, 13, 199, 39);
		panel_2.add(txtgioitinhnv);

		btnthemnv = new JButton("Th??m");
		btnthemnv.setIcon(new ImageIcon("img\\Add.png"));
		btnthemnv.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnthemnv.setBounds(58, 245, 126, 53);
		panel_2.add(btnthemnv);

		btnsuanv = new JButton("S???a");
		btnsuanv.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuanv.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsuanv.setBounds(259, 245, 126, 53);
		panel_2.add(btnsuanv);

		btnxoanv = new JButton("Xo??\r\n");
		btnxoanv.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoanv.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxoanv.setBounds(467, 245, 126, 53);
		panel_2.add(btnxoanv);

		btnreloadnv = new JButton("T???i L???i");
		btnreloadnv.setIcon(new ImageIcon("img\\update.png"));
		btnreloadnv.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnreloadnv.setBounds(688, 245, 126, 53);
		panel_2.add(btnreloadnv);

		lbltimkiem = new JLabel("T??m ki???m");
		lbltimkiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbltimkiem.setBounds(118, 405, 138, 39);
		pnnhanvien.add(lbltimkiem);

		txtTimKiemnv = new JTextField();
		txtTimKiemnv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKiemnv.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtTimKiemnv.setBackground(new Color(214, 217, 223));
		txtTimKiemnv.setBounds(290, 399, 425, 39);
		pnnhanvien.add(txtTimKiemnv);
		txtTimKiemnv.setColumns(10);

		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(118, 469, 866, 253);
		pnnhanvien.add(scrollPane_4);
		dtmnhanvien = new DefaultTableModel();
		dtmnhanvien.addColumn("M??");
		dtmnhanvien.addColumn("H??? T??n");
		dtmnhanvien.addColumn("N??m Sinh");
		dtmnhanvien.addColumn("Gi???i T??nh");
		dtmnhanvien.addColumn("?????a Chi");
		dtmnhanvien.addColumn("S??T");
		///////////
		dtmnhanvien.addColumn("????n v??? ti??m");
		///////////

		tablenhanvien = new MyTable(dtmnhanvien);
		scrollPane_4.setViewportView(tablenhanvien);
		popupThemtaikhoanv = new JPopupMenu();
		mnthemtaikhoan = new JMenuItem("Th??m T??i Kho???n");
		mnthemtaikhoan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = tablenhanvien.getSelectedRow();
				if (i > -1) {
					idtaikhoan = Integer.parseInt(dtmnhanvien.getValueAt(i, 0).toString());
					new TaiKhoan().setVisible(true);
				} else {
					JOptionPane.showMessageDialog(contentPane, "B???n ch??a ch???n v??o nh??n vi??n ????? th??m t??i kho???n");
				}

			}
		});
		mnthemtaikhoan.setBounds(0, 0, 113, 19);
		popupThemtaikhoanv.add(mnthemtaikhoan);

		addPopup(tablenhanvien, popupThemtaikhoanv);

	}

	private void nhaxuatban() {

		pnnhaSanXuat = new JPanel();
		pnnhaSanXuat.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(216, 64, 708, 327);
		pnnhaSanXuat.add(panel_1);
		panel_1.setLayout(null);

		lblTennhaSanXuat = new JLabel("T??n Nh?? Cung C???p");
		lblTennhaSanXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTennhaSanXuat.setBounds(43, 38, 145, 43);
		panel_1.add(lblTennhaSanXuat);

		lblaCh = new JLabel("?????a Ch???");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblaCh.setBounds(43, 104, 145, 43);
		panel_1.add(lblaCh);

		lblTennhaSx_2 = new JLabel("S??? ??i???n Tho???i");
		lblTennhaSx_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTennhaSx_2.setBounds(43, 172, 145, 43);
		panel_1.add(lblTennhaSx_2);

		txtTennhaSx = new JTextField();
		txtTennhaSx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTennhaSx.setBounds(321, 44, 282, 37);
		panel_1.add(txtTennhaSx);
		txtTennhaSx.setColumns(10);

		txtdiachinhaSx = new JTextField();
		txtdiachinhaSx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtdiachinhaSx.setColumns(10);
		txtdiachinhaSx.setBounds(321, 110, 282, 37);
		panel_1.add(txtdiachinhaSx);

		txtsdtnSx = new JTextField();
		txtsdtnSx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsdtnSx.setColumns(10);
		txtsdtnSx.setBounds(321, 172, 282, 37);
		panel_1.add(txtsdtnSx);

		btnThemnSX = new JButton("Th??m");
		btnThemnSX.setIcon(new ImageIcon("img\\Add.png"));
		btnThemnSX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemnSX.setBounds(45, 252, 108, 47);
		panel_1.add(btnThemnSX);

		btnsuaNhaSx = new JButton("S???a");
		btnsuaNhaSx.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsuaNhaSx.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuaNhaSx.setBounds(221, 252, 108, 47);
		panel_1.add(btnsuaNhaSx);

		btnxoaNhaSx = new JButton("Xo??");
		btnxoaNhaSx.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoaNhaSx.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxoaNhaSx.setBounds(387, 252, 108, 47);
		panel_1.add(btnxoaNhaSx);

		btnreloadnSX = new JButton("T???i L???i");
		btnreloadnSX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadnxb();
			}
		});
		btnreloadnSX.setIcon(new ImageIcon("img\\update.png"));
		btnreloadnSX.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnreloadnSX.setBounds(562, 252, 108, 47);
		panel_1.add(btnreloadnSX);

		lblTimKiemnSx = new JLabel("T??m Ki???m");
		lblTimKiemnSx.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiemnSx.setBounds(260, 419, 145, 43);
		pnnhaSanXuat.add(lblTimKiemnSx);

		txttimnSx = new JTextField();
		txttimnSx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttimnSx.setColumns(10);
		txttimnSx.setBounds(427, 419, 282, 37);
		pnnhaSanXuat.add(txttimnSx);

		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(211, 473, 713, 249);
		pnnhaSanXuat.add(scrollPane_3);
		dtmnhaSx = new DefaultTableModel();
		dtmnhaSx.addColumn("M?? Nh?? Cung C???p");
		dtmnhaSx.addColumn("T??n Nh?? Cung C???p");
		dtmnhaSx.addColumn("?????a Ch???");
		dtmnhaSx.addColumn("S??? ??i???n Tho???i");
		tablenhaSx = new MyTable(dtmnhaSx);
		scrollPane_3.setViewportView(tablenhaSx);

	}

	private void nguoidan() {

		pnNguoiDan = new JPanel();
		pnNguoiDan.setLayout(null);

		panelthongtinnguoidan = new JPanel();
		panelthongtinnguoidan.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelthongtinnguoidan.setBounds(130, 39, 837, 252);
		pnNguoiDan.add(panelthongtinnguoidan);
		panelthongtinnguoidan.setLayout(null);

		lblTenNguoiDan = new JLabel("T??n Ng?????i D??n/????? tu???i");
		lblTenNguoiDan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenNguoiDan.setBounds(51, 13, 120, 36);
		panelthongtinnguoidan.add(lblTenNguoiDan);
		
		//them n??m sinh
		lblDoTuoi = new JLabel("N??m sinh");
		lblDoTuoi.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDoTuoi.setBounds(91, 68, 110, 36);
		panelthongtinnguoidan.add(lblDoTuoi);
		
		/*
		//th??m b???ng ng??y sinh cho ng?????i d??n
		dateChooser_nguoidan = new JDateChooser();
		dateChooser_nguoidan.setDateFormatString("yyyy-MM-dd");
		dateChooser_nguoidan.setEnabled(true);
		dateChooser_nguoidan.setDate(Calendar.getInstance().getTime());
		dateChooser_nguoidan.setBounds(192, 68, 208, 36);
		panelthongtindocgia.add(dateChooser_nguoidan);
		txtnamsinhnguoidan
		
		txtnamsinhnguoidan = new JTextField();
		txtnamsinhnguoidan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtnamsinhnguoidan.setColumns(10);
		txtnamsinhnguoidan.setBounds(192, 68, 208, 36);
		panelthongtindocgia.add(txtnamsinhnguoidan);
		txtmaCCCD
		*/
		/////////
		
		
		// th??m n??m sinh ng?????i d??n
		txtnamsinhnguoidan = new JTextField();
		txtnamsinhnguoidan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtnamsinhnguoidan.setColumns(10);
		txtnamsinhnguoidan.setBounds(192, 68, 208, 36);
		panelthongtinnguoidan.add(txtnamsinhnguoidan);
		
		
		////th??m m?? ????ng k?? ti??m
		lblNewLabel_3 = new JLabel("S??? CCCD");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(453,68, 191, 36);
		panelthongtinnguoidan.add(lblNewLabel_3);
		
		///////////////////////////
		txtmaCCCD = new JTextField();
		txtmaCCCD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtmaCCCD.setColumns(10);
		txtmaCCCD.setBounds(569,68, 208, 36);
		panelthongtinnguoidan.add(txtmaCCCD);
		///////////////////////////
				
		lbldiachiNguoidan = new JLabel("?????a Ch???");
		lbldiachiNguoidan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldiachiNguoidan.setBounds(91, 119, 91, 36);
		panelthongtinnguoidan.add(lbldiachiNguoidan);

		lblgioitinhNguoiDan = new JLabel("Gi???i T??nh");
		lblgioitinhNguoiDan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblgioitinhNguoiDan.setBounds(453, 119, 91, 36);
		panelthongtinnguoidan.add(lblgioitinhNguoiDan);

		lblSdtnguoidan = new JLabel("S??? ??i???n tho???i");
		lblSdtnguoidan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSdtnguoidan.setBounds(453, 13, 109, 36);
		panelthongtinnguoidan.add(lblSdtnguoidan);

		txtTennguoidan = new JTextField();
		txtTennguoidan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTennguoidan.setBounds(192, 13, 208, 36);
		panelthongtinnguoidan.add(txtTennguoidan);
		txtTennguoidan.setColumns(10);

		txtdiachinguoidan = new JTextField();
		txtdiachinguoidan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtdiachinguoidan.setColumns(10);
		txtdiachinguoidan.setBounds(192, 119, 208, 36);
		panelthongtinnguoidan.add(txtdiachinguoidan);

		txtgioitinhnguoidan = new JTextField();
		txtgioitinhnguoidan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtgioitinhnguoidan.setColumns(10);
		txtgioitinhnguoidan.setBounds(569, 119, 208, 36);
		panelthongtinnguoidan.add(txtgioitinhnguoidan);

		txtsdtnguoidan = new JTextField();
		txtsdtnguoidan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsdtnguoidan.setColumns(10);
		txtsdtnguoidan.setBounds(569, 13, 208, 36);
		panelthongtinnguoidan.add(txtsdtnguoidan);

		btnthemnguoidan = new JButton("Th??m");
		btnthemnguoidan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnthemnguoidan.setIcon(new ImageIcon("img\\Add.png"));
		btnthemnguoidan.setBounds(84, 190, 119, 49);
		panelthongtinnguoidan.add(btnthemnguoidan);

		btnsuanguoidan = new JButton("S???a");
		btnsuanguoidan.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuanguoidan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsuanguoidan.setBounds(274, 190, 119, 49);
		panelthongtinnguoidan.add(btnsuanguoidan);

		btnxoanguoidan = new JButton("Xo??");
		btnxoanguoidan.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoanguoidan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxoanguoidan.setBounds(496, 190, 119, 49);
		panelthongtinnguoidan.add(btnxoanguoidan);

		btnTiLi = new JButton("T???i L???i");
		btnTiLi.setIcon(new ImageIcon("img\\update.png"));
		btnTiLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loadnguoidan();
			}
		});
		btnTiLi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTiLi.setBounds(693, 190, 119, 49);
		panelthongtinnguoidan.add(btnTiLi);

		txtTimkiemnguoidan = new JTextField();
		txtTimkiemnguoidan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimkiemnguoidan.setBounds(251, 322, 442, 42);
		pnNguoiDan.add(txtTimkiemnguoidan);
		txtTimkiemnguoidan.setColumns(10);

		btnTimkiemnguoidan = new JButton("T??m");
		btnTimkiemnguoidan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!isNumber(txtTimkiemnguoidan.getText())) {
					JOptionPane.showMessageDialog(null, "T??m ki???m m?? ng?????i d??n ph???i l?? s???");
					return;
				}
				int ma = Integer.parseInt(txtTimkiemnguoidan.getText());
				NguoiDan doc = NguoiDanBUS.gI().timdocgia(ma);
				if (doc != null) {
					dtmnguoidan.setRowCount(0);
					Vector<Object> vec = new Vector<Object>();
					vec.add(doc.getMaDocGia());
					vec.add(doc.getTenDocGia());
					vec.add(doc.getGioiTinh());
					vec.add(doc.getSdt());
					vec.add(doc.getDiachi());
					///////////////////////
					vec.add(doc.getNamSinh());
					/////////////////

					dtmnguoidan.addRow(vec);
				}
			}
		});
		btnTimkiemnguoidan.setIcon(new ImageIcon("img\\Search.png"));
		btnTimkiemnguoidan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimkiemnguoidan.setBounds(765, 316, 120, 53);
		pnNguoiDan.add(btnTimkiemnguoidan);

		lblTimKiem = new JLabel("T??m Ki???m");
		lblTimKiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTimKiem.setBounds(98, 322, 91, 36);
		pnNguoiDan.add(lblTimKiem);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(47, 404, 1005, 308);
		pnNguoiDan.add(scrollPane_1);
		dtmnguoidan = new DefaultTableModel();
		dtmnguoidan.addColumn("M?? Ng?????i D??n");
		dtmnguoidan.addColumn("H??? V?? T??n");
		dtmnguoidan.addColumn("Gi???i T??nh");
		dtmnguoidan.addColumn("S??? ??i???n Th???oi");
		dtmnguoidan.addColumn("?????a Ch???");
		
		////////////////////
		dtmnguoidan.addColumn("N??m sinh");
		///////////////////
		
		tablenguoidan = new MyTable(dtmnguoidan);
		scrollPane_1.setViewportView(tablenguoidan);
		JPopupMenu popupMenu = new JPopupMenu();
		mntmNewMenuItem = new JMenuItem("Test-C???p th???");
		mntmNewMenuItem.setBounds(0, 0, 113, 19);
		mntmNewMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = tablenguoidan.getSelectedRow();
				if (i > -1) {
					int ma = Integer.parseInt(dtmnguoidan.getValueAt(i, 0).toString());
					tv = TestTheQuanLyDAL.thongtinthe(ma);
					//System.out.println("C??i c???n l???y " + tv);
					if(tv.getMaTheThuVien() != 0) {
//						System.out.println(tv);
						GUI.The the = new GUI.The();
						the.setVisible(true);
					}
					else {
						int a = JOptionPane.showConfirmDialog(null, "Th??nh Vi??n n??y ch??a c?? th??? t??i kho???n b???n c?? mu???n th??m th??? kh??ng", "", JOptionPane.YES_NO_OPTION);
						if (a == JOptionPane.YES_OPTION) {
							int maDocGia = Integer.parseInt(dtmnguoidan.getValueAt(i, 0).toString());
							String tenDocGia = dtmnguoidan.getValueAt(i, 1).toString();
							String gioiTinh = dtmnguoidan.getValueAt(i, 2).toString();
							String diachi = dtmnguoidan.getValueAt(i, 3).toString();
							String sdt = dtmnguoidan.getValueAt(i, 4).toString();
							/////////////
							String namSinh = dtmnguoidan.getValueAt(i, 5).toString();
							////////////////////
							
							
							 thethanhvien = new NguoiDan(maDocGia, tenDocGia, gioiTinh, diachi, sdt, namSinh);
							GUI.The the = new GUI.The();
							the.setVisible(true);
						}
					}
					
				}

			}
		});
		popupMenu.add(mntmNewMenuItem);

		addPopup(tablenguoidan, popupMenu);

	}

	private void pntacgia() {

		pnDangKyTiem = new JPanel();
		pnDangKyTiem.setLayout(null);

		pnthongtinDangKyTiem = new JPanel();
		pnthongtinDangKyTiem.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnthongtinDangKyTiem.setBounds(158, 78, 607, 281);
		pnDangKyTiem.add(pnthongtinDangKyTiem);
		pnthongtinDangKyTiem.setLayout(null);

		lblTentacgia = new JLabel("Ng??y ????ng K??");
		lblTentacgia.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTentacgia.setBounds(35, 15, 152, 37);
		pnthongtinDangKyTiem.add(lblTentacgia);
		//l???a ch???n ng?????i d??n n??o ????ng k??
		////////////////
		cmbnguoidandangky = new JComboBox();
		cmbnguoidandangky.setBounds(250, 65, 300, 37);
		cmbnguoidandangky.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (cmbnguoidandangky.getSelectedItem() == null) {
					return;
				}
				dgsl = (NguoiDan) cmbnguoidandangky.getSelectedItem();

			}
		});
		pnthongtinDangKyTiem.add(cmbnguoidandangky);
		///////////////
		
		//dateChooser_dangkyngaymuontiem

		dateChooser_dangkytiem = new JDateChooser();
		dateChooser_dangkytiem.setDateFormatString("yyyy-MM-dd");
		dateChooser_dangkytiem.setEnabled(false);
		dateChooser_dangkytiem.setDate(Calendar.getInstance().getTime());
		dateChooser_dangkytiem.setBounds(250, 15, 300, 37);
		pnthongtinDangKyTiem.add(dateChooser_dangkytiem);

		lblnamsinh = new JLabel("Ng??y mu???n ti??m");
		lblnamsinh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnamsinh.setBounds(35, 165, 152, 37);
		pnthongtinDangKyTiem.add(lblnamsinh);
		//ngay muon tiem
		dateChooser_dangkyngaymuontiem = new JDateChooser();
		dateChooser_dangkyngaymuontiem.setDateFormatString("yyyy-MM-dd");
		dateChooser_dangkyngaymuontiem.setEnabled(true);
		dateChooser_dangkyngaymuontiem.setDate(Calendar.getInstance().getTime());
		dateChooser_dangkyngaymuontiem.setBounds(250, 165, 300, 37);
		pnthongtinDangKyTiem.add(dateChooser_dangkyngaymuontiem);
		
		//?????a ??i???m mu???n ti??m
		txtnamsinhtacgia = new JTextField();
		txtnamsinhtacgia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtnamsinhtacgia.setColumns(10);
		txtnamsinhtacgia.setBounds(250, 215, 300, 37);
		pnthongtinDangKyTiem.add(txtnamsinhtacgia);
		////////////////////////
		lbldiadiemmuontiem = new JLabel("G??i Ti??m");
		lbldiadiemmuontiem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbldiadiemmuontiem.setBounds(35, 215, 152, 37);
		pnthongtinDangKyTiem.add(lbldiadiemmuontiem);
		////////////////////////////////////
		lblCCCD = new JLabel("M?? CCCD");
		lblCCCD.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCCCD.setBounds(35, 65, 300, 37);
		pnthongtinDangKyTiem.add(lblCCCD);
		
		lblTentacgia_2 = new JLabel("Lo???i V???c-xin ??/k??");
		lblTentacgia_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTentacgia_2.setBounds(35, 115, 152, 37);
		pnthongtinDangKyTiem.add(lblTentacgia_2);

		txtQueQuan = new JTextField();
		txtQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtQueQuan.setColumns(10);
		txtQueQuan.setBounds(250, 115, 300, 37);
		pnthongtinDangKyTiem.add(txtQueQuan);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(158, 430, 792, 281);
		pnDangKyTiem.add(scrollPane_2);

		dtmtacgia = new DefaultTableModel();
		dtmtacgia.addColumn("M?? ????ng K?? Ti??m");
		dtmtacgia.addColumn("Ng??y ????ng K?? ");
		dtmtacgia.addColumn("G??i Ti??m");
		dtmtacgia.addColumn("Lo???i V???c-xin ??/k");
		
		dtmtacgia.addColumn("M?? CCCD1");
		dtmtacgia.addColumn("Ng??y mu???n ti??m");
		
		tabletacgia = new MyTable(dtmtacgia);
		scrollPane_2.setViewportView(tabletacgia);

		btnThemTacgia = new JButton("Th??m");
		btnThemTacgia.setIcon(new ImageIcon("img\\Add.png"));
		btnThemTacgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemTacgia.setBounds(819, 78, 126, 54);
		pnDangKyTiem.add(btnThemTacgia);

		btnsuatacgia = new JButton("S???a");
		btnsuatacgia.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuatacgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsuatacgia.setBounds(819, 144, 126, 47);
		pnDangKyTiem.add(btnsuatacgia);

		btnxoatacgia = new JButton("Xo??");
		btnxoatacgia.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoatacgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxoatacgia.setBounds(819, 203, 126, 47);
		pnDangKyTiem.add(btnxoatacgia);

		btnreloadtacgia = new JButton("T???i L???i");
		btnreloadtacgia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadtacgia();
			}
		});
		btnreloadtacgia.setIcon(new ImageIcon("img\\update.png"));
		btnreloadtacgia.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnreloadtacgia.setBounds(819, 262, 126, 47);
		pnDangKyTiem.add(btnreloadtacgia);

	}

	private void pnVaccine() {

		pnVaccine = new JPanel();

		pnVaccine.setLayout(null);

		lbltitlepnVaccine = new JLabel("Vaccine");
		lbltitlepnVaccine.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbltitlepnVaccine.setBounds(502, 0, 100, 77);
		pnVaccine.add(lbltitlepnVaccine);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(66, 77, 788, 273);
		pnVaccine.add(panel);
		panel.setLayout(null);

		lblTenVaccine = new JLabel("T??n Vaccine");
		lblTenVaccine.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTenVaccine.setBounds(12, 13, 112, 34);
		panel.add(lblTenVaccine);

		lblMaLoai = new JLabel("M?? Lo???i");
		lblMaLoai.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaLoai.setBounds(12, 64, 112, 34);
		panel.add(lblMaLoai);

		lblNewLabel_2 = new JLabel("M?? Nh?? Cung C???p");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(12, 111, 132, 34);
		panel.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("H???n s??? d???ng");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(12, 160, 112, 34);
		panel.add(lblNewLabel_3);

		lblHinhAnh = new JLabel("H??nh ???nh");
		lblHinhAnh.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHinhAnh.setBounds(398, 13, 112, 34);
		panel.add(lblHinhAnh);

		lblnamSx = new JLabel("N??m S???n Xu???t");
		lblnamSx.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblnamSx.setBounds(398, 64, 112, 34);
		panel.add(lblnamSx);

		lblSLng = new JLabel("S??? L?????ng");
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSLng.setBounds(398, 111, 112, 34);
		panel.add(lblSLng);

		lblMaKe = new JLabel("M?? K???");
		lblMaKe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMaKe.setBounds(398, 160, 112, 34);
		panel.add(lblMaKe);

		txttenVaccine = new JTextField();
		txttenVaccine.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txttenVaccine.setBounds(156, 14, 203, 34);
		panel.add(txttenVaccine);
		txttenVaccine.setColumns(10);

		cmbmaloai = new JComboBox();
		cmbmaloai.setBounds(156, 71, 203, 27);
		cmbmaloai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (cmbmaloai.getSelectedItem() == null) {
					return;
				}
				loaisl = (LoaiDTO) cmbmaloai.getSelectedItem();

			}
		});
		panel.add(cmbmaloai);

		cmbmanhaSx = new JComboBox();
		cmbmanhaSx.setBounds(156, 118, 203, 27);
		cmbmanhaSx.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (cmbmanhaSx.getSelectedItem() == null) {
					return;
				}
				nxbsl = (NhaSanXuat) cmbmanhaSx.getSelectedItem();
			}
		});
		panel.add(cmbmanhaSx);
//??ang fix
		
		cmbmatg = new JComboBox();
		cmbmatg.setBounds(156, 160, 203, 27);
		cmbmatg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (cmbmatg.getSelectedItem() == null) {
					return;
				}
				tacgiasl = (DangKyTiemDTO) cmbmatg.getSelectedItem();
			}
		});
		panel.add(cmbmatg);

		cmbmake = new JComboBox();
		cmbmake.setBounds(522, 160, 207, 27);
		cmbmake.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (cmbmake.getSelectedItem() == null) {
					return;
				}
				kesl = (KeDTO) cmbmake.getSelectedItem();
			}
		});
		panel.add(cmbmake);

		txtsoluongVaccine = new JTextField();
		txtsoluongVaccine.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtsoluongVaccine.setBounds(522, 111, 207, 34);
		panel.add(txtsoluongVaccine);
		txtsoluongVaccine.setColumns(10);

		txtnamSx = new JTextField();
		txtnamSx.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtnamSx.setColumns(10);
		txtnamSx.setBounds(522, 64, 207, 34);
		panel.add(txtnamSx);

		JButton btnNewButton = new JButton("Ch???n ???nh");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				xuLyChonAnh();
			}
		});
		btnNewButton.setBounds(522, 19, 112, 28);
		panel.add(btnNewButton);

		btnthemsach = new JButton("Th??m");
		btnthemsach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnthemsach.setIcon(new ImageIcon("img\\Add.png"));
		btnthemsach.setBounds(32, 206, 112, 53);
		panel.add(btnthemsach);

		btnsuasach = new JButton("S???a");
		btnsuasach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsuasach.setIcon(new ImageIcon("img\\Edit.png"));
		btnsuasach.setBounds(213, 206, 112, 51);
		panel.add(btnsuasach);

		btnxoasach = new JButton("Xo??");
		btnxoasach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxoasach.setIcon(new ImageIcon("img\\Delete.png"));
		btnxoasach.setBounds(408, 206, 112, 51);
		panel.add(btnxoasach);

		btnloadlaitrang = new JButton("T???i L???i");
		btnloadlaitrang.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnloadlaitrang.setIcon(new ImageIcon("img\\update.png"));
		btnloadlaitrang.setBounds(620, 204, 112, 53);
		panel.add(btnloadlaitrang);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 456, 1024, 273);
		pnVaccine.add(scrollPane);
		dtmVAccine = new DefaultTableModel();
		dtmVAccine.addColumn("M?? Vaccine");
		dtmVAccine.addColumn("T??n Vaccine");
		dtmVAccine.addColumn("M?? Nh?? Khoa H???c");
		dtmVAccine.addColumn("M?? Nh?? Cung C???p");
		dtmVAccine.addColumn("M?? Lo???i");
		dtmVAccine.addColumn("N??m S???n Xu???t");
		dtmVAccine.addColumn("S??? L?????ng");
		dtmVAccine.addColumn("M?? K???");
		dtmVAccine.addColumn("???nh");

		tableVaccine = new MyTable(dtmVAccine);
		scrollPane.setViewportView(tableVaccine);
		JPopupMenu popupMenu = new JPopupMenu();
		mntmNewMenuItem = new JMenuItem("Th??ng tin chi ti???t");
		mntmNewMenuItem.setBounds(0, 0, 113, 19);
		popupMenu.add(mntmNewMenuItem);

		addPopup(tableVaccine, popupMenu);

	}

	private void trangchu() {

		pnTrangChu = new JPanel();

		pnTrangChu.setLayout(null);

		/* PANEL NH??N VI??N */

		lblNewLabel = new JLabel("QU???N L?? TH??NG TIN TI??M V???C-XIN");
		lblNewLabel.setForeground(new Color(255, 20, 147));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setBounds(150, 41, 945, 185);
		pnTrangChu.add(lblNewLabel);
	}

	public void addEvent() {

		btnlocthongke.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				thongkectphieunhap = null;

				if (!rdloctheonam.isSelected() && !rdloctheongay.isSelected()) {
					JOptionPane.showMessageDialog(null, "B???n c???n ch???n l???c theo ng??y / n??m");
					return;
				}
				if (namselect.equals("") && ngaybd.getDate() == null && ngayketthuc.getDate() == null) {
					JOptionPane.showMessageDialog(null, "B???n ch??a ch???n n??m");
					return;
				}
				if (namselect != "" && rdloctheonam.isSelected()) {
					int tong1 = 0;
					int soluong1 = 0;
					ngaybd.setDate(null);
					ngayketthuc.setDate(null);
					thongkectphieunhap = ChiTietPhieuNhapBUS.gI().getthongkenam(Integer.parseInt(namselect));

					dtmthongkenhaphang.setRowCount(0);

					for (ChiTietPhieuNhap pn : thongkectphieunhap) {

						Vector<Object> vec = new Vector<Object>();
						vec.add(pn.getMaCTPN());
						vec.add(pn.getMaPhieuNhap());
						vec.add(pn.getMaSach());
						vec.add(pn.getGia());
						vec.add(pn.getSoLuong());
						vec.add(pn.getThanhTien());
						vec.add(pn.getNgaynhap());
						vec.add(pn.getTensach());
						soluong1 += pn.getSoLuong();
						tong1 += pn.getThanhTien();
						dtmthongkenhaphang.addRow(vec);

						// dtmctpm.addRow(vec);

					}
					lbltongtien.setText(tong1 + "");
					lblsosachdanhap.setText(soluong1 + "");

				} else if (ngaybd.getDate() != null && ngayketthuc.getDate() != null && rdloctheongay.isSelected()) {
					int tong2 = 0;
					int soluong3 = 0;
					namselect = "";
					comboBox.setSelectedIndex(0);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String date1 = sdf.format(ngaybd.getDate());
					String date2 = sdf.format(ngayketthuc.getDate());
					System.out.println(date2);
					thongkectphieunhap = ChiTietPhieuNhapBUS.gI().getthongketheongay(date1, date2);

					dtmthongkenhaphang.setRowCount(0);

					for (ChiTietPhieuNhap pn : thongkectphieunhap) {

						Vector<Object> vec = new Vector<Object>();
						vec.add(pn.getMaCTPN());
						vec.add(pn.getMaPhieuNhap());
						vec.add(pn.getMaSach());
						vec.add(pn.getGia());
						vec.add(pn.getSoLuong());
						vec.add(pn.getThanhTien());
						vec.add(pn.getNgaynhap());
						vec.add(pn.getTensach());
						dtmthongkenhaphang.addRow(vec);
						soluong3 += pn.getSoLuong();
						tong2 += pn.getThanhTien();
						// dtmctpm.addRow(vec);
					}
					lbltongtien.setText(tong2 + "");
					lblsosachdanhap.setText(soluong3 + "");

				}

			}

		});
		/////////////////////////////////////////////////////////////////////////////
		/////////// TIM KIEM TONG HOP////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////

		btnloadlaitrang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadVaccine();

			}
		});
		btnthongkesachmuon.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TableThongKePhieuTiem().setVisible(true);

			}
		});
		tablectpt.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = tablectpt.getSelectedRow();
				if (i >= 0) {
					Date date2;
					try {
						date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) dtmctpt.getValueAt(i, 3).toString());
						dateChooser_ngaytra.setDate(date2);
						txtmaVaccineTiem.setText(dtmctpt.getValueAt(i, 2).toString());
						txtghichuctpt.setText(dtmctpt.getValueAt(i, 4).toString());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		btninphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = tablephieunhap.getSelectedRow();
				if (i > -1) {
					int ma = Integer.parseInt(dtmphieunhap.getValueAt(i, 0).toString());

					Export.WritePDF wpdf = new WritePDF();
					wpdf.xuatPDFPhieuNhap(tablechitietphieunhap, ma);

				} else {
					JOptionPane.showMessageDialog(null, "B???n Ch??a Click V??o Table ????? Xu???t Ho?? ????n");
				}

			}
		});
		btnxuatexcel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Export.ExportExcel ex = new ExportExcel();
				ex.xuatExcel(tablephieunhap);

			}
		});
		btnnhapexcel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Export.ImportExcel ix = new ImportExcel();
				ix.nhapExcel(tablephieunhap);

			}
		});

		btnmanvphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TableNhanVien().setVisible(true);

			}
		});

		btnmanccphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TableNCC().setVisible(true);

			}
		});
		btnmanvphieunhap_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TableVaccine().setVisible(true);

			}
		});
		tablephieunhap.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int i = tablephieunhap.getSelectedRow();
				if (i >= 0) {
					mapn = Integer.parseInt(dtmphieunhap.getValueAt(i, 0).toString());
					lblmaphieunhap.setText("M?? Phi???u Nh???p " + mapn);
					txtManhanvienphieunhap.setText(dtmphieunhap.getValueAt(i, 0).toString());
					txtManccPhieuNhap.setText(dtmphieunhap.getValueAt(i, 1).toString());
					Date date2;
					try {
						date2 = new SimpleDateFormat("yyyy-MM-dd")
								.parse((String) dtmphieunhap.getValueAt(i, 3).toString());
						NgayNhapPhieuNhap.setDate(date2);

					} catch (ParseException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					int maphieunhap = mapn;
					dtmchitietphieunhap.setRowCount(0);
					for (ChiTietPhieuNhap ct : ctphieunhap) {

						if (ct.getMaPhieuNhap() == maphieunhap) {
							Vector vec = new Vector();
							vec.add(ct.getMaCTPN());
							vec.add(ct.getMaPhieuNhap());
							vec.add(ct.getMaSach());
							vec.add(ct.getGia());
							vec.add(ct.getSoLuong());
							vec.add(ct.getThanhTien());
							dtmchitietphieunhap.addRow(vec);
						}
					}
				}

			}
		});

		tablechitietphieunhap.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int i = tablechitietphieunhap.getSelectedRow();
				if (i >= 0) {
					lblmaphieunhap.setText("M?? Phi???u Nh???p " + dtmchitietphieunhap.getValueAt(i, 1).toString());
					txtMaSachctpn.setText(dtmchitietphieunhap.getValueAt(i, 2).toString());
					txtsoluongctpn.setText(dtmchitietphieunhap.getValueAt(i, 3).toString());
					txtgianhap.setText(dtmchitietphieunhap.getValueAt(i, 4).toString());

				}

			}
		});
		tablemuon.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = tablemuon.getSelectedRow();
				if (i >= 0) {
					try {
						//ch?? ??
						Date date = new SimpleDateFormat("yyyy-MM-dd")
								.parse((String) dtmTiem.getValueAt(i, 3).toString());

						dateChooser.setDate(date);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					txtmapt.setText(dtmTiem.getValueAt(i, 0).toString());
					Ma = (dtmTiem.getValueAt(i, 0).toString());
					String tinhtrang = dtmTiem.getValueAt(i, 4).toString();
					if (tinhtrang.equals("T???t")) {
						rdTiem.setSelected(true);
					} else {
						rdtra.setSelected(true);
					}
					String ngay = dtmTiem.getValueAt(i, 3).toString();

					for (int j = 0; j < nv.size(); j++) {
						if (nv.get(j).getMaNV() == Integer.parseInt(dtmTiem.getValueAt(i, 1).toString())) {
							cmbnhanvienpm.setSelectedIndex(j);
							break;
						}
					}
					for (int j = 0; j < dg.size(); j++) {
						if (dg.get(j).getMaDocGia() == Integer.parseInt(dtmTiem.getValueAt(i, 2).toString())) {
							cmbmaVaccinephieuTiem.setSelectedIndex(j);
							///////////
							
							///////////
							break;
						}
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					dtmctpt.setRowCount(0);
					for (int k = 0; k < ctpm.size(); k++) {
						if (ctpm.get(k).getMaPhieuMuon() == Integer.parseInt(dtmTiem.getValueAt(i, 0).toString())) {
							Vector<Object> vec = new Vector<Object>();
							vec.add(ctpm.get(k).getMaChiTietPhieuMuon());
							vec.add(ctpm.get(k).getMaPhieuMuon());
							vec.add(ctpm.get(k).getMaSach());
							vec.add(ctpm.get(k).getNgayTra());
							vec.add(ctpm.get(k).getGhichu());
							dtmctpt.addRow(vec);

						}

					}
					Date date2;
					try {
						date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) dtmctpt.getValueAt(0, 3).toString());
						dateChooser_ngaytra.setDate(date2);
						txtmaVaccineTiem.setText(dtmctpt.getValueAt(0, 2).toString());
						txtghichuctpt.setText(dtmctpt.getValueAt(0, 4).toString());
					} catch (Exception e) {

					}
				}

			}
		});
		tablenguoidan.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				int i = tablenguoidan.getSelectedRow();
				if (i >= 0) {
					
					//////////
					txtmaCCCD.setText(dtmnguoidan.getValueAt(i, 0).toString());
					///////////
					
					txtTennguoidan.setText(dtmnguoidan.getValueAt(i, 1).toString());
					txtgioitinhnguoidan.setText(dtmnguoidan.getValueAt(i, 2).toString());
					txtdiachinguoidan.setText(dtmnguoidan.getValueAt(i, 4).toString());
					txtsdtnguoidan.setText(dtmnguoidan.getValueAt(i, 3).toString());
					///////////////////////
					txtnamsinhnguoidan.setText(dtmnguoidan.getValueAt(i, 5).toString());
					//////////////////////
				}

			}
		});
		tabletacgia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tabletacgia.getSelectedRow();
				if (i >= 0) {
					
					/*
					tacgiasl = (TacGiaDTO) cmbmatg.getSelectedItem();
					*/
					//??ang fix (nagyf ????ng k?? ch??a ch???y theo khi click chu???t
					//txtTentacgia.setText(dtmtacgia.getValueAt(i, 1).toString());
					
					txtnamsinhtacgia.setText(dtmtacgia.getValueAt(i, 2).toString());
					txtQueQuan.setText(dtmtacgia.getValueAt(i, 3).toString());
					/////////////
					for (int j = 0; j < dg.size(); j++) {
						if (dg.get(j).getMaDocGia() == Integer.parseInt(dtmtacgia.getValueAt(i, 4).toString())) {
							cmbnguoidandangky.setSelectedIndex(j);
							///////////
							
							///////////
							break;
						}
					}
					/////////////
					 
					
				}

			}
		});

		lbldangxuat.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				lbldangxuat.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				lbldangxuat.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				setVisible(false);
				isdangxuat = true;
				new LoginForm().setVisible(true);
				return;

			}
		});
		lblchung.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				lblchung.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				lblchung.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				pnTrangChu.show(false);
				pnVaccine.show(false);
				pnNguoiDan.show(false);
				pnDangKyTiem.show(false);
				pnnhaSanXuat.show(false);
				pnnhanvien.show(false);
				pnPhieuTiem.show(false);
				pnchung.show();
				panelThongKe.show(false);
				pnPhieuNhap.show(false);
			}
		});
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		lblnhanvien.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblnhanvien.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblnhanvien.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnVaccine.show(false);
				pnNguoiDan.show(false);
				pnDangKyTiem.show(false);
				pnnhaSanXuat.show(false);
				pnnhanvien.show(true);
				pnPhieuTiem.show(false);
				pnchung.show(false);
				panelThongKe.show(false);
				pnPhieuNhap.show(false);
			}
		});

		lblnhaSx.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblnhaSx.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblnhaSx.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnVaccine.show(false);
				pnNguoiDan.show(false);
				pnDangKyTiem.show(false);
				pnnhaSanXuat.show(true);
				pnnhanvien.show(false);
				pnPhieuTiem.show(false);
				pnchung.show(false);
				panelThongKe.show(false);
				pnPhieuNhap.show(false);
			}

		});
		lbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lbl.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lbl.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnVaccine.show(false);
				pnNguoiDan.show(true);
				pnDangKyTiem.show(false);
				pnnhaSanXuat.show(false);
				pnnhanvien.show(false);
				pnPhieuTiem.show(false);
				pnchung.show(false);
				panelThongKe.show(false);
				pnPhieuNhap.show(false);
			}
		});
		lblTrangchu.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				lblTrangchu.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				lblTrangchu.setBackground(Color.BLUE);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				pnTrangChu.show();
				pnVaccine.show(false);
				pnNguoiDan.show(false);
				pnDangKyTiem.show(false);
				pnnhaSanXuat.show(false);
				pnnhanvien.show(false);
				pnPhieuTiem.show(false);
				pnchung.show(false);
				pnPhieuNhap.show(false);
				panelThongKe.show(false);
			}
		});

		lblVaccine1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblVaccine1.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblVaccine1.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnVaccine.show(true);
				pnNguoiDan.show(false);
				pnDangKyTiem.show(false);
				pnnhaSanXuat.show(false);
				pnnhanvien.show(false);
				pnPhieuTiem.show(false);
				pnchung.show(false);
				panelThongKe.show(false);
				pnPhieuNhap.show(false);
			}
		});
		lbltacgia.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lbltacgia.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lbltacgia.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				// lblTitle.setText("T??c Gi???");
				pnTrangChu.show(false);
				pnVaccine.show(false);
				pnNguoiDan.show(false);
				pnDangKyTiem.show(true);
				pnnhaSanXuat.show(false);
				pnnhanvien.show(false);
				pnPhieuTiem.show(false);

				pnchung.show(false);
				panelThongKe.show(false);
				pnPhieuNhap.show(false);
			}
		});

		lblthongke.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblthongke.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblthongke.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnVaccine.show(false);
				pnNguoiDan.show(false);
				pnDangKyTiem.show(false);
				pnnhaSanXuat.show(false);
				pnnhanvien.show(false);
				pnPhieuTiem.show(false);
				pnchung.show(false);

				panelThongKe.show();

				pnPhieuNhap.show(false);
			}
		});

		lblphieutiem.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

				lblphieutiem.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblphieutiem.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent e) {

				pnTrangChu.show(false);
				pnVaccine.show(false);
				pnNguoiDan.show(false);
				pnDangKyTiem.show(false);
				pnnhaSanXuat.show(false);
				pnnhanvien.show(false);
				pnPhieuTiem.show();
				pnPhieuNhap.show(false);
				pnchung.show(false);
				panelThongKe.show(false);
			}
		});
		lblphieunhap.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

				lblphieunhap.setBackground(new Color(64, 64, 64));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				lblphieunhap.setBackground(Color.blue);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				pnTrangChu.show(false);
				pnVaccine.show(false);
				pnNguoiDan.show(false);
				pnDangKyTiem.show(false);
				pnnhaSanXuat.show(false);
				pnnhanvien.show(false);
				pnPhieuTiem.show(false);
				pnPhieuNhap.show();
				pnchung.show(false);
				panelThongKe.show(false);
			}
		});

		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent arg0) {

				x_mouse = arg0.getX();
				y_mouse = arg0.getY();

			}

			@Override
			public void mouseDragged(MouseEvent arg0) {

				moveFrame(arg0.getXOnScreen(), arg0.getYOnScreen());

			}

		});
		tableloai.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int i = -1;
				i = tableloai.getSelectedRow();
				if (i >= 0) {
					txttenloai.setText(dtmloai.getValueAt(i, 1).toString());
				}
			}
		});
		;
		tableVaccine.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i = tableVaccine.getSelectedRow();
				if (i > -1) {
					txttenVaccine.setText(dtmVAccine.getValueAt(i, 1).toString());
					int maloai = Integer.parseInt(dtmVAccine.getValueAt(i, 2).toString());
					int manxb = Integer.parseInt(dtmVAccine.getValueAt(i, 3).toString());
					int matg = Integer.parseInt(dtmVAccine.getValueAt(i, 4).toString());
					int make = Integer.parseInt(dtmVAccine.getValueAt(i, 7).toString());
					txtnamSx.setText(dtmVAccine.getValueAt(i, 5).toString());
					txtsoluongVaccine.setText(dtmVAccine.getValueAt(i, 6).toString());
					hinhanh = dtmVAccine.getValueAt(i, 8).toString();
					lblhinhanhpre.setIcon(getAnhSP(hinhanh));
				}

			}
		});
		tablencc.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int i = -1;
				i = tablencc.getSelectedRow();
				if (i >= 0) {
					txtNcc.setText(dtmncc.getValueAt(i, 1).toString());
				}
			}
		});

		tableke.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {

				int i = -1;
				i = tableke.getSelectedRow();
				if (i >= 0) {
					txtKe.setText("" + dtmke.getValueAt(i, 1));
				}
			}
		});

		btnthemke.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				KeDTO ke = new KeDTO(2, txtKe.getText());
				if (KeBus.gI().themke(ke) >= 0) {
					loadkesach();
					// JOptionPane.showMessageDialog(contentPane, "Th??m Th??nh C??ng");
				} else {
					JOptionPane.showMessageDialog(contentPane, "Th??m Th???t b???i");
				}
			}
		});
		btnsuake.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tableke.getSelectedRow();
				if (i > -1) {
					int vitri = Integer.parseInt(dtmke.getValueAt(i, 0).toString());
					KeDTO ke = new KeDTO(vitri, txtKe.getText());
					if (KeBus.gI().suake(ke) >= 0) {
						loadkesach();
					} else {
						JOptionPane.showMessageDialog(contentPane, "S???a Th???t b???i");
					}
				} else {
					JOptionPane.showMessageDialog(null, "B???n ch??a ch???n k??? n??o.");
				}
			}
		});
		btnxoake.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = tableke.getSelectedRow();
				if (i > -1) {
					int vitri = Integer.parseInt(dtmke.getValueAt(i, 0).toString());
					KeDTO ke = new KeDTO(vitri, txtKe.getText());
					int a = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo??", "", JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						if (KeBus.gI().xoake(ke) >= 0) {
							loadkesach();
						} else {
							JOptionPane.showMessageDialog(contentPane, "Xo?? Th???t b???i");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "B???n ch??a ch???n k??? n??o.");
				}

			}
		});

		btnxoaloai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tableloai.getSelectedRow();
				int vitri = Integer.parseInt(dtmloai.getValueAt(i, 0).toString());
				LoaiDTO ke = new LoaiDTO(vitri, txttenloai.getText());
				int a = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo??", "", JOptionPane.YES_NO_OPTION);
				if (a == JOptionPane.YES_OPTION) {
					int j = LoaiBUS.gI().xoaloai(ke);
					if (j > 0) {
						loadloaiVaccine();
					}
				}

			}
		});
		btnThemloai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoaiDTO loaisach = new LoaiDTO(2, txttenloai.getText());
				if (LoaiBUS.gI().themloai(loaisach) >= 0) {
					loadloaiVaccine();
				}
			}
		});

		btnsualoai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = tableloai.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmloai.getValueAt(i, 0).toString());
					LoaiDTO ke = new LoaiDTO(vitri, txttenloai.getText());
					int a = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n s???a", "", JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						if (LoaiBUS.gI().sualoai(ke) >= 0) {
							loadloaiVaccine();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "B???n ch??a ch???n lo???i n??o");
				}

			}
		});

		btnxoancc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablencc.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmncc.getValueAt(i, 0).toString());
					NhaCungCapDTO ncc = new NhaCungCapDTO(vitri, txtNcc.getText());
					int a = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo??", "", JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						int j = NhaCungcapbus.gI().xoancc(ncc);
						if (j > 0) {
							loadnhacungcap();
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "B???n ch??a ch???n nh?? cung c???p n??o.");
				}

			}
		});
		btnThemncc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				NhaCungCapDTO ncc = new NhaCungCapDTO(0, txtNcc.getText());
				int j = NhaCungcapbus.gI().themncc(ncc);
				if (j > 0) {
					loadnhacungcap();
				}
			}
		});

		btnsuancc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablencc.getSelectedRow();
				if (i > -1) {
					int vitri = Integer.parseInt(dtmncc.getValueAt(i, 0).toString());
					NhaCungCapDTO ncc = new NhaCungCapDTO(vitri, txtNcc.getText());
					int j = NhaCungcapbus.gI().suancc(ncc);
					if (j > 0) {
						loadnhacungcap();
					}
				} else {
					JOptionPane.showMessageDialog(null, "B???n ch??a ch???n nh?? cung c???p n??o");
				}
			}
		});
		tablenhanvien.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

				int i = tablenhanvien.getSelectedRow();
				if (i >= 0) {
					txttennv.setText(dtmnhanvien.getValueAt(i, 1).toString());
					txtnamsinhnv.setText(dtmnhanvien.getValueAt(i, 2).toString());
					txtgioitinhnv.setText(dtmnhanvien.getValueAt(i, 3).toString());
					txtdiachinv.setText(dtmnhanvien.getValueAt(i, 4).toString());
					txtsodienthoainv.setText(dtmnhanvien.getValueAt(i, 5).toString());
					////////
					txtdonvitiem.setText(dtmnhanvien.getValueAt(i, 6).toString());
					//////////

				}
			}
		});

		btnsuanv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablenhanvien.getSelectedRow();
				if (i > -1) {
					int vitri = Integer.parseInt(dtmnhanvien.getValueAt(i, 0).toString());
					// JOptionPane.showMessageDialog(contentPane, vitri);
					SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
					NhanVien nv;
					nv = new NhanVien(vitri, txttennv.getText(), txtnamsinhnv.getText(), txtgioitinhnv.getText(),
							txtsodienthoainv.getText(), txtdiachinv.getText(),txtdonvitiem.getText());

					int j = NhanVienBus.gI().suanhanvien(nv);
					if (j > 0) {
						loadnhanvien();
					}

				} else {
					JOptionPane.showMessageDialog(null, "B???n ch??ua ch???n nh??n vi??n n??o h???t");
				}
			}
		});

		btnthemnv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NhanVien nv;
				nv = new NhanVien(0, txttennv.getText(), txtnamsinhnv.getText(), txtgioitinhnv.getText(),
						txtsodienthoainv.getText(), txtdiachinv.getText(),txtdonvitiem.getText());
				int j = NhanVienBus.gI().themnhanvien(nv);
				if (j > 0) {
					loadnhanvien();
				}

			}
		});
		btnxoanv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int i = tablenhanvien.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmnhanvien.getValueAt(i, 0).toString());
					SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
					NhanVien nv;
					nv = new NhanVien(vitri, txttennv.getText(), txtnamsinhnv.getText(), txtgioitinhnv.getText(),
							txtsodienthoainv.getText(), txtdiachinv.getText(),txtdonvitiem.getText());
					int a = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo??", "", JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						int j = NhanVienBus.gI().xoanhanvien(nv);
						if (j > 0) {
							loadnhanvien();
						}
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "B???n Ch??a Ch???n v??o table");
				}
			}
		});

		txtTimKiemnv.getDocument().addDocumentListener(new DocumentListener() {
			// text field t??m ki???m nh??n vi??n
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// text field thay ?????i g???i l???i search
				searchNv();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// text field thay ?????i g???i l???i search
				searchNv();
			}

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// text field thay ?????i g???i l???i search
				searchNv();
			}

			public void searchNv() {
				// JOptionPane.showMessageDialog(contentPane, "Ch???y t???i ????y");
				try {
					dtmnhanvien.setRowCount(0);
					////// m???i l???n g???i l???i xo?? m???a c??i table ??i
					if (txtTimKiemnv.getText().isEmpty()) {
						// n???u txtfield r???ng th?? hi???n th??? l???i c??i b???ng ?????y ?????
						loadnhanvien(); // h??m ?????y t??? csdl v??o b???ng //
						return;
					}
					String s = txtTimKiemnv.getText().toLowerCase(); // chuy???n ch??? trong txtfield v??? ch??? th?????ng
					// nh??? v m?? seach ch??? th?????ng ch??? hoa g?? c??ng ra h???t
					for (NhanVien nv : nv) {
						if (nv.getTenNV().toLowerCase().contains(s)) {
							// ????ng ??i???u ki???n th?? ?????y n?? v??o table
							Vector<Object> vec = new Vector<Object>();
							vec.add(nv.getMaNV());
							vec.add(nv.getTenNV());
							vec.add(nv.getNamSinh());
							vec.add(nv.getGioiTinh());
							vec.add(nv.getDiaChi());
							vec.add(nv.getSdt());
							dtmnhanvien.addRow(vec);
						}
						// .DesignLai.dtm.addRow(vec);
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		tablenhaSx.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {

			}

			@Override
			public void mousePressed(MouseEvent arg0) {

			}

			@Override
			public void mouseExited(MouseEvent arg0) {

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {

				int i = tablenhaSx.getSelectedRow();
				if (i >= 0) {
					txtTennhaSx.setText(dtmnhaSx.getValueAt(i, 1).toString());
					txtdiachinhaSx.setText(dtmnhaSx.getValueAt(i, 2).toString());
					txtsdtnSx.setText(dtmnhaSx.getValueAt(i, 3).toString());
				}
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		///////////////////////////////////////////////////////////////////////////////////////
		////////////////////////// THEM SUA XOA NH?? XU???T
		/////////////////////////////////////////////////////////////////////////////////////// B???N////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////

		btnThemnSX.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NhaSanXuat nxb = new NhaSanXuat(0, txtTennhaSx.getText(), txtdiachinhaSx.getText(),
						txtsdtnSx.getText());
				int j = NhaSanXuatBUS.gI().themnxb(nxb);
				if (j > 0) {
					loadnxb();
				}

			}
		});
		btnsuaNhaSx.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = tablenhaSx.getSelectedRow();
				if (i > -1) {
					int vitri = Integer.parseInt(dtmnhaSx.getValueAt(i, 0).toString());
					NhaSanXuat nxb = new NhaSanXuat(vitri, txtTennhaSx.getText(), txtdiachinhaSx.getText(),
							txtsdtnSx.getText());
					int j = NhaSanXuatBUS.gI().suanxb(nxb);
					if (j > 0) {
						loadnxb();
					}
				} else {
					JOptionPane.showMessageDialog(null, "B???n ch??a ch???n v??o table");
				}

			}
		});

		btnxoaNhaSx.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int i = tablenhaSx.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmnhaSx.getValueAt(i, 0).toString());
					NhaSanXuat nxb = new NhaSanXuat(vitri, txtTennhaSx.getText(), txtdiachinhaSx.getText(),
							txtsdtnSx.getText());
					int a = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo??", "", JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						int j = NhaSanXuatBUS.gI().xoanxb(nxb);
						if (j > 0) {
							loadnxb();
						}
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "B???n Ch??a Ch???n v??o table");
				}
			}
		});

		/* TH??M S???A XO?? T??C GI??? *///
		/////////////////////////////////
		/////////////////////////////////

		btnThemTacgia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/////////////////////////////////
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String ngaydangky = sdf.format(dateChooser_dangkytiem.getDate());
				String ngaymuontiem = sdf.format(dateChooser_dangkyngaymuontiem.getDate());
				int madocgia = dgsl.getMaDocGia();
				////////////////////////////
				
				DangKyTiemDTO tg = new DangKyTiemDTO(0, ngaydangky , txtnamsinhtacgia.getText(),
						txtQueQuan.getText(),madocgia, ngaymuontiem);
				int j = DangKyTiemBUS.gI().themtacgia(tg);
				if (j > 0) {
					loadtacgia();
				}

			}
		});
		btnsuatacgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/////////////////////////////////
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String ngaydangky = sdf.format(dateChooser_dangkytiem.getDate());
				String ngaymuontiem = sdf.format(dateChooser_dangkyngaymuontiem.getDate());
				int madocgia = dgsl.getMaDocGia();
				////////////////////////////
				
				int i = tabletacgia.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmtacgia.getValueAt(i, 0).toString());
					DangKyTiemDTO tg = new DangKyTiemDTO(vitri, ngaydangky, txtnamsinhtacgia.getText(),
							txtQueQuan.getText(),madocgia, ngaymuontiem);
					int j = DangKyTiemBUS.gI().suatacgia(tg);
					if (j > 0) {
						loadtacgia();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "B???n ch??a ch???n v??o table");
				}

			}
		});

		btnxoatacgia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				/////////////////////////////////
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String ngaydangky = sdf.format(dateChooser_dangkytiem.getDate());
				String ngaymuontiem = sdf.format(dateChooser_dangkyngaymuontiem.getDate());
				int madocgia = dgsl.getMaDocGia();
				////////////////////////////
				
				int i = tabletacgia.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmtacgia.getValueAt(i, 0).toString());
					DangKyTiemDTO tg = new DangKyTiemDTO(vitri, ngaydangky, txtnamsinhtacgia.getText(),
							txtQueQuan.getText(),madocgia, ngaymuontiem);
					int a = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo??", "", JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						int j = DangKyTiemBUS.gI().xoatacgia(tg);
						if (j > 0) {
							loadtacgia();
						}
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "B???n Ch??a Ch???n v??o table");
				}
			}
		});
		///////////////////////////////////////////////////
		//////////////// TH??M S???A XO?? ?????C GI??? //////////////////////////txtmaCCCD.getValue().toString()
		/////////////////////////////////////////////////
		btnthemnguoidan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				//String a =  String.valueOf(txtmaCCCD);
				NguoiDan docgia = new NguoiDan(Integer.parseInt(txtmaCCCD.getText()), txtTennguoidan.getText(), txtgioitinhnguoidan.getText(),
						txtdiachinguoidan.getText(), txtsdtnguoidan.getText(), txtnamsinhnguoidan.getText());
				int j = NguoiDanBUS.gI().themdocgia(docgia);
				if (j > 0) {
					loadnguoidan();
				}

			}
		});

		btnsuanguoidan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int i = tablenguoidan.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmnguoidan.getValueAt(i, 0).toString());
					NguoiDan docgia = new NguoiDan(vitri, txtTennguoidan.getText(), txtgioitinhnguoidan.getText(),
							txtdiachinguoidan.getText(), txtsdtnguoidan.getText(), txtnamsinhnguoidan.getText());
					int j = NguoiDanBUS.gI().suadocgia(docgia);
					if (j > 0) {
						loadnguoidan();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "B???n Ch??a Ch???n v??o table");
				}
			}
		});

		btnxoanguoidan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int i = tablenguoidan.getSelectedRow();
				if (i >= 0) {
					int vitri = Integer.parseInt(dtmnguoidan.getValueAt(i, 0).toString());
					NguoiDan docgia = new NguoiDan(vitri, txtTennguoidan.getText(), txtgioitinhnguoidan.getText(),
							txtdiachinguoidan.getText(), txtsdtnguoidan.getText(), txtnamsinhnguoidan.getText());
					int a = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo??", "", JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						int j = NguoiDanBUS.gI().xoadocgia(docgia);
						if (j > 0) {
							loadnguoidan();
						}
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "B???n Ch??a Ch???n v??o table");
				}
			}
		});
		/////////////////////////// TH??M S???A XO?? S??CH///////////////////////////
		//////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////

		btnthemsach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int makesach = kesl.getMaKeSach();
				int manxb = nxbsl.getMaNXB();
				int matg = tacgiasl.getMaTacGia();
				int loai = loaisl.getMaloai();

				String tensach = txttenVaccine.getText();
				int namxb = Integer.parseInt(txtnamSx.getText());
				System.out.println(namxb);
				int soluong ;
				try {
					 soluong = Integer.parseInt(txtsoluongVaccine.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "S??? l?????ng ph???i l?? s???");
					return ;
				}

				VaccineDTO sach = new VaccineDTO(0, tensach, matg, manxb, loai, namxb, soluong, "1", hinhanh, makesach);
				int j = VaccineBus.gI().themsach(sach);
				if (j > 0) {
					loadVaccine();
				}

			}
		});

		btnsuasach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = tableVaccine.getSelectedRow();
				if (i > -1) {
					int makesach = kesl.getMaKeSach();
					int manxb = nxbsl.getMaNXB();
					int matg = tacgiasl.getMaTacGia();
					int loai = loaisl.getMaloai();

					String tensach = txttenVaccine.getText();
					int namxb = Integer.parseInt(txtnamSx.getText());
					int soluong = Integer.parseInt(txtsoluongVaccine.getText());
					int masach = Integer.parseInt(dtmVAccine.getValueAt(i, 0).toString());
					VaccineDTO sach = new VaccineDTO(masach, tensach, matg, manxb, loai, namxb, soluong, "", hinhanh,
							makesach);
					int j = VaccineBus.gI().suasach(sach);
					if (j > 0) {
						loadVaccine();
					}
				} else {
					JOptionPane.showMessageDialog(null, "B???n Ch??a Ch???n V??o B???ng");
				}

			}
		});

		btnxoasach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = tableVaccine.getSelectedRow();
				if (i > -1) {
					int makesach = kesl.getMaKeSach();
					int manxb = nxbsl.getMaNXB();
					int matg = tacgiasl.getMaTacGia();
					int loai = loaisl.getMaloai();

					String tensach = txttenVaccine.getText();
					int namxb = Integer.parseInt(txtnamSx.getText());
					int soluong = Integer.parseInt(txtsoluongVaccine.getText());
					int masach = Integer.parseInt(dtmVAccine.getValueAt(i, 0).toString());
					VaccineDTO sach = new VaccineDTO(masach, tensach, matg, manxb, loai, namxb, soluong, "", hinhanh,
							makesach);
					int a = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo??", "", JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						int j = VaccineBus.gI().xoasach(sach);
						if (j > 0) {
							loadVaccine();
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "B???n Ch??a Ch???n V??o B???ng");
				}

			}
		});

		////////////////////////////////////////////////////////////
		////////////////// * THEM SUA XOA PHIEU MUON *///////////////
		///////////////////////////////////////////////////////////

		btnthemphieuTiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (dateChooser.getDate() == null) {
					JOptionPane.showMessageDialog(null, "B???n ch??a ch???n ng??y");
					return;
				}
				if (!rdTiem.isSelected() && !rdtra.isSelected()) {
					JOptionPane.showMessageDialog(null, "B???n ch??a ch???n t??nh tr???ng");
					return;
				}

				int manv = nvsl.getMaNV();
				int madocgia = dgsl.getMaDocGia();
				/*
				if (!TheThuVienDAL.check(madocgia)) {
					JOptionPane.showMessageDialog(null, "ng?????i dnn??y ch??a c?? th??? qu???n l??, vui l??ng ????ng k?? th??? qu???n l?? v???i admin");
					return;
				}
				*/
				String tinhtrang = "T???t";

				if (rdTiem.isSelected()) {
					tinhtrang = "Theo d??i";

				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				// String ngaymuon = ((JTextField)
				// dateChooser.getDateEditor().getUiComponent()).getText();
				//ch?? ??
				String ngaymuon = sdf.format(dateChooser.getDate());
				PhieuTiem pm = new PhieuTiem(0, manv, madocgia, ngaymuon, tinhtrang);
				int j = PhieuTiemBus.gI().thempm(pm);
				if (j > 0) {
					loadphieuTiem();
				}
			}
		});

		btnsuaphieuTiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int i = tablemuon.getSelectedRow();
				if (i >= 0) {
					if (dateChooser.getDate() == null) {
						JOptionPane.showMessageDialog(null, "B???n ch??a ch???n ng??y");
						return;
					}
					if (!rdTiem.isSelected() && !rdtra.isSelected()) {
						JOptionPane.showMessageDialog(null, "B???n ch??a ch???n t??nh tr???ng");
						return;
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					// String ngaymuon = ((JTextField)
					// dateChooser.getDateEditor().getUiComponent()).getText();
					String ngaymuon = sdf.format(dateChooser.getDate());
					int vitri = Integer.parseInt(dtmTiem.getValueAt(i, 0).toString());
					String tinhtrang = tinhtrangmuon();
					PhieuTiem pm = new PhieuTiem(vitri, nvsl.getMaNV(), dgsl.getMaDocGia(), ngaymuon, tinhtrang);
					int j = PhieuTiemBus.gI().suapm(pm);
					if (j > 0) {
						loadphieuTiem();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "B???n Ch??a Ch???n v??o table");
				}
			}
		});

		btnxoaphieuTiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int i = tablemuon.getSelectedRow();
				if (i >= 0) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String ngaymuon = sdf.format(dateChooser.getDate());
					int vitri = Integer.parseInt(dtmTiem.getValueAt(i, 0).toString());
					String tinhtrang = tinhtrangmuon();
					PhieuTiem pm = new PhieuTiem(vitri, nvsl.getMaNV(), dgsl.getMaDocGia(), ngaymuon, tinhtrang);
					int a = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo??", "", JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						int j = PhieuTiemBus.gI().xoapm(pm);
						if (j > 0) {
							loadphieuTiem();
						}
					}
				}

				else {
					JOptionPane.showMessageDialog(contentPane, "B???n Ch??a Ch???n v??o table");
				}
			}
		});

		////////////////////////////////////////////////////////////
		////////////////// * THEM SUA XOA CHI TIET PHIEU MUON *///////////////
		///////////////////////////////////////////////////////////
		btnthemctptiem.addActionListener(new ActionListener() {

			private String ngaymuon2;

			@Override
			public void actionPerformed(ActionEvent e) {
//ch?? ??
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String ngaymuon2;
				String ngaytra;
				try {
					ngaytra = sdf.format(dateChooser_ngaytra.getDate());
					ngaymuon2 = sdf.format(dateChooser.getDate());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Ng??y sai");
					return;
				}
				if (!isNumber(txtmapt.getText())) {
					JOptionPane.showMessageDialog(null, "M?? Vaccine sai");
					return;
				}
				if (!isNumber(txtmapt.getText())) {
					JOptionPane.showMessageDialog(null, "M?? Vaccine sai");
					return;
				}
				if (!isNumber(txtmaVaccineTiem.getText())) {
					JOptionPane.showMessageDialog(null, "M?? Vaccine sai");
					return;
				}

				ChiTieuPMDTO ctpm = new ChiTieuPMDTO(0, Integer.parseInt(txtmapt.getText()),
						Integer.parseInt(txtmaVaccineTiem.getText()), ngaymuon2, ngaytra, txtghichuctpt.getText());

				int j = Chitietptbus.gI().themctpm(ctpm);
				if (j > 0) {
					loadctphieuTiem();
				}

			}

		});
		btnsuactpm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int i = tablectpt.getSelectedRow();
				if (i >= 0) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String ngaymuon2;
					String ngaytra;
					try {
						ngaytra = sdf.format(dateChooser_ngaytra.getDate());
						ngaymuon2 = sdf.format(dateChooser.getDate());
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Ng??y sai");
						return;
					}
					int mactpm = Integer.parseInt(dtmctpt.getValueAt(i, 0).toString());
					int mapm = Integer.parseInt(dtmctpt.getValueAt(i, 1).toString());
					ChiTieuPMDTO ctpm = new ChiTieuPMDTO(mactpm, mapm, Integer.parseInt(txtmaVaccineTiem.getText()),
							ngaymuon2, ngaytra, txtghichuctpt.getText());
					int j = Chitietptbus.gI().suactpm(ctpm);
					if (j > 0) {
						loadctphieuTiem();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "B???n Ch??a Ch???n v??o table");
				}
			}
		});

		btnxoactpm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int i = tablectpt.getSelectedRow();
				if (i >= 0) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					// String ngaymuon = ((JTextField)
					// dateChooser.getDateEditor().getUiComponent()).getText();
					String ngaytra = sdf.format(dateChooser_ngaytra.getDate());
					int mactpm = Integer.parseInt(dtmctpt.getValueAt(i, 0).toString());
					ChiTieuPMDTO ctpm = new ChiTieuPMDTO(mactpm, Integer.parseInt(txtmapt.getText()),
							Integer.parseInt(txtmaVaccineTiem.getText()), ngaytra, txtghichuctpt.getText());
					int a = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo??", "", JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						int j = Chitietptbus.gI().xoactpm(ctpm);
						if (j > 0) {
							loadctphieuTiem();
						}
					}
				}

				else {
					JOptionPane.showMessageDialog(contentPane, "B???n Ch??a Ch???n v??o table");
				}
			}
		});
		///////////////////////////////////////////////////////////////////////////////////////////////
		///////// TH??M S???A XO?? PHI???U
		/////////////////////////////////////////////////////////////////////////////////////////////// NH???P/////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////

		btnthemphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (txtManhanvienphieunhap.getText().isEmpty()) {
					thongbao("M?? nh??n vi??n");
					return;
				}
				if (txtManccPhieuNhap.getText().isEmpty()) {
					thongbao("M?? NCC");
					return;
				}
				if (NgayNhapPhieuNhap.getDate() == null) {
					thongbao("Ng??y Nh???p");
					return;
				}
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String ngaynhap = sdf.format(NgayNhapPhieuNhap.getDate());
				int Manv = Integer.parseInt(txtManhanvienphieunhap.getText());
				int Mancc = Integer.parseInt(txtManccPhieuNhap.getText());
				PhieuNhap pn = new PhieuNhap(0, Mancc, Manv, ngaynhap);
				int j = PhieuNhapBUS.gI().thempn(pn);
				if (j > 0) {
					loadphieunhap();
				}
			}
		});
		btnsuaphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = tablephieunhap.getSelectedRow();
				if (i >= 0) {
					if (txtManhanvienphieunhap.getText().isEmpty()) {
						thongbao("M?? nh??n vi??n");
						return;
					}
					if (txtManccPhieuNhap.getText().isEmpty()) {
						thongbao("M?? NCC");
						return;
					}
					if (NgayNhapPhieuNhap.getDate() == null) {
						thongbao("Ng??y Nh???p");
						return;
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					int vitri = Integer.parseInt(dtmphieunhap.getValueAt(i, 0).toString());
					String ngaynhap = sdf.format(NgayNhapPhieuNhap.getDate());
					int Manv = Integer.parseInt(txtManhanvienphieunhap.getText());
					int Mancc = Integer.parseInt(txtManccPhieuNhap.getText());
					PhieuNhap pn = new PhieuNhap(vitri, Mancc, Manv, ngaynhap);
					int j = PhieuNhapBUS.gI().suapn(pn);
					if (j > 0) {
						loadphieunhap();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "B???n Ch??a Ch???n v??o table");
				}

			}
		});

		btnxoaphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int i = tablephieunhap.getSelectedRow();
				if (i >= 0) {

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					int vitri = Integer.parseInt(dtmphieunhap.getValueAt(i, 0).toString());
					String ngaynhap = sdf.format(NgayNhapPhieuNhap.getDate());
					int Manv = Integer.parseInt(txtManhanvienphieunhap.getText());
					int Mancc = Integer.parseInt(txtManccPhieuNhap.getText());
					PhieuNhap pn = new PhieuNhap(vitri, Mancc, Manv, ngaynhap);
					int a = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo??", "", JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						int j = PhieuNhapBUS.gI().xoapn(pn);
						if (j > 0) {
							loadphieunhap();
						}
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "B???n Ch??a Ch???n v??o table");
				}
			}
		});
		////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////// TH??M S???A XO?? CHI TI???T PHI???U
		//////////////////////////////////////////////////////////////////////////////////////////////// NH???P/////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////////////////////
		btnthemchitietphieunhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtMaSachctpn.getText().isEmpty()) {
					thongbao("M?? Vaccine");
					return;
				}
				if (!isNumber(txtsoluongctpn.getText())) {
					JOptionPane.showMessageDialog(null, "S??? l?????ng ph???i nh???p s???");
					return;
				}
				if (txtsoluongctpn.getText().isEmpty()) {
					thongbao("S??? l?????ng");
					return;
				}
				if (!isNumber(txtgianhap.getText())) {
					JOptionPane.showMessageDialog(null, "Gi?? nh???p ph???i l?? s???");
					return;
				}
				if (txtgianhap.getText().isEmpty()) {
					thongbao("Gi?? nh???p");
					return;
				}

				int masach = Integer.parseInt(txtMaSachctpn.getText());
				int sl = Integer.parseInt(txtsoluongctpn.getText());
				int gia = Integer.parseInt(txtgianhap.getText());
				ChiTietPhieuNhap ct = new ChiTietPhieuNhap(0, mapn, masach, gia, sl, sl * gia);
				int j = ChiTietPhieuNhapBUS.gI().themctpn(ct);
				if(j > 0) {
					loadctphieunhap();
				}
			}
		});

		btnxoactpn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int i = tablechitietphieunhap.getSelectedRow();
				if (i >= 0) {

					int masach = Integer.parseInt(txtMaSachctpn.getText());
					int sl = Integer.parseInt(txtsoluongctpn.getText());
					int gia = Integer.parseInt(txtgianhap.getText());
					int mactpn = Integer.parseInt(dtmchitietphieunhap.getValueAt(i, 0).toString());
					ChiTietPhieuNhap ct = new ChiTietPhieuNhap(mactpn, mapn, masach, gia, sl, sl * gia);
					int a = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n xo??", "", JOptionPane.YES_NO_OPTION);
					if (a == JOptionPane.YES_OPTION) {
						int j = ChiTietPhieuNhapBUS.gI().xoactpn(ct);
						if(j > 0) {
							loadctphieunhap();
						}
					}

				} else {
					JOptionPane.showMessageDialog(contentPane, "B???n Ch??a Ch???n v??o table");
				}
			}
		});

		btnsuactpn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = tablechitietphieunhap.getSelectedRow();
				if (i >= 0) {
					if (txtMaSachctpn.getText().isEmpty()) {
						thongbao("M?? Vaccine");
						return;
					}
					if (!isNumber(txtsoluongctpn.getText())) {
						JOptionPane.showMessageDialog(null, "S??? l?????ng ph???i nh???p s???");
						return;
					}
					if (txtsoluongctpn.getText().isEmpty()) {
						thongbao("S??? l?????ng");
						return;
					}
					if (!isNumber(txtgianhap.getText())) {
						JOptionPane.showMessageDialog(null, "Gi?? nh???p ph???i l?? s???");
						return;
					}
					if (txtgianhap.getText().isEmpty()) {
						thongbao("Gi?? nh???p");
						return;
					}
					int masach = Integer.parseInt(txtMaSachctpn.getText());
					int sl = Integer.parseInt(txtsoluongctpn.getText());
					int gia = Integer.parseInt(txtgianhap.getText());
					int mactpn = Integer.parseInt(dtmchitietphieunhap.getValueAt(i, 0).toString());
					ChiTietPhieuNhap ct = new ChiTietPhieuNhap(mactpn, mapn, masach, gia, sl, sl * gia);
					int j = ChiTietPhieuNhapBUS.gI().suactpn(ct);
					if(j > 0) {
						loadctphieunhap();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "B???n Ch??a Ch???n v??o table");
				}
			}
		});
	}

	private void moveFrame(int x, int y) {

		this.setLocation(x - x_mouse, y - y_mouse);
	}

	public static ArrayList<LoaiDTO> loaiVaccineArr;

	public void loadloaiVaccine() {
		loaiVaccineArr = null;
		LoaiBUS loaiBUS = new LoaiBUS();
		loaiVaccineArr = loaiBUS.getLoaisachLoai();
		dtmloai.setRowCount(0);
		cmbmaloai.removeAllItems();
		for (LoaiDTO loaisachDTO : loaiVaccineArr) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(loaisachDTO.getMaloai());
			vec.add(loaisachDTO.getTenloai());
			dtmloai.addRow(vec);
			cmbmaloai.addItem(loaisachDTO);

		}
	}

	public static ArrayList<NhaSanXuat> nxb;

	public void loadnxb() {
		nxb = null;
		NhaSanXuatBUS nxbbus = new NhaSanXuatBUS();
		nxb = nxbbus.getdanhsachnxb();
		dtmnhaSx.setRowCount(0);
		cmbmanhaSx.removeAllItems();
		if (nxb != null) {
			for (NhaSanXuat nxb : nxb) {
				Vector<Object> vec = new Vector<Object>();
				vec.add(nxb.getMaNXB());
				vec.add(nxb.getTenNXB());
				vec.add(nxb.getDiaChi());
				vec.add(nxb.getSdt());
				cmbmanhaSx.addItem(nxb);
				dtmnhaSx.addRow(vec);

			}
		}
	}

	public static ArrayList<NhaCungCapDTO> ncc;

	public void loadnhacungcap() {
		ncc = null;
		NhaCungcapbus nccbus = new NhaCungcapbus();
		ncc = nccbus.getdanhsachncc();
		dtmncc.setRowCount(0);
		for (NhaCungCapDTO nhaCungCapDTO : ncc) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(nhaCungCapDTO.getMaNCC());

			vec.add(nhaCungCapDTO.getTenNCC());
			dtmncc.addRow(vec);
		}

	}

	public static ArrayList<KeDTO> ke = new ArrayList<KeDTO>();

	public void loadkesach() {
		ke = null;
		KeBus keSachBus = new KeBus();
		ke = keSachBus.getdanhsachke();
		dtmke.setRowCount(0);
		cmbmake.removeAllItems();
		for (KeDTO kesach : ke) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(kesach.getMaKeSach());

			vec.add(kesach.getViTri());
			cmbmake.addItem(kesach);
			dtmke.addRow(vec);

			// .DesignLai.dtm.addRow(vec);
		}
		/*
		 * for (NhaCungCap ncc1 : ncc) { Vector<Object> vec = new Vector<Object>();
		 * vec.add(ncc1.getMaNCC()); vec.add(ncc1.getTenNCC()); dtmncc.addRow(vec); }
		 */
	}

	public static ArrayList<NhanVien> nv = new ArrayList<NhanVien>();

	public void loadnhanvien() {
		nv = null;
		NhanVienBus nvbuss = new NhanVienBus();
		nv = nvbuss.getdanhsachnv();
		dtmnhanvien.setRowCount(0);
		cmbnhanvienpm.removeAllItems();
		for (NhanVien nv : nv) {
			Vector<Object> vec = new Vector<Object>();
			vec.add(nv.getMaNV());
			vec.add(nv.getTenNV());
			vec.add(nv.getNamSinh());
			vec.add(nv.getGioiTinh());
			vec.add(nv.getDiaChi());
			vec.add(nv.getSdt());
			
			////////////
			vec.add(nv.getDonViTiem());
			//////////
			dtmnhanvien.addRow(vec);
			cmbnhanvienpm.addItem(nv);
			// .DesignLai.dtm.addRow(vec);
		}
		/*
		 * for (NhaCungCap ncc1 : ncc) { Vector<Object> vec = new Vector<Object>();
		 * vec.add(ncc1.getMaNCC()); vec.add(ncc1.getTenNCC()); dtmncc.addRow(vec); }
		 */
	}

	public static ArrayList<DangKyTiemDTO> tg = new ArrayList<DangKyTiemDTO>();

	public void loadtacgia() {
		tg = null;
		DangKyTiemBUS tgbus = new DangKyTiemBUS();
		tg = tgbus.getdanhsachtacgia();
		dtmtacgia.setRowCount(0);
		cmbmatg.removeAllItems();
		//////////////////////
		
		//////////////////////
		if (tg != null) {
			for (DangKyTiemDTO tg : tg) {
				Vector<Object> vec = new Vector<Object>();
				vec.add(tg.getMaTacGia());
				vec.add(tg.getTenTacGia());
				vec.add(tg.getNamSinh());
				vec.add(tg.getQueQuan());
				///////////////
				vec.add(tg.getMaDocGia());
				vec.add(tg.getNgayMuonTiem());
				///////////////////
				dtmtacgia.addRow(vec);
				cmbmatg.addItem(tg);
			
				//cmbnguoidan_vaccine.addItem(tg);
				// .DesignLai.dtm.addRow(vec);
			}
		}

	}

	private JLabel lblhinhanhpre;
	private JButton btnthemsach;
	private JButton btnsuasach;
	private JButton btnxoasach;
	private JButton btnloadlaitrang;
	public static ArrayList<NguoiDan> dg = new ArrayList<NguoiDan>();

	public void loadnguoidan() {
		dg = null;
		NguoiDanBUS dgbus = new NguoiDanBUS();
		dg = dgbus.getdanhsachdocgia();
		dtmnguoidan.setRowCount(0);
		if (dg != null) {
			for (NguoiDan dg1 : dg) {
				Vector<Object> vec = new Vector<Object>();
				vec.add(dg1.getMaDocGia());
				vec.add(dg1.getTenDocGia());
				vec.add(dg1.getGioiTinh());
				vec.add(dg1.getSdt());
				vec.add(dg1.getDiachi());
				///////////////////////////
				vec.add(dg1.getNamSinh());
				////////////////////

				dtmnguoidan.addRow(vec);
				cmbmaVaccinephieuTiem.addItem(dg1);
				
				////////////
				cmbnguoidandangky.addItem(dg1);
				///////////
				// .DesignLai.dtm.addRow(vec);
			}
		}

	}

	public static ArrayList<VaccineDTO> sach = new ArrayList<VaccineDTO>();

	public void loadVaccine() {
		sach = null;
		VaccineBus sachbus = new VaccineBus();
		sach = sachbus.getLoaisachLoai();

		dtmVAccine.setRowCount(0);
		if (sach != null) {
			for (VaccineDTO sachitem : sach) {
				Vector<Object> vec = new Vector<Object>();
				vec.add(sachitem.getMasosach());
				vec.add(sachitem.getTensach());
				vec.add(sachitem.getMaloai());
				vec.add(sachitem.getMaNXB());
				vec.add(sachitem.getMatacgia());
				vec.add(sachitem.getNamxb());
				vec.add(sachitem.getSoluong());
				vec.add(sachitem.getMake());
				vec.add(sachitem.getHinhanh());
				dtmVAccine.addRow(vec);
			}
		}
	}

	private JTable tablemuon;
	public static ArrayList<PhieuTiem> dspm = new ArrayList<PhieuTiem>();

	public void loadphieuTiem() {
		dspm = null;
		PhieuTiemBus pmbus = new PhieuTiemBus();
		dspm = PhieuTiemDAL.getdanhsachphieumuon();
		dtmTiem.setRowCount(0);

		for (PhieuTiem pm : dspm) {

			Vector<Object> vec = new Vector<Object>();
			vec.add(pm.getMaPhieuMuon());
			vec.add(pm.getMaNV());
			vec.add(pm.getMaDocGia());
			vec.add(pm.getNgayMuon());
			vec.add(pm.getTinhtrang());

			dtmTiem.addRow(vec);
		}
	}

	public static ArrayList<ChiTieuPMDTO> ctpm = new ArrayList<ChiTieuPMDTO>();

	public void loadctphieuTiem() {
		ctpm = null;
		Chitietptbus ctpmbus = new Chitietptbus();
		ctpm = ctpmbus.getdanhsachpm();
		dtmctpt.setRowCount(0);

		for (ChiTieuPMDTO pm : ctpm) {

			Vector<Object> vec = new Vector<Object>();
			vec.add(pm.getMaChiTietPhieuMuon());
			vec.add(pm.getMaPhieuMuon());
			vec.add(pm.getMaSach());
			vec.add(pm.getNgayTra());
			vec.add(pm.getGhichu());

			dtmctpt.addRow(vec);
		}
	}

	public static ArrayList<PhieuNhap> phieunhap = new ArrayList<PhieuNhap>();

	public void loadphieunhap() {
		phieunhap = null;
		phieunhap = PhieuNhapBUS.gI().getdanhsachphieunhap();

		dtmphieunhap.setRowCount(0);

		for (PhieuNhap pn : phieunhap) {

			Vector<Object> vec = new Vector<Object>();
			vec.add(pn.getMaPhieuNhap());
			vec.add(pn.getMaNhaCung());
			vec.add(pn.getMaNhanVien());
			vec.add(pn.getNgayNhap());
			dtmphieunhap.addRow(vec);

			// dtmctpm.addRow(vec);
		}
	}

	public static ArrayList<ChiTietPhieuNhap> thongkectphieunhap = new ArrayList<ChiTietPhieuNhap>();

	public void loadthongkephieunhap() {
		thongkectphieunhap = null;
		thongkectphieunhap = ChiTietPhieuNhapBUS.gI().thongkephieunhap();

		dtmthongkenhaphang.setRowCount(0);

		for (ChiTietPhieuNhap pn : thongkectphieunhap) {

			Vector<Object> vec = new Vector<Object>();
			vec.add(pn.getMaCTPN());
			vec.add(pn.getMaPhieuNhap());
			vec.add(pn.getMaSach());
			vec.add(pn.getGia());
			vec.add(pn.getSoLuong());
			vec.add(pn.getThanhTien());
			vec.add(pn.getNgaynhap());
			vec.add(pn.getTensach());
			dtmthongkenhaphang.addRow(vec);

			// dtmctpm.addRow(vec);
		}
	}

	public static ArrayList<ChiTietPhieuNhap> ctphieunhap = new ArrayList<ChiTietPhieuNhap>();

	public void loadctphieunhap() {
		ctphieunhap = null;
		ctphieunhap = ChiTietPhieuNhapBUS.gI().getdanhsachpm();

		dtmchitietphieunhap.setRowCount(0);

		for (ChiTietPhieuNhap pn : ctphieunhap) {

			Vector<Object> vec = new Vector<Object>();
			vec.add(pn.getMaCTPN());
			vec.add(pn.getMaPhieuNhap());
			vec.add(pn.getMaSach());
			vec.add(pn.getSoLuong());
			vec.add(pn.getGia());
			vec.add(pn.getThanhTien());

			dtmchitietphieunhap.addRow(vec);

			// dtmctpm.addRow(vec);
		}
	}

	private JMenuItem mntmNewMenuItem;
	private JPanel panelThongKe;
	private JTable table_1;
	private JTable tablechitietphieunhap;
	public static JTextField txtManhanvienphieunhap;
	public static JTextField txtManccPhieuNhap;
	private JLabel lblNewLabel_12;
	public static JTextField txtMaSachctpn;
	private JButton btnmanvphieunhap_1;
	private JLabel lblNewLabel_13;
	private JTextField txtsoluongctpn;
	private JLabel lblNewLabel_14;
	private JTextField txtgianhap;
	private JLabel lblmaphieunhap;
	private JButton btnthemchitietphieunhap;
	private JButton btnsuactpn;
	private JButton btnxoactpn;
	private JPanel panel_7;
	private JLabel lblNewLabel_16;
	private JTextField txttimphieunhap;
	private JButton btninphieunhap;
	private JButton btnxuatexcel;
	private JButton btnnhapexcel;

	public String tinhtrangmuon() {
		if (rdTiem.isSelected()) {
			return "T???t";
		}
		return "Theo D??i";
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private void xuLyChonAnh() {
		JFileChooser fileChooser = new JFileChooser("img/sach/");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("T???p h??nh ???nh", "jpg", "png", "jpeg");
		fileChooser.setFileFilter(filter);
		int returnVal = fileChooser.showOpenDialog(null);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			String name = fileChooser.getSelectedFile().getName();
			hinhanh = name;
			lblhinhanhpre.setIcon(getAnhSP(name));
			System.out.println(name);
		}
	}

	File fileAnhSP;
	private JButton btnthongkesachmuon;
	private JTable tablethongkenhaphang;
	private JLabel lblNewLabel_18;
	private JLabel lblsosachdanhap;
	private JTextField txttimsach;
	private JButton btnTiLi;
	private JLabel lblTmKim;
	private JTextField txttimtacgia;
	private JButton btnTm_2;
	private JButton btntimphieunhap;
	private JButton btntailai;

	private ImageIcon getAnhSP(String src) {
		src = src.trim().equals("") ? "default.png" : src;
		// X??? l?? ???nh
		BufferedImage img = null;
		File fileImg = new File("img/sach/" + src);

		if (!fileImg.exists()) {
			src = "default.png";
			fileImg = new File("img/sach/" + src);
		}

		try {
			img = ImageIO.read(fileImg);
			fileAnhSP = new File("img/sach/" + src);
		} catch (IOException e) {
			fileAnhSP = new File("img/sach/default.png");
		}

		if (img != null) {
			Image dimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

			return new ImageIcon(dimg);
		}
		return null;
	}

	public static void thongbao(String s) {
		JOptionPane.showMessageDialog(null, s + " kh??ng ???????c b??? tr???ng");
	}

	public static boolean isNumber(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}