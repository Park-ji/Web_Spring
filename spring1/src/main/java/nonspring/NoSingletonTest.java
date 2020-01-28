package nonspring;

class NoSingleton{
	static int i=0;
	public NoSingleton() {
		System.out.println(++i + "번째 생성자 호출합니다.");
	}
}

public class NoSingletonTest {
	public static void main(String[] args) {
		NoSingleton n1 = new NoSingleton();
		NoSingleton n2 = new NoSingleton();
		NoSingleton n3 = new NoSingleton();
		System.out.println("생성된 객체 = " + n1);
		System.out.println("생성된 객체 = " + n2);
		System.out.println("생성된 객체 = " + n3);
	}
}

