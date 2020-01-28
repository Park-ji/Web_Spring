package member;

public class MemberVO {
	String id, name;
	
	public MemberVO() {	}
	//<jsp:useBean id="a" class="memberVO"
	//<beans:bean id="a" class="MemberVO"
	//@Component
	//위의 동작에서 기본생성자가 쓰임
	//따라서, 사용자 정의 생성자를 만들때, 기본 생성자를 반드시 같이 정의 해줘야함!
	public MemberVO(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//toString메소드 Override 내용은 이클립스에서 미리 선언해놓음
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + "]";
	}
	
	

}
