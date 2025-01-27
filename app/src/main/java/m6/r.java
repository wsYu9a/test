package m6;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState;
import com.tencent.bugly.beta.tinker.TinkerReport;
import kotlin.text.Typography;

/* loaded from: classes2.dex */
public final class r {

    /* renamed from: a */
    public final z5.a f28524a;

    /* renamed from: b */
    public final CurrentParsingState f28525b = new CurrentParsingState();

    /* renamed from: c */
    public final StringBuilder f28526c = new StringBuilder();

    public r(z5.a aVar) {
        this.f28524a = aVar;
    }

    public static int g(z5.a aVar, int i10, int i11) {
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            if (aVar.h(i10 + i13)) {
                i12 |= 1 << ((i11 - i13) - 1);
            }
        }
        return i12;
    }

    public String a(StringBuilder sb2, int i10) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            n c10 = c(i10, str);
            String a10 = q.a(c10.b());
            if (a10 != null) {
                sb2.append(a10);
            }
            String valueOf = c10.d() ? String.valueOf(c10.c()) : null;
            if (i10 == c10.a()) {
                return sb2.toString();
            }
            i10 = c10.a();
            str = valueOf;
        }
    }

    public final m b(int i10) {
        char c10;
        int f10 = f(i10, 5);
        if (f10 == 15) {
            return new m(i10 + 5, '$');
        }
        if (f10 >= 5 && f10 < 15) {
            return new m(i10 + 5, (char) (f10 + 43));
        }
        int f11 = f(i10, 6);
        if (f11 >= 32 && f11 < 58) {
            return new m(i10 + 6, (char) (f11 + 33));
        }
        switch (f11) {
            case TTDownloadField.CALL_EVENT_CONFIG_GET_CLICK_BUTTON_TAG /* 58 */:
                c10 = '*';
                break;
            case 59:
                c10 = ',';
                break;
            case 60:
                c10 = '-';
                break;
            case 61:
                c10 = '.';
                break;
            case 62:
                c10 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + f11);
        }
        return new m(i10 + 6, c10);
    }

    public n c(int i10, String str) throws FormatException {
        this.f28526c.setLength(0);
        if (str != null) {
            this.f28526c.append(str);
        }
        this.f28525b.i(i10);
        n o10 = o();
        return (o10 == null || !o10.d()) ? new n(this.f28525b.a(), this.f28526c.toString()) : new n(this.f28525b.a(), this.f28526c.toString(), o10.c());
    }

    public final m d(int i10) throws FormatException {
        int f10 = f(i10, 5);
        if (f10 == 15) {
            return new m(i10 + 5, '$');
        }
        char c10 = '+';
        if (f10 >= 5 && f10 < 15) {
            return new m(i10 + 5, (char) (f10 + 43));
        }
        int f11 = f(i10, 7);
        if (f11 >= 64 && f11 < 90) {
            return new m(i10 + 7, (char) (f11 + 1));
        }
        if (f11 >= 90 && f11 < 116) {
            return new m(i10 + 7, (char) (f11 + 7));
        }
        switch (f(i10, 8)) {
            case 232:
                c10 = '!';
                break;
            case 233:
                c10 = Typography.quote;
                break;
            case org.mozilla.universalchardet.prober.g.f29289p /* 234 */:
                c10 = '%';
                break;
            case org.mozilla.universalchardet.prober.g.f29290q /* 235 */:
                c10 = Typography.amp;
                break;
            case 236:
                c10 = '\'';
                break;
            case org.mozilla.universalchardet.prober.g.f29291r /* 237 */:
                c10 = '(';
                break;
            case org.mozilla.universalchardet.prober.g.f29292s /* 238 */:
                c10 = ')';
                break;
            case 239:
                c10 = '*';
                break;
            case 240:
                break;
            case zi.c.f33842o /* 241 */:
                c10 = ',';
                break;
            case 242:
                c10 = '-';
                break;
            case 243:
                c10 = '.';
                break;
            case org.mozilla.universalchardet.prober.g.f29296w /* 244 */:
                c10 = '/';
                break;
            case org.mozilla.universalchardet.prober.g.f29297x /* 245 */:
                c10 = m5.d.f28378d;
                break;
            case org.mozilla.universalchardet.prober.g.f29298y /* 246 */:
                c10 = ';';
                break;
            case 247:
                c10 = Typography.less;
                break;
            case 248:
                c10 = '=';
                break;
            case 249:
                c10 = Typography.greater;
                break;
            case 250:
                c10 = '?';
                break;
            case TinkerReport.KEY_LOADED_UNCAUGHT_EXCEPTION /* 251 */:
                c10 = '_';
                break;
            case TinkerReport.KEY_LOADED_EXCEPTION_DEX /* 252 */:
                c10 = b5.a.O;
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new m(i10 + 8, c10);
    }

    public final o e(int i10) throws FormatException {
        int i11 = i10 + 7;
        if (i11 > this.f28524a.l()) {
            int f10 = f(i10, 4);
            return f10 == 0 ? new o(this.f28524a.l(), 10, 10) : new o(this.f28524a.l(), f10 - 1, 10);
        }
        int f11 = f(i10, 7) - 8;
        return new o(i11, f11 / 11, f11 % 11);
    }

    public int f(int i10, int i11) {
        return g(this.f28524a, i10, i11);
    }

    public final boolean h(int i10) {
        int i11 = i10 + 3;
        if (i11 > this.f28524a.l()) {
            return false;
        }
        while (i10 < i11) {
            if (this.f28524a.h(i10)) {
                return false;
            }
            i10++;
        }
        return true;
    }

    public final boolean i(int i10) {
        int i11;
        if (i10 + 1 > this.f28524a.l()) {
            return false;
        }
        for (int i12 = 0; i12 < 5 && (i11 = i12 + i10) < this.f28524a.l(); i12++) {
            if (i12 == 2) {
                if (!this.f28524a.h(i10 + 2)) {
                    return false;
                }
            } else if (this.f28524a.h(i11)) {
                return false;
            }
        }
        return true;
    }

    public final boolean j(int i10) {
        int i11;
        if (i10 + 1 > this.f28524a.l()) {
            return false;
        }
        for (int i12 = 0; i12 < 4 && (i11 = i12 + i10) < this.f28524a.l(); i12++) {
            if (this.f28524a.h(i11)) {
                return false;
            }
        }
        return true;
    }

    public final boolean k(int i10) {
        int f10;
        if (i10 + 5 > this.f28524a.l()) {
            return false;
        }
        int f11 = f(i10, 5);
        if (f11 < 5 || f11 >= 16) {
            return i10 + 6 <= this.f28524a.l() && (f10 = f(i10, 6)) >= 16 && f10 < 63;
        }
        return true;
    }

    public final boolean l(int i10) {
        int f10;
        if (i10 + 5 > this.f28524a.l()) {
            return false;
        }
        int f11 = f(i10, 5);
        if (f11 >= 5 && f11 < 16) {
            return true;
        }
        if (i10 + 7 > this.f28524a.l()) {
            return false;
        }
        int f12 = f(i10, 7);
        if (f12 < 64 || f12 >= 116) {
            return i10 + 8 <= this.f28524a.l() && (f10 = f(i10, 8)) >= 232 && f10 < 253;
        }
        return true;
    }

    public final boolean m(int i10) {
        if (i10 + 7 > this.f28524a.l()) {
            return i10 + 4 <= this.f28524a.l();
        }
        int i11 = i10;
        while (true) {
            int i12 = i10 + 3;
            if (i11 >= i12) {
                return this.f28524a.h(i12);
            }
            if (this.f28524a.h(i11)) {
                return true;
            }
            i11++;
        }
    }

    public final l n() {
        while (k(this.f28525b.a())) {
            m b10 = b(this.f28525b.a());
            this.f28525b.i(b10.a());
            if (b10.c()) {
                return new l(new n(this.f28525b.a(), this.f28526c.toString()), true);
            }
            this.f28526c.append(b10.b());
        }
        if (h(this.f28525b.a())) {
            this.f28525b.b(3);
            this.f28525b.h();
        } else if (i(this.f28525b.a())) {
            if (this.f28525b.a() + 5 < this.f28524a.l()) {
                this.f28525b.b(5);
            } else {
                this.f28525b.i(this.f28524a.l());
            }
            this.f28525b.g();
        }
        return new l(false);
    }

    public final n o() throws FormatException {
        l q10;
        boolean b10;
        do {
            int a10 = this.f28525b.a();
            if (this.f28525b.c()) {
                q10 = n();
                b10 = q10.b();
            } else if (this.f28525b.d()) {
                q10 = p();
                b10 = q10.b();
            } else {
                q10 = q();
                b10 = q10.b();
            }
            if (a10 == this.f28525b.a() && !b10) {
                break;
            }
        } while (!b10);
        return q10.a();
    }

    public final l p() throws FormatException {
        while (l(this.f28525b.a())) {
            m d10 = d(this.f28525b.a());
            this.f28525b.i(d10.a());
            if (d10.c()) {
                return new l(new n(this.f28525b.a(), this.f28526c.toString()), true);
            }
            this.f28526c.append(d10.b());
        }
        if (h(this.f28525b.a())) {
            this.f28525b.b(3);
            this.f28525b.h();
        } else if (i(this.f28525b.a())) {
            if (this.f28525b.a() + 5 < this.f28524a.l()) {
                this.f28525b.b(5);
            } else {
                this.f28525b.i(this.f28524a.l());
            }
            this.f28525b.f();
        }
        return new l(false);
    }

    public final l q() throws FormatException {
        while (m(this.f28525b.a())) {
            o e10 = e(this.f28525b.a());
            this.f28525b.i(e10.a());
            if (e10.f()) {
                return new l(e10.g() ? new n(this.f28525b.a(), this.f28526c.toString()) : new n(this.f28525b.a(), this.f28526c.toString(), e10.c()), true);
            }
            this.f28526c.append(e10.b());
            if (e10.g()) {
                return new l(new n(this.f28525b.a(), this.f28526c.toString()), true);
            }
            this.f28526c.append(e10.c());
        }
        if (j(this.f28525b.a())) {
            this.f28525b.f();
            this.f28525b.b(4);
        }
        return new l(false);
    }
}
