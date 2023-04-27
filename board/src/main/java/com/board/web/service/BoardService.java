package com.board.web.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.board.web.vo.BoardVO;

//Description : 구현할 기능의 명세서

@Service
public interface BoardService{
	public void write(BoardVO boardVO) throws Exception;
	BoardVO read(int no) throws Exception;
	public List<BoardVO> boardList(BoardVO boardVO) throws Exception;
	public void update(BoardVO boardVO) throws Exception;
	public void delete(int no) throws Exception;
	public void deleteSelect(int[] checkno) throws Exception;
}
