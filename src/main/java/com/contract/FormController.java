package com.contract;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FormController implements Initializable {
    @FXML
    public TextField listItem;
    @FXML
    public TextField listTemplate;
    @FXML
    public Label numberLabel;
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
    }

    @FXML //Обработка кнопки "Сохранить результат"
    protected void onSaveButtonClick() throws IOException {
        resultText.setText(controller.saveResultText());
    }
    @FXML //Обработка кнопки "Загрузить шаблон"
    protected void onTemplateButtonClick() throws IOException {
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
}