package org.m.javafx.util;

import javafx.scene.control.PasswordField;

/**
 * @author malaka senanayake
 */
public class PasswordFieldUtil {

    private static final String DEFAULT_STYLE = "-border-colour:-border-colour;-text-colour :-text-colour;"; // normal colour
    private static final String ERROR_STYLE = "-border-colour:-error-border-colour;-text-colour :-error-text-colour;"; // error colour

    //------------------------------------------------------------------------------------------------------------------
    public static boolean checkPassword(PasswordField fristPf, PasswordField secondPf) {
        if (fristPf.getText().length() >= 7) {
            if (fristPf.getText().equals(secondPf.getText())) {
                return true;
            } else {
                AlertsUtil.waningMessage("Your password doesn't math to second one");
                return false;
            }
        } else {
            AlertsUtil.waningMessage("Your password is too short");
            return false;
        }

    }
    //------------------------------------------------------------------------------------------------------------------

    public static boolean isNotEmpty(PasswordField ar[]) {
        boolean b = true;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].getText().isEmpty()) {
                ar[i].setStyle(ERROR_STYLE);
                AlertsUtil.waningMessage("You cannot save data with empty fields , please fill data and retry");
                ar[i].requestFocus();
                i = ar.length;
                b = false;
            }

        }
        return b;
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void toRed(PasswordField textField) {
        textField.setStyle(ERROR_STYLE);
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void toNormal(PasswordField textField) {
        textField.setStyle(DEFAULT_STYLE);
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void fristFieldInKeyRelease(PasswordField fristField, PasswordField secondField) {
        toNormal(secondField);
        toNormal(fristField);
        secondField.clear();
        if ((fristField.getText().length()) < 7) {
            toRed(fristField);
        } else if ((fristField.getText().length()) > 7) {
            toNormal(fristField);
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void secondFieldInKeyRelease(PasswordField fristField, PasswordField secondField) {
        toNormal(secondField);
        if ((fristField.getText()).equals(secondField.getText())) {
            toNormal(secondField);
        } else {
            toRed(secondField);
        }
    }
    //------------------------------------------------------------------------------------------------------------------
}
