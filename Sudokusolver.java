public class Sudokusolver {
public static void main(String[] args) {
    int[][] board = new int[][]{
        {3, 0, 6, 5, 0, 8, 4, 0, 0},
        {5, 2, 0, 0, 0, 0, 0, 0, 0},
        {0, 9, 7, 0, 0, 0, 0, 3, 1},
        {0, 0, 3, 0, 1, 0, 0, 8, 0},
        {9, 0, 0, 8, 6, 3, 0, 0, 5},
        {0, 5, 6, 0, 9, 0, 6, 0, 0},
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0, 0, 0, 0, 0, 0, 0, 7, 4},
        {0, 0, 5, 2, 0, 6, 3, 0, 0}
    };
    // System.out.println(solve(board));
    if(solve(board)){
        display(board);
    }else{
        System.out.println("cannot solve");
    }
    
}
static boolean solve(int[][] board){
    int n =board.length;
    int r = -1;
    int c = -1;
     boolean emptyLeft = true;

     //this is how we are replacing the r, c from arguments
     for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if( board[i][j] == 0){ 
                r = i;
                c = j;
                 emptyLeft = false;
                 break;
            }
        }
    
        //
        //if you found some empty element int row, then break
        if(emptyLeft == false){
            break;
        }
    }
        if(emptyLeft==true){
            return true;
            //sudoku solved
        }
        //backtrack
        for(int number = 1; number<= 9; number++){
            if(isSafe(board, r, c,number)){
                board[r][c] = number;
                if(solve(board)){
                    //found the answer
                    
                    return true;
                }else{
                    //backtrack
                    board[r][c]=0;
                }
            }
        }
        return false;
     
}
private static void display(int[][] board){
    for(int[] row : board){
        for(int num : row){
            System.out.println(num + " ");
        }
        System.out.println();
    }
}
    



static boolean isSafe(int[][] board, int r, int c, int num){
    //check the row
    for( int i=0; i< board.length; i++){
  //check if the num is in the row 
  if(board[r][c] == num){
    return false;
  }
    }
    //check if the number is in the col
    for(int[] nums: board){
        if(nums[c] ==num){
            return false;
        }

    }
    int sqrt = (int) (Math.sqrt(board.length));
    int rowstart = r-r % sqrt;
    int colstart = c - c % sqrt;
    for(int row = rowstart; row < rowstart + sqrt; row++){
        for(int col = colstart; col < colstart + sqrt; col++){
            if(board[row][col] == num){
                return false;
            }
        }
    }
    return true;
    }

}
