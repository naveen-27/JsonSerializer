package Serializers;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntegerArraySerializer extends AbstractArraySerializer<Integer> {
    public IntegerArraySerializer() {
        super(new IntegerSerializer());
    }

    @Override
    public String serialize(Object object) {
        Stream<Integer> stream = Arrays.stream(this.getOriginalTypeValue(object));
        return this.serializeArray(stream);
    }

    @Override
    public Integer[] getOriginalTypeValue(Object object) {
        if (object instanceof int[] unboxedItems) {
            Integer[] boxedItems = new Integer[unboxedItems.length];
            for (int i = 0; i < unboxedItems.length; i++) {
                boxedItems[i] = unboxedItems[i];
            }

            return boxedItems;
        }

        return (Integer[]) object;
    }
}
