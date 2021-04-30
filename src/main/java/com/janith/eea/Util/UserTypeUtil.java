package com.janith.eea.Util;

public enum UserTypeUtil {
    ADMIN,STUDENT,LECTURER;

    public static UserTypeUtil fromText(String text){
        switch (text.toUpperCase()){

            case "ADMIN":  return ADMIN;
            case "STUDENT":return STUDENT;
            case "LECTURER":return LECTURER;

            default: throw new IllegalArgumentException("In valid User Type " + text);
        }
    }

}
