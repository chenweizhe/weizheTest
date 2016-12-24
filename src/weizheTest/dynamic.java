package weizheTest;

import java.util.Scanner;

/**
 * 动态规划
 * 根据可能发生的可能情况 设计以下算法 写的比较垃圾
 * @author javazhe
 *
 */
public class dynamic {
	
	public static boolean status = true;
	private static Scanner scanner;
	public static int min(int a,int b) {
		return a>b?b:a;
	}
	
	public static void main(String[] args) {
		System.out.println("请输入合法的括号：");
		scanner = new Scanner(System.in);
		String a[] = {scanner.next(),scanner.next(),scanner.next()};
				
		
		int l = a.length;
		
		int[][] dp = new int[l][l];
		
		for(int i=0;i<l;i++){
			dp[i][i] = 1;
		}
		
		for(int i=1;i<l;i++){
			dp[i][i-1] =0;
		}
		
		for(int len=2; len<=l ; len++){
			for(int s=0; s<=l-len;s++){
				int e = s+len-1;
				dp[s][e] = 99999999;
				
				if((a[s]=="("&&a[e]==")")||(a[s]=="["&&a[e]=="]")){
					dp[s][e] = min(dp[s][e], dp[s+1][e-1]);
				}
				
				if((a[s]=="("&&a[e]!=")") || (a[s]=="["&&a[e] != "]")){
					
					dp[s][e] = min(dp[s][e], dp[s][e-1]+1);
//					System.out.println(dp[s][e]+"-----"+dp[s][e-1]);
				}
					
				if((a[e]==")"&&a[s]!="(") || (a[e]=="]"&&a[s]!="[")){
					dp[s][e] = min(dp[s][e], dp[s+1][e]+1);
				}
					
				for(int k=s;k<e;k++){
//					System.out.println(dp[s][e]+"---------"+dp[s][k]+"--------"+dp[k+1][e]);
					dp[s][e] = min(dp[s][e],dp[s][k]+dp[k+1][e]);
				}		
			}
		}

		System.out.println();
		System.out.println("最少添加括号数为：   "+dp[0][l-1]);
		for(int i=0; i<l; i++){
			for (int j = 0; j < l; j++) {
				System.out.print(dp[i][j]);
			}
			System.out.println();
		}
	}

}
