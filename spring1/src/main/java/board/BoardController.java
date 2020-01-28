package board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Autowired
	BoardDAO dao;
	
	@RequestMapping(value="/write.board", method = RequestMethod.GET) //쓰기 폼만 보여주면 됨
	public ModelAndView writeBoard() {
		ModelAndView mav = new ModelAndView();
		//구현하시오.
		//1. model 없다
		//2. WEB-INF/views/board/writeform.jsp : 즉, board폴더 만들어서 작성
		//:title, contents, writer(foreign key 제약조건 있으므로 member테이블에 있는 것만 사용할 것) 
		//해당 입력 폼 : post방식으로 /write.board로 action
		//action할때 : /mvc/write.board
		mav.setViewName("board/writeform");
		return mav;
	}
	
	@RequestMapping(value="/write.board", method = RequestMethod.POST)
	public ModelAndView writeBoard(BoardVO vo) {
		ModelAndView mav = new ModelAndView();
		//구현하시오.
		//1. BoardVO 
		//: seq, title, contents, writer, time, password, viewcount
		//: getter, setter 메소드
		//:toString - 생성자 추가 정의 선택적
		//2. BoardDAO
		//: writeBoardSQL 또는 writeBoardDB등 이름 통일 - 이번 실습에서는 똑같이 사용
		//:writeBoard(BoardVO vo) : insert 구현
		//-> seq와, time은 sysdate, viewcount는 0
		//-> 즉, 입력받을 것은 title, contents, wrtier
		//3. model 없다
		//4. WEB-INF/views/board/list.jsp : 즉, board폴더 만들어서 작성
		System.out.println(vo.title);
		int result = dao.writeBoard(vo);
		System.out.println(result);
		ArrayList<BoardVO> list = dao.getBoardList();
		mav.addObject("list",list);
		mav.setViewName("board/list");
		return mav;
	}
	
	@RequestMapping("/list.board")
	public ModelAndView getBoardList() {
		ModelAndView mav = new ModelAndView();
		//구현하시오.
		//1. BoardDAO
		//:ArrayList<BoardVO> getBoardList() -> Board테이블의 모든 게시물 전체 가지고 오기 
		//2. model : getBoardList()리턴 결과 -> 모델의 이름은 마음대로 정하기
		//3. view : board/list.jsp
		//: 번호 제목 작성자
		//이때, 제목태그에 <a href="">로 링크 걸어주기
		//href경로 : /mvc/detail.board
		//이때, seq 변수 필요 => /mvc/detail.board?seq=2 등
		//즉, /mvc/detail.board?seq=번호
		ArrayList<BoardVO> list = dao.getBoardList();
		mav.addObject("list",list);
		mav.setViewName("board/list");
		return mav;
	}
	
	@RequestMapping("/detail.board")
	public ModelAndView getBoardDetail(int seq) {
		ModelAndView mav = new ModelAndView();
		//구현하시오.
		//1. BoardDAO
		//BoardVO getBoardDetail(int seq) : seq번호에 해당하는 board 게시물 1개
		//2. model : getBoardDeatil 리턴 결과
		//3. view : board/deatil.jsp
		//번호 :
		//제목:
		//작성자:
		//작성시간:
		//조회수:
		//내용:
		BoardVO vo = dao.getBoardDetail(seq);
		mav.addObject("vo",vo);
		mav.setViewName("board/detail");
		return mav;
	}

}




















