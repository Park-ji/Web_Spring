package nonspring;

public class TVFactory {
	
	public TV getTV(String name) {
		TV result = null;
		if(name.equals("삼성")) result = new SamsungTV();
		else if(name.equals("엘지")) result = new LgTv();
		return result;
	}

}
