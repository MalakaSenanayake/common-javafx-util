package org.m.javafx.util;

import javafx.scene.control.Button;

/**
 * @author malaka senanayake @ Creative IT
 */
public class ButtonUtil {
    //------------------------------------------------------------------------------------------------------------------
    private static final String DEFAULT_STYLE ;
    private static final String SELECTED_STYLE ;
    //------------------------------------------------------------------------------------------------------------------
    static {
        if (Theme.getTheme().equals(Configuration.DARK_THEME)){
            DEFAULT_STYLE = "-fx-background-color: rgba(0,0,0,0);";
            SELECTED_STYLE = "-fx-background-color:rgba(41,128,185 ,0.3);";
        }else if (Theme.getTheme().equals(Configuration.LIGHT_THEME)){
            DEFAULT_STYLE = "-fx-background-color:rgba(0,0,0,0);";
            SELECTED_STYLE = "-fx-background-color:rgba(0,0,0,0.4);";
        }else{
            DEFAULT_STYLE = "-fx-background-color:rgba(0,0,0,0);";
            SELECTED_STYLE = "-fx-background-color:rgba(0,0,0,0.4);";
            MessageUtil.themeConfigurationMsg();
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public static void setSelectedBtn(Button[] otherButtons, Button button) {
        for (Button btn : otherButtons) {
            btn.setStyle(DEFAULT_STYLE);
        }
        button.setStyle(SELECTED_STYLE);
    }
    //------------------------------------------------------------------------------------------------------------------
}