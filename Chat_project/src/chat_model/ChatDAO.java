package chat_model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChatDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ChatDAO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
	}
	
	// getAllChat_VO
	public ArrayList<ChatVO> getAllChat_VO() throws SQLException{
		ArrayList<ChatVO> ctarray = new ArrayList<ChatVO>();
		
		String sql = "SELECT * FROM chat_member OREDR BY num";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			ChatVO vo = new ChatVO(
					rs.getInt("mem_num"),
					rs.getString("ip_no"),
					rs.getInt("port_no"),
					rs.getString("nickname"),
					rs.getString("mem_name"),
					rs.getDate("mem_date")
					);
			ctarray.add(vo);
		}
		
		return ctarray;
	}
	// insert
	public boolean insert(ChatVO vo) throws SQLException {
		String sql = "INSERT INTO chat_member(num, ip_no, port_no, nickname, name)"
				+ " VAlUES(num_seq.NEXTVAL,?,?,?,?)";
		
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setString(1, vo.getIpno());
		pstmt.setInt(2, vo.getPortno());
		pstmt.setString(3, vo.getNickname());
		pstmt.setString(4, vo.getName());
		
		int result = pstmt.executeUpdate();
		 
		if(result == 0) {
			System.out.println("insert ½ÇÆÐ");
			return false;
		}
		return true;
	}
	// delete
	public void delete(int portno) {
		
	}

	
}
	
