package com.example.demo.services.dto;

import javax.validation.constraints.Size;
import java.util.Set;

/**
 * @author vzpintor
 * @project demo
 * @date 10/10/17
 */
public class ManagedUser extends UserDTO {

    public static final int PASSWORD_MIN_LENGTH = 4;

    public static final int PASSWORD_MAX_LENGTH = 100;

    @Size(min = PASSWORD_MIN_LENGTH, max = PASSWORD_MAX_LENGTH)
    private String password;

    public ManagedUser() {
    }

    public ManagedUser(Long id, String username, String password, String nombre, String apellidoPaterno, String apellidoMaterno, String email, String tipo, Boolean activo, Set<String> rols) {

        //super(id, username, nombre, apellidoPaterno, apellidoMaterno, email, tipo, activo, rols);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "ManagedUser{" +
                "} " + super.toString();
    }
}
