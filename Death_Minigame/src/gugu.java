

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;



public class gugu extends JFrame {

	private JPanel contentPane;
	private JTextField answer1;
	private JTextField round1;
	private static JTextField ti1;
	private JTextField question1;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	static int ro1 = 1;
	private JButton end1;
	private JButton home1;
	private	JButton btnNewButton;
	private JButton start;
	private JButton end2;
	int rn1;  //// 랜덤 두 숫자를 전역선언? 해버리면 숫자가 바뀌지 않는다 . 대신 답란과 비교가 가능하다.
	int rn2;
	static long s1 = System.currentTimeMillis();
	long e1;
	int num;
	int qu1;
	static String bb;
	public static String bb1;
	private JButton btn1;
	int i;
	private JLabel lblNewLabel_2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gugu frame = new gugu();
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
	public gugu() {
		setTitle("죽음의 사칙연산게임");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 838, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		answer1 = new JTextField();
		answer1.setFont(new Font("한컴 말랑말랑 Regular", Font.PLAIN, 15));
		answer1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				btn1.doClick();
			}
		});
		answer1.disable();
		answer1.setText("\uC815\uB2F5 \uC785\uB825 \uD6C4 'Enter'\uB97C \uB20C\uB7EC\uC8FC\uC138\uC694~!");
		answer1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				answer1.setText("");	
			}
		});
		answer1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				int key=arg0.getKeyCode();
				if(key==KeyEvent.VK_ENTER) {        ////////앤터키를 누르떄 
					
					btnNewButton.doClick();	///////////////버튼이 눌린다
					
				}
			}
		});
		
		label_1 = new JLabel("\uBB38\uC81C");
		label_1.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		label_1.setOpaque(true);
		label_1.setBackground(Color.LIGHT_GRAY);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(48, 269, 100, 35);
		contentPane.add(label_1);
		answer1.setBounds(160, 429, 514, 35);
		contentPane.add(answer1);
		answer1.setColumns(10);
		
		round1 = new JTextField();
		round1.setText("10/1");
		round1.setHorizontalAlignment(SwingConstants.CENTER);
		round1.setFont(new Font("한컴산뜻돋움", Font.BOLD, 20));
		round1.setBounds(279, 121, 263, 35);
		contentPane.add(round1);
		round1.setColumns(10);
		round1.setEditable(false);
		
		ti1 = new JTextField();
		ti1.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 20));
		ti1.setBounds(279, 54, 263, 35);
		contentPane.add(ti1);
		ti1.setColumns(10);
		ti1.setEditable(false);
		
		label = new JLabel("\uC815\uB2F5");
		label.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		label.setBackground(Color.LIGHT_GRAY);
		label.setOpaque(true);
		label.setForeground(Color.BLACK);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(48, 429, 100, 35);
		contentPane.add(label);
		
		lblNewLabel = new JLabel("\uB77C\uC6B4\uB4DC");
		lblNewLabel.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(180, 121, 87, 35);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\uD0C0\uC774\uBA38");
		lblNewLabel_1.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(180, 54, 87, 35);
		contentPane.add(lblNewLabel_1);
		
		end1 = new JButton("");
		end1.setIcon(new ImageIcon(gugu.class.getResource("/images/CloseButton_mini.png")));
		end1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
			}
		});
		end1.setBounds(24, 22, 100, 40);
		contentPane.add(end1);
		
		home1 = new JButton("");
		home1.setIcon(new ImageIcon(gugu.class.getResource("/images/HomeButton_mini.png")));
		home1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setVisible(false);
			}
			
		});
		home1.setBounds(24, 72, 100, 40);
		contentPane.add(home1);
		
		start = new JButton("");
		start.setIcon(new ImageIcon(gugu.class.getResource("/images/StartButton_mini.png")));
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer1.enable();
				rn1 = (int) ((Math.random()*100) + 1);
				rn2 = (int) ((Math.random()*100) + 1);	
				int num = (int) (Math.random()*4);
				String qu2 = Integer.toString(qu1);
				String rn3 = Integer.toString(rn1);
				String rn4 = Integer.toString(rn2);
				if(num == 0) {
					qu1 = rn1 + rn2;
					question1.setText(rn3+"+"+rn4);
				}
				if(num == 1)
				{
					qu1 = rn1 - rn2;
					question1.setText(rn3+"-"+rn4);
				}
				if(num == 2)
		         {	
					 if(rn1%rn2 == 0 ) {
				            qu1 = rn1 / rn2;
							question1.setText(rn3+"/"+rn4);
				            }
					 else
						 start.doClick();
		         }
				if(num == 3)
				{
					qu1 = rn1 * rn2;
					question1.setText(rn3+"*"+rn4);

				}
				
			}
		});
		start.setBounds(24, 122, 100, 40);
		contentPane.add(start);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String ans1 = answer1.getText();
				String qu2 = Integer.toString(qu1);
				if(ans1.equals(qu2)) {	
					rn1 = (int) ((Math.random()*100) + 1);
					rn2 = (int) ((Math.random()*100) + 1);
					//int num = (int) (Math.random()*4);
					ro1++;	
					answer1.setText("");
					question1.setText("");
					start.doClick();
					if(ro1==11) {
						end2.doClick();
					}
				}
				else
					answer1.setText("");
					String ro2 = Integer.toString(ro1);
					round1.setText("10/"+ro2);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(699, 429, 62, 35);
		contentPane.add(btnNewButton);
		btnNewButton.setVisible(false);
		
		end2 = new JButton("\uC885\uB8CC");
		end2.setVisible(false);
		end2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long e1 = System.currentTimeMillis();
				long timer1 = e1-s1;
				int timer2 = (int) (timer1/1000);
				String timer3 = Integer.toString(timer2);
				ti1.setText(timer3+"초");
				
				start.setVisible(false);
				start.disable();
				answer1.disable();
				question1.setText("");
				
				bb=ti1.getText();
				new NicknameCreate().setVisible(true);
				new Result1(bb).setVisible(false);
				
				ro1=1;
			}
		
		});
		end2.setBounds(24, 160, 97, 23);
		contentPane.add(end2);
		
		btn1 = new JButton("");
		btn1.setVisible(false);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				if(i==50)
					new Moon1().setVisible(true);
			}
		});
		btn1.setBounds(643, 34, 72, 54);
		contentPane.add(btn1);
		
		question1 = new JTextField();
		question1.setHorizontalAlignment(SwingConstants.CENTER);
		question1.setFont(new Font("굴림", Font.BOLD, 50));
		question1.setBounds(160, 182, 514, 192);
		contentPane.add(question1);
		question1.setColumns(10);
		question1.setEditable(false);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(gugu.class.getResource("/images/guguBg.png")));
		lblNewLabel_2.setBounds(0, 0, 822, 498);
		contentPane.add(lblNewLabel_2);
	
	}


	
}
