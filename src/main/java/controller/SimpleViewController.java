package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.BackStack;

import java.io.IOException;

public class SimpleViewController extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @FXML
    VBox primaryStack;

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = null;
        VBox primaryStack = null;

        try {
            root = FXMLLoader.load(getClass().getResource("SimpleView.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

        VBox leaf = FXMLLoader.load(getClass().getResource("LeafView.fxml"));
    }

    public void addLeaf(ActionEvent event) {
        VBox leaf = null;
        try{
            leaf = FXMLLoader.load(getClass().getResource("LeafView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BackStack.setActionBox((HBox) leaf.getChildren().get(1));
        BackStack.pushToStack(primaryStack);
        primaryStack.getChildren().add(leaf);
    }

    public void undo(ActionEvent event) {
        if(BackStack.getStack().size() > 1) {
            BackStack.popStack();
            BackStack.popStack();
            BackStack.getStack().get(0).getChildren().remove(BackStack.getStack().get(0).getChildren().size()-1);
            BackStack.getStack().get(0).getChildren().remove(BackStack.getStack().get(0).getChildren().size()-1);

            //Make the single split button reappear
            VBox leafView = (VBox) BackStack.getStack().get(0).getChildren().get(BackStack.getStack().get(0).getChildren().size()-1);
            leafView.getChildren().add(BackStack.getActionBox());

            //BackStack.getStack().get(0).getChildren().get(BackStack.getStack().get(0).getChildren().size()-1).lookup("#actionBox").setVisible(true);
        }

    }
}
