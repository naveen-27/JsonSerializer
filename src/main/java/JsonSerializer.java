import Factories.SerializerFactory;
import Serializers.Abstractions.Serializer;

public final class JsonSerializer {
    public static String Serialize(Object object) {
        Serializer<?> rootSerializer = SerializerFactory.getSerializer(object.getClass().getSimpleName());
        return rootSerializer.serialize(object);
    }
}
