package kr.or.ddit.main.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.IBoardDAO;
import kr.or.ddit.main.dao.BoardDAO;
import kr.or.ddit.vo.BoardVO;

@Service
public class BoardService {
	
	@Inject
	private BoardDAO boardDao;
	
	public List<BoardVO> getLatestBoardList(int count) {
		
		return boardDao.selectBoardList(count);
	}

}
