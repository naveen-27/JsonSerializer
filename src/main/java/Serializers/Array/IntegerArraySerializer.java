package Serializers.Array;

import java.util.Arrays;
import java.util.stream.Stream;
import Serializers.Abstractions.ArraySerializer;
import Serializers.Abstractions.Serializer;

public class IntegerArraySerializer extends ArraySerializer<Integer> {
    public IntegerArraySerializer(Serializer<Integer> integerSerializer) {
        super(integerSerializer);
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
