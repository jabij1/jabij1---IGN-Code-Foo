public class Knight {
    private int[][] board;
    private int length;
    private int width;

    public Knight() {
         length = 8;
         width = 8;
         board = new int[width][length];
         set();
    }

    private void set() {
        for(int i=0;i<length;i++) {
            for(int j=0;j<width;j++) {
                board[i][j]=0;
            }
        }
    }
    
    public boolean position(int x, int y, int moves) {
        if (x < 0 || x >= width || y < 0 || y >= length) {
            return false;
        } else if (board[y][x] > 0) {
            return false;
        } else if (moves == (length*width)) {
            board[y][x] = moves;
            return true;
        }  else {
            System.out.printf("Position: (%d,%d,%d)%n", x,y, moves);
            board[y][x] = moves;
            moves++;  
            if (position(x-2, y-1, moves) || position(x-2, y+1,  moves) || position(x-1, y+2,  moves)|| position(x+1, y+2, moves) || position(x+2, y+1, moves) || position(x+2, y-1,  moves) || position(x+1, y-2,  moves) || position(x-1, y-2,  moves)) {
                return true;
            } else {
                board[y][x] = 0;
                return false;
            }
        }
    }
}