package com.example.service;

public interface UserService {
    int signUp(IdentityParameters identityParameters);

    void login(IdentityParameters identityParameters) throws UserException;


}
