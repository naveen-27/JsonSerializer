package Serializers;

import Helpers.JsonSerializerHelper;
import Serializers.Interfaces.Serializer;

public class StringSerializer implements Serializer<String> {
    @Override
    public String Serialize(Object object) {
        return JsonSerializerHelper.WrapWithQuotes(this.GetOriginalTypeValue(object));
    }

    @Override
    public String GetOriginalTypeValue(Object object) {
        return (String) object;
    }
}
