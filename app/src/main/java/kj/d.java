package kj;

/* loaded from: classes4.dex */
public final class d {

    /* renamed from: c */
    public long f27858c = System.currentTimeMillis() + 86400000;

    /* renamed from: a */
    public String f27856a = null;

    /* renamed from: b */
    public int f27857b = 0;

    public final String toString() {
        StringBuilder a10 = nh.b.a("ValueData{value='");
        a10.append(this.f27856a);
        a10.append('\'');
        a10.append(", code=");
        a10.append(this.f27857b);
        a10.append(", expired=");
        a10.append(this.f27858c);
        a10.append('}');
        return a10.toString();
    }
}
