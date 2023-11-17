package kr.or.ddit.book.web;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.book.service.IBookService;

@Controller
@RequestMapping("/book")
public class BookModifyController {

	@Inject
	private IBookService service;

	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView updateForm(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();

		// 데이터베이스에서 조회한 결과를 detailMap변수에 담는다.
		Map<String, Object> detailMap = service.selectBook(map);
		// ModelAndView 객체 mav에 뷰로 전달할 데이터를 담는다.
		// book 이라는 키의 이름으로 쿼리의 결과를 담았다.
		mav.addObject("book", detailMap);
		// 응답으로 나갈 페이지 정보 설정
		mav.setViewName("book/update");

		return mav;

	}

	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();

		boolean result = service.updateBook(map);
		if (result) {
			// 업데이트가 정상적으로 데이터 갱신되었을 때 확인을 위해서 상세페이지로 이동
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/book/detail.do?bookId=" + bookId);
		} else {
			// 갱신 되지 않았을 때 GET메서드로 redirect하는 방법도 있지만, 상세보기 화면을 바로 보여줄 수도 있음.
			mav = updateForm(map);
		}

		return mav;

	}

	@RequestMapping(value = "/delete.do", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();

		// 삭제가 성공했는지 확인한다.
		boolean result = service.removeBook(map);
		if (result) {
			// 삭제가 성공했으면 상세 페이지가 없으므로 목록으로 redirect 한다.
			mav.setViewName("redirect:/book/list.do");
		} else {
			// 삭제가 실패했으면 다시 상세페이지로 이동한다.
			String bookId = map.get("bookId").toString();
			mav.setViewName("redirect:/book/detail.do?bookId=" + bookId);

		}

		return mav;

	}

}
