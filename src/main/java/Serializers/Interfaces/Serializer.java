package Serializers.Interfaces;

public interface Serializer<T> {
    String Serialize(String propertyName, Object value);
}
