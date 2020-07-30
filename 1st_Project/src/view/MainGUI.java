package view;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.CustomerDTO;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI {

	private JFrame frame;
	JButton btn_main_login;
	JButton btn_main_logout;
	
	JMenu mn_main_myPage;
	
	//����� ����
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
		
		//�α��� ���� ���� ���¿��� �α׾ƿ� ��ư�� ������ �ʰ� ��
		btn_main_logout.setVisible(false);
		
		//�α��� ���� ���� ���¿��� ������������ ������ �ʰ� ��
		mn_main_myPage.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 843, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("\uC0C1\uD488");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\uAC00\uC804 \uC81C\uD488 \uAC80\uC0C9");
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("\uC73C\uB738 \uD6A8\uC728 \uAC00\uC804\uC81C\uD488 \uAD6C\uB9E4\uBE44\uC6A9 \uD658\uAE08\uC0AC\uC5C5");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\"\uC73C\uB738 \uD6A8\uC728 \uAC00\uC804\uC81C\uD488 \uAD6C\uB9E4\uBE44\uC6A9 \uD658\uAE08\uC0AC\uC5C5\"\uC774\uB780?\r\n");
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\uD658\uAE09 \uB300\uD589 \uC2E0\uCCAD");
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\uD658\uAE09 \uB300\uD589 \uC2E0\uCCAD\uC744 \uC704\uD55C \uC11C\uB958");
		mnNewMenu_2.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\uC6B0\uB9AC\uC9D1 \uC5D0\uB108\uC9C0 \uC808\uC57D\uC740 \uC774\uB807\uAC8C \uD574\uC694!!");
		mnNewMenu_2.add(mntmNewMenuItem_7);
		
		mn_main_myPage = new JMenu("My page");
		menuBar.add(mn_main_myPage);
		
		//ȸ������ ���� �� Ż�� ��ư
		JMenuItem mntmNewMenuItem = new JMenuItem("ȸ������ ���� �� Ż��");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
				//CustomerUpdateGUI â�� ���� �α��� ���� ����
				CustomerUpdateGUI update = new CustomerUpdateGUI();
				update.loginInfo(loginDto);
			}
		});
		mn_main_myPage.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\uAD6C\uB9E4\uB0B4\uC5ED");
		mn_main_myPage.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\uC2E0\uCCAD\uB0B4\uC5ED");
		mn_main_myPage.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\uB0B4 \uAC00\uC804\uC81C\uD488");
		mn_main_myPage.add(mntmNewMenuItem_3);
		frame.getContentPane().setLayout(null);
		
		//�α��ι�ư
		btn_main_login = new JButton("\uB85C\uADF8\uC778");
		btn_main_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//â ����
				frame.dispose();
				//loginâ ���� (��ü����)
				LoginGUI login = new LoginGUI();
			}
		});
		btn_main_login.setBounds(718, 10, 97, 23);
		frame.getContentPane().add(btn_main_login);
		
		//�α׾ƿ���ư
		btn_main_logout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btn_main_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainGUI main = new MainGUI();
				main.logoutInfo();
			}
		});
		btn_main_logout.setBounds(718, 10, 97, 23);
		frame.getContentPane().add(btn_main_logout);
	}
	
	//�α��� ������ �۵�
	public void loginInfo(CustomerDTO dto) {
		//�α��� ��ư�� ������ �ʰ�, �α׾ƿ� ��ư�� ���̰� ��
		btn_main_login.setVisible(false);
		btn_main_logout.setVisible(true);
		//������������ ���̰� ��
		mn_main_myPage.setVisible(true);
		//�α��� ���� ����
		loginDto = dto;
	}
	
	//�α׾ƿ� ������ �۵�
	public void logoutInfo() {	
		//�α��� ��ư�� ���̰�, �α׾ƿ� ��ư�� ������ �ʰ� ��
		btn_main_login.setVisible(true);
		btn_main_logout.setVisible(false);
	}
}
