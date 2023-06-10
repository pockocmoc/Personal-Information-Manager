package com.pockocmoc.exceptionfinalproject;

import com.pockocmoc.exceptionfinalproject.data_validator.Validator;
import com.pockocmoc.exceptionfinalproject.exception.GenderException;
import com.pockocmoc.exceptionfinalproject.exception.InvalidIDateFormatException;
import com.pockocmoc.exceptionfinalproject.exception.InvalidPhoneNumberFormatException;
import com.pockocmoc.exceptionfinalproject.exception.InvalidSurnameException;
import com.pockocmoc.exceptionfinalproject.fileutils.UserDataFileManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InvalidIDateFormatException, 
            InvalidPhoneNumberFormatException, GenderException, InvalidSurnameException {

        String input;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные в формате: Фамилия,Имя,Отчество Дата_рождения "
                    + "Телефонный_номер Пол");
            input = scanner.nextLine();
        }
        String[] inputData = input.split(" ");
        if (inputData.length != 4) {
            System.err.println("Ошибка: неверное количество данных.");
            System.exit(1);
            return;
        }

        String surnameString = inputData[0];
        String dateOfBirthString = inputData[1];
        String phoneNumberString = inputData[2];
        String genderString = inputData[3];
        char gender = genderString.charAt(0);

        Validator validator = new Validator();
        
        String validatedSurname = validator.checkSurnameLength(surnameString);

        String validatedDateString = validator.dateOfBirthValidator(dateOfBirthString);

        int validatedPhoneNum = validator.phoneNumberValidator(phoneNumberString);

        char validatedGender = validator.validateGender(gender);
        
        String firstWordSurname = surnameString.split(",")[0];
        String surnameFileName = "data/" + firstWordSurname + ".csv";

        UserDataFileManager.saveUserDataToFile(surnameFileName, validatedSurname,
                validatedDateString, validatedPhoneNum, validatedGender);

    }

}
