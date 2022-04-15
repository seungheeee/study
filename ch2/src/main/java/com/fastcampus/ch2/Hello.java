package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. 원격 호출가능한 프로그램으로 등록
@Controller
public class Hello {
	//2. URL과 메서드를 연결
	@RequestMapping("/hello")
	public void main() {
		//static이 없어도 실행되는 이유
		//원격 서버에서 객체 생성 후 메서드 호출하기 때문에
		//왜 인스턴스 메서드를 사용하느냐?
		//cv, iv 모두 사용 가능해서 유용하니까
		System.out.println("Hello");
	}
	
	@RequestMapping("/hello2")
	private void main2() {
		//private인데도 실행되는 이유는 requestmapping이 외부에서 사용하겠다는 것이므로 제어자에 상관없이 실행됨
		//외부에서는 실행 가능하고 내부에서는 private
		System.out.println("Hello-private");
	}
}
