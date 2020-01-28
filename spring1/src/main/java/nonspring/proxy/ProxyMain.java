package nonspring.proxy;

public class ProxyMain {
	//Proxy : 가짜

	public static void main(String[] args) {
		ProxyInterface pi = new C(); //어떤 객체를 전달받을지? xml태그 or Annotation으로 전달 내용 변경 가능
		B b1 = new B();
		b1.setProxyInterface(pi); 
		b1.action();//핵심관심 + B(공통관심)
		//요청한 것? 핵심관심
		//요청한 객체 뿐만 아니라 요청한 객체가 다른 객체에게 일을 더 시킴
		//결과? 핵심관심 + 공통관심
		//위의 내용으로 보면 B가 공통관심까지 같이 일을 함
		//-> AOP 내용
		
		//만약? C를 요청했을 때, B의 내용은 실행하고 싶지 않으면?
		//b1.action다음에 pi.action을 호출하면 O = 스프링에서는 해당 내용을 xml태그로 선언할 수 있음
	}

}
