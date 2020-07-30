package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import model.CustomerDTO;

public class FileDownloadGUI {

	private JFrame frame;
	
	CustomerDTO loginDto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FileDownloadGUI window = new FileDownloadGUI();
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
	public FileDownloadGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 995, 674);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\uC704\uC784\uC7A5 \uC11C\uC2DD \uB2E4\uC6B4\uB85C\uB4DC \uD558\uAE30 >>");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		label.setBounds(50, 112, 313, 45);
		frame.getContentPane().add(label);
		
		// 위임장 미리보기 제시
		JLabel lbl_docPreview = new JLabel("");
		lbl_docPreview.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_docPreview.setIcon(new ImageIcon("E:\\Bigdata\\팀 프로젝트\\[자료] GUI에 쓰인 사진들\\\\Doc.jpg"));
		lbl_docPreview.setBounds(472, 10, 495, 615);
		frame.getContentPane().add(lbl_docPreview);
		lbl_docPreview.setIcon(new ImageIcon(new ImageIcon("E:\\Bigdata\\팀 프로젝트\\[자료] GUI에 쓰인 사진들\\Doc.jpg").getImage().getScaledInstance(450, 520, Image.SCALE_DEFAULT)));
		
		// 위임장 서식 다운로드 버튼
		JButton btn_downloadDoc = new JButton("\uC73C\uB738 \uD6A8\uC728 \uAC00\uC804\uC81C\uD488 \uAD6C\uB9E4\uBE44\uC6A9 \uD658\uAE09\uC2E0\uCCAD \uC704\uC784\uC7A5.jpg");
		btn_downloadDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setSelectedFile(new File("E:\\Bigdata\\팀 프로젝트\\[자료] GUI에 쓰인 사진들\\Doc.jpg"));
				if (JFileChooser.APPROVE_OPTION == chooser.showSaveDialog(null)) {
					RenderedImage rendered = createReportAsJpg();
					try {
						ImageIO.write(rendered, "jpg", chooser.getSelectedFile());
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						return;
					}
				}
			}
			private RenderedImage createReportAsJpg() {
				return null;
			}
		});
		btn_downloadDoc.setBackground(Color.WHITE);
		btn_downloadDoc.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		btn_downloadDoc.setBounds(50, 155, 358, 37);
		frame.getContentPane().add(btn_downloadDoc);
		
		JButton button = new JButton("\uB2EB\uAE30");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainGUI main = new MainGUI();
				main.loginInfo(loginDto);
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		button.setBackground(new Color(205, 92, 92));
		button.setBounds(12, 590, 70, 35);
		frame.getContentPane().add(button);
	}

}
