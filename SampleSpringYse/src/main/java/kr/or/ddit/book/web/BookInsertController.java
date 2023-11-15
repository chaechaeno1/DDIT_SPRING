package kr.or.ddit.book.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/*
 * @Controller 어노테이션이 있는 클래스는 스프링이 브라우저의 요청(request)을 받아들이는 컨트롤러라고 인지해서
 * 자바 빈(Java Bean)으로 등록해서 관리한다.
 */


@Controller
@RequestMapping("/book") ///book으로 시작하는 곳이면 이쪽으로 요청 매핑 시켜라!
public class BookInsertController {
	
	/*
	 * @RequestMapping
	 * - 요청 URL을 어떤 메소드가 처리할 지 여부를 결정
	 * 	>클래스 라인에 들어있다면 시작 URL을 처리
	 * 	>메소드 라인에 들어있다면 최종 목적이 URL을 처리
	 * 
	 * method 속성은 http요청 메소드를 의미합니다.
	 * 일반적인 웹 페이지 개발에서 GET 메소드는 데이터를 변경하지 않는 경우에, POST 메소드는 데이터가 변경될 때 사용
	 * 
	 * ModelAndView는 컨트롤러가 반환할 데이터를 담당하는 모델(Model)과 화면을 담당하는 뷰(View)의 경로를 합쳐놓은 객체
	 * ModelAndView의 생성자에 문자열 타입 파라미터가 입력되면 뷰의 경로라고 간주한다.
	 * 
	 * 뷰의 경로를 'book/form'과 같은 형태로 전달하는 이유는 요청(request)에 해당하는 url의 mapping되는
	 * 화면의 경로값을 ViewResolver라는 녀석이 제일 먼저 받게 됩니다. 받아서 suffix, prefix 속성에 의해서
	 * 앞에는 '/WEB-INF/views/'를 붙이고 뒤에는 '.jsp'를 붙여 최종 위치에 해당하는 jsp 파일을 찾아줍니다.
	 * 
	 * ViewResolver는 servlet-context.xml 파일에 있음
	 * 
	 * 
	 * 
	 */
	

	//bookForm() 메서드는 '/book/form.do'를 받는 최종 목적지
	//이때, return으로 나가는 정보가 'book/form'이라는 페이지 정보를 리턴
	//문자열로 이뤄진 페이지 정보이기 때문에 리턴 타입을 String으로 설정
	//페이지 정보를 리턴하는 방법은 여러가지가 존재한다.
	// - 문자열 그대로를 리턴하는 String, 문자열을 리턴타입으로 설정
	// - (현재 프로젝트에서는!!) ModelAndView 객체를 이용한 리턴설정
	
	
	//주소창에 입력하여 들어오므로 get방식으로
	//처음에 하나는 value로 인식하지만 여러개일 경우 문제
	//value="/form.do", method=RequestMethod.GET로 표현
	
	@RequestMapping(value="/form.do", method=RequestMethod.GET)
	public ModelAndView bookForm() {		
		return new ModelAndView("book/form");
		
	}
	
}
