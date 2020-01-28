package mybatis.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmpMybatisController {

	@Autowired
	EmpService service;

	// employees 모든 레코드 조회 - View : myBatis/emplist.jsp
	@RequestMapping("/mybatis/emplist")
	public ModelAndView getEmpList() { // url과 같으면 void

		ModelAndView mav = new ModelAndView();

		List<EmpVO> list = service.getAllEmp();

		mav.addObject("emplist", list);
		mav.setViewName("mybatis/empList");

		return mav;
	}

	@RequestMapping(value = "/mybatis/insertemp", method = RequestMethod.GET)
	public ModelAndView insertEmp() {
		// 1. jobs 테이블 모든 job_id 조회 : List<String>
		// 2. "model", list
		// 3. View : myBatis/insertEmpForm.jsp
		// 4. 직종코드 : <select> <option> 태그 출력하여 선택
		
		ModelAndView mav = new ModelAndView();
		
		List<String> jobIdList = service.getJobId();
		List<Integer> deptIdList = service.getDeptId();
		
		mav.addObject("jobIdList", jobIdList);
		mav.addObject("deptIdList", deptIdList);
		
		mav.setViewName("mybatis/insertEmpForm");
		
		return mav;
	}
	
	@RequestMapping(value = "/mybatis/insertemp", method = RequestMethod.POST)
	public String insertEmpProcess(EmpVO vo) {
		// 사번(Not Null, Unique), 이름, 성, 입사일, 이메일(Unique), 직종코드(fk), 부서번호(fk)
		service.insertEmp(vo);
		return "mybatis/insertEmpSuccess";
	}
}
