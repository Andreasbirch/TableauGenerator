package model;

import javafx.scene.layout.VBox;

public class Branch {
    private Leaf parentContainer;
    private VBox branchView;
    private VBox primarySubContainer;
    private VBox secondarySubContainer;

    public Branch(Leaf parentContainer, VBox primarySubContainer){
        this.parentContainer = parentContainer;
        this.primarySubContainer = primarySubContainer;
    }

    public Branch(Leaf parentContainer, VBox primarySubContainer, VBox secondarySubContainer){
        this.parentContainer = parentContainer;
        this.primarySubContainer = primarySubContainer;
        this.secondarySubContainer = secondarySubContainer;
    }
}
