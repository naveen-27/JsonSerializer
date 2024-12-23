package Helpers;

import Annotations.JsonProperty;
import Annotations.JsonSerializable;
import Constants.Constants;
import java.lang.reflect.Field;

public final class JsonSerializerHelper {
    public static String formatProperty(String propertyName) {
        return Constants.QUOTE + propertyName + Constants.QUOTE;
    }

    public static boolean isObjectSerializable(Class<?> reflect) {
        return reflect.getDeclaredAnnotation(JsonSerializable.class) != null;
    }

    public static JsonProperty getPropertyForField(Field fieldReflect) {
        return fieldReflect.getDeclaredAnnotation(JsonProperty.class);
    }

    public static Object getUnderlyingFieldValue(Field field, Object parent) {
        try {
            field.setAccessible(true);
            return field.get(parent);
        }
        catch (Exception ex) {
            String errMessage = ex.getMessage();
            System.err.println(errMessage);
            return "";
        }
    }

    public static String wrapWithQuotes(String serializedPrimitiveObject) {
        return Constants.QUOTE + serializedPrimitiveObject + Constants.QUOTE;
    }

    public static boolean isArray(String simpleTypeName) {
        return simpleTypeName.endsWith("[]");
    }
}
