package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PurchaseGUI {

	private JFrame frame;
	private JTextField tf_cardnum4;
	private JTextField tf_cardnum3;
	private JTextField tf_cardnum2;
	private JTextField tf_cardnum1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseGUI window = new PurchaseGUI();
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
	public PurchaseGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 674, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_p_image = new JLabel("New label");
		label_p_image.setForeground(Color.BLACK);
		label_p_image.setBackground(Color.BLACK);
		label_p_image.setBounds(12, 15, 217, 188);
		frame.getContentPane().add(label_p_image);
		
		JLabel lblNewLabel = new JLabel("\uC81C\uD488\uBA85");
		lblNewLabel.setBounds(258, 47, 63, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("\uC8FC\uBB38\uC77C\uC790");
		label.setBounds(258, 79, 63, 22);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\uC8FC\uBB38\uC218\uB7C9");
		label_1.setBounds(258, 111, 63, 22);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\uACB0\uC81C \uAE08\uC561");
		label_2.setBounds(258, 143, 63, 22);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uACB0\uC81C \uBC29\uBC95");
		label_3.setFont(new Font("굴림", Font.PLAIN, 18));
		label_3.setBounds(12, 437, 80, 22);
		frame.getContentPane().add(label_3);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(72, 469, 574, 201);
		frame.getContentPane().add(tabbedPane);
		
		JPanel card = new JPanel();
		tabbedPane.addTab("카드결제 ", null, card, null);
		card.setLayout(null);
		
		tf_cardnum4 = new JTextField();
		tf_cardnum4.setColumns(10);
		tf_cardnum4.setBounds(426, 37, 63, 21);
		card.add(tf_cardnum4);
		
		JLabel lblNewLabel_1 = new JLabel("\uCE74\uB4DC\uC885\uB958");
		lblNewLabel_1.setBounds(11, 40, 57, 15);
		card.add(lblNewLabel_1);
		
		JComboBox comboBox_CARD = new JComboBox();
		comboBox_CARD.setModel(new DefaultComboBoxModel(new String[] {"\uD604\uB300\uCE74\uB4DC", "\uC2E0\uD55C\uCE74\uB4DC", "NH\uCC44\uC6C0\uCE74\uB4DC", "BC\uCE74\uB4DC", "\uC6B0\uB9AC\uCE74\uB4DC", "\uCE74\uCE74\uC624\uBC45\uD06C", "KB\uAD6D\uBBFC\uCE74\uB4DC", "\uC0BC\uC131\uCE74\uB4DC"}));
		comboBox_CARD.setBounds(80, 37, 91, 21);
		card.add(comboBox_CARD);
		
		JLabel label_10 = new JLabel("\uD560\uBD80 \uAC1C\uC6D4");
		label_10.setBounds(11, 75, 57, 15);
		card.add(label_10);
		
		JComboBox comboBox_month = new JComboBox();
		comboBox_month.setModel(new DefaultComboBoxModel(new String[] {"\uC77C\uC2DC\uBD88"}));
		comboBox_month.setBounds(80, 72, 91, 21);
		card.add(comboBox_month);
		
		JButton btn_complete = new JButton("\uACB0\uC81C \uC644\uB8CC");
		btn_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_complete.setBounds(460, 139, 97, 23);
		card.add(btn_complete);
		
		tf_cardnum3 = new JTextField();
		tf_cardnum3.setColumns(10);
		tf_cardnum3.setBounds(351, 37, 63, 21);
		card.add(tf_cardnum3);
		
		tf_cardnum2 = new JTextField();
		tf_cardnum2.setColumns(10);
		tf_cardnum2.setBounds(276, 37, 63, 21);
		card.add(tf_cardnum2);
		
		tf_cardnum1 = new JTextField();
		tf_cardnum1.setColumns(10);
		tf_cardnum1.setBounds(201, 37, 63, 21);
		card.add(tf_cardnum1);
		
		JPanel naverpay = new JPanel();
		tabbedPane.addTab("네이버페이", null, naverpay, null);
		
		JPanel kakaopay = new JPanel();
		tabbedPane.addTab("카카오페이", null, kakaopay, null);
		
		JLabel label_4 = new JLabel("\uBC30\uC1A1\uC9C0");
		label_4.setFont(new Font("굴림", Font.PLAIN, 18));
		label_4.setBounds(12, 213, 63, 22);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\uC774\uB984");
		label_5.setBounds(40, 245, 63, 22);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\uC5F0\uB77D\uCC98");
		label_6.setBounds(40, 277, 63, 22);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\uC8FC\uC18C");
		label_7.setBounds(40, 308, 63, 22);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\uBC30\uC1A1\uC2DC \uC694\uCCAD\uC0AC\uD56D");
		label_8.setBounds(40, 370, 103, 22);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("\uAD6C\uB9E4\uC815\uBCF4");
		label_9.setFont(new Font("굴림", Font.PLAIN, 19));
		label_9.setBounds(241, 15, 80, 22);
		frame.getContentPane().add(label_9);
		
		JComboBox cmb_request = new JComboBox();
		cmb_request.setModel(new DefaultComboBoxModel(new String[] {"\uBC30\uC1A1\uC2DC \uC694\uCCAD\uC0AC\uD56D \uC120\uD0DD", "\uBD80\uC7AC\uC2DC\uC5D0 \uACBD\uBE44\uC2E4\uC5D0 \uB9E1\uACA8\uC8FC\uC138\uC694.", "\uBB38\uC55E\uC5D0 \uB194\uB46C\uC8FC\uC138\uC694.", "\uBD80\uC7AC\uC2DC \uC5F0\uB77D\uCC98\uB85C \uC5F0\uB77D\uC8FC\uC138\uC694.", "\uD0DD\uBC30\uD568\uC5D0 \uB123\uC5B4 \uC8FC\uC138\uC694."}));
		cmb_request.setBounds(143, 371, 207, 21);
		frame.getContentPane().add(cmb_request);
		
		JTextPane tp_cell1 = new JTextPane();
		tp_cell1.setBounds(214, 277, 70, 22);
		frame.getContentPane().add(tp_cell1);
		
		JTextPane tp_name = new JTextPane();
		tp_name.setBounds(143, 246, 108, 21);
		frame.getContentPane().add(tp_name);
		
		JTextPane tp_address = new JTextPane();
		tp_address.setBounds(143, 339, 287, 21);
		frame.getContentPane().add(tp_address);
		
		JTextPane tp_postalcode = new JTextPane();
		tp_postalcode.setBounds(214, 309, 132, 21);
		frame.getContentPane().add(tp_postalcode);
		
		JLabel lblNewLabel_2 = new JLabel("\uC6B0\uD3B8\uBC88\uD638");
		lblNewLabel_2.setBounds(143, 312, 63, 15);
		frame.getContentPane().add(lblNewLabel_2);
		
		JComboBox cmb_cell = new JComboBox();
		cmb_cell.setModel(new DefaultComboBoxModel(new String[] {"010", "011", "016", "017", "018", "019"}));
		cmb_cell.setBounds(143, 278, 48, 21);
		frame.getContentPane().add(cmb_cell);
		
		JTextPane tp_cell2 = new JTextPane();
		tp_cell2.setBounds(306, 277, 70, 22);
		frame.getContentPane().add(tp_cell2);
	}
}
