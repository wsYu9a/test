package com.martian.libcomm.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Date;

/* loaded from: classes.dex */
public class GsonUtils {

    /* loaded from: classes2.dex */
    public static class DateDeserializer implements JsonDeserializer<Date> {
        @Override // com.google.gson.JsonDeserializer
        /* renamed from: a */
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return new Date(json.getAsJsonPrimitive().getAsLong());
        }
    }

    /* loaded from: classes2.dex */
    public static class DateSerializer implements JsonSerializer<Date> {
        @Override // com.google.gson.JsonSerializer
        /* renamed from: a */
        public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive((Number) Long.valueOf(src.getTime()));
        }
    }

    public static Gson a() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
    }

    public static Gson b() {
        return new GsonBuilder().setDateFormat(b.d.b.f.f4408b).create();
    }

    public static Gson c() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateSerializer()).setDateFormat(1);
        gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer()).setDateFormat(1);
        return gsonBuilder.create();
    }
}
