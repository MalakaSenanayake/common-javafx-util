package com.mavora.fx.util;

import javafx.scene.control.PasswordField;

/**
 * @author malaka senanayake
 */
public class FxPasswordFieldUtil {

    private static final String DEFAULT_STYLE ; // normal colour
    private static final String ERROR_STYLE ; // error colour
    //------------------------------------------------------------------------------------------------------------------
    static {
        if (Configuration.getTheme()== Configuration.Theme.LIGHT){
            DEFAULT_STYLE = Configuration.TEXTFIELD_LIGHT_THEME_DEFAULT_STYLE;
            ERROR_STYLE = Configuration.TEXTFIELD_LIGHT_THEME_ERROR_STYLE;
        }else{
            DEFAULT_STYLE =Configuration.TEXTFIELD_DARK_THEME_DEFAULT_STYLE;
            ERROR_STYLE = Configuration.TEXTFIELD_DARK_THEME_ERROR_STYLE;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean checkPassword(PasswordField firstPf, PasswordField secondPf) {
        if (firstPf.getText().length() >= 7) {
            if (firstPf.getText().equals(secondPf.getText())) {
                return true;
            } else {
                FxAlertsUtil.waningMessage("Your password doesn't math to second one");
                return false;
            }
        } else {
            FxAlertsUtil.waningMessage("Your password is too short");
            return false;
        }

    }
    //------------------------------------------------------------------------------------------------------------------

    public static boolean isNotEmpty(PasswordField ar[]) {
        boolean b = true;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].getText().isEmpty()) {
                ar[i].setStyle(ERROR_STYLE);
                FxAlertsUtil.waningMessage("You cannot save data with empty fields , please fill data and retry");
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
