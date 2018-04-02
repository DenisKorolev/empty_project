package ru.bellintegrator.practice.common.util;

import ru.bellintegrator.practice.common.exception.EntityDoesNotExistException;
import ru.bellintegrator.practice.common.exception.FieldIsNotDataTypeException;
import ru.bellintegrator.practice.common.exception.FieldIsNotLongException;
import ru.bellintegrator.practice.common.exception.RequiredFieldIsNullException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidationUtils {

    public static boolean isStringBoolean(String str){
        return (str.equals("true")) || (str.equals("false"));
    }

    public static boolean isFieldLong(String field, String fieldName) {

        try {
            Long.parseLong(field);
        }
        catch (NumberFormatException ex){
            throw new FieldIsNotDataTypeException(fieldName, "Long");
        }

        return true;
    }

    public static boolean isStringNullOrEmpty(String str){
        return ((str == null) || (str.isEmpty()));
    }

    public static void checkFieldOnNullAndNotLong(String field, String fieldName){

        //Checks if field is not null
        if (isStringNullOrEmpty(field))
            throw new RequiredFieldIsNullException(fieldName);
        //Checks if filed is Long
        try {
            Long.parseLong(field);
        }
        catch (NumberFormatException ex){
            throw new FieldIsNotDataTypeException(fieldName, "Long");
        }
    }

    public static void checkFieldOnNotFloat(String field, String fieldName){
        try {
            Float.parseFloat(field);
        }
        catch (NumberFormatException ex){
            throw new FieldIsNotDataTypeException(fieldName, "Float");
        }
    }

    public static Date checksFieldOnNotDate(String field, String fieldName){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        Date date;
        try {
            date = dateFormat.parse(field);
        } catch (ParseException ex) {
            throw new FieldIsNotDataTypeException(fieldName, "Date (yyyy-MM-dd)");
        }
        return date;
    }

    public static void checkEntityExists(Object entity, String entityName, String entityId){
        if (entity == null)
            throw new EntityDoesNotExistException(entityName, entityId);
    }
}
