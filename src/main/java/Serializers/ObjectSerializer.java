package Serializers;

import Annotations.JsonProperty;
import Constants.Constants;
import Helpers.JsonSerializerHelper;
import Factories.SerializerFactory;
import Serializers.Interfaces.Serializer;
import java.lang.reflect.Field;

public class ObjectSerializer implements Serializer<Object> {
    @Override
    public String serialize(Object object) {
        if (object == null)
            return Constants.Object.OPEN_BRACE + Constants.Object.CLOSE_BRACE;

        Class<?> objectReflect = object.getClass();
        boolean isSerializable = JsonSerializerHelper.isObjectSerializable(objectReflect);

        if (!isSerializable)
            return "";

        return serializeInternal(object, objectReflect);
    }

    @Override
    public Object getOriginalTypeValue(Object object) {
        return object;
    }

    private static String serializeInternal(Object object, Class<?> objectReflect) {
        StringBuilder serializedObjectBuilder = new StringBuilder(Constants.Object.OPEN_BRACE);
        Field[] fields = objectReflect.getDeclaredFields();

        for (Field field : fields) {
            appendField(serializedObjectBuilder, field, object);
        }

        serializedObjectBuilder.append(Constants.Object.CLOSE_BRACE);
        return serializedObjectBuilder.toString();
    }

    private static String serializeFieldInternal(Field field, Object parent) {
        Serializer<?> serializer = SerializerFactory.getSerializer(field.getType().getSimpleName());
        Object underlyingValue = JsonSerializerHelper.getUnderlyingFieldValue(field, parent);

        if (underlyingValue == null) {
            return null;
        }
        return serializer.serialize(underlyingValue);
    }

    private static void appendField(StringBuilder serializerBuilder, Field field, Object value) {
        JsonProperty jsonProperty = JsonSerializerHelper.getPropertyForField(field);
        if (jsonProperty == null)
            return;

        String serializedField = serializeFieldInternal(field, value);
        if (serializedField == null && jsonProperty.ignoreIfNull())
            return;

        String propertyName = extractPropertyName(jsonProperty, field);
        if (serializerBuilder.charAt(serializerBuilder.length() - 1) != Constants.Object.OPEN_BRACE.charAt(0)) {
            serializerBuilder.append(Constants.Property.DELIMITER);
        }
        serializerBuilder.append(bindPropertyToField(propertyName, serializedField));
    }

    private static String extractPropertyName(JsonProperty jsonProperty, Field field) {
        String annotatedName = jsonProperty.name();
        return annotatedName.isEmpty() ? field.getName() : annotatedName;
    }

    private static String bindPropertyToField(String propertyName, String serializedField) {
        return JsonSerializerHelper.formatProperty(propertyName) +
               Constants.Property.ASSIGNMENT_SEPARATOR +
               serializedField;
    }
}
