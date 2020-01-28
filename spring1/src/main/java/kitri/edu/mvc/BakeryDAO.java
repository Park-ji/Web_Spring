package kitri.edu.mvc;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

@Repository
public class BakeryDAO {
	//상품 등록 : insert
	public void insertBakery(BakeryVO vo) throws Exception {
		//vo 전달 모든 내용을 bakery insert
		//bakeryid  : bakery_seq.nextval() 시퀀스 이용
		//bakeryimage : 이미지 사진 업로드 파일 이름
		
		//db에 내용 저장
		int insertRow=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","hr","hr");
			String sql = "insert into bakery values(bakery_seq.nextval, ?, ?, ?, ?)";
			//last_name ||','||first_name as name
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, vo.getBakeryname());
			pt.setInt(2, vo.getPrice());
			pt.setInt(3, vo.getBalance());
			pt.setString(4,vo.getBakeryimage().getOriginalFilename());
			
			insertRow = pt.executeUpdate();
			if(insertRow==1) System.out.println("insert 성공");
			
			pt.close();
			con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		
	}

}
