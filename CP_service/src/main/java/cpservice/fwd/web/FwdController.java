package cpservice.fwd.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import cpservice.cmmn.dao.CommonDAO;
import cpservice.cmmn.domain.User;
import cpservice.fwd.service.FwdService;
import cpservice.fwd.service.FwdVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Controller
public class FwdController {
	@Autowired
	CommonDAO commonDAO;

	@Resource(name = "fwdService")
	public FwdService fwdService;
	
	@RequestMapping(value = "/list.do")
	public String list(User vo, Model model) throws Exception {
		
		System.out.println("1");
		List<?> list = fwdService.boardList(vo);
		System.out.println("2");
		model.addAttribute("list", list);
		System.out.println("3");
		return "sample/list";
		
	}

	
}
