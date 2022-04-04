package com.contract;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WordDocument {
    private String docText;
    private String docFileName;

    public WordDocument(String docFileName){
        this.docFileName = docFileName;
    }

    public WordDocument(){
        FileIo file = new FileIo();
        FileNameExtensionFilter filter = new FileNameExtensionFilter( "Документ MS Word, docx","docx");
        file.chooseFile(filter);
        this.docFileName = file.getFileName();
    }

    public void setDocText(String docText){
        this.docText = docText;
    }

    public String getDocFromFile(){
        try (XWPFDocument doc = new XWPFDocument(
                 Files.newInputStream(Paths.get(this.docFileName)))) {
            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
            this.docText = xwpfWordExtractor.getText();
            return this.docText;
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    public void setDocFileName(String docFileName){
        this.docFileName = docFileName;
    }

    public String getDocText(){
        return this.docText;
    }

    public String replaceAndWrite(String[] template, String[] target,int fileNumber) throws IOException {
        //System.out.println(docFileName);
        try (XWPFDocument doc = new XWPFDocument(
                Files.newInputStream(Paths.get(this.docFileName)))
        ) {

            List<XWPFParagraph> xwpfParagraphList = doc.getParagraphs();
            //Iterate over paragraph list and check for the replaceable text in each paragraph
            for (XWPFParagraph xwpfParagraph : xwpfParagraphList) {
                for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
                    String docText = xwpfRun.getText(0);

                    //replacement and setting position
                    //System.out.println(template.length+" "+target.length);
                    for (int i = 0; i < target.length; i++) {
                        if(docText!=null) {
                            docText = docText.replace(template[i], target[i]);
                            //System.out.println(docText);
                            xwpfRun.setText(docText, 0);
                        }
                    }
                }
            }
            // save the docs
            try (FileOutputStream out = new FileOutputStream("contract "+fileNumber+".docx")) {
                doc.write(out);
            }
            XWPFWordExtractor xwpfWordExtractor = new XWPFWordExtractor(doc);
            this.docText = xwpfWordExtractor.getText();
            //System.out.println(docText);
            return this.docText;
        }
    }
}





