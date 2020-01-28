package springDI_SERVICE_exam1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("springDI_SERVICE_exam1/test.xml");	
		
		//spring bean파일에 만든 생성객체 확인 
		String[] names = factory.getBeanDefinitionNames();
		for(String name : names) {
			//names배열의 값 하나하나를 name이라고 생각
			System.out.println(name);
		}
		
		
//		TestService service = factory.getBean("service", TestService.class);
//		TestVO vo = service.test();
//		System.out.println(vo.getMember1() + " : "+  vo.getMember2());
		//System.out.println(service.test()); //TestVO에 toString 오버라이딩 한 경우		
	}

}
