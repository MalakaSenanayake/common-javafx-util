/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.m.javafx.util;

/**
 * @author Malaka SENANAYAKE
 */
public class MessageUtil {
    //------------------------------------------------------------------------------------------------------------------
    public static String getAccountCreateMsg(String userName, String password) {
        return "- OMS Login credentials -"
                + " User Name - " + userName + " "
                + " Password - " + password + " (Onetime password)";
    }

    //------------------------------------------------------------------------------------------------------------------
    protected static void themeConfigurationMsg() {
        System.out.println("[INFO] -------------------------------------------------------------------------------");
        System.out.println("[INFO] Theme is not configured. - DEFAULT_STYLE ");
        System.out.println("[INFO] To LIGHT_THEME theme you can use - Theme.setTheme(ThemeConfig.LIGHT_THEME)");
        System.out.println("[INFO] To DARK_THEME theme you can use - Theme.setTheme(ThemeConfig.DARK_THEME)");
        System.out.println("[INFO] -------------------------------------------------------------------------------");
    }
    //------------------------------------------------------------------------------------------------------------------
}
