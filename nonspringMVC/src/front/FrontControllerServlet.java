package front;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontControllerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 정보 : request
		System.out.println(request.getRequestURI());//콘솔 출력 O, 브라우져 출력 X
		
		//[실습]
		//1. Command 형식
		//Command 인터페이스 : print();
		//hello.front --- HelloCommand : hello 콘솔 출력
		//board.front --- BoardCommand : 게시판은 글쓰기, 목록 보여주기로 구성됩니다.
		//member.front --- MemberCommand : 회원은 가입후에 로그인 가능합니다.
		
		//2. Front Controller + Command Factory 연결
		CommandFactory factory = new CommandFactory();
		Command com = factory.getCommand(request.getRequestURI());
		if(com!=null) com.print();
		
		//3. Front Controller + MVC 패턴 연결
		
	}

}













