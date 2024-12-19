package com.example.FreeSoulsApi.exeptions;

public class NoRegistersFoundException extends AppException {
    public NoRegistersFoundException(Long id) {
        super("Entity with ID " + id + " not found in data base");
    }
}
