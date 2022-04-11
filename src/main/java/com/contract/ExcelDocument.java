package com.contract;

import javafx.scene.control.Cell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ExcelDocument {
    private final String exelFile;
    private ArrayList headerList = new ArrayList();
    private ArrayList row = new ArrayList<>();
    private ArrayList listRow = new ArrayList<>();

    public ExcelDocument() {
        FileIo file = new FileIo();
        FileNameExtensionFilter filter = new FileNameExtensionFilter( "Документ MS Exel, xlsx","xlsx");
        file.chooseFile(filter);
        this.exelFile = file.getFileName();
    }

    public void parse() {
            String result = "";
            InputStream in = null;
            XSSFWorkbook wb = null;
            //System.out.println(name);
            try {
                in = Files.newInputStream(Paths.get(this.exelFile));
                wb = new XSSFWorkbook(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        String sheetName = wb.getSheetName(0);
            int i = 0;
            String cell;
            //String cell = wb.getSheet(sheetName).getRow(0).getCell(i).toString();
           //System.out.println(cell);
            while (wb.getSheet(sheetName).getRow(0).getCell(i) != null){
                    cell = wb.getSheet(sheetName).getRow(0).getCell(i).toString();
                //System.out.println(cell);
                i++;
                this.headerList.add(cell);
            }
    }

    public ArrayList<String> getHeaderList() {
        return headerList;
    }
}

