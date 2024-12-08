package Serializers;

import Constants.Constants;
import Helpers.JsonSerializerHelper;
import Serializers.Interfaces.Serializer;

public class DoubleSerializer implements Serializer {
    @Override
    public String Serialize(String propertyName, Object value) {
        return JsonSerializerHelper.FormatProperty(propertyName) + Constants.Property.ASSIGNMENT_SEPARATOR + value;
    }
}
