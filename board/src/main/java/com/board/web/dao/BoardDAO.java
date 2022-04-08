package com.board.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.board.web.vo.BoardVO;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class BoardDAO extends EgovAbstractMapper{
	public void insert(BoardVO boardVO) throws Exception{
		insert("insert", boardVO);
	}
	
	public BoardVO select(int no) throws Exception{
		return selectOne("select", no);
	}
	
	@SuppressWarnings("deprecation")
	public List<?> boardList(BoardVO boardVO) throws Exception{
		return list("boardList", boardVO);
	}
	
	public void update(BoardVO boardVO) throws Exception{
		update("update", boardVO);
	}
	
	public void delete(int no) throws Exception{
		delete("delete", no);
	}
}
