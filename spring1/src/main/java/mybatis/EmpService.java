package mybatis;

import java.util.List;

public interface EmpService {
	//모든 사원 조회 서비스
	public List<EmpVO> getAllEmp();
	//특정 사번 사원 조회 서비스
	public EmpVO getOneEmp(int id);
	//특정 사번 사원 여러명 조회 서비스
	public List<EmpVO> getManyEmp(int id);
	//신입 사원 등록 서비스
	public void insertEmp(EmpVO vo);
	//사원 수정 서비스
	public void updateEmp(EmpVO vo);
	//특정 사번 사원 퇴사 서비스
	public void deleteEmp(int id);
}
