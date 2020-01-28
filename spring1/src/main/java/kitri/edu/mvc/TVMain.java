package kitri.edu.mvc;

public class TVMain {

	public static void main(String[] args) {
		
		//1. 일반적인 java 
//		//삼성 tv
////		SamsungTV tv = new SamsungTV();
////		tv.powerOn();
////		tv.volumeDown();
////		tv.volumeUp();
////		tv.powerOff();
//		
//		//삼성 tv 구입사용자 -> LgTV 구입
//		LgTv tv = new LgTv();
//		tv.turnOn();
//		tv.soundDown();
//		tv.soundUp();
//		tv.turnOff();
//		
//		//위의 코드
//		//SamsungTV -> LgTV 바꿀때
//		//1. tv타입 새로 정의
//		//2. 메소드 고침
//		//즉, 소스 수정 너무 많음
//		
//		//소스 수정이 많다? COUPLING(결합도)가 높다  = 좋은 코드 X
//		
		
		
//		//2. 제약조건 1> 메소드 이름 통일 : interface TV사용
//		//인터페이스 목적 : 객체 만드는 것 X, 상속 O
//		//TV tv = new SamsungTV(); 
//		TV tv = new LgTv();
//		//상위 인터페이스 선언 + 변수명 = new 하위클래스();
//		//하위클래스는 언제든지 상위 인터페이스로 형변환 가능 O
//		tv.powerOn();
//		tv.soundDown();
//		tv.soundUp();
//		tv.powerOff();
//		//하지만, 객체를 바꿀때마다 객체 선언(new~) 부분을 계속 바꿔줘야함
//		//줄이는 방법? 객체만 만드는 클래스를 만들어서 객체 선언 부분을 일임 : TVFactory

		//3. 제약조건 2> 객체 생성 클래스 만들기 : TVFactory 사용
		//Main 메소드의 매개변수 String[] args ? Run 메뉴 -> Run Configurations -> Arguments에 입력한 부분
		//ex) Arguments에 입력 : 삼성 티비
		//args[0] ? 삼성
		TVFactory factory = new TVFactory();
		TV tv = factory.getTV(args[0]);
		tv.powerOn();
		tv.soundDown();
		tv.soundUp();
		tv.powerOff();	
		//입력에 따라서 main함수 코드 수정하는 부분 X : COUPLING을 낮춤!!!
		
	}

}


















