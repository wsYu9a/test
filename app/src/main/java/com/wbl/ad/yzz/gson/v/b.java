package com.wbl.ad.yzz.gson.v;

import android.text.TextUtils;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* loaded from: classes5.dex */
public class b implements Closeable, Flushable {

    /* renamed from: j */
    public static final String[] f32395j = new String[128];
    public static final String[] k;

    /* renamed from: a */
    public final Writer f32396a;

    /* renamed from: b */
    public int[] f32397b = new int[32];

    /* renamed from: c */
    public int f32398c = 0;

    /* renamed from: d */
    public String f32399d;

    /* renamed from: e */
    public String f32400e;

    /* renamed from: f */
    public boolean f32401f;

    /* renamed from: g */
    public boolean f32402g;

    /* renamed from: h */
    public String f32403h;

    /* renamed from: i */
    public boolean f32404i;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f32395j[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f32395j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        k = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public b(Writer writer) {
        a(6);
        this.f32400e = ":";
        this.f32404i = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f32396a = writer;
    }

    public final void a(boolean z) {
        this.f32402g = z;
    }

    public final void b(String str) {
        if (str.length() == 0) {
            this.f32399d = null;
            this.f32400e = ":";
        } else {
            this.f32399d = str;
            this.f32400e = ": ";
        }
    }

    public final void c(boolean z) {
        this.f32404i = z;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f32396a.close();
        int i2 = this.f32398c;
        if (i2 > 1 || (i2 == 1 && this.f32397b[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f32398c = 0;
    }

    public b d() throws IOException {
        m();
        return a(3, "{");
    }

    public b e() throws IOException {
        return a(1, 2, "]");
    }

    public b f() throws IOException {
        return a(3, 5, "}");
    }

    public void flush() throws IOException {
        if (this.f32398c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f32396a.flush();
    }

    public final boolean g() {
        return this.f32404i;
    }

    public final boolean h() {
        return this.f32402g;
    }

    public boolean i() {
        return this.f32401f;
    }

    public final void j() throws IOException {
        if (this.f32399d == null) {
            return;
        }
        this.f32396a.write("\n");
        int i2 = this.f32398c;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f32396a.write(this.f32399d);
        }
    }

    public b k() throws IOException {
        if (this.f32403h != null) {
            if (!this.f32404i) {
                this.f32403h = null;
                return this;
            }
            m();
        }
        b();
        this.f32396a.write("null");
        return this;
    }

    public final int l() {
        int i2 = this.f32398c;
        if (i2 != 0) {
            return this.f32397b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void m() throws IOException {
        if (this.f32403h != null) {
            a();
            c(this.f32403h);
            this.f32403h = null;
        }
    }

    public final b a(int i2, String str) throws IOException {
        b();
        a(i2);
        this.f32396a.write(str);
        return this;
    }

    public b c() throws IOException {
        m();
        return a(1, "[");
    }

    public b d(String str) throws IOException {
        if (str == null) {
            return k();
        }
        m();
        b();
        c(str);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f32402g
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.wbl.ad.yzz.gson.v.b.k
            goto L9
        L7:
            java.lang.String[] r0 = com.wbl.ad.yzz.gson.v.b.f32395j
        L9:
            java.io.Writer r1 = r8.f32396a
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
            java.io.Writer r6 = r8.f32396a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f32396a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f32396a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f32396a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wbl.ad.yzz.gson.v.b.c(java.lang.String):void");
    }

    public final b a(int i2, int i3, String str) throws IOException {
        int l = l();
        if (l != i3 && l != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f32403h == null) {
            this.f32398c--;
            if (l == i3) {
                j();
            }
            this.f32396a.write(str);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f32403h);
    }

    public final void b(boolean z) {
        this.f32401f = z;
    }

    public final void b(int i2) {
        this.f32397b[this.f32398c - 1] = i2;
    }

    public b d(boolean z) throws IOException {
        m();
        b();
        this.f32396a.write(z ? "true" : "false");
        return this;
    }

    public final void b() throws IOException {
        int l = l();
        if (l == 1) {
            b(2);
            j();
            return;
        }
        if (l == 2) {
            this.f32396a.append(',');
            j();
        } else {
            if (l != 4) {
                if (l != 6) {
                    if (l == 7) {
                        if (!this.f32401f) {
                            throw new IllegalStateException("JSON must have only one top-level value.");
                        }
                    } else {
                        throw new IllegalStateException("Nesting problem.");
                    }
                }
                b(7);
                return;
            }
            this.f32396a.append((CharSequence) this.f32400e);
            b(5);
        }
    }

    public final void a(int i2) {
        int i3 = this.f32398c;
        int[] iArr = this.f32397b;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f32397b = iArr2;
        }
        int[] iArr3 = this.f32397b;
        int i4 = this.f32398c;
        this.f32398c = i4 + 1;
        iArr3[i4] = i2;
    }

    public b a(String str) throws IOException {
        if (str != null) {
            if (this.f32403h == null) {
                if (this.f32398c != 0) {
                    this.f32403h = str;
                    return this;
                }
                throw new IllegalStateException("JsonWriter is closed.");
            }
            throw new IllegalStateException();
        }
        throw new NullPointerException("name == null");
    }

    public b a(Boolean bool) throws IOException {
        if (bool == null) {
            return k();
        }
        m();
        b();
        this.f32396a.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public b a(long j2) throws IOException {
        m();
        b();
        this.f32396a.write(Long.toString(j2));
        return this;
    }

    public b a(Number number) throws IOException {
        if (number == null) {
            return k();
        }
        m();
        String obj = number.toString();
        if (!this.f32401f && (TextUtils.equals("-Infinity", obj) || TextUtils.equals(obj, "Infinity") || TextUtils.equals(obj, "NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        b();
        this.f32396a.append((CharSequence) obj);
        return this;
    }

    public final void a() throws IOException {
        int l = l();
        if (l == 5) {
            this.f32396a.write(44);
        } else if (l != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        j();
        b(4);
    }
}
