package controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.BackStack;
import model.Leaf;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class LeafViewController extends Application {

    public VBox parentContainer;
    public VBox leftChild;
    public VBox rightChild;
    public VBox LeafView;
    public HBox actionBox;
    public Button changeBoolButton;
    public Label labelID;

    public static void main(String[] args) {
        launch(args);
    }
    VBox view = null;
    VBox primaryStack;

    @FXML
    public void initialize() {
        labelID.setText(BackStack.getIDCounter());
        BackStack.incrementIDCounter();
    }

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
    public void addSplitLeaf(ActionEvent event) {
        VBox branch = null;
        SplitPane subBranchContainer = null;

        System.out.println(event.getSource());
        try {
            LeafView.getChildren().remove(1);
            branch = FXMLLoader.load(getClass().getResource("splitBranchView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        subBranchContainer = (SplitPane) branch.getChildren().get(1);
        VBox leftSubBranch = (VBox) subBranchContainer.getItems().get(0);
        VBox rightSubBranch = (VBox) subBranchContainer.getItems().get(1);
        Leaf leafLeft = new Leaf(leftSubBranch);
        Leaf leafRight = new Leaf(rightSubBranch);
        leftSubBranch.getChildren().add(leafLeft.getLeafView());
        rightSubBranch.getChildren().add(leafRight.getLeafView());

        BackStack.getStack().get(1).getChildren().addAll(branch,subBranchContainer);
        BackStack.pushToStack(branch);
        System.out.println(BackStack.getStack().get(BackStack.getStack().size()-1).getParent().getId());
    }

    @FXML
    public void addSingleLeaf(ActionEvent event) {
        VBox branch = null;
        VBox leaf = null;

        try {
            branch = FXMLLoader.load(getClass().getResource("singleBranchView.fxml"));
            leaf = FXMLLoader.load(getClass().getResource("LeafView.fxml"));
            LeafView.getChildren().remove(1);
            Button btn = (Button) event.getSource();
            Label lbl = (Label) btn.getParent().getParent().getChildrenUnmodifiable().get(0);
            //LeafView.getChildren().add(leaf.getChildren().get(1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        VBox containerToAddTo = (VBox) BackStack.getStack().get(BackStack.getStack().size()-1).getParent();
        //BackStack.getStack().get(0).getChildren().addAll(branch,leaf);
        containerToAddTo.getChildren().addAll(branch,leaf);
        BackStack.pushToStack(branch);
        BackStack.pushToStack(leaf);
    }

    @FXML
    public void changeBool(ActionEvent event) {
        if(changeBoolButton.getText().equals("T")){
            changeBoolButton.setText("F");
        } else {
            changeBoolButton.setText("T");
        }
        System.out.println(event.getSource());
    }

}
