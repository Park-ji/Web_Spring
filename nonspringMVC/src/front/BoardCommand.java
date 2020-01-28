package front;

public class BoardCommand implements Command {

	@Override
	public void print() {
		System.out.println("게시판은 글쓰기, 목록 보여주기로 구성됩니다.");	
	}

}
