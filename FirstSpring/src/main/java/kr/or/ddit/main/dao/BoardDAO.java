package kr.or.ddit.main.dao;

import java.util.List;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Repository
public class BoardDAO {
	
	@Inject
	private SqlSessionTemplate sqlSession;
	

	public List<BoardVO> selectBoardList(int count) {
	
		return sqlSession.selectList("Board.selectBoardMain");
	}

}
