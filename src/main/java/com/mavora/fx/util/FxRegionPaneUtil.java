/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavora.fx.util;

import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Region;

/**
 *
 * @author Malaka SENANAYAKE
 */
public class FxRegionPaneUtil {
    //------------------------------------------------------------------------------------------------------------------
    public static void showRegionPaneAndProgress(Region backRegionPane ,ProgressIndicator loadingProgress){
        backRegionPane.setStyle(Configuration.PANE_STYLE);
        loadingProgress.setVisible(true);
        backRegionPane.setVisible(true);
        FxAnimationUtil.setFade(backRegionPane);
    }
    //------------------------------------------------------------------------------------------------------------------
    public static void hideRegionPaneAndProgress(Region backRegionPane ,ProgressIndicator loadingProgress){
        loadingProgress.setVisible(false);
        backRegionPane.setVisible(false);
    }
    //------------------------------------------------------------------------------------------------------------------
}
