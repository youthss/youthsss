package board.spring.mybatis;

import org.springframework.stereotype.Component;

@Component
public class BoardVO {
	int seq;
	String title;
	String contents;
	String writer;
	int password;
	String time;
	int viewcount;
	BoardVO(){} 
	//<jsp:useBean id="a" class="MemberVO"
	//<beans:bean id="a" class"MemberVO"
	//@Component
	
	public BoardVO(int seq, String title, String contents, String writer,String time, int password, int viewcount) { //매개변수받는 생성자 쓰려면 기본생성자 무조건 생성해줘야함
		this.seq=seq;
		this.title=title;
		this.contents=contents;
		this.writer=writer;
		this.time=time;
		this.password=password;
		this.viewcount=viewcount;
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
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
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	
	
}
