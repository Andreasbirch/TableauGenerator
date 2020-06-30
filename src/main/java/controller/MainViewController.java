package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    private int posY = 50;

    @FXML
    private AnchorPane mainPane;

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        NodeController nodeController = new NodeController();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    public void branchSplit(ActionEvent event) {
        System.out.println("Split Branch");
    }

    @FXML
    public void branchSingle(ActionEvent event) {
        System.out.println("Single Branch");
        HBox nodeConnector;
        try {
            nodeConnector = FXMLLoader.load(getClass().getResource("NodeConnectorView.fxml"));
            nodeConnector.setLayoutX(140);
            nodeConnector.setLayoutY(posY);
            posY += 50;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainPane.getChildren().add(nodeConnector);
    }

    @FXML
    public void branchClose(ActionEvent event) {
        System.out.println("Close Branch");
    }
}
