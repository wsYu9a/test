package com.google.gson.internal;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public final class f {

    private static final class b extends Writer {

        /* renamed from: a */
        private final Appendable f8156a;

        /* renamed from: b */
        private final a f8157b;

        static class a implements CharSequence {

            /* renamed from: a */
            char[] f8158a;

            a() {
            }

            @Override // java.lang.CharSequence
            public char charAt(int i2) {
                return this.f8158a[i2];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f8158a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i2, int i3) {
                return new String(this.f8158a, i2, i3 - i2);
            }
        }

        /* synthetic */ b(Appendable appendable, a aVar) {
            this(appendable);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) throws IOException {
            a aVar = this.f8157b;
            aVar.f8158a = cArr;
            this.f8156a.append(aVar, i2, i3 + i2);
        }

        private b(Appendable appendable) {
            this.f8157b = new a();
            this.f8156a = appendable;
        }

        @Override // java.io.Writer
        public void write(int i2) throws IOException {
            this.f8156a.append((char) i2);
        }
    }

    public static JsonElement a(com.google.gson.stream.a aVar) throws JsonParseException {
        boolean z;
        try {
            try {
                aVar.C();
                z = false;
                try {
                    return TypeAdapters.P.read2(aVar);
                } catch (EOFException e2) {
                    e = e2;
                    if (z) {
                        return JsonNull.INSTANCE;
                    }
                    throw new JsonSyntaxException(e);
                }
            } catch (MalformedJsonException e3) {
                throw new JsonSyntaxException(e3);
            } catch (IOException e4) {
                throw new JsonIOException(e4);
            } catch (NumberFormatException e5) {
                throw new JsonSyntaxException(e5);
            }
        } catch (EOFException e6) {
            e = e6;
            z = true;
        }
    }

    public static void b(JsonElement jsonElement, com.google.gson.stream.c cVar) throws IOException {
        TypeAdapters.P.write(cVar, jsonElement);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }
}
