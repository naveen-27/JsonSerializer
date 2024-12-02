package Helpers;

import Annotations.JsonProperty;
import Annotations.JsonSerializable;
import Constants.Constants;

import java.lang.reflect.Field;

public final class JsonSerializerHelper {
    public static String FormatProperty(String propertyName) {
        return Constants.QUOTE + propertyName + Constants.QUOTE;
    }

    public static String FormatObjectInit(String propertyName) {
        return IsNullOrEmpty(propertyName)
                ? Constants.Object.OBJECT_OPEN_BRACE
                : propertyName + Constants.Property.ASSIGNMENT_SEPARATOR + Constants.Object.OBJECT_OPEN_BRACE;
    }

    public static boolean IsObjectSerializable(Class<?> reflect) {
        return reflect.getDeclaredAnnotation(JsonSerializable.class) != null;
    }

    public static JsonProperty GetPropertyForField(Field fieldReflect) {
        return fieldReflect.getDeclaredAnnotation(JsonProperty.class);
    }

    public static boolean IsNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static Object GetUnderlyingFieldValue(Field field, Object parent) throws IllegalAccessException {
        return field.get(parent);
    }
}
