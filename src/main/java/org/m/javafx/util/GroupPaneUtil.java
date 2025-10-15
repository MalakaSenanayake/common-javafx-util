package org.m.javafx.util;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

/**
 * @author malaka Senanayake @ Creative IT
 */
public class GroupPaneUtil {

    static FXMLLoader loder;
    static Group root;
    //------------------------------------------------------------------------------------------------------------------

    public static Group setNew(URL fxmlPath) {
        root = new Group();
        try {
            loder = new FXMLLoader();
            loder.setLocation(fxmlPath);
            root = loder.load();
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return root;
    }
    //------------------------------------------------------------------------------------------------------------------

    public static Group setNew(URL fxmlPath, Object controller) {
        root = new Group();
        try {
            loder = new FXMLLoader();
            loder.setLocation(fxmlPath);
            loder.setController(controller);
            root = loder.load();
            AnchorPane.setTopAnchor(root, 0.0);
            AnchorPane.setBottomAnchor(root, 0.0);
            AnchorPane.setLeftAnchor(root, 0.0);
            AnchorPane.setRightAnchor(root, 0.0);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return root;
    }
    //------------------------------------------------------------------------------------------------------------------
}
