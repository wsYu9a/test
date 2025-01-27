package e6;

/* loaded from: classes2.dex */
public final class m extends c {
    @Override // e6.c, e6.g
    public void a(h hVar) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!hVar.j()) {
                break;
            }
            char d10 = hVar.d();
            hVar.f25718f++;
            d(d10, sb2);
            if (sb2.length() % 3 == 0) {
                c.g(hVar, sb2);
                int o10 = j.o(hVar.e(), hVar.f25718f, b());
                if (o10 != b()) {
                    hVar.p(o10);
                    break;
                }
            }
        }
        f(hVar, sb2);
    }

    @Override // e6.c, e6.g
    public int b() {
        return 3;
    }

    @Override // e6.c
    public int d(char c10, StringBuilder sb2) {
        if (c10 == '\r') {
            sb2.append((char) 0);
        } else if (c10 == '*') {
            sb2.append((char) 1);
        } else if (c10 == '>') {
            sb2.append((char) 2);
        } else if (c10 == ' ') {
            sb2.append((char) 3);
        } else if (c10 >= '0' && c10 <= '9') {
            sb2.append((char) (c10 - ','));
        } else if (c10 < 'A' || c10 > 'Z') {
            j.f(c10);
        } else {
            sb2.append((char) (c10 - '3'));
        }
        return 1;
    }

    @Override // e6.c
    public void f(h hVar, StringBuilder sb2) {
        hVar.q();
        int b10 = hVar.h().b() - hVar.a();
        hVar.f25718f -= sb2.length();
        if (hVar.g() > 1 || b10 > 1 || hVar.g() != b10) {
            hVar.s((char) 254);
        }
        if (hVar.f() < 0) {
            hVar.p(0);
        }
    }
}
