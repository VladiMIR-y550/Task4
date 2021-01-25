import java.util.Scanner;
public class Main {

    private final int[] cell = new int[9];
    private boolean letsPlay = true;


    public static void main(String[] args) {
        Main main = new Main();
        GameBoard gameBoard = new GameBoard();

        while (main.letsPlay) {
            gameBoard.printGameBoard();
            System.out.println("Player 1 (plays X), please input number cell (1-9) or input 'end' for finish");
            int pos1 = main.inputValid();
            if(!main.letsPlay) {
                System.out.println("Player1 finish the game!");
                break;
            } else {
                gameBoard.placeValue(pos1, Players.PLAYER1.getMark());
            }
            if (gameBoard.checkWinner('X')) {
                gameBoard.printGameBoard();
                System.out.println("Congratulations Player 1. You Won!");
                break;
            } else if (main.checkDraw()) {
                gameBoard.printGameBoard();
                System.out.println("It's a draw");
                break;
            }

            gameBoard.printGameBoard();
            System.out.println("Player 2 (plays O), please input number cell (1-9) or input 'end' for finish");
            int pos2 = main.inputValid();
            if(!main.letsPlay) {
                System.out.println("Player2 finish the game!");
                break;
            } else {
                gameBoard.placeValue(pos2, Players.PLAYER2.getMark());
            }
            if (gameBoard.checkWinner('O')) {
                gameBoard.printGameBoard();
                System.out.println("Congratulations Player 2. You Won!");
                break;
            } else if (main.checkDraw()) {
                gameBoard.printGameBoard();
                System.out.println("It's a draw");
                break;
            }
        }
    }
    int inputValid() {
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
    boolean checkDuplicatesCell(int pos) {
        return pos != cell[0] && pos != cell[1] && pos != cell[2]
                && pos != cell[3] && pos != cell[4] && pos != cell[5]
                && pos != cell[6] && pos != cell[7] && pos != cell[8];
    }
    void recordCellMemory(int pos) {
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
    boolean checkDraw() {
        for (int n : cell) {
            if (n == 0) {
                return false;
            }
        }
        return true;
    }
}