package ws23.protorype;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HistoryController {
    @FXML
    private FXMLLoader loader;
    @FXML
    private Parent scene;
    @FXML
    private Stage stage;

    /**
     * Method to retur to the MainMenuView
     * @param event
     * @throws IOException
     */
    @FXML
    public void showMainMenu(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("MainMenuView.fxml"));
        scene = loader.load();

        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(scene));
        stage.show();

    }
}
