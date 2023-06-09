package com.pockocmoc.exceptionfinalproject.fileutils;

import java.io.FileWriter;
import java.io.IOException;

public class UserDataFileManager {

    private static final String DELIMITER = " ";

    public static void saveUserDataToFile(String filename, String surname,
            String name, String patronymic, String dateOfBirth,
            int phoneNumber, char gender) {
        try (FileWriter writer = new FileWriter(filename, true)) {
            String userRow = surname + DELIMITER + name + DELIMITER
                    + patronymic + DELIMITER + dateOfBirth + DELIMITER
                    + phoneNumber + DELIMITER + gender + "\n";

            writer.write(userRow);
        } catch (IOException ex) {
            System.err.println("Произошла ошибка при сохранении пользовательских данных в файл:");
        }
    }

}
