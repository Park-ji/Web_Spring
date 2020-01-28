package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardMybatisService implements BoardService {
	
	@Autowired
	BoardMybatisDAO dao;

	@Override
	public List<BoardVO> getAllBoard() {
		return dao.getAllBoard();
	}
	
	@Override
	public BoardVO getOneBoard(int seq) {
		return dao.getOneBoard(seq);
	}



	@Override
	public void addViewCount(int seq) {
		dao.addViewCount(seq);
	}



	@Override
	public int selectBoardCount() {
		int allcnt = dao.selectBoardCount();
		return allcnt;
	}

	@Override
	public List<BoardVO> boardPaging(int[] param) {
		List<BoardVO> list = dao.boardPaging(param);
		return list;
	}

	@Override
	public void deleteBoard(int seq) {
		dao.deleteBoard(seq);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		dao.updateBoard(vo);
	}

	
	@Override
	public void insertBoard(BoardVO vo) {
		dao.insertBoard(vo);
		
	}

	@Override
	public int selectCheckMem(String writer) {
		return dao.selectCheckMem(writer);
	}

}
