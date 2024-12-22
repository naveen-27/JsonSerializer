package Helpers;

import Annotations.JsonProperty;
import Annotations.JsonSerializable;
import Constants.Constants;
import java.lang.reflect.Field;

public final class JsonSerializerHelper {
    public static String FormatProperty(String propertyName) {
        return Constants.QUOTE + propertyName + Constants.QUOTE;
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

    public static Object GetUnderlyingFieldValue(Field field, Object parent) {
        try {
            field.setAccessible(true);
            return field.get(parent);
        }
        catch (Exception ex) {
            System.err.println(ex);
            return "";
        }
    }

    public static String GetTypeFromSimpleName(String simpleTypeName) {
        if (simpleTypeName.endsWith("[]")) {
            return "ARRAY";
        }

        return simpleTypeName;
    }

    public static String WrapWithQuotes(String serializedPrimitiveObject) {
        return Constants.QUOTE + serializedPrimitiveObject + Constants.QUOTE;
    }
}
