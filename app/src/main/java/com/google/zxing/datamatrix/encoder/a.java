package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
final class a implements g {
    a() {
    }

    private static char c(char c2, char c3) {
        if (j.g(c2) && j.g(c3)) {
            return (char) (((c2 - '0') * 10) + (c3 - '0') + org.mozilla.universalchardet.prober.n.c.m);
        }
        throw new IllegalArgumentException("not digits: " + c2 + c3);
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        if (j.a(hVar.e(), hVar.f8398f) >= 2) {
            hVar.s(c(hVar.e().charAt(hVar.f8398f), hVar.e().charAt(hVar.f8398f + 1)));
            hVar.f8398f += 2;
            return;
        }
        char d2 = hVar.d();
        int o = j.o(hVar.e(), hVar.f8398f, b());
        if (o == b()) {
            if (!j.h(d2)) {
                hVar.s((char) (d2 + 1));
                hVar.f8398f++;
                return;
            } else {
                hVar.s((char) 235);
                hVar.s((char) ((d2 - 128) + 1));
                hVar.f8398f++;
                return;
            }
        }
        if (o == 1) {
            hVar.s((char) 230);
            hVar.p(1);
            return;
        }
        if (o == 2) {
            hVar.s((char) 239);
            hVar.p(2);
            return;
        }
        if (o == 3) {
            hVar.s((char) 238);
            hVar.p(3);
        } else if (o == 4) {
            hVar.s((char) 240);
            hVar.p(4);
        } else if (o == 5) {
            hVar.s((char) 231);
            hVar.p(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + o);
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public int b() {
        return 0;
    }
}
