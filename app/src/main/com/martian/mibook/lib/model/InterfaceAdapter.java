package com.martian.mibook.lib.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import h3.e;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class InterfaceAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {
    public final JsonElement a(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement != null) {
            return jsonElement;
        }
        throw new JsonParseException("no '" + str + "' member found in json file.");
    }

    public final Type b(JsonElement jsonElement) {
        try {
            String asString = jsonElement.getAsString();
            if (asString.equals("com.martian.bdshucheng.data.BSBook")) {
                asString = "com.martian.mibook.lib.bdshucheng.data.BSBook";
            }
            return Class.forName(asString);
        } catch (ClassNotFoundException e10) {
            throw new JsonParseException(e10);
        }
    }

    @Override // com.google.gson.JsonDeserializer
    public final T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = (JsonObject) jsonElement;
        return (T) jsonDeserializationContext.deserialize(a(jsonObject, e.f26408m), b(a(jsonObject, "type")));
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(T t10, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", t10.getClass().getName());
        jsonObject.add(e.f26408m, jsonSerializationContext.serialize(t10));
        return jsonObject;
    }
}
