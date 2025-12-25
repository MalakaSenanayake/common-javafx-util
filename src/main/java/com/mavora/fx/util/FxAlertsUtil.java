package com.mavora.fx.util;

import java.util.Objects;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author malaka senanayake @ mavora IT
 */
public class FxAlertsUtil {

    static Alert alert;
    static DialogPane dialogPane;

    private static final String STYLE;
    //------------------------------------------------------------------------------------------------------------------
    static {
        if(Configuration.getTheme()== Configuration.Theme.LIGHT){ //DARK
            STYLE = Configuration.ALERT_LIGHT_THEME_STYLE;
        }else {
            STYLE = Configuration.ALERT_DARK_THEME_STYLE;
        }
    }

    //error alert-------------------------------------------------------------------------------------------------
    public static void errorMessage(String message,Stage owner) {
        alert = new Alert(AlertType.ERROR);
        setDialogPane(owner);
        alert.setTitle(Configuration.getAppName());
        alert.setHeaderText("Error !");
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void errorMessage(String message) {
        alert = new Alert(AlertType.ERROR);
        setDialogPane();
        alert.setTitle(Configuration.getAppName());
        alert.setHeaderText("Error !");
        alert.setContentText(message);
        alert.showAndWait();
    }
    //Information alert-------------------------------------------------------------------------------------------------
    public static void informationMessage(String message, Stage owner) {
        alert = new Alert(AlertType.INFORMATION);
        setDialogPane(owner);
        alert.setTitle(Configuration.getAppName());
        alert.setHeaderText("Success !");
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void informationMessage(String message) {
        alert = new Alert(AlertType.INFORMATION);
        setDialogPane();
        alert.setTitle(Configuration.getAppName());
        alert.setHeaderText("Success !");
        alert.setContentText(message);
        alert.showAndWait();
    }
    //Waning alert -----------------------------------------------------------------------------------------------------
    public static void waningMessage(String message, Stage owner) {
        alert = new Alert(AlertType.WARNING);
        setDialogPane(owner);
        alert.setTitle(Configuration.getAppName());
        alert.setHeaderText("Warning !");
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static void waningMessage(String message) {
        alert = new Alert(AlertType.WARNING);
        setDialogPane();
        alert.setTitle(Configuration.getAppName());
        alert.setHeaderText("Warning !");
        alert.setContentText(message);
        alert.showAndWait();
    }
    //Is saved alert ---------------------------------------------------------------------------------------------------
    public static void isSavedMessage(boolean isSave, Stage owner) {
        if (isSave) {
            informationMessage("Action completed successfully !", owner);
        } else {
            errorMessage("An error occurred. Please try again.", owner);
        }
    }
    public static void isSavedMessage(boolean isSave) {
        if (isSave) {
            informationMessage("Action completed successfully !");
        } else {
            errorMessage("An error occurred. Please try again.");
        }
    }
    //Conformation alert------------------------------------------------------------------------------------------------
    public static boolean conformationMessage(String message, Stage owner) {
        boolean b = false;
        alert = new Alert(AlertType.CONFIRMATION);
        setDialogPane(owner);
        alert.setTitle(Configuration.getAppName());
        alert.setHeaderText("Confirmation !");
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        // ... user chose OK
        // ... user chose CANCEL or closed the dialog
        b = result.get() == ButtonType.OK;
        return b;
    }
    public static boolean conformationMessage(String message) {
        boolean b = false;
        alert = new Alert(AlertType.CONFIRMATION);
        setDialogPane();
        alert.setTitle(Configuration.getAppName());
        alert.setHeaderText("Confirmation !");
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        // ... user chose OK
        // ... user chose CANCEL or closed the dialog
        b = result.get() == ButtonType.OK;
        return b;
    }
    // Helping method for all -------------------------------------------------------------------------------------------
    private static void setDialogPane(Stage owner) {
        dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(Objects.requireNonNull(FxAlertsUtil.class.getResource(STYLE)).toExternalForm());
        ((Stage) dialogPane.getScene().getWindow()).getIcons().add(new Image(Configuration.getAppIcon()));
        alert.initOwner(owner);
        alert.initModality(Modality.APPLICATION_MODAL);
    }
    // -----------------------------------------------------------------------------------------------------------------
    private static void setDialogPane() {
        dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(Objects.requireNonNull(FxAlertsUtil.class.getResource(STYLE)).toExternalForm());
        ((Stage) dialogPane.getScene().getWindow()).getIcons().add(new Image(Configuration.getAppIcon()));
        alert.initModality(Modality.APPLICATION_MODAL);
    }
    //------------------------------------------------------------------------------------------------------------------
}
