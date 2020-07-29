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
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FileUploadGUI {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileUploadGUI window = new FileUploadGUI();
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
	public FileUploadGUI() {
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

		JPanel screen2_fileUpload = new JPanel();
		screen2_fileUpload.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("\uD658\uAE09 \uB300\uD589 \uC2E0\uCCAD\uC744 \uC704\uD55C \uC11C\uB958", null, screen2_fileUpload, null);
		screen2_fileUpload.setLayout(null);
		
		JLabel lbl_idCardUpload = new JLabel("\uC2E0\uBD84\uC99D \uC0AC\uBCF8 (jpg\uD30C\uC77C)");
		lbl_idCardUpload.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lbl_idCardUpload.setBounds(31, 172, 313, 45);
		screen2_fileUpload.add(lbl_idCardUpload);
		
		JLabel lbl_docUpload = new JLabel("\uC704\uC784\uC7A5 \uC0AC\uBCF8 (jpg\uD30C\uC77C)");
		lbl_docUpload.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lbl_docUpload.setBounds(485, 172, 313, 45);
		screen2_fileUpload.add(lbl_docUpload);
		
		JLabel lbl_bankAccountUpload = new JLabel("\uD658\uAE09 \uBC1B\uC744 \uBCF8\uC778 \uBA85\uC758 \uACC4\uC88C\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694.");
		lbl_bankAccountUpload.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		lbl_bankAccountUpload.setBounds(31, 22, 418, 45);
		screen2_fileUpload.add(lbl_bankAccountUpload);
		
//		String [] comboBoxMenu = {"¿ì¸®ÀºÇà ", "±¹¹ÎÀºÇà", "±â¾÷ÀºÇà", "³óÇù", "½ÅÇÑÀºÇà", "±¤ÁÖÀºÇà", "ÇÏ³ªÀºÇà", "ÇÑ±¹¾¾Æ¼ÀºÇà"};  
		JComboBox cb_banks = new JComboBox();
		cb_banks.setBackground(new Color(255, 255, 255));
		cb_banks.setModel(new DefaultComboBoxModel(new String[] {"\uC6B0\uB9AC\uC740\uD589", "\uAD6D\uBBFC\uC740\uD589", "\uAE30\uC5C5\uC740\uD589", "\uB18D\uD611", "\uC2E0\uD55C\uC740\uD589", "\uAD11\uC8FC\uC740\uD589", "\uD558\uB098\uC740\uD589", "\uD55C\uAD6D\uC528\uD2F0\uC740\uD589", "\uC6B0\uCCB4\uAD6D", "\uCE74\uCE74\uC624\uBC45\uD06C"}));
		cb_banks.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		cb_banks.setBounds(31, 66, 146, 21);
		screen2_fileUpload.add(cb_banks);
		
		textField = new JTextField();
		textField.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		textField.setBounds(31, 97, 346, 30);
		screen2_fileUpload.add(textField);
		textField.setColumns(10);	
		
		JLabel lbl_previewIdCard = new JLabel("\uBBF8\uB9AC\uBCF4\uAE30");
		lbl_previewIdCard.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_previewIdCard.setBounds(31, 269, 385, 285);
		screen2_fileUpload.add(lbl_previewIdCard);
		
		JButton btn_fileUpload_idCard = new JButton("\uC774\uBBF8\uC9C0 \uD30C\uC77C \uC5C5\uB85C\uB4DC");
		btn_fileUpload_idCard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {
					lbl_previewIdCard.setIcon(new ImageIcon(chooser.getSelectedFile().getAbsolutePath()));
				}
			}
		});
		btn_fileUpload_idCard.setBackground(new Color(95, 158, 160));
		btn_fileUpload_idCard.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		btn_fileUpload_idCard.setBounds(31, 216, 171, 38);
		screen2_fileUpload.add(btn_fileUpload_idCard);
		
		JLabel lbl_previewDoc = new JLabel("\uBBF8\uB9AC\uBCF4\uAE30");
		lbl_previewDoc.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_previewDoc.setBounds(485, 269, 385, 285);
		screen2_fileUpload.add(lbl_previewDoc);
		
		JButton btn_fileUpload_doc = new JButton("\uC774\uBBF8\uC9C0 \uD30C\uC77C \uC5C5\uB85C\uB4DC");
		btn_fileUpload_doc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(null)) {
					lbl_previewDoc.setIcon(new ImageIcon(chooser.getSelectedFile().getAbsolutePath()));
				}
			}
		});
		btn_fileUpload_doc.setBackground(new Color(95, 158, 160));
		btn_fileUpload_doc.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		btn_fileUpload_doc.setBounds(485, 216, 171, 38);
		screen2_fileUpload.add(btn_fileUpload_doc);
		
		JButton btn_saveBankAccount = new JButton("\uC800\uC7A5");
		btn_saveBankAccount.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		btn_saveBankAccount.setBounds(437, 97, 66, 30);
		screen2_fileUpload.add(btn_saveBankAccount);
		
		JButton btn_saveIdCard = new JButton("\uC800\uC7A5");
		btn_saveIdCard.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		btn_saveIdCard.setBounds(351, 224, 66, 30);
		screen2_fileUpload.add(btn_saveIdCard);
		
		JButton btn_saveDoc = new JButton("\uC800\uC7A5");
		btn_saveDoc.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 13));
		btn_saveDoc.setBounds(804, 229, 66, 30);
		screen2_fileUpload.add(btn_saveDoc);
		
	}
}
