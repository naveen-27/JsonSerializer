package Serializers;

import Serializers.Interfaces.Serializer;
import java.util.Arrays;
import java.util.stream.Stream;

public class IntegerArraySerializer extends BaseArraySerializer<Integer> implements Serializer<Integer[]> {
    public IntegerArraySerializer() {
        super(new IntegerSerializer());
    }

    @Override
    public String Serialize(Object object) {
        Stream<Integer> stream = Arrays.stream(this.GetOriginalTypeValue(object));
        return this.SerializeArray(stream);
    }

    @Override
    public Integer[] GetOriginalTypeValue(Object object) {
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
