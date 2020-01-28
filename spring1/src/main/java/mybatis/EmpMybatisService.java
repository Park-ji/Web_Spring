package mybatis;

import java.util.List;

public class EmpMybatisService implements EmpService {

	EmpDAO dao;
	
	public void setDao(EmpDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<EmpVO> getAllEmp() {
		return dao.getAllEmp();
	}
	
	@Override
	public EmpVO getOneEmp(int id) {
		return dao.getOneEmp(id);
	}

	@Override
	public List<EmpVO> getManyEmp(int id) {
		return dao.getManyEmp(id);
	}

	@Override
	public void insertEmp(EmpVO vo) {
		dao.insertEmp(vo);
	}

	@Override
	public void updateEmp(EmpVO vo) {
		dao.updateEmp(vo);
	}

	@Override
	public void deleteEmp(int id) {
		//참조관계 생각 잘하기!
		dao.deleteHistory(id); //history 먼저 삭제
		dao.deleteEmp(id);
	}

}
