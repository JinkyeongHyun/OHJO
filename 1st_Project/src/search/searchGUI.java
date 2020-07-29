package search;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

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
import javax.swing.Action;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;

import model.ProductDTO;

import javax.swing.JToggleButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class searchGUI {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action = new SwingAction();
	private JTextField tf_text;

	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchGUI window = new searchGUI();
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
	public searchGUI() {
		initialize();
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

		// ��������
		JRadioButton rb_desc = new JRadioButton("\uAC00\uACA9 \uB192\uC740\uC21C");
		buttonGroup.add(rb_desc);
		rb_desc.setBounds(8, 28, 106, 23);
		panel.add(rb_desc);

		// ��������
		JRadioButton rb_asce = new JRadioButton("\uAC00\uACA9 \uB0AE\uC740\uC21C");
		rb_asce.setSelected(true);
		buttonGroup.add(rb_asce);
		rb_asce.setBounds(8, 53, 106, 23);
		panel.add(rb_asce);

		JLabel lblNewLabel = new JLabel("\uAC00\uACA9");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 12));
		lblNewLabel.setBounds(8, 7, 89, 15);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\uC5D0\uB108\uC9C0 \uD6A8\uC728 \uB4F1\uAE09");
		lblNewLabel_1.setFont(new Font("����", Font.BOLD, 12));
		lblNewLabel_1.setBounds(8, 93, 106, 15);
		panel.add(lblNewLabel_1);

		JCheckBox chckbxNewCheckBox = new JCheckBox("1\uB4F1\uAE09");
		chckbxNewCheckBox.setBounds(8, 114, 106, 23);
		panel.add(chckbxNewCheckBox);

		JCheckBox checkBox = new JCheckBox("2\uB4F1\uAE09");
		checkBox.setBounds(8, 139, 106, 23);
		panel.add(checkBox);

		JCheckBox checkBox_1 = new JCheckBox("3\uB4F1\uAE09");
		checkBox_1.setBounds(8, 164, 106, 23);
		panel.add(checkBox_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(150, 89, 532, 356);
		frame.getContentPane().add(scrollPane);

		String[] colName = { "�𵨸�", "��ǰ��", "������ ȿ�� ��� ", "����" };
		ProductDAO dao = new ProductDAO();
		TableModelChange change = new TableModelChange(dao.priceAsce());
		Object[][] data = change.listTypeChange();

		table = new JTable(data, colName);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();	
				
				String model = (String) table.getValueAt(row,0);
				
				detailsGUI det = new detailsGUI(model);
	
			}
		});
		scrollPane.setViewportView(table);

		tf_text = new JTextField();
		tf_text.setBounds(111, 46, 465, 33);
		frame.getContentPane().add(tf_text);
		tf_text.setColumns(10);

		JButton btn_search = new JButton("\uAC80\uC0C9");
		btn_search.setIcon(new ImageIcon("C:\\Users\\SMT042\\Desktop\\\uAC80.jpg"));
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rb_desc.isSelected()) {
					String[] colName = { "�𵨸�", "��ǰ��", "������ ȿ�� ��� ", "����" };
					ProductDAO dao = new ProductDAO();
					TableModelChange change = new TableModelChange(dao.priceDesc());
					Object[][] data = change.listTypeChange();
					table = new JTable(data, colName);
					scrollPane.setViewportView(table);
				}
				if (rb_asce.isSelected()) {
					String[] colName = { "�𵨸�", "��ǰ��", "������ ȿ�� ��� ", "����" };
					ProductDAO dao = new ProductDAO();
					TableModelChange change = new TableModelChange(dao.priceAsce());
					Object[][] data = change.listTypeChange();

					table = new JTable(data, colName);
					scrollPane.setViewportView(table);
				}

			}
		});
		btn_search.setBounds(585, 46, 97, 33);
		frame.getContentPane().add(btn_search);

		JLabel lblNewLabel_2 = new JLabel("\uBAA8\uB378\uBA85 \uC785\uB825 :");
		lblNewLabel_2.setBounds(12, 46, 87, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\uC81C\uD488 \uC0C1\uC138 \uC815\uBCF4 \uBCF4\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBounds(496, 455, 186, 58);
		frame.getContentPane().add(btnNewButton);
	}

	private Object[][] listTypeChange() {
		// TODO Auto-generated method stub
		return null;
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
