package com.spring.QuoraReactiveApp.Utils;

import org.hibernate.validator.internal.util.actions.LoadClass;

import java.time.LocalDateTime;

public class CursorUtils {
    public static boolean isValidCusor(String cursor){
        if(cursor.length()==0 || cursor.isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
    public static LocalDateTime parseCursor(String cursor){
        return LocalDateTime.parse(cursor);
    }
}
