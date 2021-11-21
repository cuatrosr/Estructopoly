package ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.objects.Board;

public class Main extends Application {

    private ApoTwoPolyGUI gui;
    private ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data\\Data.txt"));

    public Main() throws ClassNotFoundException, FileNotFoundException, IOException {
        this.gui = new ApoTwoPolyGUI((Board) ois.readObject());
        //this.gui = new ApoTwoPolyGUI();
        ois.close();

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("screens/main_screen/main.fxml"));//screens/game_screens/board_scene/board.fxml
        fxmlLoader.setController(gui);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("ApoTwoPoly");
        stage.show();
        gui.setLocalStage(stage);

    }

    @Override
    public void init() throws ClassNotFoundException, IOException {
        //Load load = new Load();
        //load.escribir();

    }

}
