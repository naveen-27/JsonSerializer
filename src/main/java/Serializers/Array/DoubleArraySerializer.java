package Serializers.Array;

import java.util.Arrays;
import java.util.stream.Stream;
import Serializers.Abstractions.ArraySerializer;
import Serializers.Abstractions.Serializer;

public class DoubleArraySerializer extends ArraySerializer<Double> {
    public DoubleArraySerializer(Serializer<Double> doubleSerializer) {
        super(doubleSerializer);
    }

    @Override
    public String serialize(Object object) {
        Stream<Double> stream = Arrays.stream(this.getOriginalTypeValue(object));
        return this.serializeArray(stream);
    }

    @Override
    public Double[] getOriginalTypeValue(Object object) {
        if (object instanceof double[] unboxedItems) {
            Double[] boxedItems = new Double[unboxedItems.length];
            for (int i = 0; i < unboxedItems.length; i++) {
                boxedItems[i] = unboxedItems[i];
            }

            return boxedItems;
        }

        return (Double[]) object;
    }
}
