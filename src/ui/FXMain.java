package ui;

import javafx.application.Application;
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
        primaryStage.setScene(scene);
        primaryStage.setTitle("Estructopoly!");
        primaryStage.setResizable(false);
        primaryStage.setMaximized(true);
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(FXMain.class.getResourceAsStream("images/logo.png"))));
        primaryStage.show();
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH); //<-Disable ESC = exit fullscreen
        fxmlLoader = new FXMLLoader(getClass().getResource("fxml/menu.fxml"));
        fxmlLoader.setController(mainController);
        root = fxmlLoader.load();
        mainController.getMainPane().setCenter(root);
    }

    @Override
    public void stop() {
        System.out.println("Game stopped.");
    }
}
