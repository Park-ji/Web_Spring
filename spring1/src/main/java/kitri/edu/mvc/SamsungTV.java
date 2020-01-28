package kitri.edu.mvc;

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
	
//	//전원 켜다
//	public void powerOn() {
//		System.out.println("삼성 TV : 전원켜다");
//	}
//	//전원 끄다
//	public void powerOff() {
//		System.out.println("삼성 TV : 전원끄다");
//	}
//	//볼륨 높이다
//	public void volumeUp() {
//		System.out.println("삼성 TV : 볼륨 높이다");
//	}
//
//	//볼륨 낮추다
//	public void volumeDown() {
//		System.out.println("삼성 TV : 볼륨 낮추다");
//	}
}
