package mybatis.bakery;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BakeryDAO {
	
	SqlSession session;

	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public void insertBakery(BakeryVO vo) {
		session.insert("bakery.insertbk", vo);
	}
	
	public List<BakeryVO> getBakeryList(){
		return session.selectList("bakery.allbk");
	}

}
