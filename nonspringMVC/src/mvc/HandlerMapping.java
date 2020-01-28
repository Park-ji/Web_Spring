package mvc;

import java.util.HashMap;

public class HandlerMapping {
	//키값에 맞는 Controller 매핑해놓음
	HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings  =  new HashMap<String, Controller>();
		mappings.put("hello.mvc", new HelloController());
		//Controller 많아지면 mappings에 mapping해놓기
		mappings.put("boardwrite", new BoardController());
		mappings.put("member.front", new MemberController());		
	}
	
	public Controller getController(String result){
		return mappings.get(result); //result에 맞는 Controller전달 
	}

}
