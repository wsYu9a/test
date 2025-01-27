package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class b extends com.google.gson.stream.c {
    private static final Writer l = new a();
    private static final JsonPrimitive m = new JsonPrimitive("closed");
    private final List<JsonElement> n;
    private String o;
    private JsonElement p;

    static class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    public b() {
        super(l);
        this.n = new ArrayList();
        this.p = JsonNull.INSTANCE;
    }

    private JsonElement D() {
        return this.n.get(r0.size() - 1);
    }

    private void E(JsonElement jsonElement) {
        if (this.o != null) {
            if (!jsonElement.isJsonNull() || h()) {
                ((JsonObject) D()).add(this.o, jsonElement);
            }
            this.o = null;
            return;
        }
        if (this.n.isEmpty()) {
            this.p = jsonElement;
            return;
        }
        JsonElement D = D();
        if (!(D instanceof JsonArray)) {
            throw new IllegalStateException();
        }
        ((JsonArray) D).add(jsonElement);
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c A(boolean z) throws IOException {
        E(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }

    public JsonElement C() {
        if (this.n.isEmpty()) {
            return this.p;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.n);
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c c() throws IOException {
        JsonArray jsonArray = new JsonArray();
        E(jsonArray);
        this.n.add(jsonArray);
        return this;
    }

    @Override // com.google.gson.stream.c, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.n.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.n.add(m);
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c d() throws IOException {
        JsonObject jsonObject = new JsonObject();
        E(jsonObject);
        this.n.add(jsonObject);
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c f() throws IOException {
        if (this.n.isEmpty() || this.o != null) {
            throw new IllegalStateException();
        }
        if (!(D() instanceof JsonArray)) {
            throw new IllegalStateException();
        }
        this.n.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.c, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c g() throws IOException {
        if (this.n.isEmpty() || this.o != null) {
            throw new IllegalStateException();
        }
        if (!(D() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        this.n.remove(r0.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c k(String str) throws IOException {
        if (this.n.isEmpty() || this.o != null) {
            throw new IllegalStateException();
        }
        if (!(D() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        this.o = str;
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c m() throws IOException {
        E(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c w(double d2) throws IOException {
        if (j() || !(Double.isNaN(d2) || Double.isInfinite(d2))) {
            E(new JsonPrimitive((Number) Double.valueOf(d2)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d2);
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c x(long j2) throws IOException {
        E(new JsonPrimitive((Number) Long.valueOf(j2)));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c y(Number number) throws IOException {
        if (number == null) {
            return m();
        }
        if (!j()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        E(new JsonPrimitive(number));
        return this;
    }

    @Override // com.google.gson.stream.c
    public com.google.gson.stream.c z(String str) throws IOException {
        if (str == null) {
            return m();
        }
        E(new JsonPrimitive(str));
        return this;
    }
}
