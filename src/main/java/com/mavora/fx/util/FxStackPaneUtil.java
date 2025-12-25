package com.mavora.fx.util;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * Utility class for loading FXML content into StackPane containers.
 * Provides methods for creating, loading, and manipulating StackPane layouts.
 *
 * @author malaka senanayake @ mavora IT
 */
public class FxStackPaneUtil {

    private FxStackPaneUtil() {
        // Private constructor to prevent instantiation
    }

    /**
     * Loads FXML content and returns it wrapped in a StackPane.
     *
     * @param fxmlPath URL of the FXML file
     * @return StackPane containing the loaded content
     * @throws IOException if loading fails
     */
    public static StackPane loadStackPane(URL fxmlPath) throws IOException {
        Node content = loadFxml(fxmlPath, null);
        return wrapInStackPane(content);
    }

    /**
     * Loads FXML content with a specified controller and returns it wrapped in a StackPane.
     *
     * @param fxmlPath URL of the FXML file
     * @param controller Controller instance for the FXML
     * @return StackPane containing the loaded content
     * @throws IOException if loading fails
     */
    public static StackPane loadStackPane(URL fxmlPath, Object controller) throws IOException {
        Node content = loadFxml(fxmlPath, controller);
        return wrapInStackPane(content);
    }

    /**
     * Loads FXML content and replaces the content of the specified StackPane with fade animation.
     *
     * @param fxmlPath URL of the FXML file
     * @param targetPane Target StackPane to display the content
     * @throws IOException if loading or replacement fails
     */
    public static void loadIntoStackPane(URL fxmlPath, StackPane targetPane) throws IOException {
        if (targetPane == null) {
            throw new IllegalArgumentException("targetPane cannot be null");
        }

        Node loadedContent = loadFxml(fxmlPath, null);
        FxAnimationUtil.setFade(loadedContent);
        targetPane.getChildren().setAll(loadedContent);
    }

    /**
     * Loads FXML content with controller and replaces the content of the specified StackPane.
     *
     * @param fxmlPath URL of the FXML file
     * @param targetPane Target StackPane to display the content
     * @param controller Controller instance for the FXML
     * @throws IOException if loading or replacement fails
     */
    public static void loadIntoStackPane(URL fxmlPath, StackPane targetPane, Object controller) throws IOException {
        if (targetPane == null) {
            throw new IllegalArgumentException("targetPane cannot be null");
        }

        Node loadedContent = loadFxml(fxmlPath, controller);
        FxAnimationUtil.setFade(loadedContent);
        targetPane.getChildren().setAll(loadedContent);
    }

    /**
     * Creates a StackPane with centered content.
     *
     * @param content The content to add to the StackPane
     * @return A new StackPane with centered content
     */
    public static StackPane createCenteredStackPane(Node content) {
        StackPane stackPane = new StackPane(content);
        stackPane.setAlignment(Pos.CENTER);
        return stackPane;
    }

    /**
     * Creates an overlay StackPane with base and overlay layers.
     * Useful for modals, loading indicators, and popups.
     *
     * @param baseLayer The base content layer
     * @param overlayLayer The overlay content layer
     * @return StackPane with both layers
     */
    public static StackPane createOverlay(Node baseLayer, Node overlayLayer) {
        StackPane overlayPane = new StackPane();

        if (baseLayer != null) {
            overlayPane.getChildren().add(baseLayer);
        }

        if (overlayLayer != null) {
            overlayPane.getChildren().add(overlayLayer);
        }

        return overlayPane;
    }

    /**
     * Adds an overlay to an existing base content.
     * The base content should already be displayed in a StackPane or similar.
     *
     * @param basePane The existing StackPane with base content
     * @param overlayNode The overlay node to add
     * @return The modified StackPane with overlay
     */
    public static StackPane addOverlay(StackPane basePane, Node overlayNode) {
        if (basePane == null) {
            throw new IllegalArgumentException("basePane cannot be null");
        }

        if (overlayNode != null) {
            basePane.getChildren().add(overlayNode);
        }

        return basePane;
    }

    /**
     * Removes an overlay from a StackPane.
     *
     * @param pane The StackPane to remove overlay from
     * @param overlayNode The specific overlay node to remove
     */
    public static void removeOverlay(StackPane pane, Node overlayNode) {
        if (pane != null && overlayNode != null) {
            pane.getChildren().remove(overlayNode);
        }
    }

    /**
     * Clears all overlays from a StackPane, leaving only the base layer (first child).
     *
     * @param pane The StackPane to clear overlays from
     */
    public static void clearOverlays(StackPane pane) {
        if (pane != null && pane.getChildren().size() > 1) {
            Node baseLayer = pane.getChildren().get(0);
            pane.getChildren().setAll(baseLayer);
        }
    }

    /**
     * Sets alignment for all children in a StackPane.
     *
     * @param pane The StackPane to modify
     * @param alignment The alignment to apply
     */
    public static void setAlignmentForAll(StackPane pane, Pos alignment) {
        if (pane != null && alignment != null) {
            pane.setAlignment(alignment);
            for (Node child : pane.getChildren()) {
                StackPane.setAlignment(child, alignment);
            }
        }
    }

    /**
     * Loads FXML content from URL.
     */
    private static Node loadFxml(URL fxmlPath, Object controller) throws IOException {
        FXMLLoader loader = new FXMLLoader(fxmlPath);

        if (controller != null) {
            loader.setController(controller);
        }

        return loader.load();
    }

    /**
     * Wraps a node in a StackPane with default settings.
     */
    private static StackPane wrapInStackPane(Node content) {
        StackPane stackPane = new StackPane(content);
        return stackPane;
    }
}