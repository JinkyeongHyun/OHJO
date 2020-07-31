package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import model.ApplyDAO;
import model.ApplyDTO;
import model.CustomerDTO;
import model.ProductDTO;
import search.ProductDAO;
import search.TableModelChange;

import javax.swing.JTextField;
import java.awt.Color;

public class ApplyDetailGUI {

	private JFrame frame;
	
	CustomerDTO loginDto;
	JButton btn_main_login;
	JButton btn_main_logout;
	JMenu main_mn_myPage;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ApplyDetailGUI window = new ApplyDetailGUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ApplyDetailGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 875, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_applydetails = new JLabel("\uC2E0\uCCAD\uB0B4\uC5ED");
		lbl_applydetails.setBounds(22, 10, 91, 56);
		lbl_applydetails.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		frame.getContentPane().add(lbl_applydetails);
		
		JLabel lbl_applyno = new JLabel("\uC2E0\uCCAD\uBC88\uD638");
		lbl_applyno.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_applyno.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lbl_applyno.setBounds(174, 183, 118, 36);
		frame.getContentPane().add(lbl_applyno);
		
		JLabel lbl_model = new JLabel("\uBAA8\uB378\uBA85");
		lbl_model.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_model.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lbl_model.setBounds(174, 244, 118, 36);
		frame.getContentPane().add(lbl_model);
		
		JLabel lbl_applyamount = new JLabel("\uC2E0\uCCAD\uC218\uB7C9");
		lbl_applyamount.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_applyamount.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lbl_applyamount.setBounds(174, 304, 118, 36);
		frame.getContentPane().add(lbl_applyamount);
		
		JButton button = new JButton("\uB2EB\uAE30");
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
		button.setBounds(383, 499, 70, 35);
		frame.getContentPane().add(button);
		
		JLabel lb_no = new JLabel("New label");
		lb_no.setBounds(304, 191, 390, 21);
		frame.getContentPane().add(lb_no);
	}
	
	//로그인 성공시 작동
		public void loginInfo(CustomerDTO dto) {
			//로그인 버튼을 보이지 않게, 로그아웃 버튼을 보이게 함
		//	btn_main_login.setVisible(false);
			btn_main_logout.setVisible(true);
			//마이페이지를 보이게 함
			main_mn_myPage.setVisible(true);
			//로그인 정보 저장
			loginDto = dto;
		}
		
		//로그아웃 성공시 작동
		public void logoutInfo() {	
			//로그인 버튼을 보이게, 로그아웃 버튼을 보이지 않게 함
			btn_main_login.setVisible(true);
			btn_main_logout.setVisible(false);
		}
}
