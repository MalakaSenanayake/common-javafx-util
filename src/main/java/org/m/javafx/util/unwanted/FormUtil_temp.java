package org.m.javafx.util.unwanted;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.m.javafx.util.Configuration;

import java.io.IOException;
import java.net.URL;

class FormUtil_temp {

    // Instance variables
    private static FXMLLoader loader;
    private static Stage subStage;
    private static AnchorPane root;
    private static Scene scene;

    // Maximized Frame Methods
    /**
     * Creates a new maximized undecorated frame.
     * @param fxmlAnchorPanePath URL to the FXML file
     */
    public static void newUndecoratedMaximizedFrame(URL fxmlAnchorPanePath) {
        try {
            initializeStage(StageStyle.UNDECORATED);
            subStage.setMaximized(true);
            loadFXML(fxmlAnchorPanePath);
            showStage();
        } catch (IOException ex) {
            logException("newUndecoratedMaximizedFrame", ex);
        }
        cleanup();
    }

    public static void newMaximizedFrame(URL fxmlPath) {
        try {
            initializeStage(StageStyle.DECORATED);
            subStage.setMaximized(true);
            loadFXML(fxmlPath);
            showStage();
        } catch (IOException ex) {
            logException("newMaximizedFrame", ex);
        }
        cleanup();
    }

    public static void newMaximizedFrame(URL fxmlPath, Object controller) {
        try {
            initializeStage(StageStyle.DECORATED);
            subStage.setMaximized(true);
            loadFXML(fxmlPath, controller);
            showStage();
        } catch (IOException ex) {
            logException("newMaximizedFrame", ex);
        }
        cleanup();
    }

    // Standard Frame Methods
    public static void newFrame(URL fxmlPath) {
        try {
            initializeStage(StageStyle.DECORATED);
            loadFXML(fxmlPath);
            showStage();
        } catch (IOException ex) {
            logException("newFrame", ex);
        }
        cleanup();
    }

    public static void newFrame(URL fxmlPath, Stage owner) {
        try {
            initializeStage(StageStyle.DECORATED);
            subStage.initOwner(owner);
            subStage.initModality(Modality.APPLICATION_MODAL);
            loadFXML(fxmlPath);
            showStage();
        } catch (IOException ex) {
            logException("newFrame", ex);
        }
        cleanup();
    }

    public static void newFrame(URL fxmlPath, Object controller,Stage owner) {
        try {
            initializeStage(StageStyle.DECORATED);
            subStage.initOwner(owner);
            subStage.setAlwaysOnTop(true);
            subStage.setResizable(false);
            loadFXML(fxmlPath, controller);
            showStage();
        } catch (IOException ex) {
            logException("newFrame", ex);
        }
        cleanup();
    }

    // Dialog Methods (Decorated)
    public static void newDialog(URL fxmlAnchorPanePath) {
        try {
            initializeStage(StageStyle.DECORATED);
            configureDialog();
            loadFXML(fxmlAnchorPanePath);
            showStage();
        } catch (IOException ex) {
            logException("newDialog", ex);
        }
        cleanup();
    }

    public static void newDialog(URL fxmlAnchorPanePath, Stage owner) {
        try {
            initializeStage(StageStyle.DECORATED);
            subStage.initOwner(owner);
            subStage.getIcons().add(new Image(Configuration.APP_ICON));
            configureDialog();
            loadFXML(fxmlAnchorPanePath);
            showStage();
        } catch (IOException ex) {
            logException("newDialog", ex);
        }
        cleanup();
    }

    public static void newDialog(URL fxmlAnchorPanePath, Object controller , Stage owner) {
        try {
            initializeStage(StageStyle.DECORATED);
            subStage.initOwner(owner);
            configureDialog();
            loadFXML(fxmlAnchorPanePath, controller);
            showStage();
        } catch (IOException ex) {
            logException("newDialog", ex);
        }
        cleanup();
    }

