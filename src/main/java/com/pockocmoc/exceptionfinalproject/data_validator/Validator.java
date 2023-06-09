package com.pockocmoc.exceptionfinalproject.data_validator;

public class Validator {


    public String dateOfBirthValidator(String dateString) {
        if (!dateString.matches("^\\d{2}\\.\\d{2}\\.\\d{4}$")) {
            return null;
        } else {
            return dateString;
        }
    }

    public int phoneNumberValidator(String phone) {
        if (phone.matches("\\d{7,11}")) {
            int phoneNumber = Integer.parseInt(phone);
            return phoneNumber;
        } else {
            return 0;
        }

    }

}
