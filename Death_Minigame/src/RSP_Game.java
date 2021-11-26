
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;


public class RSP_Game extends JFrame implements ActionListener{
	
	private JPanel contentPane;//미엔패널
	private JPanel gamePanel;//게임창패널
	private JPanel userPanel;//가위바위보버튼들어 있는 패널
	private JTextField textField;//안내면 진다창
	private JLabel lblcomputer;//컴퓨터이미지 넣을 라벨
	private JButton RSPListBtn;//가위바위보 창  버튼
	private JButton startBtn;//시작버튼
	private JButton homeBtn;//HOME 버튼
	private JButton exitBtn;//종료 버튼
	private JButton eventeggBtn;//이스터에그 버튼
	private JButton btnScissor;
	private JButton btnRock;
	private JButton btnPaper;
	private JLabel lblResult;	
	private JTextField round1;
	
	
	static int ro1 = 1;
	//-------------안내면 진다 텍스트바
	Timer t1=new Timer();
	static int sw=0;
	static String s1="                                                안내면 진다~~!";
	//----------------------
	static String bb;
	public static String bb1;
	
	/**
	 * Create the frame.
	 */
	public RSP_Game() {
		
		setTitle("살얼음판 가위바위보 게임");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 838, 537);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//시작 버튼
		startBtn = new JButton("");
		startBtn.setIcon(new ImageIcon(RSP_Game.class.getResource("/images/StartButton_mini.png")));
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		startBtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
			//시작 버튼 클릭시 안내면 진다~ 텍스트 지나감
				RSPListBtn.setVisible(true);
				if(e.getSource()==startBtn && sw==0)	{	
					t1.scheduleAtFixedRate(new TimerTask()	{
						public void run()	{	
							s1=s1.substring(1, s1.length())+s1.substring(0,1);
							textField.setText(s1);
						}
					}, 0, 50);
				}
				sw=1;	
				
			}
		});
		startBtn.setBounds(660, 394, 100, 40);
		contentPane.add(startBtn);
		
		//HOME 버튼
		homeBtn = new JButton("");
		homeBtn.setIcon(new ImageIcon(RSP_Game.class.getResource("/images/HomeButton_mini.png")));
		homeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
			}
		});
		homeBtn.setBounds(660, 28, 100, 40);
		contentPane.add(homeBtn);
		
		//게임종료 버튼
		exitBtn = new JButton("");
		exitBtn.setIcon(new ImageIcon(RSP_Game.class.getResource("/images/CloseButton_mini.png")));
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				setVisible(false);
			}
		});
		exitBtn.setBounds(660, 74, 100, 40);
		contentPane.add(exitBtn);
		
		//게임창 패널
		gamePanel = new JPanel();
		gamePanel.setBounds(202, 54, 383, 421);
		contentPane.add(gamePanel);
		gamePanel.setLayout(null);
		
		//컴퓨터 패널 안 라벨
		lblcomputer = new JLabel("");
		lblcomputer.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		lblcomputer.setHorizontalAlignment(SwingConstants.CENTER);
		lblcomputer.setBounds(22, 35, 133, 159);
		gamePanel.add(lblcomputer);
		
		//가위바위보버튼이 있는 패널
		userPanel = new JPanel();
		userPanel.setBounds(35, 254, 304, 120);
		gamePanel.add(userPanel);
		userPanel.setBackground(Color.WHITE);
		userPanel.setLayout(null);
		
		btnScissor = new JButton();
		btnScissor.setForeground(Color.BLUE);
		btnScissor.setBackground(Color.WHITE);
		btnScissor.setIcon(new ImageIcon(RSP_Game.class.getResource("/images/sissor.png")));
		btnScissor.setBounds(12, 23, 97, 66);
		userPanel.add(btnScissor);
		btnScissor.addActionListener(this);
		
		btnRock = new JButton();
		btnRock.setForeground(Color.BLUE);
		btnRock.setBackground(Color.WHITE);
		btnRock.setIcon(new ImageIcon(RSP_Game.class.getResource("/images/rock.png")));
		btnRock.setBounds(107, 23, 97, 66);
		userPanel.add(btnRock);
		btnRock.addActionListener(this);
		
		btnPaper = new JButton();
		btnPaper.setForeground(Color.BLUE);
		btnPaper.setBackground(Color.WHITE);
		btnPaper.setIcon(new ImageIcon(RSP_Game.class.getResource("/images/paper.png")));
		btnPaper.setBounds(195, 23, 97, 66);
		userPanel.add(btnPaper);
		userPanel.setVisible(false);
		btnPaper.addActionListener(this);
		
		//가위바위보창 버튼
		RSPListBtn = new JButton("");
		RSPListBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		RSPListBtn.setIcon(new ImageIcon(RSP_Game.class.getResource("/images/RSPButton_game.png")));
		RSPListBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userPanel.setVisible(true);
				RSPListBtn.setEnabled(false);
			}
		});
		RSPListBtn.setVisible(false);
		RSPListBtn.setBounds(114, 388, 165, 23);
		gamePanel.add(RSPListBtn);
		
		textField = new JTextField();
		textField.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN, 15));
		textField.setBounds(35, 221, 304, 21);
		gamePanel.add(textField);
		textField.setColumns(10);
		
		//이스터에그 버튼
		eventeggBtn = new JButton("");
		eventeggBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		eventeggBtn.setBorderPainted(false);
		eventeggBtn.setBackground(Color.WHITE);
		eventeggBtn.setOpaque(false);
		eventeggBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==10) {
					String a="그만 클릭";
					JOptionPane.showMessageDialog(null,a);
				}
			}
		});
		eventeggBtn.setBounds(167, 24, 204, 187);
		gamePanel.add(eventeggBtn);
		
		//결과라벨
		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 22));
		lblResult.setBounds(22, 147, 133, 69);
		gamePanel.add(lblResult);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(RSP_Game.class.getResource("/images/rspCom.png")));
		lblNewLabel_3.setBounds(167, 24, 204, 187);
		gamePanel.add(lblNewLabel_3);
		ro1 = 1;
		
		round1 = new JTextField();
		round1.setText("1 Round");
		round1.setHorizontalAlignment(SwingConstants.CENTER);
		round1.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD, 20));
		round1.setBounds(202, 20, 383, 28);
		contentPane.add(round1);
		round1.setColumns(10);
		round1.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("  x");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon(RSP_Game.class.getResource("/images/life2.png")));
		lblNewLabel.setBounds(25, 89, 100, 53);
		contentPane.add(lblNewLabel);
		
		lblLife = new JLabel("3");									// 목숨 라벨
		lblLife.setBackground(Color.WHITE);
		lblLife.setForeground(Color.BLACK);
		lblLife.setFont(new Font("굴림", Font.BOLD, 26));
		lblLife.setBounds(107, 92, 31, 50);
		contentPane.add(lblLife);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RSP_Game.class.getResource("/images/rspBg.jpg")));
		lblNewLabel_2.setBounds(0, 0, 822, 498);
		contentPane.add(lblNewLabel_2);
	
	}
	
	int win=0;
	private JLabel lblLife;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	   public void actionPerformed(ActionEvent e) {
	      int life;
	      
	      int comNum =(int)(Math.random()*3);
	      int convertNum = 0;
	      if(e.getSource()==btnScissor) convertNum =0;
	      else if(e.getSource()==btnRock) convertNum =1;
	      else if (e.getSource()==btnPaper) convertNum=2;
	      life = Integer.parseInt(lblLife.getText());
	      if(comNum==0) {//가위
	         lblcomputer.setIcon(new ImageIcon(RSP_Game.class.getResource("/images/sissor.png")));
	         if(convertNum ==0) {
	            lblResult.setText("비겼습니다");
	            win=0;
	            ro1++;
	         }
	         else if(convertNum==1) {
	            lblResult.setText("이겼습니다");
	            win++;
	            ro1++;
	         }
	         else if(convertNum==2) {
	            lblResult.setText("졌습니다");
	            life--;
	            win=0;
	            ro1++;
	         }
	      }
	      else if(comNum==1) {//바위
	         lblcomputer.setIcon(new ImageIcon(RSP_Game.class.getResource("/images/rock.png")));
	         if(convertNum ==0) {
	            lblResult.setText("졌습니다");
	            life--;
	            win=0;
	            ro1++;
	         }
	         else if(convertNum==1) {
	            lblResult.setText("비겼습니다");
	            win=0;
	            ro1++;
	         }
	         else if(convertNum==2) {
	            lblResult.setText("이겼습니다");
	            win++;
	            ro1++;
	         }
	      }
	      else if(comNum==2) {//보
	         lblcomputer.setIcon(new ImageIcon(RSP_Game.class.getResource("/images/paper.png")));
	         if(convertNum ==0) {
	            lblResult.setText("이겼습니다");
	            win++;
	            ro1++;
	            
	         }
	         else if(convertNum==1) {
	            lblResult.setText("졌습니다");
	            life--;
	            win=0;
	            ro1++;
	         }
	         else if(convertNum==2) {
	            lblResult.setText("비겼습니다");
	            win=0;
	            ro1++;
	            }
	         }//if문-end
	      if(win == 2) {
	         life++;
	         win=0;
	      }
	      
	      if(life == 0) { 
	    	  
	          new NicknameCreate2().setVisible(true);
	          
	          RSPListBtn.setVisible(false);
	          userPanel.setVisible(false);
	          bb=round1.getText();
	          new Result2(bb).setVisible(false);
	          startBtn.setVisible(false);
	       }
	    
	     
	      lblLife.setText(""+life); 
	      round1.setText(ro1+" Round");
	      }
	   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RSP_Game frame = new RSP_Game();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
