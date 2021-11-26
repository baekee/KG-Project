package chat_Sever;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Panel;
import javax.swing.SwingConstants;

public class ServerStartGUI extends JFrame {
	
	DataOutputStream outputStream;
	DataInputStream inputStream;
	
	private JFrame jframe;
	private JTextField ipField;
	private JTextField portField;
	private JTextField nameField;
	private JButton startBtn;
	private JLabel lblNewLabel;
	
	//닉네임, ip, port
	String name = null;
	String ip = "";
	int port = 0;	
	ServerStartGUI sg = this;

	// 그래픽 구현
	public ServerStartGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 908);
		getContentPane().setBackground(Color.YELLOW);
		setTitle("서버 구동 창");
		setSize(604,337);
		getContentPane().setLayout(null);
		
		JLabel portLabel = new JLabel("PORT #");
		portLabel.setFont(new Font("굴림", Font.BOLD, 26));
		portLabel.setBounds(291, 90, 105, 39);
		getContentPane().add(portLabel);
		
		portField = new JTextField();
		portField.setHorizontalAlignment(SwingConstants.CENTER);
		portField.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		portField.setBounds(268, 151, 145, 39);
		getContentPane().add(portField);
		portField.setColumns(10);
		
		startBtn = new JButton("");
		startBtn.setToolTipText("\uBC84\uD2BC\uC744 \uB20C\uB7EC\uC8FC\uC138\uC694");
		startBtn.setIcon(new ImageIcon(ServerStartGUI.class.getResource("/imeges/powerbt_iconmonster_48.png")));
		startBtn.setBorderPainted(false);
		startBtn.setContentAreaFilled(false);
		startBtn.setFocusPainted(false);
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				port = Integer.parseInt(portField.getText().trim());
				
				try {
					
					new ChatServer(port,sg);
					
				} catch (IOException | ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		startBtn.setBounds(425, 130, 74, 76);
		getContentPane().add(startBtn);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ServerStartGUI.class.getResource("/imeges/website_freefix_128.png")));
		lblNewLabel.setBounds(100, 61, 183, 145);
		getContentPane().add(lblNewLabel);

		setVisible(true);

	}
	
	public static void main(String args[]){
		new ServerStartGUI();
	}//main-end
} //main class- end
