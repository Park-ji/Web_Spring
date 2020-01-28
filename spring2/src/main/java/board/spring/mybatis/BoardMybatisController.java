package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardMybatisController {

	@Autowired
	BoardService service;

	@RequestMapping("/boardpaginglist")
	public ModelAndView getBoardList(
			@RequestParam(value = "pagenum", required = false, defaultValue = "1") int pagenum) {
		//페이징 처리 = pagenum에 해당하는 게시물 5개
		//pagenum=2? 6(5*(pagenum-1) + 1 ~ 10(5*pagenum)의 게시물만 보임
		ModelAndView mav = new ModelAndView();
		int startpagenum = 5 * (pagenum -1);
		int endpagenum = 5 * pagenum;
		int param[] = {startpagenum, endpagenum};
		//int allcnt = service.selectBoardCount(); // board 테이블 게시물 전체 갯수
		//List<BoardVO> list = service.getAllBoard(); //board 테이블 전체 게시물 조회
		List<BoardVO> list = service.boardPaging(param);
		mav.addObject("boardlist", list);
		mav.setViewName("board/boardList");
		return mav;
	}

	@RequestMapping("/boarddetail")
	public ModelAndView getBoarddetail(int seq) {
		ModelAndView mav = new ModelAndView();
		service.addViewCount(seq);
		BoardVO vo = service.getOneBoard(seq);
		mav.addObject("boarddetail", vo);
		mav.setViewName("board/boardDetail");
		return mav;
	}
	
	@RequestMapping(value="/boardwrite", method = RequestMethod.GET)
	public String writeBoard() {
		return "/board/boardWrite";
	}
	
	@RequestMapping(value="/boardwrite", method = RequestMethod.POST)
	public ModelAndView insertBoard(BoardVO vo) {
		ModelAndView mav = new ModelAndView();
		int result = service.selectCheckMem(vo.getWriter());
		if(result != 1) mav.setViewName("board/memberInsert");
		else {
			service.insertBoard(vo);
			mav.setViewName("board/boardWriteSuccess");
		}
		return mav;
	}
	

	@RequestMapping(value = "/boardupdate", method = RequestMethod.GET)
	public ModelAndView getBoardContent(int seq) {
		ModelAndView mav = new ModelAndView();
		BoardVO vo = service.getOneBoard(seq);
		mav.addObject("boarddetail",vo);
		mav.setViewName("/board/boardUpdate");	
		return mav;
	}

	@RequestMapping(value = "/boardupdate", method = RequestMethod.POST)
	public String updateBoardContent(String title, String contents, int seq) {
		BoardVO vo = service.getOneBoard(seq);
		vo.setTitle(title);
		vo.setContents(contents);
		service.updateBoard(vo);
		return "/board/boardUpdateSuccess";
	}

	@RequestMapping("/boarddelete")
	public String deleteBoardContent(int seq) {
		service.deleteBoard(seq);
		return "/board/boardDelete";
	}
	
	

}
