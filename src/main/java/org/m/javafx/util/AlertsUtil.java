package org.m.javafx.util;

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
 * @author malaka senanayake @ Creative IT feature 
 */
public class AlertsUtil {

    static Alert alert;
    static DialogPane dialogPane;
    private static final String STYLE ;
    //------------------------------------------------------------------------------------------------------------------
    static {
        if(Theme.getTheme().equals(Configuration.DARK_THEME)){
            STYLE = "/style/alertStyleDark.css";
        }else if(Theme.getTheme().equals(Configuration.LIGHT_THEME)) {
            STYLE = "/style/alertStyleLight.css";
        }else{
            STYLE = "/style/alertStyleLight.css";
            MessageUtil.themeConfigurationMsg();
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void errorMessage(String message,Stage owner) {
        alert = new Alert(AlertType.ERROR);
        dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(Objects.requireNonNull(AlertsUtil.class.getResource(STYLE)).toExternalForm());
        ((Stage) dialogPane.getScene().getWindow()).getIcons().add(new Image(Configuration.APP_ICON));
        alert.initOwner(owner);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle(owner.getTitle());
        alert.setHeaderText("Error !");
        alert.setContentText(message);
        alert.showAndWait();
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void informationMessage(String message, Stage owner) {
        alert = new Alert(AlertType.INFORMATION);
        dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(Objects.requireNonNull(AlertsUtil.class.getResource(STYLE)).toExternalForm());
        ((Stage) dialogPane.getScene().getWindow()).getIcons().add(new Image(Configuration.APP_ICON));
        alert.initOwner(owner);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle(owner.getTitle());
        alert.setHeaderText("Success !");
        alert.setContentText(message);
        alert.showAndWait();
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void waningMessage(String message, Stage owner) {
        alert = new Alert(AlertType.WARNING);
        dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(Objects.requireNonNull(AlertsUtil.class.getResource(STYLE)).toExternalForm());
        ((Stage) dialogPane.getScene().getWindow()).getIcons().add(new Image(Configuration.APP_ICON));
        alert.initOwner(owner);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle(owner.getTitle());
        alert.setHeaderText("Warning !");
        alert.setContentText(message);
        alert.showAndWait();
    }
    //------------------------------------------------------------------------------------------------------------------
    public static void waningMessage(String message) {
        alert = new Alert(AlertType.WARNING);
        dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(Objects.requireNonNull(AlertsUtil.class.getResource(STYLE)).toExternalForm());
        ((Stage) dialogPane.getScene().getWindow()).getIcons().add(new Image(Configuration.APP_ICON));
        alert.setTitle(null);
        alert.setHeaderText("Warning !");
        alert.setContentText(message);
        alert.showAndWait();
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void isSavedMessage(boolean isSave, Stage owner) {
        if (isSave) {
            informationMessage("Action completed successfully !", owner);
        } else {
            errorMessage("An error occurred. Please try again.", owner);
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    public static boolean conformationMessage(String message, Stage owner) {
        boolean b = false;
        alert = new Alert(AlertType.CONFIRMATION);
        dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(Objects.requireNonNull(AlertsUtil.class.getResource(STYLE)).toExternalForm());
        ((Stage) dialogPane.getScene().getWindow()).getIcons().add(new Image(Configuration.APP_ICON));
        alert.initOwner(owner);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle(owner.getTitle());
        alert.setHeaderText("Confirmation !");
        alert.setContentText(message);
        Optional<ButtonType> result = alert.showAndWait();
        // ... user chose OK
        // ... user chose CANCEL or closed the dialog
        b = result.get() == ButtonType.OK;
        return b;
    }
    //------------------------------------------------------------------------------------------------------------------
}
