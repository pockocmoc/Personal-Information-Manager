package com.pockocmoc.exceptionfinalproject;

import com.pockocmoc.exceptionfinalproject.data_validator.Validator;
import com.pockocmoc.exceptionfinalproject.fileutils.UserDataFileManager;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String input;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные в формате: Фамилия Имя Отчество Дата_рождения "
                    + "Телефонный_номер Пол");
            input = scanner.nextLine();
        }
        String[] inputData = input.split(" ");
        if (inputData.length != 6) {
            System.err.println("Ошибка: неверное количество данных.");
            return;
        }

        String surname = inputData[0];
        String name = inputData[1];
        String patronymic = inputData[2];
        String dateOfBirth = inputData[3];
        String phoneNumberString = inputData[4];
        String gender = inputData[5];
        char sex = gender.charAt(0);

        Validator validator = new Validator();

        String validatedDateString = validator.dateOfBirthValidator(dateOfBirth);
        if (validatedDateString == null) {
            System.out.println("Ошибка неверный формат даты.");
            return;
        }

        int phoneNum = validator.phoneNumberValidator(phoneNumberString);
        if (phoneNum == 0) {
            System.out.println("Ошибка неверный тип телефонного номера.");
            return;
        }

        switch (sex) {
            case 'm', 'f' -> {
            }
            default -> {
                System.out.println("Ошибка: пол должен быть указан как 'm' или 'f'");
                return;
            }
        }

        String surnameFileName = "data/" + surname + ".csv";

        UserDataFileManager.saveUserDataToFile(surnameFileName, surname, name, patronymic,
                dateOfBirth, phoneNum, sex);

    }

}
