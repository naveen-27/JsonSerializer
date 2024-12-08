package Serializers;

import Annotations.JsonProperty;
import Helpers.JsonSerializerHelper;
import Helpers.SerializerFactory;
import Serializers.Interfaces.Serializer;
import java.lang.reflect.Field;

public class ObjectSerializer implements Serializer {
    @Override
    public String Serialize(String propertyName, Object value) {
        if (value == null) { return ""; }

        Class<?> objectReflect = value.getClass();
        boolean isSerializable = JsonSerializerHelper.IsObjectSerializable(objectReflect);

        if (!isSerializable) { return ""; }

        StringBuilder serializedObject = new StringBuilder(JsonSerializerHelper.FormatObjectInit(propertyName));
        Field[] fields = value.getClass().getDeclaredFields();

        for (int idx = 0; idx < fields.length; idx++) {
            try {
                String serializedField = SerializeFieldInternal(fields[idx], value);
                if (idx != 0 && !JsonSerializerHelper.IsNullOrEmpty(serializedField)) {
                    serializedObject.append(",");
                }

                serializedObject.append(serializedField);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        serializedObject.append("}");
        return serializedObject.toString();
    }

    private String SerializeFieldInternal(Field field, Object parent) throws IllegalAccessException {
        JsonProperty jsonPropertyAnnotation = JsonSerializerHelper.GetPropertyForField(field);

        if (jsonPropertyAnnotation == null) { return ""; }

        Serializer serializer = SerializerFactory.GetSerializer(field.getType().getSimpleName());
        String propertyName = ExtractPropertyName(jsonPropertyAnnotation, field);
        return serializer.Serialize(propertyName, JsonSerializerHelper.GetUnderlyingFieldValue(field, parent));
    }

    private String ExtractPropertyName(JsonProperty jsonPropertyAnnotation, Field field) {
        String annotatedName = jsonPropertyAnnotation.Name();
        return annotatedName.isEmpty() ? field.getName() : annotatedName;
    }
}
