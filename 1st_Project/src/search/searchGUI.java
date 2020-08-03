package search;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import javax.swing.JTextField;

import model.CustomerDTO;
import model.MyAppliancesDAO;
import model.MyAppliancesDTO;
import model.ProductDTO;
import search.LineChart;
import search.CustomTableCellRenderer;
import view.MainGUI;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class searchGUI {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JTextField tf_text;
	private String model;
	private JTable searchTable;
	public JRadioButton rb_desc;
	JRadioButton rb_asce;
	JScrollPane searchScrollPane;
	CustomerDTO loginDto;
	JCheckBox ch1;
	JCheckBox ch2;
	JCheckBox ch3;
	String[] colName = { "모델명", "제품명", "에너지 효율 등급 ", "가격" };
	ProductDAO dao = new ProductDAO();
	private final ButtonGroup checkBox = new ButtonGroup();
	private final ButtonGroup checkBoxR = new ButtonGroup();
	
	//비교
	private JTable table_search_compare;
	JPanel panel_search_chart;
	private JTextField tf_search_realPrice;
	
	JList list;
	DefaultListModel lModel;
	int selectedListIndex;

	DefaultTableModel tModel;
	
	LineChart chart;
	ChartPanel chartPanel;
	XYSeries series1,series2;
	String lastSeries;
	
	String selectedModel;
	
	ProductDTO myDto;
	ProductDTO selectedDto;
	ArrayList<MyAppliancesDTO> dtos;
	
	MyAppliancesDAO myDao;
	public searchGUI(CustomerDTO loginDto) {
		this.loginDto = loginDto;
		initialize();
		frame.setVisible(true);

	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1100, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(12, 89, 126, 424);
		frame.getContentPane().add(searchPanel);
		searchPanel.setLayout(null);

		JLabel lbl_search_price = new JLabel("\uAC00\uACA9");
		lbl_search_price.setFont(new Font("굴림", Font.BOLD, 12));
		lbl_search_price.setBounds(8, 7, 89, 15);
		searchPanel.add(lbl_search_price);

		JLabel lbl_search_class = new JLabel("\uC5D0\uB108\uC9C0 \uD6A8\uC728 \uB4F1\uAE09");
		lbl_search_class.setFont(new Font("굴림", Font.BOLD, 12));
		lbl_search_class.setBounds(8, 93, 106, 15);
		searchPanel.add(lbl_search_class);

		JScrollPane searchScrollPane = new JScrollPane();
		searchScrollPane.setBounds(150, 89, 343, 356);
		frame.getContentPane().add(searchScrollPane);
		
		ProductDAO dao = new ProductDAO();
		TableModelChange change = new TableModelChange(dao.priceAsce());
		Object[][] data = change.listTypeChange();
		searchTable = new JTable(data, colName);
		searchScrollPane.setViewportView(searchTable);
		
		searchTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = searchTable.getSelectedRow();
				model = (String) searchTable.getValueAt(row, 0);
				searchTmodelChartChange(model);	//바꾼부분
			}
		});

		tf_text = new JTextField();
		tf_text.setBounds(150, 46, 226, 33);
		frame.getContentPane().add(tf_text);
		tf_text.setColumns(10);

		JButton btn_search = new JButton("\uAC80\uC0C9");
		btn_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = searchTable.getSelectedRow();
				model = (String) searchTable.getValueAt(row, 0);
				searchTmodelChartChange(model);	//바꾼부분
				
			}
		});
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductDAO dao = new ProductDAO();
				ArrayList<ProductDTO> tf = dao.search(tf_text.getText());
				TableModelChange change = new TableModelChange(tf);
				Object[][] data = change.listTypeChange();
				searchTable = new JTable(data, colName);
				searchScrollPane.setViewportView(searchTable);
			}
		});

		ch1 = new JCheckBox("1\uB4F1\uAE09");
		checkBox.add(ch1);
		ch1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rb_asce.isSelected()) {
					if (ch1.isSelected()) {
						// 체크박스 1등급,2등급 체크
						TableModelChange change = new TableModelChange(dao.eclss("1등급", ""));
						Object[][] data = change.listTypeChange();

						searchTable = new JTable(data, colName);
						searchScrollPane.setViewportView(searchTable);
						searchTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = searchTable.getSelectedRow();
								model = (String) searchTable.getValueAt(row, 0);
								searchTmodelChartChange(model);	//바꾼부분
							}
						});

					}
					if (ch1.isSelected() == false) {
						TableModelChange change = new TableModelChange(dao.priceAsce());
						Object[][] data = change.listTypeChange();

						searchTable = new JTable(data, colName);
						searchScrollPane.setViewportView(searchTable);
						searchTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = searchTable.getSelectedRow();
								model = (String) searchTable.getValueAt(row, 0);
								searchTmodelChartChange(model);	//바꾼부분
							}
						});
					}

				} else {
					if (ch1.isSelected()) {
						TableModelChange change = new TableModelChange(dao.eclss("1등급", "desc"));
						Object[][] data = change.listTypeChange();

						searchTable = new JTable(data, colName);
						searchScrollPane.setViewportView(searchTable);
						searchTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = searchTable.getSelectedRow();
								model = (String) searchTable.getValueAt(row, 0);
								searchTmodelChartChange(model);	//바꾼부분
							}
						});
					}
					if (ch1.isSelected() == false) {
						TableModelChange change = new TableModelChange(dao.priceDesc());
						Object[][] data = change.listTypeChange();

						searchTable = new JTable(data, colName);
						searchScrollPane.setViewportView(searchTable);
						searchTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = searchTable.getSelectedRow();
								model = (String) searchTable.getValueAt(row, 0);
								searchTmodelChartChange(model);	//바꾼부분
							}
						});
					}
				}

			}
		});
		ch1.setBounds(8, 114, 106, 23);
		searchPanel.add(ch1);

		ch2 = new JCheckBox("2\uB4F1\uAE09");
		checkBox.add(ch2);
		ch2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rb_asce.isSelected()) {
					if (ch2.isSelected()) {
						TableModelChange change = new TableModelChange(dao.eclss("2등급", ""));
						Object[][] data = change.listTypeChange();

						searchTable = new JTable(data, colName);
						searchScrollPane.setViewportView(searchTable);
						searchTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = searchTable.getSelectedRow();
								model = (String) searchTable.getValueAt(row, 0);
								searchTmodelChartChange(model);	//바꾼부분
							}
						});
					}
					if (ch2.isSelected() == false) {
						TableModelChange change = new TableModelChange(dao.priceAsce());
						Object[][] data = change.listTypeChange();

						searchTable = new JTable(data, colName);
						searchScrollPane.setViewportView(searchTable);
						searchTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = searchTable.getSelectedRow();
								model = (String) searchTable.getValueAt(row, 0);
								searchTmodelChartChange(model);	//바꾼부분
							}
						});
					}

				} else {
					if (ch2.isSelected()) {
						TableModelChange change = new TableModelChange(dao.eclss("2등급", "desc"));
						Object[][] data = change.listTypeChange();

						searchTable = new JTable(data, colName);
						searchScrollPane.setViewportView(searchTable);
						searchTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = searchTable.getSelectedRow();
								model = (String) searchTable.getValueAt(row, 0);
								searchTmodelChartChange(model);	//바꾼부분
							}
						});
					}
					if (ch2.isSelected() == false) {
						TableModelChange change = new TableModelChange(dao.priceDesc());
						Object[][] data = change.listTypeChange();

						searchTable = new JTable(data, colName);
						searchScrollPane.setViewportView(searchTable);
						searchTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = searchTable.getSelectedRow();
								model = (String) searchTable.getValueAt(row, 0);
								searchTmodelChartChange(model);	//바꾼부분
							}
						});
					}
				}

			}
		});
		ch2.setBounds(8, 139, 106, 23);
		searchPanel.add(ch2);

		ch3 = new JCheckBox("3\uB4F1\uAE09");
		checkBox.add(ch3);
		ch3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rb_asce.isSelected()) {
					if (ch3.isSelected()) {
						TableModelChange change = new TableModelChange(dao.eclss("3등급", ""));
						Object[][] data = change.listTypeChange();

						searchTable = new JTable(data, colName);
						searchScrollPane.setViewportView(searchTable);
						searchTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = searchTable.getSelectedRow();
								model = (String) searchTable.getValueAt(row, 0);
								searchTmodelChartChange(model);	//바꾼부분
							}
						});
					}
					if (ch3.isSelected() == false) {
						TableModelChange change = new TableModelChange(dao.priceAsce());
						Object[][] data = change.listTypeChange();

						searchTable = new JTable(data, colName);
						searchScrollPane.setViewportView(searchTable);
						searchTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = searchTable.getSelectedRow();
								model = (String) searchTable.getValueAt(row, 0);
								searchTmodelChartChange(model);	//바꾼부분
							}
						});
					}

				} else {
					if (ch3.isSelected()) {
						TableModelChange change = new TableModelChange(dao.eclss("3등급", "desc"));
						Object[][] data = change.listTypeChange();

						searchTable = new JTable(data, colName);
						searchScrollPane.setViewportView(searchTable);
						searchTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = searchTable.getSelectedRow();
								model = (String) searchTable.getValueAt(row, 0);
								searchTmodelChartChange(model);	//바꾼부분
							}
						});
					}
					if (ch3.isSelected() == false) {
						TableModelChange change = new TableModelChange(dao.priceDesc());
						Object[][] data = change.listTypeChange();

						searchTable = new JTable(data, colName);
						searchScrollPane.setViewportView(searchTable);
						searchTable.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								int row = searchTable.getSelectedRow();
								model = (String) searchTable.getValueAt(row, 0);
								searchTmodelChartChange(model);	//바꾼부분
							}
						});
					}
				}

			}
		});
		ch3.setBounds(8, 164, 106, 23);
		searchPanel.add(ch3);
		
		// 오름차순
		rb_desc = new JRadioButton("\uAC00\uACA9 \uB192\uC740\uC21C");
		rb_desc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ch1.setSelected(false);
				ch2.setSelected(false);
				ch3.setSelected(false);	
				TableModelChange change = new TableModelChange(dao.priceDesc());
				Object[][] data = change.listTypeChange();

				searchTable = new JTable(data, colName);
				searchScrollPane.setViewportView(searchTable);
				searchTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = searchTable.getSelectedRow();
						model = (String) searchTable.getValueAt(row, 0);
						searchTmodelChartChange(model);	//바꾼부분
					}
				});

			}

		});
		buttonGroup.add(rb_desc);
		rb_desc.setBounds(8, 28, 106, 23);
		searchPanel.add(rb_desc);

		// 내림차순
		rb_asce = new JRadioButton("\uAC00\uACA9 \uB0AE\uC740\uC21C");
		rb_asce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ch1.setSelected(false);
				ch2.setSelected(false);
				ch3.setSelected(false);	
				TableModelChange change = new TableModelChange(dao.priceAsce());
				Object[][] data = change.listTypeChange();

				searchTable = new JTable(data, colName);
				searchScrollPane.setViewportView(searchTable);
				searchTable.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int row = searchTable.getSelectedRow();
						model = (String) searchTable.getValueAt(row, 0);
						searchTmodelChartChange(model);	//바꾼부분
					}
				});
			}
		});

		JButton detailview = new JButton("\uC81C\uD488 \uC0C1\uC138 \uC815\uBCF4 \uBCF4\uAE30");
		detailview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				detailsGUI det = new detailsGUI(model, loginDto,dtos);
			}
		});

		detailview.setBounds(150, 455, 186, 58);
		frame.getContentPane().add(detailview);
		rb_asce.setSelected(true);
		buttonGroup.add(rb_asce);
		rb_asce.setBounds(8, 53, 106, 23);
		searchPanel.add(rb_asce);

		btn_search.setIcon(new ImageIcon("C:\\Users\\SMT042\\Desktop\\\uAC80.jpg"));
		btn_search.setBounds(396, 46, 97, 33);
		frame.getContentPane().add(btn_search);

		JLabel lblNewLabel_2 = new JLabel("\uBAA8\uB378\uBA85 \uC785\uB825 :");
		lblNewLabel_2.setBounds(12, 46, 87, 33);
		frame.getContentPane().add(lblNewLabel_2);

		JButton btn_back = new JButton("\uB4A4\uB85C \uAC00\uAE30");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				MainGUI main = new MainGUI();
				main.loginInfo(loginDto);
			}
		});
		btn_back.setBounds(348, 455, 157, 58);
		frame.getContentPane().add(btn_back);
		
		
		
		//********************비교 추가부분********************
		panel_search_chart = new JPanel();
		panel_search_chart.setBounds(582, 213, 500, 300);
		frame.getContentPane().add(panel_search_chart);

		JScrollPane scrollPane_search_compare = new JScrollPane();
		scrollPane_search_compare.setBounds(614, 46, 402, 79);
		frame.getContentPane().add(scrollPane_search_compare);
		
		JScrollPane scrollPane_search_list = new JScrollPane();
		scrollPane_search_list.setBounds(582, 152, 126, 58);
		frame.getContentPane().add(scrollPane_search_list);
		
		JLabel lbl_search_my = new JLabel("\uB0B4\uAC00\uC804\uC81C\uD488");
		lbl_search_my.setBounds(535, 55, 76, 15);
		frame.getContentPane().add(lbl_search_my);
		
		JLabel lbl_search_select = new JLabel("\uC120\uD0DD\uD55C\uC81C\uD488");
		lbl_search_select.setBounds(535, 80, 76, 15);
		frame.getContentPane().add(lbl_search_select);
		
		JLabel lbl_search_list = new JLabel("\uB0B4\uAC00\uC804\uC81C\uD488");
		lbl_search_list.setBounds(514, 136, 76, 15);
		frame.getContentPane().add(lbl_search_list);
		
		JLabel lbl_search_realPrice = new JLabel("\uC2E4\uAD6C\uB9E4\uAE08\uC561");
		lbl_search_realPrice.setBounds(811, 135, 57, 15);
		frame.getContentPane().add(lbl_search_realPrice);
		
		tf_search_realPrice = new JTextField();
		tf_search_realPrice.setText("0");
		tf_search_realPrice.setColumns(10);
		tf_search_realPrice.setBounds(881, 135, 116, 21);
		frame.getContentPane().add(tf_search_realPrice);
		
		//리스트
		myDao = new MyAppliancesDAO();
		dtos = myDao.myAppliancesSelectList(loginDto.getC_id());
		String[] items = new String[dtos.size()];
		for(int i=0; i<dtos.size(); i++) {
			String sum =  "";
				sum += dtos.get(i).getCategory() + "  ";
				sum += dtos.get(i).getModel() + "  "; 
				sum += dtos.get(i).getNickname();
				items[i] = sum;
		}		

		//DefaultListModel로 리스트 생성
		list = new JList(new DefaultListModel());
		lModel = (DefaultListModel)list.getModel();		
		
		//리스트모델에 데이터 추가
		for(int i=0; i<items.length; i++) {
			lModel.addElement(items[i]);
		}
		
		//패널에 리스트 추가
		scrollPane_search_list.setViewportView(list);

		//리스트 선택 모드 설정
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

		//리스트 이벤트 처리
		list.addListSelectionListener(new ListSelectionListener() {	
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {	//이벤트를 두번 받지 않기 위해 if문 지정
					selectedListIndex = list.getSelectedIndex();	//선택된 리스트의 인덱스
						String all = (String)list.getModel().getElementAt(selectedListIndex);
						String[] allArray = all.split("  ");
						String category = allArray[0];
						String model = allArray[1];
						String nickname = allArray[2];
						myLmodelChartChange(nickname);
				}
			}
		});
		
		//테이블
		String[] colName = {"이미지", "제품명", "등급", "가격", "에너지비용"};
		
		Object[][] tdata = new Object[2][5];

		for(int i=0; i<2; i++) {
			for(int j=0; j<5; j++) {
				tdata[i][j]= 0;
			}
		}
		
		//DefaultTableModel로 테이블 생성
		tModel = new DefaultTableModel(tdata,colName);
		table_search_compare = new JTable(tModel);
		
		//셀 렌더링 설정
		TableCellRenderer renderer = new CustomTableCellRenderer();
		table_search_compare.setDefaultRenderer(Object.class, renderer);
		table_search_compare.setRowHeight(30);
		scrollPane_search_compare.setViewportView(table_search_compare);
		
		//차트
		//누적합 계산
		int myPrice = (Integer)tModel.getValueAt(0, 3);
		int myEcost = (Integer)tModel.getValueAt(0, 4);
		int[] sum1 = {myPrice,myPrice,myPrice,myPrice,myPrice,myPrice,myPrice,myPrice,myPrice,myPrice};
		for(int i=0; i<10; i++) {
			sum1[i] += myEcost*(i+1);
		}
		
		int sPrice = Integer.parseInt(tf_search_realPrice.getText());
		int sEcost = (Integer)tModel.getValueAt(1, 4);
		int[] sum2 = {sPrice,sPrice,sPrice,sPrice,sPrice,sPrice,sPrice,sPrice,sPrice,sPrice};
		for(int i=0; i<10; i++) {
			sum2[i] += sEcost*(i+1);
		}
		
		chart = new LineChart();
		series1 =  chart.createSeries(sum1, "내 가전");
		series2 =  chart.createSeries(sum2, "비교 가전");
		chartPanel = new LineChart().getchartPanel_lineChart(series1,series2);
		chartPanel.setPreferredSize(new java.awt.Dimension(500,250));
		
		panel_search_chart.add(chartPanel);
		
	}
	
	//검색 테이블 선택시 테이블 및 실구매가격 및 차트 변경 메서드
	public void searchTmodelChartChange(String model) {
		//선택된 행의 모델명으로 제품 정보 조회 
		ArrayList<ProductDTO> selectedDtos = dao.search(model);
		selectedDto = selectedDtos.get(0);
		
		//테이블모델의 1번째 행 삭제
		tModel.removeRow(1);
		
		//새로운 model 추가
		Object[] newData = new Object[5];
		newData[0] = selectedDto.getP_img();
		newData[1] = selectedDto.getP_name();
		newData[2] = selectedDto.getP_class();
		newData[3] = selectedDto.getP_price();
		newData[4] = selectedDto.getP_eCost();
		tModel.addRow(newData);
		
		//실구매가격 변경
		int selectedPrice = (Integer)table_search_compare.getValueAt(1, 3);
		tf_search_realPrice.setText(Integer.toString(selectedPrice*9/10));

		int sPrice = Integer.parseInt(tf_search_realPrice.getText());
		int sEcost = (Integer)tModel.getValueAt(1, 4);
		int[] sum = {sPrice,sPrice,sPrice,sPrice,sPrice,sPrice,sPrice,sPrice,sPrice,sPrice};
		for(int i=0; i<10; i++) {
			sum[i] += sEcost*(i+1);
		}
		
		//새로운 시리즈 생성
		XYSeries nseries =  chart.createSeries(sum, "비교 가전");
		//기존 series2 변경
		series2 = nseries;
		//차트생성
		ChartPanel nchartPanel = new LineChart().getchartPanel_lineChart(series1,nseries);
		nchartPanel.setPreferredSize(new java.awt.Dimension(500,250));

		panel_search_chart.removeAll();
		panel_search_chart.revalidate();
		panel_search_chart.add(nchartPanel);
	}
		
	//리스트 선택시 테이블 및 차트 변경 메서드
	public void myLmodelChartChange(String nickname) {
		
		myDto = myDao.myAppliancesSelect(loginDto.getC_id(), nickname);	
		Object[] myData = new Object[5];
		myData[0] = myDto.getP_img();
		myData[1] = myDto.getP_name();
		myData[2] = myDto.getP_class();
		myData[3] = myDto.getP_price();
		myData[4] = myDto.getP_eCost();
		
		//테이블 첫번째 행(내 가전) 삭제
		tModel.removeRow(0);
		//테이블 첫번째 행(내 가전) 삽입
		tModel.insertRow(0, myData);
		
		//실구매가격 변경
		int selectedPrice = (Integer)table_search_compare.getValueAt(1, 3);
		tf_search_realPrice.setText(Integer.toString(selectedPrice*9/10));
		
		//시리즈 생성
		int myPrice = (Integer)tModel.getValueAt(0, 3);
		int myEcost = Integer.parseInt(tModel.getValueAt(0, 4).toString());
		int[] sum = {myPrice,myPrice,myPrice,myPrice,myPrice,myPrice,myPrice,myPrice,myPrice,myPrice};
		for(int i=0; i<10; i++) {
			sum[i] += myEcost*(i+1);
		}
		
		//시리즈 생성
		XYSeries nseries =  chart.createSeries(sum, "내 가전");
		series1 = nseries;
		//차트 생성
		ChartPanel nchartPanel = new LineChart().getchartPanel_lineChart(nseries,series2);
		nchartPanel.setPreferredSize(new java.awt.Dimension(500,250));
		//이전 차트 삭제
		panel_search_chart.removeAll();
		panel_search_chart.revalidate();
		//차트 추가
		panel_search_chart.add(nchartPanel);
	}
}

