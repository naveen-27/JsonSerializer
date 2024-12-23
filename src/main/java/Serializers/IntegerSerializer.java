package Serializers;

import Serializers.Interfaces.Serializer;

public class IntegerSerializer implements Serializer<Integer> {
    @Override
    public String serialize(Object object) {
        return this.getOriginalTypeValue(object).toString();
    }

    @Override
    public Integer getOriginalTypeValue(Object object) {
        return (Integer) object;
    }
}
