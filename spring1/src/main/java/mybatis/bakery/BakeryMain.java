package mybatis.bakery;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class BakeryMain {
	
	public static void main(String[] args) throws Exception{
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory =  builder.build(Resources.getResourceAsReader("mybatis/bakery/config.xml"));
		SqlSession session =  factory.openSession(true);
		
		BakeryDAO dao = new BakeryDAO();
		dao.setSession(session);
		
		BakeryService service = new BakeryServiceImpl();
		((BakeryServiceImpl)service).setDao(dao);
		
		//db연결? mybatis 이용
		//mybatis구현? BakeryDAO 이용
		
		/*1. bakery 테이블 insert
		 *  bakeryid : bakery_seq.nextval
		 *  bakeryname, price, balance, bakeryimage(파일이름) 입력받음
		 *  입력받을때? 명령행 매개변수 사용(run-run configurations - arguments - program argu..
		 *  입력된 값 : 숫자든 문자든 모두 String으로 간주(공백으로 구분)
		 *  ex) 소보로빵(args[0]) 1500 100 bbang1.jpg
		*/
		
		for (int i = 0; i < args.length; i++) {
			int cnt = i;
			BakeryVO vo = new BakeryVO();
			vo.setBakeryname(args[i++]);
			vo.setPrice(Integer.parseInt(args[i++]));
			vo.setBalance(Integer.parseInt(args[i++]));
			vo.setBakeryimage(args[i]);
			service.insertBakery(vo);
			System.out.println("<"+args[cnt] +"> 상품 등록 완료" );
		}
		
		
//		BakeryVO vo = new BakeryVO();
//		vo.setBakeryname(args[0]);
//		vo.setPrice(Integer.parseInt(args[1]));
//		vo.setBalance(Integer.parseInt(args[2]));
//		vo.setBakeryimage(args[3]);
//		service.insertBakery(vo);

		
		/*2. bakery 테이블 select : 콘솔 출력*/
		System.out.println("\n베이커리 리스트 출력");
		for(BakeryVO bk : service.getBakeryList()) {
			System.out.println(bk);
		}		
	}
//cf) mybatis orm plugin : mybatis-config.xml / mapping.xml 자동생성 - but, 제공받는 수준? 선언부 정도
}





















