package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.ApplyDetailDAO;
import model.ApplyDetailDTO;
import model.CustomerDTO;

public class ApplyDetailGUI {

	private JFrame frame;
	
	CustomerDTO loginDto;
	JButton btn_main_login;
	JButton btn_main_logout;
	JMenu main_mn_myPage;
	private JTable table;


	public ApplyDetailGUI() {
		initialize();
     	frame.setVisible(true);
	}


	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 875, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// "신청 내역" 제목
		JLabel lbl_applydetails = new JLabel("\uC2E0\uCCAD\uB0B4\uC5ED");
		lbl_applydetails.setBounds(22, 10, 91, 56);
		lbl_applydetails.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		frame.getContentPane().add(lbl_applydetails);
		
		// 닫기 버튼
		JButton button = new JButton("\uB2EB\uAE30");
		button.setBounds(383, 467, 70, 35);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI main = new MainGUI();
				main.loginInfo(loginDto);
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		button.setBackground(new Color(205, 92, 92));
		frame.getContentPane().add(button);
		
		// 신청 내역 표 출력
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(83, 117, 680, 316);
		frame.getContentPane().add(scrollPane);
		
		String[] colName = {"신청 번호", "모델 이름", "신청 수량"};
		ApplyDetailDAO dao = new ApplyDetailDAO();
		ArrayList<ApplyDetailDTO> applyDatailList = dao.applyInfoSelect();
		Object[][] data = new Object[applyDatailList.size()][5];
		for (int i = 0; i < data.length; i++) {
			data[i][0] = applyDatailList.get(i).getApplyno();
			data[i][1] = applyDatailList.get(i).getModel();
			data[i][2] = applyDatailList.get(i).getApplyamount();
		}
		
		table = new JTable(data, colName);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
	}
	
		// 로그인 성공 시 작동
		public void loginInfo(CustomerDTO dto) {
			loginDto = dto;
		}
}
