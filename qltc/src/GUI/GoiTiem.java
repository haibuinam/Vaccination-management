package GUI;

import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.GoiTiemBUS;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class GoiTiem extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtphat;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GoiTiem() {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 511, 354);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Mã Phiếu Tiêm");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(32, 42, 119, 28);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(163, 46, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Gói Tiêm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(32, 112, 58, 28);
		contentPane.add(lblNewLabel_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Gói 1");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {

					txtphat.setText("500000");
					txtphat.setEditable(false);
				}
			}
		});
		chckbxNewCheckBox.setSelected(true);
		chckbxNewCheckBox.setBounds(90, 116, 113, 25);
		contentPane.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Gói 2");
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (chckbxNewCheckBox_1.isSelected()) {

					txtphat.setText("600000");
					txtphat.setEditable(false);
				}

			}
		});
		chckbxNewCheckBox_1.setBounds(300, 116, 113, 25);
		contentPane.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Gói Vip");
		chckbxNewCheckBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_2.isSelected()) {
					txtphat.setText("10000000");
					txtphat.setEditable(false);
				}
			}
		});
		chckbxNewCheckBox_2.setBounds(90, 159, 189, 25);
		contentPane.add(chckbxNewCheckBox_2);

		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Gói Tiêm Khác");
		chckbxNewCheckBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxNewCheckBox_3.isSelected()) {
					txtphat.setEditable(true);
				}
			}
		});
		chckbxNewCheckBox_3.setBounds(300, 159, 113, 25);
		contentPane.add(chckbxNewCheckBox_3);

		JLabel lblNewLabel_1_1 = new JLabel("Số Tiền Thanh Toán");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(32, 217, 106, 28);
		contentPane.add(lblNewLabel_1_1);
		ButtonGroup group = new ButtonGroup();
		group.add(chckbxNewCheckBox);
		group.add(chckbxNewCheckBox_1);
		group.add(chckbxNewCheckBox_2);
		group.add(chckbxNewCheckBox_3);
	
		txtphat = new JTextField();
		txtphat.setEditable(false);
		txtphat.setBounds(150, 218, 250, 28);
		contentPane.add(txtphat);
		txtphat.setColumns(10);

		JButton btnNewButton = new JButton("Lưu");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (txtphat.getText().isEmpty() || textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin");
					return;
				}
				int mapm = Integer.parseInt(textField.getText());
				String lydo = "";
				if (chckbxNewCheckBox.isSelected()) {
					lydo = "Gói 1";
				} else if (chckbxNewCheckBox_1.isSelected()) {
					lydo = "Gói 2";
				} else if (chckbxNewCheckBox_2.isSelected()) {
					lydo = "Gói Vip";
				} else if (chckbxNewCheckBox_3.isSelected()) {
					lydo = "Khác";
				}
				
				String tienphat = txtphat.getText();
				if(Integer.parseInt(tienphat) <= 0 || !isNumber(tienphat) ) {
					JOptionPane.showMessageDialog(null, "Số tiền không đúng");
					return ;
				}
				DTO.GoiTiemDTO phat = new DTO.GoiTiemDTO(0, mapm, lydo, tienphat);
				if (GoiTiemBUS.gI().themke(phat) > 0) {
					JOptionPane.showMessageDialog(contentPane, "Thêm Phiếu Thanh toán Thành Công");
				} else {
					JOptionPane.showMessageDialog(contentPane, "Thêm Phiếu Thanh toán Thất Bại");

				}
				
				dispose();

			}
		});
		btnNewButton.setBounds(237, 269, 97, 25);
		contentPane.add(btnNewButton);
		textField.setText(MainFrame.Ma);
		setLocationRelativeTo(null);
	}
	public static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
