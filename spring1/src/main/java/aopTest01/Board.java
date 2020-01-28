package aopTest01;

import java.util.ArrayList;
import java.util.List;

public class Board {
	
	public List<String> getList() {
		System.out.println("게시물 리스트를 가져옵니다.");
		ArrayList<String> list = new ArrayList<String>();
		list.add("1:제목1:내용1");
		list.add("2:제목2:내용2");
		list.add("3:제목3:내용3");
		return list;		
	}
	
	public void insert(int seq) {
		System.out.println(seq+"번째 게시물을 등록합니다.");
	}

}
