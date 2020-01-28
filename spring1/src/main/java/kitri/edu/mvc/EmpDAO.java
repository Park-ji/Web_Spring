package kitri.edu.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository //이름 따로 안주면? 클래스명과 동일(하지만, 맨 앞 문자만 소문자로 바뀜)
public class EmpDAO{
	
	public ArrayList<EmpVO> getBoardList(){ //전체 게시물 조회
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
		String sql = "select employee_id, first_name, last_name, salary, to_char(hire_date, 'YYYY/MM/DD') as hire_date from employees";
		//last_name ||','||first_name as name
		PreparedStatement pt = con.prepareStatement(sql);
		ResultSet rs =  pt.executeQuery();
		while(rs.next()) {
			EmpVO vo = new EmpVO();
			vo.setId(rs.getInt("employee_id"));
			vo.setName(rs.getString("first_name")+rs.getString("last_name"));
			vo.setSalary(rs.getDouble("salary"));
			vo.setHiredate(rs.getString("hire_date"));
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

}
