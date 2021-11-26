
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;


public class Minigame_Discription1_1 extends JFrame {

	private JPanel Part1_1;
	private final JLabel Playgame = new JLabel("\uB3D9\uC601\uC0C1");
	
	public void Part1_1 () 	{}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Minigame_Discription1_1 frame = new Minigame_Discription1_1();
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
	public Minigame_Discription1_1() {
		
		setTitle("사칙연산게임 설명");	// 사칙연산게임 설명1
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		setLocationRelativeTo(null);
		Part1_1 = new JPanel();
		Part1_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Part1_1);
		Part1_1.setLayout(null);
		
		// 스킵 아이콘
		JButton SkipButton = new JButton("Skip");
		SkipButton.setIcon(new ImageIcon(Minigame_Discription1_1.class.getResource("/images/SkipButton.png")));
		SkipButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane aa = new JOptionPane();
				int result = aa.showConfirmDialog(null, "Skip 하시겠습니까?","Confirm", JOptionPane.YES_OPTION );
				if (result == JOptionPane.YES_OPTION) {
				      dispose();
				      setVisible(false);
				      new gugu().setVisible(true);
				}
			}
		});
		SkipButton.setToolTipText("\uC2A4\uD0B5");
		SkipButton.setBounds(180, 450, 70, 31);
		Part1_1.add(SkipButton);
		
		// 넥스트 버튼
		JButton NextButton = new JButton("Next >");
		NextButton.setIcon(new ImageIcon(Minigame_Discription1_1.class.getResource("/images/NextButton.png")));
		NextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new Minigame_Discription1_2().setVisible(true);
			}

		});
		
		NextButton.setToolTipText("\uB2E4\uC74C\uC73C\uB85C");
		NextButton.setBounds(303, 447, 80, 35);
		Part1_1.add(NextButton);
		
		// 프리뷰버튼
		JButton PrevButton = new JButton("< Prev");
		PrevButton.setIcon(new ImageIcon(Minigame_Discription1_1.class.getResource("/images/PrevButton.png")));
		PrevButton.setToolTipText("\uC774\uC804\uC73C\uB85C");
		PrevButton.setBounds(40, 450, 85, 40);
		Part1_1.add(PrevButton);
		PrevButton.setVisible(false);
		
		// 게임설명란 텍스트 창
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textPane.setToolTipText("\uAC8C\uC784 \uC124\uBA85");
		textPane.setText("\uBB38\uC81C \uC815\uB2F5 \uC2DC, \uB2E4\uC74C \uB77C\uC6B4\uB4DC \uC9C4\uD589");
		textPane.setBounds(43, 267, 350, 125);
		Part1_1.add(textPane);
		Playgame.setIcon(new ImageIcon(Minigame_Discription1_1.class.getResource("/images/gugu1.PNG")));
		Playgame.setBackground(Color.WHITE);
		Playgame.setBounds(43, 40, 350, 219);
		Part1_1.add(Playgame);
		textPane.setEditable(false); 
		
		// 창 부제
		JLabel TitleOfDiscription = new JLabel("\uBB38\uC81C \uC815\uB2F5 \uC2DC");
		TitleOfDiscription.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		TitleOfDiscription.setBounds(12, 10, 122, 22);
		Part1_1.add(TitleOfDiscription);
		
		// 이미지 사이즈 조절
		/*	ImageIcon img1 = new ImageIcon("icon-blackcircle/normalicon.png");
		Image img1_1 = img1.getImage();
		Image img1_2 = img1_1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon img1_3 = new ImageIcon(img1_2);	*/
		
		/*	ImageIcon img2 = new ImageIcon("icon-whitecircle/normalicon.png");
		Image img2_1 = img2.getImage();
		Image img2_2 = img2_1.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		ImageIcon img2_3 = new ImageIcon(img2_2);	*/
		
		JButton RoundButton1 = new JButton("");
		RoundButton1.setBounds(170, 410, 20, 20);
		RoundButton1.setFocusPainted(false);
		RoundButton1.setContentAreaFilled(false);
		RoundButton1.setIcon(new ImageIcon("src/images/icon-blackcircle.png"));
		Part1_1.add(RoundButton1);
		

		JButton RoundButton2 = new JButton("");
		RoundButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new Minigame_Discription1_2().setVisible(true);
			}
		});
		RoundButton2.setBounds(200, 410, 20, 20);
		RoundButton2.setFocusPainted(false);
		RoundButton2.setContentAreaFilled(false);
		RoundButton2.setIcon(new ImageIcon("src/images/icon-whitecircle.png"));
		Part1_1.add(RoundButton2);
		
		JButton RoundButton3 = new JButton("");
		RoundButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new Minigame_Discription1_3().setVisible(true);
			}
		});
		RoundButton3.setBounds(230, 410, 20, 20);
		RoundButton3.setFocusPainted(false);
		RoundButton3.setContentAreaFilled(false);
		RoundButton3.setIcon(new ImageIcon("src/images/icon-whitecircle.png"));
		Part1_1.add(RoundButton3);
		
	}

	public JPanel getPart1_1() {
		return Part1_1;
	}

	public void setPart1_1(JPanel part1_1) {
		Part1_1 = part1_1;
	}

	public JLabel getPlaygame() {
		return Playgame;
	}
}
