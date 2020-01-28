package mybatis;

import java.util.List;
import org.apache.ibatis.session.SqlSession;

//직접 db 접근하는 객체
//기존의 연결방식 : JDBC
//현재 연결방식 : Mybatis
public class EmpDAO {
	
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<EmpVO> getAllEmp(){
		
		List<EmpVO> list = session.selectList("emp.allemp");
		for(EmpVO vo : list) {
			System.out.println(vo);
		}
		return list;
	}
	
	public EmpVO getOneEmp(int id) {
		//매개변수로 id넘김
		return session.selectOne("emp.oneemp", id);
	}
	
	public List<EmpVO> getManyEmp(int id){
		return session.selectList("emp.manyemp", id);
	}
	
	public void insertEmp(EmpVO vo) {
		session.insert("emp.insertemp", vo);
	}
	
	public void updateEmp(EmpVO vo) {
		session.update("emp.updateemp",vo);
	}
	public void deleteEmp(int id) {
		session.delete("emp.deleteemp",id);
	}
	//DAO에서 메소드 하나 = sql문 하나
	public void deleteHistory(int id) {
		session.delete("emp.deletehistory",id);
	}

}
















