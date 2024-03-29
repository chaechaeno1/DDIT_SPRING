package kr.or.ddit.main.web;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.free.service.IFreeService;
import kr.or.ddit.main.service.IMainService;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.FreeVO;
import kr.or.ddit.vo.NoticeVO;

@Controller
public class MainController {

	/*
	 * @Inject private IBoardService boardService;
	 * 
	 * @Inject private IFreeService freeService;
	 * 
	 * @Inject private INoticeService noticeService;
	 */
	
	@Inject
	private IMainService mainService;
	
	
	@RequestMapping(value={"/","/main.do"}, method = RequestMethod.GET)
	public String main(Model model) {
		
		//일반게시판 최신글 5개 목록 가져오기
		List<BoardVO> boardList = mainService.selectBoardList();
		//공지사항, 게시판, 자유 게시판 최신글 5개 목록 가져오기
		List<NoticeVO> noticeList = mainService.selectNoticeList();
		List<FreeVO> freeList = mainService.selectFreeList();
		
		
		//일반, 공지, 자유 게시판의 총 게시글 수 가져오기
		Map<String,String> allCount = mainService.selectAllCount();
		
		//
		model.addAttribute("boardList", boardList);
		model.addAttribute("allCount", allCount);
		model.addAttribute("noticeList", noticeList);
		model.addAttribute("freeList", freeList);
		
		
		/*
		 * int boardCnt = boardService.selectBoardCount_();
		 * model.addAttribute("boardCnt",boardCnt);
		 * 
		 * int freeCnt = freeService.selectFreeCount_();
		 * model.addAttribute("freeCnt",freeCnt);
		 * 
		 * int noticeCnt = noticeService.selectNoticeCount_();
		 * model.addAttribute("noticeCnt",noticeCnt);
		 * 
		 * List<BoardVO> boardList = boardService.selectBoardList_();
		 * model.addAttribute("boardList", boardList);
		 * 
		 * List<FreeVO> freeList = freeService.selectFreeList_();
		 * model.addAttribute("freeList", freeList);
		 * 
		 * List<NoticeVO> noticeList = noticeService.selectNoticeList_();
		 * model.addAttribute("noticeList", noticeList);
		 */
		
				
		return "main";
	}
	
}
