package y5;

import com.google.zxing.client.result.ParsedResultType;
import java.util.Map;

/* loaded from: classes2.dex */
public final class k extends q {

    /* renamed from: q */
    public static final String f33026q = "KG";

    /* renamed from: r */
    public static final String f33027r = "LB";

    /* renamed from: b */
    public final String f33028b;

    /* renamed from: c */
    public final String f33029c;

    /* renamed from: d */
    public final String f33030d;

    /* renamed from: e */
    public final String f33031e;

    /* renamed from: f */
    public final String f33032f;

    /* renamed from: g */
    public final String f33033g;

    /* renamed from: h */
    public final String f33034h;

    /* renamed from: i */
    public final String f33035i;

    /* renamed from: j */
    public final String f33036j;

    /* renamed from: k */
    public final String f33037k;

    /* renamed from: l */
    public final String f33038l;

    /* renamed from: m */
    public final String f33039m;

    /* renamed from: n */
    public final String f33040n;

    /* renamed from: o */
    public final String f33041o;

    /* renamed from: p */
    public final Map<String, String> f33042p;

    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(ParsedResultType.PRODUCT);
        this.f33028b = str;
        this.f33029c = str2;
        this.f33030d = str3;
        this.f33031e = str4;
        this.f33032f = str5;
        this.f33033g = str6;
        this.f33034h = str7;
        this.f33035i = str8;
        this.f33036j = str9;
        this.f33037k = str10;
        this.f33038l = str11;
        this.f33039m = str12;
        this.f33040n = str13;
        this.f33041o = str14;
        this.f33042p = map;
    }

    public static boolean d(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int t(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // y5.q
    public String a() {
        return String.valueOf(this.f33028b);
    }

    public String e() {
        return this.f33034h;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return d(this.f33029c, kVar.f33029c) && d(this.f33030d, kVar.f33030d) && d(this.f33031e, kVar.f33031e) && d(this.f33032f, kVar.f33032f) && d(this.f33034h, kVar.f33034h) && d(this.f33035i, kVar.f33035i) && d(this.f33036j, kVar.f33036j) && d(this.f33037k, kVar.f33037k) && d(this.f33038l, kVar.f33038l) && d(this.f33039m, kVar.f33039m) && d(this.f33040n, kVar.f33040n) && d(this.f33041o, kVar.f33041o) && d(this.f33042p, kVar.f33042p);
    }

    public String f() {
        return this.f33035i;
    }

    public String g() {
        return this.f33031e;
    }

    public String h() {
        return this.f33033g;
    }

    public int hashCode() {
        return (((((((((((t(this.f33029c) ^ t(this.f33030d)) ^ t(this.f33031e)) ^ t(this.f33032f)) ^ t(this.f33034h)) ^ t(this.f33035i)) ^ t(this.f33036j)) ^ t(this.f33037k)) ^ t(this.f33038l)) ^ t(this.f33039m)) ^ t(this.f33040n)) ^ t(this.f33041o)) ^ t(this.f33042p);
    }

    public String i() {
        return this.f33039m;
    }

    public String j() {
        return this.f33041o;
    }

    public String k() {
        return this.f33040n;
    }

    public String l() {
        return this.f33029c;
    }

    public String m() {
        return this.f33032f;
    }

    public String n() {
        return this.f33028b;
    }

    public String o() {
        return this.f33030d;
    }

    public Map<String, String> p() {
        return this.f33042p;
    }

    public String q() {
        return this.f33036j;
    }

    public String r() {
        return this.f33038l;
    }

    public String s() {
        return this.f33037k;
    }
}
