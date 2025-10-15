package org.m.javafx.util;

import java.text.SimpleDateFormat;

import javafx.scene.control.Label;

/**
 * @author malaka senanayake @ Creative IT
 */
public class LableUtil {

    //------------------------------------------------------------------------------------------------------------------
    public static void setDate(Label lable) {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);
        lable.setText(date);
    }
    //------------------------------------------------------------------------------------------------------------------
}
