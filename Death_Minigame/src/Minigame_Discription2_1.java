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


public class Minigame_Discription2_1 extends JFrame {

	private JPanel Part2_1;
	private final JLabel Playgame = new JLabel("\uB3D9\uC601\uC0C1");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Minigame_Discription2_1 frame = new Minigame_Discription2_1();
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
	public Minigame_Discription2_1() {
		
		setTitle("가위바위보게임 설명");	// 가위바위보게임 설명1
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		setLocationRelativeTo(null);
		Part2_1 = new JPanel();
		Part2_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Part2_1);
		Part2_1.setLayout(null);
		
		JButton SkipButton = new JButton("Skip");
		SkipButton.setIcon(new ImageIcon(Minigame_Discription2_1.class.getResource("/images/SkipButton.png")));
		SkipButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane aa = new JOptionPane();
				int result = aa.showConfirmDialog(null, "Skip 하시겠습니까?","Confirm", JOptionPane.YES_OPTION );
				if (result == JOptionPane.YES_OPTION) {
				      dispose();
				      setVisible(false);
				      new RSP_Game().setVisible(true);
				}
			}
		});
		SkipButton.setToolTipText("\uC2A4\uD0B5");
		SkipButton.setBounds(180, 457, 70, 33);
		Part2_1.add(SkipButton);
		
		JButton NextButton = new JButton("Next >");
		NextButton.setIcon(new ImageIcon(Minigame_Discription2_1.class.getResource("/images/NextButton.png")));
		NextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new Minigame_Discription2_2().setVisible(true);
			}
		});
		NextButton.setToolTipText("\uB2E4\uC74C\uC73C\uB85C");
		NextButton.setBounds(300, 457, 85, 33);
		Part2_1.add(NextButton);
		
		JButton PrevButton = new JButton("< Prev");
		PrevButton.setIcon(new ImageIcon(Minigame_Discription2_1.class.getResource("/images/PrevButton.png")));
		PrevButton.setToolTipText("\uC774\uC804\uC73C\uB85C");
		PrevButton.setBounds(40, 450, 85, 40);
		Part2_1.add(PrevButton);
		PrevButton.setVisible(false);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textPane.setToolTipText("\uAC8C\uC784 \uC124\uBA85");
		textPane.setText("게임 승리 시, 사용자 목숨은 그대로!!\r\n"
				+ "다음 라운드 진행\r\n"
				+ "3연승 시, 목숨 1개 지급 ++");
		textPane.setBounds(43, 267, 350, 125);
		Part2_1.add(textPane);
		Playgame.setIcon(new ImageIcon(Minigame_Discription2_1.class.getResource("/images/rspWin.PNG")));
		Playgame.setBackground(Color.WHITE);
		Playgame.setBounds(43, 40, 350, 219);
		Part2_1.add(Playgame);
		textPane.setEditable(false); 
		
		JLabel TitleOfDiscription = new JLabel("\uAC8C\uC784 \uC2B9\uB9AC \uC2DC");
		TitleOfDiscription.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		TitleOfDiscription.setBounds(12, 10, 122, 22);
		Part2_1.add(TitleOfDiscription);
		

		JButton RoundButton1 = new JButton("");
		RoundButton1.setBounds(160, 410, 20, 20);
		RoundButton1.setIcon(new ImageIcon("src/images/icon-blackcircle.png"));
		RoundButton1.setFocusPainted(false);
		RoundButton1.setContentAreaFilled(false);
		Part2_1.add(RoundButton1);
		

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
		Part2_1.add(RoundButton2);
		
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
		Part2_1.add(RoundButton3);
		
		JButton RoundButton4 = new JButton("");
		RoundButton4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new Minigame_Discription2_4().setVisible(true);
			}
		});
		RoundButton4.setBounds(250, 410, 20, 20);
		RoundButton3.setIcon(new ImageIcon("src/images/icon-whitecircle.png"));
		RoundButton4.setFocusPainted(false);
		RoundButton4.setContentAreaFilled(false);
		Part2_1.add(RoundButton4);
		
	}

	public JPanel getPart2_1() {
		return Part2_1;
	}

	public void setPart2_1(JPanel part2_1) {
		Part2_1 = part2_1;
	}

	public JLabel getPlaygame() {
		return Playgame;
	}
}
