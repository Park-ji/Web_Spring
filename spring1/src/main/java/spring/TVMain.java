package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		//TVFactory factory = new TVFactory();
		
		//spring안에 factory역할을 하는 api 이용
		//ApplicationContext? 현재 스프링 실행 파일 정보를 가지고 있음 = factory 역할
		//ClassPathXmlApplicationContext()? 설정파일(xml파일) 넘기기
		//xml은 폴더 구조로 저장(cf, 자바는 패키지 구조로 저장)
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring/tvspring.xml");
		//TV tv = (TV)factory.getBean("tv"); //tv라는 이름의 bean태그 -> tvspring.xml안에 있는 <bean id="tv" class="spring.LgTv"/> :  spring.LgTv 객체로 만듦						
		
		//1. getBean은 오브젝트 형식으로 리턴하기때문에 TV로 형식 정함
		//TV tv = (TV)factory.getBean("tv2");//삼성티비
		//2. 또는 매개변수 하나 더 지정
		TV tv = factory.getBean("tv2", TV.class);
		//즉, 스프링으로 구현시, new 키워드 사라짐(직접 객체를 생성하는)
		tv.powerOn();
		tv.soundDown();
		tv.soundUp();
		tv.powerOff();	
	}

}


