//테이블 셀 렌더링 클래스
class CustomTableCellRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setForeground(row%2==0?Color.RED:Color.BLUE);
        return c;
    }
}

//선그래프 생성 클래스
class LineChart {
	private XYSeries series = null;
	private XYDataset dataset = null;
	private JFreeChart chart = null;
	private TextTitle subTitle = null;
	XYSeriesCollection dataset1;
	XYSeriesCollection dataset2;
	
	 public XYSeries createSeries(int[] sum, String s) {
		 XYSeries series = new XYSeries(s);
		  for(int i=0; i<10; i++) {
			  series.add(i+1,sum[i]);
		  }  
		 return series;
	 }
	 
	 public void addSeries(XYSeries series) {
	 }
	 public ChartPanel getchartPanel_lineChart(XYSeries series1, XYSeries series2){
	  ChartPanel chartPanel_lineChart = null;
	  dataset1 = new XYSeriesCollection();
	  dataset2 = new XYSeriesCollection();
	  dataset1.addSeries(series1);
	  dataset2.addSeries(series2);
	  chart = ChartFactory.createXYLineChart("내제품/선택제품", "년",  "제품가격 + 누적연간에너지비용(원)", dataset, org.jfree.chart.plot.PlotOrientation.VERTICAL, true, true, false);
	  subTitle = new TextTitle("비교하기");

	  Font f = new Font("Gulim", Font.BOLD, 14);
	  chart.getTitle().setFont(f);
	  chart.getLegend().setItemFont(f);
	  chart.addSubtitle(subTitle);
	  chart.setBackgroundPaint(Color.WHITE);
	  

	  XYPlot plot = chart.getXYPlot();
	  plot.setDataset(0,dataset1);
	  plot.setDataset(1,dataset2);
	  
	  plot.setRenderer(0, new XYSplineRenderer()); //첫번째
	  XYSplineRenderer splineRenderer = new XYSplineRenderer();
	  splineRenderer.setSeriesFillPaint(0, Color.BLUE);
	  plot.setRenderer(1, splineRenderer);
	  plot.getDomainAxis().setLabelFont(f);
	  plot.getDomainAxis().setTickLabelFont(f);
	  plot.getRangeAxis().setLabelFont(f);
	  plot.getRangeAxis().setTickLabelFont(f);
	  chartPanel_lineChart = new ChartPanel(chart);
	  return chartPanel_lineChart;
	 } 
	}