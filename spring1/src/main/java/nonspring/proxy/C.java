package nonspring.proxy;

public class C implements ProxyInterface {

	@Override
	public void action() {
		System.out.println("C 클래스의 action() 수행중"); //핵심관심
	}

}
