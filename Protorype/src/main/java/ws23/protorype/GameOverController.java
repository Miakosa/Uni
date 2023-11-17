package ws23.protorype;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class GameOverController {
    @FXML
    private Button backButton, restart;
    @FXML
    private Stage stage;
    @FXML
    private  GameController gameController;

    public void setGameController(GameController gameController){
        this.gameController = gameController;
    }

    /**
     * Method to get back to the MainmenuView
     */
    @FXML
    private void showMainMenu() {
        // use Method in GameController to return to MainMenuView
        gameController.returnMainMenu();
        // Close GameOverView
        Stage stage = (Stage) backButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Method to restart the game
     */
    @FXML
    private void restart()  {
        stage = (Stage) restart.getScene().getWindow();
        stage.close();

        gameController.initialize();

    }
}
