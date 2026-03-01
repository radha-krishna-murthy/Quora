package com.spring.QuoraReactiveApp.Utils;

// import org.hibernate.validator.internal.util.actions.LoadClass;

import java.time.LocalDateTime;

public class CursorUtils {
    public static boolean isValidCursor(String cursor) {
        return cursor != null && !cursor.isEmpty();
    }
    public static LocalDateTime parseCursor(String cursor){
        return LocalDateTime.parse(cursor);
    }
}
