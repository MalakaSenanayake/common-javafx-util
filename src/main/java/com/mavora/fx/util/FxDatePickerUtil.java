package com.mavora.fx.util;

import com.mavora.util.DateTimeUtil;
import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

/**
 * @author Malaka SENANAYAKE
 */
public final class FxDatePickerUtil {

    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final java.time.format.DateTimeFormatter DATE_FORMATTER = DateTimeUtil.LOCAL_DATE;

    private FxDatePickerUtil() {
    }

    public static void configure(DatePicker datePicker) {
        if (datePicker == null) {
            return;
        }
        datePicker.setPromptText(DATE_PATTERN);
        datePicker.setConverter(createConverter());
        datePicker.setEditable(false);
    }

    public static void configureWithToday(DatePicker datePicker) {
        configure(datePicker);
        datePicker.setValue(DateTimeUtil.today());
        datePicker.setEditable(false);
    }

    public static void setToday(DatePicker datePicker) {
        if (datePicker != null) {
            datePicker.setValue(DateTimeUtil.today());
            datePicker.setEditable(false);
        }
    }

    public static void configureAll(DatePicker... datePickers) {
        if (datePickers == null) {
            return;
        }
        for (DatePicker datePicker : datePickers) {
            configure(datePicker);
        }
    }

    public static void configureAllWithToday(DatePicker... datePickers) {
        if (datePickers == null) {
            return;
        }
        for (DatePicker datePicker : datePickers) {
            configureWithToday(datePicker);
        }
    }

    public static void configureAllWithRangeDays(DatePicker fromDatePicker, DatePicker toDatePicker, int daysBack) {
        configureAll(fromDatePicker, toDatePicker);
        applyRangeDays(fromDatePicker, toDatePicker, daysBack);
    }

    public static void configureAllWithRangeMonths(DatePicker fromDatePicker, DatePicker toDatePicker, int monthsBack) {
        configureAll(fromDatePicker, toDatePicker);
        applyRangeMonths(fromDatePicker, toDatePicker, monthsBack);
    }

    private static void applyRangeDays(DatePicker fromDatePicker, DatePicker toDatePicker, int daysBack) {
        if (fromDatePicker == null || toDatePicker == null) {
            return;
        }
        LocalDate today = DateTimeUtil.today();
        fromDatePicker.setValue(DateTimeUtil.todayMinusDays(daysBack));
        toDatePicker.setValue(today);
        fromDatePicker.setEditable(false);
        toDatePicker.setEditable(false);
    }

    private static void applyRangeMonths(DatePicker fromDatePicker, DatePicker toDatePicker, int monthsBack) {
        if (fromDatePicker == null || toDatePicker == null) {
            return;
        }
        LocalDate today = DateTimeUtil.today();
        fromDatePicker.setValue(DateTimeUtil.todayMinusMonths(monthsBack));
        toDatePicker.setValue(today);
        toDatePicker.setEditable(false);
        fromDatePicker.setEditable(false);
    }

    private static StringConverter<LocalDate> createConverter() {
        return new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate date) {
                if (date == null) {
                    return "";
                }
                return DATE_FORMATTER.format(date);
            }

            @Override
            public LocalDate fromString(String value) {
                if (value == null || value.trim().isEmpty()) {
                    return null;
                }
                try {
                    return LocalDate.parse(value.trim(), DATE_FORMATTER);
                } catch (DateTimeParseException ex) {
                    return null;
                }
            }
        };
    }
}
