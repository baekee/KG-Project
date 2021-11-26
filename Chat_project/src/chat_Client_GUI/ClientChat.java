package chat_Client_GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import file_Server.File_Server;
import java.awt.event.ActionListener;

public class ClientChat extends JFrame implements Runnable{


	DataOutputStream dos;
	DataInputStream dis;
	String nickname;
	Toolkit tk = Toolkit.getDefaultToolkit();

	private JPanel contentPane;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JButton btnUpload;
	
	private Socket socket;
	private String ip;
	private int port;	


	public ClientChat(DataOutputStream dos, DataInputStream dis, String nickname) {

		this.dos = dos;
		this.dis = dis;
		this.nickname = nickname;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("채팅 창");
		setBounds(100, 100, 570, 908);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		// 채팅 입력 창
		textField = new JTextField();
		textField.setBounds(17, 759, 368, 50);
		textField.setFont(new Font("굴림", Font.BOLD, 18));
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER ) {
					try {
						dos.writeUTF(nickname + ">" + textField.getText());
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					textField.setText(""); 
				}		
			}
		});
		contentPane.add(textField);
		textField.setColumns(10);

		
		//전송 버튼
		JButton btnSend = new JButton("\uC804\uC1A1");
		btnSend.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					dos.writeUTF(nickname + ">" + textField.getText());
				} catch (IOException e1) {
	
					e1.printStackTrace();
				}
				textField.setText(""); 
			}		

		});
		btnSend.setBounds(423, 760, 108, 51);
		contentPane.add(btnSend);

		//채팅 공간
		textArea= new JTextArea();
		textArea.setFont(new Font("굴림", Font.BOLD, 18));
		textArea.setEditable(false);
		scrollPane = new JScrollPane();
		scrollPane.setViewportView(textArea);
		scrollPane.setBounds(17, 15, 514, 698);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);

		/*
		//파일 서버에 업로드
		btnUpload = new JButton("");
		btnUpload.setToolTipText("\uD30C\uC77C \uC804\uC1A1 \uBC84\uD2BC");
		btnUpload.setIcon(new ImageIcon("src/images/link.png"));
		btnUpload.setBorderPainted(false);
		btnUpload.setContentAreaFilled(false);
		btnUpload.setFocusPainted(false);
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jFileChooser = new JFileChooser("C:/");
				jFileChooser.setDialogTitle("파일 선택");
				jFileChooser.setMultiSelectionEnabled(true);
				jFileChooser.setApproveButtonToolTipText("전송할 파일을 선택하세요");
				jFileChooser.showDialog(btnUpload, "열기");
				File path = jFileChooser.getSelectedFile();
				
				if (path != null) {
					send_message("FileStart/"+path.getName());
					File_Server fileSender = new File_Server(path);
					File_Server fs = new  File_Server(path);
					fs.start();
				}
			}
		});
		btnUpload.setBounds(17, 715, 73, 42);
		contentPane.add(btnUpload);
		
		*/

		setVisible(true);

		Thread t = new Thread(this);
		t.start();
	}
	
	
	//전송
			private void send_message(String message){ //button
				try {
					dos.writeUTF(message);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}


	@Override
	public void run() {
		try {
			while(true) {
				String strServer = dis.readUTF();

				textArea.append("\n" + strServer);
				int kkeut = textArea.getText().length();
				textArea.setCaretPosition(kkeut); 

			}
		} catch (IOException e) {
			textArea.append("\n" + e);
		}
	}
}







