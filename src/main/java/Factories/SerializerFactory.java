package Factories;

import Helpers.JsonSerializerHelper;
import Serializers.*;
import Serializers.Interfaces.Serializer;

public class SerializerFactory {
    public static Serializer<?> getSerializer(String simpleTypeName) {
        simpleTypeName = simpleTypeName.toUpperCase();

        if (JsonSerializerHelper.isArray(simpleTypeName))
            return getArraySerializer(simpleTypeName);

        return getPrimitiveSerializer(simpleTypeName);
    }

    private static Serializer<?> getArraySerializer(String simpleTypeName) {
        return switch (simpleTypeName) {
            case "INT[]", "INTEGER[]" -> new IntegerArraySerializer();
            case "STRING[]" -> new StringArraySerializer();
            case "DOUBLE[]" -> new DoubleArraySerializer();
            default -> new ObjectArraySerializer();
        };
    }

    private static Serializer<?> getPrimitiveSerializer(String simpleTypeName) {
        return switch (simpleTypeName) {
            case "INTEGER", "INT" -> new IntegerSerializer();
            case "DOUBLE" -> new DoubleSerializer();
            case "STRING" -> new StringSerializer();
            default -> new ObjectSerializer();
        };
    }
}
