package com.mavora.fx.util;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * @author malaka senanayake @ mavora IT
 */
public class FxAnimationUtil {

    static ScaleTransition st;
    static FadeTransition fadeTransition;
    //------------------------------------------------------------------------------------------------------------------

    public static void setScale(Node home) {
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

    public static void setSmallScale(Node home) {
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
    public static void expand(Node home) {
        st = new ScaleTransition(Duration.millis(200), home);
        home.setScaleX(1);
        home.setScaleY(1);
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

    public static void setFade(Node home) {
        fadeTransition = new FadeTransition(Duration.millis(600), home);
        fadeTransition.setFromValue(-5);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void setFadeInSplashScreen(Node home) {
        fadeTransition = new FadeTransition(Duration.millis(10000), home);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setTranslateRightToLeft(Node home) {
        TranslateTransition transLate = new TranslateTransition(Duration.millis(600), home);
        transLate.setFromX(1200);
        transLate.setToX(0);
        transLate.play();
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setTranslateDownToUp(Node home) {
        TranslateTransition transLate = new TranslateTransition(Duration.millis(600), home);
        transLate.setFromY(1200);
        transLate.setToY(0);
        transLate.play();
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setTranslateLeftToRight(Node home) {
        TranslateTransition transLate = new TranslateTransition(Duration.millis(600), home);
        transLate.setFromX(-1200);
        transLate.setToX(0);
        transLate.play();
    }
    //------------------------------------------------------------------------------------------------------------------
}
