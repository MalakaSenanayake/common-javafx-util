/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.m.javafx.util;

import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Region;

/**
 *
 * @author Malaka SENANAYAKE
 */
public class RegionPaneUtil {
    //------------------------------------------------------------------------------------------------------------------
    public static void showRegionPaneAndProgress(Region backRegionPane ,ProgressIndicator loadingProgress){
        backRegionPane.setStyle("-fx-background-color: transparent;-fx-background-color: rgba(0, 0, 0, 0.4);");
        loadingProgress.setVisible(true);
        backRegionPane.setVisible(true);
        AnimationUtil.setFade(backRegionPane);
    }
    //------------------------------------------------------------------------------------------------------------------
    public static void hideRegionPaneAndProgress(Region backRegionPane ,ProgressIndicator loadingProgress){
        loadingProgress.setVisible(false);
        backRegionPane.setVisible(false);
    }
    //------------------------------------------------------------------------------------------------------------------
}
