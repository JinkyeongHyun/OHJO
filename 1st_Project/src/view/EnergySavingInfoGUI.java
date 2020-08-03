package view;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.CustomerDTO;

public class EnergySavingInfoGUI {

	private JFrame frame;
	
	CustomerDTO loginDto;


	public EnergySavingInfoGUI(CustomerDTO dto) {
		loginDto = dto;
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 975, 609);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// ������ �̸����� ȭ��
		JLabel lbl_previewScreen = new JLabel("");		
		lbl_previewScreen.setIcon(new ImageIcon(new ImageIcon(EnergySavingInfoGUI.class.getResource("/images/refrigerator.jpg" )).getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
		lbl_previewScreen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_previewScreen.setBounds(394, 26, 494, 521);
		frame.getContentPane().add(lbl_previewScreen);
		
		JLabel lblNewLabel = new JLabel("\uAC00\uC804\uC758 \uC885\uB958\uB97C \uC120\uD0DD\uD558\uC138\uC694 >> ");
		lblNewLabel.setFont(new Font("���� ���", Font.BOLD, 15));
		lblNewLabel.setBounds(74, 84, 261, 36);
		frame.getContentPane().add(lblNewLabel);
		
		// ������ǰ ���� ���� �޺��ڽ�
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("���� ���", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uB0C9\uC7A5\uACE0", "\uC5D0\uC5B4\uCEE8", "\uC138\uD0C1\uAE30", "\uB0C9\uC628\uC218\uAE30", "\uBC25\uC1A5", "\uCCAD\uC18C\uAE30", "\uACF5\uAE30\uCCAD\uC815\uAE30, \uC81C\uC2B5\uAE30", "TV", "\uC758\uB958\uAC74\uC870\uAE30"}));
		comboBox.setBounds(74, 134, 212, 47);
		frame.getContentPane().add(comboBox);
		
		// "�ݱ�" ��ư
		JButton button = new JButton("\uB2EB\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI main = new MainGUI();
				main.loginInfo(loginDto);
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("���� ���", Font.BOLD, 15));
		button.setBackground(new Color(205, 92, 92));
		button.setBounds(12, 525, 70, 35);
		frame.getContentPane().add(button);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 959, 570);
		frame.getContentPane().add(lblNewLabel_1);
		
		// ������ǰ ���� ���� �׿� �´� �̹����� ��µǰ� �ϴ� �κ�
		comboBox.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				if ("�����".equals(comboBox.getSelectedItem())) {	
					lbl_previewScreen.setIcon(new ImageIcon(new ImageIcon(EnergySavingInfoGUI.class.getResource("/images/refrigerator.jpg")).getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("������".equals(comboBox.getSelectedItem())) {
					lbl_previewScreen.setIcon(new ImageIcon(new ImageIcon(EnergySavingInfoGUI.class.getResource("/images/air_conditioner.jpg")).getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("��Ź��".equals(comboBox.getSelectedItem())) {					
					lbl_previewScreen.setIcon(new ImageIcon(new ImageIcon(EnergySavingInfoGUI.class.getResource("/images/washer.jpg")).getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("�ÿ¼���".equals(comboBox.getSelectedItem())) {					
					lbl_previewScreen.setIcon(new ImageIcon(new ImageIcon(EnergySavingInfoGUI.class.getResource("/images/water_dispenser.jpg")).getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("���".equals(comboBox.getSelectedItem())) {					
					lbl_previewScreen.setIcon(new ImageIcon(new ImageIcon(EnergySavingInfoGUI.class.getResource("/images/rice_cooker.jpg")).getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("û�ұ�".equals(comboBox.getSelectedItem())) {					
					lbl_previewScreen.setIcon(new ImageIcon(new ImageIcon(EnergySavingInfoGUI.class.getResource("/images/vacuum.jpg")).getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("����û����, ������".equals(comboBox.getSelectedItem())) {					
					lbl_previewScreen.setIcon(new ImageIcon(new ImageIcon(EnergySavingInfoGUI.class.getResource("/images/aircleaner_dehumidifier.jpg")).getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("TV".equals(comboBox.getSelectedItem())) {					
					lbl_previewScreen.setIcon(new ImageIcon(new ImageIcon(EnergySavingInfoGUI.class.getResource("/images/tv.jpg")).getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("�Ƿ�������".equals(comboBox.getSelectedItem())) {					
					lbl_previewScreen.setIcon(new ImageIcon(new ImageIcon(EnergySavingInfoGUI.class.getResource("/images/clothes_dryer.jpg")).getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} 
			}
		});
		
		
	}
}
