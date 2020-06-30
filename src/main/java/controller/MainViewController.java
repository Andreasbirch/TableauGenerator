package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainViewController extends Application {
    public List<VBox> Stack = new ArrayList<>();
    public HBox infoHbox;

    public static void main(String[] args) {
        launch(args);
    }
    private int posY = 50;

    @FXML
    private AnchorPane mainPane;
    @FXML
    private Button changeBoolButton;

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MainView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);

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
        VBox nodeView;
        try {
            nodeConnector = FXMLLoader.load(getClass().getResource("NodeConnectorView.fxml"));
            HBox connectorHbox = (HBox) nodeConnector.lookup("#connectorHbox");
            Line singleLine = new Line (140, posY, 140, posY+50);
            connectorHbox.getChildren().removeAll();
            connectorHbox.getChildren().add(0, singleLine);

            nodeConnector.setLayoutX(280);
            nodeConnector.setLayoutY(posY);



            nodeView = FXMLLoader.load(getClass().getResource("NodeView.fxml"));
            nodeView.setLayoutX(140);
            nodeView.setLayoutY(posY+50);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        mainPane.getChildren().addAll(nodeConnector, nodeView);
    }

    @FXML
    public void branchClose(ActionEvent event) {
        System.out.println("Close Branch");
    }

    @FXML
    public void changeBool(ActionEvent event) {
        if(changeBoolButton.getText().equals("T")){
            changeBoolButton.setText("F");
        } else {
            changeBoolButton.setText("T");
        }
    }
}
