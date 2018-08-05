import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;


public class Test extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        InputStream inputStream = Schronisko.class.getResourceAsStream("ala.txt");

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 400,200));
        primaryStage.show();
    }



    public static void main(String[] args) throws FileNotFoundException {

        launch(args);
    }
}