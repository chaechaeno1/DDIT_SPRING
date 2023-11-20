package kr.or.ddit.board.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardRetrieveController {
	
	@Inject
	private IBoardService boardService;
	

	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public String boardList() {
		return "board/list";
	}
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String boardDetail(int boNo, Model model) { //내가 받고싶은 타입으로 지정해주면 그대로 들어옴(ex. int) 원래는 스트링으로 무조건 들어와서 변환해야했었음.
		BoardVO boardVO = boardService.selectBoard(boNo);
		model.addAttribute("board",boardVO); //view.jsp에서 ${board.boTitle} 처럼 객체 부를때 사용할 것
		return "board/view";
	}
	
	
}
