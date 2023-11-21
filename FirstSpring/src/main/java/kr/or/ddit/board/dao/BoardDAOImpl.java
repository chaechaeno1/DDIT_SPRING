package kr.or.ddit.board.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.BoardVO;


@Repository
public class BoardDAOImpl implements IBoardDAO {

	@Inject
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertBoard(BoardVO boardVO) {
		
		return sqlSession.insert("Board.insertBoard", boardVO);
	}

	@Override
	public void incrementHit(int boNo) {
		sqlSession.update("Board.incrementHit",boNo);
		
	}

	@Override
	public BoardVO selectBoard(int boNo) {		
		return sqlSession.selectOne("Board.selectBoard",boNo);
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		
		return sqlSession.update("Board.updateBoard",boardVO);
	}

	@Override
	public int deleteBoard(int boNo) {
		
		return sqlSession.update("Board.deleteBoard",boNo);
	}

	@Override
	public List<BoardVO> selectBoardList() {
		
		return sqlSession.selectList("Board.selectBoardList");
	}

}
