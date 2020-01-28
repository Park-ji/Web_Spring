package aopTest01;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopMain {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("aopTest01/aop1.xml");
		Member member = factory.getBean("member", Member.class);
		Board board = factory.getBean("board", Board.class);
		
		member.login("id");
		board.insert(4);
		
		 board.getList(); //board.getList()메소드 사용시 common.printAround도 같이 실행됨 => 이때, common.printAround가 해당 결과 가로채감(밑의 반복문에 넘길 list값이 없음)
		/*
		 * List list = board.getList();
		 * for(Object o : list) { //generic 표현식 안사용했으므로 Object타입으로 돌리기
		 * System.out.println(o); }
		 */
		
		member.logout();
	}

}
