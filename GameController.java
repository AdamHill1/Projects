package TicTacToeGame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author clatulip
 */
public class GameController {

    private GameDataModel myModel;
    private StartScreen myStartScreen;
    private GameBoard myGameBoard;

    public GameController(GameDataModel myModel) {
        this.myModel = myModel;
        myStartScreen = new StartScreen(myModel, this);
        myStartScreen.setVisible(true);

    }

    public void startGame() {
        myModel.startGame();

    }

}
