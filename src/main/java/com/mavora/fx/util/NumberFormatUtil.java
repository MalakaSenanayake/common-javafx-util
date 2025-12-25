/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mavora.fx.util;

import java.text.DecimalFormat;

/**
 * @author Malaka SENANAYAKE
 */
class NumberFormatUtil {
    //------------------------------------------------------------------------------------------------------------------

     static String toDecimalFormat(String value) {
        if (value == null || value.trim().isEmpty()) {
            return "0.00";
        }
        try {
            String nonCommaValue = value.replace(",", "").replace(" ", "");
            double finalOutput = Double.parseDouble(nonCommaValue);
            DecimalFormat decFor;
            decFor = new DecimalFormat("0.00");
            return decFor.format(finalOutput);
        } catch (NumberFormatException e) {
            return "Invalid Input";
        }
    }
    //------------------------------------------------------------------------------------------------------------------

     static double toDouble(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0.0; // Default safe value
        }
        try {
            String nonCommaValue = value.replace(",", "").replace(" ", "");
            return Double.parseDouble(nonCommaValue);
        } catch (NumberFormatException e) {
            return 0.0; // Handle invalid input safely
        }
    }
    //------------------------------------------------------------------------------------------------------------------

     static String toDouble(double value) {
        DecimalFormat decFor = new DecimalFormat("0.00");
        return decFor.format(value);
    }
    //------------------------------------------------------------------------------------------------------------------

}
