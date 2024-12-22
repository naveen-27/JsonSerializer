package Serializers;

import Serializers.Interfaces.Serializer;
import java.util.Arrays;
import java.util.stream.Stream;

public class ObjectArraySerializer extends BaseArraySerializer<Object> implements Serializer<Object[]> {
    public ObjectArraySerializer() {
        super(new ObjectSerializer());
    }

    @Override
    public String Serialize(Object object) {
        Stream<Object> stream = Arrays.stream(this.GetOriginalTypeValue(object));
        return this.SerializeArray(stream);
    }

    @Override
    public Object[] GetOriginalTypeValue(Object object) {
        return (Object[]) object;
    }
}
