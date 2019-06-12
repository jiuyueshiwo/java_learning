package day01;

import java.util.Scanner;

public class Variable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Variable v001 = new Variable();
		v001.go();
	}
	public void go(){
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入年龄\n");
		int age = scan.nextInt();
		System.out.println("年龄是"+age+"\n");
	}

}
