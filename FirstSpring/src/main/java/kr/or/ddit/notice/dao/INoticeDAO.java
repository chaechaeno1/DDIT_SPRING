package kr.or.ddit.notice.dao;

import java.util.List;

import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface INoticeDAO {

	int insertNotice(NoticeVO noticeVO);

	void incrementHit(int noticeNo);

	NoticeVO selectNotice(int noticeNo);

	int updateNotice(NoticeVO noticeVo);

	int deleteNotice(int noticeNo);

	List<NoticeVO> selectNoticeList_();

	int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);

	List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);



}
