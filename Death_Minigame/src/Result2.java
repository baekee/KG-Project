

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
import java.lang.Package;


class RSP{
	String bb;
	String RS;
	
	public RSP() {}
	
	public RSP(String bb, String RS) {
		this.bb=bb;
		this.RS=RS;
	}

	public String getBb() {
		return bb;
	}

	public void setBb(String bb) {
		this.bb = bb;
	}

	public String getRS() {
		return RS;
	}

	public void setRS(String rS) {
		RS = rS;
	}

	@Override
	public String toString() {
		return bb + " , " + RS + "\n";
	}
	
	
	
}
public class Result2 extends JFrame {//°¡À§¹ÙÀ§º¸ °á°úÃ¢

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result2 frame = new Result2();
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
	public Result2(String bb) {
		setTitle("\uAC00\uC704\uBC14\uC704\uBCF4 \uACB0\uACFC\uCC3D");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setBounds(100, 100, 838, 537);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Plus_Ranking.class.getResource("/images/Confirm.png")));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();//È®ÀÎ ´©¸£¸é Ã¢ ´ÝÈû
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(607, 368, 155, 21);
		lblNewLabel_1.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.PLAIN, 15));
		contentPane.add(lblNewLabel_1);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(727, 414, 60, 37);
		lblNewLabel_1.setText(RSP_Game.bb);
		contentPane.add(button);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(429, 368, 155, 21);
		lblNewLabel.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.PLAIN, 15));
		contentPane.add(lblNewLabel);
		lblNewLabel.setText(NicknameCreate2.bb);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("ÇÑÄÄ ¸»¶û¸»¶û Bold", Font.BOLD, 20));
		textArea.setText(" \r\n                      \uAC8C\uC784\uC774 \uB05D\uB0AC\uC2B5\uB2C8\uB2E4\r\n\r\n                      \uACB0\uACFC \uD45C\uC2DC\r\n ");
		textArea.setBounds(358, 256, 452, 214);
		textArea.setEnabled(false);
		contentPane.add(textArea);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Result2.class.getResource("/images/ResultBackgro.png")));
		lblNewLabel_2.setBounds(0, 0, 843, 498);
		contentPane.add(lblNewLabel_2);
	}

public Result2() {	getContentPane().setLayout(null);
	}
	}

