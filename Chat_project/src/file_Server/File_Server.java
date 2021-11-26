package file_Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class File_Server extends Thread {
	
	File file;
	public File_Server() {
	}
	
	public File_Server(File file) {
		this.file=file;
	}
	
	public void run() {
		try {
		ServerSocket serverSocket = new ServerSocket(9990);
		System.out.println("���ϼ��� ���ÿϷ�");
		serverSocket.setSoTimeout(5000);
		
		Socket socket = serverSocket.accept();
		System.out.println("�������۽���");
		FileInputStream fis = new FileInputStream(file);
		
		DataInputStream dis = new DataInputStream(fis);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		byte[] byteBae = new byte[(int)file.length()]; ////
		
		System.out.println("file ---> byte ��...");
		dis.readFully(byteBae); //���ϳ���-->����Ʈ�迭, 100byte�� 2������ �ٲ㼭 1000100100...
		
		/* ����Ʈ���� ó�� �Լ�  -- ���� �� �ȳ�
		 writeInt() : 4����ƮȮ���� ���� ���� ����, double�� 8����Ʈ
		 readInt() : 4����Ʈ��ŭ ������ ������� �״�� ���� 
		 */
		
		//���̸� ���� ����, ������ ����  //dos1�� ��� 
		dos.writeInt(byteBae.length);
		dos.write(byteBae);
		System.out.println("���� ���� �Ϸ�");
		
		dos.close();
		dis.close();
		fis.close();
		socket.close();
		serverSocket.close();
		} catch (IOException e) {      
            e.printStackTrace();{
            	System.out.println("���� ���� ����");
            }
		}
	}
}
class ThreadFile extends Thread {

	Socket socket;
	FileInputStream fis;
	FileOutputStream fos;
	File file;
	DataOutputStream dos;
	DataInputStream dis;
	
	public ThreadFile() {}
	
	public ThreadFile(String ip,File file) throws IOException {
	this.file=file;
	socket = new Socket(ip,9990);
	System.out.println("���� �ٿ�ε� ����");
	
	DataInputStream dis = new DataInputStream(socket.getInputStream());
	}
	public void run() {
		try {
			int len1 = dis.readInt();
			byte[] byteBae2 = new byte[len1];///////
			dis.readFully(byteBae2);
			
			FileOutputStream fos = new FileOutputStream("C:/");
			fos.write(byteBae2);
	
			System.out.println("���� �ٿ� �Ϸ�");
		} catch(IOException e) {
			System.out.println("���� ���� ����");
		} finally {
			try {
				dis.close();
				dos.close();
				fos.close();
				fis.close();
				socket.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
