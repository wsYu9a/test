package com.google.gason.internal.bind;

import com.google.gason.JsonElement;
import com.google.gason.JsonIOException;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: classes7.dex */
public abstract class TypeAdapter<T> {

    public interface Factory {
        <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken);
    }

    public final T fromJson(String str) throws IOException {
        return read(new StringReader(str));
    }

    public T fromJsonElement(JsonElement jsonElement) {
        try {
            JsonElementReader jsonElementReader = new JsonElementReader(jsonElement);
            jsonElementReader.setLenient(true);
            return read(jsonElementReader);
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public abstract T read(JsonReader jsonReader) throws IOException;

    public final T read(Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        jsonReader.setLenient(true);
        return read(jsonReader);
    }

    public final String toJson(T t) throws IOException {
        StringWriter stringWriter = new StringWriter();
        write((Writer) stringWriter, (StringWriter) t);
        return stringWriter.toString();
    }

    public JsonElement toJsonElement(T t) {
        try {
            JsonElementWriter jsonElementWriter = new JsonElementWriter();
            jsonElementWriter.setLenient(true);
            write((JsonWriter) jsonElementWriter, (JsonElementWriter) t);
            return jsonElementWriter.get();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public abstract void write(JsonWriter jsonWriter, T t) throws IOException;

    public final void write(Writer writer, T t) throws IOException {
        write(new JsonWriter(writer), (JsonWriter) t);
    }
}
