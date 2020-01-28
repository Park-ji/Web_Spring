package config.bean.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("config/bean/spring/tvspring.xml");
		//TV tv = factory.getBean("tv2", TV.class);
		
		for(String n : factory.getBeanDefinitionNames()) {
			System.out.println(n);
		}
		
		TVConfig tvc = (TVConfig)factory.getBean("TVConfig");
		tvc.getTV();
		
		TV tv = factory.getBean("getTV", TV.class);
		tv.powerOn();
		tv.soundDown();
		tv.soundUp();
		tv.powerOff();	
	}

}


















