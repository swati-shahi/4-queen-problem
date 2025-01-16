public class fourQueen {

    static int N = 4;  // Number of queens

    // Function to print the chessboard
    static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to check if a queen can be placed on board[row][col]
    static boolean isSafe(int board[][], int row, int col) {
        // Check the column for queens already placed
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // Check the upper left diagonal for queens already placed
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check the upper right diagonal for queens already placed
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Function to solve the N-Queens problem using backtracking
    static boolean solveNQueens(int board[][], int row) {
        // If all queens are placed
        if (row >= N) {
            return true;
        }

        // Try placing this queen in all columns one by one
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                // Place the queen
                board[row][col] = 1;

                // Recur to place the next queen
                if (solveNQueens(board, row + 1)) {
                    return true;
                }

                // If placing queen in board[row][col] doesn't lead to a solution, backtrack
                board[row][col] = 0;
            }
        }

        return false;
    }

    // Main function to solve the 4-Queens problem
    public static void main(String[] args) {
        int board[][] = new int[N][N];

        // Initialize the board with 0s
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = 0;
            }
        }

        // Try to solve the problem
        if (solveNQueens(board, 0)) {
            printSolution(board);
        } else {
            System.out.println("Solution does not exist.");
        }
    }
}
