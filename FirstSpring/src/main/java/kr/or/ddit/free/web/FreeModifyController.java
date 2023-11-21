package kr.or.ddit.free.web;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.free.service.IFreeService;
import kr.or.ddit.vo.FreeVO;

@Controller
@RequestMapping("/free")
public class FreeModifyController {
	
	@Inject
	private IFreeService freeService;

	@RequestMapping(value="/update.do", method = RequestMethod.GET)
	public String freeUpdateForm(int freeNo, Model model) {
		FreeVO freeVO = freeService.selectFree(freeNo);
		model.addAttribute("free", freeVO);
		model.addAttribute("status","u"); 
		return "free/form"; 
		
	}
	
	@RequestMapping(value="/update.do", method = RequestMethod.POST)
	public String noticeUpdate(FreeVO freeVO, Model model) {
		String goPage = "";
		
		ServiceResult result = freeService.updateFree(freeVO);
		if(result.equals(ServiceResult.OK)) { //수정 성공
			goPage = "redirect:/free/detail.do?freeNo="+freeVO.getFreeNo();
		}else { //수정 실패
			model.addAttribute("free",freeVO); //보 객체 보낸다
			model.addAttribute("status","u"); //수정 상태임을 보낸다
			goPage = "free/form";
			
		}
		
		return goPage;
	}
	
	@RequestMapping(value="/delete.do", method = RequestMethod.POST)
	public String deleteFree(int freeNo, Model model) {
		String goPage = "";
		
		ServiceResult result =  freeService.deleteFree(freeNo);
		if(result.equals(ServiceResult.OK)) { //삭제 성공
			
			goPage = "redirect:/free/list.do";
			
		}else { //삭제 실패
			goPage = "redirect:/free/detail.do?freeNo="+freeNo;			
		}		
		return goPage;
	}

}
