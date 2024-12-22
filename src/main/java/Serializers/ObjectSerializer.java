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
        if (object == null)
            return Constants.Object.OPEN_BRACE + Constants.Object.CLOSE_BRACE;

        Class<?> objectReflect = object.getClass();
        boolean isSerializable = JsonSerializerHelper.IsObjectSerializable(objectReflect);

        if (!isSerializable)
            return "";

        return SerializeInternal(object, objectReflect);
    }

    @Override
    public Object GetOriginalTypeValue(Object object) {
        return object;
    }

    private static String SerializeInternal(Object object, Class<?> objectReflect) {
        StringBuilder serializedObjectBuilder = new StringBuilder(Constants.Object.OPEN_BRACE);
        Field[] fields = objectReflect.getDeclaredFields();

        for (Field field : fields) {
            AppendField(serializedObjectBuilder, field, object);
        }

        serializedObjectBuilder.append(Constants.Object.CLOSE_BRACE);
        return serializedObjectBuilder.toString();
    }

    private static String SerializeFieldInternal(Field field, Object parent) {
        String typeName = JsonSerializerHelper.GetTypeFromSimpleName(field.getType().getSimpleName());
        Serializer<?> serializer = SerializerFactory.GetSerializer(typeName);
        Object underlyingValue = JsonSerializerHelper.GetUnderlyingFieldValue(field, parent);

        if (underlyingValue == null) {
            return null;
        }
        return serializer.Serialize(underlyingValue);
    }

    private static void AppendField(StringBuilder serializerBuilder, Field field, Object value) {
        JsonProperty jsonProperty = JsonSerializerHelper.GetPropertyForField(field);
        if (jsonProperty == null)
            return;

        String serializedField = SerializeFieldInternal(field, value);
        if (serializedField == null && jsonProperty.IgnoreIfNull())
            return;

        String propertyName = ExtractPropertyName(jsonProperty, field);
        if (serializerBuilder.charAt(serializerBuilder.length() - 1) != Constants.Object.OPEN_BRACE.charAt(0)) {
            serializerBuilder.append(Constants.Property.DELIMITER);
        }
        serializerBuilder.append(BindPropertyToField(propertyName, serializedField));
    }

    private static String ExtractPropertyName(JsonProperty jsonProperty, Field field) {
        String annotatedName = jsonProperty.Name();
        return annotatedName.isEmpty() ? field.getName() : annotatedName;
    }

    private static String BindPropertyToField(String propertyName, String serializedField) {
        return JsonSerializerHelper.FormatProperty(propertyName) +
               Constants.Property.ASSIGNMENT_SEPARATOR +
               serializedField;
    }
}
