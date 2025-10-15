package org.m.javafx.util;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Utility class for creating and managing JavaFX windows and dialogs.
 * Provides methods to create various types of frames and dialogs with different configurations.
 *
 * @author Malaka Senanayake @ Creative IT
 */
public class FormUtil {

    private static FXMLLoader loader;
    private static Stage subStage;
    private static AnchorPane root;
    private static Scene scene;

    // Standard Frame Methods with Image support
    public static void newFrame(URL fxmlPath, Stage owner) {
        try {
            initializeStage(StageStyle.DECORATED);
            subStage.initOwner(owner);
            subStage.initModality(Modality.APPLICATION_MODAL);
            setStageIcon();
            loadFXML(fxmlPath);
            showStage();
        } catch (IOException ex) {
            handleException("Failed to create new frame with owner", ex);
        } catch (IllegalArgumentException ex) {
            handleException("Invalid image path specified", ex);
        } finally {
            cleanup();
        }
    }

    public static void newFrame(URL fxmlPath, Object controller, Stage owner) {
        try {
            initializeStage(StageStyle.DECORATED);
            subStage.initOwner(owner);
            subStage.setAlwaysOnTop(true);
            subStage.setResizable(false);
            setStageIcon();
            loadFXML(fxmlPath, controller);
            showStage();
        } catch (IOException ex) {
            handleException("Failed to create new frame with controller", ex);
        } catch (IllegalArgumentException ex) {
            handleException("Invalid image path specified", ex);
        } finally {
            cleanup();
        }
    }

    // Dialog Methods (Decorated) with Image support

    public static void newDialog(URL fxmlAnchorPanePath, Stage owner) {
        try {
            initializeStage(StageStyle.DECORATED);
            subStage.initOwner(owner);
            setStageIcon();
            configureDialog();
            loadFXML(fxmlAnchorPanePath);
            showStage();
        } catch (IOException ex) {
            handleException("Failed to create new dialog with owner", ex);
        } catch (IllegalArgumentException ex) {
            handleException("Invalid image path specified", ex);
        } finally {
            cleanup();
        }
    }

    public static void newDialog(URL fxmlAnchorPanePath, Object controller, Stage owner) {
        try {
            initializeStage(StageStyle.DECORATED);
            subStage.initOwner(owner);
            configureDialog();
            setStageIcon();
            loadFXML(fxmlAnchorPanePath, controller);
            showStage();
        } catch (IOException ex) {
            handleException("Failed to create new dialog with controller", ex);
        } catch (IllegalArgumentException ex) {
            handleException("Invalid image path specified", ex);
        } finally {
            cleanup();
        }
    }

    // Utility Methods--------------------------------------------------------------------------------------------------
    public static void closeWindow(Node node) {
        try {
            if (node != null && node.getParent() != null && node.getParent().getScene() != null) {
                ((Stage) node.getParent().getScene().getWindow()).close();
            }
        } catch (Exception ex) {
            handleException("Failed to close window", ex);
        }
    }

    // Private Helper Methods
    private static void initializeStage(StageStyle style) throws IllegalStateException {
        try {
            subStage = new Stage();
            root = new AnchorPane();
            subStage.initStyle(style);
            loader = new FXMLLoader();
        } catch (Exception ex) {
            throw new IllegalStateException("Failed to initialize stage", ex);
        }
    }

    private static void loadFXML(URL fxmlPath) throws IOException {
        if (fxmlPath == null) {
            throw new IllegalArgumentException("FXML path cannot be null");
        }
        loader.setLocation(fxmlPath);
        root = loader.load();
        scene = new Scene(root);
    }

    private static void loadFXML(URL fxmlPath, Object controller) throws IOException {
        if (fxmlPath == null) {
            throw new IllegalArgumentException("FXML path cannot be null");
        }
        loader.setLocation(fxmlPath);
        loader.setController(controller);
        root = loader.load();
        scene = new Scene(root);
    }

    private static void configureDialog() {
        subStage.initModality(Modality.APPLICATION_MODAL);
        subStage.setResizable(false);
    }

    private static void showStage() {
        try {
            subStage.setScene(scene);
            subStage.centerOnScreen();
            subStage.show();
        } catch (Exception ex) {
            handleException("Failed to show stage", ex);
        }
    }

    private static void setStageIcon() {
        String imagePath = Configuration.APP_ICON;
        try {
            Image icon = new Image(imagePath);
            subStage.getIcons().add(icon);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Failed to load icon from: " + imagePath, ex);
        }
    }

    private static void handleException(String message, Exception ex) {
        System.err.println(message + ": " + ex.getMessage());
        ex.printStackTrace();
    }

    private static void cleanup() {
        try {
            System.gc();
        } catch (Exception ex) {
            handleException("Failed to perform cleanup", ex);
        }
    }
}