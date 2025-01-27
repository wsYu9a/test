package com.wbl.ad.yzz.gson.v;

import com.wbl.ad.yzz.gson.stream.JsonToken;
import com.wbl.ad.yzz.gson.stream.MalformedJsonException;
import com.wbl.ad.yzz.gson.t.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import kotlin.text.Typography;

/* loaded from: classes5.dex */
public class a implements Closeable {
    public static final char[] p = ")]}'\n".toCharArray();

    /* renamed from: a */
    public final Reader f32385a;

    /* renamed from: b */
    public boolean f32386b = false;

    /* renamed from: c */
    public final char[] f32387c = new char[1024];

    /* renamed from: d */
    public int f32388d = 0;

    /* renamed from: e */
    public int f32389e = 0;

    /* renamed from: f */
    public int f32390f = 0;

    /* renamed from: g */
    public int f32391g = 0;

    /* renamed from: h */
    public int f32392h = 0;

    /* renamed from: i */
    public long f32393i;

    /* renamed from: j */
    public int f32394j;
    public String k;
    public int[] l;
    public int m;
    public String[] n;
    public int[] o;

    /* renamed from: com.wbl.ad.yzz.gson.v.a$a */
    public static class C0728a extends e {
        @Override // com.wbl.ad.yzz.gson.t.e
        public void a(a aVar) throws IOException {
            if (aVar instanceof com.wbl.ad.yzz.gson.t.k.e) {
                ((com.wbl.ad.yzz.gson.t.k.e) aVar).C();
                return;
            }
            int i2 = aVar.f32392h;
            if (i2 == 0) {
                i2 = aVar.e();
            }
            if (i2 == 13) {
                aVar.f32392h = 9;
                return;
            }
            if (i2 == 12) {
                aVar.f32392h = 8;
                return;
            }
            if (i2 == 14) {
                aVar.f32392h = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + aVar.t() + aVar.k());
        }
    }

    static {
        e.f32293a = new C0728a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.l = iArr;
        this.m = 0;
        this.m = 1;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f32385a = reader;
    }

