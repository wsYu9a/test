package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.tencent.bugly.beta.tinker.TinkerReport;
import kotlin.text.Typography;

/* loaded from: classes.dex */
final class r {

    /* renamed from: a */
    private final com.google.zxing.common.a f8627a;

    /* renamed from: b */
    private final CurrentParsingState f8628b = new CurrentParsingState();

    /* renamed from: c */
    private final StringBuilder f8629c = new StringBuilder();

    r(com.google.zxing.common.a aVar) {
        this.f8627a = aVar;
    }

    private m b(int i2) {
        char c2;
        int f2 = f(i2, 5);
        if (f2 == 15) {
            return new m(i2 + 5, Typography.dollar);
        }
        if (f2 >= 5 && f2 < 15) {
            return new m(i2 + 5, (char) ((f2 + 48) - 5));
        }
        int f3 = f(i2, 6);
        if (f3 >= 32 && f3 < 58) {
            return new m(i2 + 6, (char) (f3 + 33));
        }
        switch (f3) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = '-';
                break;
            case 61:
                c2 = '.';
                break;
            case 62:
                c2 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + f3);
        }
        return new m(i2 + 6, c2);
    }

    private m d(int i2) throws FormatException {
        char c2;
        int f2 = f(i2, 5);
        if (f2 == 15) {
            return new m(i2 + 5, Typography.dollar);
        }
        if (f2 >= 5 && f2 < 15) {
            return new m(i2 + 5, (char) ((f2 + 48) - 5));
        }
        int f3 = f(i2, 7);
        if (f3 >= 64 && f3 < 90) {
            return new m(i2 + 7, (char) (f3 + 1));
        }
        if (f3 >= 90 && f3 < 116) {
            return new m(i2 + 7, (char) (f3 + 7));
        }
        switch (f(i2, 8)) {
            case 232:
                c2 = '!';
                break;
            case 233:
                c2 = Typography.quote;
                break;
            case org.mozilla.universalchardet.prober.g.f35436i /* 234 */:
                c2 = '%';
                break;
            case org.mozilla.universalchardet.prober.g.f35437j /* 235 */:
                c2 = Typography.amp;
                break;
            case 236:
                c2 = '\'';
                break;
            case org.mozilla.universalchardet.prober.g.k /* 237 */:
                c2 = '(';
                break;
            case org.mozilla.universalchardet.prober.g.l /* 238 */:
                c2 = ')';
                break;
            case 239:
                c2 = '*';
                break;
            case org.mozilla.universalchardet.prober.g.n /* 240 */:
                c2 = '+';
                break;
            case org.mozilla.universalchardet.prober.n.c.o /* 241 */:
                c2 = ',';
                break;
            case 242:
                c2 = '-';
                break;
            case 243:
                c2 = '.';
                break;
            case org.mozilla.universalchardet.prober.g.p /* 244 */:
                c2 = '/';
                break;
            case org.mozilla.universalchardet.prober.g.q /* 245 */:
                c2 = ':';
                break;
            case org.mozilla.universalchardet.prober.g.r /* 246 */:
                c2 = ';';
                break;
            case 247:
                c2 = Typography.less;
                break;
            case 248:
                c2 = '=';
                break;
            case 249:
                c2 = Typography.greater;
                break;
            case 250:
                c2 = '?';
                break;
            case TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION /* 251 */:
                c2 = '_';
                break;
            case TinkerReport.KEY_LOADED_EXCEPTION_DEX /* 252 */:
                c2 = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new m(i2 + 8, c2);
    }

    private o e(int i2) throws FormatException {
        int i3 = i2 + 7;
        if (i3 > this.f8627a.l()) {
            int f2 = f(i2, 4);
            return f2 == 0 ? new o(this.f8627a.l(), 10, 10) : new o(this.f8627a.l(), f2 - 1, 10);
        }
        int f3 = f(i2, 7) - 8;
        return new o(i3, f3 / 11, f3 % 11);
    }

    static int g(com.google.zxing.common.a aVar, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            if (aVar.h(i2 + i5)) {
                i4 |= 1 << ((i3 - i5) - 1);
            }
        }
        return i4;
    }

    private boolean h(int i2) {
        int i3 = i2 + 3;
        if (i3 > this.f8627a.l()) {
            return false;
        }
        while (i2 < i3) {
            if (this.f8627a.h(i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private boolean i(int i2) {
        int i3;
        if (i2 + 1 > this.f8627a.l()) {
            return false;
        }
        for (int i4 = 0; i4 < 5 && (i3 = i4 + i2) < this.f8627a.l(); i4++) {
            if (i4 == 2) {
                if (!this.f8627a.h(i2 + 2)) {
                    return false;
                }
            } else if (this.f8627a.h(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean j(int i2) {
        int i3;
        if (i2 + 1 > this.f8627a.l()) {
            return false;
        }
        for (int i4 = 0; i4 < 4 && (i3 = i4 + i2) < this.f8627a.l(); i4++) {
            if (this.f8627a.h(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean k(int i2) {
        int f2;
        if (i2 + 5 > this.f8627a.l()) {
            return false;
        }
        int f3 = f(i2, 5);
        if (f3 < 5 || f3 >= 16) {
            return i2 + 6 <= this.f8627a.l() && (f2 = f(i2, 6)) >= 16 && f2 < 63;
        }
        return true;
    }

    private boolean l(int i2) {
        int f2;
        if (i2 + 5 > this.f8627a.l()) {
            return false;
        }
        int f3 = f(i2, 5);
        if (f3 >= 5 && f3 < 16) {
            return true;
        }
        if (i2 + 7 > this.f8627a.l()) {
            return false;
        }
        int f4 = f(i2, 7);
        if (f4 < 64 || f4 >= 116) {
            return i2 + 8 <= this.f8627a.l() && (f2 = f(i2, 8)) >= 232 && f2 < 253;
        }
        return true;
    }

    private boolean m(int i2) {
        if (i2 + 7 > this.f8627a.l()) {
            return i2 + 4 <= this.f8627a.l();
        }
        int i3 = i2;
        while (true) {
            int i4 = i2 + 3;
            if (i3 >= i4) {
                return this.f8627a.h(i4);
            }
            if (this.f8627a.h(i3)) {
                return true;
            }
            i3++;
        }
    }

    private l n() {
        while (k(this.f8628b.a())) {
            m b2 = b(this.f8628b.a());
            this.f8628b.i(b2.a());
            if (b2.c()) {
                return new l(new n(this.f8628b.a(), this.f8629c.toString()), true);
            }
            this.f8629c.append(b2.b());
        }
        if (h(this.f8628b.a())) {
            this.f8628b.b(3);
            this.f8628b.h();
        } else if (i(this.f8628b.a())) {
            if (this.f8628b.a() + 5 < this.f8627a.l()) {
                this.f8628b.b(5);
            } else {
                this.f8628b.i(this.f8627a.l());
            }
            this.f8628b.g();
        }
        return new l(false);
    }

    private n o() throws FormatException {
        l q;
        boolean b2;
        do {
            int a2 = this.f8628b.a();
            if (this.f8628b.c()) {
                q = n();
                b2 = q.b();
            } else if (this.f8628b.d()) {
                q = p();
                b2 = q.b();
            } else {
                q = q();
                b2 = q.b();
            }
            if (!(a2 != this.f8628b.a()) && !b2) {
                break;
            }
        } while (!b2);
        return q.a();
    }

    private l p() throws FormatException {
        while (l(this.f8628b.a())) {
            m d2 = d(this.f8628b.a());
            this.f8628b.i(d2.a());
            if (d2.c()) {
                return new l(new n(this.f8628b.a(), this.f8629c.toString()), true);
            }
            this.f8629c.append(d2.b());
        }
        if (h(this.f8628b.a())) {
            this.f8628b.b(3);
            this.f8628b.h();
        } else if (i(this.f8628b.a())) {
            if (this.f8628b.a() + 5 < this.f8627a.l()) {
                this.f8628b.b(5);
            } else {
                this.f8628b.i(this.f8627a.l());
            }
            this.f8628b.f();
        }
        return new l(false);
    }

    private l q() throws FormatException {
        while (m(this.f8628b.a())) {
            o e2 = e(this.f8628b.a());
            this.f8628b.i(e2.a());
            if (e2.f()) {
                return new l(e2.g() ? new n(this.f8628b.a(), this.f8629c.toString()) : new n(this.f8628b.a(), this.f8629c.toString(), e2.c()), true);
            }
            this.f8629c.append(e2.b());
            if (e2.g()) {
                return new l(new n(this.f8628b.a(), this.f8629c.toString()), true);
            }
            this.f8629c.append(e2.c());
        }
        if (j(this.f8628b.a())) {
            this.f8628b.f();
            this.f8628b.b(4);
        }
        return new l(false);
    }

    String a(StringBuilder sb, int i2) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            n c2 = c(i2, str);
            String a2 = q.a(c2.b());
            if (a2 != null) {
                sb.append(a2);
            }
            String valueOf = c2.d() ? String.valueOf(c2.c()) : null;
            if (i2 == c2.a()) {
                return sb.toString();
            }
            i2 = c2.a();
            str = valueOf;
        }
    }

    n c(int i2, String str) throws FormatException {
        this.f8629c.setLength(0);
        if (str != null) {
            this.f8629c.append(str);
        }
        this.f8628b.i(i2);
        n o = o();
        return (o == null || !o.d()) ? new n(this.f8628b.a(), this.f8629c.toString()) : new n(this.f8628b.a(), this.f8629c.toString(), o.c());
    }

    int f(int i2, int i3) {
        return g(this.f8627a, i2, i3);
    }
}
