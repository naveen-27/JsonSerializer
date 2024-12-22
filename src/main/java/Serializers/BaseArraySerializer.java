package Serializers;

import Constants.Constants;
import Serializers.Interfaces.Serializer;
import java.util.List;
import java.util.stream.Stream;

public abstract class BaseArraySerializer<T> {
    private final Serializer<T> serializer;

    protected BaseArraySerializer(Serializer<T> serializer) {
        this.serializer = serializer;
    }

    protected String SerializeArray(Stream<T> stream) {
        List<String> serializedItems = stream.map(this::SerializeItem).toList();
        String joinedItems = String.join(Constants.Property.DELIMITER, serializedItems);
        return WrapInArray(joinedItems);
    }

    private String SerializeItem(T item) {
        return this.serializer.Serialize(item);
    }

    private static String WrapInArray(String serializedItems) {
        return Constants.Array.OPEN_BRACE +
               serializedItems +
               Constants.Array.CLOSE_BRACE;
    }
}
