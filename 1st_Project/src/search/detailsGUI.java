package search;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;

public class detailsGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					detailsGUI window = new detailsGUI();
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
	public detailsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 451, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC81C\uD488 \uBAA8\uB378 \uC0C1\uC138\uC815\uBCF4");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(138, 10, 167, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 57, 411, 494);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(43, 10, 330, 228);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("\uBAA8\uB378\uBA85 : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(12, 248, 59, 51);
		panel.add(lblNewLabel_2);
		
		JLabel label = new JLabel("\uC81C\uD488\uBA85  : ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(203, 261, 59, 35);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\uBD84\uB958  : ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(12, 312, 59, 35);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\uC5D0\uB108\uC9C0 \uD6A8\uC728 \uB4F1\uAE09  : ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(194, 306, 123, 35);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("\uC5F0\uAC04 \uBE44\uC6A9 : ");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(225, 357, 92, 35);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("\uAE08\uC561  : ");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(194, 402, 123, 35);
		panel.add(label_5);
		
		JLabel lb_model = new JLabel("");
		lb_model.setBounds(83, 253, 108, 41);
		panel.add(lb_model);
		
		JLabel lb_name = new JLabel("");
		lb_name.setBounds(274, 258, 125, 41);
		panel.add(lb_name);
		
		JLabel lb_cate = new JLabel("");
		lb_cate.setBounds(83, 309, 82, 41);
		panel.add(lb_cate);
		
		JLabel lb_rank = new JLabel("");
		lb_rank.setBounds(342, 306, 57, 35);
		panel.add(lb_rank);
		
		JLabel lb_ev = new JLabel("");
		lb_ev.setBounds(132, 357, 57, 35);
		panel.add(lb_ev);
		
		JLabel lb_yearCost = new JLabel("");
		lb_yearCost.setBounds(329, 357, 79, 35);
		panel.add(lb_yearCost);
		
		JLabel lb_cost = new JLabel("");
		lb_cost.setBounds(342, 402, 57, 35);
		panel.add(lb_cost);
		
		JLabel label_3 = new JLabel("\uC5F0\uAC04 \uC0AC\uC6A9 \uBE44\uC6A9 : ");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(12, 357, 108, 35);
		panel.add(label_3);
		
		JButton btn_buy = new JButton("\uAD6C\uB9E4\uD558\uAE30");
		btn_buy.setBounds(12, 461, 108, 23);
		panel.add(btn_buy);
		
		JButton btn_back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btn_back.setBounds(317, 461, 82, 23);
		panel.add(btn_back);
	}
}
