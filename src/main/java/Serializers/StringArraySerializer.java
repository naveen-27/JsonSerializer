package Serializers;

import Serializers.Interfaces.Serializer;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringArraySerializer extends BaseArraySerializer<String> implements Serializer<String[]> {
    public StringArraySerializer() {
        super(new StringSerializer());
    }

    @Override
    public String Serialize(Object object) {
        Stream<String> stream = Arrays.stream(this.GetOriginalTypeValue(object));
        return this.SerializeArray(stream);
    }

    @Override
    public String[] GetOriginalTypeValue(Object object) {
        return (String[]) object;
    }
}
