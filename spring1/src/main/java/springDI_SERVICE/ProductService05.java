package springDI_SERVICE;

public class ProductService05 implements ProductService {
	
	ProductDAO dao;

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public ProductVO sell() {
		//5월 판매 정책 관련 구현
		return dao.sell(0.3, 3);		
	}

}
