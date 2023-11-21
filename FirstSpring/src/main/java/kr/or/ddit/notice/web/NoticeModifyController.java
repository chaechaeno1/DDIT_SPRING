package kr.or.ddit.notice.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.vo.BoardVO;
import kr.or.ddit.vo.NoticeVO;

@Controller
@RequestMapping("/notice")
public class NoticeModifyController {
	
	@Inject
	private INoticeService noticeService;

	@RequestMapping(value="/update.do", method = RequestMethod.GET)
	public String noticeUpdateForm(int noticeNo, Model model) {
		NoticeVO noticeVO = noticeService.selectNotice(noticeNo);
		model.addAttribute("notice", noticeVO);
		model.addAttribute("status","u"); //'현재 기능은 수정입니다'를 알리기 위한 flag
		return "notice/form"; //이상태로 넘어가면 등록인지 수정인지 구별 불가능(그래서 위에서 u사용하는것)
		
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	public String noticeUpdate(NoticeVO noticeVo, Model model) {
		String goPage = "";
		
		ServiceResult result = noticeService.updateBoard(noticeVo);
		if(result.equals(ServiceResult.OK)) { //수정 성공
			goPage = "redirect:/notice/detail.do?noticeNo="+noticeVo.getNoticeNo();
		}else { //수정 실패
			model.addAttribute("notice",noticeVo); //보 객체 보낸다
			model.addAttribute("status","u"); //수정 상태임을 보낸다
			goPage = "notice/form";
			
		}
		
		return goPage;
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.POST)
	public String deleteBoard(int noticeNo, Model model) {
		String goPage = "";
		
		ServiceResult result =  noticeService.deleteBoard(noticeNo);
		if(result.equals(ServiceResult.OK)) { //삭제 성공
			
			goPage = "redirect:/notice/list.do";
			
		}else { //삭제 실패
			goPage = "redirect:/notice/detail.do?noticeNo="+noticeNo;			
		}		
		return goPage;
	}

}
