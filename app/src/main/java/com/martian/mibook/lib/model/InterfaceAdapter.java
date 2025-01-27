package com.martian.mibook.lib.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.martian.mibook.application.MiConfigSingleton;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class InterfaceAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {
    private JsonElement a(final JsonObject wrapper, final String memberName) {
        JsonElement jsonElement = wrapper.get(memberName);
        if (jsonElement != null) {
            return jsonElement;
        }
        throw new JsonParseException("no '" + memberName + "' member found in json file.");
    }

    private Type b(final JsonElement typeElem) {
        try {
            String asString = typeElem.getAsString();
            if (asString.equals("com.martian.bdshucheng.data.BSBook")) {
                asString = "com.martian.mibook.lib.bdshucheng.data.BSBook";
            }
            return Class.forName(asString);
        } catch (ClassNotFoundException e2) {
            throw new JsonParseException(e2);
        }
    }

    @Override // com.google.gson.JsonDeserializer
    public final T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = (JsonObject) jsonElement;
        return (T) jsonDeserializationContext.deserialize(a(jsonObject, MiConfigSingleton.t0), b(a(jsonObject, "type")));
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(final T object, final Type interfaceType, final JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", object.getClass().getName());
        jsonObject.add(MiConfigSingleton.t0, context.serialize(object));
        return jsonObject;
    }
}
