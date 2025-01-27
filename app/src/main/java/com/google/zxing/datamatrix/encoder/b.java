package com.google.zxing.datamatrix.encoder;

/* loaded from: classes.dex */
final class b implements g {
    b() {
    }

    private static char c(char c2, int i2) {
        int i3 = c2 + ((i2 * 149) % 255) + 1;
        return i3 <= 255 ? (char) i3 : (char) (i3 - 256);
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!hVar.j()) {
                break;
            }
            sb.append(hVar.d());
            hVar.f8398f++;
            int o = j.o(hVar.e(), hVar.f8398f, b());
            if (o != b()) {
                hVar.p(o);
                break;
            }
        }
        int length = sb.length() - 1;
        int a2 = hVar.a() + length + 1;
        hVar.r(a2);
        boolean z = hVar.h().b() - a2 > 0;
        if (hVar.j() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else {
                if (length > 1555) {
                    throw new IllegalStateException("Message length not in valid ranges: " + length);
                }
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            }
        }
        int length2 = sb.length();
        for (int i2 = 0; i2 < length2; i2++) {
            hVar.s(c(sb.charAt(i2), hVar.a() + 1));
        }
    }

    @Override // com.google.zxing.datamatrix.encoder.g
    public int b() {
        return 5;
    }
}
