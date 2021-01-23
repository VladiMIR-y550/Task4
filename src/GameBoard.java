public class GameBoard {
    private final char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

    void printGameBoard() {
        for (char[] row : gameBoard) {
            for (char column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }
    void placeValue(int pos, String user) {
        char symbol = ' ';
        if (user.equals("player1")) {
            symbol = 'X';
        } else if (user.equals(("player2"))) {
            symbol = 'O';
        }
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
    boolean checkWinner(char symbol) {
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
        return (gameBoard[0][0] == symbol
                && gameBoard[2][2] == symbol
                && gameBoard[4][4] == symbol)
                || (gameBoard[0][4] == symbol
                && gameBoard[2][2] == symbol
                && gameBoard[4][0] == symbol);
    }
}