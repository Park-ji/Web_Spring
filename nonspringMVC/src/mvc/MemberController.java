package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("inform", "회원 가입 후에 로그인 가능합니다.");
		return "member.jsp";
	}

}
