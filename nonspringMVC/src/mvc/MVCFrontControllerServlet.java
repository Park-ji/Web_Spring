package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MVCFrontControllerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getCharacterEncoding());//필터 동작 잘하는지 확인
		//1. *.mvc 모든 요청 받아라
		String uri = request.getRequestURI();
		String[] uris = uri.split("/");
		String result = uris[uris.length-1];
		
		//2. uri - controller 매핑 클래스 정의
		//"hello.mvc" = HelloController 호출
		//즉, xxx.mvc = xxxController 호출
		//하지만 개수가 많아질수록 if-else 조건문 너무 길어지므로 2번의 과정 사용!
		HandlerMapping mapping = new HandlerMapping();
		//boardwrite 요청 = BoardController 호출
		//member.front 요청 = MemberController 호출
		
		//3. 분석 - 적절한 controller 시켜라
		Controller controller = mapping.getController(result);	
		//4. Model - 여기서 만들 필요 X (이유? 위에서 선정한 Controller에서 만듦)
		//또한, 선정된 Controller에서 뷰 선정해서 이름 리턴함
		
		//5. View 선택
		String jspname = controller.handleRequest(request, response);
		
		//6. View 브라우저 출력 forward
		RequestDispatcher rd = request.getRequestDispatcher(jspname);
		// /a.jsp? http:ip:port/컨텍스트명/a.jsp
		//  a.jsp? /컨텍스트명/hello.mvc를 호출한 곳과 같은 경로 = 현재 경로
		//즉, 지금은 /a.jsp 와 a.jsp는 같은 경로를 의미함
		rd.forward(request, response);		
	}

}
