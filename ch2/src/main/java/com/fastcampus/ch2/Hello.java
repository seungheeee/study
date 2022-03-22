package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//1. ���� ȣ�Ⱑ���� ���α׷����� ���
@Controller
public class Hello {
	//2. URL�� �޼��带 ����
	@RequestMapping("/hello")
	public void main() {
		//static�� ��� ����Ǵ� ����
		//���� �������� ��ü ���� �� �޼��� ȣ���ϱ� ������
		//�� �ν��Ͻ� �޼��带 ����ϴ���?
		//cv, iv ��� ��� �����ؼ� �����ϴϱ�
		System.out.println("Hello");
	}
	
	@RequestMapping("/hello2")
	private void main2() {
		//private�ε��� ����Ǵ� ������ requestmapping�� �ܺο��� ����ϰڴٴ� ���̹Ƿ� �����ڿ� ������� �����
		//�ܺο����� ���� �����ϰ� ���ο����� private
		System.out.println("Hello-private");
	}
}
