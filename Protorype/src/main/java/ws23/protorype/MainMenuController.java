package ws23.protorype;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {
    @FXML
    private FXMLLoader loader;
    @FXML
    private Parent scene;
    @FXML
    private Stage stage;

    /**
     *  Method to change th GameView
     * @param event button click
     * @throws IOException
     */
    @FXML
    public void showGame(ActionEvent event) throws IOException {

        loader = new FXMLLoader(getClass().getResource("GameView.fxml"));
        scene = loader.load();

        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(scene));

        stage.show();
    }
    /**
     *  Method to change th HistoryView
     * @param event button click
     * @throws IOException
     */
    @FXML
    public void showHistory(ActionEvent event) throws IOException {
        loader = new FXMLLoader(getClass().getResource("HistoryView.fxml"));
        scene = loader.load();

        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(scene));
        stage.show();
    }

}