package mybatis.bakery;

import java.util.List;

public class BakeryServiceImpl implements BakeryService {
	
	BakeryDAO dao;

	public void setDao(BakeryDAO dao) {
		this.dao = dao;
	}

	@Override
	public void insertBakery(BakeryVO vo) {
		dao.insertBakery(vo);
	}

	@Override
	public List<BakeryVO> getBakeryList() {
		return dao.getBakeryList();
	}

}
