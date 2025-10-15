package org.m.javafx.util;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * @author malaka senanayake @ Creative IT
 */
public class AnimationUtil {

    static ScaleTransition st;
    static FadeTransition fadeTransition;
    //------------------------------------------------------------------------------------------------------------------

    public static void setScale(Node homme) {
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

    public static void setSmallScale(Node homme) {
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
    public static void expan(Node homme) {
        st = new ScaleTransition(Duration.millis(200), homme);
        homme.setScaleX(1);
        homme.setScaleY(1);
        st.setByX(0.4);
        st.setByY(0.4);
        st.setCycleCount(2);
        st.setAutoReverse(false);
        st.play();
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void setAnimation(Button button) {
        button.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                st = new ScaleTransition(Duration.millis(200), button);
                button.setScaleX(1);
                button.setScaleY(1);
                st.setByX(0.4);
                st.setByY(0.4);
                st.setCycleCount(2);
                st.setAutoReverse(true);
                st.play();
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setFade(Node homme) {
        fadeTransition = new FadeTransition(Duration.millis(600), homme);
        fadeTransition.setFromValue(-5);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void setFadeInSplashScreen(Node homme) {
        fadeTransition = new FadeTransition(Duration.millis(10000), homme);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setTranslateRightToleft(Node homme) {
        TranslateTransition transLate = new TranslateTransition(Duration.millis(600), homme);
        transLate.setFromX(1200);
        transLate.setToX(0);
        transLate.play();
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setTranslateDownToUp(Node homme) {
        TranslateTransition transLate = new TranslateTransition(Duration.millis(600), homme);
        transLate.setFromY(1200);
        transLate.setToY(0);
        transLate.play();
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setTranslateLeftToRight(Node homme) {
        TranslateTransition transLate = new TranslateTransition(Duration.millis(600), homme);
        transLate.setFromX(-1200);
        transLate.setToX(0);
        transLate.play();
    }
    //------------------------------------------------------------------------------------------------------------------
}
