package e6;

/* loaded from: classes2.dex */
public class c implements g {
    public static String e(CharSequence charSequence, int i10) {
        int charAt = (charSequence.charAt(i10) * 1600) + (charSequence.charAt(i10 + 1) * '(') + charSequence.charAt(i10 + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }

    public static void g(h hVar, StringBuilder sb2) {
        hVar.t(e(sb2, 0));
        sb2.delete(0, 3);
    }

    @Override // e6.g
    public void a(h hVar) {
        int o10;
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!hVar.j()) {
                break;
            }
            char d10 = hVar.d();
            hVar.f25718f++;
            int d11 = d(d10, sb2);
            int a10 = hVar.a() + ((sb2.length() / 3) << 1);
            hVar.r(a10);
            int b10 = hVar.h().b() - a10;
            if (!hVar.j()) {
                StringBuilder sb3 = new StringBuilder();
                if (sb2.length() % 3 == 2 && (b10 < 2 || b10 > 2)) {
                    d11 = c(hVar, sb2, sb3, d11);
                }
                while (sb2.length() % 3 == 1 && ((d11 <= 3 && b10 != 1) || d11 > 3)) {
                    d11 = c(hVar, sb2, sb3, d11);
                }
            } else if (sb2.length() % 3 == 0 && (o10 = j.o(hVar.e(), hVar.f25718f, b())) != b()) {
                hVar.p(o10);
                break;
            }
        }
        f(hVar, sb2);
    }

    @Override // e6.g
    public int b() {
        return 1;
    }

    public final int c(h hVar, StringBuilder sb2, StringBuilder sb3, int i10) {
        int length = sb2.length();
        sb2.delete(length - i10, length);
        hVar.f25718f--;
        int d10 = d(hVar.d(), sb3);
        hVar.l();
        return d10;
    }

    public int d(char c10, StringBuilder sb2) {
        if (c10 == ' ') {
            sb2.append((char) 3);
            return 1;
        }
        if (c10 >= '0' && c10 <= '9') {
            sb2.append((char) (c10 - ','));
            return 1;
        }
        if (c10 >= 'A' && c10 <= 'Z') {
            sb2.append((char) (c10 - '3'));
            return 1;
        }
        if (c10 >= 0 && c10 <= 31) {
            sb2.append((char) 0);
            sb2.append(c10);
            return 2;
        }
        if (c10 >= '!' && c10 <= '/') {
            sb2.append((char) 1);
            sb2.append((char) (c10 - '!'));
            return 2;
        }
        if (c10 >= ':' && c10 <= '@') {
            sb2.append((char) 1);
            sb2.append((char) (c10 - '+'));
            return 2;
        }
        if (c10 >= '[' && c10 <= '_') {
            sb2.append((char) 1);
            sb2.append((char) (c10 - 'E'));
            return 2;
        }
        if (c10 >= '`' && c10 <= 127) {
            sb2.append((char) 2);
            sb2.append((char) (c10 - '`'));
            return 2;
        }
        if (c10 >= 128) {
            sb2.append("\u0001\u001e");
            return d((char) (c10 - 128), sb2) + 2;
        }
        throw new IllegalArgumentException("Illegal character: " + c10);
    }

    public void f(h hVar, StringBuilder sb2) {
        int length = (sb2.length() / 3) << 1;
        int length2 = sb2.length() % 3;
        int a10 = hVar.a() + length;
        hVar.r(a10);
        int b10 = hVar.h().b() - a10;
        if (length2 == 2) {
            sb2.append((char) 0);
            while (sb2.length() >= 3) {
                g(hVar, sb2);
            }
            if (hVar.j()) {
                hVar.s((char) 254);
            }
        } else if (b10 == 1 && length2 == 1) {
            while (sb2.length() >= 3) {
                g(hVar, sb2);
            }
            if (hVar.j()) {
                hVar.s((char) 254);
            }
            hVar.f25718f--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb2.length() >= 3) {
                g(hVar, sb2);
            }
            if (b10 > 0 || hVar.j()) {
                hVar.s((char) 254);
            }
        }
        hVar.p(0);
    }
}
