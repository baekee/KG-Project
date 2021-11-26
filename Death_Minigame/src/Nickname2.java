

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class Nickname2 extends JFrame {//�г��� ����Ͻðڽ��ϱ�?(����������)

	public static String bb;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nickname2 frame = new Nickname2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param bb 
	 */
	public Nickname2(String bb) {//Nickname2�� ����
		setTitle("�г��� ���â");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 220);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC774 \uB2C9\uB124\uC784\uC73C\uB85C \uB4F1\uB85D\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("���� �������� Bold", Font.BOLD, 20));
		lblNewLabel.setBounds(149, 77, 137, 33);
		contentPane.add(lblNewLabel);
		lblNewLabel.setText(bb);//�Է��� �г��� ���
		JButton btn1 = new JButton("   Cancle");
		btn1.setIcon(new ImageIcon(Nickname2.class.getResource("/images/CancelButton.png")));
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				new NicknameCreate2().setVisible(true);
				
			}
		});
		btn1.setBackground(Color.WHITE);
		btn1.setForeground(Color.WHITE);
		btn1.setBounds(0, 135, 221, 33);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton(" ");
		btn2.setIcon(new ImageIcon(Nickname2.class.getResource("/images/OKButton_mini.png")));
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				
				 new Result2(bb).setVisible(true);
			}
		});
		btn2.setForeground(Color.WHITE);
		btn2.setBackground(Color.WHITE);
		btn2.setBounds(221, 135, 221, 33);
		contentPane.add(btn2);
		
		JLabel label = new JLabel("\uC544\uB798 \uB2C9\uB124\uC784\uC73C\uB85C \uB4F1\uB85D\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
		label.setFont(new Font("����", Font.BOLD, 20));
		label.setBounds(41, 32, 351, 24);
		contentPane.add(label);
	}

	public Nickname2() {
		setTitle("�г��� ����ϱ�");
	}
	}
	

