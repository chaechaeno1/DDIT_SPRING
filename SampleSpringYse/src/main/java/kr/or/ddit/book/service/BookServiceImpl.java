package kr.or.ddit.book.service;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import kr.or.ddit.book.dao.BookDAO;

//IBookService를 참조받은 클래스인 것
/*
 * 일반적으로 서비스 레이어는 인터페이스와 클래스를 함께 사용한다.
 * 스프링은 직접 클래스를 생성하는 것을 지양하고 인터페이스를 통해 접근하는 것을 권장하는 프레임워크이다.
 */

@Service
public class BookServiceImpl implements IBookService {
	/*
	 * Service 클래스는 비즈니스 클래스가 위치하는 곳이다.
	 * +) '비즈니스 클래스'란? : 비즈니스 로직을 담당하고 있는 클래스
	 * +) 비즈니스 로직은 어떤 애플리케이션에서 특정 업무나 기능을 수행하기 위한 실제 작업을 말하며, 이를 담당하는 클래스들이 비즈니스 클래스
	 * 
	 * 스프링 MVC 구조에서 서비스 클래스는 컨트롤러와 DAO를 연결하는 역할을 한다.
	 * 
	 * 어노테이션(@) Service는 스프링에 서비스 클래스임을 알려준다.
	 * 
	 * 데이터베이스 접근을 위해 BookDAO 인스턴스를 주입받는다.
	 * 클래스의 이름이 Impl로 끝나는 것은 implements의 약자로 관습에 따라
	 * Impl이 붙고 안붙고에 따라 클래스인지 인터페이스인지 구별하기 쉽다.
	 */
	
	@Inject
	private BookDAO dao;
	
	
	/**
	 * 메서드 명 위에 커서 올려놓고 alt+shift+j
	 *
	 *	<p>책 등록</p>
	 *	@since SampleSpringYse
	 *  @author ddit
	 *  @param map 등록할 책 데이터
	 *  @return 성공 책ID, 실패 null
	 *  
	 */
	@Override
	public String insertBook(Map<String, Object> map) {
		//status 변수에는 영향 받은 행수가 담긴다.
		//insert 구문은 입력이 성공하면 1, 실패하면 0을 리턴한다.
		int status = dao.insert(map);
		
		if(status == 1) {
			//결과가 성공일 때, map 인스턴스에 book 테이블의 pk인 book_id가 담겨있다.
			return map.get("book_id").toString();
		}		
		return null;
	}

	
	
	/**
	 *<p> 책 상세보기 </p>
	 *@since SampleSpringYse 1.0
	 *@author ddit
	 *@param map 책ID
	 *@return ID에 해당하는 책 정보
	 */
	@Override
	public Map<String, Object> selectBook(Map<String, Object> map) {
		//서비스 내 detail함수는 dao를 호출한 결과를 바로 리턴하는 일만 한다.
		return dao.selectBook(map);
	}

		


	/**
	 * <p> 책 수정</p>
	 * @since SampleSpringYse
	 * @author ddit
	 * @param map 책ID
	 * @return 성공1(true), 실패 0(false)
	 *
	 */
	@Override
	public boolean updateBook(Map<String, Object> map) {
		//수정의 경우 입력과는 다르게 PK를 가져오거나 하는 절차가 필요 없으므로 행이 정상적으로 영향 받았는지만 검사하면 됨
		int status = dao.updateBook(map);
		return status == 1;
	}

}
