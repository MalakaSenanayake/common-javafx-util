/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavora.fx.util;

import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Pane;

/**
 *
 * @author Malaka SENANAYAKE
 */
public class FxPaneUtil {
    //------------------------------------------------------------------------------------------------------------------
    public static void centerInPane(Pane parent, ProgressIndicator progressIndicator) {
        progressIndicator.layoutXProperty().bind(
                parent.widthProperty()
                        .subtract(progressIndicator.widthProperty())
                        .divide(2)
        );
        progressIndicator.layoutYProperty().bind(
                parent.heightProperty()
                        .subtract(progressIndicator.heightProperty())
                        .divide(2)
        );
    }
    //------------------------------------------------------------------------------------------------------------------
}
