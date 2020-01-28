package config.bean.spring;

public class LgTv  implements TV{	
	
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
