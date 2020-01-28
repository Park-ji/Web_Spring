package front;

public class HelloCommand implements Command {

	@Override
	public void print() {
		System.out.println("hello");
	}

}
