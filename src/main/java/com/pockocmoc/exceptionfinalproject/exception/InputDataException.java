/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pockocmoc.exceptionfinalproject.exception;

/**
 *
 * @author marat
 */
public class InputDataException extends Exception {

    private final int errorCode;

    public InputDataException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return String.format("%d: %s", errorCode, super.getMessage());
    }
}
