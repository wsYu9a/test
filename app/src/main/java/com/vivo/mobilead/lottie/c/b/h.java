package com.vivo.mobilead.lottie.c.b;

/* loaded from: classes4.dex */
public class h implements b {

    /* renamed from: a */
    private final String f29242a;

    /* renamed from: b */
    private final a f29243b;

    /* renamed from: c */
    private final boolean f29244c;

    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a a(int i2) {
            return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? MERGE : EXCLUDE_INTERSECTIONS : INTERSECT : SUBTRACT : ADD : MERGE;
        }
    }

    public h(String str, a aVar, boolean z) {
        this.f29242a = str;
        this.f29243b = aVar;
        this.f29244c = z;
    }

    @Override // com.vivo.mobilead.lottie.c.b.b
    public com.vivo.mobilead.lottie.a.a.c a(com.vivo.mobilead.lottie.c cVar, com.vivo.mobilead.lottie.c.c.a aVar) {
        if (cVar.c()) {
            return new com.vivo.mobilead.lottie.a.a.l(this);
        }
        com.vivo.mobilead.lottie.f.d.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String a() {
        return this.f29242a;
    }

    public a b() {
        return this.f29243b;
    }

    public boolean c() {
        return this.f29244c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f29243b + '}';
    }
}
