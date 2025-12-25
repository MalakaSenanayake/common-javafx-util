package com.mavora.fx.util;

import javafx.scene.control.Tooltip;
import javafx.scene.text.Font;

/**
 *
 * @author malaka Senanayake
 */
public class FxToolTipUtil {

    static Tooltip tp ;
    //------------------------------------------------------------------------------------------------------------------
    public static  Tooltip setTooltip(String text){
        tp = new Tooltip(text);
        tp.setFont(new Font("Segoe UI", 14));
        return tp ;
    }
    //------------------------------------------------------------------------------------------------------------------
}
