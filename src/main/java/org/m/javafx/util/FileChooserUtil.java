package org.m.javafx.util;

import java.io.File;

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author malaka senanayake @ Creative IT
 */
public class FileChooserUtil {

    //------------------------------------------------------------------------------------------------------------------
    public static String getFolderPath(Stage owner) {
        String path = "";
        try {
            DirectoryChooser dc = new DirectoryChooser();
            dc.setTitle("Select Folder");
            File file = dc.showDialog(owner);
            path = file.getAbsolutePath();
            path = path.replace("\\", "/");
        } catch (Exception e) {
            System.out.println("[Error] exception at FXFileChooser in selectExcelFile method " + e);
        }
        return path;
    }
    //------------------------------------------------------------------------------------------------------------------

    public static File selectExcelFile2007(Stage owner) {
        File selectedFile = null;
        File excelFile = null;
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Excel file");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.xls", "*.xls"));
            selectedFile = fileChooser.showOpenDialog(owner);

            if (selectedFile.getName().endsWith(".xls")) {
                excelFile = selectedFile;
            } else {
                AlertsUtil.waningMessage(" select  excel files only (.xls)",owner);
            }
        } catch (Exception e) {
            System.out.println("[Error] exception at FXFileChooser in selectExcelFile method " + e);
        }
        return excelFile;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static File selectExcelFile2010(Stage owner) {
        File selectedFile = null;
        File excelFile = null;
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Excel file");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.xlsx", "*.xlsx"));
            selectedFile = fileChooser.showOpenDialog(owner);

            if (selectedFile.getName().endsWith(".xlsx")) {
                excelFile = selectedFile;
            } else {
                AlertsUtil.waningMessage(" select  excel files only (.xlsx)",owner);
            }
        } catch (Exception e) {
            System.out.println("[Error] exception at FXFileChooser in selectExcelFile method " + e);
        }
        return excelFile;
    }
    //------------------------------------------------------------------------------------------------------------------

    public static String selectFile(Stage owner) {
        String path = "";
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select file");
            File file = fileChooser.showOpenDialog(owner);
            path = file.getAbsolutePath();
            path = path.replace("\\", "/");
        } catch (Exception e) {
            System.out.println("[Error] exception at FXFileChooser in selectExcelFile method " + e);
        }
        return path;
    }

    //------------------------------------------------------------------------------------------------------------------
    public static boolean isSelectedFile(File selectedFile) {
        if (selectedFile != null) {
            return true;
        } else {
            return false;
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    public static File selectCSVFile(Stage owner) {
        File selectedFile = null;
        File csvFile = null;
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select csv file");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("*.csv", "*.csv"));
            selectedFile = fileChooser.showOpenDialog(owner);

            if (selectedFile.getName().endsWith(".csv")) {
                csvFile = selectedFile;
            } else {
                AlertsUtil.waningMessage("Invalid File Selected! Please select a valid .csv file.",owner);
            }
        } catch (NullPointerException exception){
            System.out.println("Exception null pointer - "+exception);
        } catch (Exception e) {
            System.out.println("[Error] Exception at FXFileChooser in selectCSVFile method " + e);
        }
        return csvFile;
    }
    //------------------------------------------------------------------------------------------------------------------
}
