package board.spring.mybatis;

import java.util.List;

public interface BoardService {
	
	public List<BoardVO> getAllBoard();
	public BoardVO getOneBoard(int seq);
	public void addViewCount(int seq);
	public void deleteBoard(int seq);
	public int selectBoardCount();
	public List<BoardVO> boardPaging(int[] param);
	public void updateBoard(BoardVO vo);
	public void insertBoard(BoardVO vo);
	public int selectCheckMem(String writer);

}
