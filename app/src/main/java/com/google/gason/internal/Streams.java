package com.google.gason.internal;

import com.google.gason.JsonElement;
import com.google.gason.JsonIOException;
import com.google.gason.JsonNull;
import com.google.gason.JsonParseException;
import com.google.gason.JsonSyntaxException;
import com.google.gason.internal.bind.TypeAdapters;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonWriter;
import com.google.gason.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes7.dex */
public final class Streams {

    /* renamed from: com.google.gason.internal.Streams$1 */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class AppendableWriter extends Writer {
        private final Appendable appendable;
        private final CurrentWrite currentWrite;

        static class CurrentWrite implements CharSequence {
            char[] chars;

            CurrentWrite() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i2) {
                return this.chars[i2];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.chars.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i2, int i3) {
                return new String(this.chars, i2, i3 - i2);
            }
        }

        private AppendableWriter(Appendable appendable) {
            this.currentWrite = new CurrentWrite();
            this.appendable = appendable;
        }

        /* synthetic */ AppendableWriter(Appendable appendable, AnonymousClass1 anonymousClass1) {
            this(appendable);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i2) throws IOException {
            this.appendable.append((char) i2);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) throws IOException {
            this.currentWrite.chars = cArr;
            this.appendable.append(this.currentWrite, i2, i3 + i2);
        }
    }

    public static JsonElement parse(JsonReader jsonReader) throws JsonParseException {
        boolean z;
        try {
            try {
                jsonReader.peek();
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            } catch (NumberFormatException e4) {
                throw new JsonSyntaxException(e4);
            }
        } catch (EOFException e5) {
            e = e5;
            z = true;
        }
        try {
            return TypeAdapters.JSON_ELEMENT.read(jsonReader);
        } catch (EOFException e6) {
            e = e6;
            z = false;
            if (z) {
                return JsonNull.INSTANCE;
            }
            throw new JsonIOException(e);
        }
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, (JsonWriter) jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new AppendableWriter(appendable, null);
    }
}
