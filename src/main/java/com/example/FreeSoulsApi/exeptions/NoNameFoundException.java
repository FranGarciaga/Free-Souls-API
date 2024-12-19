package com.example.FreeSoulsApi.exeptions;

public class NoNameFoundException extends AppException {
    public NoNameFoundException(String name) {
        super("Entity with name " + name + " not found in data base");
    }
}
