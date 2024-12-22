package Helpers;

import Serializers.*;
import Serializers.Interfaces.Serializer;

public class SerializerFactory {
    public static Serializer<?> GetSerializer(String type) {
        return switch (type.toUpperCase()) {
            case "INTEGER", "INT" -> new IntegerSerializer();
            case "STRING" -> new StringSerializer();
            case "INT[]", "INTEGER[]" -> new IntegerArraySerializer();
            case "STRING[]" -> new StringArraySerializer();
            default -> new ObjectSerializer();
        };
    }
}
