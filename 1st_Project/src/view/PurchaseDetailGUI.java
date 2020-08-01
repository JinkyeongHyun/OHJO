package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import model.PurchaseDAO;
import model.PurchaseDetailDTO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PurchaseDetailGUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					PurchasedetailsGUI window = new PurchasedetailsGUI();
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
	public PurchaseDetailGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 875, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uAD6C\uB9E4\uB0B4\uC5ED");
		lblNewLabel.setFont(new Font("µ¸¿ò", Font.BOLD, 20));
		lblNewLabel.setBounds(22, 10, 91, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 76, 741, 400);
		frame.getContentPane().add(scrollPane);
		
		String[] colName = {"orderno","model","amount","totalprice","address","receiver","receivercell"};
		 PurchaseDAO dao = new PurchaseDAO();
		ArrayList<PurchaseDetailDTO> purchaseList=dao.search();
		Object[][] data = new Object[purchaseList.size()][7];
		for(int i = 0;i<data.length; i++) {
			data[i][0] = purchaseList.get(i).getOrderno();
			data[i][1] = purchaseList.get(i).getModel();
			data[i][2] = purchaseList.get(i).getAmount();
			data[i][3] = purchaseList.get(i).getTotalprice();
			data[i][4] = purchaseList.get(i).getAddress();
			data[i][5] = purchaseList.get(i).getReceiver();
		    data[i][6] = purchaseList.get(i).getReceivercell();
		   	
		}
		
		table = new JTable(data,colName);
		scrollPane.setViewportView(table);
		
		JButton btn_backmain = new JButton("\uBA54\uC778\uBA54\uB274");
		btn_backmain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI main = new MainGUI();
			}
		});
		btn_backmain.setBounds(719, 497, 97, 23);
		frame.getContentPane().add(btn_backmain);
	}
}
