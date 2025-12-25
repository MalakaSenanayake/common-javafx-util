package com.mavora.fx.util;

import java.text.SimpleDateFormat;

import javafx.scene.control.Label;

/**
 * @author malaka senanayake @ Creative IT
 */
public class FxLableUtil {

    //------------------------------------------------------------------------------------------------------------------
    public static void setDate(Label label) {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d);
        label.setText(date);
    }
    //------------------------------------------------------------------------------------------------------------------
}
