import java.util.Scanner;

public class Main {
    static int[] cell = new int[9];
    static int[] inputNumberCell = new int[1];
    static boolean letsPlay = true;

    public static void main(String[] args) {
        while (letsPlay) {
            GameBoard.printGameBoard();
            System.out.println("Player 1 (plays X), please input number cell (1-9) or input 'end' for finish");
            int pos1 = inputValid();
            if(!letsPlay) {
                System.out.println("Player1 finish the game!");
                break;
            }
            GameBoard.placeValue(pos1, "player1");
            if (GameBoard.checkWinner('X')) {
                GameBoard.printGameBoard();
                System.out.println("Congratulations Player 1. You Won!");
                break;
            }
            if (checkDraw()) {
                GameBoard.printGameBoard();
                System.out.println("It's a draw");
                break;
            }

            GameBoard.printGameBoard();
            System.out.println("Player 2 (plays O), please input number cell (1-9) or input 'end' for finish");
            int pos2 = inputValid();
            if(!letsPlay) {
                System.out.println("Player2 finish the game!");
                break;
            }
            GameBoard.placeValue(pos2, "player2");
            if (GameBoard.checkWinner('O')) {
                GameBoard.printGameBoard();
                System.out.println("Congratulations Player 2. You Won!");
                break;
            }
            if (checkDraw()) {
                GameBoard.printGameBoard();
                System.out.println("It's a draw");
                break;
            }
        }
    }
    public static int inputValid() {
        Scanner scan = new Scanner(System.in);
        String inputStr;
        int playerPos = 0;
        boolean valid = false;
        while (!valid) {
            inputStr = scan.nextLine();
            if (inputStr.equals("end")) {
                letsPlay = false;
                break;
            } else {
                try {
                    int cell = Integer.parseInt(inputStr);
                    if (cell > 0 && cell <= 9) {
                        if (checkDuplicatesCell(cell)) {
                            recordCellMemory(cell);
                            playerPos = cell;
                            valid = true;
                        } else {
                            System.out.println("Position taken! Enter a correct Position");
                        }
                    } else {
                        System.out.println("Wrong enter, please enter the number (1 - 9)");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter the number");
                }
            }
        }
        return playerPos;
    }
    static boolean checkDuplicatesCell(int pos) {
        inputNumberCell[0] = pos;
        return inputNumberCell[0] != cell[0] && inputNumberCell[0] != cell[1] && inputNumberCell[0] != cell[2] && inputNumberCell[0] != cell[3] && inputNumberCell[0] != cell[4] && inputNumberCell[0] != cell[5] && inputNumberCell[0] != cell[6] && inputNumberCell[0] != cell[7] && inputNumberCell[0] != cell[8];
    }
    static void recordCellMemory(int pos) {
        if (cell[0] == 0) {
            cell[0] = pos;
        }else if (cell[1] == 0) {
            cell[1] = pos;
        }else if (cell[2] == 0) {
            cell[2] = pos;
        }else if (cell[3] == 0) {
            cell[3] = pos;
        }else if (cell[4] == 0) {
            cell[4] = pos;
        }else if (cell[5] == 0) {
            cell[5] = pos;
        }else if (cell[6] == 0) {
            cell[6] = pos;
        }else if (cell[7] == 0) {
            cell[7] = pos;
        }else if (cell[8] == 0) {
            cell[8] = pos;
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
}
