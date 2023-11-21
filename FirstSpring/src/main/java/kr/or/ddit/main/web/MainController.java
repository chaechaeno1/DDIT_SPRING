package kr.or.ddit.main.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.main.service.BoardService;
import kr.or.ddit.vo.BoardVO;

@Controller
public class MainController {
	
	@Inject
	private BoardService boardService;

	@RequestMapping(value={"/","/main.do"}, method = RequestMethod.GET)
	public String main(Model model) {
		List<BoardVO> BoardListMain = boardService.getLatestBoardList(5);
		
		model.addAttribute("BoardListMain", BoardListMain);
		
		return "main";
	}
	
	
	
}
