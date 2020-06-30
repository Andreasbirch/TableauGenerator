package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class NodeController extends Application {
    @FXML
    public HBox infoHbox;
    public HBox optionsHbox;
    public VBox mainPane;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("NodeView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    @FXML
    public void branchSingle(ActionEvent event) {
        System.out.println("Single Branch");
        HBox nodeConnector;
        VBox nodeView;
        try {
            nodeConnector = FXMLLoader.load(getClass().getResource("NodeConnectorView.fxml"));
            HBox connectorHbox = (HBox) nodeConnector.lookup("#connectorHbox");
            Line singleLine = new Line (140, 50, 140, 50+50);
            connectorHbox.getChildren().removeAll();
            connectorHbox.getChildren().add(0, singleLine);

            nodeConnector.setLayoutX(280);
            nodeConnector.setLayoutY(50);



            nodeView = FXMLLoader.load(getClass().getResource("NodeView.fxml"));
            nodeView.setLayoutX(140);
            nodeView.setLayoutY(50+50);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainPane.getChildren().addAll(nodeConnector, nodeView);
    }

    public void branchSplit(ActionEvent event) {
    }

    public void branchClose(ActionEvent event) {
    }
}
