package weizheTest;

public class Horse {
	
	private final static int N = 4;
	private final static int M = 5;
	
	private static int[][] nextPos = {{-2,1},{-1,2},{1,2},{2,1},
			{2,-1},{1,-2},{-1,-2},{-2,-1}};
	private static int total = 0;
	static int prePosX;
	static int prePosY;
	
	

	public static void main(String[] args) {
		int[][] chessBoard = new int[N][M];
		int startX = 0;
		int startY = 0;
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
				chessBoard[xx][yy] = dep;
				if (dep == N*M) {
					total++;
					PrintChessBoard(chessBoard);
					System.out.println("*****************************************");
				}else {
					find(xx, yy, dep+1, chessBoard);
				}
				chessBoard[xx][yy] = 0;
			}
		}
	}



	private static void PrintChessBoard(int[][] chessBoard) {
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				System.out.print(chessBoard[i][j]+"\t");
			}
			System.out.println();
		}
	}



	private static boolean isInBoard(int posX, int posY) {
		return 0 <= posX && posX < N && 0<= posY && posY < M;
	}

}
