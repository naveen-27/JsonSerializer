package Helpers;

import Serializers.DoubleSerializer;
import Serializers.IntegerSerializer;
import Serializers.Interfaces.Serializer;
import Serializers.ObjectSerializer;
import Serializers.StringSerializer;

public final class SerializerFactory {
    public static Serializer GetSerializer(String classType) {
        switch (classType.toUpperCase()) {
            case "DOUBLE":
                return new DoubleSerializer();

            case "INT":
            case "INTEGER":
                return new IntegerSerializer();

            case "STRING":
                return new StringSerializer();

            default:
                return new ObjectSerializer();
        }
    }
}
