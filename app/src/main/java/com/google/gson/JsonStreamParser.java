package com.google.gson;

import com.google.gson.internal.f;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.google.gson.stream.a;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class JsonStreamParser implements Iterator<JsonElement> {
    private final Object lock;
    private final a parser;

    public JsonStreamParser(String str) {
        this(new StringReader(str));
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z;
        synchronized (this.lock) {
            try {
                try {
                    try {
                        z = this.parser.C() != JsonToken.END_DOCUMENT;
                    } catch (MalformedJsonException e2) {
                        throw new JsonSyntaxException(e2);
                    }
                } catch (IOException e3) {
                    throw new JsonIOException(e3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public JsonStreamParser(Reader reader) {
        a aVar = new a(reader);
        this.parser = aVar;
        aVar.H(true);
        this.lock = new Object();
    }

    @Override // java.util.Iterator
    public JsonElement next() throws JsonParseException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return f.a(this.parser);
        } catch (JsonParseException e2) {
            if (e2.getCause() instanceof EOFException) {
                throw new NoSuchElementException();
            }
            throw e2;
        } catch (OutOfMemoryError e3) {
            throw new JsonParseException("Failed parsing JSON source to Json", e3);
        } catch (StackOverflowError e4) {
            throw new JsonParseException("Failed parsing JSON source to Json", e4);
        }
    }
}
