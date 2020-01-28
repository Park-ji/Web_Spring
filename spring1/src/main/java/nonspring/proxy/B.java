package nonspring.proxy;

public class B implements ProxyInterface {
	//B는? 어떤 객체의 핵심기능과 B의 기능(공통관심)을 같이 연결해서 보여줌
	
	ProxyInterface pi; //자기자신이 상속받은 인터페이스 타입의 객체 변수를 만듦
	//pi는 A든 B든 C든 모든 클래스가 전달받아질수 있음!
	
	public void setProxyInterface(ProxyInterface pi) { //ProxyInterface 타입의 객체를 외부에서 전달받음
		this.pi = pi;
	}

	@Override
	public void action() {
		//1. 핵심관심 앞에 Pointcut 잡은 경우
		System.out.println("B 클래스의 action() 수행중1"); //B의 action 수행(공통관심)
		//2. 핵심관심
		pi.action(); //전달 받은 클래스의 acton 수행(핵심관심)
		//3. 핵심관심 뒤에 Pointcut 잡은 경우
		System.out.println("B 클래스의 action() 수행중2"); //B의 action 수행(공통관심)
	}
	
	/*
	 * 위의 action 예제 - db연결시 각 위치의 의미
	 * 1 = db연결(공통관심)
	 * 2 = sql 문(핵심관심)
	 * 3 = db해제(공통관심)
	 * */

}
