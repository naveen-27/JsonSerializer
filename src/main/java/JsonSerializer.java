import Factories.SerializerFactory;
import Serializers.Interfaces.Serializer;

public final class JsonSerializer {
    public static String Serialize(Object object) {
        Serializer<?> rootSerializer = SerializerFactory.GetSerializer(object.getClass().getSimpleName());
        return rootSerializer.Serialize(object);
    }
}
