package e6;

/* loaded from: classes2.dex */
public final class f implements g {
    public static void c(char c10, StringBuilder sb2) {
        if (c10 >= ' ' && c10 <= '?') {
            sb2.append(c10);
        } else if (c10 < '@' || c10 > '^') {
            j.f(c10);
        } else {
            sb2.append((char) (c10 - '@'));
        }
    }

    private static String d(CharSequence charSequence, int i10) {
        int length = charSequence.length() - i10;
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int charAt = (charSequence.charAt(i10) << 18) + ((length >= 2 ? charSequence.charAt(i10 + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i10 + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i10 + 3) : (char) 0);
        char c10 = (char) ((charAt >> 16) & 255);
        char c11 = (char) ((charAt >> 8) & 255);
        char c12 = (char) (charAt & 255);
        StringBuilder sb2 = new StringBuilder(3);
        sb2.append(c10);
        if (length >= 2) {
            sb2.append(c11);
        }
        if (length >= 3) {
            sb2.append(c12);
        }
        return sb2.toString();
    }

    public static void e(h hVar, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z10 = true;
            if (length == 1) {
                hVar.q();
                int b10 = hVar.h().b() - hVar.a();
                if (hVar.g() == 0 && b10 <= 2) {
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i10 = length - 1;
            String d10 = d(charSequence, 0);
            if (!(!hVar.j()) || i10 > 2) {
                z10 = false;
            }
            if (i10 <= 2) {
                hVar.r(hVar.a() + i10);
                if (hVar.h().b() - hVar.a() >= 3) {
                    hVar.r(hVar.a() + d10.length());
                    z10 = false;
                }
            }
            if (z10) {
                hVar.l();
                hVar.f25718f -= i10;
            } else {
                hVar.t(d10);
            }
        } finally {
            hVar.p(0);
        }
    }

    @Override // e6.g
    public void a(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!hVar.j()) {
                break;
            }
            c(hVar.d(), sb2);
            hVar.f25718f++;
            if (sb2.length() >= 4) {
                hVar.t(d(sb2, 0));
                sb2.delete(0, 4);
                if (j.o(hVar.e(), hVar.f25718f, b()) != b()) {
                    hVar.p(0);
                    break;
                }
            }
        }
        sb2.append(r5.c.f30310b);
        e(hVar, sb2);
    }

    @Override // e6.g
    public int b() {
        return 4;
    }
}
