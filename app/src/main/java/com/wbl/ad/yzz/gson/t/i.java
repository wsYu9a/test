package com.wbl.ad.yzz.gson.t;

import com.wbl.ad.yzz.gson.JsonIOException;
import com.wbl.ad.yzz.gson.JsonParseException;
import com.wbl.ad.yzz.gson.JsonSyntaxException;
import com.wbl.ad.yzz.gson.k;
import com.wbl.ad.yzz.gson.l;
import com.wbl.ad.yzz.gson.stream.MalformedJsonException;
import com.wbl.ad.yzz.gson.t.k.n;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes5.dex */
public final class i {
    public static k a(com.wbl.ad.yzz.gson.v.a aVar) throws JsonParseException {
        boolean z;
        try {
            try {
                aVar.t();
                z = false;
                try {
                    return n.X.a(aVar);
                } catch (EOFException e2) {
                    e = e2;
                    if (z) {
                        return l.f32262a;
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

    public static final class a extends Writer {

        /* renamed from: a */
        public final Appendable f32295a;

        /* renamed from: b */
        public final C0725a f32296b = new C0725a();

        /* renamed from: com.wbl.ad.yzz.gson.t.i$a$a */
        public static class C0725a implements CharSequence {

            /* renamed from: a */
            public char[] f32297a;

            @Override // java.lang.CharSequence
            public char charAt(int i2) {
                return this.f32297a[i2];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f32297a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i2, int i3) {
                return new String(this.f32297a, i2, i3 - i2);
            }
        }

        public a(Appendable appendable) {
            this.f32295a = appendable;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) throws IOException {
            C0725a c0725a = this.f32296b;
            c0725a.f32297a = cArr;
            this.f32295a.append(c0725a, i2, i3 + i2);
        }

        @Override // java.io.Writer
        public void write(int i2) throws IOException {
            this.f32295a.append((char) i2);
        }
    }

    public static void a(k kVar, com.wbl.ad.yzz.gson.v.b bVar) throws IOException {
        n.X.a(bVar, kVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }
}
