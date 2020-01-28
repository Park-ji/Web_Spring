package spring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommandMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("spring2/command.xml"); //ClassPath : 자바 소스들이 있는 패키지
		Command[] array = new Command[3];
		
		array[0] = (Command)factory.getBean("comm1");
		array[1] = factory.getBean("comm2", Command.class); //2번째 매개변수? Command 타입
		array[2] = factory.getBean("comm3", Command.class);	
		
		for(int i=0; i<array.length;i++) {
			array[i].run();
		}
		
		//아래에서 몇번을 불러도 생성자가 호출되지 X(이유? singleton타입이므로)
		//생성자를 매번 호출해서 객체를 매번 만들려면? scope속성을 prototype
		Command singleton = factory.getBean("comm1",Command.class);
		Command singleton2 = factory.getBean("comm1",Command.class);
		Command singleton3 = factory.getBean("comm1",Command.class);
	}

}
