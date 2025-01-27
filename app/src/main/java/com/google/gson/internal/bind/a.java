package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends com.google.gson.stream.a {
    private static final Reader R = new C0110a();
    private static final Object S = new Object();
    private final List<Object> T;

    /* renamed from: com.google.gson.internal.bind.a$a */
    static class C0110a extends Reader {
        C0110a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) throws IOException {
            throw new AssertionError();
        }
    }

    public a(JsonElement jsonElement) {
        super(R);
        ArrayList arrayList = new ArrayList();
        this.T = arrayList;
        arrayList.add(jsonElement);
    }

    private void O(JsonToken jsonToken) throws IOException {
        if (C() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + C());
    }

    private Object P() {
        return this.T.get(r0.size() - 1);
    }

    private Object Q() {
        return this.T.remove(r0.size() - 1);
    }

    @Override // com.google.gson.stream.a
    public String A() throws IOException {
        JsonToken C = C();
        JsonToken jsonToken = JsonToken.STRING;
        if (C == jsonToken || C == JsonToken.NUMBER) {
            return ((JsonPrimitive) Q()).getAsString();
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + C);
    }

    @Override // com.google.gson.stream.a
    public JsonToken C() throws IOException {
        if (this.T.isEmpty()) {
            return JsonToken.END_DOCUMENT;
        }
        Object P = P();
        if (P instanceof Iterator) {
            boolean z = this.T.get(r1.size() - 2) instanceof JsonObject;
            Iterator it = (Iterator) P;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z) {
                return JsonToken.NAME;
            }
            this.T.add(it.next());
            return C();
        }
        if (P instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (P instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (!(P instanceof JsonPrimitive)) {
            if (P instanceof JsonNull) {
                return JsonToken.NULL;
            }
            if (P == S) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) P;
        if (jsonPrimitive.isString()) {
            return JsonToken.STRING;
        }
        if (jsonPrimitive.isBoolean()) {
            return JsonToken.BOOLEAN;
        }
        if (jsonPrimitive.isNumber()) {
            return JsonToken.NUMBER;
        }
        throw new AssertionError();
    }

    @Override // com.google.gson.stream.a
    public void M() throws IOException {
        if (C() == JsonToken.NAME) {
            w();
        } else {
            Q();
        }
    }

    public void R() throws IOException {
        O(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) P()).next();
        this.T.add(entry.getValue());
        this.T.add(new JsonPrimitive((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.T.clear();
        this.T.add(S);
    }

    @Override // com.google.gson.stream.a
    public void f() throws IOException {
        O(JsonToken.BEGIN_ARRAY);
        this.T.add(((JsonArray) P()).iterator());
    }

    @Override // com.google.gson.stream.a
    public void g() throws IOException {
        O(JsonToken.BEGIN_OBJECT);
        this.T.add(((JsonObject) P()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public void k() throws IOException {
        O(JsonToken.END_ARRAY);
        Q();
        Q();
    }

    @Override // com.google.gson.stream.a
    public void l() throws IOException {
        O(JsonToken.END_OBJECT);
        Q();
        Q();
    }

    @Override // com.google.gson.stream.a
    public boolean p() throws IOException {
        JsonToken C = C();
        return (C == JsonToken.END_OBJECT || C == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public boolean s() throws IOException {
        O(JsonToken.BOOLEAN);
        return ((JsonPrimitive) Q()).getAsBoolean();
    }

    @Override // com.google.gson.stream.a
    public double t() throws IOException {
        JsonToken C = C();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (C != jsonToken && C != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + C);
        }
        double asDouble = ((JsonPrimitive) P()).getAsDouble();
        if (q() || !(Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            Q();
            return asDouble;
        }
        throw new NumberFormatException("JSON forbids NaN and infinities: " + asDouble);
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return a.class.getSimpleName();
    }

    @Override // com.google.gson.stream.a
    public int u() throws IOException {
        JsonToken C = C();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (C == jsonToken || C == JsonToken.STRING) {
            int asInt = ((JsonPrimitive) P()).getAsInt();
            Q();
            return asInt;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + C);
    }

    @Override // com.google.gson.stream.a
    public long v() throws IOException {
        JsonToken C = C();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (C == jsonToken || C == JsonToken.STRING) {
            long asLong = ((JsonPrimitive) P()).getAsLong();
            Q();
            return asLong;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + C);
    }

    @Override // com.google.gson.stream.a
    public String w() throws IOException {
        O(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) P()).next();
        this.T.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // com.google.gson.stream.a
    public void y() throws IOException {
        O(JsonToken.NULL);
        Q();
    }
}
