package weizheTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态规划
 * 根据可能发生的可能情况 设计以下算法 写的比较垃圾
 * 因为判断出非法字符后，还需要把字符串变成合法
 * 所以这里用到的数据结构是顺序表，由于当初的数据结构代码不知道扔哪里 所以用到是java提供的包
 * @author javazhe
 *
 */
public class dynamic {
	
	public static boolean status = true;
	public static int min(int a,int b) {
		if(a>b)
			status = true;
		else
			status = false;
		return a>b?b:a;
	}
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		String a[] = {"(","(",")"};
		for(int i=0;i<a.length;i++){
			list.add(a[i]);
		}
			
		
		int l = a.length;
		int[][] dp = new int[l][l];
		for(int i=0;i<l;i++){
			dp[i][i] = 1;
			if(l == 1){
				if(a[i] == "(")
					list.add(")");
				if(a[i] == "[")
					list.add("]");
				if(a[i] == ")")
					list.add(0, "(");
				if(a[i] == "]")
					list.add(0, "[");
			}
		}
		for(int len=2; len<=l ; len++){
			for(int s=0; s<=l-len;s++){
				int e = s+len-1;
				dp[s][e] = 99999999;
				
				if((a[s]=="("&&a[e]==")")||(a[s]=="["&&a[e]=="]"))
					dp[s][e] = min(dp[s][e], dp[s+1][e-1]);
				
				if((a[s]=="("&&a[e]!=")") || (a[s]=="["&&a[e] != "]")){
					dp[s][e] = min(dp[s][e], dp[s][e-1]+1);
					if (status) {
						if(a[s] == "(")
						    list.add(e+1, ")");
						if(a[s] == "[")
							list.add(e+1, "]");
					}
				}
					
				if((a[e]==")"&&a[s]!="(") || (a[e]=="]"&&a[s]!="["))
					dp[s][e] = min(dp[s][e], dp[s+1][e]+1);
				
				for(int k=s;k<e;k++){
					dp[s][e] = min(dp[s][e],dp[s][k]+dp[k+1][e]);
				}		
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		System.out.println(dp[0][l-1]);
		
		
	}

}
