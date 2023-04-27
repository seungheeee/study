package com.board.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.web.dao.BoardDAO;
import com.board.web.service.BoardService;
import com.board.web.vo.BoardVO;

@Controller
public class BoardController{

	@Autowired
	BoardDAO boardDAO;

	@Resource(name = "boardService")
	public BoardService boardService;
	
	/**
	 * Description : 게시판 글을 작성하는 페이지를 띄워주는 메소드
	 *
	 * Return
	 *    @return write.jsp를 view로 보여준다.
	 */
	@GetMapping("/write.do")
	public String write() throws Exception{
		return "board/write";
	}
	
	/**
	 * Description : 게시글 작성완료 시 작성한 내용을 데이터베이스에 저장하고
	 *            	  저장된 게시글의 목록을 보여주는 메소드
	 *
	 * Parameter
	 *    @param BoardVO no, name, subject, content, date를 담아 데이터베이스에 저장시킨다. 
	 * Return
	 *    @return 작성된 글까지 반영된 list.jsp를 view로 보여준다.
	 */
	@PostMapping("/writeSuccess.do")
	public String writeSuccess(BoardVO boardVO) throws Exception{
		boardService.write(boardVO);
		return "redirect:/list.do";
	}
	
	/**
	 * Description : 작성했던 게시글의 내용을 데이터베이스로부터 가져와 보여주는 메소드
	 *
	 *    @param no 글의 key값으로 url에 넘어오는 no를 이용해 name, content, date를 조회한다
	 *    @param BoardVO no로 데이터베이스를 조회한 값을 담는다.
	 * Return
	 *    @return created.jsp를 view로 보여준다.
	 */
	@GetMapping("/created.do")
	public String created(int no, Model model, BoardVO boardVO) throws Exception{
		boardVO = boardService.read(no);
		model.addAttribute(boardVO);
		return "board/created";
	}
	
	/**
	 * Description : 작성한 게시글의 목록을 보여주는 메소드
	 *
	 * Parameter
	 *    @param BoardVO 저장된 게시글의 정보를 담는다.
	 * Return
	 *    @return list.jsp를 view로 보여준다.
	 */
	@GetMapping(value = "/list.do")
	public String list(BoardVO boardVO, Model model) throws Exception{
		List<BoardVO> list = boardService.boardList(boardVO);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	/**
	 * Description : 작성한 게시글을 수정하는 메소드
	 *
	 * Parameter
	 *    @param no 게시글의 key값으로 url로 넘어오는 no를 이용해 
	 *    			기존에 작성했던 내용을 데이터베이스로부터 불러온다.
	 * Return
	 *    @return update.jsp를 view로 보여준다.
	 */
	@GetMapping(value = "/update.do")
	public String update(int no, BoardVO boardVO, Model model) throws Exception{
		boardVO = boardService.read(no);
		model.addAttribute(boardVO);
		return "board/update";
	}
	
	/**
	 * Description : 수정 완료 시 수정된 내용을 데이터베이스에 update하고
	 * 				 게시글 리스트를 보여주는 메소드
	 *
	 * Parameter
	 *    @param no 게시글의 key값으로 no를 이용해 
	 *    			기존에 작성했던 내용의 데이터베이스를 수정한다.
	 *    @param BoardVO 수정한 게시글의 내용을 담는다.
	 * Return
	 *    @return 수정된 내용을 반영한 list.jsp를 view로 보여준다.
	 */
	@PostMapping("/updateSuccess.do")
	public String updateSuccess(@RequestParam int no, BoardVO boardVO) throws Exception{
		boardService.update(boardVO);
		return "redirect:/list.do";
	}
	
	/**
	 * Description : 게시글을 삭제하고 게시글 리스트를 보여주는 메소드
	 *
	 * Parameter
	 *    @param no 게시글의 key값으로 url로 넘어온 no를 이용해 
	 *    			기존에 작성했던 내용을 데이터베이스로부터 삭제한다.
	 * Return
	 *    @return 삭제한 내용을 반영한 list.jsp를 view로 보여준다.
	 */
	@GetMapping("/delete.do")
	public String delete(int no) throws Exception{
		boardService.delete(no);
		return "redirect:/list.do";
	}
	
	/**
	 * Description : 여러 개의 글을 한번에 삭제하고 게시글 리스트를 보여주는 메소드
	 *
	 * Parameter
	 *    @param checkno 선택한 체크박스의 checkno를 배열로 담는다.
	 * Return
	 *    @return 삭제한 내용을 반영한 list.jsp를 view로 보여준다.
	 */
	@PostMapping("/deleteSelect.do")
	public String delectSelect(@RequestParam ("checkno") int[] checkno) throws Exception{
			boardService.deleteSelect(checkno);
		return "redirect:/list.do";
	}

}
