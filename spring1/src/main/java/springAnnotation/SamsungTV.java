package springAnnotation;

import org.springframework.stereotype.Component;

//@Component("tv2") //tvspring.xml의 2번째 bean태그와 같은 의미
//xml태그 대신 annotation 설정 이용시? spring한테 알려줘야함

@Component //이름을 안주면? 클래스명과 같은 이름으로 자동생성 => 맨 앞의 한문자만 소문자로 바뀜
//이름 확인? factory.getBeanDefinitionNames()메소드 사용
public class SamsungTV implements TV{

	@Override
	public void powerOn() {
		System.out.println("삼성 TV : 전원켜다");
	}

	@Override
	public void powerOff() {
		System.out.println("삼성 TV : 전원끄다");
	}

	@Override
	public void soundUp() {
		System.out.println("삼성 TV : 볼륨 높이다");
	}

	@Override
	public void soundDown() {
		System.out.println("삼성 TV : 볼륨 낮추다");
	}

}
