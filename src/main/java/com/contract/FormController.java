package com.contract;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class FormController implements Initializable {
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
    Controller controller;

    //Инициализация при загрузке формы
    @Override
    public void initialize(URL location, ResourceBundle resources){
        //Создание нового контроллера
        controller = new Controller();
        // столбец для вывода имени
    }

    @FXML //Обработка кнопки "Сохранить результат"
    protected void onSaveButtonClick() throws IOException {
       // resultText.setText(controller.saveResultText());
    }
    @FXML //Обработка кнопки "Загрузить шаблон"
    protected void onTemplateButtonClick() {
        templateText.setText(controller.readTemplate());
    }
    @FXML //Обработка кнопки "Загрузить список"
    protected void onListButtonClick(){
        controller.loadExelFile();
        this.tableLoad();


    }
    @FXML //Обработка кнопки "Предыдущая запись"
    protected void onPrevButtonClick(){
        //controller.setListNumber(controller.getListItemNumber() - 1);
        //listItem.setText(controller.readListItem());
        numberLabel.setText("Запись №"+controller.getListItemNumber());
    }
    @FXML //Обработка кнопки "Следующая запись"
    protected void onNextButtonClick(){
        //controller.setListNumber(controller.getListItemNumber() + 1);
        //listItem.setText(controller.readListItem());
        numberLabel.setText("Запись №"+controller.getListItemNumber());
    }
    @FXML
    protected void onExcelTest(){
        new ExcelDocument().parse();
    }

    private void tableLoad(){
        controller.loadExelHeaders();
        int i = 0;
        TableColumn<FileIo, String> tableColumn;
        while (controller.getDataTemplateCell(i)!=null) {
           tableColumn = new TableColumn<FileIo, String>(controller.getDataTemplateCell(i));
           tableTemplate.getColumns().add(tableColumn);
            i++;
        }
        // определяем фабрику для столбца с привязкой к свойству name
        // добавляем столбец
        //tableColumn.setCellValueFactory(new PropertyValueFactory<FileIo, String>("name"));
        //tableTemplate.getColumns().add(tableColumn);

        //tableColumn = new TableColumn<>("2");
       // tableColumn.setCellValueFactory(new PropertyValueFactory<FileIo, String>("name"));
        //tableTemplate.getColumns().add(tableColumn);

        // tableTemplate.getColumns().add(nameColumn);
    }
}