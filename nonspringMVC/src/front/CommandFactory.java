package front;

public class CommandFactory {
	public Command getCommand(String name) {
		if(name.equals("/nonspringMVC/hello.front")) {return new HelloCommand();}
		else if(name.equals("/nonspringMVC/board.front")) {return new BoardCommand();}
		else if(name.equals("/nonspringMVC/member.front")) {return new  MemberCommand();}
		else {return null;}
	}
}
