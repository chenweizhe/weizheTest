package weizheTest;

import java.util.Scanner;

public class Horse2 {
	static int total,x,y;
	static int[][] biaoji = new int[5][6];
	private static int[][] nextPos = {{-2,1},{-1,2},{1,2},{2,1},
			{2,-1},{1,-2},{-1,-2},{-2,-1}};
	private static Scanner scanner;
	static int out(int x,int y){ // 判断是否超出地图   
	    if(x<0 || x>4 || y<0 || y>5)
	    	return 1;  
	    return 0;  
	}  
	
	public static void DFS(int x, int y){

		int xx,yy;
		for(int i=0; i<8; i++){
			xx = x+nextPos[i][0];
			yy = y+nextPos[i][1];
			if (isInBoard(xx, yy) && biaoji[xx][yy] == 0) {
				total++;
				biaoji[xx][yy] = 1;
				DFS(xx, yy);
				biaoji[xx][yy] = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		if (out(x, y) == 1) {
			System.out.println("error");
		}else{
			total = 0;
			biaoji[x][y] = 1;
			DFS(x, y);
			System.out.println(total);
		}
		
	}
	
	private static boolean isInBoard(int posX, int posY) {
		return 0 <= posX && posX <5 && 0<= posY && posY <6;
	}

}
