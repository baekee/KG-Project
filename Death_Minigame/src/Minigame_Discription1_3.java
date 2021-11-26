import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Minigame_Discription1_3 extends JFrame {

	private JPanel Part1_3;
	private final JLabel Playgame = new JLabel("");
	
	public void Part1_3 () 	{}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Minigame_Discription1_3 frame = new Minigame_Discription1_3();
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
	public Minigame_Discription1_3() {
		
		setTitle("사칙연산게임 설명");	// 사칙연산게임 설명3
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		setLocationRelativeTo(null);
		Part1_3 = new JPanel();
		Part1_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Part1_3);
		Part1_3.setLayout(null);
		
		JButton SkipButton = new JButton("Skip");
		SkipButton.setIcon(new ImageIcon(Minigame_Discription1_3.class.getResource("/images/SkipButton.png")));
		SkipButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		SkipButton.setToolTipText("\uC2A4\uD0B5");
		SkipButton.setBounds(180, 450, 70, 31);
		Part1_3.add(SkipButton);
		SkipButton.setVisible(false);
		
		JButton PrevButton = new JButton("< Prev");
		PrevButton.setIcon(new ImageIcon(Minigame_Discription1_3.class.getResource("/images/PrevButton.png")));
		PrevButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new Minigame_Discription1_2().setVisible(true);
			}
		});
		PrevButton.setToolTipText("\uC774\uC804\uC73C\uB85C");
		PrevButton.setBounds(43, 447, 78, 35);
		Part1_3.add(PrevButton);
		
		JTextPane txtpnGameover = new JTextPane();
		txtpnGameover.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		txtpnGameover.setToolTipText("\uAC8C\uC784 \uC124\uBA85");
		txtpnGameover.setText("\uB77C\uC6B4\uB4DC 10\uD68C\uAC00 \uC9C0\uB098\uBA74 Gameover!!");
		txtpnGameover.setBounds(43, 267, 350, 125);
		Part1_3.add(txtpnGameover);
		Playgame.setIcon(new ImageIcon(Minigame_Discription1_3.class.getResource("/images/gugu3.PNG")));
		Playgame.setBackground(Color.WHITE);
		Playgame.setBounds(43, 40, 350, 219);
		Part1_3.add(Playgame);
		txtpnGameover.setEditable(false); 
		
		JLabel TitleOfDiscription = new JLabel("Gameover");
		TitleOfDiscription.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		TitleOfDiscription.setBounds(12, 10, 122, 22);
		Part1_3.add(TitleOfDiscription);
		

		JButton RoundButton1 = new JButton("");
		RoundButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new Minigame_Discription1_1().setVisible(true);
			}
		});
		RoundButton1.setBounds(170, 410, 20, 20);
		RoundButton1.setIcon(new ImageIcon("src/images/icon-whitecircle.png"));
		RoundButton1.setFocusPainted(false);
		RoundButton1.setContentAreaFilled(false);
		Part1_3.add(RoundButton1);
		

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
		RoundButton2.setIcon(new ImageIcon("src/images/icon-whitecircle.png"));
		RoundButton2.setFocusPainted(false);
		RoundButton2.setContentAreaFilled(false);
		Part1_3.add(RoundButton2);
		
		JButton RoundButton3 = new JButton("");
		RoundButton3.setBounds(230, 410, 20, 20);
		RoundButton3.setIcon(new ImageIcon("src/images/icon-blackcircle.png"));
		RoundButton3.setFocusPainted(false);
		RoundButton3.setContentAreaFilled(false);
		Part1_3.add(RoundButton3);
		
		JButton GameStart = new JButton("GameStart");
		GameStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GameStart.setIcon(new ImageIcon(Minigame_Discription1_3.class.getResource("/images/GameSatrt_mini.png")));
		GameStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new gugu().setVisible(true);
			}
		});
		GameStart.setToolTipText("\uAC8C\uC784 \uC2DC\uC791");
		GameStart.setBounds(290, 450, 107, 35);
		Part1_3.add(GameStart);
		
	}

	public JPanel getPart1_3() {
		return Part1_3;
	}

	public void setPart1_3(JPanel part1_3) {
		Part1_3 = part1_3;
	}

	public JLabel getPlaygame() {
		return Playgame;
	}
}
