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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class Minigame_Discription1_2 extends JFrame {

	private JPanel Part1_2;
	private final JLabel Playgame = new JLabel("\uB3D9\uC601\uC0C1");
	
	public void Part1_2 () 	{}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Minigame_Discription1_2 frame = new Minigame_Discription1_2();
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
	public Minigame_Discription1_2() {
		
		setTitle("사칙연산게임 설명");	// 사칙연산게임 설명2
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		setLocationRelativeTo(null);
		Part1_2 = new JPanel();
		Part1_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Part1_2);
		Part1_2.setLayout(null);
		
		JButton SkipButton = new JButton("Skip");
		SkipButton.setIcon(new ImageIcon(Minigame_Discription1_2.class.getResource("/images/SkipButton.png")));
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
		Part1_2.add(SkipButton);
		
		JButton NextButton = new JButton("Next >");
		NextButton.setIcon(new ImageIcon(Minigame_Discription1_2.class.getResource("/images/NextButton.png")));
		NextButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new Minigame_Discription1_3().setVisible(true);
			}
		});
		NextButton.setToolTipText("\uB2E4\uC74C\uC73C\uB85C");
		NextButton.setBounds(303, 447, 80, 35);
		Part1_2.add(NextButton);
		
		JButton PrevButton = new JButton("< Prev");
		PrevButton.setIcon(new ImageIcon(Minigame_Discription1_2.class.getResource("/images/PrevButton.png")));
		PrevButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		PrevButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
	            setVisible(false);
	            new Minigame_Discription1_1().setVisible(true);
			}
		});
		PrevButton.setToolTipText("\uC774\uC804\uC73C\uB85C");
		PrevButton.setBounds(43, 447, 78, 35);
		Part1_2.add(PrevButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		textPane.setText("\uBB38\uC81C \uC624\uB2F5 \uC2DC, \uD574\uB2F9 \uB77C\uC6B4\uB4DC \uC7AC\uC9C4\uD589     (\uB3D9\uC77C\uD55C \uBB38\uC81C\uB85C \uC9C4\uD589)");
		textPane.setBounds(43, 267, 350, 125);
		Part1_2.add(textPane);
		Playgame.setIcon(new ImageIcon(Minigame_Discription1_2.class.getResource("/images/gugu2.PNG")));
		Playgame.setBackground(Color.WHITE);
		Playgame.setBounds(43, 40, 350, 219);
		Part1_2.add(Playgame);
		textPane.setEditable(false); 
		
		JLabel TitleOfDiscription = new JLabel("\uBB38\uC81C \uC624\uB2F5 \uC2DC");
		TitleOfDiscription.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		TitleOfDiscription.setBounds(12, 10, 122, 22);
		Part1_2.add(TitleOfDiscription);
		

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
		Part1_2.add(RoundButton1);
		

		JButton RoundButton2 = new JButton("");
		RoundButton2.setBounds(200, 410, 20, 20);
		RoundButton2.setIcon(new ImageIcon("src/images/icon-blackcircle.png"));
		RoundButton2.setFocusPainted(false);
		RoundButton2.setContentAreaFilled(false);
		Part1_2.add(RoundButton2);
		
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
		RoundButton3.setIcon(new ImageIcon("src/images/icon-whitecircle.png"));
		RoundButton3.setFocusPainted(false);
		RoundButton3.setContentAreaFilled(false);
		Part1_2.add(RoundButton3);
		
	}

	public JPanel getPart1_2()	{
		return Part1_2;
	}

	public void setPart1_2(JPanel part1_2) {
		Part1_2 = part1_2;
	}

	public JLabel getPlaygame() {
		return Playgame;
	}
}
