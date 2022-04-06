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
        TableColumn<FileIo, String> tableColumn =  new TableColumn<FileIo, String>("Name");
        // определяем фабрику для столбца с привязкой к свойству name
        // добавляем столбец
        tableColumn.setCellValueFactory(new PropertyValueFactory<FileIo, String>("name"));
        tableTemplate.getColumns().add(tableColumn);
        tableColumn = new TableColumn<>("2");
        tableColumn.setCellValueFactory(new PropertyValueFactory<FileIo, String>("name"));
        tableTemplate.getColumns().add(tableColumn);

        // tableTemplate.getColumns().add(nameColumn);
    }

    @FXML //Обработка кнопки "Сохранить результат"
    protected void onSaveButtonClick() throws IOException {
        resultText.setText(controller.saveResultText());
    }
    @FXML //Обработка кнопки "Загрузить шаблон"
    protected void onTemplateButtonClick() {
        templateText.setText(controller.readTemplate());
    }
    @FXML //Обработка кнопки "Загрузить список"
    protected void onListButtonClick(){
        controller.openCsvFile();
        controller.setListNumber(0);
        listTemplate.setText(controller.readListItem());
        controller.setListNumber(1);
        listItem.setText(controller.readListItem());
    }
    @FXML //Обработка кнопки "Предыдущая запись"
    protected void onPrevButtonClick(){
        controller.setListNumber(controller.getListItemNumber() - 1);
        listItem.setText(controller.readListItem());
        numberLabel.setText("Запись №"+controller.getListItemNumber());
    }
    @FXML //Обработка кнопки "Следующая запись"
    protected void onNextButtonClick(){
        controller.setListNumber(controller.getListItemNumber() + 1);
        listItem.setText(controller.readListItem());
        numberLabel.setText("Запись №"+controller.getListItemNumber());
    }
    @FXML
    protected void onExcelTest(){
        new ExcelDocument().parse("test.xlsx");
    }
}