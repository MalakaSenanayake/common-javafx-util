package com.mavora.fx.util;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * Utility class for loading FXML files into AnchorPanes with proper constraints.
 *
 * @author malaka senanayake @ mavora IT
 */
public class FxAnchorPaneUtil {

    private FxAnchorPaneUtil() {
        // Private constructor to prevent instantiation
    }

    /**
     * Loads an FXML file and returns an AnchorPane with all constraints set to 0.
     *
     * @param fxmlPath the URL of the FXML file to load
     * @return the loaded AnchorPane
     * @throws IOException if the FXML file cannot be loaded
     */
    public static AnchorPane loadAnchorPane(URL fxmlPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
        AnchorPane root = fxmlLoader.load();

        // Set constraints to fill parent
        AnchorPane.setTopAnchor(root, 0.0);
        AnchorPane.setBottomAnchor(root, 0.0);
        AnchorPane.setLeftAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);

        return root;
    }

    /**
     * Loads an FXML file with a specified controller and returns an AnchorPane
     * with all constraints set to 0.
     *
     * @param fxmlPath the URL of the FXML file to load
     * @param controller the controller instance to use
     * @return the loaded AnchorPane
     * @throws IOException if the FXML file cannot be loaded
     */
    public static AnchorPane loadAnchorPane(URL fxmlPath, Object controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
        fxmlLoader.setController(controller);
        AnchorPane root = fxmlLoader.load();

        // Set constraints to fill parent
        AnchorPane.setTopAnchor(root, 0.0);
        AnchorPane.setBottomAnchor(root, 0.0);
        AnchorPane.setLeftAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);

        return root;
    }

    /**
     * Loads an FXML file into a specified AnchorPane container with fade animation.
     *
     * @param fxmlPath the URL of the FXML file to load
     * @param container the AnchorPane container to load the content into
     * @throws IOException if the FXML file cannot be loaded
     */
    public static void loadIntoContainer(URL fxmlPath, AnchorPane container) throws IOException {
        AnchorPane content = loadAnchorPane(fxmlPath);
        FxAnimationUtil.setFade(content);
        container.getChildren().clear();
        container.getChildren().add(content);
    }

    /**
     * Loads an FXML file with a specified controller into a container with fade animation.
     *
     * @param fxmlPath the URL of the FXML file to load
     * @param container the AnchorPane container to load the content into
     * @param controller the controller instance to use
     * @throws IOException if the FXML file cannot be loaded
     */
    public static void loadIntoContainer(URL fxmlPath, AnchorPane container, Object controller) throws IOException {
        AnchorPane content = loadAnchorPane(fxmlPath, controller);
        FxAnimationUtil.setFade(content);
        container.getChildren().clear();
        container.getChildren().add(content);
    }
}