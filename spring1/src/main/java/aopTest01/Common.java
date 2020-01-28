package aopTest01;

import org.aspectj.lang.ProceedingJoinPoint;

public class Common {
	
	public void printStart() {
		System.out.println("<<<메소드를 시작합니다.>>>");
	}
	
	public void printEnd() {
		System.out.println("<<<메소드를 종료합니다.>>>");
	}
	
	public void printResult(Object val) {
		//pointcut으로 선택된 대상 메소드 수행 종료 시, 생기는 리턴값을 활용 
		//-> 각 메소드의 리턴타입을 받아야하므로 매개변수 타입을 Object로 지정
		System.out.println("<<<메소드 수행 후 리턴값 = " + val +">>>");
	}

	//핵심관심메소드(poincut 문법에 의해 선택된 메소드) 실행되기전 실행되기후 둘다 사용 가능
	public void printAround(ProceedingJoinPoint joinpoint) { //joinpoint? 선택한 메소드
		try {
		System.out.println("<<<메소드를 시작합니다.>>>");
		//핵심관심 선택 메소드 =  pointcut
		Object val = joinpoint.proceed(); //핵심관심 메소드 실행하고 실행 결과물에 리턴값이 있다면? val에 저장
		System.out.println("실행결과 = "+ val); //printResult에서 하는 역할과 동일
		//System.out.println("객체 이름 = " + joinpoint.getTarget()); //객체정보 확인
		//System.out.println("메소드 이름 = " + joinpoint.toShortString()); //선택한 메소드 이름 확인
		System.out.println("<<<메소드를 종료합니다.>>>");
		}catch(Throwable e) {}
	}
	
}
