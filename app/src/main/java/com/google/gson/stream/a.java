package com.google.gson.stream;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import kotlin.text.Typography;

/* loaded from: classes.dex */
public class a implements Closeable {
    private static final int A = 6;
    private static final int B = 7;

    /* renamed from: a */
    private static final char[] f8164a = ")]}'\n".toCharArray();

    /* renamed from: b */
    private static final long f8165b = -922337203685477580L;

    /* renamed from: c */
    private static final int f8166c = 0;

    /* renamed from: d */
    private static final int f8167d = 1;

    /* renamed from: e */
    private static final int f8168e = 2;

    /* renamed from: f */
    private static final int f8169f = 3;

    /* renamed from: g */
    private static final int f8170g = 4;

    /* renamed from: h */
    private static final int f8171h = 5;

    /* renamed from: i */
    private static final int f8172i = 6;

    /* renamed from: j */
    private static final int f8173j = 7;
    private static final int k = 8;
    private static final int l = 9;
    private static final int m = 10;
    private static final int n = 11;
    private static final int o = 12;
    private static final int p = 13;
    private static final int q = 14;
    private static final int r = 15;
    private static final int s = 16;
    private static final int t = 17;
    private static final int u = 0;
    private static final int v = 1;
    private static final int w = 2;
    private static final int x = 3;
    private static final int y = 4;
    private static final int z = 5;
    private final Reader C;
    private boolean D = false;
    private final char[] E = new char[1024];
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private int I = 0;
    private int J = 0;
    private long K;
    private int L;
    private String M;
    private int[] N;
    private int O;
    private String[] P;
    private int[] Q;

    /* renamed from: com.google.gson.stream.a$a */
    static class C0111a extends com.google.gson.internal.c {
        C0111a() {
        }

        @Override // com.google.gson.internal.c
        public void a(a aVar) throws IOException {
            if (aVar instanceof com.google.gson.internal.bind.a) {
                ((com.google.gson.internal.bind.a) aVar).R();
                return;
            }
            int i2 = aVar.J;
            if (i2 == 0) {
                i2 = aVar.j();
            }
            if (i2 == 13) {
                aVar.J = 9;
                return;
            }
            if (i2 == 12) {
                aVar.J = 8;
                return;
            }
            if (i2 == 14) {
                aVar.J = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + aVar.C() + "  at line " + aVar.o() + " column " + aVar.n() + " path " + aVar.getPath());
        }
    }

    static {
        com.google.gson.internal.c.f8153a = new C0111a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.N = iArr;
        this.O = 0;
        this.O = 0 + 1;
        iArr[0] = 6;
        this.P = new String[32];
        this.Q = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.C = reader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        h();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String B() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r6.F
            int r4 = r3 + r2
            int r5 = r6.G
            if (r4 >= r5) goto L4e
            char[] r4 = r6.E
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.h()
            goto L5c
        L4e:
            char[] r3 = r6.E
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.m(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r0 = r2
            goto L78
        L5e:
            if (r1 != 0) goto L65
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L65:
            char[] r3 = r6.E
            int r4 = r6.F
            r1.append(r3, r4, r2)
            int r3 = r6.F
            int r3 = r3 + r2
            r6.F = r3
            r2 = 1
            boolean r2 = r6.m(r2)
            if (r2 != 0) goto L2
        L78:
            if (r1 != 0) goto L84
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.E
            int r3 = r6.F
            r1.<init>(r2, r3, r0)
            goto L8f
        L84:
            char[] r2 = r6.E
            int r3 = r6.F
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L8f:
            int r2 = r6.F
            int r2 = r2 + r0
            r6.F = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.B():java.lang.String");
    }

    private int D() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.E[this.F];
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
            if (this.F + i3 >= this.G && !m(i3 + 1)) {
                return 0;
            }
            char c3 = this.E[this.F + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.F + length < this.G || m(length + 1)) && r(this.E[this.F + length])) {
            return 0;
        }
        this.F += length;
        this.J = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x009d, code lost:
    
        if (r9 != 2) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x009f, code lost:
    
        if (r10 == false) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a5, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a7, code lost:
    
        if (r13 == false) goto L185;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x00a9, code lost:
    
        if (r13 == false) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00ac, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00ad, code lost:
    
        r18.K = r11;
        r18.F += r8;
        r18.J = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b8, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b9, code lost:
    
        if (r9 == 2) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00bc, code lost:
    
        if (r9 == 4) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bf, code lost:
    
        if (r9 != 7) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c2, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c4, code lost:
    
