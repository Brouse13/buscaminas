package org.brouse.buscaminas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.brouse.buscaminas.game.Game;

import java.io.File;
import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Game game = new Game();
        game.start();
        File file = new File(App.class.getClassLoader().getResource("").getPath()+
                "views/TableroBuscaminas.fxml");

        Parent root = FXMLLoader.load(file.toURL());
        primaryStage.setTitle(Settings.title);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}