    public void a() throws IOException {
        int i2 = this.f32392h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 3) {
            b(1);
            this.o[this.m - 1] = 0;
            this.f32392h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + t() + k());
        }
    }

    public final void b(boolean z) {
        this.f32386b = z;
    }

    public final void c(char c2) throws IOException {
        char[] cArr = this.f32387c;
        do {
            int i2 = this.f32388d;
            int i3 = this.f32389e;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f32388d = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f32388d = i4;
                    w();
                    i2 = this.f32388d;
                    i3 = this.f32389e;
                } else {
                    if (c3 == '\n') {
                        this.f32390f++;
                        this.f32391g = i4;
                    }
                    i2 = i4;
                }
            }
            this.f32388d = i2;
        } while (a(1));
        b("Unterminated string");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f32392h = 0;
        this.l[0] = 8;
        this.m = 1;
        this.f32385a.close();
    }

    public final void d() throws IOException {
        a(true);
        int i2 = this.f32388d - 1;
        this.f32388d = i2;
        char[] cArr = p;
        if (i2 + cArr.length > this.f32389e && !a(cArr.length)) {
            return;
        }
        int i3 = 0;
        while (true) {
            char[] cArr2 = p;
            if (i3 >= cArr2.length) {
                this.f32388d += cArr2.length;
                return;
            } else if (this.f32387c[this.f32388d + i3] != cArr2[i3]) {
                return;
            } else {
                i3++;
            }
        }
    }

    public int e() throws IOException {
        int a2;
        int[] iArr = this.l;
        int i2 = this.m - 1;
        int i3 = iArr[i2];
        if (i3 == 1) {
            iArr[i2] = 2;
        } else if (i3 == 2) {
            int a3 = a(true);
            if (a3 != 44) {
                if (a3 != 59) {
                    if (a3 == 93) {
                        this.f32392h = 4;
                        return 4;
                    }
                    b("Unterminated array");
                    throw null;
                }
                c();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                iArr[i2] = 4;
                if (i3 == 5 && (a2 = a(true)) != 44) {
                    if (a2 != 59) {
                        if (a2 == 125) {
                            this.f32392h = 2;
                            return 2;
                        }
                        b("Unterminated object");
                        throw null;
                    }
                    c();
                }
                int a4 = a(true);
                if (a4 == 34) {
                    this.f32392h = 13;
                    return 13;
                }
                if (a4 == 39) {
                    c();
                    this.f32392h = 12;
                    return 12;
                }
                if (a4 == 125) {
                    if (i3 != 5) {
                        this.f32392h = 2;
                        return 2;
                    }
                    b("Expected name");
                    throw null;
                }
                c();
                this.f32388d--;
                if (a((char) a4)) {
                    this.f32392h = 14;
                    return 14;
                }
                b("Expected name");
                throw null;
            }
            if (i3 == 4) {
                iArr[i2] = 5;
                int a5 = a(true);
                if (a5 != 58) {
                    if (a5 != 61) {
                        b("Expected ':'");
                        throw null;
                    }
                    c();
                    if (this.f32388d < this.f32389e || a(1)) {
                        char[] cArr = this.f32387c;
                        int i4 = this.f32388d;
                        if (cArr[i4] == '>') {
                            this.f32388d = i4 + 1;
                        }
                    }
                }
            } else if (i3 == 6) {
                if (this.f32386b) {
                    d();
                }
                this.l[this.m - 1] = 7;
            } else if (i3 == 7) {
                if (a(false) == -1) {
                    this.f32392h = 17;
                    return 17;
                }
                c();
                this.f32388d--;
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int a6 = a(true);
        if (a6 == 34) {
            this.f32392h = 9;
            return 9;
        }
        if (a6 == 39) {
            c();
            this.f32392h = 8;
            return 8;
        }
        if (a6 != 44 && a6 != 59) {
            if (a6 == 91) {
                this.f32392h = 3;
                return 3;
            }
            if (a6 != 93) {
                if (a6 == 123) {
                    this.f32392h = 1;
                    return 1;
                }
                this.f32388d--;
                int u = u();
                if (u != 0) {
                    return u;
                }
                int v = v();
                if (v != 0) {
                    return v;
                }
                if (!a(this.f32387c[this.f32388d])) {
                    b("Expected value");
                    throw null;
                }
                c();
                this.f32392h = 10;
                return 10;
            }
            if (i3 == 1) {
                this.f32392h = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            b("Unexpected value");
            throw null;
        }
        c();
        this.f32388d--;
        this.f32392h = 7;
        return 7;
    }

    public void f() throws IOException {
        int i2 = this.f32392h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + t() + k());
        }
        int i3 = this.m - 1;
        this.m = i3;
        int[] iArr = this.o;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f32392h = 0;
    }

    public void g() throws IOException {
        int i2 = this.f32392h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + t() + k());
        }
        int i3 = this.m - 1;
        this.m = i3;
        this.n[i3] = null;
        int[] iArr = this.o;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.f32392h = 0;
    }

    public String h() {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.dollar);
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.l[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.o[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.n;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public boolean i() throws IOException {
        int i2 = this.f32392h;
        if (i2 == 0) {
            i2 = e();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public final boolean j() {
        return this.f32386b;
    }

    public String k() {
        return " at line " + (this.f32390f + 1) + " column " + ((this.f32388d - this.f32391g) + 1) + " path " + h();
    }

    public boolean l() throws IOException {
        int i2 = this.f32392h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 5) {
            this.f32392h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        }
        if (i2 == 6) {
            this.f32392h = 0;
            int[] iArr2 = this.o;
            int i4 = this.m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + t() + k());
    }

    public double m() throws IOException {
        int i2 = this.f32392h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            this.f32392h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f32393i;
        }
        if (i2 == 16) {
            this.k = new String(this.f32387c, this.f32388d, this.f32394j);
            this.f32388d += this.f32394j;
        } else if (i2 == 8 || i2 == 9) {
            this.k = b(i2 == 8 ? '\'' : Typography.quote);
        } else if (i2 == 10) {
            this.k = s();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + t() + k());
        }
        this.f32392h = 11;
        double parseDouble = Double.parseDouble(this.k);
        if (!this.f32386b && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + k());
        }
        this.k = null;
        this.f32392h = 0;
        int[] iArr2 = this.o;
        int i4 = this.m - 1;
        iArr2[i4] = iArr2[i4] + 1;
        return parseDouble;
    }

    public int n() throws IOException {
        int i2 = this.f32392h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            long j2 = this.f32393i;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.f32392h = 0;
                int[] iArr = this.o;
                int i4 = this.m - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.f32393i + k());
        }
        if (i2 == 16) {
            this.k = new String(this.f32387c, this.f32388d, this.f32394j);
            this.f32388d += this.f32394j;
        } else {
            if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected an int but was " + t() + k());
            }
            if (i2 == 10) {
                this.k = s();
            } else {
                this.k = b(i2 == 8 ? '\'' : Typography.quote);
            }
            try {
                int parseInt = Integer.parseInt(this.k);
                this.f32392h = 0;
                int[] iArr2 = this.o;
                int i5 = this.m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f32392h = 11;
        double parseDouble = Double.parseDouble(this.k);
        int i6 = (int) parseDouble;
        if (i6 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.k + k());
        }
        this.k = null;
        this.f32392h = 0;
        int[] iArr3 = this.o;
        int i7 = this.m - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return i6;
    }

    public long o() throws IOException {
        int i2 = this.f32392h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            this.f32392h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f32393i;
        }
        if (i2 == 16) {
            this.k = new String(this.f32387c, this.f32388d, this.f32394j);
            this.f32388d += this.f32394j;
        } else {
            if (i2 != 8 && i2 != 9 && i2 != 10) {
                throw new IllegalStateException("Expected a long but was " + t() + k());
            }
            if (i2 == 10) {
                this.k = s();
            } else {
                this.k = b(i2 == 8 ? '\'' : Typography.quote);
            }
            try {
                long parseLong = Long.parseLong(this.k);
                this.f32392h = 0;
                int[] iArr2 = this.o;
                int i4 = this.m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f32392h = 11;
        double parseDouble = Double.parseDouble(this.k);
        long j2 = (long) parseDouble;
        if (j2 != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.k + k());
        }
        this.k = null;
        this.f32392h = 0;
        int[] iArr3 = this.o;
        int i5 = this.m - 1;
        iArr3[i5] = iArr3[i5] + 1;
        return j2;
    }

    public String p() throws IOException {
        String b2;
        int i2 = this.f32392h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 14) {
            b2 = s();
        } else if (i2 == 12) {
            b2 = b('\'');
        } else {
            if (i2 != 13) {
                throw new IllegalStateException("Expected a name but was " + t() + k());
            }
            b2 = b(Typography.quote);
        }
        this.f32392h = 0;
        this.n[this.m - 1] = b2;
        return b2;
    }

    public void q() throws IOException {
        int i2 = this.f32392h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 7) {
            this.f32392h = 0;
            int[] iArr = this.o;
            int i3 = this.m - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + t() + k());
    }

    public String r() throws IOException {
        String str;
        int i2 = this.f32392h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 10) {
            str = s();
        } else if (i2 == 8) {
            str = b('\'');
        } else if (i2 == 9) {
            str = b(Typography.quote);
        } else if (i2 == 11) {
            str = this.k;
            this.k = null;
        } else if (i2 == 15) {
            str = Long.toString(this.f32393i);
        } else {
            if (i2 != 16) {
                throw new IllegalStateException("Expected a string but was " + t() + k());
            }
            str = new String(this.f32387c, this.f32388d, this.f32394j);
            this.f32388d += this.f32394j;
        }
        this.f32392h = 0;
        int[] iArr = this.o;
        int i3 = this.m - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x0048, code lost:
    
        c();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0042. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String s() throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r5.f32388d
            int r3 = r3 + r2
            int r4 = r5.f32389e
            if (r3 >= r4) goto L4c
            char[] r4 = r5.f32387c
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5a
            r4 = 10
            if (r3 == r4) goto L5a
            r4 = 12
            if (r3 == r4) goto L5a
            r4 = 13
            if (r3 == r4) goto L5a
            r4 = 32
            if (r3 == r4) goto L5a
            r4 = 35
            if (r3 == r4) goto L48
            r4 = 44
            if (r3 == r4) goto L5a
            r4 = 47
            if (r3 == r4) goto L48
            r4 = 61
            if (r3 == r4) goto L48
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5a
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5a
            r4 = 58
            if (r3 == r4) goto L5a
            r4 = 59
            if (r3 == r4) goto L48
            switch(r3) {
                case 91: goto L5a;
                case 92: goto L48;
                case 93: goto L5a;
                default: goto L45;
            }
        L45:
            int r2 = r2 + 1
            goto L3
        L48:
            r5.c()
            goto L5a
        L4c:
            char[] r3 = r5.f32387c
            int r3 = r3.length
            if (r2 >= r3) goto L5c
            int r3 = r2 + 1
            boolean r3 = r5.a(r3)
            if (r3 == 0) goto L5a
            goto L3
        L5a:
            r0 = r2
            goto L7c
        L5c:
            if (r1 != 0) goto L69
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L69:
            char[] r3 = r5.f32387c
            int r4 = r5.f32388d
            r1.append(r3, r4, r2)
            int r3 = r5.f32388d
            int r3 = r3 + r2
            r5.f32388d = r3
            r2 = 1
            boolean r2 = r5.a(r2)
            if (r2 != 0) goto L2
        L7c:
            if (r1 != 0) goto L88
            java.lang.String r1 = new java.lang.String
            char[] r2 = r5.f32387c
            int r3 = r5.f32388d
            r1.<init>(r2, r3, r0)
            goto L93
        L88:
            char[] r2 = r5.f32387c
            int r3 = r5.f32388d
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L93:
            int r2 = r5.f32388d
            int r2 = r2 + r0
            r5.f32388d = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wbl.ad.yzz.gson.v.a.s():java.lang.String");
    }

    public JsonToken t() throws IOException {
        int i2 = this.f32392h;
        if (i2 == 0) {
            i2 = e();
        }
        switch (i2) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + k();
    }

    public final int u() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.f32387c[this.f32388d];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str = "false";
            str2 = "FALSE";
        } else {
            if (c2 != 'n' && c2 != 'N') {
                return 0;
            }
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f32388d + i3 >= this.f32389e && !a(i3 + 1)) {
                return 0;
            }
            char c3 = this.f32387c[this.f32388d + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f32388d + length < this.f32389e || a(length + 1)) && a(this.f32387c[this.f32388d + length])) {
            return 0;
        }
        this.f32388d += length;
        this.f32392h = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0097, code lost:
    
        if (r9 != 2) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0099, code lost:
    
        if (r13 == false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009f, code lost:
    
        if (r10 != Long.MIN_VALUE) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a1, code lost:
    
        if (r12 == false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a7, code lost:
    
        if (r10 != 0) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a9, code lost:
    
        if (r12 != false) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ab, code lost:
    
        if (r12 == false) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00ae, code lost:
    
        r10 = -r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00af, code lost:
    
        r18.f32393i = r10;
        r18.f32388d += r8;
        r18.f32392h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00ba, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00bb, code lost:
    
        if (r9 == 2) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00be, code lost:
    
        if (r9 == 4) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c1, code lost:
    
        if (r9 != 7) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c4, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c6, code lost:
    
        r18.f32394j = r8;
        r18.f32392h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cc, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0095, code lost:
    
        if (a(r14) != false) goto L196;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00cd, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int v() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wbl.ad.yzz.gson.v.a.v():int");
    }

    public final char w() throws IOException {
        int i2;
        int i3;
        if (this.f32388d == this.f32389e && !a(1)) {
            b("Unterminated escape sequence");
            throw null;
        }
        char[] cArr = this.f32387c;
        int i4 = this.f32388d;
        int i5 = i4 + 1;
        this.f32388d = i5;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.f32390f++;
            this.f32391g = i5;
        } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
            if (c2 == 'b') {
                return '\b';
            }
            if (c2 == 'f') {
                return '\f';
            }
            if (c2 == 'n') {
                return '\n';
            }
            if (c2 == 'r') {
                return '\r';
            }
            if (c2 == 't') {
                return '\t';
            }
            if (c2 != 'u') {
                b("Invalid escape sequence");
                throw null;
            }
            if (i5 + 4 > this.f32389e && !a(4)) {
                b("Unterminated escape sequence");
                throw null;
            }
            char c3 = 0;
            int i6 = this.f32388d;
            int i7 = i6 + 4;
            while (i6 < i7) {
                char c4 = this.f32387c[i6];
                char c5 = (char) (c3 << 4);
                if (c4 < '0' || c4 > '9') {
                    if (c4 >= 'a' && c4 <= 'f') {
                        i2 = c4 - 'a';
                    } else {
                        if (c4 < 'A' || c4 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f32387c, this.f32388d, 4));
                        }
                        i2 = c4 - 'A';
                    }
                    i3 = i2 + 10;
                } else {
                    i3 = c4 - '0';
                }
                c3 = (char) (c5 + i3);
                i6++;
            }
            this.f32388d += 4;
            return c3;
        }
        return c2;
    }

    public final void x() throws IOException {
        char c2;
        do {
            if (this.f32388d >= this.f32389e && !a(1)) {
                return;
            }
            char[] cArr = this.f32387c;
            int i2 = this.f32388d;
            int i3 = i2 + 1;
            this.f32388d = i3;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.f32390f++;
                this.f32391g = i3;
                return;
            }
        } while (c2 != '\r');
    }

    public final void y() throws IOException {
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.f32388d + i2;
                if (i3 < this.f32389e) {
                    char c2 = this.f32387c[i3];
                    if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (c2 != '/' && c2 != '=') {
                                    if (c2 != '{' && c2 != '}' && c2 != ':') {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    this.f32388d = i3;
                }
            }
            c();
            this.f32388d += i2;
            return;
        } while (a(1));
    }

    public void z() throws IOException {
        int i2 = 0;
        do {
            int i3 = this.f32392h;
            if (i3 == 0) {
                i3 = e();
            }
            if (i3 == 3) {
                b(1);
            } else if (i3 == 1) {
                b(3);
            } else {
                if (i3 == 4) {
                    this.m--;
                } else if (i3 == 2) {
                    this.m--;
                } else {
                    if (i3 == 14 || i3 == 10) {
                        y();
                    } else if (i3 == 8 || i3 == 12) {
                        c('\'');
                    } else if (i3 == 9 || i3 == 13) {
                        c(Typography.quote);
                    } else if (i3 == 16) {
                        this.f32388d += this.f32394j;
                    }
                    this.f32392h = 0;
                }
                i2--;
                this.f32392h = 0;
            }
            i2++;
            this.f32392h = 0;
        } while (i2 != 0);
        int[] iArr = this.o;
        int i4 = this.m - 1;
        iArr[i4] = iArr[i4] + 1;
        this.n[i4] = "null";
    }

    public void b() throws IOException {
        int i2 = this.f32392h;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 1) {
            b(3);
            this.f32392h = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + t() + k());
        }
    }

    public final boolean a(char c2) throws IOException {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (c2 != '/' && c2 != '=') {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x005d, code lost:
    
        if (r2 != null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005f, code lost:
    
        r2 = new java.lang.StringBuilder(java.lang.Math.max((r3 - r4) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006d, code lost:
    
        r2.append(r0, r4, r3 - r4);
        r10.f32388d = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(char r11) throws java.io.IOException {
        /*
            r10 = this;
            char[] r0 = r10.f32387c
            r1 = 0
            r2 = r1
        L4:
            int r3 = r10.f32388d
            int r4 = r10.f32389e
        L8:
            r5 = r4
            r4 = r3
        La:
            r6 = 16
            r7 = 1
            if (r3 >= r5) goto L5d
            int r8 = r3 + 1
            char r3 = r0[r3]
            if (r3 != r11) goto L29
            r10.f32388d = r8
            int r8 = r8 - r4
            int r8 = r8 - r7
            if (r2 != 0) goto L21
            java.lang.String r11 = new java.lang.String
            r11.<init>(r0, r4, r8)
            return r11
        L21:
            r2.append(r0, r4, r8)
            java.lang.String r11 = r2.toString()
            return r11
        L29:
            r9 = 92
            if (r3 != r9) goto L50
            r10.f32388d = r8
            int r8 = r8 - r4
            int r8 = r8 - r7
            if (r2 != 0) goto L41
            int r2 = r8 + 1
            int r2 = r2 * 2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r2 = java.lang.Math.max(r2, r6)
            r3.<init>(r2)
            r2 = r3
        L41:
            r2.append(r0, r4, r8)
            char r3 = r10.w()
            r2.append(r3)
            int r3 = r10.f32388d
            int r4 = r10.f32389e
            goto L8
        L50:
            r6 = 10
            if (r3 != r6) goto L5b
            int r3 = r10.f32390f
            int r3 = r3 + r7
            r10.f32390f = r3
            r10.f32391g = r8
        L5b:
            r3 = r8
            goto La
        L5d:
            if (r2 != 0) goto L6d
            int r2 = r3 - r4
            int r2 = r2 * 2
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r2 = java.lang.Math.max(r2, r6)
            r5.<init>(r2)
            r2 = r5
        L6d:
            int r5 = r3 - r4
            r2.append(r0, r4, r5)
            r10.f32388d = r3
            boolean r3 = r10.a(r7)
            if (r3 == 0) goto L7b
            goto L4
        L7b:
            java.lang.String r11 = "Unterminated string"
            r10.b(r11)
            goto L82
        L81:
            throw r1
        L82:
            goto L81
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wbl.ad.yzz.gson.v.a.b(char):java.lang.String");
    }

    public final boolean a(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.f32387c;
        int i5 = this.f32391g;
        int i6 = this.f32388d;
        this.f32391g = i5 - i6;
        int i7 = this.f32389e;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f32389e = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f32389e = 0;
        }
        this.f32388d = 0;
        do {
            Reader reader = this.f32385a;
            int i9 = this.f32389e;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.f32389e + read;
            this.f32389e = i3;
            if (this.f32390f == 0 && (i4 = this.f32391g) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f32388d++;
                this.f32391g = i4 + 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    public final void c() throws IOException {
        if (this.f32386b) {
            return;
        }
        b("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    public final int a(boolean z) throws IOException {
        char[] cArr = this.f32387c;
        int i2 = this.f32388d;
        int i3 = this.f32389e;
        while (true) {
            if (i2 == i3) {
                this.f32388d = i2;
                if (!a(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + k());
                }
                i2 = this.f32388d;
                i3 = this.f32389e;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f32390f++;
                this.f32391g = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f32388d = i4;
                    if (i4 == i3) {
                        this.f32388d = i4 - 1;
                        boolean a2 = a(2);
                        this.f32388d++;
                        if (!a2) {
                            return c2;
                        }
                    }
                    c();
                    int i5 = this.f32388d;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f32388d = i5 + 1;
                        if (a("*/")) {
                            i2 = this.f32388d + 2;
                            i3 = this.f32389e;
                        } else {
                            b("Unterminated comment");
                            throw null;
                        }
                    } else {
                        if (c3 != '/') {
                            return c2;
                        }
                        this.f32388d = i5 + 1;
                        x();
                        i2 = this.f32388d;
                        i3 = this.f32389e;
                    }
                } else if (c2 == '#') {
                    this.f32388d = i4;
                    c();
                    x();
                    i2 = this.f32388d;
                    i3 = this.f32389e;
                } else {
                    this.f32388d = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    public final void b(int i2) {
        int i3 = this.m;
        int[] iArr = this.l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            int[] iArr2 = new int[i4];
            int[] iArr3 = new int[i4];
            String[] strArr = new String[i4];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.o, 0, iArr3, 0, this.m);
            System.arraycopy(this.n, 0, strArr, 0, this.m);
            this.l = iArr2;
            this.o = iArr3;
            this.n = strArr;
        }
        int[] iArr4 = this.l;
        int i5 = this.m;
        this.m = i5 + 1;
        iArr4[i5] = i2;
    }

    public final IOException b(String str) throws IOException {
        throw new MalformedJsonException(str + k());
    }

    public final boolean a(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f32388d + length > this.f32389e && !a(length)) {
                return false;
            }
            char[] cArr = this.f32387c;
            int i2 = this.f32388d;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f32387c[this.f32388d + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.f32390f++;
            this.f32391g = i2 + 1;
            this.f32388d++;
        }
    }
}
