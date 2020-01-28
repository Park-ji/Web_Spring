package kitri.edu.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component("chatwebsockethandler")
// 각 클라이언트 접속시 웹소켓핸들로 하나씩 생성됨
//List는 각 클라이언트가 접속하더라도 모든 웹소켓 핸들러들이 하나를 공유해야함 = static
public class ChatWebsocketHandler implements WebSocketHandler {
	
	//WebSocketHandler는 들어오는 클라이언트를 WebSocketSession형태로 받음
	public static List<WebSocketSession> list = new ArrayList<WebSocketSession>();
	

	@Override //최초로 클라이언트 연결시
	//session?웹 소켓으로 연결되어진 클라이언트
	public void afterConnectionEstablished(WebSocketSession session) throws Exception { //연결 후
		list.add(session);//접속한 클라이언트 목록에 저장
		System.out.println("사용자 추가 = " + list.size());//콘솔 출력으로 해당 기능 동작 확인 - 사이즈 커져야함
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		//제일 중요한 메소드
		//매개변수 : session, message
		//session? 웹소켓에 접속한 클라이언트(ip, ...)
		//message? 웹소켓 클라이언트가 서버로 전송한(보낸) 메세지 ex) 현재, 'nickname:message'형태로 보냄
		//1개의 클라이언트가 문자를 보내면 나머지 모든 클라이언트에게 그대로 보냄
		//1> 1개의 클라이언트가 보낸 문자 받기
		String msg = (String)message.getPayload(); //getPayload? 메세지 값을 읽어옴
		//2> 나머지 모든 클라이언트에게 그대로 보내기
		for(WebSocketSession ss : list) {
			//하나의 클라이언트가 보낸 문자(msg)를 text형식으로 만듦
			//2번째 매개변수 스타일
			WebSocketMessage<String> sendmsg = new TextMessage(msg);
			//리스트에 들어가있는 클라이언트에 보냄
			ss.sendMessage(sendmsg); //클라이언트에 보낼때 모양? server.data = nick:message 
		}
		System.out.println("사용자 송수신 = " + list.size()); //사이즈 변화없어야함
	}//handleMessage end

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		//이번 실습에서는 구현 X
		//에러 발생시 처리 구현
	}

	@Override //클라이언트와 연결이 해제됬을때
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		//연결 끝
		list.remove(session);
		System.out.println("사용자 삭제 = " + list.size()); //사이즈 줄어야함
	}

	@Override
	public boolean supportsPartialMessages() { //메세지가 크면 조금씩 잘라서 구현
		//이번 실습에서는 구현 X
		//보통 그대로 둠
		return false;
	}

}







