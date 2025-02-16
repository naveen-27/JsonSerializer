package Serializers;

import Helpers.JsonSerializerHelper;
import Serializers.Abstractions.Serializer;

public class StringSerializer implements Serializer<String> {
    @Override
    public String serialize(Object object) {
        return JsonSerializerHelper.wrapWithQuotes(this.getOriginalTypeValue(object));
    }

    @Override
    public String getOriginalTypeValue(Object object) {
        return (String) object;
    }
}
