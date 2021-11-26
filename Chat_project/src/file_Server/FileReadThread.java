package file_Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class FileReadThread extends Thread {

	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	FileInputStream fis;
	FileOutputStream fos;
	File path;
	

	public FileReadThread(Socket s, File path) {
		this.s = s;
		this.path = path;
	}
	
	public void run() {
		try {
			dis = new DataInputStream(s.getInputStream());
			fos = new FileOutputStream(path);
			
			while(true) {
				byte[] byteBae = new byte[(int)path.length()];

				dis.readFully(byteBae);
				dos.writeInt(byteBae.length); 
				dos.write(byteBae);

				System.out.println("업로드 완료");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
