package mvc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EmpController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		ModelAndView mav = new ModelAndView();
		
		ApplicationContext factory = new ClassPathXmlApplicationContext("mvc/emp.xml");
		EmpDAO dao = factory.getBean("dao",EmpDAO.class);	
		//ArrayList<EmpVO> list = new EmpDAO().getBoardList();
		ArrayList<EmpVO> list = dao.getBoardList();
		mav.addObject("list", list);//모델 선정
		mav.setViewName("emplist"); //확장자는 뺌 - 뷰 선정	
		return mav;
		
	}

}
