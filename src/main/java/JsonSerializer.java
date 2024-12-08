import Serializers.ObjectSerializer;

public final class JsonSerializer {
    public static String Serialize(Object object) {
        return new ObjectSerializer().Serialize("", object);
    }
}
