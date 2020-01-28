package kitri.edu.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MemberController {

	@RequestMapping("/member.front")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		
		ModelAndView mav = new ModelAndView();
		// request.setAttribute("inform", "회원 가입 후에 로그인 가능합니다.");
		mav.addObject("inform", "회원 가입 후에 로그인 가능합니다.");//모델 선정
		mav.addObject("id","member");//addObject는 여러번 사용 가능
		//	return "member.jsp";
		mav.setViewName("member"); //확장자는 뺌	- 뷰 선정	
		return mav;
		
	}
		
//	@Override
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		request.setAttribute("inform", "회원 가입 후에 로그인 가능합니다.");
//		return "member.jsp";
//	}

}
