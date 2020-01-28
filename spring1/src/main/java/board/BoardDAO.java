package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	public int writeBoard(BoardVO vo) {
		int rs=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
			String sql = "insert into board values((select max(seq)+1 from board), ?, ?, ?, sysdate, ?, 0)";
			//last_name ||','||first_name as name
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, vo.getTitle());
			pt.setString(2, vo.getContents());
			pt.setString(3, vo.getWriter());
			pt.setInt(4, vo.getPassword());
			
			rs = pt.executeUpdate();
			if(rs==1) System.out.println("insert 성공");
			
			pt.close();
			con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		return rs;
	}
	
	public ArrayList<BoardVO> getBoardList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
		String sql = "select * from board";
		//last_name ||','||first_name as name
		PreparedStatement pt = con.prepareStatement(sql);
		ResultSet rs =  pt.executeQuery();
		while(rs.next()) {
			BoardVO vo = new BoardVO();
			vo.setSeq(rs.getInt("seq"));
			vo.setTitle(rs.getString("title"));
			vo.setContents(rs.getString("contents"));
			vo.setWriter(rs.getString("writer"));
			vo.setTime(rs.getDate("time").toString());
			vo.setPassword(rs.getInt("password"));
			vo.setViewcount(rs.getInt("viewcount"));
			list.add(vo);
		}
		rs.close();
		pt.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public BoardVO getBoardDetail(int seq) {
		BoardVO vo = new BoardVO();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
			String sql = "select * from board where seq= ?";
			//last_name ||','||first_name as name
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setInt(1, seq);
			ResultSet rs =  pt.executeQuery();			
			while(rs.next()) {
				vo.setSeq(rs.getInt("seq"));
				vo.setTitle(rs.getString("title"));
				vo.setContents(rs.getString("contents"));
				vo.setWriter(rs.getString("writer"));
				vo.setTime(rs.getDate("time").toString());
				vo.setPassword(rs.getInt("password"));
				vo.setViewcount(rs.getInt("viewcount"));
			}
			rs.close();
			pt.close();
			con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			return vo;		
	}

}
