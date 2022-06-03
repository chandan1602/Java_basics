package programs;

import java.util.ArrayList;
import java.util.List;

class Shift2d1260 {
    public static void main(String[] args) {
//        int grid[][] = {
//                {1,1}
//        };
//        int k=1;
//        shiftGrid(grid, k);
//        System.out.println(shiftGrid(grid, k));

        pickA3By3Grid(new String[][]{
                {"5","3",".",".","7",".",".",".","."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}
        }, 4,8);
    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int net=m*n;
        k%=net;
        List<List<Integer>> sol = new ArrayList<>();

        if(k==0) {
            for(int i=0; i<m; i++) {
                List<Integer> l = new ArrayList<>();
                for(int j=0; j<n; j++) l.add(grid[i][j]);
                sol.add(l);
            }
            return sol;
        }

        int initialRow = (net - k)/n; //
        int initialCol = (net - k)%n; //
        int cnt=0;

        while(cnt!=net) {
            List<Integer> r = new ArrayList<>();
            for(int i=0; i<n; i++) {
                r.add(grid[initialRow][initialCol++]);
                if(initialCol==n) {
                    initialCol=0;
                    if(initialRow==m-1) {
                        initialRow=0;
                    } else {
                        initialRow++;
                    }
                }
                cnt++;
            }
            sol.add(r);
        }


        return sol;
    }

    public static void pickA3By3Grid(String[][] board, int row, int col) {
        int addCol = (col%3)*3;
        int addRow = (row/3)*3;
        for(int j=0; j<9; j++) {
            int c = j%3 + addCol;
            int r = j/3 + addRow;
            System.out.println(board[r][c]);
        }
    }
}