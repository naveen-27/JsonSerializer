package Helpers;

import Serializers.IntegerSerializer;
import Serializers.Interfaces.Serializer;
import Serializers.ObjectSerializer;
import Serializers.StringSerializer;

public class SerializerFactory {
    public static Serializer<?> GetSerializer(String type) {
        return switch (type.toUpperCase()) {
            case "INTEGER", "INT" -> new IntegerSerializer();
            case "STRING" -> new StringSerializer();
            default -> new ObjectSerializer();
        };
    }
}
