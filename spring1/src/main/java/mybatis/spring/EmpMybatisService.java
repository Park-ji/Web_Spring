package mybatis.spring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpMybatisService implements EmpService {

	@Autowired
	EmpDAO dao;

	@Override
	public List<EmpVO> getAllEmp() {

		return dao.getAllEmp();
	}

	@Override
	public EmpVO getOneEmp(int id) {// 100
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
		dao.deleteEmp(id);

	}

	@Override
	public int selectEmpCount() {
		int allcnt = dao.selectEmpCount();
		return allcnt;
	}

	@Override
	public List<EmpVO> empPaging(int[] param) {
		List<EmpVO> list = dao.empPaging(param);
		return list;
	}

	@Override
	public List<EmpVO> getEmpDeptid(ArrayList<Integer> dept_id) {
		List<EmpVO> list = dao.getEmpDeptid(dept_id);
		return list;
	}

	@Override
	public List<EmpVO> getEmpDynamicwhere(HashMap<String, String> map) {
		return dao.getEmpDynamicwhere(map);

	}
	
	@Override
	public List<String> getJobId() {
		return dao.getJobId();
	}

	@Override
	public List<Integer> getDeptId() {
		// TODO Auto-generated method stub
		return dao.getDeptId();
	}

}
