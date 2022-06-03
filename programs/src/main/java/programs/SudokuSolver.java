package programs;

class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {
                {'.','.','.','4','1','.','.','.','.'},
                {'.','8','.','7','.','.','2','.','.'},
                {'.','7','.','.','.','.','.','5','.'},
                {'.','.','6','.','.','.','3','.','.'},
                {'2','.','.','.','9','6','.','7','.'},
                {'.','.','.','.','8','4','.','.','.'},
                {'5','3','.','.','.','.','8','.','4'},
                {'.','.','.','.','.','9','.','6','.'},
                {'.','4','.','.','.','1','.','.','.'}
        };
        solveSudoku(board);
        for(int i=0; i<board.length; i++) {
            for(int j=0;j<board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        fillSudoku(board);
    }
    
    public static boolean fillSudoku(char[][] board) {
        int r = -1;
        int c = -1;
        boolean found = false;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(board[i][j]=='.') {
                    r=i;
                    c=j;
                    found=true;
                    break;
                }
            }
            if(found) break;
        }
        
        if(!found) return true;
        
        for(int i=1; i<=9; i++) {
            char ch = (char)(i+'0');
            if(isSafe(board, r, c, ch)) {
                board[r][c]=ch;
                //Backtrack
                if(fillSudoku(board)) return true;
                board[r][c]='.';
            }
        }
        return false;
    }
    
    public static boolean isSafe(char board[][], int row, int col, char val) {
        int nr = board.length;
        int nc = board[0].length;
        
        for(int i=0; i<nc; i++) {        //Check Row
           if(board[row][i]==val) return false;
        }
        
        for(int j=0; j<nr; j++) {       //Check Col
            if(board[j][col]==val) return false;
        }
        
        int sqrt = (int)Math.sqrt(board.length);
        int colStart = col - col%sqrt;
        int rowStart = row - row%sqrt; 
        for(int i=rowStart; i<rowStart+sqrt; i++) {
            for(int j=colStart; j<colStart+sqrt; j++) {
                if(board[i][j]==val) return false;
            }
        }
        
        return true;
    }
}