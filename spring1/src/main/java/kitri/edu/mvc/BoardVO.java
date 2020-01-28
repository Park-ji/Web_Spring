package kitri.edu.mvc;

public class BoardVO {
	String title,contents,writer,time;
	int seq, password,viewcount;
	
	public BoardVO() {}
	

	public BoardVO(int seq,String title, String contents, String writer, String time, int password, int viewcount) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.time = time;
		this.seq = seq;
		this.password = password;
		this.viewcount = viewcount;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	
}
