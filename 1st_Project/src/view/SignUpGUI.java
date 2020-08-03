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

public class SignUpGUI {

	private JFrame frame;
	private JTextField tf_signUp_id;
	private JPasswordField pf_signUp_pw;
	private JTextField tf_signUp_name;
	private JTextField tf_signUp_cell1;
	
	int flag = 0;
	private JTextField tf_signUp_cell2;
	private JTextField tf_signUp_cell3;
	
	//constructor()
	public SignUpGUI() {
		initialize();
		frame.setVisible(true);
	}
	
	//initialize()
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl_signUp_id = new JLabel("ID");
		lbl_signUp_id.setBounds(40, 40, 57, 15);
		frame.getContentPane().add(lbl_signUp_id);
		
		JLabel lbl_signUp_pw = new JLabel("PW");
		lbl_signUp_pw.setBounds(40, 65, 57, 15);
		frame.getContentPane().add(lbl_signUp_pw);
		
		JLabel lbl_signUp_name = new JLabel("\uC774\uB984");
		lbl_signUp_name.setBounds(40, 90, 57, 15);
		frame.getContentPane().add(lbl_signUp_name);
		
		JLabel lbl_signUp_cell = new JLabel("\uC804\uD654\uBC88\uD638");
		lbl_signUp_cell.setBounds(40, 115, 57, 15);
		frame.getContentPane().add(lbl_signUp_cell);
		
		tf_signUp_id = new JTextField();
		tf_signUp_id.setBounds(109, 37, 116, 21);
		frame.getContentPane().add(tf_signUp_id);
		tf_signUp_id.setColumns(10);
		
		pf_signUp_pw = new JPasswordField();
		pf_signUp_pw.setBounds(109, 62, 116, 21);
		frame.getContentPane().add(pf_signUp_pw);
		
		tf_signUp_name = new JTextField();
		tf_signUp_name.setColumns(10);
		tf_signUp_name.setBounds(109, 87, 116, 21);
		frame.getContentPane().add(tf_signUp_name);
		
		tf_signUp_cell1 = new JTextField();
		tf_signUp_cell1.setColumns(10);
		tf_signUp_cell1.setBounds(109, 112, 30, 21);
		frame.getContentPane().add(tf_signUp_cell1);
		
		tf_signUp_cell2 = new JTextField();
		tf_signUp_cell2.setColumns(10);
		tf_signUp_cell2.setBounds(153, 112, 30, 21);
		frame.getContentPane().add(tf_signUp_cell2);
		
		tf_signUp_cell3 = new JTextField();
		tf_signUp_cell3.setColumns(10);
		tf_signUp_cell3.setBounds(195, 112, 30, 21);
		frame.getContentPane().add(tf_signUp_cell3);
		
		//회원가입
		JButton btn_signUp_signUp = new JButton("\uAC00\uC785\uD558\uAE30");
		btn_signUp_signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag==1) {	
					//중복체크를 한 경우
					String id,pw,name,cell = "";								
					id = tf_signUp_id.getText();					
					pw = pf_signUp_pw.getText();
					name = tf_signUp_name.getText();
					cell = tf_signUp_cell1.getText()+tf_signUp_cell2.getText()+tf_signUp_cell3.getText();
				
					CustomerDAO dao = new CustomerDAO();
					CustomerDTO dto = new CustomerDTO(id, pw, name, cell);
					int result = dao.signUpInsert(dto);
					
					if(result == 1) {
						//회원가입 성공
						JOptionPane.showMessageDialog(null, "회원가입에 성공하셨습니다");
						frame.dispose();
						LoginGUI login = new LoginGUI();
					}else if(result == 0){
						//회원가입 실패
						JOptionPane.showMessageDialog(null, "정확한 정보를 입력해주세요", "check", JOptionPane.ERROR_MESSAGE);
					}	
				}else {	
					//중복체크를 하지 않은 경우
					JOptionPane.showMessageDialog(null,"아이디 중복체크를 해주세요", "check", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btn_signUp_signUp.setBounds(128, 162, 97, 23);
		frame.getContentPane().add(btn_signUp_signUp);
		
		//중복체크
		JButton btn_signUp_check = new JButton("\uC911\uBCF5\uD655\uC778");
		btn_signUp_check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerDAO dao = new CustomerDAO();
				boolean result = dao.signUpCheck(tf_signUp_id.getText());
				
				if(result) {	
					JOptionPane.showMessageDialog(null,"중복되는 아이디입니다", "check", JOptionPane.ERROR_MESSAGE);	//중복인 경우
				}else {	
					JOptionPane.showMessageDialog(null,"사용가능한 아이디입니다");	//중복되지 않은 경우
					flag = 1;
				}
			}
		});
		btn_signUp_check.setBounds(237, 36, 97, 23);
		frame.getContentPane().add(btn_signUp_check);

		//취소
		JButton btn_signUp_cancel = new JButton("\uCDE8\uC18C");
		btn_signUp_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				LoginGUI login = new LoginGUI();
			}
		});
		btn_signUp_cancel.setBounds(237, 162, 97, 23);
		frame.getContentPane().add(btn_signUp_cancel);		
	}

}