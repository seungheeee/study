package com.board.web.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.board.web.dao.BoardDAO;
import com.board.web.vo.BoardVO;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("boardService")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService{
	@Resource(name="boardDAO")
	public BoardDAO boardDAO;
	
	//사용자가 작성한 내용 데이터 저장
	@Override
	public void write(BoardVO boardVO) throws Exception {
		boardDAO.insert(boardVO);
	}
	
	//리스트에서 선택한 글의 내용 전체를 확인
	@Override
	public BoardVO read(int no) throws Exception {
		BoardVO boardVO = boardDAO.select(no);
		return boardVO;
	}
	
	//저장된 글의 리스트 조회
	@Override
	public List<BoardVO> boardList(BoardVO vo) throws Exception {
		return boardDAO.boardList(vo);
	}

	//게시글의 내용을 수정하여 데이터에 저장
	@Override
	public void update(BoardVO boardVO) throws Exception {
		boardDAO.update(boardVO);
	}

	//게시글 삭제
	@Override
	public void delete(int no) throws Exception {
		boardDAO.delete(no);
	}
	
	@Override
	public void deleteSelect(int[] checkno) throws Exception {
		boardDAO.deleteSelect(checkno);
	}

}
