package Factories;

import Helpers.JsonSerializerHelper;
import Serializers.*;
import Serializers.Array.DoubleArraySerializer;
import Serializers.Array.IntegerArraySerializer;
import Serializers.Array.ObjectArraySerializer;
import Serializers.Array.StringArraySerializer;
import Serializers.Abstractions.Serializer;

public class SerializerFactory {
    public static Serializer<?> getSerializer(String simpleTypeName) {
        String simpleTypeNameUpper = simpleTypeName.toUpperCase();

        if (JsonSerializerHelper.isArray(simpleTypeNameUpper))
            return getArraySerializer(simpleTypeNameUpper);

        return getPrimitiveSerializer(simpleTypeNameUpper);
    }

    private static Serializer<?> getArraySerializer(String simpleTypeName) {
        return switch (simpleTypeName) {
            case "INT[]", "INTEGER[]" -> new IntegerArraySerializer(new IntegerSerializer());
            case "STRING[]" -> new StringArraySerializer(new StringSerializer());
            case "DOUBLE[]" -> new DoubleArraySerializer(new DoubleSerializer());
            default -> new ObjectArraySerializer(new ObjectSerializer());
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
