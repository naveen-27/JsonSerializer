package Helpers;

import Serializers.DoubleSerializer;
import Serializers.IntegerSerializer;
import Serializers.Interfaces.Serializer;
import Serializers.ObjectSerializer;

public final class SerializerFactory {
    public static Serializer<?> GetSerializer(String classType) {
        switch (classType.toUpperCase()) {
            case "DOUBLE":
                return new DoubleSerializer();

            case "INT":
            case "INTEGER":
                return new IntegerSerializer();

            default:
                return new ObjectSerializer();
        }
    }
}
