/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.m.javafx.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

/**
 * @author Malaka SENANAYAKE
 */
public class DatePickerUtil {
    //------------------------------------------------------------------------------------------------------------------

    public static void setDate(String date, DatePicker datePicker) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String dates = sdf.format(sdf.parse(date
            ));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(dates, formatter);
            datePicker.setValue(localDate);
        } catch (Exception e) {
            System.out.println("exception in Datepicker @ setDate method " + e);
        }

    }
    //------------------------------------------------------------------------------------------------------------------

    public static boolean isNotEmptyDatePicker(DatePicker datePicker) {
        boolean b = true;
        try {
            if (datePicker.getValue().toString().isEmpty()) {
                b = false;
                AlertsUtil.waningMessage("Fill the date");
            } else {
                b = true;
            }

        } catch (Exception e) {
            b = false;
            System.out.println("exception in Datepicker @ isEmptyDatePicker method " + e);
        }
        return b;
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
}
