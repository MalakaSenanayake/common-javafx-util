package com.mavora.fx.util;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 * @author BEST
 */
public class FxComboBoxUtil {
    //------------------------------------------------------------------------------------------------------------------

    public static boolean isSelected(ComboBox combobox) {
        boolean b = true;
        if (combobox.getSelectionModel().isSelected(0)) {
            b = false;
            combobox.requestFocus();
            FxAlertsUtil.waningMessage("Select a value form drop down !");
        } else {
            b = true;
        }
        return b;
    }
    //------------------------------------------------------------------------------------------------------------------

    public static boolean isSelectionNotEmpty(ComboBox combobox) {
        if (combobox.getSelectionModel().isEmpty()) {
            combobox.requestFocus();
            return false;
        } else {
            return true;
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    public static boolean isSelectionNotEmptyWithNotification(ComboBox combobox) {
        if (combobox.getSelectionModel().isEmpty()) {
            combobox.requestFocus();
            FxAlertsUtil.waningMessage("Select a value form drop down !");
            return false;
        } else {
            return true;
        }
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void setValueToComboBox(ComboBox comboBox, List<String> dataList) {
        ObservableList<String> obj = null;
        comboBox.setItems(null);
        obj = FXCollections.observableArrayList(dataList);
        comboBox.setItems(obj);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void setValueToComboBox(ComboBox comboBox, String data) {
        ObservableList<String> obj = null;
        comboBox.setItems(null);
        obj = FXCollections.observableArrayList(data);
        comboBox.setItems(obj);
        comboBox.getSelectionModel().selectFirst();
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isSelectedValueWithNotification(ComboBox combobox) {
        if (combobox.getSelectionModel().isEmpty()) {
            combobox.requestFocus();
            FxAlertsUtil.waningMessage("Select a value form drop down !");
            return false;
        } else {
            return true;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static int splitInt(ComboBox<String> combobox, int element) {
        String selectedItem = combobox.getSelectionModel().getSelectedItem();
        String[] value = selectedItem.split(":");
        String key = value[element].replaceAll(" +", "");
        return Integer.parseInt(key);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String splitString(ComboBox<String> combobox, int element) {
        String selectedItem = combobox.getSelectionModel().getSelectedItem();
        String[] value = selectedItem.split(":");
        return value[element].replaceAll(" +", "");
    }

    //------------------------------------------------------------------------------------------------------------------
    public static double splitDouble(ComboBox<String> combobox, int element) {
        String selectedItem = combobox.getSelectionModel().getSelectedItem();
        String[] value = selectedItem.split(":");
        String key = value[element].replaceAll(" +", "");
        return Double.parseDouble(key);
    }
    //------------------------------------------------------------------------------------------------------------------
}
