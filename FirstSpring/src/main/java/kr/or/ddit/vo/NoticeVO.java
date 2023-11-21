package kr.or.ddit.vo;

import lombok.Data;

//noNo -> 로 설정하는게 아니라 noticeNo이런식으로 설정해야함 ㅠ

@Data
public class NoticeVO {
	private int noticeNo; 			
	private String noticeTitle;		
	private String noticeWriter;	
	private String noticeContent;	
	private String noticeDate;		
	private int noticeHit;			

}
