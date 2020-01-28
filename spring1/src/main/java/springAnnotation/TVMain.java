package springAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("springAnnotation/tvspring.xml");
		
		String[] names = factory.getBeanDefinitionNames();
		for(String name : names) {
			System.out.println(name);
		}
		//실행결과?
//		lgTv
//		samsungTV
		//스프링이 자동으로 만든 bean들
//		org.springframework.context.annotation.internalConfigurationAnnotationProcessor
//		org.springframework.context.annotation.internalAutowiredAnnotationProcessor
//		org.springframework.context.annotation.internalRequiredAnnotationProcessor
//		org.springframework.context.event.internalEventListenerProcessor
//		org.springframework.context.event.internalEventListenerFactory
		
		TV tv1 = factory.getBean("lgTv", TV.class);		
		tv1.powerOn();
		tv1.soundDown();
		tv1.soundUp();
		tv1.powerOff();	
		
		TV tv2 = factory.getBean("samsungTV", TV.class);		
		tv2.powerOn();
		tv2.soundDown();
		tv2.soundUp();
		tv2.powerOff();	
	}

}


















