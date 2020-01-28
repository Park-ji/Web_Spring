package springAnnotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("tv")
//@Component()
@Scope("prototype")
@Repository //component annotation과 같은 기능(단,  의미적으로 분리해서 사용하기를 권장 - dao 파일)

public class LgTv  implements TV{	
	
	public LgTv() {
		System.out.println("LgTv() 생성자 호출");
	}
	
	@Override
	public void powerOn() {
		System.out.println("엘지 TV : 전원켜다");
	}

	@Override
	public void powerOff() {
		System.out.println("엘지 TV : 전원끄다");
	}

	@Override
	public void soundUp() {
		System.out.println("엘지 TV : 볼륨 높이다");
	}

	@Override
	public void soundDown() {
		System.out.println("엘지 TV : 볼륨 낮추다");
	}

}
