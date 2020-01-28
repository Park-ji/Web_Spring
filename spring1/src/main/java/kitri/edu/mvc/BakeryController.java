package kitri.edu.mvc;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BakeryController {
	@Autowired
	BakeryDAO dao;
	
	@RequestMapping(value="/store.bakery", method = RequestMethod.GET)
	public String storeForm() {
		//베이커리 이름, 가격, 수량, 이미지파일 업로드 폼(storeform.jsp)
		return "storeform";
	}
	
	@RequestMapping(value="/store.bakery", method = RequestMethod.POST)
	public String storeResult(BakeryVO vo) throws Exception {
		//BakeryDAO 객체 시킬 것
		//모델 값 : 상품 등록 완료되었습니다.
		
		dao.insertBakery(vo);
		
		//실제 업로드 파일 저장
		//String uploadpath =  path+"/resources/bakery/";
		//경로의 의미 : \\ = /
		String uploadpath = "C:/web_worksapce/spring1/src/main/webapp/resources/bakery/";
		String filename = vo.getBakeryimage().getOriginalFilename();
		File file = new File(uploadpath + filename);
		//파일 복사 : IOException
		vo.getBakeryimage().transferTo(file);
		
		//3초 일시정지
		Thread.sleep(3000);
		
		//리턴타입이 ModelAndView일때
//		mav.addObject("model","상품 등록 완료되었습니다.");
//		mav.setViewName("storeresult");
		
		return "storeresult";
	}	

}
