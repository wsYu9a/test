package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes2.dex */
public final class Streams {
    private Streams() {
        throw new UnsupportedOperationException();
    }

    public static JsonElement parse(JsonReader jsonReader) throws JsonParseException {
        boolean z10;
        try {
            try {
                jsonReader.peek();
                z10 = false;
            } catch (MalformedJsonException e10) {
                throw new JsonSyntaxException(e10);
            } catch (IOException e11) {
                throw new JsonIOException(e11);
            } catch (NumberFormatException e12) {
                throw new JsonSyntaxException(e12);
            }
        } catch (EOFException e13) {
            e = e13;
            z10 = true;
        }
        try {
            return TypeAdapters.JSON_ELEMENT.read2(jsonReader);
        } catch (EOFException e14) {
            e = e14;
            if (z10) {
                return JsonNull.INSTANCE;
            }
            throw new JsonSyntaxException(e);
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable);
    }

    public static final class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite = new CurrentWrite();

        public static class CurrentWrite implements CharSequence {
            char[] chars;

            @Override // java.lang.CharSequence
            public char charAt(int i10) {
                return this.chars[i10];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i10, int i11) {
                return new String(this.chars, i10, i11 - i10);
            }
        }

        public AppendableWriter(Appendable appendable) {
            this.appendable = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) throws IOException {
            CurrentWrite currentWrite = this.currentWrite;
            currentWrite.chars = cArr;
            this.appendable.append(currentWrite, i10, i11 + i10);
        }

        @Override // java.io.Writer
        public void write(int i10) throws IOException {
            this.appendable.append((char) i10);
        }
    }
}
