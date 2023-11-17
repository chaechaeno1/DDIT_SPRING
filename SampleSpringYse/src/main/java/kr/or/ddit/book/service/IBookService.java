package kr.or.ddit.book.service;

import java.util.Map;

public interface IBookService {

	public String insertBook(Map<String, Object> map);

	public Map<String, Object> selectBook(Map<String, Object> map);

	public boolean updateBook(Map<String, Object> map);

}
