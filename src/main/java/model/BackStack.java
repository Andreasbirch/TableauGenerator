package model;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class BackStack {
    private static int IDCounter = 0;
    private static Object instance;
    private static List<VBox> stack = new ArrayList<>();
    private static HBox actionBox;

    private BackStack() { }

    public static List<VBox> getStack () {
        return stack;
    }

    public static void popStack(){
        stack.remove(stack.size()-1);
    }

    public static void pushToStack(VBox vBox){
        stack.add(vBox);
    }

    public static String getIDCounter() {
        return String.valueOf(IDCounter);
    }

    public static  void incrementIDCounter() {
        IDCounter++;
    }

    public static Object getInstance() {
        return instance;
    }

    public static void setActionBox(HBox template) {
        actionBox = template;
    }

    public static HBox getActionBox() {
        return actionBox;
    }

    public static VBox findLeafWithID(String id){
        for (VBox vBox:stack){
            if(vBox.lookup("labelID").equals(id)){
                return vBox;
            }
        }
        return null;
    }
}
