package aopTest01.animal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalMain {
	public static void main(String[] args) {
		//AnimalCommon클래스 생성 -> aop활용 클래스
		ApplicationContext factory = new ClassPathXmlApplicationContext("aopTest01/animal/animal.xml");
		
		Animal[] animal = new Animal[3]; //Animal 객체
		animal[0] = factory.getBean("cat",Animal.class);
		animal[1] = factory.getBean("dog",Animal.class);
		animal[2] = factory.getBean("rabbit",Animal.class);
		
		for(Animal a : animal) {
			a.lunch();
		}
		
	}
}

/*
 * <출력결과>
 * 점심먹었어요?//공통1
 * 생선먹었습니다.//핵심
 * Cat님은 생선먹었군요.//공통2(클래스, return출력)
 * 
 * 점심먹었어요?//공통1
 * 사료먹었습니다.//핵심
 * Dog님은  사료먹었군요.//공통2(클래스, return출력) 
 * 
 * 점심먹었어요?//공통1
 * 당근먹었습니다.//핵심
 * Rabbit님은 당근먹었군요.//공통2(클래스, return출력) 
 */
