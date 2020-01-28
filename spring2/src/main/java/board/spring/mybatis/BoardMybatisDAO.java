package board.spring.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardMybatisDAO {
	
	@Autowired
	SqlSession session;
	
	public List<BoardVO> getAllBoard(){
		List<BoardVO> list = session.selectList("board.allboard");
		return list;
	}
	
	public BoardVO getOneBoard(int seq) {
		BoardVO vo = session.selectOne("board.oneboard", seq);
		return vo;
	}
	
	public void addViewCount(int seq) {
		session.update("board.addviewcount", seq);
	}
	
	public int selectBoardCount() {
		int i = session.selectOne("board.boardcnt");
		return i;
	}
	
	public List<BoardVO> boardPaging(int[] param){
		List<BoardVO> list = session.selectList("board.boardpaging",param);
		return list;
	}
	
	public void deleteBoard(int seq) {
		session.delete("board.boarddelete", seq);
	}
	
	public void updateBoard(BoardVO vo) {
		session.update("board.updateboard", vo);
	}
	
	public void insertBoard(BoardVO vo) {
		session.insert("board.insertboard",vo);
	}
	
	public int selectCheckMem(String writer) {
		int result = session.selectOne("board.checkmem", writer);
		return result;
	}

}
