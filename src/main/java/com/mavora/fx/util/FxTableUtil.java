package com.mavora.fx.util;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * @author malaka senanayake
 */
public class FxTableUtil {
    //------------------------------------------------------------------------------------------------------------------

    public static boolean isTableFilled(TableView tableName) {
        boolean b = false;
        if (tableName.getItems().isEmpty()) {
            b = false;
            FxAlertsUtil.waningMessage(" No data in the table  ");
        } else {
            b = true;
        }
        return b;
    }
    //------------------------------------------------------------------------------------------------------------------

    private static boolean isTableFilledNoMessage(TableView tableName) {
        boolean b = false;
        if (tableName.getItems().isEmpty()) {
            b = false;
        } else {
            b = true;
        }
        return b;
    }
    //------------------------------------------------------------------------------------------------------------------

    public static boolean isRowSelected(TableView tableName) {
        boolean b = false;
        if (tableName.getSelectionModel().isEmpty()) {
            b = false;
            FxAlertsUtil.waningMessage("Select a row in the table");
        } else {
            b = true;
        }
        return b;
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setTableEmpty(TableView tableName, List dataList) {
        if (!dataList.isEmpty()) {
            dataList.clear();
            tableName.getItems().setAll(dataList);
        } else {
            tableName.getItems().setAll(dataList);
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setTableEmpty(TableView tableName) {
        List dataList = new ArrayList();
        tableName.getItems().setAll(dataList);
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setTableFristRowSelect(TableView tableName) {
        if (FxTableUtil.isTableFilledNoMessage(tableName)) {
            tableName.getSelectionModel().selectFirst();
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setTableFristRowSelectAndFocus(TableView tableName) {
        if (FxTableUtil.isTableFilledNoMessage(tableName)) {
            tableName.getSelectionModel().selectFirst();
            tableName.requestFocus();
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setTableFocus(TableView tableName) {
        if (FxTableUtil.isTableFilledNoMessage(tableName)) {
            tableName.requestFocus();
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setTableEmpty(TableView tableName, TextField textField) {
        if (textField.getText().isEmpty()) {
            List dataList = new ArrayList();
            tableName.getItems().setAll(dataList);
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setData(TableView tableName, List dataList) {
        tableName.getItems().setAll(dataList);
    }
    //------------------------------------------------------------------------------------------------------------------

    public static boolean isSelectedRowEmptyNoNotification(TableView tableName) {
        boolean b = false;
        if (tableName.getSelectionModel().isEmpty()) {
            b = false;
        } else {
            b = true;
        }
        return b;
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void deleteTableRow(TableView tableName, List dataList, int index) {
        if (!dataList.isEmpty()) {
            dataList.remove(index);
            tableName.getItems().setAll(dataList);
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void closeWindowDoubleClicked(final TableView tableName) {
        tableName.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().equals(MouseButton.PRIMARY)) {
                    if (event.getClickCount() == 2) {
                        FxFormUtil.closeWindow(tableName);
                    }
                }
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    public static List<Object> getData(TableView table) {
        List<Object> data = new ArrayList();
        for (Object itms : table.getItems()) {
            data.add(itms);
        }
        return data;
    }
    //------------------------------------------------------------------------------------------------------------------
}
