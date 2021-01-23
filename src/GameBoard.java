public class GameBoard {
    public static char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};
    public static void printGameBoard() {
        for (char[] row : gameBoard) {
            for (char column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }
    public static void placeValue(int pos, String user) {
        char symbol = ' ';
        if (user.equals("player1")) {
            symbol = 'X';
        } else if (user.equals(("player2"))) {
            symbol = 'O';
        }
        switch (pos) {
            case 1:
                GameBoard.gameBoard[0][0] = symbol;
                break;
            case 2:
                GameBoard.gameBoard[0][2] = symbol;
                break;
            case 3:
                GameBoard.gameBoard[0][4] = symbol;
                break;
            case 4:
                GameBoard.gameBoard[2][0] = symbol;
                break;
            case 5:
                GameBoard.gameBoard[2][2] = symbol;
                break;
            case 6:
                GameBoard.gameBoard[2][4] = symbol;
                break;
            case 7:
                GameBoard.gameBoard[4][0] = symbol;
                break;
            case 8:
                GameBoard.gameBoard[4][2] = symbol;
                break;
            case 9:
                GameBoard.gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
    public static boolean checkWinner(char symbol) {
        if (gameBoard[0][0] == symbol && gameBoard[0][2] == symbol && gameBoard[0][4] == symbol) {
            return true;
        } else if (gameBoard[2][0] == symbol && gameBoard[2][2] == symbol && gameBoard[2][4] == symbol) {
            return true;
        } else if (gameBoard[4][0] == symbol && gameBoard[4][2] == symbol && gameBoard[4][4] == symbol) {
            return true;
        } else if (gameBoard[0][0] == symbol && gameBoard[2][0] == symbol && gameBoard[4][0] == symbol) {
            return true;
        } else if (gameBoard[0][2] == symbol && gameBoard[2][2] == symbol && gameBoard[4][2] == symbol) {
            return true;
        } else if (gameBoard[0][4] == symbol && gameBoard[2][4] == symbol && gameBoard[4][4] == symbol) {
            return true;
        }
        return (gameBoard[0][0] == symbol && gameBoard[2][2] == symbol && gameBoard[4][4] == symbol) || (gameBoard[0][4] == symbol && gameBoard[2][2] == symbol && gameBoard[4][0] == symbol);
    }
}
