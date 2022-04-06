package com.contract;

import javafx.scene.control.Cell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class ExcelDocument {



        public void parse(String name) {

            String result = "";
            InputStream in = null;
            XSSFWorkbook wb = null;
            System.out.println(name);
            try {
                in = Files.newInputStream(Paths.get(name));
                wb = new XSSFWorkbook(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //System.out.println(wb);
            System.out.println(wb.getSheet("Лист1").getRow(0).getCell(5));
        }

    }

