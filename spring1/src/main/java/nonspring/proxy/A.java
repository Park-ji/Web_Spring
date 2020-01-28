package nonspring.proxy;

public class A implements ProxyInterface {

	@Override
	public void action() {
		System.out.println("A 클래스의 action() 수행중"); //핵심관심
	}

}
