package kr.or.ddit.notice.web;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.vo.NoticeVO;
import kr.or.ddit.vo.PaginationInfoVO;

@Controller
@RequestMapping("/notice")
public class NoticeRetrieveController {
	
	@Inject
	private INoticeService noticeservice;
	
	@RequestMapping(value="/list.do")
	public String noticeList(
			@RequestParam(name="page", required = false, defaultValue = "1") int currentPage,
			@RequestParam(required = false, defaultValue = "title") String searchType,
			@RequestParam(required = false) String searchWord,			
			Model model) {
		
		/*
		 * List<NoticeVO> noticeList = noticeservice.selectNoticeList();
		 * model.addAttribute("noticeList",noticeList);
		 */
		

		PaginationInfoVO<NoticeVO> pagingVO = new PaginationInfoVO<NoticeVO>();
		
		if(StringUtils.isNotBlank(searchWord)) {
			pagingVO.setSearchType(searchType);
			pagingVO.setSearchWord(searchWord);
			model.addAttribute("searchType",searchType);
			model.addAttribute("searchWord",searchWord);
		}
		
		pagingVO.setCurrentPage(currentPage);
		int totalRecord = noticeservice.selectNoticeCount(pagingVO);
		pagingVO.setTotalRecord(totalRecord);
		List<NoticeVO> dataList = noticeservice.selectNoticeList(pagingVO);
		pagingVO.setDataList(dataList);
		
		model.addAttribute("pagingVO", pagingVO);
		
		
		return "notice/list";
	}
	
	@RequestMapping(value="/detail.do", method = RequestMethod.GET)
	public String noticeDetail(int noticeNo, Model model) {
		NoticeVO noticeVO = noticeservice.selectNotice(noticeNo);
		model.addAttribute("notice", noticeVO);
		return "notice/view";
		
	}

}
