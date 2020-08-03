package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.ApplyDAO;
import model.CustomerDTO;

public class FileUploadGUI {

	private JFrame frame;
	
	CustomerDTO loginDto;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private JTextField tf_idcardPath;
	private JTextField tf_docPath;

	
	public FileUploadGUI(CustomerDTO dto) {
		loginDto = dto;
		initialize();
		frame.setVisible(true);
	}
		
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 910, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel screen2_fileUpload = new JPanel();
		screen2_fileUpload.setLayout(null);
		screen2_fileUpload.setBackground(Color.WHITE);
		frame.getContentPane().add(screen2_fileUpload, "name_1336119195484900");
		
		JLabel lbl_idCardUpload = new JLabel("\uC2E0\uBD84\uC99D \uC0AC\uBCF8 (jpg\uD30C\uC77C)");
		lbl_idCardUpload.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbl_idCardUpload.setBounds(31, 172, 313, 45);
		screen2_fileUpload.add(lbl_idCardUpload);
		
		JLabel lbl_docUpload = new JLabel("\uC704\uC784\uC7A5 \uC0AC\uBCF8 (jpg\uD30C\uC77C)");
		lbl_docUpload.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbl_docUpload.setBounds(485, 172, 313, 45);
		screen2_fileUpload.add(lbl_docUpload);
		
		JLabel lbl_bankAccountUpload = new JLabel("\uD658\uAE09 \uBC1B\uC744 \uBCF8\uC778 \uBA85\uC758 \uACC4\uC88C\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694 (\"-\" \uC81C\uC678).");
		lbl_bankAccountUpload.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbl_bankAccountUpload.setBounds(31, 22, 523, 45);
		screen2_fileUpload.add(lbl_bankAccountUpload);
		
		// 은행 선택
		JComboBox cb_banks = new JComboBox();
		cb_banks.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		cb_banks.setBackground(Color.WHITE);
		cb_banks.setModel(new DefaultComboBoxModel(new String[] {"우리은행", "신한은행", "농협", "광주은행", "하나은행", "국민은행", "한국씨티은행"}));
		cb_banks.setBounds(31, 66, 146, 21);
		screen2_fileUpload.add(cb_banks);
		
		// 계좌번호 입력
		JTextField bankaccountInsert = new JTextField();
		bankaccountInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		bankaccountInsert.setColumns(10);
		bankaccountInsert.setBounds(31, 97, 346, 30);
		screen2_fileUpload.add(bankaccountInsert);
		
		// 업로드된 신분증 이미지 미리보기
		JLabel lbl_previewIdCard = new JLabel("미리 보기");
		lbl_previewIdCard.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_previewIdCard.setBounds(31, 299, 300, 255);
		screen2_fileUpload.add(lbl_previewIdCard);
		
		// 신분증 사본 파일 경로
		JTextField	tf_idcardPath = new JTextField();
		tf_idcardPath.setBounds(30, 268, 387, 21);
		screen2_fileUpload.add(tf_idcardPath);
		tf_idcardPath.setColumns(10);
		
		// 신분증 사본 업로드
		JButton btn_fileUpload_idCard = new JButton("\uC774\uBBF8\uC9C0 \uD30C\uC77C \uC5C5\uB85C\uB4DC");
		btn_fileUpload_idCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();// 객체 생성
				
				if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {
					lbl_previewIdCard.setIcon(new ImageIcon(chooser.getSelectedFile().getAbsolutePath()));
					String a = chooser.getSelectedFile().getAbsolutePath();
					tf_idcardPath.setText(a);
				}
			}
		});
		btn_fileUpload_idCard.setBackground(new Color(95, 158, 160));
		btn_fileUpload_idCard.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		btn_fileUpload_idCard.setBounds(31, 216, 171, 38);
		screen2_fileUpload.add(btn_fileUpload_idCard);
		
		// 업로드된 위임장 사본 미리보기
		JLabel lbl_previewDoc = new JLabel("\uBBF8\uB9AC\uBCF4\uAE30");
		lbl_previewDoc.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_previewDoc.setBounds(572, 299, 300, 255);
		screen2_fileUpload.add(lbl_previewDoc);
				
		// 위임장 사본 파일 경로
		JTextField tf_docPath = new JTextField();
		tf_docPath.setBounds(485, 268, 387, 21);
		screen2_fileUpload.add(tf_docPath);
		tf_docPath.setColumns(10);
				
		// 위임장 사본 업로드 버튼
		JButton btn_fileUpload_doc = new JButton("\uC774\uBBF8\uC9C0 \uD30C\uC77C \uC5C5\uB85C\uB4DC");
		btn_fileUpload_doc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {
					lbl_previewDoc.setIcon(new ImageIcon(chooser.getSelectedFile().getAbsolutePath()));
					String a = chooser.getSelectedFile().getAbsolutePath();
			              tf_docPath.setText(a);
				}
			}
		});
		btn_fileUpload_doc.setBackground(new Color(95, 158, 160));
		btn_fileUpload_doc.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		btn_fileUpload_doc.setBounds(485, 216, 171, 38);
		screen2_fileUpload.add(btn_fileUpload_doc);
				
		// 닫기 버튼
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
		btn_close.setBounds(437, 533, 70, 35);
		screen2_fileUpload.add(btn_close);
		
		// 저장 버튼
		JButton btn_save = new JButton("\uC800\uC7A5");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bank = (String) cb_banks.getSelectedItem();
				String bankaccount = bankaccountInsert.getText();
				ApplyDAO dao = new ApplyDAO();
				dao.bankInfo(loginDto.getC_id(), bank, bankaccount); 
						
				if (bankaccount.equals("") || tf_idcardPath.getText().equals("") || tf_docPath.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "비어있는 항목을 채우십시오.");
				} else {
					JOptionPane.showMessageDialog(null, "저장을 완료하였습니다.");
					frame.dispose();
					MainGUI main = new MainGUI();
					return;
				}
			}
		});
		btn_save.setForeground(Color.BLACK);
		btn_save.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		btn_save.setBackground(new Color(205, 92, 92));
		btn_save.setBounds(357, 533, 70, 35);
		screen2_fileUpload.add(btn_save);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(EnergySavingInfoGUI.class.getResource("/images/loginBBBB.png")).getImage().getScaledInstance(894, 593, Image.SCALE_DEFAULT)));
		lblNewLabel.setBounds(0, 0, 894, 593);
		screen2_fileUpload.add(lblNewLabel);
	}
}
