package Serializers.Array;

import Serializers.Abstractions.ArraySerializer;
import Serializers.Abstractions.Serializer;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringArraySerializer extends ArraySerializer<String> implements Serializer<String[]> {
    public StringArraySerializer(Serializer<String> stringSerializer) {
        super(stringSerializer);
    }

    @Override
    public String serialize(Object object) {
        Stream<String> stream = Arrays.stream(this.getOriginalTypeValue(object));
        return this.serializeArray(stream);
    }

    @Override
    public String[] getOriginalTypeValue(Object object) {
        return (String[]) object;
    }
}
