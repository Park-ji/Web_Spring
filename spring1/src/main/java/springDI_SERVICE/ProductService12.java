package springDI_SERVICE;

public class ProductService12 implements ProductService {
	
	ProductDAO dao;

	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}

	@Override
	public ProductVO sell() {
		//12월 판매 정책 관련 부분 구현
		return dao.sell(0.5, 1);
	}

}
