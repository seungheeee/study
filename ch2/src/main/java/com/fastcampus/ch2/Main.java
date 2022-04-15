package com.fastcampus.ch2;

import java.lang.reflect.Method;

public class Main {
	public static void main(String[] args) throws Exception {
		//Hello hello = new Hello();
		//hello.main2();// private�̶� �ܺ� ȣ�� �Ұ�
		
		//Reflection API�� ��� - Ŭ���� ������ ��� �ٷ� �� �ִ� ������ �������
		//java.lang.reflect ��Ű���� ����
		//Hello Ŭ������ Class ��ü(Ŭ������ ������ ��� �ִ� ��ü)�� ���´�.
		Class helloClass = Class.forName("com.fastcampus.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // class��ü�� ���� ������ ��ü ����
		Method main = helloClass.getDeclaredMethod("main");
		main.setAccessible(true); //private�� ,main()�� ȣ�Ⱑ���ϰ� �Ѵ�.
		
		main.invoke(hello);//hello.main()
	}
}