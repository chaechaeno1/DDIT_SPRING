package kr.or.ddit.notice.service;

import java.util.List;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface INoticeService {
	
	public ServiceResult insertNotice(NoticeVO noticeVO);

	public NoticeVO selectNotice(int noticeNo);

	public ServiceResult updateNotice(NoticeVO noticeVo);

	public ServiceResult deleteNotice(int noticeNo);

	public List<NoticeVO> selectNoticeList_();

	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO);

	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO);


	
}
