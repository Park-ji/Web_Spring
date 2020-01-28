package mybatis.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//@Service : 객체를 만드는 것이기 때문에 interface에는 붙일 수 없음
public interface EmpService {
	// 모든 사언 조회 서비스
	public List<EmpVO> getAllEmp();

	// 한개 사원 조회 서비스
	public EmpVO getOneEmp(int id);

	// 특정 사원 조회 서비스
	public List<EmpVO> getManyEmp(int id);

	// 특정 사원 등록
	public void insertEmp(EmpVO vo);

	// 정보 업데이트
	public void updateEmp(EmpVO vo);

	// 정보 삭제
	public void deleteEmp(int id);

	// 총 사원 수
	public int selectEmpCount();

	// 페이징처리 조회 서비스
	public List<EmpVO> empPaging(int[] param);

	// 부서코드 조건조회 서비스
	public List<EmpVO> getEmpDeptid(ArrayList<Integer> dept_id);

	// ${}, #{} 사용한 조회 서비스
	public List<EmpVO> getEmpDynamicwhere(HashMap<String, String> map);

	// jobs Table job_id 조회 서비스
	public List<String> getJobId();
	
	// departments Table department_id 조회 서비스
	public List<Integer> getDeptId();
}
