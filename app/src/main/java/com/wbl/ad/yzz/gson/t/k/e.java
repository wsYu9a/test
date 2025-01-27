package com.wbl.ad.yzz.gson.t.k;

import com.wbl.ad.yzz.gson.stream.JsonToken;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.Typography;

/* loaded from: classes5.dex */
public final class e extends com.wbl.ad.yzz.gson.v.a {
    public static final Object u;
    public Object[] q;
    public int r;
    public String[] s;
    public int[] t;

    public static class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) throws IOException {
            throw new AssertionError();
        }
    }

    static {
        new a();
        u = new Object();
    }

    private String k() {
        return " at path " + h();
    }

    public final Object A() {
        return this.q[this.r - 1];
    }

    public final Object B() {
        Object[] objArr = this.q;
        int i2 = this.r - 1;
        this.r = i2;
        Object obj = objArr[i2];
        objArr[i2] = null;
        return obj;
    }

    public void C() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) A()).next();
        a(entry.getValue());
        a(new com.wbl.ad.yzz.gson.n((String) entry.getKey()));
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public void a() throws IOException {
        a(JsonToken.BEGIN_ARRAY);
        a(((com.wbl.ad.yzz.gson.h) A()).iterator());
        this.t[this.r - 1] = 0;
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public void b() throws IOException {
        a(JsonToken.BEGIN_OBJECT);
        a(((com.wbl.ad.yzz.gson.m) A()).h().iterator());
    }

    @Override // com.wbl.ad.yzz.gson.v.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.q = new Object[]{u};
        this.r = 1;
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public void f() throws IOException {
        a(JsonToken.END_ARRAY);
        B();
        B();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public void g() throws IOException {
        a(JsonToken.END_OBJECT);
        B();
        B();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public String h() {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.dollar);
        int i2 = 0;
        while (i2 < this.r) {
            Object[] objArr = this.q;
            if (objArr[i2] instanceof com.wbl.ad.yzz.gson.h) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.t[i2]);
                    sb.append(']');
                }
            } else if (objArr[i2] instanceof com.wbl.ad.yzz.gson.m) {
                i2++;
                if (objArr[i2] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.s;
                    if (strArr[i2] != null) {
                        sb.append(strArr[i2]);
                    }
                }
            }
            i2++;
        }
        return sb.toString();
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public boolean i() throws IOException {
        JsonToken t = t();
        return (t == JsonToken.END_OBJECT || t == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public boolean l() throws IOException {
        a(JsonToken.BOOLEAN);
        boolean h2 = ((com.wbl.ad.yzz.gson.n) B()).h();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return h2;
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public double m() throws IOException {
        JsonToken t = t();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (t != jsonToken && t != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + t + k());
        }
        double j2 = ((com.wbl.ad.yzz.gson.n) A()).j();
        if (!j() && (Double.isNaN(j2) || Double.isInfinite(j2))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + j2);
        }
        B();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return j2;
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public int n() throws IOException {
        JsonToken t = t();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (t != jsonToken && t != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + t + k());
        }
        int k = ((com.wbl.ad.yzz.gson.n) A()).k();
        B();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return k;
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public long o() throws IOException {
        JsonToken t = t();
        JsonToken jsonToken = JsonToken.NUMBER;
        if (t != jsonToken && t != JsonToken.STRING) {
            throw new IllegalStateException("Expected " + jsonToken + " but was " + t + k());
        }
        long l = ((com.wbl.ad.yzz.gson.n) A()).l();
        B();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
        return l;
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public String p() throws IOException {
        a(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) A()).next();
        String str = (String) entry.getKey();
        this.s[this.r - 1] = str;
        a(entry.getValue());
        return str;
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public void q() throws IOException {
        a(JsonToken.NULL);
        B();
        int i2 = this.r;
        if (i2 > 0) {
            int[] iArr = this.t;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public String r() throws IOException {
        JsonToken t = t();
        JsonToken jsonToken = JsonToken.STRING;
        if (t == jsonToken || t == JsonToken.NUMBER) {
            String n = ((com.wbl.ad.yzz.gson.n) B()).n();
            int i2 = this.r;
            if (i2 > 0) {
                int[] iArr = this.t;
                int i3 = i2 - 1;
                iArr[i3] = iArr[i3] + 1;
            }
            return n;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + t + k());
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public JsonToken t() throws IOException {
        if (this.r == 0) {
            return JsonToken.END_DOCUMENT;
        }
        Object A = A();
        if (A instanceof Iterator) {
            boolean z = this.q[this.r - 2] instanceof com.wbl.ad.yzz.gson.m;
            Iterator it = (Iterator) A;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z) {
                return JsonToken.NAME;
            }
            a(it.next());
            return t();
        }
        if (A instanceof com.wbl.ad.yzz.gson.m) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (A instanceof com.wbl.ad.yzz.gson.h) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (!(A instanceof com.wbl.ad.yzz.gson.n)) {
            if (A instanceof com.wbl.ad.yzz.gson.l) {
                return JsonToken.NULL;
            }
            if (A == u) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        com.wbl.ad.yzz.gson.n nVar = (com.wbl.ad.yzz.gson.n) A;
        if (nVar.q()) {
            return JsonToken.STRING;
        }
        if (nVar.o()) {
            return JsonToken.BOOLEAN;
        }
        if (nVar.p()) {
            return JsonToken.NUMBER;
        }
        throw new AssertionError();
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public String toString() {
        return e.class.getSimpleName();
    }

    @Override // com.wbl.ad.yzz.gson.v.a
    public void z() throws IOException {
        if (t() == JsonToken.NAME) {
            p();
            this.s[this.r - 2] = "null";
        } else {
            B();
            int i2 = this.r;
            if (i2 > 0) {
                this.s[i2 - 1] = "null";
            }
        }
        int i3 = this.r;
        if (i3 > 0) {
            int[] iArr = this.t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
        }
    }

    public final void a(JsonToken jsonToken) throws IOException {
        if (t() == jsonToken) {
            return;
        }
        throw new IllegalStateException("Expected " + jsonToken + " but was " + t() + k());
    }

    public final void a(Object obj) {
        int i2 = this.r;
        Object[] objArr = this.q;
        if (i2 == objArr.length) {
            int i3 = i2 * 2;
            Object[] objArr2 = new Object[i3];
            int[] iArr = new int[i3];
            String[] strArr = new String[i3];
            System.arraycopy(objArr, 0, objArr2, 0, i2);
            System.arraycopy(this.t, 0, iArr, 0, this.r);
            System.arraycopy(this.s, 0, strArr, 0, this.r);
            this.q = objArr2;
            this.t = iArr;
            this.s = strArr;
        }
        Object[] objArr3 = this.q;
        int i4 = this.r;
        this.r = i4 + 1;
        objArr3[i4] = obj;
    }
}
