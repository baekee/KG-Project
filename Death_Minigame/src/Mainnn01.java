import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

class Plus_User{	// 사칙연산 닉네임, 점수 받는 클래스
	private String nickname;
	private int score;
	
	Plus_User(){}
	Plus_User(String nickname, int score){
		this.nickname = nickname;
		this.score = score;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void Info() {
	}
	public String toString() {
		return "닉네임 : " + nickname + " " + score +" 점\n"; 
	}
}

class RSP_User{					// 가위바위보 닉네임, 점수 받는 클래스
	private String nickname;
	private int score;
	
	RSP_User(){}
	RSP_User(String nickname, int score){
		this.nickname = nickname;
		this.score = score;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String toString() {
		return "닉네임 : " + nickname + " " + score +" 점\n";  
	}
	
}

public class Mainnn01 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainnn01 frame = new Mainnn01();
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

	public Mainnn01() {
		setTitle("Death Minigame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 838, 537);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("src/images/CloseButton.png"));
		button.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
			}
		});
		button.setBounds(338, 386, 121, 41);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("");	// 랭킹확인버튼
		btnNewButton.setIcon(new ImageIcon("src/images/RankButton.png"));
		btnNewButton.setFont(new Font("함초롬돋움", Font.BOLD, 20));
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new RSP_Ranking().setVisible(true);	//가위바위보 랭킹창
			}
		});
		btnNewButton.setBounds(338, 323, 121, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");	//사칙연산 설명창
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 25));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Minigame_Discription1_1().setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("src/images/gugubutton.png"));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(168, 138, 183, 102);
		contentPane.add(btnNewButton_1);
		btnNewButton_1 = new JButton(new ImageIcon("math.jpg"));
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("src/images/RSPButton.png"));
		btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 25));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Minigame_Discription2_1().setVisible(true);
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(525, 138, 161, 102);
		contentPane.add(btnNewButton_2);
		
		JButton btnEgg = new JButton("");
		btnEgg.setIcon(new ImageIcon("src/images/MainTitle.png"));
		btnEgg.setBackground(Color.WHITE);
		btnEgg.setOpaque(false);
		btnEgg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(arg0.getClickCount()==10) {
					new EndingCredit().setVisible(true);
				}
			}
		});
		btnEgg.setBounds(238, 26, 390, 71);
		contentPane.add(btnEgg);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("src/images/MainBackgro.png"));
		lblNewLabel_1.setBounds(0, 0, 824, 500);
		contentPane.add(lblNewLabel_1);
	}
}
