package chat_Client_GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import chat_model.ChatDAO;
import chat_model.ChatVO;

public class ClientLogin extends JFrame {

	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	ChatDAO dao;
	ChatVO vo;
	int clientPort;

	private JPanel contentPane;
	private JLabel lblHi;
	private JLabel lblPort;
	private JLabel lblIp;
	private JLabel lblName;
	private JLabel lbl_nickname;
	private JTextField text_ip;
	private JTextField text_portno;
	private JTextField text_name;
	private JTextField text_nickname;
	private JButton btnAccess;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientLogin frame = new ClientLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public ClientLogin() throws ClassNotFoundException, SQLException, ParseException  {



		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ä�� ��� â");
		setBounds(100, 100, 570, 908);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		//����
		lblHi = new JLabel("HI \uCC44\uD305 ");
		lblHi.setHorizontalAlignment(SwingConstants.CENTER);
		lblHi.setFont(new Font("����", Font.BOLD, 48));
		lblHi.setBounds(144, 49, 277, 65);
		contentPane.add(lblHi);


		lblPort = new JLabel("PORT #");
		lblPort.setFont(new Font("���� ���", Font.BOLD, 15));
		lblPort.setHorizontalAlignment(SwingConstants.LEFT);
		lblPort.setBounds(35, 380, 105, 43);
		contentPane.add(lblPort);

		lblIp = new JLabel("IP #");
		lblIp.setFont(new Font("���� ���", Font.BOLD, 15));
		lblIp.setHorizontalAlignment(SwingConstants.LEFT);
		lblIp.setBounds(35, 299, 105, 43);
		contentPane.add(lblIp);

		lbl_nickname = new JLabel("NICKNAME");
		lbl_nickname.setFont(new Font("���� ���", Font.BOLD, 15));
		lbl_nickname.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_nickname.setBounds(35, 464, 105, 43);
		contentPane.add(lbl_nickname);

		lblName = new JLabel("NAME");
		lblName.setFont(new Font("���� ���", Font.BOLD, 15));
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setBounds(35, 542, 105, 43);
		contentPane.add(lblName);


		// ip�ּ� �Է¶�
		text_ip = new JTextField();
		text_ip.setFont(new Font("����", Font.PLAIN, 15));
		text_ip.setHorizontalAlignment(SwingConstants.CENTER);
		text_ip.setForeground(Color.LIGHT_GRAY);
		text_ip.setText("127.0.0.1");
		text_ip.setColumns(10);
		text_ip.setBounds(201, 299, 265, 43);
		text_ip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				text_ip.setForeground(Color.BLACK);
			}
		});
		text_ip.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				text_ip.setForeground(Color.BLACK);
			}
		});
		contentPane.add(text_ip);


		// ��Ʈ��ȣ �Է¶�
		text_portno = new JTextField();
		text_portno.setFont(new Font("����", Font.PLAIN, 15));
		text_portno.setHorizontalAlignment(SwingConstants.CENTER);
		text_portno.setColumns(10);
		text_portno.setBounds(201, 380, 265, 43);
		contentPane.add(text_portno);

		// �̸� ���Զ�
		text_name = new JTextField();
		text_name.setFont(new Font("����", Font.PLAIN, 15));
		text_name.setHorizontalAlignment(SwingConstants.CENTER);
		text_name.setColumns(10);
		text_name.setBounds(201, 542, 265, 43);
		contentPane.add(text_name);

		// �г��� ���Զ�
		text_nickname = new JTextField();
		text_nickname.setFont(new Font("����", Font.PLAIN, 15));
		text_nickname.setHorizontalAlignment(SwingConstants.CENTER);
		text_nickname.setColumns(10);
		text_nickname.setBounds(201, 464, 265, 43);
		contentPane.add(text_nickname);

		// ��� ��ư
		btnAccess = new JButton("���");
		btnAccess.setFont(new Font("���� ���", Font.BOLD, 18));
		btnAccess.setBounds(201, 713, 137, 50);
		contentPane.add(btnAccess);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ClientLogin.class.getResource("/imeges/chat_freefix_100.png")));
		lblNewLabel.setBounds(216, 124, 123, 126);
		contentPane.add(lblNewLabel);

		btnAccess.addMouseListener(new MouseAdapter() {// ��� Ŭ���Ҷ�
			@Override
			public void mouseClicked(MouseEvent e) {
				String client_info = text_nickname.getText() + "/" + text_name.getText();

				try {

					if(!(text_ip.getText().equals("127.0.0.1"))) {
						JOptionPane.showMessageDialog(null, "ip�� ��Ȯ�� �Է����ּ���", "�г��� ��� �����޽���",
								JOptionPane.ERROR_MESSAGE);
						text_ip.setText("");
						text_portno.setText("");
					}else {
						s = new Socket(text_ip.getText(), Integer.parseInt(text_portno.getText()));
						dos = new DataOutputStream(s.getOutputStream());
						dis = new DataInputStream(s.getInputStream());
						dos.writeUTF(client_info);
						JOptionPane.showMessageDialog(null, "�г����� ��ϵǾ����ϴ�", "�г��� ��� Ȯ�θ޽���", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						setVisible(false);


						int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?", "���� Ȯ�� â", JOptionPane.YES_NO_OPTION);

						if(result == JOptionPane.CLOSED_OPTION)	{
							JOptionPane.showMessageDialog(null, "������ ��ҵǾ����ϴ�");
							dispose();
						}
						else if(result == JOptionPane.YES_OPTION)	{
							new ClientChat(dos,dis,text_nickname.getText()) ;
						} else	{
							JOptionPane.showMessageDialog(null, "������ ��ҵǾ����ϴ�");
							dispose();
						}
					}
				} catch (ConnectException | IllegalArgumentException   e1) {

					JOptionPane.showMessageDialog(null, "port�� ��Ȯ�� �Է����ּ���", "�г��� ��� �����޽���",
							JOptionPane.ERROR_MESSAGE);
					text_ip.setText("");
					text_portno.setText("");

				} catch (IOException e1) {
					e1.printStackTrace();
				}








			} 

		});
	}

}