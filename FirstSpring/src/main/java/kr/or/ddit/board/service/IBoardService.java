package kr.or.ddit.board.service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.vo.BoardVO;

public interface IBoardService {

	ServiceResult insertBoard(BoardVO boardVO);
	
	

}
