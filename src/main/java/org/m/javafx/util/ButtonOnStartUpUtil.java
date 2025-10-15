package org.m.javafx.util;

import javafx.animation.ScaleTransition;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * @author malaka senanayake @ Creative IT
 */
public class ButtonOnStartUpUtil {

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

    private static void setScale(Node homme) {
        st = new ScaleTransition(Duration.millis(200), homme);
        homme.setScaleX(1);
        homme.setScaleY(1);
        st.setByX(0.4);
        st.setByY(0.4);
        st.setCycleCount(2);
        st.setAutoReverse(true);
        st.play();
    }
    //------------------------------------------------------------------------------------------------------------------

    private static void setSmallScale(Node homme) {
        st = new ScaleTransition(Duration.millis(200), homme);
        homme.setScaleX(1);
        homme.setScaleY(1);
        st.setByX(0.1);
        st.setByY(0.1);
        st.setCycleCount(2);
        st.setAutoReverse(true);
        st.play();
    }
    //------------------------------------------------------------------------------------------------------------------
}
