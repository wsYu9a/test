package m5;

import b5.n;
import b5.p;
import b5.r;
import b5.u;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import com.google.errorprone.annotations.concurrent.LazyInit;
import e5.z0;
import e5.z1;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;

@a5.b
@Immutable
@m5.a
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: l */
    public static final String f28429l = "application";

    /* renamed from: m */
    public static final String f28432m = "audio";

    /* renamed from: n */
    public static final String f28435n = "image";

    /* renamed from: o */
    public static final String f28438o = "text";

    /* renamed from: p */
    public static final String f28441p = "video";

    /* renamed from: a */
    public final String f28474a;

    /* renamed from: b */
    public final String f28475b;

    /* renamed from: c */
    public final ImmutableListMultimap<String, String> f28476c;

    /* renamed from: d */
    @CheckForNull
    @LazyInit
    public String f28477d;

    /* renamed from: e */
    @LazyInit
    public int f28478e;

    /* renamed from: f */
    @CheckForNull
    @LazyInit
    public Optional<Charset> f28479f;

    /* renamed from: g */
    public static final String f28414g = "charset";

    /* renamed from: h */
    public static final ImmutableListMultimap<String, String> f28417h = ImmutableListMultimap.of(f28414g, b5.a.g(b5.c.f1249c.name()));

    /* renamed from: i */
    public static final b5.b f28420i = b5.b.f().b(b5.b.v().F()).b(b5.b.s(b5.a.O)).b(b5.b.H("()<>@,;:\\\"/[]?="));

    /* renamed from: j */
    public static final b5.b f28423j = b5.b.f().b(b5.b.H("\"\\\r"));

    /* renamed from: k */
    public static final b5.b f28426k = b5.b.d(" \t\r\n");

    /* renamed from: s */
    public static final Map<h, h> f28450s = Maps.Y();

    /* renamed from: r */
    public static final String f28447r = "*";

    /* renamed from: t */
    public static final h f28453t = i(f28447r, f28447r);

    /* renamed from: u */
    public static final h f28456u = i("text", f28447r);

    /* renamed from: v */
    public static final h f28459v = i("image", f28447r);

    /* renamed from: w */
    public static final h f28462w = i("audio", f28447r);

    /* renamed from: x */
    public static final h f28465x = i("video", f28447r);

    /* renamed from: y */
    public static final h f28468y = i("application", f28447r);

    /* renamed from: q */
    public static final String f28444q = "font";

    /* renamed from: z */
    public static final h f28471z = i(f28444q, f28447r);
    public static final h A = j("text", "cache-manifest");
    public static final h B = j("text", "css");
    public static final h C = j("text", "csv");
    public static final h D = j("text", com.baidu.mobads.sdk.internal.a.f6640f);
    public static final h E = j("text", "calendar");
    public static final h F = j("text", "plain");
    public static final h G = j("text", "javascript");
    public static final h H = j("text", "tab-separated-values");
    public static final h I = j("text", "vcard");
    public static final h J = j("text", "vnd.wap.wml");
    public static final h K = j("text", "xml");
    public static final h L = j("text", "vtt");
    public static final h M = i("image", "bmp");
    public static final h N = i("image", "x-canon-crw");
    public static final h O = i("image", "gif");
    public static final h P = i("image", "vnd.microsoft.icon");
    public static final h Q = i("image", "jpeg");
    public static final h R = i("image", "png");
    public static final h S = i("image", "vnd.adobe.photoshop");
    public static final h T = j("image", "svg+xml");
    public static final h U = i("image", "tiff");
    public static final h V = i("image", "webp");
    public static final h W = i("image", "heif");
    public static final h X = i("image", "jp2");
    public static final h Y = i("audio", "mp4");
    public static final h Z = i("audio", "mpeg");

    /* renamed from: a0 */
    public static final h f28402a0 = i("audio", "ogg");

    /* renamed from: b0 */
    public static final h f28404b0 = i("audio", "webm");

    /* renamed from: c0 */
    public static final h f28406c0 = i("audio", "l16");

    /* renamed from: d0 */
    public static final h f28408d0 = i("audio", "l24");

    /* renamed from: e0 */
    public static final h f28410e0 = i("audio", "basic");

    /* renamed from: f0 */
    public static final h f28412f0 = i("audio", "aac");

    /* renamed from: g0 */
    public static final h f28415g0 = i("audio", "vorbis");

    /* renamed from: h0 */
    public static final h f28418h0 = i("audio", "x-ms-wma");

    /* renamed from: i0 */
    public static final h f28421i0 = i("audio", "x-ms-wax");

    /* renamed from: j0 */
    public static final h f28424j0 = i("audio", "vnd.rn-realaudio");

    /* renamed from: k0 */
    public static final h f28427k0 = i("audio", "vnd.wave");

    /* renamed from: l0 */
    public static final h f28430l0 = i("video", "mp4");

    /* renamed from: m0 */
    public static final h f28433m0 = i("video", "mpeg");

    /* renamed from: n0 */
    public static final h f28436n0 = i("video", "ogg");

    /* renamed from: o0 */
    public static final h f28439o0 = i("video", "quicktime");

    /* renamed from: p0 */
    public static final h f28442p0 = i("video", "webm");

    /* renamed from: q0 */
    public static final h f28445q0 = i("video", "x-ms-wmv");

    /* renamed from: r0 */
    public static final h f28448r0 = i("video", "x-flv");

    /* renamed from: s0 */
    public static final h f28451s0 = i("video", "3gpp");

    /* renamed from: t0 */
    public static final h f28454t0 = i("video", "3gpp2");

    /* renamed from: u0 */
    public static final h f28457u0 = j("application", "xml");

    /* renamed from: v0 */
    public static final h f28460v0 = j("application", "atom+xml");

    /* renamed from: w0 */
    public static final h f28463w0 = i("application", "x-bzip2");

    /* renamed from: x0 */
    public static final h f28466x0 = j("application", "dart");

    /* renamed from: y0 */
    public static final h f28469y0 = i("application", "vnd.apple.pkpass");

    /* renamed from: z0 */
    public static final h f28472z0 = i("application", "vnd.ms-fontobject");
    public static final h A0 = i("application", "epub+zip");
    public static final h B0 = i("application", "x-www-form-urlencoded");
    public static final h C0 = i("application", "pkcs12");
    public static final h D0 = i("application", "binary");
    public static final h E0 = i("application", "geo+json");
    public static final h F0 = i("application", "x-gzip");
    public static final h G0 = i("application", "hal+json");
    public static final h H0 = j("application", "javascript");
    public static final h I0 = i("application", "jose");
    public static final h J0 = i("application", "jose+json");
    public static final h K0 = j("application", "json");
    public static final h L0 = j("application", "manifest+json");
    public static final h M0 = i("application", "vnd.google-earth.kml+xml");
    public static final h N0 = i("application", "vnd.google-earth.kmz");
    public static final h O0 = i("application", "mbox");
    public static final h P0 = i("application", "x-apple-aspen-config");
    public static final h Q0 = i("application", "vnd.ms-excel");
    public static final h R0 = i("application", "vnd.ms-outlook");
    public static final h S0 = i("application", "vnd.ms-powerpoint");
    public static final h T0 = i("application", "msword");
    public static final h U0 = i("application", "dash+xml");
    public static final h V0 = i("application", "wasm");
    public static final h W0 = i("application", "x-nacl");
    public static final h X0 = i("application", "x-pnacl");
    public static final h Y0 = i("application", "octet-stream");
    public static final h Z0 = i("application", "ogg");

    /* renamed from: a1 */
    public static final h f28403a1 = i("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");

    /* renamed from: b1 */
    public static final h f28405b1 = i("application", "vnd.openxmlformats-officedocument.presentationml.presentation");

    /* renamed from: c1 */
    public static final h f28407c1 = i("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    /* renamed from: d1 */
    public static final h f28409d1 = i("application", "vnd.oasis.opendocument.graphics");

    /* renamed from: e1 */
    public static final h f28411e1 = i("application", "vnd.oasis.opendocument.presentation");

    /* renamed from: f1 */
    public static final h f28413f1 = i("application", "vnd.oasis.opendocument.spreadsheet");

    /* renamed from: g1 */
    public static final h f28416g1 = i("application", "vnd.oasis.opendocument.text");

    /* renamed from: h1 */
    public static final h f28419h1 = j("application", "opensearchdescription+xml");

    /* renamed from: i1 */
    public static final h f28422i1 = i("application", "pdf");

    /* renamed from: j1 */
    public static final h f28425j1 = i("application", "postscript");

    /* renamed from: k1 */
    public static final h f28428k1 = i("application", "protobuf");

    /* renamed from: l1 */
    public static final h f28431l1 = j("application", "rdf+xml");

    /* renamed from: m1 */
    public static final h f28434m1 = j("application", "rtf");

    /* renamed from: n1 */
    public static final h f28437n1 = i("application", "font-sfnt");

    /* renamed from: o1 */
    public static final h f28440o1 = i("application", "x-shockwave-flash");

    /* renamed from: p1 */
    public static final h f28443p1 = i("application", "vnd.sketchup.skp");

    /* renamed from: q1 */
    public static final h f28446q1 = j("application", "soap+xml");

    /* renamed from: r1 */
    public static final h f28449r1 = i("application", "x-tar");

    /* renamed from: s1 */
    public static final h f28452s1 = i("application", "font-woff");

    /* renamed from: t1 */
    public static final h f28455t1 = i("application", "font-woff2");

    /* renamed from: u1 */
    public static final h f28458u1 = j("application", "xhtml+xml");

    /* renamed from: v1 */
    public static final h f28461v1 = j("application", "xrd+xml");

    /* renamed from: w1 */
    public static final h f28464w1 = i("application", com.sigmob.sdk.archives.d.f17516f);

    /* renamed from: x1 */
    public static final h f28467x1 = i(f28444q, "collection");

    /* renamed from: y1 */
    public static final h f28470y1 = i(f28444q, "otf");

    /* renamed from: z1 */
    public static final h f28473z1 = i(f28444q, "sfnt");
    public static final h A1 = i(f28444q, "ttf");
    public static final h B1 = i(f28444q, "woff");
    public static final h C1 = i(f28444q, "woff2");
    public static final p.d D1 = p.p(t8.a.f30754i).u("=");

    public static final class a {

        /* renamed from: a */
        public final String f28480a;

        /* renamed from: b */
        public int f28481b = 0;

        public a(String str) {
            this.f28480a = str;
        }

        @CanIgnoreReturnValue
        public char a(char c10) {
            u.g0(e());
            u.g0(f() == c10);
            this.f28481b++;
            return c10;
        }

        public char b(b5.b bVar) {
            u.g0(e());
            char f10 = f();
            u.g0(bVar.B(f10));
            this.f28481b++;
            return f10;
        }

        public String c(b5.b bVar) {
            int i10 = this.f28481b;
            String d10 = d(bVar);
            u.g0(this.f28481b != i10);
            return d10;
        }

        @CanIgnoreReturnValue
        public String d(b5.b bVar) {
            u.g0(e());
            int i10 = this.f28481b;
            this.f28481b = bVar.F().o(this.f28480a, i10);
            return e() ? this.f28480a.substring(i10, this.f28481b) : this.f28480a.substring(i10);
        }

        public boolean e() {
            int i10 = this.f28481b;
            return i10 >= 0 && i10 < this.f28480a.length();
        }

        public char f() {
            u.g0(e());
            return this.f28480a.charAt(this.f28481b);
        }
    }

    public h(String str, String str2, ImmutableListMultimap<String, String> immutableListMultimap) {
        this.f28474a = str;
        this.f28475b = str2;
        this.f28476c = immutableListMultimap;
    }

    public static h b(h hVar) {
        f28450s.put(hVar, hVar);
        return hVar;
    }

    public static h e(String str, String str2) {
        h f10 = f(str, str2, ImmutableListMultimap.of());
        f10.f28479f = Optional.absent();
        return f10;
    }

    public static h f(String str, String str2, z0<String, String> z0Var) {
        u.E(str);
        u.E(str2);
        u.E(z0Var);
        String t10 = t(str);
        String t11 = t(str2);
        u.e(!f28447r.equals(t10) || f28447r.equals(t11), "A wildcard type cannot be used with a non-wildcard subtype");
        ImmutableListMultimap.a builder = ImmutableListMultimap.builder();
        for (Map.Entry<String, String> entry : z0Var.entries()) {
            String t12 = t(entry.getKey());
            builder.f(t12, s(t12, entry.getValue()));
        }
        h hVar = new h(t10, t11, builder.a());
        return (h) com.google.common.base.a.a(f28450s.get(hVar), hVar);
    }

    public static h g(String str) {
        return e("application", str);
    }

    public static h h(String str) {
        return e("audio", str);
    }

    public static h i(String str, String str2) {
        h b10 = b(new h(str, str2, ImmutableListMultimap.of()));
        b10.f28479f = Optional.absent();
        return b10;
    }

    public static h j(String str, String str2) {
        h b10 = b(new h(str, str2, f28417h));
        b10.f28479f = Optional.of(b5.c.f1249c);
        return b10;
    }

    public static h k(String str) {
        return e(f28444q, str);
    }

    public static h l(String str) {
        return e("image", str);
    }

    public static h m(String str) {
        return e("text", str);
    }

    public static h n(String str) {
        return e("video", str);
    }

    public static String o(String str) {
        StringBuilder sb2 = new StringBuilder(str.length() + 16);
        sb2.append(Typography.quote);
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (charAt == '\r' || charAt == '\\' || charAt == '\"') {
                sb2.append('\\');
            }
            sb2.append(charAt);
        }
        sb2.append(Typography.quote);
        return sb2.toString();
    }

    public static /* synthetic */ String r(String str) {
        return (!f28420i.C(str) || str.isEmpty()) ? o(str) : str;
    }

    public static String s(String str, String str2) {
        u.E(str2);
        u.u(b5.b.f().C(str2), "parameter values must be ASCII: %s", str2);
        return f28414g.equals(str) ? b5.a.g(str2) : str2;
    }

    public static String t(String str) {
        u.d(f28420i.C(str));
        u.d(!str.isEmpty());
        return b5.a.g(str);
    }

    @CanIgnoreReturnValue
    public static h w(String str) {
        String c10;
        u.E(str);
        a aVar = new a(str);
        try {
            b5.b bVar = f28420i;
            String c11 = aVar.c(bVar);
            aVar.a('/');
            String c12 = aVar.c(bVar);
            ImmutableListMultimap.a builder = ImmutableListMultimap.builder();
            while (aVar.e()) {
                b5.b bVar2 = f28426k;
                aVar.d(bVar2);
                aVar.a(';');
                aVar.d(bVar2);
                b5.b bVar3 = f28420i;
                String c13 = aVar.c(bVar3);
                aVar.a('=');
                if ('\"' == aVar.f()) {
                    aVar.a(Typography.quote);
                    StringBuilder sb2 = new StringBuilder();
                    while ('\"' != aVar.f()) {
                        if ('\\' == aVar.f()) {
                            aVar.a('\\');
                            sb2.append(aVar.b(b5.b.f()));
                        } else {
                            sb2.append(aVar.c(f28423j));
                        }
                    }
                    c10 = sb2.toString();
                    aVar.a(Typography.quote);
                } else {
                    c10 = aVar.c(bVar3);
                }
                builder.f(c13, c10);
            }
            return f(c11, c12, builder.a());
        } catch (IllegalStateException e10) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 18);
            sb3.append("Could not parse '");
            sb3.append(str);
            sb3.append("'");
            throw new IllegalArgumentException(sb3.toString(), e10);
        }
    }

    public h A(String str, String str2) {
        return C(str, ImmutableSet.of(str2));
    }

    public h B(z0<String, String> z0Var) {
        return f(this.f28474a, this.f28475b, z0Var);
    }

    public h C(String str, Iterable<String> iterable) {
        u.E(str);
        u.E(iterable);
        String t10 = t(str);
        ImmutableListMultimap.a builder = ImmutableListMultimap.builder();
        z1<Map.Entry<String, String>> it = this.f28476c.entries().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            String key = next.getKey();
            if (!t10.equals(key)) {
                builder.f(key, next.getValue());
            }
        }
        Iterator<String> it2 = iterable.iterator();
        while (it2.hasNext()) {
            builder.f(t10, s(t10, it2.next()));
        }
        h hVar = new h(this.f28474a, this.f28475b, builder.a());
        if (!t10.equals(f28414g)) {
            hVar.f28479f = this.f28479f;
        }
        return (h) com.google.common.base.a.a(f28450s.get(hVar), hVar);
    }

    public h D() {
        return this.f28476c.isEmpty() ? this : e(this.f28474a, this.f28475b);
    }

    public Optional<Charset> c() {
        Optional<Charset> optional = this.f28479f;
        if (optional == null) {
            optional = Optional.absent();
            z1<String> it = this.f28476c.get((ImmutableListMultimap<String, String>) f28414g).iterator();
            String str = null;
            while (it.hasNext()) {
                String next = it.next();
                if (str == null) {
                    optional = Optional.of(Charset.forName(next));
                    str = next;
                } else if (!str.equals(next)) {
                    StringBuilder sb2 = new StringBuilder(str.length() + 35 + String.valueOf(next).length());
                    sb2.append("Multiple charset values defined: ");
                    sb2.append(str);
                    sb2.append(", ");
                    sb2.append(next);
                    throw new IllegalStateException(sb2.toString());
                }
            }
            this.f28479f = optional;
        }
        return optional;
    }

    public final String d() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f28474a);
        sb2.append('/');
        sb2.append(this.f28475b);
        if (!this.f28476c.isEmpty()) {
            sb2.append(t8.a.f30754i);
            D1.d(sb2, Multimaps.E(this.f28476c, new n() { // from class: m5.f
                @Override // b5.n
                public final Object apply(Object obj) {
                    String r10;
                    r10 = h.r((String) obj);
                    return r10;
                }
            }).entries());
        }
        return sb2.toString();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f28474a.equals(hVar.f28474a) && this.f28475b.equals(hVar.f28475b) && v().equals(hVar.v());
    }

    public int hashCode() {
        int i10 = this.f28478e;
        if (i10 != 0) {
            return i10;
        }
        int b10 = r.b(this.f28474a, this.f28475b, v());
        this.f28478e = b10;
        return b10;
    }

    public boolean p() {
        return f28447r.equals(this.f28474a) || f28447r.equals(this.f28475b);
    }

    public boolean q(h hVar) {
        return (hVar.f28474a.equals(f28447r) || hVar.f28474a.equals(this.f28474a)) && (hVar.f28475b.equals(f28447r) || hVar.f28475b.equals(this.f28475b)) && this.f28476c.entries().containsAll(hVar.f28476c.entries());
    }

    public String toString() {
        String str = this.f28477d;
        if (str != null) {
            return str;
        }
        String d10 = d();
        this.f28477d = d10;
        return d10;
    }

    public ImmutableListMultimap<String, String> u() {
        return this.f28476c;
    }

    public final Map<String, ImmutableMultiset<String>> v() {
        return Maps.B0(this.f28476c.asMap(), new n() { // from class: m5.g
            @Override // b5.n
            public final Object apply(Object obj) {
                return ImmutableMultiset.copyOf((Collection) obj);
            }
        });
    }

    public String x() {
        return this.f28475b;
    }

    public String y() {
        return this.f28474a;
    }

    public h z(Charset charset) {
        u.E(charset);
        h A2 = A(f28414g, charset.name());
        A2.f28479f = Optional.of(charset);
        return A2;
    }
}
