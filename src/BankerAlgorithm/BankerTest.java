package BankerAlgorithm;

import java.util.Scanner;

public class BankerTest {
	
	private static Scanner in;
	
	public static void main(String[] args) {
		boolean choose = true;
		String C;
		in = new Scanner(System.in);
		BankerClass T = new BankerClass();
		System.out.println("这是一个三个进程，初始系统可用三类资源为{10,8,7}的银行家算法：");
		T.setSystemVariable();
		while (choose == true) {
			T.setRequest();
			System.out.println("您是否还要进行请求：y/n？");
			C = in.nextLine();
			if(C.endsWith("n")){
				choose = false;
			}
		}
	}
}
