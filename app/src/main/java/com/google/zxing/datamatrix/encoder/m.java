package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
final class m extends c {
    m() {
    }

    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!hVar.j()) {
                break;
            }
            char d2 = hVar.d();
            hVar.f8398f++;
            d(d2, sb);
            if (sb.length() % 3 == 0) {
                c.g(hVar, sb);
                int o = j.o(hVar.e(), hVar.f8398f, b());
                if (o != b()) {
                    hVar.p(o);
                    break;
                }
            }
        }
        f(hVar, sb);
    }

    @Override // com.google.zxing.datamatrix.encoder.c, com.google.zxing.datamatrix.encoder.g
    public int b() {
        return 3;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    int d(char c2, StringBuilder sb) {
        if (c2 == '\r') {
            sb.append((char) 0);
        } else if (c2 == '*') {
            sb.append((char) 1);
        } else if (c2 == '>') {
            sb.append((char) 2);
        } else if (c2 == ' ') {
            sb.append((char) 3);
        } else if (c2 >= '0' && c2 <= '9') {
            sb.append((char) ((c2 - '0') + 4));
        } else if (c2 < 'A' || c2 > 'Z') {
            j.f(c2);
        } else {
            sb.append((char) ((c2 - 'A') + 14));
        }
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.c
    void f(h hVar, StringBuilder sb) {
        hVar.q();
        int b2 = hVar.h().b() - hVar.a();
        hVar.f8398f -= sb.length();
        if (hVar.g() > 1 || b2 > 1 || hVar.g() != b2) {
            hVar.s((char) 254);
        }
        if (hVar.f() < 0) {
            hVar.p(0);
        }
    }
}
