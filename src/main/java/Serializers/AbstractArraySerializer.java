package Serializers;

import Constants.Constants;
import Serializers.Interfaces.Serializer;
import java.util.List;
import java.util.stream.Stream;

public abstract class AbstractArraySerializer<T> implements Serializer<T[]> {
    private final Serializer<T> serializer;

    protected AbstractArraySerializer(Serializer<T> serializer) {
        this.serializer = serializer;
    }

    protected String serializeArray(Stream<T> stream) {
        List<String> serializedItems = stream.map(this::serializeItem).toList();
        String joinedItems = String.join(Constants.Property.DELIMITER, serializedItems);
        return wrapInArray(joinedItems);
    }

    private String serializeItem(T item) {
        return this.serializer.serialize(item);
    }

    private static String wrapInArray(String serializedItems) {
        return Constants.Array.OPEN_BRACE +
               serializedItems +
               Constants.Array.CLOSE_BRACE;
    }
}
