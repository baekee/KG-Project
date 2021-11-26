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


public class Minigame_Discription2_4 extends JFrame {

	private JPanel Part2_4;
	private final JLabel Playgame = new JLabel("\uB3D9\uC601\uC0C1");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Minigame_Discription2_4 frame = new Minigame_Discription2_4();
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
	public Minigame_Discription2_4() {
		
		setTitle("가위바위보게임 설명");	// 가위바위보게임 설명4
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		setLocationRelativeTo(null);
		Part2_4 = new JPanel();
		Part2_4.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Part2_4);
		Part2_4.setLayout(null);
		
		JButton SkipButton = new JButton("Skip");
		SkipButton.setIcon(new ImageIcon(Minigame_Discription2_4.class.getResource("/images/SkipButton.png")));
		SkipButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		SkipButton.setToolTipText("\uC2A4\uD0B5");
		SkipButton.setBounds(180, 450, 70, 40);
		Part2_4.add(SkipButton);
		SkipButton.setVisible(false);
		
		JButton PrevButton = new JButton("< Prev");
		PrevButton.setIcon(new ImageIcon(Minigame_Discription2_4.class.getResource("/images/PrevButton.png")));
		PrevButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new Minigame_Discription2_3().setVisible(true);
			}
		});
		PrevButton.setToolTipText("\uC774\uC804\uC73C\uB85C");
		PrevButton.setBounds(40, 457, 77, 33);
		Part2_4.add(PrevButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textPane.setToolTipText("\uAC8C\uC784 \uC124\uBA85");
		textPane.setText("\uBAA9\uC228\uC774 0 \uB418\uBA74 Gameover!!");
		textPane.setBounds(43, 267, 350, 125);
		Part2_4.add(textPane);
		Playgame.setIcon(new ImageIcon(Minigame_Discription2_4.class.getResource("/images/rspLose.PNG")));
		Playgame.setBackground(Color.WHITE);
		Playgame.setBounds(43, 40, 350, 219);
		Part2_4.add(Playgame);
		textPane.setEditable(false); 
		
		JLabel TitleOfDiscription = new JLabel("Gameover");
		TitleOfDiscription.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		TitleOfDiscription.setBounds(12, 10, 122, 22);
		Part2_4.add(TitleOfDiscription);
		

		JButton RoundButton1 = new JButton("");
		RoundButton1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new Minigame_Discription2_1().setVisible(true);
			}
		});
		RoundButton1.setBounds(160, 410, 20, 20);
		RoundButton1.setIcon(new ImageIcon("src/images/icon-whitecircle.png"));
		RoundButton1.setFocusPainted(false);
		RoundButton1.setContentAreaFilled(false);
		Part2_4.add(RoundButton1);
		

		JButton RoundButton2 = new JButton("");
		RoundButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new Minigame_Discription2_2().setVisible(true);
			}
		});
		RoundButton2.setBounds(190, 410, 20, 20);
		RoundButton2.setIcon(new ImageIcon("src/images/icon-whitecircle.png"));
		RoundButton2.setFocusPainted(false);
		RoundButton2.setContentAreaFilled(false);
		Part2_4.add(RoundButton2);
		
		JButton RoundButton3 = new JButton("");
		RoundButton3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new Minigame_Discription2_3().setVisible(true);
			}
		});
		RoundButton3.setBounds(220, 410, 20, 20);
		RoundButton3.setIcon(new ImageIcon("src/images/icon-whitecircle.png"));
		RoundButton3.setFocusPainted(false);
		RoundButton3.setContentAreaFilled(false);
		Part2_4.add(RoundButton3);
		
		JButton RoundButton4 = new JButton("");
		RoundButton4.setBounds(250, 410, 20, 20);
		RoundButton4.setIcon(new ImageIcon("src/images/icon-blackcircle.png"));
		RoundButton4.setFocusPainted(false);
		RoundButton4.setContentAreaFilled(false);
		Part2_4.add(RoundButton4);
		
		JButton GameStart = new JButton("GameStart");
		GameStart.setIcon(new ImageIcon(Minigame_Discription2_4.class.getResource("/images/GameSatrt_mini.png")));
		GameStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new RSP_Game().setVisible(true);
			}
		});
		GameStart.setToolTipText("\uAC8C\uC784 \uC2DC\uC791");
		GameStart.setBounds(300, 457, 110, 33);
		Part2_4.add(GameStart);
		
	}

	public JPanel getPart2_4() {
		return Part2_4;
	}

	public void setPart2_4(JPanel part2_4) {
		Part2_4 = part2_4;
	}

	public JLabel getPlaygame() {
		return Playgame;
	}
}
