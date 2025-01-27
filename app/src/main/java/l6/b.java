package l6;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a */
    public final boolean f27930a;

    /* renamed from: b */
    public final k6.b f27931b;

    /* renamed from: c */
    public final k6.b f27932c;

    /* renamed from: d */
    public final k6.c f27933d;

    public b(k6.b bVar, k6.b bVar2, k6.c cVar, boolean z10) {
        this.f27931b = bVar;
        this.f27932c = bVar2;
        this.f27933d = cVar;
        this.f27930a = z10;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public k6.c b() {
        return this.f27933d;
    }

    public k6.b c() {
        return this.f27931b;
    }

    public k6.b d() {
        return this.f27932c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a(this.f27931b, bVar.f27931b) && a(this.f27932c, bVar.f27932c) && a(this.f27933d, bVar.f27933d);
    }

    public boolean f() {
        return this.f27930a;
    }

    public boolean g() {
        return this.f27932c == null;
    }

    public int hashCode() {
        return (e(this.f27931b) ^ e(this.f27932c)) ^ e(this.f27933d);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("[ ");
        sb2.append(this.f27931b);
        sb2.append(" , ");
        sb2.append(this.f27932c);
        sb2.append(" : ");
        k6.c cVar = this.f27933d;
        sb2.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb2.append(" ]");
        return sb2.toString();
    }
}
