package kr.or.ddit.notice.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.notice.dao.INoticeDAO;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Service
public class NoticeServiceImpl implements INoticeService {
	
	@Inject
	private INoticeDAO noticeDao;

	@Override
	public ServiceResult insertNotice(NoticeVO noticeVO) {
		ServiceResult result = null;
		int status = noticeDao.insertNotice(noticeVO);
		if(status > 0) { //성공
			result = ServiceResult.OK;
		}else { //실패
			result = ServiceResult.FAILED;
		}

		return result;
	}

	@Override
	public NoticeVO selectNotice(int noticeNo) {
		
		//조회수 증가
		noticeDao.incrementHit(noticeNo);
				
		return noticeDao.selectNotice(noticeNo);
		
	}

	@Override
	public ServiceResult updateNotice(NoticeVO noticeVo) {
		ServiceResult result = null;
		int status = noticeDao.updateNotice(noticeVo);
		
		if(status > 0) { //수정 성공
			result = ServiceResult.OK;
		}else { // 수정 실패
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Override
	public ServiceResult deleteNotice(int noticeNo) {
		ServiceResult result = null;
		int status = noticeDao.deleteNotice(noticeNo);
		
		if(status > 0) { //삭제 성공
			result = ServiceResult.OK;
		}else { // 삭제 실패
			result = ServiceResult.FAILED;
		}
		
		return result;
		
	}

	@Override
	public List<NoticeVO> selectNoticeList_() {
		
		return noticeDao.selectNoticeList_();
	}


	@Override
	public int selectNoticeCount(PaginationInfoVO<NoticeVO> pagingVO) {
		
		return noticeDao.selectNoticeCount(pagingVO);
	}

	@Override
	public List<NoticeVO> selectNoticeList(PaginationInfoVO<NoticeVO> pagingVO) {
		
		return noticeDao.selectNoticeList(pagingVO);
	}

	

}
