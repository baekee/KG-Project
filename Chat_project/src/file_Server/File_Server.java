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
		System.out.println("파일서버 세팅완료");
		serverSocket.setSoTimeout(5000);
		
		Socket socket = serverSocket.accept();
		System.out.println("파일전송시작");
		FileInputStream fis = new FileInputStream(file);
		
		DataInputStream dis = new DataInputStream(fis);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		byte[] byteBae = new byte[(int)file.length()]; ////
		
		System.out.println("file ---> byte 중...");
		dis.readFully(byteBae); //파일내용-->바이트배열, 100byte를 2진수로 바꿔서 1000100100...
		
		/* 바이트단위 처리 함수  -- 에러 잘 안남
		 writeInt() : 4바이트확보한 다음 숫자 찍음, double은 8바이트
		 readInt() : 4바이트만큼 내용을 끄집어내서 그대로 읽음 
		 */
		
		//길이를 먼저 전송, 내용을 전송  //dos1은 통로 
		dos.writeInt(byteBae.length);
		dos.write(byteBae);
		System.out.println("파일 전송 완료");
		
		dos.close();
		dis.close();
		fis.close();
		socket.close();
		serverSocket.close();
		} catch (IOException e) {      
            e.printStackTrace();{
            	System.out.println("파일 전송 실패");
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
	System.out.println("파일 다운로드 시작");
	
	DataInputStream dis = new DataInputStream(socket.getInputStream());
	}
	public void run() {
		try {
			int len1 = dis.readInt();
			byte[] byteBae2 = new byte[len1];///////
			dis.readFully(byteBae2);
			
			FileOutputStream fos = new FileOutputStream("C:/");
			fos.write(byteBae2);
	
			System.out.println("파일 다운 완료");
		} catch(IOException e) {
			System.out.println("파일 전송 실패");
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
