package springDI_SERVICE;

public class ProductDAO {
	ProductVO vo;

	public void setVo(ProductVO vo) {
		this.vo = vo;
	}
	
	//12월에 서비스하는 객체 : sell(0.5,1) -> ProductService12
	//5월에 서비스하는 객체 : sell(0.3,3) -> ProductService5
	//다른 월(세일을 하지 않는 월)에 서비스하는 객체 : sell(0.0, 5) -> ProductServiceGeneral
	
	//각 서비스 객체는 같은 메소드 사용함 = COMMAND 패턴사용(ProductService interface 사용)

	public ProductVO sell(double sale, int coupon) {
	//상품 판매 정책 : 세일, 쿠폰 개수에 따라 다름 - 월별로 달라지는 값
	//구현하려는 내용? ProductVO객체.setSale(sale값)
		vo.setSale(sale);
		vo.setCoupon(coupon);
		return vo;
	}
}
