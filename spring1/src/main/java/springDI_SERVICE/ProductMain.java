package springDI_SERVICE;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductMain {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("springDI_SERVICE/product.xml");
		//필요한 객체? FACTORY패턴 사용
		//ProductServiceGeneral, ProductService12, ProductService05 
		//ProductDAO, ProductVO
		
		//서비스 유형? 3가지
		ProductService service1 = factory.getBean("service1", ProductService.class);
		ProductService service2 = factory.getBean("service2", ProductService.class); //12월
		ProductService service3 = factory.getBean("service3", ProductService.class); //5월
		
		//즉, 정책이 달라지더라도 service부터 dao, vo는 변하지 않음
		//main의 출력 형태만 바꾸면 됨!
		System.out.println("====노세일기간====");
		ProductVO result1 = service1.sell();
		System.out.println(result1);
		
		System.out.println("====12월 세일기간====");
		ProductVO result2 = service2.sell(); //12월
		System.out.println(result2);
		
		System.out.println("====5월 세일기간====");
		ProductVO result3 = service3.sell(); //5월
		System.out.println(result3);
	}

}
