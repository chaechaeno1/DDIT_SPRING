package kr.or.ddit.book.dao;

import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


//데이터 처리 담당

/*
 * 어노테이션(@) Reposiotry는 데이터에 접근하는 클래스임을 명시한다.
 * 해당 어노테이션이 있는 클래스는 스프링이 데이터를 관리하는 클래스라고 인지하여
 * 자바 빈(Java Bean)으로 등록해서 관리한다.
 * 
 * SqlSessionTemplate 객체를 멤버 변수로 선언하는 이유는 mapper xml을 실행시키기 위해서다.
 * 해당 객체 위에 @Inject 또는 @Autowired를 붙여서 sqlSessionTemplate 객체를 사용할 수 있도록 한다.
 * 이러한 형태를 '의존성 주입'이라고 한다. (필드 인젝션(Field Injection))
 * 
 * SqlSessionTemplate 객체는 new 키워드를 통해 직접 생성하지 않고, 의존성 주입(Dependency Injection - DI)
 * 를 통해 주입받는다.
 * 스프링은 미리 만들어 놓은 SqlSessionTemplate 타입 객체를 BookDAO 클래스 안에서 사용한다.
 * 해당 과정은 스프링에서 자동 실행되며 개발자가 직접 SqlSessionTemplate 객체를 생성하는 일 없이 곧바로 사용할 수 있다.
 * 
 * SqlSessionTemplate 객체는 root-Context.xml에서 정의해둔 객체이기도 하고, 서버가 시작될 때
 * 스프링은 미리 xml을 읽어 객체를 인스턴스화 해둔다.
 */
@Repository
public class BookDAO {
	
	/*
	 * 매퍼xml을 실행시키기 위해서 SqlSessionTemplate 객체를 멤버 변수로 선언한다.
	 * @Inject를 붙여서 SqlSessionTemplate 객체를 사용할 수 있게 한다.
	 * 
	 */

	//멤버변수로 선언 -> mapper.xml 실행
	@Inject	
	private SqlSessionTemplate sqlSession;
	
	
	/*
	 * sqlSessionTemplate.insert()
	 * 1) 첫번째 파라미터는 SQL Mapper의 id이다.
	 * 		book_SQL.xml에서는 namespace로 설정한 'Book'과 insert쿼리를 실행하기 위해 만든 insert문의
	 * 		id의 값 'insert'이다
	 * 		mybatis는 네임스페이스 + id 조합으로 쿼리를 찾아서 실행한다.
	 * 2) 두번째 파라미터는 쿼리에 전달할 데이터 이다.
	 * 		mapper 내 insert 쿼리를 실행하기 위해 전달되어지는 parameterType이 map이다.
	 * 
	 * 외부에서 Dao까지 map에 title, category, price가 담겨져서 온다.
	 * 그리고, useGenerateKeys와 KeyProperty의 설정 덕분에 book 테이블의 pk인 book_id 항목이 생긴다.
	 * 
	 * 
	 */
	
	public int insert(Map<String, Object> map) {
		/*
		 * userGeneratedKeys와 KeyProperty설정에 따라서 쿼리가 실행되고 나면
		 * 파라미터로 전달된 map 객체에 book 테이블의 PK인 book_id항목이 생김
		 * 
		 * 기존 Map :::
		 * {
		 * 	"title" : "제목", "category" : "카테고리", "price" : 1000
		 * }
		 * 
		 * 쿼리 실행 후 Map :::
		 * {
		 * 	"title" : "제목", "category" : "카테고리", "price" : 1000, "book_id" : 1
		 * }
		 * 
		 * sqlSessionTemplate.insert()의 반환값은 쿼리의 영향을 받은 행 수(row count)이다.
		 * insert 쿼리의 경우 성공하면 1개의 행(row)이 생기므로 1을 리턴하고 실패하면 0을 리턴한다.
		 * 
		 */
		
		
		//Book.insert : 네임스페이스명.메서드명
		return sqlSession.insert("Book.insert", map);
	}


	public Map<String, Object> selectBook(Map<String, Object> map) {
		/*
		 * sqlSessionTemplate의 selectOne 메소드는 데이터를 한 개만 가져올 때 사용
		 * 만약 쿼리 결과 행 수가 0개면 selectOne 메소드는 null 반환,
		 * 쿼리 결과가 여러개면 TooManyResultException 예외를 던진다.
		 * 우리가 작성한 쿼리는 조건이 pk이고, pk는 무조건 행이 유일함을 보장하기 때문에 결과는 0개 아니면 1개이다.
		 * 
		 */
		return sqlSession.selectOne("Book.selectBook", map);
	}


	public int updateBook(Map<String, Object> map) {
		/*
		 * sqlSessionTemplate 객체의 update 메소드는 insert 메소드와 사용법이 돌일하다.
		 * 첫번재 파라미터는 쿼리 ID, 두번째 파라미터는 쿼리 파라미터이며 반환값은 영향받은 행 수 이다.
		 */
		return sqlSession.update("Book.updateBook", map);
	}
	
}
