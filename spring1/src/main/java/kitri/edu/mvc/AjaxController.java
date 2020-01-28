package kitri.edu.mvc;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AjaxController {
	@RequestMapping(value = "/ajax/login", method = RequestMethod.GET )
	public String loginform() {
		return "ajax/loginform";
	}
	
	//nonajax형식일때 사용
//	@RequestMapping(value = "/ajax/login", method = RequestMethod.POST )
//	public ModelAndView loginresult(String id, String pw) {
//		//id, pw : hr 입력
//		ModelAndView mav = new ModelAndView();
//		if(id.equalsIgnoreCase("hr") && pw.equalsIgnoreCase("hr")) {
//			mav.addObject("result", "정상사용자입니다.");
//			mav.addObject("logintime",new Date().toLocaleString());
//		}
//		mav.setViewName("ajax/loginresult");
//		return mav;
//	}
	
	//ajax 형식으로 사용하기 위해서는 데이터가 json형태로 넘어가야함
	//jason형식은 X, String 타입으로 넘어옴
	@RequestMapping(value = "/ajax/login", method = RequestMethod.POST,
			produces = "application/json;charset=utf-8")
	//application/json; -> text/html;이 아니라 json형태이므로
	//produces : 강제적으로 바꿈
	@ResponseBody
	public String loginresult(String id, String pw) {
		//@RequestMapping만 있으면? String : 뷰 이름
		//순서 상관 없이 @RequsetMappgin, @ResponseBody가 같이 있으면?
		//String : 현재 요청한 뷰의 바디에 포함될 데이터
		//즉, json형태로 만들기
		//json은 모든 데이터 형태가 ""로 감싸져서 전달되게 되어 있음
		if(id.equalsIgnoreCase("hr") && pw.equalsIgnoreCase("hr")) {
		String time = new Date().toLocaleString();
		//return "{\"result\":\"ok\", \"logintime\":\"2020-01-17\"}";
		return "{\"result\":\"ok\", \"logintime\":\""+time+"\"}";
		}
		else {
			return "{\"result\":\"error\", \"logintime\":\"===\"}";
		}
	}
	
	@RequestMapping("/ajax/boardlist")
	//해당 url로 요청직접 하면? json형태로 데이터 바뀌어있는지 확인 가능
	@ResponseBody
	public ArrayList<BoardVO> getBoardList(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		list.add(new BoardVO(1,"제목1","내용1","kitri","2020-01-17",1111,0));
		list.add(new BoardVO(2,"제목2","내용2","kitri","2020-01-17",1111,0));
		list.add(new BoardVO(3,"제목3","내용3","kitri","2020-01-17",1111,0));
		list.add(new BoardVO(4,"제목4","내용4","kitri","2020-01-17",1111,0));
		list.add(new BoardVO(5,"제목5","내용5","kitri","2020-01-17",1111,0));
		return list;//내부적으로 json형태로 알아서 바뀜
	}
	
	@RequestMapping("/ajax/oneboard")
	@ResponseBody
	public BoardVO getOneBoardList(int seq){
		//게시물 리스트 5개에서 찾아서 하나 리턴
		BoardVO vo=null;
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		list.add(new BoardVO(1,"제목1","내용1","kitri","2020-01-17",1111,0));
		list.add(new BoardVO(2,"제목2","내용2","kitri","2020-01-17",1111,0));
		list.add(new BoardVO(3,"제목3","내용3","kitri","2020-01-17",1111,0));
		list.add(new BoardVO(4,"제목4","내용4","kitri","2020-01-17",1111,0));
		list.add(new BoardVO(5,"제목5","내용5","kitri","2020-01-17",1111,0));
		
		for(int i=0;i<list.size();i++) {
			if(seq == list.get(i).seq) vo = list.get(i);
		}	
		return vo;
	}

}






