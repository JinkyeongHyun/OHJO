package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

public class EnergySavingInfoGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnergySavingInfoGUI window = new EnergySavingInfoGUI();
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
	public EnergySavingInfoGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 910, 632);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSelectedIndex(-1);
		tabbedPane.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(tabbedPane, "name_445368215119300");
		
		JPanel screen3_energySavingSecret = new JPanel();
		screen3_energySavingSecret.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("\uC6B0\uB9AC\uC9D1 \uC5D0\uB108\uC9C0 \uC808\uC57D\uC740 \uC774\uB807\uAC8C \uD574\uC694!", null, screen3_energySavingSecret, null);
		screen3_energySavingSecret.setLayout(null);
		
		JLabel lbl_chooseProductsType = new JLabel("\uAC00\uC804 \uC885\uB958\uB97C \uC120\uD0DD\uD574 \uC8FC\uC138\uC694!");
		lbl_chooseProductsType.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.BOLD, 20));
		lbl_chooseProductsType.setBounds(27, 67, 280, 47);
		screen3_energySavingSecret.add(lbl_chooseProductsType);
		
		JComboBox cb_sortOfProducts = new JComboBox();
		cb_sortOfProducts.setBackground(new Color(255, 255, 255));
		cb_sortOfProducts.setModel(new DefaultComboBoxModel(new String[] {"\uB0C9\uC7A5\uACE0", "\uAE40\uCE58\uB0C9\uC7A5\uACE0", "\uC5D0\uC5B4\uCEE8 (\uBCBD\uAC78\uC774)", "\uC5D0\uC5B4\uCEE8 (\uADF8 \uC678)", "\uC138\uD0C1\uAE30 (\uC77C\uBC18)", "\uC138\uD0C1\uAE30 (\uB4DC\uB7FC)", "\uB0C9\uC628\uC218\uAE30 (\uC800\uC7A5\uC2DD)", "\uB0C9\uC628\uC218\uAE30 (\uC9C1\uC218\uC2DD)", "\uC804\uAE30\uBC25\uC1A5", "\uC9C4\uACF5 \uCCAD\uC18C\uAE30", "\uACF5\uAE30\uCCAD\uC815\uAE30", "TV", "\uC81C\uC2B5\uAE30", "\uC758\uB958\uAC74\uC870\uAE30"}));
		cb_sortOfProducts.setFont(new Font("∏º¿∫ ∞ÌµÒ", Font.PLAIN, 14));
		cb_sortOfProducts.setBounds(27, 124, 183, 32);
		screen3_energySavingSecret.add(cb_sortOfProducts);
		
		JTextPane textPane = new JTextPane();
		textPane.setForeground(new Color(0, 128, 128));
		textPane.setBackground(new Color(255, 255, 255));
		textPane.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 30));
		textPane.setText("\uC0DD\uD65C \uC18D \uC5D0\uCF54 \uC2E4\uCC9C");
		textPane.setBounds(368, 21, 280, 57);
		screen3_energySavingSecret.add(textPane);

	}

}
