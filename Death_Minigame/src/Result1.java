
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.lang.Package;

class Plus { // 사칙연산 닉네임, 점수 받는 클래스
	private String nickname;
	private int score;
	private String bb;
	private String gugu;

	Plus() {
	}

	Plus(String bb, String gugu) {
		this.bb = bb;
		this.gugu = gugu;
	}

	public String getbb() {
		return bb;
	}

	public void setbb(String bb) {
		this.bb = bb;
	}

	public String getgugu() {
		return gugu;
	}

	public void setgugu(String gugu) {
		this.gugu = gugu;
	}

	public void Info() {

	}

	public String toString() {
		return bb + " ,     " + gugu + "\n";
	}
}

public class Result1 extends JFrame {// 사칙연산

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result1 frame = new Result1();
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
	public Result1(String bb) {

		setTitle("\uC0AC\uCE59\uC5F0\uC0B0 \uACB0\uACFC\uCC3D");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 838, 537);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Plus_Ranking.class.getResource("/images/Confirm.png")));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		lblNewLabel.setBounds(415, 373, 155, 21);
		lblNewLabel.setText(NicknameCreate.bb);
		contentPane.add(lblNewLabel);
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(582, 373, 155, 21);
		lblNewLabel_1.setText(gugu.bb);

		contentPane.add(lblNewLabel_1);

		button.setForeground(Color.WHITE);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(728, 414, 59, 37);
		contentPane.add(button);

		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
		textArea.setText(
				" \r\n              \uAC8C\uC784\uC774 \uB05D\uB0AC\uC2B5\uB2C8\uB2E4.\r\n\r\n              \uACB0\uACFC \uD45C\uC2DC\r\n ");
		textArea.setBounds(358, 256, 452, 214);
		textArea.setEnabled(false);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Result1.class.getResource("/images/ResultBackgro.png")));
		lblNewLabel_2.setBounds(0, 0, 842, 498);
		contentPane.add(lblNewLabel_2);
	}

	
	  public Result1() { getContentPane().setLayout(null);
	 
	  }
	 

}
