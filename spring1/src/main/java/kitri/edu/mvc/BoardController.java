package kitri.edu.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController{
	
	@RequestMapping("/boardwrite")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", "글쓰기 화면입니다.");//모델 선정
		mav.setViewName("boardwrite"); //확장자는 뺌 - 뷰 선정	
		return mav;
		
	}
		
//	@Override
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		//모델(view에 출력할 데이터) 알려줌 : dao, vo 사용
//		//but, 실습에서는 간단하게 'hello message'문자열 출력하기
//		request.setAttribute("name", "글쓰기 화면입니다.");
//		
//		//view 알려줌(foward, include하지 않고 view가 누구인지만 알려줌)
////		String jspname = "boardwrite.jsp";
////		return jspname;
//		return "boardwrite.jsp";
//	}

}
