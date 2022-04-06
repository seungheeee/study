package board.fwd.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import board.fwd.service.BoardService;
import board.fwd.service.BoardVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("boardService")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService{
	@Resource(name="boardDAO")
	public BoardDAO boardDAO;
	
	@Override
	public void write(BoardVO boardVO) throws Exception {
		boardDAO.insert(boardVO);
	}
	
	@Override
	public BoardVO read(int no) throws Exception {
		BoardVO boardVO = boardDAO.select(no);
		return boardVO;
	}
	
	@Override
	public List<?> boardList(BoardVO vo) throws Exception {
		return boardDAO.boardList(vo);
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {
		boardDAO.update(boardVO);
	}

	@Override
	public void delete(int no) throws Exception {
		boardDAO.delete(no);
	}
	
	@Override
	public void delectSelect(int no) throws Exception {
		boardDAO.delete(no);
	}
}
