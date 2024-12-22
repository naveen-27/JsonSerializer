package Serializers;

import Serializers.Interfaces.Serializer;
import java.util.Arrays;
import java.util.stream.Stream;

public class DoubleArraySerializer extends BaseArraySerializer<Double> implements Serializer<Double[]> {
    public DoubleArraySerializer() {
        super(new DoubleSerializer());
    }

    @Override
    public String Serialize(Object object) {
        Stream<Double> stream = Arrays.stream(this.GetOriginalTypeValue(object));
        return this.SerializeArray(stream);
    }

    @Override
    public Double[] GetOriginalTypeValue(Object object) {
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
