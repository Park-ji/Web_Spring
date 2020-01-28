package front;

public class MemberCommand implements Command {

	@Override
	public void print() {
		System.out.println("회원은 가입후에 로그인 가능합니다.");
	}

}
