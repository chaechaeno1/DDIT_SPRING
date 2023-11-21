package kr.or.ddit.vo;

import java.util.List;

import lombok.Data;

@Data
public class PaginationInfoVO<T> {
	
	private int totalRecord;	//총 게시글 수
	private int totalPage;		//총 페이지 수
	private int currentPage;	//현재 페이지
	private int screenSize;		//페이지 당 게시글 수
	private int blockSize;		//페이지 블록 수
	private int startRow;		//시작 row
	private int endRow;			//끝 row
	private int startPage;		//시작 페이지
	private int endPage;		//끝 페이지
	private List<T> dataList;	//결과를 넣을 데이터 리스트
	private String searchType;	//검색 타입(제목, 작성자, 제목+작성자 등등)
	private String searchWord;	//검색 단어(키워드)
	
	
	public PaginationInfoVO() {} //기본 생성자
	public PaginationInfoVO(int screenSize, int blockSize) {
		super();
		this.screenSize = screenSize;
		this.blockSize = blockSize;
		
	} 
	
	//@Data를 통해 이미 만들어져 있지만.. 별도로 만들어서 사용
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		// ceil은 올림에 해당한다.
		// 총 게시글 수가 121개 일때, screenSize로 나누게 되면 목은 12이지만 나머지가 존재한다.
		// 이때, 올림을 하게 되면 나머지에 대한 부분이 몫으로 올림이 되므로 13이 된다.
		totalPage = (int)Math.ceil( totalRecord / (double)screenSize );
	}
	

}
