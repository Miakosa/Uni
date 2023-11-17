package ws23.protorype;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.application.Platform;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.util.Duration;

import java.io.IOException;

public class GameController {
    @FXML
    private  FXMLLoader loader;
    @FXML
    private  Parent scene;
    @FXML
    private Parent proot;
    @FXML
    private  Stage stage;
    @FXML
    private Label scoreLabel;
    @FXML
    private  Canvas field;
    @FXML
    private Button backButton;
    private static Timeline timeline;
    private static final int WIDTH = 500;
    private static final int HEIGHT = 700;
    private static final int SNAKE_SIZE = 20;
    private static final Color SNAKE_COLOR = Color.GREEN;
    private PauseController pauseController;
    private GameOverController gameOverController;
    private int snakeX = WIDTH/2;
    private int snakeY = HEIGHT/2;
    private int directionX = SNAKE_SIZE;
    private int directionY = 0;
    private static boolean pause = false;

    public void setPauseController(PauseController pauseController) {
        this.pauseController = pauseController;
    }
    public void setGameOverController(GameOverController gameOverController) {
        this.gameOverController = gameOverController;
    }


    /**
     * Method for the visuals and the handling of Key Press
     */
    @FXML
    public void initialize() {
        //creates an Instance from GraphicsContext for the canvas
        GraphicsContext gc = field.getGraphicsContext2D();
        // while animation is running, do every 0.1 sec update(),draw()
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.1), event -> {
            if (!pause) {
                update();
                draw(gc);
            }
        }));
        // start Animation
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        // analyses Key input
        field.setOnKeyPressed(keyEvent -> {
            KeyCode code = keyEvent.getCode();
            if (code == KeyCode.UP && directionY == 0) {
                directionX = 0;
                directionY = -SNAKE_SIZE;


            } else if (code == KeyCode.DOWN && directionY == 0) {
                directionX = 0;
                directionY = SNAKE_SIZE;


            } else if (code == KeyCode.LEFT && directionX == 0) {
                directionX = -SNAKE_SIZE;
                directionY = 0;


            } else if (code == KeyCode.RIGHT && directionX == 0) {
                directionX = SNAKE_SIZE;
                directionY = 0;

            } else if (code == KeyCode.SPACE){
                showPause();
            }
        });
        // needed so the down button can be recognised as input for the snake movement instead of navigation
        backButton.setFocusTraversable(false);

    }
    @FXML
    public void updateScore(int score){
        scoreLabel.setText(""+ score);
    }

    /**
     * Method to change to MainMenuView
     */
    @FXML
    public void returnMainMenu() {
        pause = false;
        timeline.pause();
        try {
            loader = new FXMLLoader(getClass().getResource("MainMenuView.fxml"));
            proot = loader.load();

            stage = (Stage) field.getScene().getWindow();
            stage.setScene(new Scene(proot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to show the PauseView and pause the animation
     */
    @FXML
    private void showPause() {
        pause = true;
        timeline.pause();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PauseView.fxml"));
            Parent proot = loader.load();
            pauseController = loader.getController();

            // Setzen Sie den GameController im PauseController
            pauseController.setGameController(this);

            Stage pauseStage = new Stage();
            pauseStage.setTitle("Pausiert");
            pauseStage.initModality(Modality.APPLICATION_MODAL);
            pauseStage.initOwner(field.getScene().getWindow());
            pauseStage.setScene(new Scene(proot));
            pauseStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to show the GameOverView, also resets basic Game parameters
     */
    @FXML
    private void showOver() {
        stopGame();
        snakeX = WIDTH/2;
        snakeY =HEIGHT/2;
        directionX = SNAKE_SIZE;
        directionY = 0;
        pause = false;

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("GameOverView.fxml"));
                Parent proot = loader.load();
                gameOverController = loader.getController();

                // Setzen Sie den GameController im PauseController
                gameOverController.setGameController(this);

                Stage overStage = new Stage();
                overStage.setTitle("Verloren");
                overStage.initModality(Modality.APPLICATION_MODAL);
                overStage.initOwner(field.getScene().getWindow());

                overStage.setScene(new Scene(proot));
                overStage.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    /**
     * Method to stop the animation of the snake
     */
    @FXML
    public void stopGame() {
        if (timeline != null) {
            timeline.stop();
        }
    }

    /**
     * Method to resume the game at the point it was paused
     */
    @FXML
    public static void resumeGame(){
        pause = false;
        timeline.play();
    }

    /**
     * Method to update the position of the snake on the canvas
     */
    private void update() {
        if (pause){
            return;
        }
        // Move Snake based on input
        snakeX += directionX;
        snakeY += directionY;

        // Collision with edge
        if (snakeX < 0 ||snakeX >= WIDTH||snakeY >= HEIGHT ||snakeY < 0) {
            showOver();
        }
    }

    /**
     *  Method that draws the Snake onto the canvas
     * @param gc 2D Object
     */
    private void draw(GraphicsContext gc) {
        // if game is paused stop the Method
        if ( pause){
            return;
        }
        // remove anything on the canvas
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        gc.setFill(SNAKE_COLOR);
        // the Rectangle for the snake's head
        gc.fillRect(snakeX, snakeY, SNAKE_SIZE, SNAKE_SIZE);
    }

}
