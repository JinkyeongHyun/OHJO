package part3_jinkyeong;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;

public class part3_applicationFullGUI {

	private JFrame frame;
	private JTextField tf_accountNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					part3_applicationFullGUI window = new part3_applicationFullGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public part3_applicationFullGUI() {
		initialize();
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
		
		JLabel lbl_policyImage = new JLabel("");
		lbl_policyImage.setIcon(new ImageIcon("C:\\Users\\SMT016\\Desktop\\\uD604\uC9C4\uACBD\\policyInfo.jpg"));
		lbl_policyImage.setBounds(12, 10, 877, 288);
		screen1_policyInfo.add(lbl_policyImage);
		
		JLabel lbl_whatContents = new JLabel("\u3147 \uC0AC\uC5C5 \uB0B4\uC6A9\uC740?");
		lbl_whatContents.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_whatContents.setForeground(new Color(0, 128, 128));
		lbl_whatContents.setFont(new Font("���� ����", Font.BOLD, 18));
		lbl_whatContents.setBounds(41, 313, 156, 27);
		screen1_policyInfo.add(lbl_whatContents);
		
		JLabel lbl_whereAt = new JLabel("\u3147 \uC2E0\uCCAD\uC740 \uC5B4\uB514\uC5D0\uC11C?");
		lbl_whereAt.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_whereAt.setForeground(new Color(0, 128, 128));
		lbl_whereAt.setFont(new Font("���� ����", Font.BOLD, 18));
		lbl_whereAt.setBounds(460, 313, 201, 27);
		screen1_policyInfo.add(lbl_whereAt);
		
		JTextPane tp_contents = new JTextPane();
		tp_contents.setFont(new Font("���� ����", Font.BOLD, 13));
		tp_contents.setText("\u3141 \uC81C\uD488 \uAD6C\uB9E4 \uAE30\uAC04\r\n2020\uB144 3\uC6D4 23\uC77C ~ 12\uC6D4 31\uC77C \r\n(\uB2E8, \uC758\uB958\uAC74\uC870\uAE30\uB294 2020\uB144 7\uC6D4 6\uC77C ~ 12\uC6D4 31\uC77C)\r\n\r\n\u3141 \uD658\uAE09 \uC2E0\uCCAD \uAE30\uAC04\r\n2020\uB144 3\uC6D4 23\uC77C ~ 2021\uB144 1\uC6D4 15\uC77C \r\n(\uB2E8, \uC758\uB958\uAC74\uC870\uAE30\uB294 2020\uB144 7\uC6D4 6\uC77C ~ 2021\uB144 1\uC6D4 15\uC77C)");
		tp_contents.setBounds(53, 345, 368, 149);
		screen1_policyInfo.add(tp_contents);
		
		JTextPane tp_site = new JTextPane();
		tp_site.setText("https://rebate.energy.or.kr \uD648\uD398\uC774\uC9C0\uC640 \r\n\uD604\uC7AC \uC0AC\uC774\uD2B8\uC5D0\uC11C \uB300\uD589 \uC2E0\uCCAD \uAC00\uB2A5");
		tp_site.setFont(new Font("���� ����", Font.BOLD, 15));
		tp_site.setBounds(472, 345, 316, 56);
		screen1_policyInfo.add(tp_site);
		
		JPanel screen2_fileUpload = new JPanel();
		screen2_fileUpload.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("\uD658\uAE09 \uB300\uD589 \uC2E0\uCCAD\uC744 \uC704\uD55C \uC11C\uB958", null, screen2_fileUpload, null);
		screen2_fileUpload.setLayout(null);
		
		
		
		JLabel lbl_idCardUpload = new JLabel("\uC2E0\uBD84\uC99D \uC0AC\uBCF8");
		lbl_idCardUpload.setFont(new Font("���� ����", Font.BOLD, 20));
		lbl_idCardUpload.setBounds(31, 172, 313, 45);
		screen2_fileUpload.add(lbl_idCardUpload);
		
		JLabel lbl_docUpload = new JLabel("\uC704\uC784\uC7A5 \uC0AC\uBCF8");
		lbl_docUpload.setFont(new Font("���� ����", Font.BOLD, 20));
		lbl_docUpload.setBounds(31, 302, 313, 45);
		screen2_fileUpload.add(lbl_docUpload);
		
		JLabel lbl_bankAccountUpload = new JLabel("\uD658\uAE09 \uBC1B\uC744 \uBCF8\uC778 \uBA85\uC758 \uACC4\uC88C\uBC88\uD638");
		lbl_bankAccountUpload.setFont(new Font("���� ����", Font.BOLD, 20));
		lbl_bankAccountUpload.setBounds(31, 22, 313, 45);
		screen2_fileUpload.add(lbl_bankAccountUpload);
		
//		String [] comboBoxMenu = {"�츮���� ", "��������", "�������", "����", "��������", "��������", "�ϳ�����", "�ѱ���Ƽ����"};  
		JComboBox cb_banks = new JComboBox();
		cb_banks.setBackground(new Color(255, 255, 255));
		cb_banks.setModel(new DefaultComboBoxModel(new String[] {"\uC6B0\uB9AC\uC740\uD589", "\uAD6D\uBBFC\uC740\uD589", "\uAE30\uC5C5\uC740\uD589", "\uB18D\uD611", "\uC2E0\uD55C\uC740\uD589", "\uAD11\uC8FC\uC740\uD589", "\uD558\uB098\uC740\uD589", "\uD55C\uAD6D\uC528\uD2F0\uC740\uD589", "\uC6B0\uCCB4\uAD6D", "\uCE74\uCE74\uC624\uBC45\uD06C"}));
		cb_banks.setFont(new Font("���� ����", Font.PLAIN, 13));
		cb_banks.setBounds(31, 77, 146, 21);
		screen2_fileUpload.add(cb_banks);
		
		tf_accountNumber = new JTextField();
		tf_accountNumber.setFont(new Font("���� ����", Font.PLAIN, 13));
		tf_accountNumber.setBounds(31, 108, 386, 30);
		screen2_fileUpload.add(tf_accountNumber);
		tf_accountNumber.setColumns(30);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\SMT016\\Desktop\\\uD604\uC9C4\uACBD\\policyImage.jpg"));
		lblNewLabel.setBounds(544, 77, 333, 278);
		screen2_fileUpload.add(lblNewLabel);
		
		JPanel screen3_energySavingSecret = new JPanel();
		screen3_energySavingSecret.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("\uC6B0\uB9AC\uC9D1 \uC5D0\uB108\uC9C0 \uC808\uC57D\uC740 \uC774\uB807\uAC8C \uD574\uC694!", null, screen3_energySavingSecret, null);
		screen3_energySavingSecret.setLayout(null);
		
		JLabel lbl_chooseProductsType = new JLabel("\uAC00\uC804 \uC885\uB958\uB97C \uC120\uD0DD\uD574 \uC8FC\uC138\uC694!");
		lbl_chooseProductsType.setFont(new Font("���� ����", Font.BOLD, 20));
		lbl_chooseProductsType.setBounds(27, 67, 280, 47);
		screen3_energySavingSecret.add(lbl_chooseProductsType);
		
		JComboBox cb_sortOfProducts = new JComboBox();
		cb_sortOfProducts.setBackground(new Color(255, 255, 255));
		cb_sortOfProducts.setModel(new DefaultComboBoxModel(new String[] {"\uB0C9\uC7A5\uACE0", "\uAE40\uCE58\uB0C9\uC7A5\uACE0", "\uC5D0\uC5B4\uCEE8 (\uBCBD\uAC78\uC774)", "\uC5D0\uC5B4\uCEE8 (\uADF8 \uC678)", "\uC138\uD0C1\uAE30 (\uC77C\uBC18)", "\uC138\uD0C1\uAE30 (\uB4DC\uB7FC)", "\uB0C9\uC628\uC218\uAE30 (\uC800\uC7A5\uC2DD)", "\uB0C9\uC628\uC218\uAE30 (\uC9C1\uC218\uC2DD)", "\uC804\uAE30\uBC25\uC1A5", "\uC9C4\uACF5 \uCCAD\uC18C\uAE30", "\uACF5\uAE30\uCCAD\uC815\uAE30", "TV", "\uC81C\uC2B5\uAE30", "\uC758\uB958\uAC74\uC870\uAE30"}));
		cb_sortOfProducts.setFont(new Font("���� ����", Font.PLAIN, 15));
		cb_sortOfProducts.setBounds(27, 124, 183, 32);
		screen3_energySavingSecret.add(cb_sortOfProducts);
		
		JTextPane textPane = new JTextPane();
		textPane.setForeground(new Color(0, 128, 128));
		textPane.setBackground(new Color(255, 255, 255));
		textPane.setFont(new Font("���ʷҵ���", Font.BOLD, 30));
		textPane.setText("\uC0DD\uD65C \uC18D \uC5D0\uCF54 \uC2E4\uCC9C");
		textPane.setBounds(368, 21, 280, 57);
		screen3_energySavingSecret.add(textPane);
		
		JButton btn_goToApplication = new JButton("\uB300\uD589 \uC2E0\uCCAD \uBC14\uB85C\uAC00\uAE30");
		btn_goToApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
//				screen2_fileUpload.
				
			}
		});
		btn_goToApplication.setBackground(new Color(95, 158, 160));
		btn_goToApplication.setForeground(new Color(0, 0, 0));
		btn_goToApplication.setFont(new Font("���� ����", Font.BOLD, 15));
		btn_goToApplication.setBounds(472, 412, 168, 30);
		screen1_policyInfo.add(btn_goToApplication);
		
		JButton button = new JButton("\uB2EB\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("���� ����", Font.BOLD, 15));
		button.setBackground(new Color(205, 92, 92));
		button.setBounds(398, 519, 70, 35);
		screen1_policyInfo.add(button);
		
	}
}
