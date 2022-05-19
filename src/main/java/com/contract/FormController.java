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
import java.util.ResourceBundle;

public class FormController implements Initializable {
    public ObservableList<Accaunt> opData = FXCollections.observableArrayList();
    private Integer id;
    private String firstName;
    private String secondName;
    private String fathersName;
    private String birthDate;
    private String birthPlace;
    private String flat;
    private String square;
    private String sertNumber;
    private String regDate;
    private String passportSerie;
    private String passportNumber;
    private String passportOutput;
    private String passportCode;
    private String regAdress;
    private String liveAdress;
    private String phone;
    private String mail;
    private String gasService;

    @FXML
    public Label numberLabel;
    @FXML
    public TableView<Accaunt> tableTemplate;
    @FXML
    public TableColumn<Accaunt,Integer> tableId;
    @FXML
    public TableColumn<Accaunt,String> tableFirstName;
    @FXML
    public TableColumn<Accaunt,String> tableSecondName;
    @FXML
    public TableColumn<Accaunt,String> tableFathersName;
    @FXML
    public TableColumn<Accaunt,String> tableBirthDate;
    @FXML
    public TableColumn<Accaunt,String> tableBirthPlace;
    @FXML
    public TableColumn<Accaunt,String> tableFlat;
    @FXML
    public TableColumn<Accaunt,String> tableSquare;
    @FXML
    public TableColumn<Accaunt,String> tableSertNumber;
    @FXML
    public TableColumn<Accaunt,String> tableRegDate;
    @FXML
    public TableColumn<Accaunt,String> tablePassportSerie;
    @FXML
    public TableColumn<Accaunt,String> tablePassportNumber;
    @FXML
    public TableColumn<Accaunt,String> tablePassportOutput;
    @FXML
    public TableColumn<Accaunt,String> tablePassportCode;
    @FXML
    public TableColumn<Accaunt,String> tableRegAdress;
    @FXML
    public TableColumn<Accaunt,String> tableLiveAdress;
    @FXML
    public TableColumn<Accaunt,String> tablePhone;
    @FXML
    public TableColumn<Accaunt,String> tableMail;
    @FXML
    public TableColumn<Accaunt,String> tableGasService;

    @FXML
    TableColumn<Accaunt, String> tableColumn;
    @FXML
    private TextArea resultText;
    @FXML
    private TextArea templateText;

    private ExcelDocument exelFile;
    private WordDocument doc;
    private ArrayList<String> dataTemplate;
    private ArrayList<String> columnNames;
    private ArrayList<String> dataList;
    private int rowSize = 18;

    //Инициализация при загрузке формы
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tableSecondName.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        tableFathersName.setCellValueFactory(new PropertyValueFactory<>("fathersName"));
        tableBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        tableBirthPlace.setCellValueFactory(new PropertyValueFactory<>("birthPlace"));
        tableFlat.setCellValueFactory(new PropertyValueFactory<>("flat"));
        tableSquare.setCellValueFactory(new PropertyValueFactory<>("square"));
        tableSertNumber.setCellValueFactory(new PropertyValueFactory<>("sertNumber"));
        tableRegDate.setCellValueFactory(new PropertyValueFactory<>("regDate"));
        tablePassportSerie.setCellValueFactory(new PropertyValueFactory<>("passportSerie"));
        tablePassportNumber.setCellValueFactory(new PropertyValueFactory<>("passportNumber"));
        tablePassportOutput.setCellValueFactory(new PropertyValueFactory<>("passportOutput"));
        tablePassportCode.setCellValueFactory(new PropertyValueFactory<>("passportCode"));
        tableRegAdress.setCellValueFactory(new PropertyValueFactory<>("regAdress"));
        tableLiveAdress.setCellValueFactory(new PropertyValueFactory<>("liveAdress"));
        tablePhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        tableMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        tableGasService.setCellValueFactory(new PropertyValueFactory<>("gasService"));
    }

    @FXML //Обработка кнопки "Сохранить результат"
    protected void onSaveButtonClick() throws IOException {

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
        // Открытие нового докусента Exel (только первый лист!)
        if (tableTemplate.getItems() != null) tableTemplate.getItems().clear();
        ExcelDocument exel = new ExcelDocument();
        int row = 0;
        while (exel.readRow(row, rowSize) != null){
            dataTemplate = exel.readRow(row,rowSize);
            this.id = row;
            this.firstName = dataTemplate.get(0);
            this.secondName = dataTemplate.get(1);
            this.fathersName = dataTemplate.get(2);
            this.birthDate = dataTemplate.get(3);
            this.birthPlace = dataTemplate.get(4);
            this.flat = dataTemplate.get(5);
            this.square = dataTemplate.get(6);
            this.sertNumber = dataTemplate.get(7);
            this.regDate = dataTemplate.get(8);
            this.passportSerie = dataTemplate.get(9);
            this.passportNumber = dataTemplate.get(10);
            this.passportOutput = dataTemplate.get(11);
            this.passportCode = dataTemplate.get(12);
            this.regAdress = dataTemplate.get(13);
            this.liveAdress = dataTemplate.get(14);
            this.phone = dataTemplate.get(15);
            this.mail = dataTemplate.get(16);
            this.gasService = dataTemplate.get(17);

            initData();
            tableTemplate.setItems(opData);
            row++;
        }

    }

    private void initData() {
        opData.add(new Accaunt(id,
                firstName,
                secondName,
                fathersName,
                birthDate,
                birthPlace,
                flat,
                square,
                sertNumber,
                regDate,
                passportSerie,
                passportNumber,
                passportOutput,
                passportCode,
                regAdress,
                liveAdress,
                phone,
                mail,
                gasService));
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

