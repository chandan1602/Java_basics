package programs;

class GameOfLife289 {
    private static int dir[][] = new int[][]{
            {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}
        };

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };
        gameOfLife(grid);
        for(int i=0; i< grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void gameOfLife(int[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                solve(board, i, j);
            }
        }
    }
    
    public static void solve(int board[][], int i, int j) {
        int m = board.length, n=board[0].length;
        int cnt=0;
        for(int k=0; k<8; k++) {
            int x = i+dir[k][0];
            int y = j+dir[k][1];
            if(x>=0 && x<m && y>=0 && y<n && board[x][y]==1) {
                cnt++;
            }
        }
        if(board[i][j]==0 && cnt==3) board[i][j]=1;
        else if(board[i][j]==1) {
            if(cnt<=1 || cnt>3) board[i][j]=0;
        }
        System.out.println("i:"+i+" :: j:"+j+" :: cnt:"+cnt);
    }
}