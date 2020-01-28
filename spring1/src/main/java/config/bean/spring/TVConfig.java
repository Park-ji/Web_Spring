package config.bean.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//getTV메소드로 만들어지는 TV타입의 객체를 바로 BEAN으로 만들고 싶으면? @Configuration, @Bean 사용
//main 함수에서 호출할때, 객체이름은? 메소드의 이름

@Configuration //BEAN을 만드는 설정파일임을 의미
public class TVConfig {
	
	@Bean
	public TV getTV() {
		//return new SamsungTV();
		return new LgTv();
	}

}

/* 
 
1. Thread 클래스 사용시? Api이므로 Thread위에 @Component라고 명시하지 X
 : 아래와 같이 사용 X

 @Component
 class Thread{...}
 
public class TVConfig {
	@Autowired
	Thread t;

}

2. 그렇다면? Thread 형식의 객체를 받아오는 방법 : Bean태그 사용
 
@Configuration //BEAN을 만드는 설정파일임을 의미
public class TVConfig {

	@Bean
	public Thread getTV() {
		//return new SamsungTV();
		return new LgTv();
	}


}

 * */
