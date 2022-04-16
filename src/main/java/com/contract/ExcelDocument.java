package com.contract;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ExcelDocument extends FileIo{
    private final String exelFile;
    private ArrayList headerRow = new ArrayList();
    private ArrayList listRow = new ArrayList();
    private ArrayList row = new ArrayList<>();
   // private ArrayList listRow = new ArrayList<>();
    private ArrayList<String> list;

    public ExcelDocument() {
        //FileIo file = new FileIo();
        FileNameExtensionFilter filter = new FileNameExtensionFilter( "Документ MS Exel, xlsx","xlsx");
        this.chooseFile(filter);
        this.exelFile = this.getFileName();
    }

    public ArrayList parse(int row) {
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
            while (wb.getSheet(sheetName).getRow(row).getCell(i) != null){
                    cell = wb.getSheet(sheetName).getRow(row).getCell(i).toString();
                //System.out.println(cell);
                i++;
                this.listRow.add(cell);
            }

            return listRow;
    }

    public ArrayList<String> getHeaderRow() {
        headerRow = this.parse(0);
        //System.out.println(headerRow.get(0));
        return headerRow;
    }

    public ArrayList<String> getRow(Integer row) {
        return this.parse(row);
    }
}

