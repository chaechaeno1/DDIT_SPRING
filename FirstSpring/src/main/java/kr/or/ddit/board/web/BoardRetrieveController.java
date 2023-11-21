package kr.or.ddit.board.web;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Controller
@RequestMapping("/board")
public class BoardRetrieveController {
	
	@Inject
	private IBoardService boardService;
	

	@RequestMapping(value="/list.do")
	public String boardList(
			@RequestParam(name="page", required = false, defaultValue = "1") int currentPage, 
			//클라이언트에서 보내는 건 page, 서버에서 사용하는건 currentPage, required가 false면 필수값은 아니지만, 디폴드밸류로 인해서 값을 보내지 않으면 무조건 1을 받아옴
			@RequestParam(required = false, defaultValue = "title") String searchType, //검색 타입
			@RequestParam(required = false) String searchWord, //검색 키워드
			Model model) {
		
		//방법 1 - 기본적인 목록 조회 시 사용
		//List<BoardVO> boardList = boardService.selectBoardList();
		//model.addAttribute("boardList", boardList);
		
		//방법 2 - PaginationInfoVO 클래스를 활용한 목록 조회 시 사용
		PaginationInfoVO<BoardVO> pagingVO = new PaginationInfoVO<BoardVO>();
		
		//브라우저에서 검색한 검색 유형, 검색 키워드를 이용하여 검색 처리 조건문
		// 검색 키워드가 있으면 검색을 한거고, 키워드가 없으면 검색을 하지 않음
		if(StringUtils.isNotBlank(searchWord)) { //검색 키워드가 비어있지 않으면(있으면)
			pagingVO.setSearchType(searchType);
			pagingVO.setSearchWord(searchWord);
			model.addAttribute("searchType", searchType);
			model.addAttribute("searchWord", searchWord);
		}
		
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = boardService.selectBoardCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<BoardVO> dataList = boardService.selectBoardList(pagingVO);
		pagingVO.setDataList(dataList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		return "board/list";
	}
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String boardDetail(int boNo, Model model) { //내가 받고싶은 타입으로 지정해주면 그대로 들어옴(ex. int) 원래는 스트링으로 무조건 들어와서 변환해야했었음.
		BoardVO boardVO = boardService.selectBoard(boNo);
		model.addAttribute("board",boardVO); //view.jsp에서 ${board.boTitle} 처럼 객체 부를때 사용할 것
		return "board/view";
	}
	
	
}
