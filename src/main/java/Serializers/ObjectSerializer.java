package Serializers;

import Annotations.JsonProperty;
import Constants.Constants;
import Helpers.JsonSerializerHelper;
import Helpers.SerializerFactory;
import Serializers.Interfaces.Serializer;

import java.lang.reflect.Field;

public class ObjectSerializer implements Serializer<Object> {
    @Override
    public String Serialize(Object object) {
        if (object == null) { return ""; }

        Class<?> objectReflect = object.getClass();
        boolean isSerializable = JsonSerializerHelper.IsObjectSerializable(objectReflect);

        if (!isSerializable) { return ""; }

        StringBuilder serializedObjectBuffer = new StringBuilder(Constants.Object.OPEN_BRACE);
        Field[] fields = objectReflect.getDeclaredFields();

        for (int fieldIdx = 0; fieldIdx < fields.length; fieldIdx++) {
            Field field = fields[fieldIdx];
            JsonProperty jsonPropertyAnnotation = JsonSerializerHelper.GetPropertyForField(field);

            String serializedField = SerializeFieldInternal(field, jsonPropertyAnnotation, object);
            if (!JsonSerializerHelper.IsNullOrEmpty(serializedField)) {
                String propertyName = ExtractPropertyName(jsonPropertyAnnotation, field);

                if (fieldIdx != 0) {
                    serializedObjectBuffer.append(Constants.Property.DELIMITER);
                }

                serializedObjectBuffer.append(BindPropertyToField(propertyName, serializedField));
            }
        }

        serializedObjectBuffer.append(Constants.Object.CLOSE_BRACE);
        return serializedObjectBuffer.toString();
    }

    @Override
    public Object GetOriginalTypeValue(Object object) {
        return object;
    }

    private String SerializeFieldInternal(Field field, JsonProperty jsonPropertyAnnotation, Object parent) {
        if (jsonPropertyAnnotation == null) { return ""; }

        String typeName = JsonSerializerHelper.GetTypeFromSimpleName(field.getType().getSimpleName());
        Serializer<?> serializer = SerializerFactory.GetSerializer(typeName);
        return serializer.Serialize(JsonSerializerHelper.GetUnderlyingFieldValue(field, parent));
    }

    private static String ExtractPropertyName(JsonProperty jsonPropertyAnnotation, Field field) {
        String annotatedName = jsonPropertyAnnotation.Name();
        return annotatedName.isEmpty() ? field.getName() : annotatedName;
    }

    private static String BindPropertyToField(String propertyName, String serializedField) {
        return JsonSerializerHelper.FormatProperty(propertyName) +
               Constants.Property.ASSIGNMENT_SEPARATOR +
               serializedField;
    }
}
