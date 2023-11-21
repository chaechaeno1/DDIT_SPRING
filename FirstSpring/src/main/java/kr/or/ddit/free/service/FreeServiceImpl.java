package kr.or.ddit.free.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.free.dao.IFreeDAO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Service
public class FreeServiceImpl implements IFreeService {
	
	@Inject
	private IFreeDAO freeDao;

	@Override
	public ServiceResult insertFree(FreeVO freeVO) {
		ServiceResult result = null;
		int status = freeDao.insertFree(freeVO);
		if(status > 0) { //성공
			result = ServiceResult.OK;
		}else { //실패
			result = ServiceResult.FAILED;
		}

		return result;
	}

	@Override
	public FreeVO selectFree(int freeNo) {
		
		//조회수 증가
		freeDao.incrementHit(freeNo);
				
		return freeDao.selectFree(freeNo);
		
	}

	@Override
	public ServiceResult updateFree(FreeVO freeVo) {
		ServiceResult result = null;
		int status = freeDao.updateFree(freeVo);
		
		if(status > 0) { //수정 성공
			result = ServiceResult.OK;
		}else { // 수정 실패
			result = ServiceResult.FAILED;
		}
		
		return result;
	}

	@Override
	public ServiceResult deleteFree(int freeNo) {
		ServiceResult result = null;
		int status = freeDao.deleteFree(freeNo);
		
		if(status > 0) { //삭제 성공
			result = ServiceResult.OK;
		}else { // 삭제 실패
			result = ServiceResult.FAILED;
		}
		
		return result;
		
	}

	@Override
	public List<FreeVO> selectFreeList_() {
		
		return freeDao.selectFreeList_();
	}


	@Override
	public int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO) {
		
		return freeDao.selectFreeCount(pagingVO);
	}

	@Override
	public List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO) {
		
		return freeDao.selectFreeList(pagingVO);
	}
	
	@Override
	public int selectFreeCount_() {
		return freeDao.selectFreeCount_();
	}

}
