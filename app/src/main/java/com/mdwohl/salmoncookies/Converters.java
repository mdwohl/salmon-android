package com.mdwohl.salmoncookies;

import androidx.room.TypeConverter;

public class Converters {
    @TypeConverter
    public static String toString(Store value){
        return value == null? null : value.getLocation();
    }
}
