package org.example.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 280 , 302);
        stage.setTitle("Calculator");
        stage.getIcons().add(new Image("file:img/icon.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}