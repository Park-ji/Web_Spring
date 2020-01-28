package mybatis.bakery;

import java.util.List;

public interface BakeryService {
	//제품등록서비스
	public void insertBakery(BakeryVO vo);
	//제품조회서비스
	public List<BakeryVO> getBakeryList();

}
