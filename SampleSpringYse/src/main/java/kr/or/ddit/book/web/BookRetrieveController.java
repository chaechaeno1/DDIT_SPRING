package kr.or.ddit.book.web;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.book.service.IBookService;

//원래 클래스 하나에 메서드 여러개 가능하나, 편의상 나누어서 진행

@Controller
@RequestMapping("/book")
public class BookRetrieveController {

	@Inject	
	private IBookService service;
		
	@RequestMapping(value="/detail.do", method =RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String,Object> map){
		ModelAndView mav = new ModelAndView();
		
		// 데이터베이스에서 조회한 결과를 detailMap변수에 담는다.
		Map<String, Object> detailMap = service.selectBook(map);
		// ModelAndView 객체 mav에 뷰로 전달할 데이터를 담는다.
		// book 이라는 키의 이름으로 쿼리의 결과를 담았다.
		mav.addObject("book", detailMap);
		// Book의 pk인 bookId도 mav 객체에 담는다.
		String bookId = map.get("bookId").toString();
		mav.addObject("bookId", bookId);
		// 응답으로 나갈 페이지 정보 설정
		mav.setViewName("book/detail");
		
		return mav;
		
	}
	
}
