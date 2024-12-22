package Serializers.Interfaces;

public interface Serializer<T> {
    String Serialize(Object object);
    T GetOriginalTypeValue(Object object);
}
