package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.CustomerDTO;
import model.MyAppliancesDAO;
import model.MyAppliancesDTO;
import model.ProductDTO;
import search.ProductDAO;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyAppliancesGUI {

	private JFrame frame;
	private JTextField tf_my_search;
	private JTextField tf_my_nickname;
	CustomerDTO loginDto;
	private JTable table_my;
	JScrollPane scrollPane_my_1;
	JScrollPane scrollPane_my_2;
	DefaultListModel model;
	DefaultTableModel tModel;
	String selectedModel;
	String selectedCategory;
	int selectedListIndex;
	JList list_my_list;
	
	public MyAppliancesGUI(CustomerDTO dto) {
		loginDto = dto;
		initialize();
		frame.setVisible(true);
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane_my_1 = new JScrollPane();
		scrollPane_my_1.setBounds(12, 41, 213, 100);
		frame.getContentPane().add(scrollPane_my_1);
		
		scrollPane_my_2 = new JScrollPane();
		scrollPane_my_2.setBounds(237, 43, 185, 208);
		frame.getContentPane().add(scrollPane_my_2);
		
		tf_my_search = new JTextField();
		tf_my_search.setBounds(12, 10, 116, 21);
		frame.getContentPane().add(tf_my_search);
		tf_my_search.setColumns(10);
		
		//검색버튼
		JButton btn_my_search = new JButton("검색");
		btn_my_search.setBounds(128, 9, 97, 23);
		btn_my_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String model = tf_my_search.getText();
				ProductDAO dao = new ProductDAO();
				ArrayList<ProductDTO> dtos = dao.search(model);
				
				Object[][] data = new Object[dtos.size()][5];
				for(int i=0; i<data.length; i++) {
					data[i][0] = dtos.get(i).getP_category();
					data[i][1] = dtos.get(i).getP_img();
					data[i][2] = dtos.get(i).getP_model();
					data[i][3] = dtos.get(i).getP_name();
					data[i][4] = dtos.get(i).getP_class();
				}
				String[] colName = { "카테고리", "사진", "모델명", "품목명 ", "등급"};
				
				table_my = new JTable(data, colName);
				scrollPane_my_1.setViewportView(table_my);
				
				//테이블 클릭할 경우
				table_my.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						int row = table_my.getSelectedRow();
						selectedModel = (String)table_my.getValueAt(row, 2);
						selectedCategory = (String)table_my.getValueAt(row, 0);
					}
				});
			}
		});
		frame.getContentPane().add(btn_my_search);	
		
		JLabel lbl_my_nickname = new JLabel("별명 : ");
		lbl_my_nickname.setBounds(12, 151, 57, 15);
		frame.getContentPane().add(lbl_my_nickname);
		
		tf_my_nickname = new JTextField();
		tf_my_nickname.setBounds(12, 176, 116, 21);
		frame.getContentPane().add(tf_my_nickname);
		tf_my_nickname.setColumns(10);
		
		//리스트
		MyAppliancesDAO dao = new MyAppliancesDAO();
		ArrayList<MyAppliancesDTO> dtos = dao.myAppliancesSelectList(loginDto.getC_id());
		String[] items = new String[dtos.size()];
		for(int i=0; i<dtos.size(); i++) {
			String sum =  "";
			sum += dtos.get(i).getCategory() + "  ";
			sum += dtos.get(i).getNickname();
			items[i] = sum;
		}
		
		//DefaultListModel로 리스트 생성
		list_my_list = new JList(new DefaultListModel());
		model = (DefaultListModel)list_my_list.getModel();
		
		//리스트모델에 데이터 추가
		for(int i=0; i<items.length; i++) {
			model.addElement(items[i]);
		}
		
		list_my_list.setBounds(237, 41, 185, 210);
		scrollPane_my_2.setViewportView(list_my_list);
		
		//리스트 선택 모드
		list_my_list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		//리스트 이벤트처리
		list_my_list.addListSelectionListener(new ListSelectionListener() {	
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(!e.getValueIsAdjusting()) {	//이벤트를 두번 받지 않기 위해 if문 지정
					selectedListIndex = list_my_list.getSelectedIndex();
					String all = (String)list_my_list.getModel().getElementAt(selectedListIndex);
					String[] allArray = all.split("  ");
					String curNick = allArray[1];
					tf_my_nickname.setText(curNick);
				}
			}
		});
		
		
		//추가버튼
		JButton btn_my_add = new JButton("추가");
		btn_my_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//별명
				String nickname = tf_my_nickname.getText();
				MyAppliancesDAO dao = new MyAppliancesDAO();

				int result = dao.myAppliancesInsert(loginDto.getC_id(), selectedModel, nickname);
				if(result == 0) {	//추가 실패
				}else {	//추가 성공
					//리스트에 값 추가
					model.addElement(selectedCategory + "  " + nickname);
				}
			}
		});
		btn_my_add.setBounds(12, 207, 97, 23);
		frame.getContentPane().add(btn_my_add);
		
		//수정버튼
		JButton btn_my_update = new JButton("수정");
		btn_my_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				String all = (String)list_my_list.getModel().getElementAt(selectedListIndex);
				String[] allArray = all.split("  ");
				String category = allArray[0];
				String curNick = allArray[1];
				String newNick = tf_my_nickname.getText();

				MyAppliancesDAO dao = new MyAppliancesDAO();
				//별명 중복 안되게 설정해야할듯 근데 귀찮다...
				result = dao.myAppliancesUpdate(newNick,loginDto.getC_id(),curNick);	
				if(result == 0) {
					
				}else {
					model.setElementAt(category + "  " + newNick, selectedListIndex);
				}
			}
		});
		btn_my_update.setBounds(12, 228, 97, 23);
		frame.getContentPane().add(btn_my_update);
		
		//삭제버튼
		JButton btn_my_delete = new JButton("삭제");
		btn_my_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = 0;
				String all = (String)list_my_list.getModel().getElementAt(selectedListIndex);
				String[] allArray = all.split("  ");
				String category = allArray[0];
				String curNick = allArray[1];
				MyAppliancesDAO dao = new MyAppliancesDAO();
				result = dao.myAppliancesDelete(loginDto.getC_id(), curNick);
				if(result == 0) {
				}else {
					model.removeElementAt(selectedListIndex);
				}
			}
		});
		btn_my_delete.setBounds(128, 207, 97, 23);
		frame.getContentPane().add(btn_my_delete);
		
		JLabel lbl_my_list = new JLabel("내 가전 목록");
		lbl_my_list.setBounds(285, 13, 90, 15);
		frame.getContentPane().add(lbl_my_list);
		
		//취소버튼
		JButton btn_my_cancel = new JButton("\uCDE8\uC18C");
		btn_my_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI main = new MainGUI();
				main.loginInfo(loginDto);
			}
		});
		btn_my_cancel.setBounds(128, 228, 97, 23);
		frame.getContentPane().add(btn_my_cancel);

	}
	
	public void loginInfo(CustomerDTO dto) {
		loginDto = dto;
	}
}