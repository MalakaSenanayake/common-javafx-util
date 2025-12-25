package com.mavora.fx.util;

import javafx.animation.ScaleTransition;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * @author malaka senanayake @ mavora IT
 */
public class FxButtonOnStartUpUtil {

    static ScaleTransition st;
    //------------------------------------------------------------------------------------------------------------------

    public static void setAnimation(final Button button) {
        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setScale(button);
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setSmallAnimation(final Button button) {
        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setSmallScale(button);
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    private static void setScale(Node home) {
        st = new ScaleTransition(Duration.millis(200), home);
        home.setScaleX(1);
        home.setScaleY(1);
        st.setByX(0.4);
        st.setByY(0.4);
        st.setCycleCount(2);
        st.setAutoReverse(true);
        st.play();
    }
    //------------------------------------------------------------------------------------------------------------------

    private static void setSmallScale(Node home) {
        st = new ScaleTransition(Duration.millis(200), home);
        home.setScaleX(1);
        home.setScaleY(1);
        st.setByX(0.1);
        st.setByY(0.1);
        st.setCycleCount(2);
        st.setAutoReverse(true);
        st.play();
    }
    //------------------------------------------------------------------------------------------------------------------
}
