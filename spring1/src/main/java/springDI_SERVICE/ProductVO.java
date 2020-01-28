package springDI_SERVICE;

public class ProductVO {
	//변하는 값 : coupon, sale
	//변하지 않는 값 : code, name, price
	
	int code;
	String name;
	int price;
	int coupon;// 달별로 변하는 값
	double sale;// 달별로 변하는 값(ex, 0.5? 50%할인)
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public double getSale() {
		return sale;
	}
	public void setSale(double sale) {
		this.sale = sale;
	}
	
	@Override
	public String toString() {
		String result = "상품코드 = " + code + "\n이름 = "+ name + "\n가격 = "+ price + "\n세일 = "+ sale + "\n쿠폰 = "+ coupon +"개";
		result += "\n지불가격 = " + (1-sale) * price;
		return result;
	}
}
