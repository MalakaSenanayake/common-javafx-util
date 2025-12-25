package com.mavora.fx.util;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

/**
 * Utility class for loading FXML files into Group nodes with optional AnchorPane constraints.
 *
 * @author malaka Senanayake @ Creative IT
 */
public class FxGroupPaneUtil {

    private FxGroupPaneUtil() {
        // Private constructor to prevent instantiation
    }

    /**
     * Loads an FXML file and returns it as a Group node.
     *
     * @param fxmlPath the URL of the FXML file to load
     * @return the loaded Group node
     * @throws IOException if the FXML file cannot be loaded
     */
    public static Group loadGroup(URL fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(fxmlPath);
        Group group = loader.load();
        return group;
    }

    /**
     * Loads an FXML file with a specified controller and returns it as a Group node.
     *
     * @param fxmlPath the URL of the FXML file to load
     * @param controller the controller instance to use
     * @return the loaded Group node
     * @throws IOException if the FXML file cannot be loaded
     */
    public static Group loadGroup(URL fxmlPath, Object controller) throws IOException {
        FXMLLoader loader = new FXMLLoader(fxmlPath);
        loader.setController(controller);
        Group group = loader.load();
        return group;
    }

    /**
     * Loads an FXML file and returns it as a Group node with AnchorPane constraints.
     * The Group will be constrained to fill its parent AnchorPane.
     *
     * @param fxmlPath the URL of the FXML file to load
     * @return the loaded Group node with AnchorPane constraints
     * @throws IOException if the FXML file cannot be loaded
     */
    public static Group loadGroupWithAnchorConstraints(URL fxmlPath) throws IOException {
        Group group = loadGroup(fxmlPath);
        applyAnchorConstraints(group);
        return group;
    }

    /**
     * Loads an FXML file with a specified controller and returns it as a Group node
     * with AnchorPane constraints.
     * The Group will be constrained to fill its parent AnchorPane.
     *
     * @param fxmlPath the URL of the FXML file to load
     * @param controller the controller instance to use
     * @return the loaded Group node with AnchorPane constraints
     * @throws IOException if the FXML file cannot be loaded
     */
    public static Group loadGroupWithAnchorConstraints(URL fxmlPath, Object controller) throws IOException {
        Group group = loadGroup(fxmlPath, controller);
        applyAnchorConstraints(group);
        return group;
    }

    /**
     * Applies AnchorPane constraints to a Group node.
     * This sets the Group to fill its parent AnchorPane.
     *
     * @param group the Group node to apply constraints to
     * @return the Group with constraints applied
     */
    private static Group applyAnchorConstraints(Group group) {
        AnchorPane.setTopAnchor(group, 0.0);
        AnchorPane.setBottomAnchor(group, 0.0);
        AnchorPane.setLeftAnchor(group, 0.0);
        AnchorPane.setRightAnchor(group, 0.0);
        return group;
    }
}