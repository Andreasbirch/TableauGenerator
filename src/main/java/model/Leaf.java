package model;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Leaf {
    private VBox view = null;
    private VBox parentContainer;
    private VBox childBranch;

    public Leaf (VBox viewContainer) {
        this.parentContainer = viewContainer;

        try {
            this.view = FXMLLoader.load(getClass().getResource("/controller/LeafView.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BackStack.getStack().add(view);
    }
    public VBox getViewContainer(){
        return parentContainer;
    }
    public VBox getLeafView(){
        return view;
    }
}