        r18.L = r8;
        r18.J = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ca, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x009b, code lost:
    
        if (r(r14) != false) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00cb, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int E() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.E():int");
    }

    private void F(int i2) {
        int i3 = this.O;
        int[] iArr = this.N;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            int[] iArr3 = new int[i3 * 2];
            String[] strArr = new String[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.Q, 0, iArr3, 0, this.O);
            System.arraycopy(this.P, 0, strArr, 0, this.O);
            this.N = iArr2;
            this.Q = iArr3;
            this.P = strArr;
        }
        int[] iArr4 = this.N;
        int i4 = this.O;
        this.O = i4 + 1;
        iArr4[i4] = i2;
    }

    private char G() throws IOException {
        int i2;
        int i3;
        if (this.F == this.G && !m(1)) {
            throw N("Unterminated escape sequence");
        }
        char[] cArr = this.E;
        int i4 = this.F;
        int i5 = i4 + 1;
        this.F = i5;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.H++;
            this.I = i5;
        } else {
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
            if (c2 == 'u') {
                if (i5 + 4 > this.G && !m(4)) {
                    throw N("Unterminated escape sequence");
                }
                char c3 = 0;
                int i6 = this.F;
                int i7 = i6 + 4;
                while (i6 < i7) {
                    char c4 = this.E[i6];
                    char c5 = (char) (c3 << 4);
                    if (c4 < '0' || c4 > '9') {
                        if (c4 >= 'a' && c4 <= 'f') {
                            i2 = c4 - 'a';
                        } else {
                            if (c4 < 'A' || c4 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.E, this.F, 4));
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
                this.F += 4;
                return c3;
            }
        }
        return c2;
    }

    private void I(char c2) throws IOException {
        char[] cArr = this.E;
        do {
            int i2 = this.F;
            int i3 = this.G;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.F = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.F = i4;
                    G();
                    i2 = this.F;
                    i3 = this.G;
                } else {
                    if (c3 == '\n') {
                        this.H++;
                        this.I = i4;
                    }
                    i2 = i4;
                }
            }
            this.F = i2;
        } while (m(1));
        throw N("Unterminated string");
    }

    private boolean J(String str) throws IOException {
        while (true) {
            if (this.F + str.length() > this.G && !m(str.length())) {
                return false;
            }
            char[] cArr = this.E;
            int i2 = this.F;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < str.length(); i3++) {
                    if (this.E[this.F + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.H++;
            this.I = i2 + 1;
            this.F++;
        }
    }

    private void K() throws IOException {
        char c2;
        do {
            if (this.F >= this.G && !m(1)) {
                return;
            }
            char[] cArr = this.E;
            int i2 = this.F;
            int i3 = i2 + 1;
            this.F = i3;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.H++;
                this.I = i3;
                return;
            }
        } while (c2 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        h();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void L() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.F
            int r2 = r1 + r0
            int r3 = r4.G
            if (r2 >= r3) goto L51
            char[] r2 = r4.E
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.h()
        L4b:
            int r1 = r4.F
            int r1 = r1 + r0
            r4.F = r1
            return
        L51:
            int r1 = r1 + r0
            r4.F = r1
            r0 = 1
            boolean r0 = r4.m(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.L():void");
    }

    private IOException N(String str) throws IOException {
        throw new MalformedJsonException(str + " at line " + o() + " column " + n() + " path " + getPath());
    }

    private void h() throws IOException {
        if (!this.D) {
            throw N("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void i() throws IOException {
        x(true);
        int i2 = this.F - 1;
        this.F = i2;
        char[] cArr = f8164a;
        if (i2 + cArr.length > this.G && !m(cArr.length)) {
            return;
        }
        int i3 = 0;
        while (true) {
            char[] cArr2 = f8164a;
            if (i3 >= cArr2.length) {
                this.F += cArr2.length;
                return;
            } else if (this.E[this.F + i3] != cArr2[i3]) {
                return;
            } else {
                i3++;
            }
        }
    }

    public int j() throws IOException {
        int x2;
        int[] iArr = this.N;
        int i2 = this.O;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int x3 = x(true);
            if (x3 != 44) {
                if (x3 != 59) {
                    if (x3 != 93) {
                        throw N("Unterminated array");
                    }
                    this.J = 4;
                    return 4;
                }
                h();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                iArr[i2 - 1] = 4;
                if (i3 == 5 && (x2 = x(true)) != 44) {
                    if (x2 != 59) {
                        if (x2 != 125) {
                            throw N("Unterminated object");
                        }
                        this.J = 2;
                        return 2;
                    }
                    h();
                }
                int x4 = x(true);
                if (x4 == 34) {
                    this.J = 13;
                    return 13;
                }
                if (x4 == 39) {
                    h();
                    this.J = 12;
                    return 12;
                }
                if (x4 == 125) {
                    if (i3 == 5) {
                        throw N("Expected name");
                    }
                    this.J = 2;
                    return 2;
                }
                h();
                this.F--;
                if (!r((char) x4)) {
                    throw N("Expected name");
                }
                this.J = 14;
                return 14;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int x5 = x(true);
                if (x5 != 58) {
                    if (x5 != 61) {
                        throw N("Expected ':'");
                    }
                    h();
                    if (this.F < this.G || m(1)) {
                        char[] cArr = this.E;
                        int i4 = this.F;
                        if (cArr[i4] == '>') {
                            this.F = i4 + 1;
                        }
                    }
                }
            } else if (i3 == 6) {
                if (this.D) {
                    i();
                }
                this.N[this.O - 1] = 7;
            } else if (i3 == 7) {
                if (x(false) == -1) {
                    this.J = 17;
                    return 17;
                }
                h();
                this.F--;
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int x6 = x(true);
        if (x6 == 34) {
            if (this.O == 1) {
                h();
            }
            this.J = 9;
            return 9;
        }
        if (x6 == 39) {
            h();
            this.J = 8;
            return 8;
        }
        if (x6 != 44 && x6 != 59) {
            if (x6 == 91) {
                this.J = 3;
                return 3;
            }
            if (x6 != 93) {
                if (x6 == 123) {
                    this.J = 1;
                    return 1;
                }
                this.F--;
                if (this.O == 1) {
                    h();
                }
                int D = D();
                if (D != 0) {
                    return D;
                }
                int E = E();
                if (E != 0) {
                    return E;
                }
                if (!r(this.E[this.F])) {
                    throw N("Expected value");
                }
                h();
                this.J = 10;
                return 10;
            }
            if (i3 == 1) {
                this.J = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw N("Unexpected value");
        }
        h();
        this.F--;
        this.J = 7;
        return 7;
    }

    private boolean m(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.E;
        int i5 = this.I;
        int i6 = this.F;
        this.I = i5 - i6;
        int i7 = this.G;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.G = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.G = 0;
        }
        this.F = 0;
        do {
            Reader reader = this.C;
            int i9 = this.G;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.G + read;
            this.G = i3;
            if (this.H == 0 && (i4 = this.I) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.F++;
                this.I = i4 + 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    public int n() {
        return (this.F - this.I) + 1;
    }

    public int o() {
        return this.H + 1;
    }

    private boolean r(char c2) throws IOException {
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
        h();
        return false;
    }

    private int x(boolean z2) throws IOException {
        char[] cArr = this.E;
        int i2 = this.F;
        int i3 = this.G;
        while (true) {
            if (i2 == i3) {
                this.F = i2;
                if (!m(1)) {
                    if (!z2) {
                        return -1;
                    }
                    throw new EOFException("End of input at line " + o() + " column " + n());
                }
                i2 = this.F;
                i3 = this.G;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.H++;
                this.I = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.F = i4;
                    if (i4 == i3) {
                        this.F = i4 - 1;
                        boolean m2 = m(2);
                        this.F++;
                        if (!m2) {
                            return c2;
                        }
                    }
                    h();
                    int i5 = this.F;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.F = i5 + 1;
                        if (!J("*/")) {
                            throw N("Unterminated comment");
                        }
                        i2 = this.F + 2;
                        i3 = this.G;
                    } else {
                        if (c3 != '/') {
                            return c2;
                        }
                        this.F = i5 + 1;
                        K();
                        i2 = this.F;
                        i3 = this.G;
                    }
                } else {
                    if (c2 != '#') {
                        this.F = i4;
                        return c2;
                    }
                    this.F = i4;
                    h();
                    K();
                    i2 = this.F;
                    i3 = this.G;
                }
            }
            i2 = i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r8.F = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String z(char r9) throws java.io.IOException {
        /*
            r8 = this;
            char[] r0 = r8.E
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
        L7:
            int r2 = r8.F
            int r3 = r8.G
        Lb:
            r4 = r3
            r3 = r2
        Ld:
            r5 = 1
            if (r2 >= r4) goto L46
            int r6 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r9) goto L22
            r8.F = r6
            int r6 = r6 - r3
            int r6 = r6 - r5
            r1.append(r0, r3, r6)
            java.lang.String r9 = r1.toString()
            return r9
        L22:
            r7 = 92
            if (r2 != r7) goto L39
            r8.F = r6
            int r6 = r6 - r3
            int r6 = r6 - r5
            r1.append(r0, r3, r6)
            char r2 = r8.G()
            r1.append(r2)
            int r2 = r8.F
            int r3 = r8.G
            goto Lb
        L39:
            r7 = 10
            if (r2 != r7) goto L44
            int r2 = r8.H
            int r2 = r2 + r5
            r8.H = r2
            r8.I = r6
        L44:
            r2 = r6
            goto Ld
        L46:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r8.F = r2
            boolean r2 = r8.m(r5)
            if (r2 == 0) goto L54
            goto L7
        L54:
            java.lang.String r9 = "Unterminated string"
            java.io.IOException r9 = r8.N(r9)
            goto L5c
        L5b:
            throw r9
        L5c:
            goto L5b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.z(char):java.lang.String");
    }

    public String A() throws IOException {
        String str;
        int i2 = this.J;
        if (i2 == 0) {
            i2 = j();
        }
        if (i2 == 10) {
            str = B();
        } else if (i2 == 8) {
            str = z('\'');
        } else if (i2 == 9) {
            str = z(Typography.quote);
        } else if (i2 == 11) {
            str = this.M;
            this.M = null;
        } else if (i2 == 15) {
            str = Long.toString(this.K);
        } else {
            if (i2 != 16) {
                throw new IllegalStateException("Expected a string but was " + C() + " at line " + o() + " column " + n() + " path " + getPath());
            }
            str = new String(this.E, this.F, this.L);
            this.F += this.L;
        }
        this.J = 0;
        int[] iArr = this.Q;
        int i3 = this.O - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public JsonToken C() throws IOException {
        int i2 = this.J;
        if (i2 == 0) {
            i2 = j();
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

    public final void H(boolean z2) {
        this.D = z2;
    }

    public void M() throws IOException {
        int i2 = 0;
        do {
            int i3 = this.J;
            if (i3 == 0) {
                i3 = j();
            }
            if (i3 == 3) {
                F(1);
            } else if (i3 == 1) {
                F(3);
            } else {
                if (i3 == 4) {
                    this.O--;
                } else if (i3 == 2) {
                    this.O--;
                } else {
                    if (i3 == 14 || i3 == 10) {
                        L();
                    } else if (i3 == 8 || i3 == 12) {
                        I('\'');
                    } else if (i3 == 9 || i3 == 13) {
                        I(Typography.quote);
                    } else if (i3 == 16) {
                        this.F += this.L;
                    }
                    this.J = 0;
                }
                i2--;
                this.J = 0;
            }
            i2++;
            this.J = 0;
        } while (i2 != 0);
        int[] iArr = this.Q;
        int i4 = this.O;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.P[i4 - 1] = "null";
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.J = 0;
        this.N[0] = 8;
        this.O = 1;
        this.C.close();
    }

    public void f() throws IOException {
        int i2 = this.J;
        if (i2 == 0) {
            i2 = j();
        }
        if (i2 == 3) {
            F(1);
            this.Q[this.O - 1] = 0;
            this.J = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + C() + " at line " + o() + " column " + n() + " path " + getPath());
    }

    public void g() throws IOException {
        int i2 = this.J;
        if (i2 == 0) {
            i2 = j();
        }
        if (i2 == 1) {
            F(3);
            this.J = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + C() + " at line " + o() + " column " + n() + " path " + getPath());
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.dollar);
        int i2 = this.O;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.N[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.Q[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.P;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public void k() throws IOException {
        int i2 = this.J;
        if (i2 == 0) {
            i2 = j();
        }
        if (i2 == 4) {
            this.O--;
            this.J = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + C() + " at line " + o() + " column " + n() + " path " + getPath());
    }

    public void l() throws IOException {
        int i2 = this.J;
        if (i2 == 0) {
            i2 = j();
        }
        if (i2 == 2) {
            int i3 = this.O - 1;
            this.O = i3;
            this.P[i3] = null;
            this.J = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + C() + " at line " + o() + " column " + n() + " path " + getPath());
    }

    public boolean p() throws IOException {
        int i2 = this.J;
        if (i2 == 0) {
            i2 = j();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public final boolean q() {
        return this.D;
    }

    public boolean s() throws IOException {
        int i2 = this.J;
        if (i2 == 0) {
            i2 = j();
        }
        if (i2 == 5) {
            this.J = 0;
            int[] iArr = this.Q;
            int i3 = this.O - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        }
        if (i2 == 6) {
            this.J = 0;
            int[] iArr2 = this.Q;
            int i4 = this.O - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + C() + " at line " + o() + " column " + n() + " path " + getPath());
    }

    public double t() throws IOException {
        int i2 = this.J;
        if (i2 == 0) {
            i2 = j();
        }
        if (i2 == 15) {
            this.J = 0;
            int[] iArr = this.Q;
            int i3 = this.O - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.K;
        }
        if (i2 == 16) {
            this.M = new String(this.E, this.F, this.L);
            this.F += this.L;
        } else if (i2 == 8 || i2 == 9) {
            this.M = z(i2 == 8 ? '\'' : Typography.quote);
        } else if (i2 == 10) {
            this.M = B();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + C() + " at line " + o() + " column " + n() + " path " + getPath());
        }
        this.J = 11;
        double parseDouble = Double.parseDouble(this.M);
        if (this.D || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            this.M = null;
            this.J = 0;
            int[] iArr2 = this.Q;
            int i4 = this.O - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + " at line " + o() + " column " + n() + " path " + getPath());
    }

    public String toString() {
        return getClass().getSimpleName() + " at line " + o() + " column " + n();
    }

    public int u() throws IOException {
        int i2 = this.J;
        if (i2 == 0) {
            i2 = j();
        }
        if (i2 == 15) {
            long j2 = this.K;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.J = 0;
                int[] iArr = this.Q;
                int i4 = this.O - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.K + " at line " + o() + " column " + n() + " path " + getPath());
        }
        if (i2 == 16) {
            this.M = new String(this.E, this.F, this.L);
            this.F += this.L;
        } else {
            if (i2 != 8 && i2 != 9) {
                throw new IllegalStateException("Expected an int but was " + C() + " at line " + o() + " column " + n() + " path " + getPath());
            }
            String z2 = z(i2 == 8 ? '\'' : Typography.quote);
            this.M = z2;
            try {
                int parseInt = Integer.parseInt(z2);
                this.J = 0;
                int[] iArr2 = this.Q;
                int i5 = this.O - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.J = 11;
        double parseDouble = Double.parseDouble(this.M);
        int i6 = (int) parseDouble;
        if (i6 == parseDouble) {
            this.M = null;
            this.J = 0;
            int[] iArr3 = this.Q;
            int i7 = this.O - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.M + " at line " + o() + " column " + n() + " path " + getPath());
    }

    public long v() throws IOException {
        int i2 = this.J;
        if (i2 == 0) {
            i2 = j();
        }
        if (i2 == 15) {
            this.J = 0;
            int[] iArr = this.Q;
            int i3 = this.O - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.K;
        }
        if (i2 == 16) {
            this.M = new String(this.E, this.F, this.L);
            this.F += this.L;
        } else {
            if (i2 != 8 && i2 != 9) {
                throw new IllegalStateException("Expected a long but was " + C() + " at line " + o() + " column " + n() + " path " + getPath());
            }
            String z2 = z(i2 == 8 ? '\'' : Typography.quote);
            this.M = z2;
            try {
                long parseLong = Long.parseLong(z2);
                this.J = 0;
                int[] iArr2 = this.Q;
                int i4 = this.O - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.J = 11;
        double parseDouble = Double.parseDouble(this.M);
        long j2 = (long) parseDouble;
        if (j2 == parseDouble) {
            this.M = null;
            this.J = 0;
            int[] iArr3 = this.Q;
            int i5 = this.O - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.M + " at line " + o() + " column " + n() + " path " + getPath());
    }

    public String w() throws IOException {
        String z2;
        int i2 = this.J;
        if (i2 == 0) {
            i2 = j();
        }
        if (i2 == 14) {
            z2 = B();
        } else if (i2 == 12) {
            z2 = z('\'');
        } else {
            if (i2 != 13) {
                throw new IllegalStateException("Expected a name but was " + C() + " at line " + o() + " column " + n() + " path " + getPath());
            }
            z2 = z(Typography.quote);
        }
        this.J = 0;
        this.P[this.O - 1] = z2;
        return z2;
    }

    public void y() throws IOException {
        int i2 = this.J;
        if (i2 == 0) {
            i2 = j();
        }
        if (i2 == 7) {
            this.J = 0;
            int[] iArr = this.Q;
            int i3 = this.O - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + C() + " at line " + o() + " column " + n() + " path " + getPath());
    }
}
