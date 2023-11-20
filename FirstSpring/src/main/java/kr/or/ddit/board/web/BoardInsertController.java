package kr.or.ddit.board.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardInsertController {

	@RequestMapping(value="/form.do", method=RequestMethod.GET)
	public String boardForm() {
		return "board/form";
	}
	
	@RequestMapping(value="/insert.do", method = RequestMethod.POST)
	public String boardInsert(BoardVO boardVO) {
		
		String goPage = ""; //페이지 정보를 담을 변수
		Map<String, String> errors = new HashMap<String, String>(); //에러를 담을 변수 
		
		
		//boardVO.getBoTitle().equals("") && boardVO.getBoTitle() == null
		
		// 클라이언트에서 넘어온 제목, 내용에 대한 데이터가 공백 또는 null로 들어오진 않는다.
		// 하지만, 데이터가 혹시나 검증되지 않고 서버로 넘어올 시 에러가 발생할 확률이 가장 높기 때문에
		// 서버에서도 데이터에 대한 입력값 검증에 대한 필터를 걸어준다.
		// 클라이언트에서 1번 거르고, 서버에서 한번 더 거른다.
		if(StringUtils.isBlank(boardVO.getBoTitle())) {
			errors.put("boTitle","제목을 입력해주세요!!");
			
		}
		
		if(StringUtils.isBlank(boardVO.getBoContent())) {
			errors.put("boContent","내용을 입력해주세요!!");
			
		}
		
	}
	
	
}
