package com.contract;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    //private FileIo exelFile;
    private ExcelDocument exelFile;
    private WordDocument doc;
    private ArrayList<String> dataTemplate;
    private ArrayList<String> dataList;
    private int listItemNumber;

  /*  public Controller(String exelFile, String doc) {
        this.doc = new WordDocument(doc);
        //this.exelFile = new FileIo(exelFile);
        this.exelFile = new ExcelDocument(exelFile);
    }*/

    public Controller(){
    }

    public String readTemplate(){
        this.doc = new WordDocument();
        return doc.getDocFromFile();
    }

    public void replace(){
        doc.getDocFromFile();
    }

    public String readSource(){
        doc.getDocFromFile();
        return doc.getDocText();
    }

   // public String saveResultText() throws IOException {
       // return doc.replaceAndWrite(dataTemplate.split(";"),dataList.split(";"), this.listItemNumber);

        //System.out.println("Сохранить");
    //}

    public void loadExelFile(){
        this.exelFile = new ExcelDocument();
    }

    public void loadExelHeaders(){
        exelFile.parse();
        dataTemplate = exelFile.getHeaderList();
    }

    public int getListItemNumber(){
        return this.listItemNumber;
    }

    public String getDataTemplateCell(int i) {
        return dataTemplate.get(i);
    }
}
