package ws23.protorype;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class PauseController {

    @FXML
    /**
     * fx:id's of the Buttons in the View
     */
    private Button backButton, resumeButton;
    @FXML
    /**
     * Stage of the View
     */
    private Stage stage;


    private  GameController gameController;

    public void setGameController(GameController gameController){
        this.gameController = gameController;
    }

    /**
     * Method to return to the MainMenu
     */
    @FXML
    private void showMainMenu() {
        // use Method in GameController to return to MainMenuView
        gameController.returnMainMenu();
        // Close PauseView
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Method to resume the game at paused point
     */
    @FXML
    private void resumeGame()  {
        // use Method in GameController to resume the paused game
        GameController.resumeGame();
        stage = (Stage) resumeButton.getScene().getWindow();
        // close Pauseview
        stage.close();


    }
}
