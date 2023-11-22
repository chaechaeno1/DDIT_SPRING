package kr.or.ddit.main.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.NoticeVO;

public interface IMainDAO {

	public List<BoardVO> selectBaordList();

	public Map<String, String> selectAllCount();

	public List<NoticeVO> selectNoticeList();

	public List<FreeVO> selectFreeList();

}
