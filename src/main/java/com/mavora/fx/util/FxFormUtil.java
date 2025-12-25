package com.mavora.fx.util;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Utility class for creating and managing JavaFX windows and dialogs.
 * Provides methods to create various types of frames and dialogs with different configurations.
 *
 * @author Malaka Senanayake @ Creative IT
 */
public class FxFormUtil {

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
            Print.error(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            Print.error(ex.getMessage());
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
            Print.error(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            Print.error(ex.getMessage());
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
            Print.error(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            Print.error(ex.getMessage());
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
            Print.error(ex.getMessage());
        } catch (IllegalArgumentException ex) {
            Print.error(ex.getMessage());
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
            Print.error(ex.getMessage());
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
            Print.error(ex.getMessage());
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
            Print.error(ex.getMessage());
        }
    }

    private static void setStageIcon() {
        String imagePath = Configuration.getAppIcon();
        try {
            Image icon = new Image(imagePath);
            subStage.getIcons().add(icon);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Failed to load icon from: " + imagePath, ex);
        }
    }
    private static void cleanup() {
        try {
            System.gc();
        } catch (Exception ex) {
            Print.error(ex.getMessage());
        }
    }
}