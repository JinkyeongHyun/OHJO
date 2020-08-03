package search;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.CustomerDTO;
import model.MyAppliancesDAO;
import model.MyAppliancesDTO;
import model.ProductDTO;
import model.PurchaseDAO;
import model.PurchaseDTO;
import view.MainGUI;
import view.PurchaseGUI;

public class detailsGUI {

	private JFrame frame;
	private String model;
	CustomerDTO logindto;
	
	ArrayList<MyAppliancesDTO> myDtos;
	JButton btn_details_my1;
	JButton btn_details_my2;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					detailsGUI window = new detailsGUI();
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
//	public detailsGUI(String model, CustomerDTO logindto) {
//		this.logindto = logindto; 
//		this.model = model;
//		initialize();
//		frame.setVisible(true);
//	}
	
	public detailsGUI(String model, CustomerDTO logindto, ArrayList<MyAppliancesDTO> myDtos) {
		this.logindto = logindto; 
		this.model = model;
		this.myDtos = myDtos;
		initialize();
		frame.setVisible(true);
		for(int i=0; i<myDtos.size(); i++) {
			if(myDtos.get(i).getModel().equals(model)) {	//내 가전 리스트에 해당 모델명이 있으면
				btn_details_my1.setVisible(false);
				btn_details_my2.setVisible(true);
				break;
			}else {
				btn_details_my1.setVisible(true);
				btn_details_my2.setVisible(false);
			}
		}

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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setResizable(false);
		frame.setBounds(100, 100, 451, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("\uC81C\uD488 \uBAA8\uB378 \uC0C1\uC138\uC815\uBCF4");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(138, 10, 167, 37);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 57, 411, 494);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("\uBAA8\uB378\uBA85 : ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(12, 248, 59, 51);
		panel.add(lblNewLabel_2);

		JLabel label = new JLabel("\uC81C\uD488\uBA85  : ");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(203, 256, 59, 35);
		panel.add(label);

		JLabel label_1 = new JLabel("\uBD84\uB958  : ");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(12, 312, 59, 35);
		panel.add(label_1);

		JLabel label_2 = new JLabel("\uC5D0\uB108\uC9C0 \uD6A8\uC728 \uB4F1\uAE09  : ");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(194, 312, 123, 35);
		panel.add(label_2);

		JLabel label_4 = new JLabel("\uC5F0\uAC04 \uBE44\uC6A9 : ");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(225, 357, 92, 35);
		panel.add(label_4);

		JLabel label_5 = new JLabel("\uAE08\uC561  : ");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(194, 402, 123, 35);
		panel.add(label_5);

		JLabel lb_model = new JLabel(model().get(0).getP_model());
		lb_model.setBounds(83, 253, 108, 41);
		panel.add(lb_model);

		JLabel lb_name = new JLabel(model().get(0).getP_name());
		lb_name.setBounds(274, 253, 125, 41);
		panel.add(lb_name);

		JLabel lb_cate = new JLabel(model().get(0).getP_category());
		lb_cate.setBounds(83, 309, 82, 41);
		panel.add(lb_cate);

		JLabel lb_rank = new JLabel(model().get(0).getP_class());
		lb_rank.setBounds(342, 312, 57, 35);
		panel.add(lb_rank);

		JLabel lb_ev = new JLabel(model().get(0).getP_maxEv());
		lb_ev.setBounds(132, 357, 81, 35);
		panel.add(lb_ev);
		
		DecimalFormat formatter = new DecimalFormat("###,###");
		
		String eco = formatter.format(model().get(0).getP_eCost());
		JLabel lb_yearCost = new JLabel(eco);
		lb_yearCost.setBounds(329, 357, 79, 35);
		panel.add(lb_yearCost);

		String price = formatter.format(model().get(0).getP_price());
		JLabel lb_cost = new JLabel(price);
		lb_cost.setBounds(342, 402, 57, 35);
		panel.add(lb_cost);

		JLabel label_3 = new JLabel("\uC5F0\uAC04 \uC0AC\uC6A9 \uBE44\uC6A9 : ");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setBounds(12, 357, 108, 35);
		panel.add(label_3);

		SimpleDateFormat date = new SimpleDateFormat("yyyymmdd");
		Date nowdate = new Date();
		String tempDate = date.format(nowdate);
		
		JButton btn_buy = new JButton("\uAD6C\uB9E4\uD558\uAE30");
		btn_buy.setBackground(Color.WHITE);
		btn_buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(logindto.getC_id());
				frame.dispose();
				PurchaseDAO dao = new PurchaseDAO();
				dao.PurchaseInsert(new PurchaseDTO(0, logindto.getC_id(), tempDate));
				
				PurchaseGUI pur = new PurchaseGUI(model, logindto, myDtos);
             
			}
		});
		btn_buy.setBounds(12, 461, 108, 23);
		panel.add(btn_buy);

		JButton btn_back = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btn_back.setBackground(Color.WHITE);
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				searchGUI search = new searchGUI(logindto);
			}
		});
		btn_back.setBounds(301, 461, 98, 23);
		panel.add(btn_back);
		String im = model().get(0).getP_img();
		
		
		JLabel lb_image = new JLabel();
		lb_image.setIcon(new ImageIcon(detailsGUI.class.getResource("/images/" + im)));
		lb_image.setBackground(Color.WHITE);
		lb_image.setBounds(12, 10, 387, 241);
		panel.add(lb_image);
		
		
		//즐겨찾기버튼(빈) - 즐겨찾기되지 않은 상태
		btn_details_my1 = new JButton("\uC990\uACA8\uCC3E\uAE30");
		btn_details_my1.setBackground(Color.WHITE);
		btn_details_my1.setBounds(326, 17, 97, 23);
		frame.getContentPane().add(btn_details_my1);
		btn_details_my1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyAppliancesDAO dao = new MyAppliancesDAO();
				String id = logindto.getC_id();
				String model = model().get(0).getP_model();
				String nickname = model().get(0).getP_name();	//별명 대신 초기값으로 제품명을 넣어줌
				dao.myAppliancesInsert(id, model, nickname);
				btn_details_my1.setVisible(false);
				btn_details_my2.setVisible(true);
			}
		});
		
		//즐겨찾기버튼 - 즐겨찾기된 상태
		btn_details_my2 = new JButton("\uC990\uACA8\uCC3E\uAE30");
		btn_details_my2.setBackground(Color.GREEN);
		btn_details_my2.setBounds(326, 17, 97, 23);
		frame.getContentPane().add(btn_details_my2);
		btn_details_my2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MyAppliancesDAO dao = new MyAppliancesDAO();
				String id = logindto.getC_id();
				String model = model().get(0).getP_model();
				dao.myAppliancesDelete(id,model);
				btn_details_my1.setVisible(true);
				btn_details_my2.setVisible(false);
			}
		});
		
	}
}
