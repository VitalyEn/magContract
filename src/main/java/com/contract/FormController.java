package com.contract;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class FormController implements Initializable {
    public ObservableList<Data> opData = FXCollections.observableArrayList();

    @FXML
    public TextField listItem;
    @FXML
    public TextField listTemplate;
    @FXML
    public Label numberLabel;
    @FXML
    public TableView<Data> tableTemplate;
    @FXML
    public TableColumn<Accaunt, Integer> id;
    @FXML
    public TableColumn<Accaunt,String> firstName;
    @FXML
    public TableColumn<Accaunt,String> secondName;
    @FXML
    public TableColumn<Accaunt,String> fathersName;
    @FXML
    public TableColumn<Accaunt,String> birthDate;
    @FXML
    public TableColumn<Accaunt,String> birthPlace;
    @FXML
    public TableColumn<Accaunt,String> flat;
    @FXML
    public TableColumn<Accaunt,String> square;
    @FXML
    public TableColumn<Accaunt,String> sertNumber;
    @FXML
    public TableColumn<Accaunt,String> regDate;
    @FXML
    public TableColumn<Accaunt,String> passportSerie;
    @FXML
    public TableColumn<Accaunt,String> passportNumber;
    @FXML
    public TableColumn<Accaunt,String> passportOutput;
    @FXML
    public TableColumn<Accaunt,String> passportCode;
    @FXML
    public TableColumn<Accaunt,String> regAdress;
    @FXML
    public TableColumn<Accaunt,String> liveAdress;
    @FXML
    public TableColumn<Accaunt,String> phone;
    @FXML
    public TableColumn<Accaunt,String> mail;
    @FXML
    public TableColumn<Accaunt,String> gasService;

    @FXML
    TableColumn<Data, String> tableColumn;
    @FXML
    private TextArea resultText;
    @FXML
    private TextArea templateText;
    //Controller controller;

    private ExcelDocument exelFile;
    private WordDocument doc;
    private ArrayList<String> dataTemplate;
    private ArrayList<String> columnNames;
    private ArrayList<String> dataList;

    //Инициализация при загрузке формы
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
    protected void onListButtonClick() {
        this.tableLoad();
    }
    //Загрузка таблицы
    @FXML
    private void tableLoad() {

        // Очистка таблицы
        tableTemplate.getColumns().clear();
        // Открытие нового докусента Exel (только первый лист!)
        ExcelDocument exel = new ExcelDocument();
        // Чтение строки заголовков
        dataTemplate = exel.readRow(0);
        // Загрузка заголовков в таблицу формы
        for(int i = 0; i < dataTemplate.size(); i++) {
            tableColumn = new TableColumn<Data, String>(dataTemplate.get(i));
            tableTemplate.getColumns().add(tableColumn);
            tableColumn.setCellValueFactory((new PropertyValueFactory<>(dataTemplate.get(i))));
            //tableColumn.setCellValueFactory((new PropertyValueFactory<>("Фамилия")));
            //TableColumn<UserAccount, String> firstNameCol = new TableColumn<UserAccount, String>("First Name");
        }

        // Загрузка строк из файла в объект Data
        int row = 1;
        while (exel.readRow(row) != null){
            HashMap<String, Object> properties = new HashMap<>();
            System.out.println(exel.readRow(row));

            for (int cell = 0; cell < dataTemplate.size(); cell++){
                properties.put(dataTemplate.get(cell),exel.readRow(row).get(cell));
            }
            opData.add(new Data(properties));
            row++;
        }
        tableTemplate.setItems(opData);


            //userNameCol.setCellValueFactory(new PropertyValueFactory<>("userName"));


    }


    //из класса Controller
    public String readTemplate() {
        this.doc = new WordDocument();
        return doc.getDocFromFile();
    }

    public void replace() {
        doc.getDocFromFile();
    }

    public String readSource() {
        doc.getDocFromFile();
        return doc.getDocText();
    }
}

