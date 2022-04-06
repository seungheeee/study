package board.fwd.service;

import java.util.List;

public interface BoardService{
	public void write(BoardVO boardVO) throws Exception;
	BoardVO read(int no) throws Exception;
	public List<?> boardList(BoardVO boardVO) throws Exception;
	public void update(BoardVO boardVO) throws Exception;
	public void delete(int no) throws Exception;
	public void delectSelect(int no) throws Exception;
}
