package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.CustomerDTO;
import model.MyAppliancesDTO;
import model.ProductDTO;
import model.PurchaseDAO;
import model.PurchaseDTO;
import model.PurchaseDetailDTO;
import search.ProductDAO;
import search.detailsGUI;

import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class PurchaseGUI {

	private JFrame frame;
	private JTextField tf_cardnum4;
	private JTextField tf_cardnum3;
	private JTextField tf_cardnum2;
	private JTextField tf_cardnum1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField tf_cell;
	private JTextField tf_Postalcode;
	private JTextField tf_name;
	private JTextField tf_address;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	PurchaseDAO dao = new PurchaseDAO();
	private String model;
	CustomerDTO logindto;
	private JTextField tf_amount;
	
	ArrayList<MyAppliancesDTO> myDtos;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PurchaseGUI window = new PurchaseGUI();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public PurchaseGUI(String model,CustomerDTO dto, ArrayList<MyAppliancesDTO> myDtos) {
		this.model = model;
		logindto = dto;
		this.myDtos = myDtos;
		initialize();
		frame.setVisible(true);

	}

	public ArrayList<ProductDTO> model() {
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductDTO> dto = dao.search(model);

		return dto;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 204));
		frame.setBounds(100, 100, 674, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label_p_image = new JLabel("");
		label_p_image.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/images/"+model().get(0).getP_img())));
		label_p_image.setForeground(Color.BLACK);
		label_p_image.setBackground(Color.BLACK);
		label_p_image.setBounds(12, 10, 387, 241);
		frame.getContentPane().add(label_p_image);

		JLabel lblNewLabel = new JLabel("\uC81C\uD488\uBA85");
		lblNewLabel.setBounds(451, 55, 63, 22);
		frame.getContentPane().add(lblNewLabel);

		JLabel label = new JLabel("\uC8FC\uBB38\uC77C\uC790");
		label.setBounds(451, 87, 63, 22);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\uC8FC\uBB38\uC218\uB7C9");
		label_1.setBounds(451, 119, 63, 22);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\uACB0\uC81C \uAE08\uC561");
		label_2.setBounds(451, 155, 63, 22);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\uACB0\uC81C \uBC29\uBC95");
		label_3.setFont(new Font("굴림", Font.PLAIN, 18));
		label_3.setBounds(12, 437, 80, 22);
		frame.getContentPane().add(label_3);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(72, 469, 574, 201);
		frame.getContentPane().add(tabbedPane);

		JPanel card = new JPanel();
		card.setBackground(new Color(255, 255, 204));
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
		comboBox_CARD.setModel(new DefaultComboBoxModel(new String[] { "\uD604\uB300\uCE74\uB4DC",
				"\uC2E0\uD55C\uCE74\uB4DC", "NH\uCC44\uC6C0\uCE74\uB4DC", "BC\uCE74\uB4DC", "\uC6B0\uB9AC\uCE74\uB4DC",
				"\uCE74\uCE74\uC624\uBC45\uD06C", "KB\uAD6D\uBBFC\uCE74\uB4DC", "\uC0BC\uC131\uCE74\uB4DC" }));
		comboBox_CARD.setBounds(80, 37, 91, 21);
		card.add(comboBox_CARD);

		JLabel label_10 = new JLabel("\uD560\uBD80 \uAC1C\uC6D4");
		label_10.setBounds(11, 75, 57, 15);
		card.add(label_10);

		JComboBox comboBox_month = new JComboBox();
		comboBox_month.setModel(new DefaultComboBoxModel(new String[] { "\uC77C\uC2DC\uBD88" }));
		comboBox_month.setBounds(80, 72, 91, 21);
		card.add(comboBox_month);

		tf_name = new JTextField();
		tf_name.setBounds(143, 312, 116, 21);
		frame.getContentPane().add(tf_name);
		tf_name.setColumns(10);

		tf_address = new JTextField();
		tf_address.setBounds(143, 406, 383, 21);
		frame.getContentPane().add(tf_address);
		tf_address.setColumns(10);

		tf_cell = new JTextField();
		tf_cell.setBounds(143, 343, 215, 21);
		frame.getContentPane().add(tf_cell);
		tf_cell.setColumns(10);

		JLabel lb_name = new JLabel(model().get(0).getP_name());
		lb_name.setBounds(525, 55, 121, 22);
		frame.getContentPane().add(lb_name);
		
		DecimalFormat formatter = new DecimalFormat("###,###");
		String price = formatter.format(model().get(0).getP_price());
		int price1 = model().get(0).getP_price();
		
		JLabel lb_price = new JLabel(price);
		lb_price.setBounds(526, 155, 120, 22);
		frame.getContentPane().add(lb_price);
		
		
		tf_amount = new JTextField();
		tf_amount.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				lb_price.setText(formatter.format(Integer.parseInt(tf_amount.getText())*price1));
			}
		});
		
		
		
		tf_amount.setText("1");
		tf_amount.setBounds(526, 120, 63, 21);
		frame.getContentPane().add(tf_amount);
		tf_amount.setColumns(10);
		int amount = Integer.parseInt(tf_amount.getText());
		

		

		JButton btn_complete = new JButton("\uACB0\uC81C \uC644\uB8CC");
		btn_complete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "결제하시겠습니까?", "confirm", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "결제가 완료 되었습니다.");
					frame.dispose();
					String recip = tf_name.getText();
					String cellnum = tf_cell.getText();
					String address = tf_address.getText();
				     dao.purchaseDetailInsert(
						new PurchaseDetailDTO(dao.numsearch().get(0).getOrderno(), model().get(0).getP_name(), amount, price, address, recip, cellnum));
				     MainGUI main = new MainGUI();
				     main.loginInfo(logindto);
				}
				;
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
		
		JButton cancelbutton = new JButton("\uCDE8\uC18C");
		cancelbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				detailsGUI det = new detailsGUI(model, logindto, myDtos);
			}
		});
		cancelbutton.setBounds(351, 139, 97, 23);
		card.add(cancelbutton);

		JPanel naverpay = new JPanel();
		naverpay.setBackground(new Color(102, 255, 0));
		tabbedPane.addTab("네이버페이", null, naverpay, null);
		naverpay.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("\uB124\uC774\uBC84 ID");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(12, 29, 87, 36);
		naverpay.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(111, 31, 167, 34);
		naverpay.add(textField);
		textField.setColumns(10);

		JLabel label_11 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label_11.setFont(new Font("굴림", Font.PLAIN, 18));
		label_11.setBounds(12, 98, 87, 36);
		naverpay.add(label_11);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(111, 98, 167, 34);
		naverpay.add(textField_1);

		JPanel kakaopay = new JPanel();
		tabbedPane.addTab("카카오페이", null, kakaopay, null);

		JLabel label_4 = new JLabel("\uBC30\uC1A1\uC9C0");
		label_4.setFont(new Font("굴림", Font.PLAIN, 18));
		label_4.setBounds(12, 279, 63, 22);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("\uC774\uB984");
		label_5.setBounds(80, 311, 34, 22);
		frame.getContentPane().add(label_5);

		JLabel label_6 = new JLabel("\uC5F0\uB77D\uCC98");
		label_6.setBounds(78, 342, 53, 22);
		frame.getContentPane().add(label_6);

		JLabel label_7 = new JLabel("\uC8FC\uC18C");
		label_7.setBounds(80, 374, 34, 22);
		frame.getContentPane().add(label_7);

		JLabel label_9 = new JLabel("\uAD6C\uB9E4\uC815\uBCF4");
		label_9.setFont(new Font("굴림", Font.PLAIN, 19));
		label_9.setBounds(434, 23, 80, 22);
		frame.getContentPane().add(label_9);

		JLabel lblNewLabel_2 = new JLabel("\uC6B0\uD3B8\uBC88\uD638");
		lblNewLabel_2.setBounds(143, 378, 63, 15);
		frame.getContentPane().add(lblNewLabel_2);

		tf_Postalcode = new JTextField();
		tf_Postalcode.setBounds(205, 375, 116, 21);
		frame.getContentPane().add(tf_Postalcode);
		tf_Postalcode.setColumns(10);

		JLabel label_12 = new JLabel("");
		label_12.setBounds(333, 79, 143, 22);
		frame.getContentPane().add(label_12);
		
		JLabel lbl_date = new JLabel(dao.numsearch().get(0).getDate());
		lbl_date.setBounds(526, 87, 120, 22);
		frame.getContentPane().add(lbl_date);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(PurchaseGUI.class.getResource("/images/purchase.jpg")));
		lblNewLabel_4.setBounds(0, 0, 658, 681);
		frame.getContentPane().add(lblNewLabel_4);
		
	}
}
