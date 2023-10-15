package com.example.immoprojectmicroservice.exceptions;

public class UserExistException extends RuntimeException{


        private String message;

        public UserExistException() {}

        public UserExistException(String msg)
        {
            super(msg);
            this.message = msg;
        }
}
