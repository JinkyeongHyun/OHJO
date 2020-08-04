package view;

import java.awt.Button;
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

	public PolicyInfoGUI(CustomerDTO dto) {
			loginDto = dto;
			initialize();
			frame.setVisible(true);
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 910, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, "name_1334762828370600");
		
		// 닫기 버튼
		JButton button = new JButton("\uB2EB\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI main = new MainGUI();
				main.loginInfo(loginDto);
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		button.setBackground(new Color(205, 92, 92));
		button.setBounds(750, 528, 70, 35);
		panel.add(button);
		
		// 환급제도 정보 이미지
		JLabel label = new JLabel("");	
		label.setIcon(new ImageIcon(new ImageIcon(EnergySavingInfoGUI.class.getResource("/images/(design)PolicyInfo.jpg")).getImage().getScaledInstance(894, 593, Image.SCALE_DEFAULT)));
		label.setBounds(0, 0, 894, 593);
		panel.add(label);
		
	}
}
