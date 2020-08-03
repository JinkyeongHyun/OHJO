package view;

import java.awt.EventQueue;

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
import javax.swing.ImageIcon;

public class CustomerUpdateGUI {

	private JFrame frame;
	private JTextField tf_cUpdate_id;
	private JTextField tf_cUpdate_name;
	private JTextField tf_cUpdate_cell;
	private JPasswordField pf_cUpdate_pw_current;
	private JPasswordField pf_cUpdate_pw_new;
	
	//사용자 정보
	CustomerDTO loginDto;
	
	public CustomerUpdateGUI() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_cUpdate_id = new JLabel("아이디");
		lbl_cUpdate_id.setBounds(60, 39, 57, 15);
		frame.getContentPane().add(lbl_cUpdate_id);
		
		tf_cUpdate_id = new JTextField();
		tf_cUpdate_id.setEditable(false);
		tf_cUpdate_id.setBounds(129, 36, 116, 21);
		frame.getContentPane().add(tf_cUpdate_id);
		tf_cUpdate_id.setColumns(10);
		
		JLabel lbl_cUpdate_pw_current = new JLabel("현재비밀번호");	//현재비밀번호를 입력해서 일치하면 새 비밀번호 변경
		lbl_cUpdate_pw_current.setBounds(37, 64, 80, 15);
		frame.getContentPane().add(lbl_cUpdate_pw_current);
		
		pf_cUpdate_pw_current = new JPasswordField();
		pf_cUpdate_pw_current.setBounds(129, 61, 116, 21);
		frame.getContentPane().add(pf_cUpdate_pw_current);
		
		JLabel lbl_cUpdate_pw_new = new JLabel("새비밀번호");
		lbl_cUpdate_pw_new.setBounds(37, 89, 80, 15);
		frame.getContentPane().add(lbl_cUpdate_pw_new);
		
		pf_cUpdate_pw_new = new JPasswordField();
		pf_cUpdate_pw_new.setBounds(129, 86, 116, 21);
		frame.getContentPane().add(pf_cUpdate_pw_new);
		
		//비밀번호 확인 버튼
		JButton btn_cUpdate_pwCheck = new JButton("확인");
		btn_cUpdate_pwCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pf_cUpdate_pw_current.getText().equals(loginDto.getC_pw())) {
					JOptionPane.showMessageDialog(null,"현재 비밀번호가 일치합니다");
				}else {
					JOptionPane.showMessageDialog(null,"현재 비밀번호가 일치하지 않습니다");
				}
			}
		});
		btn_cUpdate_pwCheck.setBounds(257, 60, 97, 23);
		frame.getContentPane().add(btn_cUpdate_pwCheck);
		
		JLabel lbl_cUpdate_name = new JLabel("이름");
		lbl_cUpdate_name.setBounds(60, 114, 57, 15);
		frame.getContentPane().add(lbl_cUpdate_name);
		
		tf_cUpdate_name = new JTextField();
		tf_cUpdate_name.setBounds(129, 111, 116, 21);
		frame.getContentPane().add(tf_cUpdate_name);
		tf_cUpdate_name.setColumns(10);
		
		JLabel lbl_cUpdate_cell = new JLabel("연락처");
		lbl_cUpdate_cell.setBounds(60, 139, 57, 15);
		frame.getContentPane().add(lbl_cUpdate_cell);
		
		tf_cUpdate_cell = new JTextField();
		tf_cUpdate_cell.setBounds(129, 136, 116, 21);
		frame.getContentPane().add(tf_cUpdate_cell);
		tf_cUpdate_cell.setColumns(10);
		
		//수정버튼
		JButton btn_cUpdate_update = new JButton("수정");
		btn_cUpdate_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pf_cUpdate_pw_current.getText().equals(loginDto.getC_pw())) {
					String id = tf_cUpdate_id.getText();
					String pw = pf_cUpdate_pw_new.getText();
					String name = tf_cUpdate_name.getText();
					String cell = tf_cUpdate_cell.getText();
					CustomerDTO dto = new CustomerDTO(id, pw, name, cell);
					CustomerDAO dao = new CustomerDAO();
					int result = dao.customerUpdate(dto);
					
					if(result == 1) {	//회원정보수정 성공
						JOptionPane.showMessageDialog(null,"회원정보를 수정했습니다");
						frame.dispose();
						CustomerUpdateGUI update = new CustomerUpdateGUI();
						update.loginInfo(dto);
					}else {	//회원정보수정 실패
						JOptionPane.showMessageDialog(null,"회원정보수정에 실패했습니다");
					}
				}else {
					JOptionPane.showMessageDialog(null,"현재 비밀번호가 일치하지 않습니다");
				}
				
			}
		});
		btn_cUpdate_update.setBounds(60, 164, 97, 23);
		frame.getContentPane().add(btn_cUpdate_update);
		
		//취소버튼
		JButton btn_cUpdate_cancell = new JButton("취소");
		btn_cUpdate_cancell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//창 끄기
				frame.dispose();
				//MainGUI로 이동
				MainGUI main = new MainGUI();
				main.loginInfo(loginDto);
			}
		});
		btn_cUpdate_cancell.setBounds(166, 164, 97, 23);
		frame.getContentPane().add(btn_cUpdate_cancell);
		
		//회원탈퇴버튼
		JButton btn_cUpdate_delete = new JButton("회원탈퇴");
		btn_cUpdate_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Y > 0, N > 1
				String inputPw = JOptionPane.showInputDialog("현재 비밀번호를 입력하세요");
				if(inputPw.equals(loginDto.getC_pw())) {
					int y_n = JOptionPane.showConfirmDialog(null, "정말 탈퇴하시겠습니까?","",JOptionPane.YES_NO_OPTION);
					if(y_n == 0) {
						CustomerDAO dao = new CustomerDAO();
						int result = dao.customerDelete(loginDto);
						if(result == 1) {	//회원탈퇴 성공
							JOptionPane.showMessageDialog(null, "안녕히 가십시오");
							frame.dispose();
							MainGUI main = new MainGUI();
						}else {				//회원탈퇴 실패
							JOptionPane.showMessageDialog(null,"가지마세요");
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "현재 비밀번호가 일치하지 않습니다");
				}
			}
		});
		btn_cUpdate_delete.setBounds(325, 228, 97, 23);
		frame.getContentPane().add(btn_cUpdate_delete);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CustomerUpdateGUI.class.getResource("/images/loginBGI.jpg")));
		lblNewLabel.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(lblNewLabel);		
	}
	
	//사용자 정보 세팅
	public void loginInfo(CustomerDTO dto) {
		tf_cUpdate_id.setText(dto.getC_id());
		tf_cUpdate_name.setText(dto.getC_name());
		tf_cUpdate_cell.setText(dto.getC_cell());		
		loginDto = dto;
	}
}