package com.contract;

public class Accaunt {
    private int id;
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

    public Accaunt(int id,
                   String firstName,
                   String secondName,
                   String fathersName,
                   String birthDate,
                   String birthPlace,
                   String flat,
                   String square,
                   String sertNumber,
                   String regDate,
                   String passportSerie,
                   String passportNumber,
                   String passportOutput,
                   String passportCode,
                   String regAdress,
                   String liveAdress,
                   String phone,
                   String mail,
                   String gasService) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.fathersName = fathersName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.flat = flat;
        this.square = square;
        this.sertNumber = sertNumber;
        this.regDate = regDate;
        this.passportSerie = passportSerie;
        this.passportNumber = passportNumber;
        this.passportOutput = passportOutput;
        this.passportCode = passportCode;
        this.regAdress = regAdress;
        this.liveAdress = liveAdress;
        this.phone = phone;
        this.mail = mail;
        this.gasService = gasService;
    }
}
