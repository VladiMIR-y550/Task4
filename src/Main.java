import java.util.Scanner;

public class Main {
    static int[] cell = new int[9];
    static int[] inputNumberCell = new int[1];

    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        while (true) {
            printGameBoard(gameBoard);
            System.out.println("Player 1 (plays X), please input number cell (1-9)");
            int pos1 = checkInputPosition();
            placeValue(gameBoard, pos1, "player1");
            if (checkWinner(gameBoard, 'X')) {
                printGameBoard(gameBoard);
                System.out.println("Congratulations Player 1. You Won!");
                break;
            }
            if (checkDraw()) {
                printGameBoard(gameBoard);
                System.out.println("It's a draw");
                break;
            }

            printGameBoard(gameBoard);
            System.out.println("Player 2 (plays O), please input number cell (1-9)");
            int pos2 = checkInputPosition();
            placeValue(gameBoard,pos2, "player2");
            if (checkWinner(gameBoard, 'O')) {
                printGameBoard(gameBoard);
                System.out.println("Congratulations Player 2. You Won!");
                break;
            }
            if (checkDraw()) {
                printGameBoard(gameBoard);
                System.out.println("It's a draw");
                break;
            }
        }
    }
    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char column : row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }
    public static int inputValid() {
        Scanner scan = new Scanner(System.in);
        String inputStr;
        int playerPos = 0;
        boolean valid = false;
        while (!valid) {
            inputStr = scan.nextLine();
            try {
                int cell = Integer.parseInt(inputStr);
                if (cell > 0 && cell <= 9) {
                    playerPos = cell;
                    valid = true;
                } else {
                    System.out.println("Wrong enter, please enter the number (1 - 9)");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter the number");
            }
        }
        return playerPos;
    }
    static int checkInputPosition() {
        int checkingPos = 0;
        boolean freePosition = false;
        while (!freePosition) {
            int pos = inputValid();
            boolean checkDuplicates = checkDuplicatesCell(pos);
            if (checkDuplicates) {
                recordCellMemory(pos);
                checkingPos = pos;
                freePosition = true;
            }
        }
        return checkingPos;
    }
    static boolean checkDuplicatesCell(int pos) {
        inputNumberCell[0] = pos;
        for (int j : cell) {
            if (j == inputNumberCell[0]) {
                System.out.println("Position taken! Enter a correct Position");
                return false;
            }
        }
        return true;
    }
    static void recordCellMemory(int pos) {
        for (int i = 0; i < cell.length; i++) {
            if (cell[i] == 0) {
                cell[i] = pos;
                break;
            }

        }
    }
    static boolean checkDraw() {
        for (int n : cell) {
            if (n == 0) {
                return false;
            }
        }
        return true;
    }
    public static void placeValue(char[][] gameBoard, int pos, String user) {
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
    public static boolean checkWinner(char[][] gameBoard, char symbol) {
        if (gameBoard[0][0] == symbol && gameBoard[0][2] == symbol && gameBoard[0][4] == symbol) {
            return true;
        } if (gameBoard[2][0] == symbol && gameBoard[2][2] == symbol && gameBoard[2][4] == symbol) {
            return true;
        } if (gameBoard[4][0] == symbol && gameBoard[4][2] == symbol && gameBoard[4][4] == symbol) {
            return true;
        } if (gameBoard[0][0] == symbol && gameBoard[2][0] == symbol && gameBoard[4][0] == symbol) {
            return true;
        } if (gameBoard[0][2] == symbol && gameBoard[2][2] == symbol && gameBoard[4][2] == symbol) {
            return true;
        } if (gameBoard[0][4] == symbol && gameBoard[2][4] == symbol && gameBoard[4][4] == symbol) {
            return true;
        }
        return (gameBoard[0][0] == symbol && gameBoard[2][2] == symbol && gameBoard[4][4] == symbol) || (gameBoard[0][4] == symbol && gameBoard[2][2] == symbol && gameBoard[4][0] == symbol);
    }
}
