/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavora.fx.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

/**
 * @author Malaka SENANAYAKE
 */
public class FxDatePickerUtil {
    //------------------------------------------------------------------------------------------------------------------

    public static void setDate(String date, DatePicker datePicker) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dates = sdf.format(sdf.parse(date
            ));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dates, formatter);
            datePicker.setValue(localDate);
        } catch (Exception ex) {
            Print.error(ex.getMessage());
        }

    }
    //------------------------------------------------------------------------------------------------------------------

    public static boolean isNotEmptyDatePicker(DatePicker datePicker) {
        if (datePicker == null) {
            FxAlertsUtil.waningMessage("Date picker is not initialized");
            return false;
        }

        // Check if value is null (no date selected)
        if (datePicker.getValue() == null) {
            FxAlertsUtil.waningMessage("Please select a date");
            return false;
        }

        // Check if date picker is editable and text field is empty or invalid
        if (datePicker.isEditable()) {
            String text = datePicker.getEditor().getText();
            if (text == null || text.trim().isEmpty()) {
                FxAlertsUtil.waningMessage("Please enter a valid date");
                return false;
            }
        }
        return true;
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void toFormatWithToday(DatePicker datePicker) {
        final String pattern = "yyyy-MM-dd";
        datePicker.setValue(LocalDate.now());
        datePicker.setPromptText(pattern.toLowerCase());
        datePicker.setConverter(new StringConverter<LocalDate>() {
            final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------

    public static void toFormat(DatePicker datePicker) {
        final String pattern = "yyyy-MM-dd";
        datePicker.setPromptText(pattern.toLowerCase());
        datePicker.setConverter(new StringConverter<LocalDate>() {
            final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
    }
    //------------------------------------------------------------------------------------------------------------------
    public static void setDatePlusGivenMonths(DatePicker sourceDatePicker, DatePicker targetDatePicker,int month) {
        if (sourceDatePicker.getValue() == null) {
            targetDatePicker.setValue(null);
            return;
        }
        LocalDate selectedDate = sourceDatePicker.getValue();
        LocalDate calculatedDate = selectedDate.plusMonths(month);
        targetDatePicker.setValue(calculatedDate);
    }
    //------------------------------------------------------------------------------------------------------------------
}
