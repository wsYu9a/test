package com.bytedance.sdk.openadsdk.api.plugin.b;

import javax.security.auth.x500.X500Principal;

/* loaded from: classes2.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f8045a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8046b;

    /* renamed from: c, reason: collision with root package name */
    private int f8047c;

    /* renamed from: d, reason: collision with root package name */
    private int f8048d;

    /* renamed from: e, reason: collision with root package name */
    private int f8049e;

    /* renamed from: f, reason: collision with root package name */
    private int f8050f;

    /* renamed from: g, reason: collision with root package name */
    private char[] f8051g;

    public b(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f8045a = name;
        this.f8046b = name.length();
    }

    private String a() {
        int i10;
        int i11;
        int i12;
        int i13;
        char c10;
        int i14;
        int i15;
        char c11;
        char c12;
        while (true) {
            i10 = this.f8047c;
            i11 = this.f8046b;
            if (i10 >= i11 || this.f8051g[i10] != ' ') {
                break;
            }
            this.f8047c = i10 + 1;
        }
        if (i10 == i11) {
            return null;
        }
        this.f8048d = i10;
        this.f8047c = i10 + 1;
        while (true) {
            i12 = this.f8047c;
            i13 = this.f8046b;
            if (i12 >= i13 || (c12 = this.f8051g[i12]) == '=' || c12 == ' ') {
                break;
            }
            this.f8047c = i12 + 1;
        }
        if (i12 >= i13) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f8045a);
        }
        this.f8049e = i12;
        if (this.f8051g[i12] == ' ') {
            while (true) {
                i14 = this.f8047c;
                i15 = this.f8046b;
                if (i14 >= i15 || (c11 = this.f8051g[i14]) == '=' || c11 != ' ') {
                    break;
                }
                this.f8047c = i14 + 1;
            }
            if (this.f8051g[i14] != '=' || i14 == i15) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f8045a);
            }
        }
        this.f8047c++;
        while (true) {
            int i16 = this.f8047c;
            if (i16 >= this.f8046b || this.f8051g[i16] != ' ') {
                break;
            }
            this.f8047c = i16 + 1;
        }
        int i17 = this.f8049e;
        int i18 = this.f8048d;
        if (i17 - i18 > 4) {
            char[] cArr = this.f8051g;
            if (cArr[i18 + 3] == '.' && (((c10 = cArr[i18]) == 'O' || c10 == 'o') && ((cArr[i18 + 1] == 'I' || cArr[i18 + 1] == 'i') && (cArr[i18 + 2] == 'D' || cArr[i18 + 2] == 'd')))) {
                this.f8048d = i18 + 4;
            }
        }
        char[] cArr2 = this.f8051g;
        int i19 = this.f8048d;
        return new String(cArr2, i19, i17 - i19);
    }

    private String b() {
        int i10 = this.f8047c + 1;
        this.f8047c = i10;
        this.f8048d = i10;
        this.f8049e = i10;
        while (true) {
            int i11 = this.f8047c;
            if (i11 == this.f8046b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f8045a);
            }
            char[] cArr = this.f8051g;
            char c10 = cArr[i11];
            if (c10 == '\"') {
                this.f8047c = i11 + 1;
                while (true) {
                    int i12 = this.f8047c;
                    if (i12 >= this.f8046b || this.f8051g[i12] != ' ') {
                        break;
                    }
                    this.f8047c = i12 + 1;
                }
                char[] cArr2 = this.f8051g;
                int i13 = this.f8048d;
                return new String(cArr2, i13, this.f8049e - i13);
            }
            if (c10 == '\\') {
                cArr[this.f8049e] = e();
            } else {
                cArr[this.f8049e] = c10;
            }
            this.f8047c++;
            this.f8049e++;
        }
    }

    private String c() {
        int i10;
        char[] cArr;
        char c10;
        int i11 = this.f8047c;
        if (i11 + 4 >= this.f8046b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f8045a);
        }
        this.f8048d = i11;
        this.f8047c = i11 + 1;
        while (true) {
            i10 = this.f8047c;
            if (i10 == this.f8046b || (c10 = (cArr = this.f8051g)[i10]) == '+' || c10 == ',' || c10 == ';') {
                break;
            }
            if (c10 == ' ') {
                this.f8049e = i10;
                this.f8047c = i10 + 1;
                while (true) {
                    int i12 = this.f8047c;
                    if (i12 >= this.f8046b || this.f8051g[i12] != ' ') {
                        break;
                    }
                    this.f8047c = i12 + 1;
                }
            } else {
                if (c10 >= 'A' && c10 <= 'F') {
                    cArr[i10] = (char) (c10 + b5.a.O);
                }
                this.f8047c = i10 + 1;
            }
        }
        this.f8049e = i10;
        int i13 = this.f8049e;
        int i14 = this.f8048d;
        int i15 = i13 - i14;
        if (i15 < 5 || (i15 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f8045a);
        }
        int i16 = i15 / 2;
        byte[] bArr = new byte[i16];
        int i17 = i14 + 1;
        for (int i18 = 0; i18 < i16; i18++) {
            bArr[i18] = (byte) a(i17);
            i17 += 2;
        }
        return new String(this.f8051g, this.f8048d, i15);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x009b, code lost:
    
        return new java.lang.String(r1, r2, r8.f8050f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d() {
        /*
            r8 = this;
            int r0 = r8.f8047c
            r8.f8048d = r0
            r8.f8049e = r0
        L6:
            int r0 = r8.f8047c
            int r1 = r8.f8046b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f8051g
            int r2 = r8.f8048d
            int r3 = r8.f8049e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f8051g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5c
            if (r2 == r5) goto L51
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            int r3 = r8.f8049e
            int r4 = r3 + 1
            r8.f8049e = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.f8047c = r0
            goto L6
        L3e:
            int r0 = r8.f8049e
            int r2 = r0 + 1
            r8.f8049e = r2
            char r2 = r8.e()
            r1[r0] = r2
            int r0 = r8.f8047c
            int r0 = r0 + 1
            r8.f8047c = r0
            goto L6
        L51:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f8048d
            int r3 = r8.f8049e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L5c:
            int r2 = r8.f8049e
            r8.f8050f = r2
            int r0 = r0 + 1
            r8.f8047c = r0
            int r0 = r2 + 1
            r8.f8049e = r0
            r1[r2] = r6
        L6a:
            int r0 = r8.f8047c
            int r1 = r8.f8046b
            if (r0 >= r1) goto L83
            char[] r2 = r8.f8051g
            char r7 = r2[r0]
            if (r7 != r6) goto L83
            int r1 = r8.f8049e
            int r7 = r1 + 1
            r8.f8049e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f8047c = r0
            goto L6a
        L83:
            if (r0 == r1) goto L8f
            char[] r1 = r8.f8051g
            char r0 = r1[r0]
            if (r0 == r3) goto L8f
            if (r0 == r4) goto L8f
            if (r0 != r5) goto L6
        L8f:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f8051g
            int r2 = r8.f8048d
            int r3 = r8.f8050f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.b.b.d():java.lang.String");
    }

    private char e() {
        int i10 = this.f8047c + 1;
        this.f8047c = i10;
        if (i10 == this.f8046b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f8045a);
        }
        char c10 = this.f8051g[i10];
        if (c10 == ' ' || c10 == '%' || c10 == '\\' || c10 == '_' || c10 == '\"' || c10 == '#') {
            return c10;
        }
        switch (c10) {
            case '*':
            case '+':
            case ',':
                return c10;
            default:
                switch (c10) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c10;
                    default:
                        return f();
                }
        }
    }

    private char f() {
        int i10;
        int i11;
        int a10 = a(this.f8047c);
        this.f8047c++;
        if (a10 < 128) {
            return (char) a10;
        }
        if (a10 < 192 || a10 > 247) {
            return '?';
        }
        if (a10 <= 223) {
            i10 = a10 & 31;
            i11 = 1;
        } else if (a10 <= 239) {
            i10 = a10 & 15;
            i11 = 2;
        } else {
            i10 = a10 & 7;
            i11 = 3;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.f8047c;
            int i14 = i13 + 1;
            this.f8047c = i14;
            if (i14 == this.f8046b || this.f8051g[i14] != '\\') {
                return '?';
            }
            int i15 = i13 + 2;
            this.f8047c = i15;
            int a11 = a(i15);
            this.f8047c++;
            if ((a11 & 192) != 128) {
                return '?';
            }
            i10 = (i10 << 6) + (a11 & 63);
        }
        return (char) i10;
    }

    private int a(int i10) {
        int i11;
        int i12;
        int i13 = i10 + 1;
        if (i13 < this.f8046b) {
            char[] cArr = this.f8051g;
            char c10 = cArr[i10];
            if (c10 >= '0' && c10 <= '9') {
                i11 = c10 - '0';
            } else if (c10 >= 'a' && c10 <= 'f') {
                i11 = c10 - 'W';
            } else {
                if (c10 < 'A' || c10 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f8045a);
                }
                i11 = c10 - '7';
            }
            char c11 = cArr[i13];
            if (c11 >= '0' && c11 <= '9') {
                i12 = c11 - '0';
            } else if (c11 >= 'a' && c11 <= 'f') {
                i12 = c11 - 'W';
            } else {
                if (c11 < 'A' || c11 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f8045a);
                }
                i12 = c11 - '7';
            }
            return (i11 << 4) + i12;
        }
        throw new IllegalStateException("Malformed DN: " + this.f8045a);
    }

    public String a(String str) {
        String b10;
        this.f8047c = 0;
        this.f8048d = 0;
        this.f8049e = 0;
        this.f8050f = 0;
        this.f8051g = this.f8045a.toCharArray();
        String a10 = a();
        if (a10 == null) {
            return null;
        }
        do {
            int i10 = this.f8047c;
            if (i10 == this.f8046b) {
                return null;
            }
            char c10 = this.f8051g[i10];
            if (c10 == '\"') {
                b10 = b();
            } else if (c10 == '#') {
                b10 = c();
            } else if (c10 != '+' && c10 != ',' && c10 != ';') {
                b10 = d();
            } else {
                b10 = "";
            }
            if (str.equalsIgnoreCase(a10)) {
                return b10;
            }
            int i11 = this.f8047c;
            if (i11 >= this.f8046b) {
                return null;
            }
            char c11 = this.f8051g[i11];
            if (c11 != ',' && c11 != ';' && c11 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f8045a);
            }
            this.f8047c = i11 + 1;
            a10 = a();
        } while (a10 != null);
        throw new IllegalStateException("Malformed DN: " + this.f8045a);
    }
}
