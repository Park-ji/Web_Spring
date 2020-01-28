package nonspring;

class Singleton{
	static int i=0;//공유할 변수 : static(Singleton클래스의 i는 하나만 만든다는 의미 : 메모리 적재)
	//static 붙으면? 객체를 만들지 않고 static 변수, static 메소드를 호출할 수 있음
	static Singleton singleton;
	private Singleton() {//클래스 안에서만 생성 가능 : private
		System.out.println(++i  + "번째 생성자 호출합니다.");
	}
	static public Singleton getInstance() {
		if(singleton == null) {
		//static 메소드 안에는 static 변수만 사용 가능
		singleton = new Singleton();
		}
		return singleton;
	}
	
	//이제, Singleton객체는 자기 자신이 자신의 factory(객체 생성) 역할을 함
	//즉, Singleton객체는 Singleton클래스만 만들수 있음
}

public class SingletonTest {
	public static void main(String[] args) {
		//getInstance만 선언하면? 현재 클래스(SingletonTest) 안에 있는 메소드라고 생각함
		//new Singleton.getInstane() 라고 선언해야함 - 하지만, Singleton 생성자는 private = 모순
		//그렇다면, 객체를 만들지 않고 getInstance를 호출하기 하려면? 멤버변수, 메소드 static 선언
		Singleton n1 = Singleton.getInstance();
		Singleton n2 = Singleton.getInstance();;
		Singleton n3 = Singleton.getInstance();
		//위처럼 선언하면 n1, n2, n3가 하나의 객체를 공유하는 것? NO 
		//해결? getInstance메소드 안에서 null체크
		System.out.println("생성된 객체 = " + n1);
		System.out.println("생성된 객체 = " + n2);
		System.out.println("생성된 객체 = " + n3);
	}
}

//하나의 객체를 만들어서 공유하려면?
//Singleton n1 = new Singleton();
//Singleton n2 = n1;
//Singleton n3 = n2;
//즉, 개발자들은 객체를 만들때 자유롭게 사용할 수 있음(위처럼 객체 다 생성할수도 있는 것) -> 따라서, 강제적인 규칙을 만듦 -> 좋은 코드를 위해서

//개발자에게 강제적으로 객체를 하나 만들면 만든 객체를 공유하라고 틀 세우기?
//1. Singleton 클래스 생성자 앞에 private사용
//2. 최초의 하나의 클래스는 만들어야하므로 Singleton클래스 안에 Singleton타입 멤버변수 선언 + 객체 생성 메소드 선언










