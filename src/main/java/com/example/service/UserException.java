package com.example.service;

public class UserException extends Exception {
    public UserException() {
        super();
    }

    public UserException(String msg) {
        super(msg);
    }

    static class UserNotFoundException extends UserException {

        public UserNotFoundException(String msg) {
            super(msg);
        }
    }

    static class InvalidPasswordException extends UserException {

        public InvalidPasswordException(String msg) {
            super(msg);
        }
    }

    static class InvalidParameterException extends UserException {

        public InvalidParameterException(String msg) {
            super(msg);
        }
    }


}
