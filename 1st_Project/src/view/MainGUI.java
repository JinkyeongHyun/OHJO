package view;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import model.CustomerDTO;
import search.searchGUI;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class MainGUI {

	private JFrame frame;
	JButton btn_main_login;
	JButton btn_main_logout;
	JMenu main_mn_myPage;
	
	//사용자 정보
	CustomerDTO loginDto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI window = new MainGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainGUI() {
		initialize();
		frame.setVisible(true);
		
		//로그인 하지 않은 상태에서 로그아웃 버튼을 보이지 않게 함
		btn_main_logout.setVisible(false);
		
		//로그인 하지 않은 상태에서 마이페이지를 보이지 않게 함
		main_mn_myPage.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 843, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu main_mn_pro = new JMenu("\uC0C1\uD488");
		menuBar.add(main_mn_pro);
		
		
		
		JMenuItem mni_search = new JMenuItem("\uAC00\uC804 \uC81C\uD488 \uAC80\uC0C9");
		mni_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				searchGUI search = new searchGUI(loginDto);
			}
		});
		mni_search.addMouseListener(new MouseAdapter() {
			
		});
		main_mn_pro.add(mni_search);
		
		JMenu main_mn_esource = new JMenu("\uC73C\uB738 \uD6A8\uC728 \uAC00\uC804\uC81C\uD488 \uAD6C\uB9E4\uBE44\uC6A9 \uD658\uAE08\uC0AC\uC5C5");
		menuBar.add(main_mn_esource);
		
		JMenuItem mn_announce = new JMenuItem("\"\uC73C\uB738 \uD6A8\uC728 \uAC00\uC804\uC81C\uD488 \uAD6C\uB9E4\uBE44\uC6A9 \uD658\uAE08\uC0AC\uC5C5\"\uC774\uB780?\r\n");
		mn_announce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PolicyInfoGUI full = new PolicyInfoGUI(loginDto);
			}
		});
		main_mn_esource.add(mn_announce);
		
		JMenuItem mn_apply = new JMenuItem("\uD658\uAE09 \uB300\uD589 \uC2E0\uCCAD");
		mn_apply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				FileUploadGUI upload = new FileUploadGUI(loginDto);			
			}
		});
		main_mn_esource.add(mn_apply);
		
		//위임장 다운로드
		JMenuItem mn_document = new JMenuItem("\uD658\uAE09 \uB300\uD589 \uC2E0\uCCAD\uC744 \uC704\uD55C \uC11C\uB958");
		mn_document.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				FileDownloadGUI download = new FileDownloadGUI(loginDto);			
			}
		});
		main_mn_esource.add(mn_document);
		
		//에너지 절약법
		JMenuItem mn_energy = new JMenuItem("\uC6B0\uB9AC\uC9D1 \uC5D0\uB108\uC9C0 \uC808\uC57D\uC740 \uC774\uB807\uAC8C \uD574\uC694!!");
		mn_energy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				EnergySavingInfoGUI save = new EnergySavingInfoGUI(loginDto);
				
			}
		});
		main_mn_esource.add(mn_energy);
		
		main_mn_myPage = new JMenu("My page");
		menuBar.add(main_mn_myPage);
		
		//회원정보 수정 및 탈퇴 버튼
		JMenuItem mn_tnwjd = new JMenuItem("회원정보 수정 및 탈퇴");
		mn_tnwjd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
				//CustomerUpdateGUI 창을 열고 로그인 정보 전송
				CustomerUpdateGUI update = new CustomerUpdateGUI();
				update.loginInfo(loginDto);
			}
		});
		main_mn_myPage.add(mn_tnwjd);
		
		//구매내역창
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\uAD6C\uB9E4\uB0B4\uC5ED");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseDetailGUI pdetail = new PurchaseDetailGUI();
				pdetail.loginInfo(loginDto);
			}
		});
		main_mn_myPage.add(mntmNewMenuItem_1);
		
		//신청내역창
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\uC2E0\uCCAD\uB0B4\uC5ED");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//신청내역창 열기
				frame.dispose();
				ApplyDetailGUI ad = new ApplyDetailGUI();
			    ad.loginInfo(loginDto);
				
				
			}
		});
	
		main_mn_myPage.add(mntmNewMenuItem_2);
		
		//내 가전제품
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\uB0B4 \uAC00\uC804\uC81C\uD488");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MyAppliancesGUI my = new MyAppliancesGUI(loginDto);
				my.loginInfo(loginDto);
			}
		});
		main_mn_myPage.add(mntmNewMenuItem_3);
		
		//로그인버튼
		btn_main_login = new JButton("\uB85C\uADF8\uC778");
		btn_main_login.setBounds(718, 10, 97, 23);
		btn_main_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//창 끄기
				frame.dispose();
				//login창 띄우기 (객체생성)
				LoginGUI login = new LoginGUI();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btn_main_login);
		
		//로그아웃버튼
		btn_main_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_main_logout.setBounds(718, 10, 97, 23);
		btn_main_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainGUI main = new MainGUI();
				main.logoutInfo();
			}
		});
		frame.getContentPane().add(btn_main_logout);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainGUI.class.getResource("/images/mainBGI.jpg")));
		lblNewLabel.setBounds(0, 0, 827, 467);
		frame.getContentPane().add(lblNewLabel);
	}
	
	//로그인 성공시 작동
	public void loginInfo(CustomerDTO dto) {
		//로그인 버튼을 보이지 않게, 로그아웃 버튼을 보이게 함
		btn_main_login.setVisible(false);
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
