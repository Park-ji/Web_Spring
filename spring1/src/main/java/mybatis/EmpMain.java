package mybatis;

import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMain {
	
	public static void main(String[] args) throws Exception {
		//각종 xml 설정 사항들 connection생성 공장
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		
		//xml설정파일을 읽음 = Resources.getResourceAsReader("mybatis/mybatis-config.xml")
		//읽어온 설정 파일대로 connection pool 생성 
		SqlSessionFactory factory =  builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));
		
		//JDBC에서 connection 1개 생성한 것과 동일한 작업
		//즉, 만들어진 connection pool에서 connection 1개 받아옴 : openSession()
		//즉, JDBC의 Connection = Mybatis의 SqlSession
		//JDBC : connection.getAutoCommit()이 true임 = dml 자동 커밋
		//JDBC : connection.setAutoCommit(false) = dml 수동 커밋 변경
		//Mybatis : session은 수동 커밋 상태가 기본
		//Mybatis : SqlSession session =  factory.openSession(true); = 자동 커밋 상태
		//SqlSession session =  factory.openSession(); //수동 커밋
		SqlSession session =  factory.openSession(true); //자동 커밋
		System.out.println(session.getConnection().getAutoCommit());
		//Cf, 사용자 수동 커밋 방법
//		session.getConnection().commit();
//		session.getConnection().rollback();
		
		//즉, session이용해서 DB접근하는 것은 : Main->Service->DAO
		//즉, Main은 Service만 부르면 됨
		//Mybatis DB 접근 객체
		EmpDAO dao = new EmpDAO();
		dao.setSession(session);
		//EmpMybatisService : 서비스한테 시킴
		EmpMybatisService service = new EmpMybatisService();
		service.setDao(dao);
		
		//서비스한테 일 시킴
//		//test 1: 모든 레코드 조회
//		List<EmpVO> list = service.getAllEmp();
//		
//		//매개변수? emp-mapping.xml에 정의한 <select 태그의 id값
//		//또한, allemp의 결과의 타입은 EmpVO임
//		//또한, selectList의 리턴 타입은? List타입
//		//List<EmpVO> list = session.selectList("emp.allemp"); //이렇게 Main에서 받지말고 Service한테 시키기!
//		
//		for(EmpVO vo : list) {
//			System.out.println(vo);
//		}
		
//		//test 2 : 특정 레코드 조회
//		EmpVO emp = service.getOneEmp(100);
//		System.out.println(emp);
		
//		//test 3 : 비교연산자 <![CDATA[]]>
//		List<EmpVO> list = service.getManyEmp(150);
//		for(EmpVO vo:list) System.out.println(vo);
		
//		//test 4 : insert(resultType 없고 parameterType있음)
//		EmpVO insertVO = new EmpVO();
//		insertVO.setEmployee_id(1000); //PK(중복 X, NOT NULL)
//		insertVO.setFirst_name("길동"); //해당 문장은 insert에 선언 X = db에 저장 X
//		insertVO.setLast_name("홍"); //NOT NULL
//		insertVO.setEmail("mybatis@kitri.com"); //UNIQUE(중복 X)
//		insertVO.setJob_id("IT_PROG"); //jobs테이블에 존재하는 데이터만 사용가능(이유 : FK제약조건)
//		insertVO.setDepartment_id(1000);
//		service.insertEmp(insertVO);
//		System.out.println("===사원등록완료===");
		
//		//test 5 : update
//		EmpVO updateVO = new EmpVO();
//		updateVO.setEmployee_id(1000);
//		updateVO.setLast_name("김");
//		service.updateEmp(updateVO);
//		System.out.println("===사원수정완료===");
		
		//test 6 : delete
		service.deleteEmp(1000);
		System.out.println("===사원삭제완료===");
	}

}






























