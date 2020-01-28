package kitri.edu.mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller //<annotation-driven/> 필요
public class EmpController {
	
	@Autowired
	EmpDAO dao; 
	//<beans:bean/> 태그 생성 또는 @Repository
	//<context:component-scan base package="kitri.edu.mvc"/> 필요
	
	@RequestMapping("/emp.spring")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		ModelAndView mav = new ModelAndView();
		//ArrayList<EmpVO> list = new EmpDAO().getBoardList();
		ArrayList<EmpVO> list = dao.getBoardList();
		mav.addObject("list", list);//모델 선정
		mav.setViewName("emplist"); //확장자는 뺌 - 뷰 선정	
		return mav;
		
	}

}
