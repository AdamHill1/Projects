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
public class TicTacToe {
    public static void main(String[] args) {
        // create the game model
        GameDataModel myModel = new GameDataModel();
        // create the controller and pass it the model
        GameController myController = new GameController(myModel);
       
    }
}
