package org.m.javafx.util;

import javafx.scene.control.CheckBox;

/**
 * @author malaka senanayake @ Creative IT
 */
public class CheckboxUtil {
    //------------------------------------------------------------------------------------------------------------------

    public static void setSelection(CheckBox checkbox, String permition) {
        if (permition.equals("0")) {
            checkbox.setSelected(false);
        } else if (permition.equals("1")) {
            checkbox.setSelected(true);
        } else {
            System.out.println("JavaFXMComboBox- set selection problem");
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    public static String getSelection(CheckBox checkbox) {
        String permition = "0";
        if (checkbox.isSelected()) {
            permition = "1";
        } else if (!checkbox.isSelected()) {
            permition = "0";
        }
        return permition;
    }
    //------------------------------------------------------------------------------------------------------------------
}
