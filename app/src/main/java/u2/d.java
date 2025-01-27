package u2;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    public String f30928a;

    /* renamed from: b */
    public int f30929b;

    /* renamed from: c */
    public long f30930c = System.currentTimeMillis() + 86400000;

    public d(String str, int i10) {
        this.f30928a = str;
        this.f30929b = i10;
    }

    public String toString() {
        return "ValueData{value='" + this.f30928a + "', code=" + this.f30929b + ", expired=" + this.f30930c + '}';
    }
}