    // Dialog Methods (Undecorated)
    public static void newUndecoratedDialog(URL fxmlAnchorPanePath) {
        try {
            initializeStage(StageStyle.UNDECORATED);
            subStage.initModality(Modality.APPLICATION_MODAL);
            loadFXML(fxmlAnchorPanePath);
            showStage();
        } catch (IOException ex) {
            logException("newUndecoratedDialog", ex);
        }
        cleanup();
    }

    public static void newUndecoratedDialog(URL fxmlAnchorPanePath, Object controller) {
        try {
            initializeStage(StageStyle.UNDECORATED);
            subStage.initModality(Modality.APPLICATION_MODAL);
            loadFXML(fxmlAnchorPanePath, controller);
            showStage();
        } catch (IOException ex) {
            logException("newUndecoratedDialog", ex);
        }
        cleanup();
    }



    // Transparent Dialog Method
    public static void newTransparentDialog(URL fxmlAnchorPanePath) {
        try {
            initializeStage(StageStyle.TRANSPARENT);
            subStage.initModality(Modality.APPLICATION_MODAL);
            loadFXML(fxmlAnchorPanePath);
            scene.setFill(Color.TRANSPARENT);
            showStage();
        } catch (IOException ex) {
            logException("newTransparentDialog", ex);
        }
        cleanup();
    }

    // Group Pane Dialog Methods
    public static void newUndecoratedDialogGroupPane(URL fxmlGroupPanePath) {
        try {
            initializeStageWithGroup(StageStyle.UNDECORATED);
            subStage.initModality(Modality.APPLICATION_MODAL);
            loadFXML(fxmlGroupPanePath);
            showStage();
        } catch (IOException ex) {
            logException("newUndecoratedDialogGroupPane", ex);
        }
        cleanup();
    }

    public static void newUndecoratedDialogGroupPane(URL fxmlGroupPanePath, Object controller) {
        try {
            initializeStageWithGroup(StageStyle.UNDECORATED);
            subStage.initModality(Modality.APPLICATION_MODAL);
            loadFXML(fxmlGroupPanePath, controller);
            showStage();
        } catch (IOException ex) {
            logException("newUndecoratedDialogGroupPane", ex);
        }
        cleanup();
    }

    public static void newDialogGroupPane(URL fxmlGroupPanePath) {
        try {
            initializeStageWithGroup(StageStyle.DECORATED);
            subStage.initModality(Modality.APPLICATION_MODAL);
            subStage.setResizable(false);
            loadFXML(fxmlGroupPanePath);
            showStage();
        } catch (IOException ex) {
            logException("newDialogGroupPane", ex);
        }
        cleanup();
    }

    public static void newDialogGroupPane(URL fxmlGroupPanePath, Object controller) {
        try {
            initializeStageWithGroup(StageStyle.DECORATED);
            subStage.initModality(Modality.APPLICATION_MODAL);
            subStage.setResizable(false);
            loadFXML(fxmlGroupPanePath, controller);
            showStage();
        } catch (IOException ex) {
            logException("newDialogGroupPane", ex);
        }
        cleanup();
    }

    // Utility Methods
    public static void closeWindow(Node node) {
        ((Stage) node.getParent().getScene().getWindow()).close();
    }

    // Private Helper Methods
    private static void initializeStage(StageStyle style) {
        subStage = new Stage();
        root = new AnchorPane();
        subStage.initStyle(style);
        loader = new FXMLLoader();
    }

    private static void initializeStageWithGroup(StageStyle style) {
        subStage = new Stage();
        root = new AnchorPane();
        subStage.initStyle(style);
        loader = new FXMLLoader();
    }

    private static void loadFXML(URL fxmlPath) throws IOException {
        loader.setLocation(fxmlPath);
        root = loader.load();
        scene = new Scene(root);
    }

    private static void loadFXML(URL fxmlPath, Object controller) throws IOException {
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
        subStage.setScene(scene);
        subStage.centerOnScreen();
        subStage.show();
    }

    private static void logException(String methodName, Exception ex) {
        System.out.println(methodName + ": " + ex);
    }

    private static void cleanup() {
        System.gc();
    }
}
