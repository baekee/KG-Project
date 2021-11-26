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

// 접속자수 입출력, 입출력 자체, 퇴장처리
class ServerClass {

	private ArrayList<ThreadServerClass> threadList = new ArrayList<ThreadServerClass>();
	Socket s1;
	private int Port_no_Client;

	private ServerStartGUI sg;
	public ServerSocket ss1;

	public ServerClass(int portno, ServerStartGUI sg) throws IOException, ClassNotFoundException, SQLException {

		this.sg = sg;
		ServerSocket ss1 = new ServerSocket(portno);

		System.out.println("서버가동.....");
		
		sg.setVisible(false);

		while (true) {
			s1 = ss1.accept();
			System.out.println("접속주소 : " + s1.getInetAddress() + ", 접속포트 : " + s1.getPort());
			ThreadServerClass tServer1 = new ThreadServerClass(s1);
			tServer1.start();
			threadList.add(tServer1);

			System.out.println("접속자 수 : " + threadList.size() + " 명");

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
				if (inputStream != null) { // 전체회원에게 지금 들어온 별명을 보내기 위한 작업
					msg = inputStream.readUTF();
					String[] info = msg.split("/");

					vo.setIpno(s1.getInetAddress().toString());
					vo.setPortno(s1.getPort());
					vo.setNickname(info[0]);
					vo.setName(info[1]);

					boolean result = dao.insert(vo);

					if (result) {
						System.out.println("insert 성공");
					}

					String whisper_nickname = info[0];
					for (int i = 0; i < threadList.size(); i++) {
						if (s1.equals(threadList.get(i).s1)) {
							threadList.get(i).nickname = whisper_nickname;
						}
					}
					sendChat(info[0] + " 님이 입장하셨습니다.");

				}

				while (inputStream != null) {
					String whispercheck = inputStream.readUTF();
					if (whispercheck.contains("/w ")) { // 채팅 메세지가 귓속말인지 판별하는 부분
						String[] sp1 = whispercheck.split("/w ");
						String[] sp2 = sp1[1].split(" ");
						whisperChat(whispercheck, sp2[0]);
					} else {
						sendChat(whispercheck);
					}
				}
			} catch (IOException | SQLException e) {
				// e.printStackTrace();
				// ㄴ> 채팅 시에는 오류 메세지가 채팅에 출력되어서 출력되지 않게 하는게 화면 구성상 유리하다
			} finally {
				for (int i = 0; i < threadList.size(); i++) {
					if (s1.equals(threadList.get(i).s1)) { // 전체회원에게 퇴장한 회원을 알리기 위한 작업
						threadList.remove(i);
						try {
							sendChat(nickname + " 님이 퇴장하셨습니다.");
						} catch (IOException e) {
							// e.printStackTrace();
						}
					}
				}
				System.out.println("접속자 수 : " + threadList.size() + " 명");

				
				  if(threadList.size() == 0) {
				  
				  System.exit(0);
				
				  }
				 

			}
		}

		// 전체에게 보내기 함수
		public void sendChat(String chat) throws IOException {
			for (int i = 0; i < threadList.size(); i++) {
				threadList.get(i).outputStream.writeUTF(chat);
			}
		}

		// 귓속말 보내기 함수
		public void whisperChat(String chat, String sp) throws IOException {
			for (int i = 0; i < threadList.size(); i++) {
				if (sp.equals(threadList.get(i).nickname) || s1.equals(threadList.get(i).s1)) {
					// ↑ 귓속말 받는 사람 조건 ↑ 귓속말 보내는 사람 조건
					chat = chat.replace("/w " + sp + " ", sp + "님에게만 ");
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
