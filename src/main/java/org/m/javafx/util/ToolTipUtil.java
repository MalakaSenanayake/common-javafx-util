package org.m.javafx.util;

import javafx.scene.control.Tooltip;
import javafx.scene.text.Font;

/**
 *
 * @author malaka Senanayake
 */
public class ToolTipUtil {

    static Tooltip tp ;
    //------------------------------------------------------------------------------------------------------------------
    public static  Tooltip setTooltip(String text){
        tp = new Tooltip(text);
        tp.setFont(new Font("Segoe UI", 14));
        return tp ;
    }
    //------------------------------------------------------------------------------------------------------------------
}
