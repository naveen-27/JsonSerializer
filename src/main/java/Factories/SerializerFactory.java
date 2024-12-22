package Factories;

import Helpers.JsonSerializerHelper;
import Serializers.*;
import Serializers.Interfaces.Serializer;

public class SerializerFactory {
    public static Serializer<?> GetSerializer(String simpleTypeName) {
        simpleTypeName = simpleTypeName.toUpperCase();

        if (JsonSerializerHelper.IsArray(simpleTypeName))
            return GetArraySerializer(simpleTypeName);

        return GetPrimitiveSerializer(simpleTypeName);
    }

    private static Serializer<?> GetArraySerializer(String simpleTypeName) {
        return switch (simpleTypeName) {
            case "INT[]", "INTEGER[]" -> new IntegerArraySerializer();
            case "STRING[]" -> new StringArraySerializer();
            case "DOUBLE[]" -> new DoubleArraySerializer();
            default -> new ObjectArraySerializer();
        };
    }

    private static Serializer<?> GetPrimitiveSerializer(String simpleTypeName) {
        return switch (simpleTypeName) {
            case "INTEGER", "INT" -> new IntegerSerializer();
            case "DOUBLE" -> new DoubleSerializer();
            case "STRING" -> new StringSerializer();
            default -> new ObjectSerializer();
        };
    }
}
