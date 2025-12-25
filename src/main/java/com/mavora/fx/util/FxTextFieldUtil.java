package com.mavora.fx.util;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

/**
 * @author malaka senanayake @ Creative IT
 */
public class FxTextFieldUtil {
    // Still not configured dark theme
    private static final String DEFAULT_STYLE ; // normal colour
    private static final String ERROR_STYLE ; // error colour
    //------------------------------------------------------------------------------------------------------------------
    static {
        if (Configuration.getTheme()== Configuration.Theme.LIGHT){
           DEFAULT_STYLE = Configuration.TEXTFIELD_LIGHT_THEME_DEFAULT_STYLE;
           ERROR_STYLE = Configuration.TEXTFIELD_LIGHT_THEME_ERROR_STYLE;
        }else{
           DEFAULT_STYLE =Configuration.TEXTFIELD_DARK_THEME_DEFAULT_STYLE;
           ERROR_STYLE = Configuration.TEXTFIELD_DARK_THEME_ERROR_STYLE;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public static void setEmpty(TextField[] ar) {
        for (TextField textField : ar) {
            textField.clear();
            textField.setStyle(DEFAULT_STYLE);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void setEmpty(TextField[] ar, boolean isSaved) {
        if (isSaved) {
            for (TextField textField : ar) {
                textField.clear();
                toDefault(textField);
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isNotEmpty(TextField[] ar) {
        boolean b = true;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].getText().isEmpty()) {
                toError(ar[i]);
                FxAlertsUtil.waningMessage("You cannot save data with empty fields , please fill data and retry");
                toDefault(ar[i]);
                ar[i].requestFocus();
                i = ar.length;
                b = false;
            }
        }
        return b;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isNotEmptyWithoutNotification(TextField[] ar) {
        boolean b = true;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].getText().isEmpty()) {
                toError(ar[i]);
                Print.warning("You cannot save data with empty fields");
                toDefault(ar[i]);
                ar[i].requestFocus();
                i = ar.length;
                b = false;
            }
        }
        return b;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isNotEmpty(TextField textField) {
        boolean b = true;
        if (textField.getText().isEmpty()) {
            toError(textField);
            FxAlertsUtil.waningMessage("You cannot save data with empty fields , please fill data and retry");
            toDefault(textField);
            textField.requestFocus();
            b = false;
        }
        return b;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isNotEmptyWithoutNotification(TextField textField) {
        boolean b = true;
        if (textField.getText().isEmpty()) {
            toError(textField);
            Print.warning("You cannot save data with empty fields");
            toDefault(textField);
            textField.requestFocus();
            b = false;
        }
        return b;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isPhoneNumbersValid(TextField[] ar) {
        boolean b = true;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].getText().length() < 10) {
                toError(ar[i]);
                FxAlertsUtil.waningMessage(" you entered phone number hasn't 10 numbers, " +
                        "please enter valid phone number");
                ar[i].requestFocus();
                i = ar.length;
                b = false;
            }
        }
        return b;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isPhoneNumberValid(TextField textField) {
        boolean b = true;
        if (textField.getText().length() < 10) {
            FxAlertsUtil.waningMessage(" Phone number is not valid , please valid phone number ");
            toError(textField);
            textField.requestFocus();
            b = false;
        }
        return b;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void checkPhoneNumber(TextField textField) {
        if (textField.getText().length() < 10) {
            FxAlertsUtil.waningMessage(" Phone number is not valid , please valid phone number ");
            toError(textField);
            textField.clear();
            textField.requestFocus();
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void checkPhoneNumbers(TextField[] ar) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].getText().length() < 10) {
                toError(ar[i]);
                FxAlertsUtil.waningMessage(" Phone number is not valid , please valid phone number ");
                ar[i].clear();
                ar[i].requestFocus();
                i = ar.length;
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------
//    public static boolean isLargeValue(TextField checkValueTextField) {
//        boolean b = true;
//        if (checkValueTextField.getStyle().equals(ERROR_STYLE)) {
//            b = false;
//            FxAlertsUtil.waningMessage(" You entered value is lager than exist value , " +
//                    "please enter small value or equal value & try again");
//            checkValueTextField.clear();
//            checkValueTextField.requestFocus();
//        }
//        return b;
//    }

    //------------------------------------------------------------------------------------------------------------------
//    public static boolean isSmallValue(TextField checkValueTextField) {
//        boolean b = true;
//        if (checkValueTextField.getStyle().equals(ERROR_STYLE)) {
//            b = false;
//            FxAlertsUtil.waningMessage(" You entered value is smaller than exist value ," +
//                    " please enter large value & & try again");
//            checkValueTextField.clear();
//            checkValueTextField.requestFocus();
//        }
//        return b;
//    }

    //------------------------------------------------------------------------------------------------------------------
    public static void setEditable(TextField[] ar) {
        for (TextField textField : ar) {
            textField.setEditable((textField.getText().equals("0")) | (textField.getText().equals("0.0")) |
                    (textField.getText().equals("0.00")));
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void setFocus(final TextField textField) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                textField.requestFocus();
                System.gc();
            }
        });
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void setNormal(TextField[] ar) {
        for (TextField textField : ar) {
                toDefault(textField);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void setFocusToNext(TextField currentTextField, TextField nextTextField) {
        if (currentTextField.getText().isEmpty()) {
            setFocus(currentTextField);
        } else {
            setFocus(nextTextField);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void copyValue(TextField valueTextField, TextField copyTextField) {
        if (!valueTextField.getText().isEmpty()) {
            copyTextField.clear();
            copyTextField.setText(valueTextField.getText());
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isNotAvailable(TextField textField, boolean availability) {
        if (availability) {
            toError(textField);
            FxAlertsUtil.waningMessage(textField.getText() + "  already exist in system ," +
                    " please enter another value");
            textField.clear();
            textField.setDisable(false);
            setFocus(textField);
            toDefault(textField);
            return false;
        } else {
            toDefault(textField);
            return true;
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void toOnlyPhoneNumber(final TextField textField) {
        textField.setOnKeyTyped(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent evt) {
                FxTextFieldUtil.toDefault(textField);
                if (evt.getCharacter().matches("[0-9]")) {
                    if (textField.getText().length() == 10) {
                        evt.consume();
                    } else {

                    }
                } else {
                    evt.consume();
                }
            }
        });
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void toOnlyIntPositive(final TextField textField) {
        textField.setOnKeyTyped(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent evt) {
                if (evt.getCharacter().matches("[0-9]")) {
                    if (textField.getText().isEmpty()) {
                        if (evt.getCharacter().matches("0")) {
                            evt.consume();
                        }
                    }

                } else {
                    evt.consume();
                }
            }
        });
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void toOnlyInt(TextField textField) {
        textField.setOnKeyTyped(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent evt) {
                if (evt.getCharacter().matches("[0-9]")) {

                } else {
                    evt.consume();
                }
            }
        });
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void toOnlyDecimalPositive(final TextField textField) {
        textField.setOnKeyTyped(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent evt) {
                if (evt.getCharacter().matches("[0-9.]")) {
                    if (textField.getText().isEmpty()) {
                        if (evt.getCharacter().matches("0")) {
                            evt.consume();
                        }
                    }
                    if (evt.getCharacter().matches("[.]")) {
                        int i = textField.getText().indexOf('.');
                        if (i != -1) {
                            evt.consume();
                        } else if (textField.getText().isEmpty()) {
                            evt.consume();
                        }
                    }

                } else {
                    evt.consume();
                }
            }
        });
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void toOnlyDecimal(final TextField textField) {
        textField.setOnKeyTyped(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent evt) {
                if (evt.getCharacter().matches("[0-9.]")) {
                    if (evt.getCharacter().matches("[.]")) {
                        int i = textField.getText().indexOf('.');
                        if (i != -1) {
                            evt.consume();
                        } else if (textField.getText().isEmpty()) {
                            evt.consume();
                        }
                    }

                } else {
                    evt.consume();
                }
            }
        });
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void toOnlyCapitalLetters(TextField textField) {
        textField.setOnKeyTyped(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent evt) {
                if (evt.getCharacter().matches("[A-Z ]")) {

                } else {
                    evt.consume();
                }
            }
        });
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void toOnlySimpleLetters(TextField textField) {
        textField.setOnKeyTyped(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent evt) {
                if (evt.getCharacter().matches("[a-z ]")) {

                } else {
                    evt.consume();
                }
            }
        });
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void toValidate(final TextField textField) {
        textField.setOnKeyTyped(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent evt) {
                FxTextFieldUtil.toDefault(textField);
                if (evt.getCharacter().matches("[0-9.A-Za-z@ #$%&?/,\\+-]")) {

                } else {
                    evt.consume();
                }
            }
        });
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void toNonSpace(final TextField textField) {
        textField.setOnKeyTyped(new EventHandler<javafx.scene.input.KeyEvent>() {
            @Override
            public void handle(javafx.scene.input.KeyEvent evt) {
                FxTextFieldUtil.toDefault(textField);
                if (evt.getCharacter().matches("[0-9.A-Za-z@#$%&?/,+-]")) {

                } else {
                    evt.consume();
                }
            }
        });
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isLargeValueInKeyRelease(TextField textField, double value) {
        boolean b = true;
        FxTextFieldUtil.toDefault(textField);
        if ((!textField.getText().isEmpty())) {
            double enterValue = NumberFormatUtil.toDouble(textField.getText());
            if (value < enterValue) {
                FxTextFieldUtil.toError(textField);
                b = false;
                FxAlertsUtil.waningMessage(" You entered value is lager than  " + NumberFormatUtil.toDouble(value) +
                        "  value , please enter small value or equal value & try again");
                textField.clear();
                textField.requestFocus();
            }
        } else {
            textField.clear();
            FxTextFieldUtil.toError(textField);
            b = false;
        }
        return b;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isSmallValueInKeyRelease(TextField textField, double value) {
        boolean b = true;
        FxTextFieldUtil.toDefault(textField);
        if ((!textField.getText().isEmpty())) {
            double enterValue = NumberFormatUtil.toDouble(textField.getText());
            if (value >= enterValue) {
                FxTextFieldUtil.toError(textField);
                b = false;
            }
        } else {
            textField.clear();
            FxTextFieldUtil.toError(textField);
            b = false;
        }
        return b;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void calculateGoldPrizeInKeyRelease(TextField itemWeightTF, TextField poundValueTF,
                                                      TextField goldPrizeTF) {
        toDefault(itemWeightTF);
        toDefault(poundValueTF);
        toDefault(goldPrizeTF);
        if ((!itemWeightTF.getText().isEmpty()) && (!poundValueTF.getText().isEmpty())) {
            double unitPoundValue = Double.parseDouble(poundValueTF.getText()) / 8;
            double goldValue = Double.parseDouble(itemWeightTF.getText()) * unitPoundValue;
            goldPrizeTF.setText(NumberFormatUtil.toDecimalFormat(goldValue + ""));
        }
        if (poundValueTF.getText().isEmpty()) {
            goldPrizeTF.clear();
            toError(poundValueTF);
        }
        if (itemWeightTF.getText().isEmpty()) {
            toError(itemWeightTF);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String calculateDeferenceInKeyRelease(TextField textField, double value) {
        double deference = 0;
        if ((!textField.getText().isEmpty()) && (value != 0)) {
            double enterValue = NumberFormatUtil.toDouble(textField.getText());
            deference = enterValue - value;
        } else {
            textField.setText("0.0");
        }
        return ("" + deference);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static String calculateSumInKeyRelease(TextField firstValueTF, TextField secondValueTF) {
        double addtion = 0;
        if ((!firstValueTF.getText().isEmpty()) && (!secondValueTF.getText().isEmpty())) {
            addtion = (NumberFormatUtil.toDouble(firstValueTF.getText())) + (NumberFormatUtil.
                    toDouble(secondValueTF.getText()));
        } else {

        }
        return ("" + addtion);
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void typeSameInKeyRelease(TextField textField1, TextField textField2) {
        if (!textField1.getText().isEmpty()) {
            textField2.clear();
            textField2.setText(textField1.getText());
        } else {
            textField2.clear();
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    public static void isAvailabilityInKeyRelease(TextField textField, boolean availability) {
        if (availability) {
            toError(textField);
        } else {
            toDefault(textField);
        }
    }

    // Healping methods-------------------------------------------------------------------------------------------------
    private static void toError(TextField textField) {
        textField.setStyle(ERROR_STYLE);
    }

    //------------------------------------------------------------------------------------------------------------------
    private static void toDefault(TextField textField) {
        textField.setStyle(DEFAULT_STYLE);
    }
    //------------------------------------------------------------------------------------------------------------------

}
