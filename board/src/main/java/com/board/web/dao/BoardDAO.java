package com.board.web.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.board.web.vo.BoardVO;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository
public class BoardDAO extends EgovAbstractMapper{
	//사용자가 작성한 내용 데이터 저장
	public void insert(BoardVO boardVO) throws Exception{
		insert("insert", boardVO);
	}
	
	//리스트에서 선택한 글의 내용 전체를 확인 
	public BoardVO select(int no) throws Exception{
		return selectOne("select", no);
	}
	
	//저장된 글의 리스트 조회
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<BoardVO> boardList(BoardVO boardVO) throws Exception{
		return (List<BoardVO>) list("boardList", boardVO);
	}
	
	//게시글의 내용을 수정하여 데이터에 저장
	public void update(BoardVO boardVO) throws Exception{
		update("update", boardVO);
	}
	
	//게시글 삭제
	public void delete(int no) throws Exception{
		delete("delete", no);
	}
	
	//게시글 선택삭제
	public void deleteSelect(int[] checkno) throws Exception{
		delete("deleteSelect", checkno);
	}

}
