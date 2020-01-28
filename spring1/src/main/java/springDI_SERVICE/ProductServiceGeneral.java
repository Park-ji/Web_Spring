package springDI_SERVICE;

public class ProductServiceGeneral implements ProductService {
	
	ProductDAO dao;

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public ProductVO sell() {
		//ProductDAO sell메소드 호출 : sell(0,5)
		//즉, ProductDAO 객체 필요 = 멤버변수 선언
		
		//dao.sell()메소드 리턴타입도 ProductVO 형태이므로 바로 return OK
		return dao.sell(0, 5);//0은 자동으로 double형태로 형변환됨
	}

}
