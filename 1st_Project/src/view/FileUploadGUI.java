package view;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.ApplyDAO;
import model.CustomerDTO;

public class FileUploadGUI {

	private JFrame frame;
	private JTextField bankaccountInsert;
	
	CustomerDTO loginDto;
	private JTextField tf_idcardPath;
	private JTextField tf_docPath;

	public FileUploadGUI(CustomerDTO dto) {
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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSelectedIndex(-1);
		tabbedPane.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(tabbedPane, "name_445368215119300");

		JPanel screen2_fileUpload = new JPanel();
		screen2_fileUpload.setBackground(Color.WHITE);
		tabbedPane.addTab("\uD658\uAE09 \uB300\uD589 \uC2E0\uCCAD\uC744 \uC704\uD55C \uC11C\uB958", null, screen2_fileUpload, null);
		screen2_fileUpload.setLayout(null);
		
		JLabel lbl_idCardUpload = new JLabel("\uC2E0\uBD84\uC99D \uC0AC\uBCF8 (jpg\uD30C\uC77C)");
		lbl_idCardUpload.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbl_idCardUpload.setBounds(31, 172, 313, 45);
		screen2_fileUpload.add(lbl_idCardUpload);
		
		JLabel lbl_docUpload = new JLabel("\uC704\uC784\uC7A5 \uC0AC\uBCF8 (jpg\uD30C\uC77C)");
		lbl_docUpload.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbl_docUpload.setBounds(485, 172, 313, 45);
		screen2_fileUpload.add(lbl_docUpload);
		
		JLabel lbl_bankAccountUpload = new JLabel("\uD658\uAE09 \uBC1B\uC744 \uBCF8\uC778 \uBA85\uC758 \uACC4\uC88C\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694.");
		lbl_bankAccountUpload.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbl_bankAccountUpload.setBounds(31, 22, 418, 45);
		screen2_fileUpload.add(lbl_bankAccountUpload);
		
		// 은행 고르는 버튼
		JComboBox cb_banks = new JComboBox();
		cb_banks.setBackground(new Color(255, 255, 255));
		cb_banks.setModel(new DefaultComboBoxModel(new String[] {"\uC6B0\uB9AC\uC740\uD589", "\uAD6D\uBBFC\uC740\uD589", "\uAE30\uC5C5\uC740\uD589", "\uB18D\uD611", "\uC2E0\uD55C\uC740\uD589", "\uAD11\uC8FC\uC740\uD589", "\uD558\uB098\uC740\uD589", "\uD55C\uAD6D\uC528\uD2F0\uC740\uD589", "\uC6B0\uCCB4\uAD6D", "\uCE74\uCE74\uC624\uBC45\uD06C"}));
		cb_banks.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		cb_banks.setBounds(31, 66, 146, 21);
		screen2_fileUpload.add(cb_banks);
		
		// 계좌번호 입력 창
		bankaccountInsert = new JTextField();
		bankaccountInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		bankaccountInsert.setBounds(31, 97, 346, 30);
		screen2_fileUpload.add(bankaccountInsert);
		bankaccountInsert.setColumns(10);	
		
		// 업로드된 신분증 사본 미리보기 창
		JLabel lbl_previewIdCard = new JLabel("\uBBF8\uB9AC\uBCF4\uAE30");
		lbl_previewIdCard.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_previewIdCard.setBounds(31, 299, 300, 255);
		screen2_fileUpload.add(lbl_previewIdCard);
		
		// 신분증 사본 파일 경로
		tf_idcardPath = new JTextField();
		tf_idcardPath.setBounds(30, 268, 387, 21);
		screen2_fileUpload.add(tf_idcardPath);
		tf_idcardPath.setColumns(10);
		
		// 신분증 사본 업로드 버튼
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
		lbl_previewDoc.setBounds(485, 299, 300, 255);
		screen2_fileUpload.add(lbl_previewDoc);
		
		// 위임장 사본 파일 경로
		tf_docPath = new JTextField();
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
		
		// 계좌번호 저장 버튼
		JButton btn_saveBankAccount = new JButton("저장");
		btn_saveBankAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String bank = (String) cb_banks.getSelectedItem();
				String bankaccount = bankaccountInsert.getText();
				ApplyDAO dao = new ApplyDAO();
				dao.bankInfo(loginDto.getC_id(), bank, bankaccount); 
				
				if (bankaccount.equals("")) {
					JOptionPane.showMessageDialog(null, "계좌번호를 입력하십시오.");
				} else {
					JOptionPane.showMessageDialog(null, "저장이 완료되었습니다.\n신분증과 위임장 사본을 첨부해 주세요.");
//					frame.dispose();
//					MainGUI main = new MainGUI();
//					return;
				}
			}
		});
		btn_saveBankAccount.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		btn_saveBankAccount.setBounds(437, 97, 66, 30);
		screen2_fileUpload.add(btn_saveBankAccount);
		
		
		// 업로드된 신분증 사본 저장 버튼
		JButton btn_saveIdCard = new JButton("\uC800\uC7A5");
		btn_saveIdCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_idcardPath.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "파일을 선택하십시오.");
				} else {
					JOptionPane.showMessageDialog(null, "저장을 완료하였습니다.");
//					frame.dispose();
//					MainGUI main = new MainGUI();
//					return;
				}
			}
		});
		btn_saveIdCard.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		btn_saveIdCard.setBounds(351, 224, 66, 30);
		screen2_fileUpload.add(btn_saveIdCard);
		
		// 업로드된 위임장 사본 저장 버튼
		JButton btn_saveDoc = new JButton("\uC800\uC7A5");
		btn_saveDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_docPath.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "파일을 선택하십시오.");
				} else {
					JOptionPane.showMessageDialog(null, "저장을 완료하였습니다.");
					frame.dispose();
					MainGUI main = new MainGUI();
					return;
				}
			}
		});
		btn_saveDoc.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		btn_saveDoc.setBounds(804, 229, 66, 30);
		screen2_fileUpload.add(btn_saveDoc);
		
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
		btn_close.setBounds(409, 519, 70, 35);
		screen2_fileUpload.add(btn_close);
		
		
		
	}
}
