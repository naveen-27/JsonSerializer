package Serializers.Interfaces;

public interface Serializer<T> {
    String serialize(Object object);
    T getOriginalTypeValue(Object object);
}
