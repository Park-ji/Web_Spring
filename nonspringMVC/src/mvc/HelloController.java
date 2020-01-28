package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		//모델(view에 출력할 데이터) 알려줌 : dao, vo 사용
		//but, 실습에서는 간단하게 'hello message'문자열 출력하기
		request.setAttribute("model", "hello message");
		
		//view 알려줌(foward, include하지 않고 view가 누구인지만 알려줌)
		String jspname = "hello.jsp";
		return jspname;
	}
}
