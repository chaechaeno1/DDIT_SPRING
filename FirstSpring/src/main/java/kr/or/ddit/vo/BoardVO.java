package kr.or.ddit.vo;

public class BoardVO {
	private int boNo;			//일반게시판 번호
	private String boTitle;		//일반 게시판 제목
	private String boWriter;	//일반 게시판 작성자
	private String boContent;	//일반게시판 내용
	private String boDate;		//일반게시판 작성일
	private int boHit;			//일반게시판 조회수
	
	
	
	//게터세터
	public int getBoNo() {
		return boNo;
	}
	public void setBoNo(int boNo) {
		this.boNo = boNo;
	}
	public String getBoTitle() {
		return boTitle;
	}
	public void setBoTitle(String boTitle) {
		this.boTitle = boTitle;
	}
	public String getBoWriter() {
		return boWriter;
	}
	public void setBoWriter(String boWriter) {
		this.boWriter = boWriter;
	}
	public String getBoContent() {
		return boContent;
	}
	public void setBoContent(String boContent) {
		this.boContent = boContent;
	}
	public String getBoDate() {
		return boDate;
	}
	public void setBoDate(String boDate) {
		this.boDate = boDate;
	}
	public int getBoHit() {
		return boHit;
	}
	public void setBoHit(int boHit) {
		this.boHit = boHit;
	}

	
	
	
}
