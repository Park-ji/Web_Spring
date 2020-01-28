package kitri.edu.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	//@RequestMapping("/loginform")
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginform() {
		ModelAndView mav = new ModelAndView();
		//mav.addObject(attributeValue); -> 필요 X
		mav.setViewName("loginform");
		return mav;
	}//end loginform
	
	//@RequestMapping("/loginresult")
//	@RequestMapping(value = "/login", method = RequestMethod.POST)//암호 포함되어있을때는 POST방식 권장
//	public ModelAndView loginresult(@RequestParam(value="id1", required=false, defaultValue="kitri") String id, String pw) {
//		
////		//test 1 : id, pw 입력 값 읽어와서 구현
////		//사용자가 loginform에서 id, pw입력하면 입력된 값을 체크해서 구현
////		//값을 받아와야하므로 : HttpServletRequest 매개변수 필요
////		String id = request.getParameter("id");
////		String pw = request.getParameter("pw");
//	
//		//test 2 : String 타입 요청파라미터명 동일 이름 매개변수
//		//매개변수가 String id, String pw일때
//		//View에서 <input name="id" ..처럼 변수명과 똑같이 주기
//		//확인 : System.out.println(id+", "+pw);
//		//요청 파라미터(input 태그의 name 속성)의 이름과 같은 이름의 String타입 매개변수를 선언하면? 자동으로 값을 읽어와서 저장함
//		
//		//test 3 : annotation 사용
//		
//		ModelAndView mav = new ModelAndView();
//		
//		if(id.equals("hr")) {
//			if(pw.equals("hr")) { //정상 로그인
//				mav.addObject("result","님 : 정상 로그인 사용자입니다.");
//			}
//			else { //암호가 맞지 않는 경우
//				mav.addObject("result","님 : 암호를 확인하세요.");
//			}
//		}
//		else { //아이디가 없는 경우
//			mav.addObject("result","님 : 새로 회원가입하세요.");
//		}
//		mav.setViewName("loginresult"); //forward하고 있음
//		return mav;		
//	}//end loginresult
	
	//test 4
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginresult(/* @ModelAttribute("model") */ LoginVO vo) {
		ModelAndView mav = new ModelAndView();
		
		//@ModelAttribute("model") LoginVO vo -> 아래 3문장과 같은 효과
//		vo.setId(request.getParmeter("id"));
//		vo.setPw(request.getParmeter("pw"));
//		mav.addObject("model",vo);
		//그렇다면 현재 vo에는 id와 pw값이 들어가 있음
		
		//@ModelAttribute("model")를 생략하고 LoginVO vo 만 사용하면?
//		vo.setId(request.getParmeter("id"));
//		vo.setPw(request.getParmeter("pw"));
//		mav.addObject("loginVO",vo); -> 이름이 자동으로 객체클래스 이름과 같아지는데 앞의 한문자는 소문자로 바뀜
		//즉, @ModelAttribute("model") 없어도 ok
		
			
		if(vo.getId().equals("hr")) {
			if(vo.getPw().equals("hr")) { //정상 로그인
				mav.addObject("result","님 : 정상 로그인 사용자입니다.");
			}
			else { //암호가 맞지 않는 경우
				mav.addObject("result","님 : 암호를 확인하세요.");
			}
		}
		else { //아이디가 없는 경우
			mav.addObject("result","님 : 새로 회원가입하세요.");
		}
		mav.setViewName("loginresult"); //forward하고 있음
		return mav;		
	}//end loginresult
	
}//end LoginController


















