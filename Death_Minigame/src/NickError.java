

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class NickError extends JFrame {//´Ð³×ÀÓÀ» ÀÔ·ÂÇÏ½Ã¿À!!

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NickError frame = new NickError();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param id 
	 */
	public NickError() {
		setTitle("ERROR");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 220);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" \uB2C9\uB124\uC784\uC744 \uC785\uB825\uD558\uC2DC\uC624!!");
		lblNewLabel.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 20));
		lblNewLabel.setBounds(123, 50, 192, 29);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("ok");
		button.setIcon(new ImageIcon(NickError.class.getResource("/images/OKButton.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();//ok ´©¸£¸é È­¸é ²¨Áü
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		button.setBackground(Color.WHITE);
		button.setBounds(10, 120, 415, 35);
		contentPane.add(button);
		
	}
	
}
