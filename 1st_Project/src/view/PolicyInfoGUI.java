package view;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import model.CustomerDTO;

public class PolicyInfoGUI {

	public JFrame frame;
	private JTextField tf_accountNumber;
	
	// 사용자 정보
	CustomerDTO loginDto;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PolicyInfoGUI window = new PolicyInfoGUI();
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
	public PolicyInfoGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 910, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSelectedIndex(-1);
		tabbedPane.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(tabbedPane, "name_445368215119300");
		
		JPanel screen1_policyInfo = new JPanel();
		screen1_policyInfo.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("\"\uC73C\uB738 \uD6A8\uC728 \uAC00\uC804\uC81C\uD488 \uAD6C\uB9E4\uBE44\uC6A9 \uD658\uAE09 \uC0AC\uC5C5\"\uC774\uB780?", null, screen1_policyInfo, null);
		screen1_policyInfo.setLayout(null);
		
		// 으뜸효율 환급제도 설명 이미지
		JLabel lbl_policyImage = new JLabel("");
		lbl_policyImage.setIcon(new ImageIcon("E:\\Bigdata\\팀 프로젝트\\[자료] GUI에 쓰인 사진들\\policyInfo.jpg"));
		lbl_policyImage.setBounds(12, 10, 877, 288);
		screen1_policyInfo.add(lbl_policyImage);
		
		JLabel lbl_whatContents = new JLabel("\u3147 \uC0AC\uC5C5 \uB0B4\uC6A9\uC740?");
		lbl_whatContents.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_whatContents.setForeground(new Color(0, 128, 128));
		lbl_whatContents.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lbl_whatContents.setBounds(41, 313, 156, 27);
		screen1_policyInfo.add(lbl_whatContents);
		
		JLabel lbl_whereAt = new JLabel("\u3147 \uC2E0\uCCAD\uC740 \uC5B4\uB514\uC5D0\uC11C?");
		lbl_whereAt.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_whereAt.setForeground(new Color(0, 128, 128));
		lbl_whereAt.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lbl_whereAt.setBounds(460, 313, 201, 27);
		screen1_policyInfo.add(lbl_whereAt);
		
		// 사업 내용 설명란
		JTextPane tp_contents = new JTextPane();
		tp_contents.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		tp_contents.setText("\u3141 \uC81C\uD488 \uAD6C\uB9E4 \uAE30\uAC04\r\n2020\uB144 3\uC6D4 23\uC77C ~ 12\uC6D4 31\uC77C \r\n(\uB2E8, \uC758\uB958\uAC74\uC870\uAE30\uB294 2020\uB144 7\uC6D4 6\uC77C ~ 12\uC6D4 31\uC77C)\r\n\r\n\u3141 \uD658\uAE09 \uC2E0\uCCAD \uAE30\uAC04\r\n2020\uB144 3\uC6D4 23\uC77C ~ 2021\uB144 1\uC6D4 15\uC77C \r\n(\uB2E8, \uC758\uB958\uAC74\uC870\uAE30\uB294 2020\uB144 7\uC6D4 6\uC77C ~ 2021\uB144 1\uC6D4 15\uC77C)");
		tp_contents.setBounds(53, 345, 368, 149);
		screen1_policyInfo.add(tp_contents);
		
		// 사업 신청 안내란
		JTextPane tp_site = new JTextPane();
		tp_site.setText("https://rebate.energy.or.kr \uD648\uD398\uC774\uC9C0\uC640 \r\n\uD604\uC7AC \uC0AC\uC774\uD2B8\uC5D0\uC11C \uB300\uD589 \uC2E0\uCCAD \uAC00\uB2A5");
		tp_site.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		tp_site.setBounds(472, 345, 316, 56);
		screen1_policyInfo.add(tp_site);
		
		// "닫기" 버튼
		JButton btn_close = new JButton("\uB2EB\uAE30");
		btn_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI main = new MainGUI();
				main.loginInfo(loginDto);
			}
		});
		btn_close.setForeground(Color.BLACK);
		btn_close.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_close.setBackground(new Color(205, 92, 92));
		btn_close.setBounds(398, 519, 70, 35);
		screen1_policyInfo.add(btn_close);
		
	}
}
