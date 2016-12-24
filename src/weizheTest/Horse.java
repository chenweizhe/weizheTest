package weizheTest;

import java.util.Scanner;

public class Horse {
	
	private final static int N = 5;
	private final static int M = 6;
	
	private static int[][] nextPos = {{-2,1},{-1,2},{1,2},{2,1},
			{2,-1},{1,-2},{-1,-2},{-2,-1}};
	private static int total = 0;
	static int prePosX;
	static int prePosY;
	static Scanner scanner;
	

	public static void main(String[] args) {
		int[][] chessBoard = new int[N][M];
		System.out.println("请输入马的位置：");
		scanner = new Scanner(System.in);
		int startX = scanner.nextInt();
		int startY = scanner.nextInt();
		chessBoard[startX][startY] = 1;
		find(startX,startY,2,chessBoard);
		System.out.println(total);
	}



	private static void find(int x, int y, int dep,int[][] chessBoard) {
		int i,xx,yy;
		for(i =0; i<8;i++){
			xx = x+nextPos[i][0];
			yy = y+nextPos[i][1];
	
			//判断坐标是否越界以及是否已走过
			if(isInBoard(xx,yy) && chessBoard[xx][yy] == 0){
				chessBoard[xx][yy] = 1;
				if (dep == N*M) {
					total++;
				}else {
					find(xx, yy, dep+1, chessBoard);
				}
				chessBoard[xx][yy] = 0;
			}
		}
	}

	//判断走的位置是否在棋盘内
	private static boolean isInBoard(int posX, int posY) {
		return 0 <= posX && posX < N && 0<= posY && posY < M;
	}
}
