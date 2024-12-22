package Serializers;

import Serializers.Interfaces.Serializer;

public class DoubleSerializer implements Serializer<Double> {
    @Override
    public String Serialize(Object object) {
        return this.GetOriginalTypeValue(object).toString();
    }

    @Override
    public Double GetOriginalTypeValue(Object object) {
        return (Double) object;
    }
}
