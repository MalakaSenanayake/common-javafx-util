/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavora.fx.util;

/**
 * @author Malaka SENANAYAKE
 */
public class FxMessageUtil {
    //------------------------------------------------------------------------------------------------------------------
    public static String getAccountCreateMsg(String userName, String password) {
        return "- Login credentials -"
                + " User Name - " + userName + " "
                + " Password - " + password + " (Onetime password)";
    }

    //------------------------------------------------------------------------------------------------------------------
    protected static void themeConfigurationMsg() {
        Print.msgGreen("-- To change app icon, Theme, Alert title Use - com.mavora.fx.util.Configuration Class --");
    }
    //------------------------------------------------------------------------------------------------------------------
}
