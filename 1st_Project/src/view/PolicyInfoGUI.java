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
	
	// »ç¿ëÀÚ Á¤º¸
	CustomerDTO loginDto;

//	/**
//	 * Launch the application.
//	 */
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
//
//	/**
//	 * Create the application.
//	 */
	public PolicyInfoGUI(CustomerDTO dto) {
		loginDto = dto;
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
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, "name_1334762828370600");
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("E:\\Bigdata\\\uD300 \uD504\uB85C\uC81D\uD2B8\\[\uC790\uB8CC] GUI\uC5D0 \uC4F0\uC778 \uC0AC\uC9C4\uB4E4\\policyInfo.jpg"));
		label.setBounds(12, 10, 877, 288);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u3147 \uC0AC\uC5C5 \uB0B4\uC6A9\uC740?");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(new Color(0, 128, 128));
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_1.setBounds(41, 313, 156, 27);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u3147 \uC2E0\uCCAD\uC740 \uC5B4\uB514\uC5D0\uC11C?");
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(new Color(0, 128, 128));
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 18));
		label_2.setBounds(460, 313, 201, 27);
		panel.add(label_2);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("\u3141 \uC81C\uD488 \uAD6C\uB9E4 \uAE30\uAC04\r\n2020\uB144 3\uC6D4 23\uC77C ~ 12\uC6D4 31\uC77C \r\n(\uB2E8, \uC758\uB958\uAC74\uC870\uAE30\uB294 2020\uB144 7\uC6D4 6\uC77C ~ 12\uC6D4 31\uC77C)\r\n\r\n\u3141 \uD658\uAE09 \uC2E0\uCCAD \uAE30\uAC04\r\n2020\uB144 3\uC6D4 23\uC77C ~ 2021\uB144 1\uC6D4 15\uC77C \r\n(\uB2E8, \uC758\uB958\uAC74\uC870\uAE30\uB294 2020\uB144 7\uC6D4 6\uC77C ~ 2021\uB144 1\uC6D4 15\uC77C)");
		textPane.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 13));
		textPane.setBounds(53, 345, 368, 149);
		panel.add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setText("https://rebate.energy.or.kr \uD648\uD398\uC774\uC9C0\uC640 \r\n\uD604\uC7AC \uC0AC\uC774\uD2B8\uC5D0\uC11C \uB300\uD589 \uC2E0\uCCAD \uAC00\uB2A5");
		textPane_1.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		textPane_1.setBounds(472, 345, 316, 56);
		panel.add(textPane_1);
		
		JButton button = new JButton("\uB2EB\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI main = new MainGUI();
				main.loginInfo(loginDto);
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 15));
		button.setBackground(new Color(205, 92, 92));
		button.setBounds(398, 519, 70, 35);
		panel.add(button);
		
	}
}
