package Serializers;

import Serializers.Interfaces.Serializer;

public class IntegerSerializer implements Serializer<Integer> {
    @Override
    public String Serialize(Object object) {
        return this.GetOriginalTypeValue(object).toString();
    }

    @Override
    public Integer GetOriginalTypeValue(Object object) {
        return (Integer) object;
    }
}
