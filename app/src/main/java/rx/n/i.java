package rx.n;

/* loaded from: classes5.dex */
public class i<T> {

    /* renamed from: a */
    private final long f36975a;

    /* renamed from: b */
    private final T f36976b;

    public i(long j2, T t) {
        this.f36976b = t;
        this.f36975a = j2;
    }

    public long a() {
        return this.f36975a;
    }

    public T b() {
        return this.f36976b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f36975a != iVar.f36975a) {
            return false;
        }
        T t = this.f36976b;
        if (t == null) {
            if (iVar.f36976b != null) {
                return false;
            }
        } else if (!t.equals(iVar.f36976b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j2 = this.f36975a;
        int i2 = (((int) (j2 ^ (j2 >>> 32))) + 31) * 31;
        T t = this.f36976b;
        return i2 + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return "TimeInterval [intervalInMilliseconds=" + this.f36975a + ", value=" + this.f36976b + "]";
    }
}
