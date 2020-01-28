package springDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpMain {

//<spring 형태로 만들기>
	// 1) new 키워드 없애고 bean 파일 만들기
	// 2) 생성하면서 값 설정? property 속성 사용
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("springDI/emp.xml");
		//emp.xml 설정 : 스프링팩토리에서 만들어진 객체 외부에서 전달받아옴
		//메인에서 객체 수정 X
		//이와 같은 방식? IOC 
		//IOC방식을 구현하기 위해서? DI 방식
		EmpVO vo = factory.getBean("vo", EmpVO.class);	
//		EmpVO vo = new EmpVO();
//		vo.setId(100);
//		vo.setName("김사원");
//		vo.setSalary(123000.99);
		EmpDAO dao = factory.getBean("dao", EmpDAO.class);
//		EmpDAO dao = new EmpDAO();
//		dao.setVo(vo);// vo 객체 생성해서 EmpDAO에 전달
		EmpVO resultvo = dao.getVo();
		System.out.println(resultvo);
	}

//<일반적인 자바 프로그램>
//	public static void main(String[] args) {
//		EmpVO vo = new EmpVO();
//		vo.setId(100);
//		vo.setName("김사원");
//		vo.setSalary(123000.99);
//		
//		EmpDAO dao = new EmpDAO();
//		dao.setVo(vo);//vo 객체 생성해서 EmpDAO에 전달
//		
//		EmpVO resultvo = dao.getVo();
//		System.out.println(resultvo);//출력형태(사번:xxx 이름:xxx 급여:xxx)
//		//객체 출력시? toString메소드 호출
//		//즉, 객체 출력형태 조정? toString 오버라이딩
//	}

}
