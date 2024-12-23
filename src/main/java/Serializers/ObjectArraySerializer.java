package Serializers;

import java.util.Arrays;
import java.util.stream.Stream;

public class ObjectArraySerializer extends AbstractArraySerializer<Object> {
    public ObjectArraySerializer() {
        super(new ObjectSerializer());
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
