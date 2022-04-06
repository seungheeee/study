/**
 * Description : 전자정부프레임워크, mysql, mybatis를 이용한 게시판 만들기 
 * 작성일 : 2022.04.06
 * 작성자 : ysh
 * Input Argument:
 *      
 * ………. 소스코드에 참고되는 내용 추가 작성 …….
 * 확인 사항 : 
 *      
 */
package board.fwd.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import board.fwd.service.BoardService;
import board.fwd.service.BoardVO;
import board.fwd.service.impl.BoardDAO;

@Controller
public class BoardController{

	@Autowired
	BoardDAO boardDAO;

	@Resource(name = "boardService")
	public BoardService boardService;

	@GetMapping("/write.do")
	public String write(Model model) throws Exception {
		return "write";
	}
	
	@PostMapping("/writeSuccess.do")
	public String writeSuccess(BoardVO boardVO) throws Exception {
		boardService.write(boardVO);
		return "redirect:/list.do";
	}
	
	@GetMapping("/created.do")
	public String created(int no, Model model, BoardVO boardVO) throws Exception {
		boardVO = boardService.read(no);
		model.addAttribute(boardVO);
		return "created";
	}
	
	@GetMapping(value = "/list.do")
	public String list(BoardVO boardVO, Model model) throws Exception {
		List<?> list = boardService.boardList(boardVO);
		model.addAttribute("list", list);
		return "list";
	}

	@GetMapping(value = "/update.do")
	public String update(int no, BoardVO boardVO, Model model) throws Exception {
		boardVO = boardService.read(no);
		model.addAttribute(boardVO);
		return "update";
	}
	
	@PostMapping("/updateSuccess.do")
	public String updateSuccess(@RequestParam int no, BoardVO boardVO) throws Exception {
		boardService.update(boardVO);
		return "redirect:/list.do";
	}
	
	@GetMapping("/delete.do")
	public String delete(@RequestParam int no) throws Exception {
		boardService.delete(no);
		return "redirect:/list.do";
	}
	
	@PostMapping("/deleteSelect.do")
	public String delectSelect(@RequestParam ("checkno") int[] checkno) throws Exception {
		for(int no : checkno) {
			boardService.delectSelect(no);
		}
		return "redirect:/list.do";
	}
}
