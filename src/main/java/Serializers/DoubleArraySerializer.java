package Serializers;

import java.util.Arrays;
import java.util.stream.Stream;

public class DoubleArraySerializer extends AbstractArraySerializer<Double> {
    public DoubleArraySerializer() {
        super(new DoubleSerializer());
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
