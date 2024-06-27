import java.util.Random;

public class Board{
    private Random rand;
    private int [][] board;

    public Board(){
        rand = new Random();
        board = new int[8][8];
        boardBegin();
        fixBoard();
    }

    private void boardBegin(){ // Creating BoardGame
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = rand.nextInt(7) + 1;
            }
        }
    }

    private void fixBoard() {  // Fix duplicated numbers
        for (int i = 0; i < 8; i++) {
            for (int j = 2; j < 8; j++) {
                if (board[i][j] == board[i][j-1] && board[i][j] == board[i][j-2]) {
                    board[i][j] = newValue(board[i][j]);
                }
            }
        }

        for (int j = 0; j < 8; j++) {
            for (int i = 2; i < 8; i++) {
                if (board[i][j] == board[i-1][j] && board[i][j] == board[i-2][j]) {
                    board[i][j] = newValue(board[i][j]);
                }
            }
        }
    }

    private int newValue(int currentValue) { //New number for be changed
        int newValue = currentValue;
        while (newValue == currentValue) {
            newValue = rand.nextInt(7) + 1;
        }
        return newValue;
    }

    public void showBoard(){  // show the board game on the terminal
        for(int i = 0; i<8; i++){
            for (int j = 0; j<8; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}