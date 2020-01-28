package kitri.edu.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatWebsocketController {
	
	@RequestMapping("/chat") //요청 url
	public String chat() {
		return "chatwebsocket"; //리턴값? 뷰
	}

}
