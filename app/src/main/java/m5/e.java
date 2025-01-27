package m5;

import b5.p;
import b5.u;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import com.google.thirdparty.publicsuffix.PublicSuffixType;
import java.util.List;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@Immutable
@a
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: e */
    public static final b5.b f28387e = b5.b.d(".。．｡");

    /* renamed from: f */
    public static final com.google.common.base.c f28388f = com.google.common.base.c.h('.');

    /* renamed from: g */
    public static final p f28389g = p.o('.');

    /* renamed from: h */
    public static final int f28390h = -1;

    /* renamed from: i */
    public static final int f28391i = 127;

    /* renamed from: j */
    public static final int f28392j = 253;

    /* renamed from: k */
    public static final int f28393k = 63;

    /* renamed from: l */
    public static final b5.b f28394l;

    /* renamed from: m */
    public static final b5.b f28395m;

    /* renamed from: n */
    public static final b5.b f28396n;

    /* renamed from: o */
    public static final b5.b f28397o;

    /* renamed from: a */
    public final String f28398a;

    /* renamed from: b */
    public final ImmutableList<String> f28399b;

    /* renamed from: c */
    public final int f28400c;

    /* renamed from: d */
    public final int f28401d;

    static {
        b5.b d10 = b5.b.d("-_");
        f28394l = d10;
        b5.b m10 = b5.b.m('0', '9');
        f28395m = m10;
        b5.b I = b5.b.m('a', 'z').I(b5.b.m('A', 'Z'));
        f28396n = I;
        f28397o = m10.I(I).I(d10);
    }

    public e(String str) {
        String g10 = b5.a.g(f28387e.N(str, '.'));
        g10 = g10.endsWith(p1.b.f29697h) ? g10.substring(0, g10.length() - 1) : g10;
        u.u(g10.length() <= 253, "Domain name too long: '%s':", g10);
        this.f28398a = g10;
        ImmutableList<String> copyOf = ImmutableList.copyOf(f28388f.n(g10));
        this.f28399b = copyOf;
        u.u(copyOf.size() <= 127, "Domain has too many parts: '%s'", g10);
        u.u(x(copyOf), "Not a valid domain name: '%s'", g10);
        this.f28400c = c(Optional.absent());
        this.f28401d = c(Optional.of(PublicSuffixType.REGISTRY));
    }

    @CanIgnoreReturnValue
    public static e d(String str) {
        return new e((String) u.E(str));
    }

    public static boolean n(String str) {
        try {
            d(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public static boolean o(Optional<PublicSuffixType> optional, Optional<PublicSuffixType> optional2) {
        return optional.isPresent() ? optional.equals(optional2) : optional2.isPresent();
    }

    public static boolean p(Optional<PublicSuffixType> optional, String str) {
        List<String> o10 = f28388f.f(2).o(str);
        return o10.size() == 2 && o(optional, Optional.fromNullable(s5.a.f30599b.get(o10.get(1))));
    }

    public static boolean w(String str, boolean z10) {
        if (str.length() >= 1 && str.length() <= 63) {
            if (!f28397o.C(b5.b.f().P(str))) {
                return false;
            }
            b5.b bVar = f28394l;
            if (!bVar.B(str.charAt(0)) && !bVar.B(str.charAt(str.length() - 1))) {
                return (z10 && f28395m.B(str.charAt(0))) ? false : true;
            }
        }
        return false;
    }

    public static boolean x(List<String> list) {
        int size = list.size() - 1;
        if (!w(list.get(size), true)) {
            return false;
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (!w(list.get(i10), false)) {
                return false;
            }
        }
        return true;
    }

    public final e a(int i10) {
        p pVar = f28389g;
        ImmutableList<String> immutableList = this.f28399b;
        return d(pVar.k(immutableList.subList(i10, immutableList.size())));
    }

    public e b(String str) {
        String str2 = (String) u.E(str);
        String str3 = this.f28398a;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str3).length());
        sb2.append(str2);
        sb2.append(p1.b.f29697h);
        sb2.append(str3);
        return d(sb2.toString());
    }

    public final int c(Optional<PublicSuffixType> optional) {
        int size = this.f28399b.size();
        for (int i10 = 0; i10 < size; i10++) {
            String k10 = f28389g.k(this.f28399b.subList(i10, size));
            if (o(optional, Optional.fromNullable(s5.a.f30598a.get(k10)))) {
                return i10;
            }
            if (s5.a.f30600c.containsKey(k10)) {
                return i10 + 1;
            }
            if (p(optional, k10)) {
                return i10;
            }
        }
        return -1;
    }

    public boolean e() {
        return this.f28399b.size() > 1;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            return this.f28398a.equals(((e) obj).f28398a);
        }
        return false;
    }

    public boolean f() {
        return this.f28400c != -1;
    }

    public boolean g() {
        return this.f28401d != -1;
    }

    public boolean h() {
        return this.f28400c == 0;
    }

    public int hashCode() {
        return this.f28398a.hashCode();
    }

    public boolean i() {
        return this.f28401d == 0;
    }

    public boolean j() {
        return this.f28401d == 1;
    }

    public boolean k() {
        return this.f28400c == 1;
    }

    public boolean l() {
        return this.f28400c > 0;
    }

    public boolean m() {
        return this.f28401d > 0;
    }

    public e q() {
        u.x0(e(), "Domain '%s' has no parent", this.f28398a);
        return a(1);
    }

    public ImmutableList<String> r() {
        return this.f28399b;
    }

    @CheckForNull
    public e s() {
        if (f()) {
            return a(this.f28400c);
        }
        return null;
    }

    @CheckForNull
    public e t() {
        if (g()) {
            return a(this.f28401d);
        }
        return null;
    }

    public String toString() {
        return this.f28398a;
    }

    public e u() {
        if (j()) {
            return this;
        }
        u.x0(m(), "Not under a registry suffix: %s", this.f28398a);
        return a(this.f28401d - 1);
    }

    public e v() {
        if (k()) {
            return this;
        }
        u.x0(l(), "Not under a public suffix: %s", this.f28398a);
        return a(this.f28400c - 1);
    }
}
