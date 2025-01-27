package com.bytedance.sdk.openadsdk.api.plugin.j;

import com.vivo.ic.dm.Downloads;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
final class zx {

    /* renamed from: g, reason: collision with root package name */
    private int f6431g;
    private int gv;

    /* renamed from: i, reason: collision with root package name */
    private int f6432i;

    /* renamed from: j, reason: collision with root package name */
    private final String f6433j;
    private char[] lg;
    private int q;
    private final int zx;

    zx(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f6433j = name;
        this.zx = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a3, code lost:
    
        return new java.lang.String(r1, r2, r8.gv - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String g() {
        /*
            r8 = this;
            int r0 = r8.f6432i
            r8.f6431g = r0
            r8.q = r0
        L6:
            int r0 = r8.f6432i
            int r1 = r8.zx
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.lg
            int r2 = r8.f6431g
            int r3 = r8.q
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.lg
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L60
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.q
            int r3 = r2 + 1
            r8.q = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f6432i = r0
            goto L6
        L40:
            int r0 = r8.q
            int r2 = r0 + 1
            r8.q = r2
            char r2 = r8.q()
            r1[r0] = r2
            int r0 = r8.f6432i
            int r0 = r0 + 1
            r8.f6432i = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.lg
            int r2 = r8.f6431g
            int r3 = r8.q
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L60:
            int r2 = r8.q
            r8.gv = r2
            int r0 = r0 + 1
            r8.f6432i = r0
            int r0 = r2 + 1
            r8.q = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.f6432i
            int r1 = r8.zx
            if (r0 >= r1) goto L87
            char[] r2 = r8.lg
            char r7 = r2[r0]
            if (r7 != r6) goto L87
            int r1 = r8.q
            int r7 = r1 + 1
            r8.q = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f6432i = r0
            goto L6e
        L87:
            if (r0 == r1) goto L97
            char[] r1 = r8.lg
            char r2 = r1[r0]
            if (r2 == r3) goto L97
            char r2 = r1[r0]
            if (r2 == r4) goto L97
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L97:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.lg
            int r2 = r8.f6431g
            int r3 = r8.gv
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.j.zx.g():java.lang.String");
    }

    private char gv() {
        int i2;
        int i3;
        int j2 = j(this.f6432i);
        this.f6432i++;
        if (j2 < 128) {
            return (char) j2;
        }
        if (j2 < 192 || j2 > 247) {
            return '?';
        }
        if (j2 <= 223) {
            i3 = j2 & 31;
            i2 = 1;
        } else if (j2 <= 239) {
            i2 = 2;
            i3 = j2 & 15;
        } else {
            i2 = 3;
            i3 = j2 & 7;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.f6432i + 1;
            this.f6432i = i5;
            if (i5 == this.zx || this.lg[i5] != '\\') {
                return '?';
            }
            int i6 = i5 + 1;
            this.f6432i = i6;
            int j3 = j(i6);
            this.f6432i++;
            if ((j3 & Downloads.Impl.STATUS_RUNNING) != 128) {
                return '?';
            }
            i3 = (i3 << 6) + (j3 & 63);
        }
        return (char) i3;
    }

    private String i() {
        int i2;
        int i3 = this.f6432i;
        if (i3 + 4 >= this.zx) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f6433j);
        }
        this.f6431g = i3;
        this.f6432i = i3 + 1;
        while (true) {
            i2 = this.f6432i;
            if (i2 == this.zx) {
                break;
            }
            char[] cArr = this.lg;
            if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                break;
            }
            if (cArr[i2] == ' ') {
                this.q = i2;
                this.f6432i = i2 + 1;
                while (true) {
                    int i4 = this.f6432i;
                    if (i4 >= this.zx || this.lg[i4] != ' ') {
                        break;
                    }
                    this.f6432i = i4 + 1;
                }
            } else {
                if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                    cArr[i2] = (char) (cArr[i2] + ' ');
                }
                this.f6432i = i2 + 1;
            }
        }
        this.q = i2;
        int i5 = this.q;
        int i6 = this.f6431g;
        int i7 = i5 - i6;
        if (i7 < 5 || (i7 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f6433j);
        }
        int i8 = i7 / 2;
        byte[] bArr = new byte[i8];
        int i9 = i6 + 1;
        for (int i10 = 0; i10 < i8; i10++) {
            bArr[i10] = (byte) j(i9);
            i9 += 2;
        }
        return new String(this.lg, this.f6431g, i7);
    }

    private String j() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        while (true) {
            i2 = this.f6432i;
            i3 = this.zx;
            if (i2 >= i3 || this.lg[i2] != ' ') {
                break;
            }
            this.f6432i = i2 + 1;
        }
        if (i2 == i3) {
            return null;
        }
        this.f6431g = i2;
        this.f6432i = i2 + 1;
        while (true) {
            i4 = this.f6432i;
            i5 = this.zx;
            if (i4 >= i5) {
                break;
            }
            char[] cArr = this.lg;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.f6432i = i4 + 1;
        }
        if (i4 >= i5) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f6433j);
        }
        this.q = i4;
        if (this.lg[i4] == ' ') {
            while (true) {
                i6 = this.f6432i;
                i7 = this.zx;
                if (i6 >= i7) {
                    break;
                }
                char[] cArr2 = this.lg;
                if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                    break;
                }
                this.f6432i = i6 + 1;
            }
            if (this.lg[i6] != '=' || i6 == i7) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f6433j);
            }
        }
        this.f6432i++;
        while (true) {
            int i8 = this.f6432i;
            if (i8 >= this.zx || this.lg[i8] != ' ') {
                break;
            }
            this.f6432i = i8 + 1;
        }
        int i9 = this.q;
        int i10 = this.f6431g;
        if (i9 - i10 > 4) {
            char[] cArr3 = this.lg;
            if (cArr3[i10 + 3] == '.' && ((cArr3[i10] == 'O' || cArr3[i10] == 'o') && ((cArr3[i10 + 1] == 'I' || cArr3[i10 + 1] == 'i') && (cArr3[i10 + 2] == 'D' || cArr3[i10 + 2] == 'd')))) {
                this.f6431g = i10 + 4;
            }
        }
        char[] cArr4 = this.lg;
        int i11 = this.f6431g;
        return new String(cArr4, i11, this.q - i11);
    }

    private char q() {
        int i2 = this.f6432i + 1;
        this.f6432i = i2;
        if (i2 == this.zx) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f6433j);
        }
        char[] cArr = this.lg;
        char c2 = cArr[i2];
        if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
            switch (c2) {
                case '*':
                case '+':
                case ',':
                    break;
                default:
                    switch (c2) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return gv();
                    }
            }
        }
        return cArr[i2];
    }

    private String zx() {
        int i2 = this.f6432i + 1;
        this.f6432i = i2;
        this.f6431g = i2;
        this.q = i2;
        while (true) {
            int i3 = this.f6432i;
            if (i3 == this.zx) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f6433j);
            }
            char[] cArr = this.lg;
            if (cArr[i3] == '\"') {
                this.f6432i = i3 + 1;
                while (true) {
                    int i4 = this.f6432i;
                    if (i4 >= this.zx || this.lg[i4] != ' ') {
                        break;
                    }
                    this.f6432i = i4 + 1;
                }
                char[] cArr2 = this.lg;
                int i5 = this.f6431g;
                return new String(cArr2, i5, this.q - i5);
            }
            if (cArr[i3] == '\\') {
                cArr[this.q] = q();
            } else {
                cArr[this.q] = cArr[i3];
            }
            this.f6432i++;
            this.q++;
        }
    }

    private int j(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.zx) {
            char[] cArr = this.lg;
            char c2 = cArr[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else {
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f6433j);
                }
                i3 = c2 - '7';
            }
            char c3 = cArr[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else {
                if (c3 < 'A' || c3 > 'F') {
                    throw new IllegalStateException("Malformed DN: " + this.f6433j);
                }
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        throw new IllegalStateException("Malformed DN: " + this.f6433j);
    }

    public String j(String str) {
        String zx;
        this.f6432i = 0;
        this.f6431g = 0;
        this.q = 0;
        this.gv = 0;
        this.lg = this.f6433j.toCharArray();
        String j2 = j();
        if (j2 == null) {
            return null;
        }
        do {
            int i2 = this.f6432i;
            if (i2 == this.zx) {
                return null;
            }
            char c2 = this.lg[i2];
            if (c2 == '\"') {
                zx = zx();
            } else if (c2 != '#') {
                zx = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : g();
            } else {
                zx = i();
            }
            if (str.equalsIgnoreCase(j2)) {
                return zx;
            }
            int i3 = this.f6432i;
            if (i3 >= this.zx) {
                return null;
            }
            char[] cArr = this.lg;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f6433j);
            }
            this.f6432i = i3 + 1;
            j2 = j();
        } while (j2 != null);
        throw new IllegalStateException("Malformed DN: " + this.f6433j);
    }
}
