package kr.or.ddit.notice.web;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;

@Controller
@RequestMapping("/notice")
public class NoticeInsertController {
	
	@Inject
	private INoticeService noticeservice;

	@RequestMapping(value = "/form.do", method=RequestMethod.GET)
	public String noticeForm() {
		return "notice/form";
	}
	
	@RequestMapping(value="/insert.do", method = RequestMethod.POST)
	public String noticeInsert(NoticeVO noticeVO, Model model) {
		
		String goPage = "";
		Map<String, String> errors = new HashMap<String, String>();
		
		if(StringUtils.isBlank(noticeVO.getNoticeTitle())) {
			errors.put("noTitle", "제목을 입력해주세요!");
		}
		
		if(StringUtils.isBlank(noticeVO.getNoticeContent())) {
			errors.put("noContent", "내용을 입력해주세요!");
		}
		
		if(errors.size() > 0) { //에러가 있는 경우
			model.addAttribute("noticeVO", noticeVO);
			model.addAttribute("errors",errors);
			
			goPage = "notice/form";
			
			
		}else {//에러가 없는 경우
			noticeVO.setNoticeWriter("b001");
			
			//enum
			ServiceResult result = noticeservice.insertNotice(noticeVO);
			
			if(result.equals(ServiceResult.OK)) {
				goPage = "redirect:/notice/detail.do?noticeNo="+noticeVO.getNoticeNo();
			}else {
				model.addAttribute("notice",noticeVO);
				model.addAttribute("message","서버 에러, 다시 시도해주세요!");
				goPage = "notice/form";
			}
			
		}
		return goPage;
		
	
	}
	
}
