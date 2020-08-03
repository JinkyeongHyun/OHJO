package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.CustomerDAO;
import model.CustomerDTO;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;

public class LoginGUI {

	private JFrame frame;
	private JTextField tf_login_id;
	private JPasswordField pf_login_pw;
	private JButton btn_login_login;
	private JButton btn_login_signUp;
	private JButton btn_login_cancel;
	private JLabel lblNewLabel;
	
	//constructor()
	public LoginGUI() {
		initialize();
		frame.setVisible(true);
	}
	
	//initialize()
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_login_id = new JLabel("ID");
		lbl_login_id.setBounds(41, 44, 57, 15);
		frame.getContentPane().add(lbl_login_id);
		
		JLabel lbl_login_pw = new JLabel("PW");
		lbl_login_pw.setBounds(41, 69, 57, 15);
		frame.getContentPane().add(lbl_login_pw);
		
		tf_login_id = new JTextField();
		tf_login_id.setBounds(166, 41, 116, 21);
		frame.getContentPane().add(tf_login_id);
		tf_login_id.setColumns(10);
		
		pf_login_pw = new JPasswordField();
		pf_login_pw.setBounds(166, 66, 116, 21);
		frame.getContentPane().add(pf_login_pw);
		
		//로그인
		btn_login_login = new JButton("\uB85C\uADF8\uC778");
		btn_login_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tf_login_id.getText();
				String pw = pf_login_pw.getText();
				CustomerDAO dao = new CustomerDAO();
				CustomerDTO dto = dao.loginSelect(id, pw);
				if(dto == null) {
					//로그인 실패
					JOptionPane.showMessageDialog(null,"아이디 혹은 비밀번호가 일치하지 않습니다.", "login", JOptionPane.ERROR_MESSAGE); 
					pf_login_pw.setText(""); //비밀번호 지우기
				}else {
					//로그인 성공
					//로그인창 종료, 메인화면으로 이동
					frame.dispose();
					MainGUI main = new MainGUI();
					main.loginInfo(dto);
				}
			}
		});
		btn_login_login.setBounds(166, 127, 97, 23);
		frame.getContentPane().add(btn_login_login);
		
		//회원가입
		btn_login_signUp = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btn_login_signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SignUpGUI signUp = new SignUpGUI();
			}
		});
		btn_login_signUp.setBounds(166, 150, 97, 23);
		frame.getContentPane().add(btn_login_signUp);
		
		//취소
		btn_login_cancel = new JButton("\uCDE8\uC18C");
		btn_login_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI main = new MainGUI();
			}
		});
		btn_login_cancel.setBounds(166, 172, 97, 23);
		frame.getContentPane().add(btn_login_cancel);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginGUI.class.getResource("/images/loginBGI.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel);
	}
}
