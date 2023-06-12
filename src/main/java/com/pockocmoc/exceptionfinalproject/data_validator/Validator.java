package com.pockocmoc.exceptionfinalproject.data_validator;

import com.pockocmoc.exceptionfinalproject.exception.GenderException;
import com.pockocmoc.exceptionfinalproject.exception.InputDataException;
import com.pockocmoc.exceptionfinalproject.exception.InvalidIDateFormatException;
import com.pockocmoc.exceptionfinalproject.exception.InvalidPhoneNumberFormatException;
import com.pockocmoc.exceptionfinalproject.exception.InvalidSurnameException;

public class Validator {

    public String[] checkInputDataLength(String input) throws InputDataException {
        String[] inputData = input.split(" ");
        if (inputData.length != 4) {
            throw new InputDataException(1, "Ошибка: неверное количество данных.");
        } else {
            return inputData;
        }
    }

    public String checkSurnameLength(String surname) throws InvalidSurnameException {
        if (surname.length() < 2 || surname.length() > 50) {
            throw new InvalidSurnameException("Фамилия должна быть не менее 2 символов и не более 50");
        } else {
            return surname;
        }
    }

    public String dateOfBirthValidator(String dateString) throws InvalidIDateFormatException {
        if (!dateString.matches("^\\d{2}\\.\\d{2}\\.\\d{4}$")) {
            throw new InvalidIDateFormatException("Ошибка: неверный формат даты рождения.");
        } else {
            return dateString;
        }
    }

    public int phoneNumberValidator(String phone) throws InvalidPhoneNumberFormatException {
        if (phone.matches("\\d{7,11}")) {
            int phoneNumber = Integer.parseInt(phone);
            return phoneNumber;
        } else {
            throw new InvalidPhoneNumberFormatException("Неправильный номер телефона.");
        }
    }

    public char validateGender(char gender) throws GenderException {
        switch (gender) {
            case 'm', 'f' -> {
            }
            default -> {
                throw new GenderException("Ошибка: пол должен быть указан как 'm' или 'f'");
            }
        }
        return gender;
    }

}
