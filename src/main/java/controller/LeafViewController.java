package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.BackStack;

import java.io.IOException;
import java.util.List;

public class LeafViewController extends Application {

    public VBox LeafView;
    public HBox actionBox;

    public static void main(String[] args) {
        launch(args);
    }
    VBox view = null;
    VBox primaryStack;
    @Override
    public void start(Stage primaryStage) {
        try {
            view = FXMLLoader.load(getClass().getResource("SimpleView.fxml"));
            primaryStack = (VBox) view.lookup("#primaryStack");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void addSingleLeaf(ActionEvent event) {
        VBox branch = null;
        VBox leaf = null;

        try {
            branch = FXMLLoader.load(getClass().getResource("singleBranchView.fxml"));
            leaf = FXMLLoader.load(getClass().getResource("LeafView.fxml"));
            LeafView.getChildren().remove(1);
            //LeafView.getChildren().add(leaf.getChildren().get(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BackStack.getStack().get(0).getChildren().addAll(branch,leaf);
        BackStack.pushToStack(branch);
        BackStack.pushToStack(leaf);


    }
}
