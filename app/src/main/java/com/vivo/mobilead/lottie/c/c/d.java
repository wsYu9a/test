package com.vivo.mobilead.lottie.c.c;

import com.vivo.mobilead.lottie.LottieComposition;
import com.vivo.mobilead.lottie.c.a.j;
import com.vivo.mobilead.lottie.c.a.k;
import com.vivo.mobilead.lottie.c.a.l;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private final List<com.vivo.mobilead.lottie.c.b.b> f29349a;

    /* renamed from: b */
    private final LottieComposition f29350b;

    /* renamed from: c */
    private final String f29351c;

    /* renamed from: d */
    private final long f29352d;

    /* renamed from: e */
    private final a f29353e;

    /* renamed from: f */
    private final long f29354f;

    /* renamed from: g */
    private final String f29355g;

    /* renamed from: h */
    private final List<com.vivo.mobilead.lottie.c.b.g> f29356h;

    /* renamed from: i */
    private final l f29357i;

    /* renamed from: j */
    private final int f29358j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;
    private final j q;
    private final k r;
    private final com.vivo.mobilead.lottie.c.a.b s;
    private final List<com.vivo.mobilead.lottie.g.a<Float>> t;
    private final b u;
    private final boolean v;

    public enum a {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum b {
        NONE,
        ADD,
        INVERT,
        UNKNOWN
    }

    public d(List<com.vivo.mobilead.lottie.c.b.b> list, LottieComposition lottieComposition, String str, long j2, a aVar, long j3, String str2, List<com.vivo.mobilead.lottie.c.b.g> list2, l lVar, int i2, int i3, int i4, float f2, float f3, int i5, int i6, j jVar, k kVar, List<com.vivo.mobilead.lottie.g.a<Float>> list3, b bVar, com.vivo.mobilead.lottie.c.a.b bVar2, boolean z) {
        this.f29349a = list;
        this.f29350b = lottieComposition;
        this.f29351c = str;
        this.f29352d = j2;
        this.f29353e = aVar;
        this.f29354f = j3;
        this.f29355g = str2;
        this.f29356h = list2;
        this.f29357i = lVar;
        this.f29358j = i2;
        this.k = i3;
        this.l = i4;
        this.m = f2;
        this.n = f3;
        this.o = i5;
        this.p = i6;
        this.q = jVar;
        this.r = kVar;
        this.t = list3;
        this.u = bVar;
        this.s = bVar2;
        this.v = z;
    }

    LottieComposition a() {
        return this.f29350b;
    }

    public String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(f());
        sb.append("\n");
        d layerModelForId = this.f29350b.layerModelForId(m());
        if (layerModelForId != null) {
            String str2 = "\t\tParents: ";
            while (true) {
                sb.append(str2);
                sb.append(layerModelForId.f());
                layerModelForId = this.f29350b.layerModelForId(layerModelForId.m());
                if (layerModelForId == null) {
                    break;
                }
                str2 = "->";
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!j().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(j().size());
            sb.append("\n");
        }
        if (r() != 0 && q() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(r()), Integer.valueOf(q()), Integer.valueOf(p())));
        }
        if (!this.f29349a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.vivo.mobilead.lottie.c.b.b bVar : this.f29349a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(bVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    float b() {
        return this.m;
    }

    float c() {
        return this.n / this.f29350b.getDurationFrames();
    }

    List<com.vivo.mobilead.lottie.g.a<Float>> d() {
        return this.t;
    }

    public long e() {
        return this.f29352d;
    }

    String f() {
        return this.f29351c;
    }

    String g() {
        return this.f29355g;
    }

    int h() {
        return this.o;
    }

    int i() {
        return this.p;
    }

    List<com.vivo.mobilead.lottie.c.b.g> j() {
        return this.f29356h;
    }

    public a k() {
        return this.f29353e;
    }

    b l() {
        return this.u;
    }

    long m() {
        return this.f29354f;
    }

    List<com.vivo.mobilead.lottie.c.b.b> n() {
        return this.f29349a;
    }

    l o() {
        return this.f29357i;
    }

    int p() {
        return this.l;
    }

    int q() {
        return this.k;
    }

    int r() {
        return this.f29358j;
    }

    j s() {
        return this.q;
    }

    k t() {
        return this.r;
    }

    public String toString() {
        return a("");
    }

    com.vivo.mobilead.lottie.c.a.b u() {
        return this.s;
    }

    public boolean v() {
        return this.v;
    }
}
