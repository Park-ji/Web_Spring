package mybatis.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Service, @Repository, @Controller : @Component 효과 내장
@Repository
public class EmpDAO {

	@Autowired
	SqlSession session; // spring SqlSession 타입 객체 bean 생성 IOC
	// class SqlSession{} 에 @Component를 할 수 없기 때문에 Spring <bean>으로 객체 생성
	// EmpMybatidService에서 @Autowired로 EmpDAO 객체를 생성하는 것과 다름

	public List<EmpVO> getAllEmp() {
		List<EmpVO> list = session.selectList("emp.allemp");
		return list;
	}

	public EmpVO getOneEmp(int id) {
		return session.selectOne("emp.oneemp", id);
	}

	public List<EmpVO> getManyEmp(int id) {
		return session.selectList("emp.manyemp", id);
	}

	public void insertEmp(EmpVO vo) {
		session.insert("emp.insertemp", vo);
	}

	public void updateEmp(EmpVO vo) {
		session.update("emp.updateemp", vo);
	}

	public void deleteEmp(int id) {
		session.delete("emp.deleteemp", id);
	}

	public int selectEmpCount() { // 무슨 타입으로 리턴하냐. resultType 확인
		int i = session.selectOne("emp.empcnt");
		return i; // 파라미터 필요없음
	}

	public List<EmpVO> empPaging(int[] param) {
		List<EmpVO> list = session.selectList("emp.emppaging", param);// {41,50}
		return list;
	}

	public List<EmpVO> getEmpDeptid(ArrayList<Integer> dept_id) {
		List<EmpVO> list = session.selectList("emp.getdept_id", dept_id);
		return list;
	}

	public List<EmpVO> getEmpDynamicwhere(HashMap<String, String> map) {
		List<EmpVO> list = session.selectList("emp.empdynamic", map);
		return list;
	}

	public List<String> getJobId() {
		List<String> list = session.selectList("emp.getJobId");
		return list;
	}
	
	public List<Integer> getDeptId() {
		List<Integer> list = session.selectList("emp.getDeptId");
		return list;
	}
	
}
