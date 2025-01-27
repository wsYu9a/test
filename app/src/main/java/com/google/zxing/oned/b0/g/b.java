package com.google.zxing.oned.b0.g;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a */
    private final boolean f8544a;

    /* renamed from: b */
    private final com.google.zxing.oned.b0.b f8545b;

    /* renamed from: c */
    private final com.google.zxing.oned.b0.b f8546c;

    /* renamed from: d */
    private final com.google.zxing.oned.b0.c f8547d;

    b(com.google.zxing.oned.b0.b bVar, com.google.zxing.oned.b0.b bVar2, com.google.zxing.oned.b0.c cVar, boolean z) {
        this.f8545b = bVar;
        this.f8546c = bVar2;
        this.f8547d = cVar;
        this.f8544a = z;
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    com.google.zxing.oned.b0.c b() {
        return this.f8547d;
    }

    com.google.zxing.oned.b0.b c() {
        return this.f8545b;
    }

    com.google.zxing.oned.b0.b d() {
        return this.f8546c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a(this.f8545b, bVar.f8545b) && a(this.f8546c, bVar.f8546c) && a(this.f8547d, bVar.f8547d);
    }

    boolean f() {
        return this.f8544a;
    }

    public boolean g() {
        return this.f8546c == null;
    }

    public int hashCode() {
        return (e(this.f8545b) ^ e(this.f8546c)) ^ e(this.f8547d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f8545b);
        sb.append(" , ");
        sb.append(this.f8546c);
        sb.append(" : ");
        com.google.zxing.oned.b0.c cVar = this.f8547d;
        sb.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb.append(" ]");
        return sb.toString();
    }
}
