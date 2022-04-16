package com.contract;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class FormController implements Initializable {
    public ObservableList<Data> opData = FXCollections.observableArrayList();
    HashMap<String, Object> properties = new HashMap<>();
    @FXML
    public TextField listItem;
    @FXML
    public TextField listTemplate;
    @FXML
    public Label numberLabel;
    @FXML
    public TableView tableTemplate;
    @FXML
    private TextArea resultText;
    @FXML
    private TextArea templateText;
   //Controller controller;

    private ExcelDocument exelFile;
    private WordDocument doc;
    private ArrayList<String> dataTemplate;
    private ArrayList<String> dataList;
    private int listItemNumber;

    //Инициализация при загрузке формы
    @Override
    public void initialize(URL location, ResourceBundle resources){
        //Создание нового контроллера
       // controller = new Controller();
        // столбец для вывода имени
    }

    @FXML //Обработка кнопки "Сохранить результат"
    protected void onSaveButtonClick() throws IOException {
       // resultText.setText(controller.saveResultText());
    }
    @FXML //Обработка кнопки "Загрузить шаблон"
    protected void onTemplateButtonClick() {
        templateText.setText(this.readTemplate());
    }
    @FXML //Обработка кнопки "Загрузить список"
    protected void onListButtonClick(){
        this.loadExelFile();
        this.tableLoad();
    }


    private void tableLoad(){
        tableTemplate.getColumns().clear();
        this.loadExelData();
        int i = 0;
        TableColumn<Data, String> tableColumn;

        //Add properties
        //for (i = 0; i < this.dataTemplate.size(); i++){
        //properties.put("name", "John Doe");
        //properties.put("age", 25);



        while (this.getDataTemplateCell(i)!=null) {
           tableColumn = new TableColumn<>(this.getDataTemplateCell(i));
           tableTemplate.getColumns().add(tableColumn);
           //tableColumn.setCellValueFactory(new PropertyValueFactory<>(controller.getDataTemplateCell(i)));
           //opData.add(this.getDataTemplate());

           //tableTemplate.getItems().add(0,"hhhhh");

           i++;
        }

        for (i = 1; i < dataTemplate.size(); i++){
           // properties.put(dataTemplate.get(i), exelFile.getRow(i));
            System.out.println(dataTemplate.get(i) + "  " + exelFile.getRow(i).get(i));
        }
        Data person = new Data(properties);
        opData.add(person);
        tableTemplate.setItems(opData);
        System.out.println(this.getDataTemplateCell(1));

        //tableTemplate.getItems().add(0,controller.getDataTemplateCell(1));
        // определяем фабрику для столбца с привязкой к свойству name
        // добавляем столбец
        //tableColumn.setCellValueFactory(new PropertyValueFactory<FileIo, String>("name"));
        //tableTemplate.getColumns().add(tableColumn);
    }


    //из класса Controller
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

    public void loadExelFile(){
        this.exelFile = new ExcelDocument();
        //this.loadExelData();
    }

    public void loadExelData(){
        dataTemplate = exelFile.getHeaderRow();
        //dataList = exelFile.getList();
    }

    public int getListItemNumber(){
        return this.listItemNumber;
    }

    public String getDataTemplateCell(int i) {
        if (i > dataTemplate.size()-1)
            return null;
        else return dataTemplate.get(i);
    }

    public ArrayList getDataTemplate(){
        return this.dataTemplate;
    }
}

