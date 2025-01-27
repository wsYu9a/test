package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
class EnumSerializer implements ObjectSerializer {
    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if ((serializeWriter.features & SerializerFeature.WriteEnumUsingToString.mask) == 0) {
            serializeWriter.writeInt(((Enum) obj).ordinal());
            return;
        }
        String str = ((Enum) obj).toString();
        if ((serializeWriter.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
            serializeWriter.writeStringWithSingleQuote(str);
        } else {
            serializeWriter.writeStringWithDoubleQuote(str, (char) 0, false);
        }
    }
}
