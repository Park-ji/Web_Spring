package member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

	//회원가입, 회원리스트 조회, 회원 조회, 회원 수정, 회원 탈퇴
	@RequestMapping("/member/add")
	public void addMember() {
		//test 1 : 리턴 타입이 void이면 모델도 뷰도 없는 상태인가? cf) 뷰가 없는 경우? ajax 호출
		//그렇다면, 이때 선택되는 뷰? 해당 url과 동일한 이름으로 결정(member/add)
		//뷰의 저장 경로 : webapp/WEB-INF/views/member/add.jsp
		//확인 : 해당 경로에 member/add만들면? 보임
		System.out.println("===회원가입처리중입니다.===");
	}
	@RequestMapping("/member/list")
	public String getMemberList() {
		//test 2 : 리턴 타입이 String이면? 
		//모델 : X
		//뷰 : void이면 url과 동일한 이름이지만, String이면 원하는 뷰의 이름으로 설정
		//리턴 값 = 뷰의 이름
		System.out.println("===회원리스트처리중입니다.===");
		return "/member/memberlist"; //뷰의 이름 :  member/memberlist
	}
	@RequestMapping("/member/delete")
	public String deleteMember() {
		System.out.println("===회원탈퇴처리후에 회원리스트 출력합니다.===");
		//방법 1  
		//return "/member/memberlist"; 
		//의미? 컨트롤러 메소드 실행은 하지 않고 jsp파일(=뷰)로 직접 이동
		//방법 2
		return "redirect:/member/list"; //getMemberList메소드에 매핑된 url주소를 redirect뒤에 사용
		//의미? 현재 request매핑된 url중에 'member/list'라는 곳에 redirect(다시 이동)하라는 의미
		//즉, 매핑 컨트롤러 메소드 실행
		//BoardController에서 아래의 메소드에 사용하면 됨
//		@RequestMapping(value="/write.board", method = RequestMethod.POST)
//		public ModelAndView writeBoard(BoardVO vo
	}
	@RequestMapping("/member/update")
	public ModelAndView updateMember() {
		System.out.println("===회원정보 수정합니다.===");
		ModelAndView mav = new ModelAndView();
		mav.addObject("updateid","수정id");
		//mav.setViewName("member/update");
		//setViewName을 쓰지 않아도 url과 똑같은 이름의 뷰이름이 생성됨
		return mav;
	}
	@RequestMapping("/member/get")
	public Model getMember(Model m) {
		//리턴타입이 Model? 매개변수로 받아야함
		//사용메서드? addAttribute
		//해당 모델을 받는 뷰? url과 동일한 이름의 뷰
		//즉, 뷰의 이름이 명시가 되지않으면 무조건 url과 동일한 이름의 뷰로 전달됨
		m.addAttribute("id", "spring");
		m.addAttribute("name","이자바");
		return m;
	}
	@RequestMapping("/member/get2")
	public Map<String,String> getMember() {
		//리턴 타입이 Map
		Map<String,String> map = new HashMap<String, String>();
		map.put("id","spring");
		map.put("name","이자바");
		return map; //map의 형태로 전달
	}
	
	//이전까지 : 리턴타입 공부
//---------------------------------------------------------------------------------------------------------------------------------------
	//이후부터 : @ModelAttribute 메소드 선언 : 공유
	//list2, list3 둘다 MemberVO가 필요함
	//따로따로 매개변수앞에 선언하지말고 메소드만들어서 앞에 선언하기
	//즉, 가장먼저 메소드 실행되서 list생성됨
	@ModelAttribute("listmodel")
	public ArrayList<MemberVO>  getModel() { //리턴하는 객체가 ModelAttribute의 객체
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		list.add(new MemberVO("SPRING","이봄"));
		list.add(new MemberVO("mybatis","박자바"));
		list.add(new MemberVO("java","김자바"));
		list.add(new MemberVO("android","이용권"));
		list.add(new MemberVO("jsp","강봄"));
		return list;
	}
	
	@ModelAttribute("searchmodel")
	public ArrayList<String> getModel2(){		
		ArrayList<String> list = new ArrayList<String>();
		list.add("ID검색");
		list.add("이름검색");
		list.add("EMAIL검색"); //흉내만 냄(현재 MemberVO에 id, name만 있음
		list.add("연락처검색");
		return list;	
	}
	
	
	@RequestMapping("/member/list2")
	public void getList2() {
		//모든 Member ArrayList 리턴 - 모델
	}
	
	@RequestMapping("/member/list3")
	public void getList3() {
		//검색 조건 추가된 Member ArrayList 리턴 - 모델
		
	}
	
	@RequestMapping("member/searchlist")
	public ModelAndView searchlist(@RequestParam("searchitem")String item, @RequestParam("searchword") String word) {
		//검색 조건 추가된 Member ArrayList 리턴 - 모델
		//item : ID검색, 이름검색 ... => XX검색
		item = item.substring(0,item.length()-2);
		ModelAndView mav = new ModelAndView();
		mav.addObject("item",item);
		mav.addObject("word",word);
		return mav;		
	}
	

}












