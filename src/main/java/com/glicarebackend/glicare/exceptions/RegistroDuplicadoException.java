package com.glicarebackend.glicare.exceptions;

public class RegistroDuplicadoException  extends RuntimeException{

    public RegistroDuplicadoException() {
        super("Esse usuário ja existe no banco de dados");
    }
}
