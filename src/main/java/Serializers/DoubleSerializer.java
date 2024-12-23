package Serializers;

import Serializers.Interfaces.Serializer;

public class DoubleSerializer implements Serializer<Double> {
    @Override
    public String serialize(Object object) {
        return this.getOriginalTypeValue(object).toString();
    }

    @Override
    public Double getOriginalTypeValue(Object object) {
        return (Double) object;
    }
}
