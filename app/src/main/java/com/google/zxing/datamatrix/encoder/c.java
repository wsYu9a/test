package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
class c implements g {
    c() {
    }

    private int c(h hVar, StringBuilder sb, StringBuilder sb2, int i2) {
        int length = sb.length();
        sb.delete(length - i2, length);
        hVar.f8398f--;
        int d2 = d(hVar.d(), sb2);
        hVar.l();
        return d2;
    }

    private static String e(CharSequence charSequence, int i2) {
        int charAt = (charSequence.charAt(i2) * 1600) + (charSequence.charAt(i2 + 1) * '(') + charSequence.charAt(i2 + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }

    static void g(h hVar, StringBuilder sb) {
        hVar.t(e(sb, 0));
        sb.delete(0, 3);
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        int o;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.j()) {
                break;
            }
            char d2 = hVar.d();
            hVar.f8398f++;
            int d3 = d(d2, sb);
            int a2 = hVar.a() + ((sb.length() / 3) << 1);
            hVar.r(a2);
            int b2 = hVar.h().b() - a2;
            if (!hVar.j()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (b2 < 2 || b2 > 2)) {
                    d3 = c(hVar, sb, sb2, d3);
                }
                while (sb.length() % 3 == 1 && ((d3 <= 3 && b2 != 1) || d3 > 3)) {
                    d3 = c(hVar, sb, sb2, d3);
                }
            } else if (sb.length() % 3 == 0 && (o = j.o(hVar.e(), hVar.f8398f, b())) != b()) {
                hVar.p(o);
                break;
            }
        }
        f(hVar, sb);
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public int b() {
        return 1;
    }

    int d(char c2, StringBuilder sb) {
        if (c2 == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
            return 1;
        }
        if (c2 >= 'A' && c2 <= 'Z') {
            sb.append((char) ((c2 - 'A') + 14));
            return 1;
        }
        if (c2 >= 0 && c2 <= 31) {
            sb.append((char) 0);
            sb.append(c2);
            return 2;
        }
        if (c2 >= '!' && c2 <= '/') {
            sb.append((char) 1);
            sb.append((char) (c2 - '!'));
            return 2;
        }
        if (c2 >= ':' && c2 <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c2 - ':') + 15));
            return 2;
        }
        if (c2 >= '[' && c2 <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c2 - '[') + 22));
            return 2;
        }
        if (c2 >= '`' && c2 <= 127) {
            sb.append((char) 2);
            sb.append((char) (c2 - '`'));
            return 2;
        }
        if (c2 >= 128) {
            sb.append("\u0001\u001e");
            return d((char) (c2 - 128), sb) + 2;
        }
        throw new IllegalArgumentException("Illegal character: " + c2);
    }

    void f(h hVar, StringBuilder sb) {
        int length = (sb.length() / 3) << 1;
        int length2 = sb.length() % 3;
        int a2 = hVar.a() + length;
        hVar.r(a2);
        int b2 = hVar.h().b() - a2;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (hVar.j()) {
                hVar.s((char) 254);
            }
        } else if (b2 == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (hVar.j()) {
                hVar.s((char) 254);
            }
            hVar.f8398f--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb.length() >= 3) {
                g(hVar, sb);
            }
            if (b2 > 0 || hVar.j()) {
                hVar.s((char) 254);
            }
        }
        hVar.p(0);
    }
}
