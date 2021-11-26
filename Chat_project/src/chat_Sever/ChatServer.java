package chat_Sever;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import chat_model.ChatDAO;
import chat_model.ChatVO;

// �����ڼ� �����, ����� ��ü, ����ó��
class ServerClass {

	private ArrayList<ThreadServerClass> threadList = new ArrayList<ThreadServerClass>();
	Socket s1;
	private int Port_no_Client;

	private ServerStartGUI sg;
	public ServerSocket ss1;

	public ServerClass(int portno, ServerStartGUI sg) throws IOException, ClassNotFoundException, SQLException {

		this.sg = sg;
		ServerSocket ss1 = new ServerSocket(portno);

		System.out.println("��������.....");
		
		sg.setVisible(false);

		while (true) {
			s1 = ss1.accept();
			System.out.println("�����ּ� : " + s1.getInetAddress() + ", ������Ʈ : " + s1.getPort());
			ThreadServerClass tServer1 = new ThreadServerClass(s1);
			tServer1.start();
			threadList.add(tServer1);

			System.out.println("������ �� : " + threadList.size() + " ��");

		}
	}

	class ThreadServerClass extends Thread {

		Socket s1;
		String msg;
		ChatVO vo;
		ChatDAO dao;
		String nickname;
		DataInputStream inputStream;
		DataOutputStream outputStream;

		public ThreadServerClass(Socket s1) throws IOException, ClassNotFoundException, SQLException {
			this.s1 = s1;
			vo = new ChatVO();
			dao = new ChatDAO();
			inputStream = new DataInputStream(s1.getInputStream());
			outputStream = new DataOutputStream(s1.getOutputStream());
			nickname = "";
		}

		@SuppressWarnings("deprecation")
		public void run() {

			try {
				if (inputStream != null) { // ��üȸ������ ���� ���� ������ ������ ���� �۾�
					msg = inputStream.readUTF();
					String[] info = msg.split("/");

					vo.setIpno(s1.getInetAddress().toString());
					vo.setPortno(s1.getPort());
					vo.setNickname(info[0]);
					vo.setName(info[1]);

					boolean result = dao.insert(vo);

					if (result) {
						System.out.println("insert ����");
					}

					String whisper_nickname = info[0];
					for (int i = 0; i < threadList.size(); i++) {
						if (s1.equals(threadList.get(i).s1)) {
							threadList.get(i).nickname = whisper_nickname;
						}
					}
					sendChat(info[0] + " ���� �����ϼ̽��ϴ�.");

				}

				while (inputStream != null) {
					String whispercheck = inputStream.readUTF();
					if (whispercheck.contains("/w ")) { // ä�� �޼����� �ӼӸ����� �Ǻ��ϴ� �κ�
						String[] sp1 = whispercheck.split("/w ");
						String[] sp2 = sp1[1].split(" ");
						whisperChat(whispercheck, sp2[0]);
					} else {
						sendChat(whispercheck);
					}
				}
			} catch (IOException | SQLException e) {
				// e.printStackTrace();
				// ��> ä�� �ÿ��� ���� �޼����� ä�ÿ� ��µǾ ��µ��� �ʰ� �ϴ°� ȭ�� ������ �����ϴ�
			} finally {
				for (int i = 0; i < threadList.size(); i++) {
					if (s1.equals(threadList.get(i).s1)) { // ��üȸ������ ������ ȸ���� �˸��� ���� �۾�
						threadList.remove(i);
						try {
							sendChat(nickname + " ���� �����ϼ̽��ϴ�.");
						} catch (IOException e) {
							// e.printStackTrace();
						}
					}
				}
				System.out.println("������ �� : " + threadList.size() + " ��");

				
				  if(threadList.size() == 0) {
				  
				  System.exit(0);
				
				  }
				 

			}
		}

		// ��ü���� ������ �Լ�
		public void sendChat(String chat) throws IOException {
			for (int i = 0; i < threadList.size(); i++) {
				threadList.get(i).outputStream.writeUTF(chat);
			}
		}

		// �ӼӸ� ������ �Լ�
		public void whisperChat(String chat, String sp) throws IOException {
			for (int i = 0; i < threadList.size(); i++) {
				if (sp.equals(threadList.get(i).nickname) || s1.equals(threadList.get(i).s1)) {
					// �� �ӼӸ� �޴� ��� ���� �� �ӼӸ� ������ ��� ����
					chat = chat.replace("/w " + sp + " ", sp + "�Կ��Ը� ");
					threadList.get(i).outputStream.writeUTF(chat);
				}
			}
		}

	}
}

public class ChatServer {

	private int port;
	private ServerStartGUI sg;

	public ChatServer(int port, ServerStartGUI sg) throws ClassNotFoundException, IOException, SQLException {
		this.port = port;
		this.sg = sg;
		new ServerClass(port, sg);
	}

}
