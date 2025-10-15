package org.m.javafx.util;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 * @author Convert to Markdown documentation comment
 *
 */
public class AnchorPaneUtil {

    static FXMLLoader fxmlloder;
    static AnchorPane homeRoot;

    static {
        homeRoot = new AnchorPane();
    }

    //------------------------------------------------------------------------------------------------------------------
    public static AnchorPane setNew(URL fxmlPath) throws Exception {
        try {
            fxmlloder = new FXMLLoader();
            fxmlloder.setLocation(fxmlPath);
            homeRoot = fxmlloder.load();
            AnchorPane.setTopAnchor(homeRoot, 0.0);
            AnchorPane.setBottomAnchor(homeRoot, 0.0);
            AnchorPane.setLeftAnchor(homeRoot, 0.0);
            AnchorPane.setRightAnchor(homeRoot, 0.0);
        } catch (IOException ex) {
            System.out.println("ex - " + ex);
        }
        return homeRoot;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static AnchorPane setNew(URL fxmlPath, Object controller) throws Exception{
        try {
            fxmlloder = new FXMLLoader();
            fxmlloder.setLocation(fxmlPath);
            fxmlloder.setController(controller);
            homeRoot = fxmlloder.load();
            AnchorPane.setTopAnchor(homeRoot, 0.0);
            AnchorPane.setBottomAnchor(homeRoot, 0.0);
            AnchorPane.setLeftAnchor(homeRoot, 0.0);
            AnchorPane.setRightAnchor(homeRoot, 0.0);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        return homeRoot;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void setPageToLodingSpace(URL fxmlPath, AnchorPane pageLoadingSpace) throws Exception{
        try{AnchorPane invoiceMain = AnchorPaneUtil.setNew(fxmlPath);
            AnimationUtil.setFade(invoiceMain);
            pageLoadingSpace.getChildren().clear();
            pageLoadingSpace.getChildren().add(invoiceMain);}catch (Exception exception){
            System.out.println("[ERROR] Exception at AnchorPaneUtill Class "+exception);
        }

    }
    //------------------------------------------------------------------------------------------------------------------
}
