package com.contract;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;

public class Controller {
    private FileIo csv;
    private WordDocument doc;
    private String dataTemplate;
    private String dataList;
    private int listItemNumber;

    public Controller(String csv, String doc) {
        this.doc = new WordDocument(doc);
        this.csv = new FileIo(csv);
    }

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

    public String saveResultText() throws IOException {
        return doc.replaceAndWrite(dataTemplate.split(";"),dataList.split(";"), this.listItemNumber);

        //System.out.println("Сохранить");
    }

    public String readListItem() {
        dataList = csv.getFileContent(listItemNumber);
        //System.out.println(dataList);
        return dataList;
    }

    public void openCsvFile(){
        this.csv = new FileIo();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Текст с разделителями ';', csv","csv");
        csv.chooseFile(filter);
        csv.readFromFileToList();
        this.dataTemplate = csv.getFileContent(0);
    }

    public int getListItemNumber(){
        return this.listItemNumber;
    }

    public void setListNumber(int i) {
       if (i < 0){i = 0;}
        if(i > csv.getContentSize()-1){
            i = csv.getContentSize()-1;
        }
        this.listItemNumber = i;
    }
}
