package part3_jinkyeong;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;

public class part3_applicationGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					part3_applicationGUI window = new part3_applicationGUI();
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
	public part3_applicationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 910, 562);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(tabbedPane, "name_445368215119300");
		
		JPanel screen1_policyInfo = new JPanel();
		screen1_policyInfo.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("\"\uC73C\uB738 \uD6A8\uC728 \uAC00\uC804\uC81C\uD488 \uAD6C\uB9E4\uBE44\uC6A9 \uD658\uAE09 \uC0AC\uC5C5\"\uC774\uB780?", null, screen1_policyInfo, null);
		screen1_policyInfo.setLayout(null);
		
		JPanel screen2_fileUpload = new JPanel();
		screen2_fileUpload.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("\uD658\uAE09 \uB300\uD589 \uC2E0\uCCAD\uC744 \uC704\uD55C \uC11C\uB958", null, screen2_fileUpload, null);
		screen2_fileUpload.setLayout(null);
		
		JPanel screen3_energySavingSecret = new JPanel();
		tabbedPane.addTab("\uC6B0\uB9AC\uC9D1 \uC5D0\uB108\uC9C0 \uC808\uC57D\uC740 \uC774\uB807\uAC8C \uD574\uC694!", null, screen3_energySavingSecret, null);
		screen3_energySavingSecret.setLayout(null);
		
	}
}
