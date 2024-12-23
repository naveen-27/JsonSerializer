package Serializers;

import Serializers.Interfaces.Serializer;
import java.util.Arrays;
import java.util.stream.Stream;

public class StringArraySerializer extends AbstractArraySerializer<String> implements Serializer<String[]> {
    public StringArraySerializer() {
        super(new StringSerializer());
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
