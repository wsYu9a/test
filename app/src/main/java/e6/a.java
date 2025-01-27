package e6;

/* loaded from: classes2.dex */
public final class a implements g {
    public static char c(char c10, char c11) {
        if (j.g(c10) && j.g(c11)) {
            return (char) (((c10 - '0') * 10) + (c11 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c10 + c11);
    }

    @Override // e6.g
    public void a(h hVar) {
        if (j.a(hVar.e(), hVar.f25718f) >= 2) {
            hVar.s(c(hVar.e().charAt(hVar.f25718f), hVar.e().charAt(hVar.f25718f + 1)));
            hVar.f25718f += 2;
            return;
        }
        char d10 = hVar.d();
        int o10 = j.o(hVar.e(), hVar.f25718f, b());
        if (o10 == b()) {
            if (!j.h(d10)) {
                hVar.s((char) (d10 + 1));
                hVar.f25718f++;
                return;
            } else {
                hVar.s(j.f25730d);
                hVar.s((char) (d10 - 127));
                hVar.f25718f++;
                return;
            }
        }
        if (o10 == 1) {
            hVar.s(j.f25728b);
            hVar.p(1);
            return;
        }
        if (o10 == 2) {
            hVar.s(j.f25734h);
            hVar.p(2);
            return;
        }
        if (o10 == 3) {
            hVar.s(j.f25733g);
            hVar.p(3);
        } else if (o10 == 4) {
            hVar.s(j.f25735i);
            hVar.p(4);
        } else if (o10 == 5) {
            hVar.s(j.f25729c);
            hVar.p(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + o10);
        }
    }

    @Override // e6.g
    public int b() {
        return 0;
    }
}
