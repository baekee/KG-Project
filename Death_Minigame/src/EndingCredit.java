

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.Font;

public class EndingCredit extends JFrame {

	private JPanel contentPane;
	private JTextArea t3;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblteam;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EndingCredit frame = new EndingCredit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EndingCredit() {
		setTitle("Death Minigame");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 803, 579);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(203, 25, 474, 73);
		lblNewLabel.setIcon(new ImageIcon(EndingCredit.class.getResource("/images/MainTitle.png")));
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\t\t\uAC00\uC704\uBC14\uC704\uBCF4Team\r\n\t\t");
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(323, 117, 144, 48);
		contentPane.add(lblNewLabel_1);
		
		label = new JLabel("\uC5FC\uD615\uC12D");
		label.setForeground(Color.WHITE);
		label.setBounds(356, 175, 111, 29);
		contentPane.add(label);
		
		label_1 = new JLabel("\uC815\uB2E4\uC740");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(356, 211, 111, 29);
		contentPane.add(label_1);
		
		lblteam = new JLabel("\uC0AC\uCE59\uC5F0\uC0B0Team");
		lblteam.setFont(new Font("±¼¸²", Font.BOLD, 17));
		lblteam.setForeground(Color.WHITE);
		lblteam.setBounds(323, 280, 133, 29);
		contentPane.add(lblteam);
		
		label_3 = new JLabel("\uACFD\uC724\uC815");
		label_3.setForeground(Color.WHITE);
		label_3.setBounds(356, 322, 93, 29);
		contentPane.add(label_3);
		
		label_4 = new JLabel("\uAE40\uC120\uC5F0");
		label_4.setForeground(Color.WHITE);
		label_4.setBounds(356, 351, 93, 29);
		contentPane.add(label_4);
		
		label_5 = new JLabel("\uBC30\uACBD\uC740");
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(356, 377, 93, 29);
		contentPane.add(label_5);
	}
}

