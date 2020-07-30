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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnergySavingInfoGUI window = new EnergySavingInfoGUI();
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
	public EnergySavingInfoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 975, 609);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAC00\uC804\uC758 \uC885\uB958\uB97C \uC120\uD0DD\uD558\uC138\uC694 >> ");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lblNewLabel.setBounds(34, 85, 261, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uB0C9\uC7A5\uACE0", "\uC5D0\uC5B4\uCEE8", "\uC138\uD0C1\uAE30", "\uB0C9\uC628\uC218\uAE30", "\uBC25\uC1A5", "\uCCAD\uC18C\uAE30", "\uACF5\uAE30\uCCAD\uC815\uAE30, \uC81C\uC2B5\uAE30", "TV", "\uC758\uB958\uAC74\uC870\uAE30"}));
		comboBox.setBounds(34, 142, 212, 47);
		frame.getContentPane().add(comboBox);
		
		
		JLabel lbl_previewSaving = new JLabel("");
		lbl_previewSaving.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_previewSaving.setBounds(401, 26, 494, 521);
		frame.getContentPane().add(lbl_previewSaving);
		
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
		button.setBounds(28, 512, 70, 35);
		frame.getContentPane().add(button);
		comboBox.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				if ("냉장고".equals(comboBox.getSelectedItem())) {
					lbl_previewSaving.setIcon(new ImageIcon("E:\\Bigdata\\팀 프로젝트\\[자료] GUI에 쓰인 사진들\\refrigerator.jpg"));
					lbl_previewSaving.setIcon(new ImageIcon(new ImageIcon("E:\\\\Bigdata\\\\팀 프로젝트\\\\[자료] GUI에 쓰인 사진들\\\\refrigerator.jpg").getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("에어컨".equals(comboBox.getSelectedItem())) {
					lbl_previewSaving.setIcon(new ImageIcon("E:\\Bigdata\\팀 프로젝트\\[자료] GUI에 쓰인 사진들\\air_conditioner.jpg"));
					lbl_previewSaving.setIcon(new ImageIcon(new ImageIcon("E:\\\\Bigdata\\\\팀 프로젝트\\\\[자료] GUI에 쓰인 사진들\\\\air_conditioner.jpg").getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("세탁기".equals(comboBox.getSelectedItem())) {
					lbl_previewSaving.setIcon(new ImageIcon("E:\\Bigdata\\팀 프로젝트\\[자료] GUI에 쓰인 사진들\\washer.jpg"));
					lbl_previewSaving.setIcon(new ImageIcon(new ImageIcon("E:\\\\Bigdata\\\\팀 프로젝트\\\\[자료] GUI에 쓰인 사진들\\\\washer.jpg").getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("냉온수기".equals(comboBox.getSelectedItem())) {
					lbl_previewSaving.setIcon(new ImageIcon("E:\\Bigdata\\팀 프로젝트\\[자료] GUI에 쓰인 사진들\\water_dispenser.jpg"));
					lbl_previewSaving.setIcon(new ImageIcon(new ImageIcon("E:\\\\Bigdata\\\\팀 프로젝트\\\\[자료] GUI에 쓰인 사진들\\\\water_dispenser.jpg").getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("밥솥".equals(comboBox.getSelectedItem())) {
					lbl_previewSaving.setIcon(new ImageIcon("E:\\Bigdata\\팀 프로젝트\\[자료] GUI에 쓰인 사진들\\rice_cooker.jpg"));
					lbl_previewSaving.setIcon(new ImageIcon(new ImageIcon("E:\\\\Bigdata\\\\팀 프로젝트\\\\[자료] GUI에 쓰인 사진들\\\\rice_cooker.jpg").getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("청소기".equals(comboBox.getSelectedItem())) {
					lbl_previewSaving.setIcon(new ImageIcon("E:\\Bigdata\\팀 프로젝트\\[자료] GUI에 쓰인 사진들\\vacuum.jpg"));
					lbl_previewSaving.setIcon(new ImageIcon(new ImageIcon("E:\\\\Bigdata\\\\팀 프로젝트\\\\[자료] GUI에 쓰인 사진들\\\\vacuum.jpg").getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("공기청정기, 제습기".equals(comboBox.getSelectedItem())) {
					lbl_previewSaving.setIcon(new ImageIcon("E:\\Bigdata\\팀 프로젝트\\[자료] GUI에 쓰인 사진들\\aircleaner_dehumidifier.jpg"));
					lbl_previewSaving.setIcon(new ImageIcon(new ImageIcon("E:\\\\Bigdata\\\\팀 프로젝트\\\\[자료] GUI에 쓰인 사진들\\\\aircleaner_dehumidifier.jpg").getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("TV".equals(comboBox.getSelectedItem())) {
					lbl_previewSaving.setIcon(new ImageIcon("E:\\Bigdata\\팀 프로젝트\\[자료] GUI에 쓰인 사진들\\tv.jpg"));
					lbl_previewSaving.setIcon(new ImageIcon(new ImageIcon("E:\\\\Bigdata\\\\팀 프로젝트\\\\[자료] GUI에 쓰인 사진들\\\\tv.jpg").getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} else if ("의류건조기".equals(comboBox.getSelectedItem())) {
					lbl_previewSaving.setIcon(new ImageIcon("E:\\Bigdata\\팀 프로젝트\\[자료] GUI에 쓰인 사진들\\clothes_dryer.jpg"));
					lbl_previewSaving.setIcon(new ImageIcon(new ImageIcon("E:\\\\Bigdata\\\\팀 프로젝트\\\\[자료] GUI에 쓰인 사진들\\\\clothes_dryer.jpg").getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
				} 
			}
		});
	}
}
