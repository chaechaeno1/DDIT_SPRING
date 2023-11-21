package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.vo.BoardVO;

public interface IBoardDAO {

	public int insertBoard(BoardVO boardVO);

	public void incrementHit(int boNo);

	public BoardVO selectBoard(int boNo);

	public int updateBoard(BoardVO boardVO);

	public int deleteBoard(int boNo);

	public List<BoardVO> selectBoardList();

}
