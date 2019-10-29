package TicTacToeGame;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author clatulip
 */
public class GameDataModel {

    private Player p1;
    private Player p2;
    private int numPlayers = 0;
    private boolean gameStarted = false;
    private boolean gameOver = false;
    final private int MAX_ROUNDS = 7;
    private int round = 0;
    private boolean twoPlayers;
    private boolean gameModeSelected = false;
    private boolean p1Turn;
    private Win win = Win.NONE;
    private int player1Counter = 0;
    private int player2Counter = 0;
    private int roundCounter = 1;
    private int turns = 0;

    private Token[] gameArray = new Token[9];

    public int getMAX_ROUNDS() {
        return MAX_ROUNDS;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        if (round <= MAX_ROUNDS) {
            this.round = round;
        }
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isTwoPlayers() {
        return twoPlayers;
    }

    public void setTwoPlayers(boolean twoPlayers) {
        this.twoPlayers = twoPlayers;
        this.gameModeSelected = true;
    }

    void addNewPlayer(String name) {
        if (numPlayers == 0) {
            p1 = new Player(name);
            numPlayers += 1;
        } else if (numPlayers == 1) {
            p2 = new Player(name);
            numPlayers += 1;
        } else {
            System.out.println("Shouldn't get here - trying to add more than one player");
        }
    }

    public boolean isGameReady() {
        // check to see if players have been set up
        boolean ready = false;
        if (twoPlayers == false) {
            if (p1 != null) {
                p2 = new Player("Computer");
                numPlayers++;
                ready = true;
            }
        } else {
            if ((p1 != null) && (p2 != null)) {
                ready = true;
            }
        }
        return ready;
    }

    public boolean selectedGameMode() {
        return gameModeSelected;
    }

    public void startGame() {
        gameStarted = true;
        startNewRound();
    }

    public void startNewRound() {
        gameOver = false;
        p1Turn = true;
        turns = 0;
        win = Win.NONE;
        if (twoPlayers) {
            double temp = Math.random();
            if (temp > 0.5) {
                p1Turn = false;
                System.out.println("P2 goes first.");
            } else {
                System.out.println("P1 goes first");
            }
        }

        for (int i = 0; i < 9; i++) {
            gameArray[i] = Token.Blank;
        }

        GameBoard myGameBoard = new GameBoard(this);
        myGameBoard.setVisible(true);
    }

    public boolean changeToken(int index) {
        // make sure this space is blank, if not return

        if (gameArray[index] != Token.Blank) {
            System.out.println("Space is already used");
            return false;
        }

        // get token for player
        Token t;
        if (p1Turn) {
            t = Token.X;
        } else {
            t = Token.O;
        }

        // set token at index
        gameArray[index] = t;

        System.out.println("changes token");

        // see if won, if so, game is over and return true
        if (checkForWin(index)) {
            if (win == Win.NONE) {
                System.out.println("Tie!");
                gameOver = true;
                return true;
            } else {
                System.out.println("Wins!");
                gameOver = true;
                return true;
            }
        }
        turns++;
        // change turns
        p1Turn = !p1Turn;
        return true;
    }

    public boolean isSpaceBlank(int index) {
        if (gameArray[index] == Token.Blank) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isP1Turn() {
        return p1Turn;
    }

    public boolean checkForWin(int index) {
        boolean over = false;
        //TO DO: check to see if there is a winner. If so, set win field and return true; otherwise, return false
        Token b = gameArray[index];
        //first row
        if (gameArray[0] == b && gameArray[1] == b && gameArray[2] == b) {
            over = true;
            win = Win.TOP_ROW;
        }//first column
        else if (gameArray[0] == b && gameArray[3] == b && gameArray[6] == b) {
            over = true;
            win = Win.LEFT_COL;
        }//diagonal top left to bottom right
        else if (gameArray[0] == b && gameArray[4] == b && gameArray[8] == b) {
            over = true;
            win = Win.DIAG1;
        }//diagonal top right to bottom left
        else if (gameArray[2] == b && gameArray[4] == b && gameArray[6] == b) {
            over = true;
            win = Win.DIAG2;
        }//second row
        else if (gameArray[3] == b && gameArray[4] == b && gameArray[5] == b) {
            over = true;
            win = Win.MID_ROW;
        }//third row
        else if (gameArray[6] == b && gameArray[7] == b && gameArray[8] == b) {
            over = true;
            win = Win.BOT_ROW;
        }//second column
        else if (gameArray[1] == b && gameArray[4] == b && gameArray[7] == b) {
            over = true;
            win = Win.MID_COL;
        } else if (gameArray[2] == b && gameArray[5] == b && gameArray[8] == b) {
            over = true;
            win = Win.RIGHT_COL;
        } else {
            int counter = 0;
            for (int i = 0; i < 9; i++) {
                if (gameArray[i] == Token.Blank) {
                    counter++;
                }
            }
            if (counter == 0) {
                over = true;
                win = Win.NONE;
            } else {
                over = false;
            }
        }
        return over;

    }

    Token getToken(int i) {
        return gameArray[i];
    }

    public Win getWin() {
        return win;
    }

    public int getPlayer1Counter() {
        return player1Counter;
    }

    public void setPlayer1Counter(int player1Counter) {
        this.player1Counter = player1Counter;
    }

    public int getPlayer2Counter() {
        return player2Counter;
    }

    public void setPlayer2Counter(int player2Counter) {
        this.player2Counter = player2Counter;
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void setRoundCounter(int roundCounter) {
        this.roundCounter = roundCounter;
    }
}

enum Token {
    X, O, Blank
};

enum Win {
    NONE, TOP_ROW, MID_ROW, BOT_ROW, LEFT_COL, MID_COL, RIGHT_COL, DIAG1, DIAG2
};
