package Serializers.Array;

import java.util.Arrays;
import java.util.stream.Stream;
import Serializers.Abstractions.ArraySerializer;
import Serializers.Abstractions.Serializer;

public class ObjectArraySerializer extends ArraySerializer<Object> {
    public ObjectArraySerializer(Serializer<Object> objectSerializer) {
        super(objectSerializer);
    }

    @Override
    public String serialize(Object object) {
        Stream<Object> stream = Arrays.stream(this.getOriginalTypeValue(object));
        return this.serializeArray(stream);
    }

    @Override
    public Object[] getOriginalTypeValue(Object object) {
        return (Object[]) object;
    }
}
