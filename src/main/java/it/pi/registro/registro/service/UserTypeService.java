package it.pi.registro.registro.service;

import it.pi.registro.registro.entity.UserType;

import java.util.List;

public interface UserTypeService {
    UserType createUserType(UserType UserType);

    UserType getUserTypeById(Long UserTypeId);

    List<UserType> getAllUserTypes();

    UserType updateUserType(UserType UserType);

    void deleteUserType(Long UserTypeId);
}
