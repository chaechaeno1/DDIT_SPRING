package kr.or.ddit.free.dao;

import java.util.List;

import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.PaginationInfoVO;

public interface IFreeDAO {

	int insertFree(FreeVO freeVO);

	void incrementHit(int freeNo);

	FreeVO selectFree(int freeNo);

	int updateFree(FreeVO freeVo);

	int deleteFree(int freeNo);

	List<FreeVO> selectFreeList_();

	int selectFreeCount(PaginationInfoVO<FreeVO> pagingVO);

	List<FreeVO> selectFreeList(PaginationInfoVO<FreeVO> pagingVO);


}
