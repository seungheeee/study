package com.board.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ErrorController {
    
    @RequestMapping("/badRequest.do")
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    public String badRequest(Model model) {

        model.addAttribute("errorMsg", "잘못된 요청입니다.");
        model.addAttribute("errorDescription", "잘못된 데이터가 전송되었습니다.<br>데이터를 확인한 뒤 다시 시도하여주십시오.");

        return "error/error";
    }
    
    @RequestMapping("/forbidden.do")
    @ResponseStatus(value=HttpStatus.FORBIDDEN)
    public String accessDenied(Model model) {
        
        model.addAttribute("errorMsg", "접근 권한이 없습니다.");
        model.addAttribute("errorDescription", "접근권한이 있는 계정으로 로그인하시기 바랍니다.");

        return "error/error";
    }

    @RequestMapping("/notFound.do")
    @ResponseStatus(value=HttpStatus.NOT_FOUND)
    public String notFound(Model model) {

        model.addAttribute("errorMsg", "페이지를 찾을 수 없습니다.");
        model.addAttribute("errorDescription", "페이지를 잘못 입력하셨거나 삭제되었습니다.");

        return "error/error";
    }
    
    @RequestMapping("/methodNotAllowed.do")
    @ResponseStatus(value=HttpStatus.METHOD_NOT_ALLOWED)
    public String methodNotAllowed(Model model) {
        
        model.addAttribute("errorMsg", "서비스가 원활하지 않습니다.");
        model.addAttribute("errorDescription", "HTTP 비활성화가 되어있거나 잘못된 요청입니다.");

        return "error/error";
    }

    @RequestMapping("/internalServerError.do")
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
    public String internalServerError(Model model) {
        
        model.addAttribute("errorMsg", "예상하지 못한 오류가 발생했습니다.");

        return "error/error";
    }
    
    @RequestMapping("/serviceUnavailable.do")
    @ResponseStatus(value=HttpStatus.SERVICE_UNAVAILABLE)
    public String serviceUnavailable(Model model) {
        
        model.addAttribute("errorMsg", "서비스가 원활하지 않습니다.");
        model.addAttribute("errorDescription", "사용자가 많거나 오류로 인하여 서비스가 원활하지 않습니다.<br>잠시 후 다시 시도해보시거나 문제가 지속되는 경우 관리자에게 문의하시기 바랍니다.");

        return "error/error";
    }
    

   
}
