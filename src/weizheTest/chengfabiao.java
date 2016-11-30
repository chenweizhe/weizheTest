package weizheTest;

import java.util.Scanner;

public class chengfabiao {
	
	private static Scanner scanner;

	public static void main(String[] args) {
		String str = null;
		System.out.println("请输入字符串:");
		scanner = new Scanner(System.in);
		str	= scanner.next();	
		if(str.length() != 0){
			for(int i=0; i<str.length(); i++){
				if(str.charAt(i) > 'c' || str.charAt(i) < 'a'){
					System.out.println("非法输入，只能输入a,b,c，请重新输入：");
					str = scanner.next();
				}
			}
		}
		System.out.println("输入的字符串为："+str);
		int n = str.length();
		int m[][][] = new int[n][n][3];
		//初始化
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
				for(int k=0; k<3; k++)
					m[i][j][k] = 0;
		for(int i=0; i<n; i++){
			m[i][i][str.charAt(i) - 'a'] = 1;
		}
		//动态规划
		for(int a=1; a<n ; a++){
			for(int i=0; i<n-a; i++){
				int j = i+a;
				for(int k=i; k<j; k++){
					m[i][j][0] += m[i][k][2]*m[k+1][j][0]+m[i][k][0]*m[k+1][j][2]+m[i][k][1]*m[k+1][j][2];
					m[i][j][1] += m[i][k][0]*m[k+1][j][0]+m[i][k][0]*m[k+1][j][1]+m[i][k][1]*m[k+1][j][1];
					m[i][j][2] += m[i][k][1]*m[k+1][j][0]+m[i][k][2]*m[k+1][j][1]+m[i][k][2]*m[k+1][j][2];
				}				
			}
		}
		System.out.println("得到a的方法数："+m[0][n-1][0]);
	}
}
