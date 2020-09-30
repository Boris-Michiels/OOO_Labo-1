package ui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.Box;
import javafx.application.Application;

public class App extends Application {

    public void start(Stage stage) {
        stage.setTitle("Shop program");

        Box box = new Box(200.0f, 120.0f, 150.0f);

        Group group = new Group(box);
        box.setTranslateX(100);
        box.setTranslateY(100);

        Scene scene = new Scene(group, 500, 300);

        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
