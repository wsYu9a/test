package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes.dex */
public class c implements Closeable, Flushable {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f8182a = new String[128];

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f8183b;

    /* renamed from: c, reason: collision with root package name */
    private final Writer f8184c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f8185d = new int[32];

    /* renamed from: e, reason: collision with root package name */
    private int f8186e = 0;

    /* renamed from: f, reason: collision with root package name */
    private String f8187f;

    /* renamed from: g, reason: collision with root package name */
    private String f8188g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8189h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8190i;

    /* renamed from: j, reason: collision with root package name */
    private String f8191j;
    private boolean k;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f8182a[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f8182a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f8183b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        p(6);
        this.f8188g = ":";
        this.k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f8184c = writer;
    }

    private void B() throws IOException {
        if (this.f8191j != null) {
            a();
            v(this.f8191j);
            this.f8191j = null;
        }
    }

    private void a() throws IOException {
        int o = o();
        if (o == 5) {
            this.f8184c.write(44);
        } else if (o != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        l();
        q(4);
    }

    private void b(boolean z) throws IOException {
        int o = o();
        if (o == 1) {
            q(2);
            l();
            return;
        }
        if (o == 2) {
            this.f8184c.append(',');
            l();
            return;
        }
        if (o == 4) {
            this.f8184c.append((CharSequence) this.f8188g);
            q(5);
            return;
        }
        if (o != 6) {
            if (o != 7) {
                throw new IllegalStateException("Nesting problem.");
            }
            if (!this.f8189h) {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        }
        if (!this.f8189h && !z) {
            throw new IllegalStateException("JSON must start with an array or an object.");
        }
        q(7);
    }

    private c e(int i2, int i3, String str) throws IOException {
        int o = o();
        if (o != i3 && o != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f8191j != null) {
            throw new IllegalStateException("Dangling name: " + this.f8191j);
        }
        this.f8186e--;
        if (o == i3) {
            l();
        }
        this.f8184c.write(str);
        return this;
    }

    private void l() throws IOException {
        if (this.f8187f == null) {
            return;
        }
        this.f8184c.write("\n");
        int i2 = this.f8186e;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f8184c.write(this.f8187f);
        }
    }

    private c n(int i2, String str) throws IOException {
        b(true);
        p(i2);
        this.f8184c.write(str);
        return this;
    }

    private int o() {
        int i2 = this.f8186e;
        if (i2 != 0) {
            return this.f8185d[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void p(int i2) {
        int i3 = this.f8186e;
        int[] iArr = this.f8185d;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f8185d = iArr2;
        }
        int[] iArr3 = this.f8185d;
        int i4 = this.f8186e;
        this.f8186e = i4 + 1;
        iArr3[i4] = i2;
    }

    private void q(int i2) {
        this.f8185d[this.f8186e - 1] = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void v(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f8190i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.gson.stream.c.f8183b
            goto L9
        L7:
            java.lang.String[] r0 = com.google.gson.stream.c.f8182a
        L9:
            java.io.Writer r1 = r8.f8184c
            java.lang.String r2 = "\""
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f8184c
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f8184c
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f8184c
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f8184c
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.c.v(java.lang.String):void");
    }

    public c A(boolean z) throws IOException {
        B();
        b(false);
        this.f8184c.write(z ? "true" : "false");
        return this;
    }

    public c c() throws IOException {
        B();
        return n(1, "[");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8184c.close();
        int i2 = this.f8186e;
        if (i2 > 1 || (i2 == 1 && this.f8185d[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f8186e = 0;
    }

    public c d() throws IOException {
        B();
        return n(3, "{");
    }

    public c f() throws IOException {
        return e(1, 2, "]");
    }

    public void flush() throws IOException {
        if (this.f8186e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f8184c.flush();
    }

    public c g() throws IOException {
        return e(3, 5, "}");
    }

    public final boolean h() {
        return this.k;
    }

    public final boolean i() {
        return this.f8190i;
    }

    public boolean j() {
        return this.f8189h;
    }

    public c k(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f8191j != null) {
            throw new IllegalStateException();
        }
        if (this.f8186e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f8191j = str;
        return this;
    }

    public c m() throws IOException {
        if (this.f8191j != null) {
            if (!this.k) {
                this.f8191j = null;
                return this;
            }
            B();
        }
        b(false);
        this.f8184c.write("null");
        return this;
    }

    public final void r(boolean z) {
        this.f8190i = z;
    }

    public final void s(String str) {
        if (str.length() == 0) {
            this.f8187f = null;
            this.f8188g = ":";
        } else {
            this.f8187f = str;
            this.f8188g = ": ";
        }
    }

    public final void t(boolean z) {
        this.f8189h = z;
    }

    public final void u(boolean z) {
        this.k = z;
    }

    public c w(double d2) throws IOException {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
        B();
        b(false);
        this.f8184c.append((CharSequence) Double.toString(d2));
        return this;
    }

    public c x(long j2) throws IOException {
        B();
        b(false);
        this.f8184c.write(Long.toString(j2));
        return this;
    }

    public c y(Number number) throws IOException {
        if (number == null) {
            return m();
        }
        B();
        String obj = number.toString();
        if (this.f8189h || !(obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            b(false);
            this.f8184c.append((CharSequence) obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public c z(String str) throws IOException {
        if (str == null) {
            return m();
        }
        B();
        b(false);
        v(str);
        return this;
    }
}
