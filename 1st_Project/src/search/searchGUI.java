package search;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import javax.swing.JTextField;

import model.CustomerDTO;
import model.ProductDTO;
import view.MainGUI;

import javax.swing.ImageIcon;
import javax.swing.JTable;

public class searchGUI {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JTextField tf_text;
	private String model;
	private JTable table;
	public JRadioButton rb_desc;
	JRadioButton rb_asce;
	JScrollPane scrollPane;
	CustomerDTO loginDto;
	JCheckBox ch1;
	JCheckBox ch2;
	JCheckBox ch3;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					searchGUI window = new searchGUI();
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
	public searchGUI(CustomerDTO loginDto) {
		this.loginDto = loginDto;
		initialize();
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 710, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 89, 126, 424);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uAC00\uACA9");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel.setBounds(8, 7, 89, 15);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC5D0\uB108\uC9C0 \uD6A8\uC728 \uB4F1\uAE09");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 12));
		lblNewLabel_1.setBounds(8, 93, 106, 15);
		panel.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 89, 532, 356);
		frame.getContentPane().add(scrollPane);

		String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
		ProductDAO dao = new ProductDAO();
		TableModelChange change = new TableModelChange(dao.priceAsce());
		Object[][] data = change.listTypeChange();
		table = new JTable(data, colName);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				System.out.println(row);
				model = (String) table.getValueAt(row, 0);

			}
		});

		tf_text = new JTextField();
		tf_text.setBounds(111, 46, 465, 33);
		frame.getContentPane().add(tf_text);
		tf_text.setColumns(10);

		JButton btn_search = new JButton("\uAC80\uC0C9");
		btn_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				model = (String) table.getValueAt(row, 0);
			}
		});
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductDAO dao = new ProductDAO();
				ArrayList<ProductDTO> tf = dao.search(tf_text.getText());
				TableModelChange change = new TableModelChange(tf);
				Object[][] data = change.listTypeChange();
				table = new JTable(data, colName);
				scrollPane.setViewportView(table);

			}
		});

		ch1 = new JCheckBox("1\uB4F1\uAE09");
		ch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rb_asce.isSelected()) {
					if (ch1.isSelected()) {
						if(ch2.isSelected()) {
							if(ch3.isSelected()==false) {
								// 체크박스 1등급,2등급 체크
								String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
								ProductDAO dao = new ProductDAO();
								TableModelChange change = new TableModelChange(dao.noteclss("3등급", ""));
								Object[][] data = change.listTypeChange();
								
								table = new JTable(data, colName);
								scrollPane.setViewportView(table);
								table.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										int row = table.getSelectedRow();
										model = (String) table.getValueAt(row, 0);
										
									}
								});
							}
							
						}else if (ch3.isSelected()) {
							String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
							ProductDAO dao = new ProductDAO();
							TableModelChange change = new TableModelChange(dao.noteclss("3등급", ""));
							Object[][] data = change.listTypeChange();
							
							table = new JTable(data, colName);
							scrollPane.setViewportView(table);
							table.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									int row = table.getSelectedRow();
									model = (String) table.getValueAt(row, 0);
									
								}
							});
						}

					}else if (ch2.isSelected()==false) {
						if(ch3.isSelected()) {
							
							String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
							ProductDAO dao = new ProductDAO();
							TableModelChange change = new TableModelChange(dao.noteclss("2등급", ""));
							Object[][] data = change.listTypeChange();
							
							table = new JTable(data, colName);
							scrollPane.setViewportView(table);
							table.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									int row = table.getSelectedRow();
									model = (String) table.getValueAt(row, 0);
									
								}
							});
						}
						
					}
					if (ch1.isSelected() == false) {
						String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
						ProductDAO dao = new ProductDAO();
						TableModelChange change = new TableModelChange(dao.priceAsce());
						Object[][] data = change.listTypeChange();

						table = new JTable(data, colName);
						scrollPane.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = table.getSelectedRow();
								model = (String) table.getValueAt(row, 0);

							}
						});
					}

				} else {
					if (ch1.isSelected()) {

						String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
						ProductDAO dao = new ProductDAO();
						TableModelChange change = new TableModelChange(dao.eclss("1등급", "desc"));
						Object[][] data = change.listTypeChange();

						table = new JTable(data, colName);
						scrollPane.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = table.getSelectedRow();
								model = (String) table.getValueAt(row, 0);

							}
						});
					}
					if (ch1.isSelected() == false) {
						String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
						ProductDAO dao = new ProductDAO();
						TableModelChange change = new TableModelChange(dao.priceDesc());
						Object[][] data = change.listTypeChange();

						table = new JTable(data, colName);
						scrollPane.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = table.getSelectedRow();
								model = (String) table.getValueAt(row, 0);

							}
						});
					}
				}

			}
		});
		ch1.setBounds(8, 114, 106, 23);
		panel.add(ch1);

		ch2 = new JCheckBox("2\uB4F1\uAE09");
		ch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rb_asce.isSelected()) {
					if (ch2.isSelected()) {
						
						String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
						ProductDAO dao = new ProductDAO();
						TableModelChange change = new TableModelChange(dao.eclss("2등급", ""));
						Object[][] data = change.listTypeChange();

						table = new JTable(data, colName);
						scrollPane.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = table.getSelectedRow();
								model = (String) table.getValueAt(row, 0);

							}
						});
					}
					if (ch2.isSelected() == false) {
						String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
						ProductDAO dao = new ProductDAO();
						TableModelChange change = new TableModelChange(dao.priceAsce());
						Object[][] data = change.listTypeChange();

						table = new JTable(data, colName);
						scrollPane.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = table.getSelectedRow();
								model = (String) table.getValueAt(row, 0);

							}
						});
					}

				} else {
					if (ch2.isSelected()) {

						String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
						ProductDAO dao = new ProductDAO();
						TableModelChange change = new TableModelChange(dao.eclss("2등급", "desc"));
						Object[][] data = change.listTypeChange();

						table = new JTable(data, colName);
						scrollPane.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = table.getSelectedRow();
								model = (String) table.getValueAt(row, 0);

							}
						});
					}
					if (ch2.isSelected() == false) {
						String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
						ProductDAO dao = new ProductDAO();
						TableModelChange change = new TableModelChange(dao.priceDesc());
						Object[][] data = change.listTypeChange();

						table = new JTable(data, colName);
						scrollPane.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = table.getSelectedRow();
								model = (String) table.getValueAt(row, 0);

							}
						});
					}
				}

			}
		});
		ch2.setBounds(8, 139, 106, 23);
		panel.add(ch2);

		ch3 = new JCheckBox("3\uB4F1\uAE09");
		ch3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rb_asce.isSelected()) {
					if (ch3.isSelected()) {

						String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
						ProductDAO dao = new ProductDAO();
						TableModelChange change = new TableModelChange(dao.eclss("3등급", ""));
						Object[][] data = change.listTypeChange();

						table = new JTable(data, colName);
						scrollPane.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = table.getSelectedRow();
								model = (String) table.getValueAt(row, 0);

							}
						});
					}
					if (ch3.isSelected() == false) {
						String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
						ProductDAO dao = new ProductDAO();
						TableModelChange change = new TableModelChange(dao.priceAsce());
						Object[][] data = change.listTypeChange();

						table = new JTable(data, colName);
						scrollPane.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = table.getSelectedRow();
								model = (String) table.getValueAt(row, 0);

							}
						});
					}

				} else {
					if (ch3.isSelected()) {

						String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
						ProductDAO dao = new ProductDAO();
						TableModelChange change = new TableModelChange(dao.eclss("3등급", "desc"));
						Object[][] data = change.listTypeChange();

						table = new JTable(data, colName);
						scrollPane.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = table.getSelectedRow();
								model = (String) table.getValueAt(row, 0);

							}
						});
					}
					if (ch3.isSelected() == false) {
						String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
						ProductDAO dao = new ProductDAO();
						TableModelChange change = new TableModelChange(dao.priceDesc());
						Object[][] data = change.listTypeChange();

						table = new JTable(data, colName);
						scrollPane.setViewportView(table);
						table.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = table.getSelectedRow();
								model = (String) table.getValueAt(row, 0);

							}
						});
					}
				}

		
			}
		});
		ch3.setBounds(8, 164, 106, 23);
		panel.add(ch3);

		// 오름차순
		rb_desc = new JRadioButton("\uAC00\uACA9 \uB192\uC740\uC21C");
		rb_desc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
				ProductDAO dao = new ProductDAO();
				TableModelChange change = new TableModelChange(dao.priceDesc());
				Object[][] data = change.listTypeChange();

				table = new JTable(data, colName);
				scrollPane.setViewportView(table);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = table.getSelectedRow();
						model = (String) table.getValueAt(row, 0);

					}
				});

			}

		});
		buttonGroup.add(rb_desc);
		rb_desc.setBounds(8, 28, 106, 23);
		panel.add(rb_desc);

		// 내림차순
		rb_asce = new JRadioButton("\uAC00\uACA9 \uB0AE\uC740\uC21C");
		rb_asce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
				ProductDAO dao = new ProductDAO();
				TableModelChange change = new TableModelChange(dao.priceAsce());
				Object[][] data = change.listTypeChange();

				table = new JTable(data, colName);
				scrollPane.setViewportView(table);
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = table.getSelectedRow();
						model = (String) table.getValueAt(row, 0);

					}
				});
			}
		});

		JButton detailview = new JButton("\uC81C\uD488 \uC0C1\uC138 \uC815\uBCF4 \uBCF4\uAE30");
		detailview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				detailsGUI det = new detailsGUI(model, loginDto);
			}
		});

		detailview.setBounds(150, 455, 186, 58);
		frame.getContentPane().add(detailview);
		rb_asce.setSelected(true);
		buttonGroup.add(rb_asce);
		rb_asce.setBounds(8, 53, 106, 23);
		panel.add(rb_asce);

		btn_search.setIcon(new ImageIcon("C:\\Users\\SMT042\\Desktop\\\uAC80.jpg"));
		btn_search.setBounds(585, 46, 97, 33);
		frame.getContentPane().add(btn_search);

		JLabel lblNewLabel_2 = new JLabel("\uBAA8\uB378\uBA85 \uC785\uB825 :");
		lblNewLabel_2.setBounds(12, 46, 87, 33);
		frame.getContentPane().add(lblNewLabel_2);

		JButton btn_back = new JButton("\uB4A4\uB85C \uAC00\uAE30");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainGUI main = new MainGUI();
			}
		});
		btn_back.setBounds(525, 480, 157, 33);
		frame.getContentPane().add(btn_back);

	}
}
