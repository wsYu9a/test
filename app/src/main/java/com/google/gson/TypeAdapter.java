package com.google.gson;

import com.google.gson.internal.bind.b;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.a;
import com.google.gson.stream.c;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* loaded from: classes.dex */
public abstract class TypeAdapter<T> {

    /* renamed from: com.google.gson.TypeAdapter$1 */
    class AnonymousClass1 extends TypeAdapter<T> {
        AnonymousClass1() {
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public T read2(a aVar) throws IOException {
            if (aVar.C() != JsonToken.NULL) {
                return (T) TypeAdapter.this.read2(aVar);
            }
            aVar.y();
            return null;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(c cVar, T t) throws IOException {
            if (t == null) {
                cVar.m();
            } else {
                TypeAdapter.this.write(cVar, t);
            }
        }
    }

    public final T fromJson(Reader reader) throws IOException {
        return read2(new a(reader));
    }

    public final T fromJsonTree(JsonElement jsonElement) {
        try {
            return read2(new com.google.gson.internal.bind.a(jsonElement));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public final TypeAdapter<T> nullSafe() {
        return new TypeAdapter<T>() { // from class: com.google.gson.TypeAdapter.1
            AnonymousClass1() {
            }

            @Override // com.google.gson.TypeAdapter
            /* renamed from: read */
            public T read2(a aVar) throws IOException {
                if (aVar.C() != JsonToken.NULL) {
                    return (T) TypeAdapter.this.read2(aVar);
                }
                aVar.y();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            public void write(c cVar, T t) throws IOException {
                if (t == null) {
                    cVar.m();
                } else {
                    TypeAdapter.this.write(cVar, t);
                }
            }
        };
    }

    /* renamed from: read */
    public abstract T read2(a aVar) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new c(writer), t);
    }

    public final JsonElement toJsonTree(T t) {
        try {
            b bVar = new b();
            write(bVar, t);
            return bVar.C();
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public abstract void write(c cVar, T t) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) throws IOException {
        StringWriter stringWriter = new StringWriter();
        toJson(stringWriter, t);
        return stringWriter.toString();
    }
}
