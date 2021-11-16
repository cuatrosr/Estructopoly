package ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class FXMain extends Application {

    FXMainController mainController;

    public FXMain() {
        mainController = new FXMainController();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/main.fxml"));
        fxmlLoader.setController(mainController);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(mainController::keyListener);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Estructopoly!");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(FXMain.class.getResourceAsStream("images/logo.png"))));
        primaryStage.setX(mainController.getScreenBounds().getMinX());
        primaryStage.setY(mainController.getScreenBounds().getMinY());
        primaryStage.setWidth(mainController.getScreenBounds().getWidth());
        primaryStage.setHeight(mainController.getScreenBounds().getHeight());
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH); //<-Disable ESC = exit fullscreen
        primaryStage.show();
        fxmlLoader = new FXMLLoader(getClass().getResource("fxml/menu.fxml"));
        fxmlLoader.setController(mainController);
        root = fxmlLoader.load();
        mainController.getMainPane().setCenter(root);
    }

    @Override
    public void stop() {
        Platform.exit();
        System.exit(0);
        mainController.getFXBoard().getTimer().cancel();
        System.out.println("Game stopped.");
    }
}
