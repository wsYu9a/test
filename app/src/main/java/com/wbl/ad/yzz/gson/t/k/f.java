package com.wbl.ad.yzz.gson.t.k;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public final class f extends com.wbl.ad.yzz.gson.v.b {
    public static final Writer o = new a();
    public static final com.wbl.ad.yzz.gson.n p = new com.wbl.ad.yzz.gson.n("closed");
    public final List<com.wbl.ad.yzz.gson.k> l;
    public String m;
    public com.wbl.ad.yzz.gson.k n;

    public static class a extends Writer {
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

    public f() {
        super(o);
        this.l = new ArrayList();
        this.n = com.wbl.ad.yzz.gson.l.f32262a;
    }

    public final void a(com.wbl.ad.yzz.gson.k kVar) {
        if (this.m != null) {
            if (!kVar.e() || g()) {
                ((com.wbl.ad.yzz.gson.m) o()).a(this.m, kVar);
            }
            this.m = null;
            return;
        }
        if (this.l.isEmpty()) {
            this.n = kVar;
            return;
        }
        com.wbl.ad.yzz.gson.k o2 = o();
        if (!(o2 instanceof com.wbl.ad.yzz.gson.h)) {
            throw new IllegalStateException();
        }
        ((com.wbl.ad.yzz.gson.h) o2).a(kVar);
    }

    @Override // com.wbl.ad.yzz.gson.v.b
    public com.wbl.ad.yzz.gson.v.b c() throws IOException {
        com.wbl.ad.yzz.gson.h hVar = new com.wbl.ad.yzz.gson.h();
        a(hVar);
        this.l.add(hVar);
        return this;
    }

    @Override // com.wbl.ad.yzz.gson.v.b, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.l.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.l.add(p);
    }

    @Override // com.wbl.ad.yzz.gson.v.b
    public com.wbl.ad.yzz.gson.v.b d() throws IOException {
        com.wbl.ad.yzz.gson.m mVar = new com.wbl.ad.yzz.gson.m();
        a(mVar);
        this.l.add(mVar);
        return this;
    }

    @Override // com.wbl.ad.yzz.gson.v.b
    public com.wbl.ad.yzz.gson.v.b e() throws IOException {
        if (this.l.isEmpty() || this.m != null) {
            throw new IllegalStateException();
        }
        if (!(o() instanceof com.wbl.ad.yzz.gson.h)) {
            throw new IllegalStateException();
        }
        this.l.remove(r0.size() - 1);
        return this;
    }

    @Override // com.wbl.ad.yzz.gson.v.b
    public com.wbl.ad.yzz.gson.v.b f() throws IOException {
        if (this.l.isEmpty() || this.m != null) {
            throw new IllegalStateException();
        }
        if (!(o() instanceof com.wbl.ad.yzz.gson.m)) {
            throw new IllegalStateException();
        }
        this.l.remove(r0.size() - 1);
        return this;
    }

    @Override // com.wbl.ad.yzz.gson.v.b, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.wbl.ad.yzz.gson.v.b
    public com.wbl.ad.yzz.gson.v.b k() throws IOException {
        a(com.wbl.ad.yzz.gson.l.f32262a);
        return this;
    }

    public com.wbl.ad.yzz.gson.k n() {
        if (this.l.isEmpty()) {
            return this.n;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.l);
    }

    public final com.wbl.ad.yzz.gson.k o() {
        return this.l.get(r0.size() - 1);
    }

    @Override // com.wbl.ad.yzz.gson.v.b
    public com.wbl.ad.yzz.gson.v.b d(String str) throws IOException {
        if (str == null) {
            return k();
        }
        a(new com.wbl.ad.yzz.gson.n(str));
        return this;
    }

    @Override // com.wbl.ad.yzz.gson.v.b
    public com.wbl.ad.yzz.gson.v.b d(boolean z) throws IOException {
        a(new com.wbl.ad.yzz.gson.n(Boolean.valueOf(z)));
        return this;
    }

    @Override // com.wbl.ad.yzz.gson.v.b
    public com.wbl.ad.yzz.gson.v.b a(String str) throws IOException {
        if (!this.l.isEmpty() && this.m == null) {
            if (o() instanceof com.wbl.ad.yzz.gson.m) {
                this.m = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // com.wbl.ad.yzz.gson.v.b
    public com.wbl.ad.yzz.gson.v.b a(Boolean bool) throws IOException {
        if (bool == null) {
            return k();
        }
        a(new com.wbl.ad.yzz.gson.n(bool));
        return this;
    }

    @Override // com.wbl.ad.yzz.gson.v.b
    public com.wbl.ad.yzz.gson.v.b a(long j2) throws IOException {
        a(new com.wbl.ad.yzz.gson.n(Long.valueOf(j2)));
        return this;
    }

    @Override // com.wbl.ad.yzz.gson.v.b
    public com.wbl.ad.yzz.gson.v.b a(Number number) throws IOException {
        if (number == null) {
            return k();
        }
        if (!i()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new com.wbl.ad.yzz.gson.n(number));
        return this;
    }
}
