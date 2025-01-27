package com.vivo.mobilead.lottie.c.b;

import android.graphics.Paint;
import com.vivo.mobilead.lottie.a.a.r;
import java.util.List;

/* loaded from: classes4.dex */
public class p implements com.vivo.mobilead.lottie.c.b.b {

    /* renamed from: a */
    private final String f29291a;

    /* renamed from: b */
    private final com.vivo.mobilead.lottie.c.a.b f29292b;

    /* renamed from: c */
    private final List<com.vivo.mobilead.lottie.c.a.b> f29293c;

    /* renamed from: d */
    private final com.vivo.mobilead.lottie.c.a.a f29294d;

    /* renamed from: e */
    private final com.vivo.mobilead.lottie.c.a.d f29295e;

    /* renamed from: f */
    private final com.vivo.mobilead.lottie.c.a.b f29296f;

    /* renamed from: g */
    private final a f29297g;

    /* renamed from: h */
    private final b f29298h;

    /* renamed from: i */
    private final float f29299i;

    /* renamed from: j */
    private final boolean f29300j;

    /* renamed from: com.vivo.mobilead.lottie.c.b.p$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f29301a;

        /* renamed from: b */
        static final /* synthetic */ int[] f29302b;

        static {
            int[] iArr = new int[b.values().length];
            f29302b = iArr;
            try {
                iArr[b.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29302b[b.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29302b[b.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[a.values().length];
            f29301a = iArr2;
            try {
                iArr2[a.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29301a[a.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29301a[a.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum a {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap a() {
            int i2 = AnonymousClass1.f29301a[ordinal()];
            return i2 != 1 ? i2 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }
    }

    public enum b {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join a() {
            int i2 = AnonymousClass1.f29302b[ordinal()];
            if (i2 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i2 == 2) {
                return Paint.Join.MITER;
            }
            if (i2 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public p(String str, com.vivo.mobilead.lottie.c.a.b bVar, List<com.vivo.mobilead.lottie.c.a.b> list, com.vivo.mobilead.lottie.c.a.a aVar, com.vivo.mobilead.lottie.c.a.d dVar, com.vivo.mobilead.lottie.c.a.b bVar2, a aVar2, b bVar3, float f2, boolean z) {
        this.f29291a = str;
        this.f29292b = bVar;
        this.f29293c = list;
        this.f29294d = aVar;
        this.f29295e = dVar;
        this.f29296f = bVar2;
        this.f29297g = aVar2;
        this.f29298h = bVar3;
        this.f29299i = f2;
        this.f29300j = z;
    }

    @Override // com.vivo.mobilead.lottie.c.b.b
    public com.vivo.mobilead.lottie.a.a.c a(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar) {
        return new r(cVar, aVar, this);
    }

    public String a() {
        return this.f29291a;
    }

    public com.vivo.mobilead.lottie.c.a.a b() {
        return this.f29294d;
    }

    public com.vivo.mobilead.lottie.c.a.d c() {
        return this.f29295e;
    }

    public com.vivo.mobilead.lottie.c.a.b d() {
        return this.f29296f;
    }

    public List<com.vivo.mobilead.lottie.c.a.b> e() {
        return this.f29293c;
    }

    public com.vivo.mobilead.lottie.c.a.b f() {
        return this.f29292b;
    }

    public a g() {
        return this.f29297g;
    }

    public b h() {
        return this.f29298h;
    }

    public float i() {
        return this.f29299i;
    }

    public boolean j() {
        return this.f29300j;
    }
}
