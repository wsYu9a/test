package rx.n;

/* loaded from: classes5.dex */
public final class j<T> {

    /* renamed from: a */
    private final long f36977a;

    /* renamed from: b */
    private final T f36978b;

    public j(long j2, T t) {
        this.f36978b = t;
        this.f36977a = j2;
    }

    public long a() {
        return this.f36977a;
    }

    public T b() {
        return this.f36978b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f36977a != jVar.f36977a) {
            return false;
        }
        T t = this.f36978b;
        if (t == null) {
            if (jVar.f36978b != null) {
                return false;
            }
        } else if (!t.equals(jVar.f36978b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j2 = this.f36977a;
        int i2 = (((int) (j2 ^ (j2 >>> 32))) + 31) * 31;
        T t = this.f36978b;
        return i2 + (t == null ? 0 : t.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f36977a), this.f36978b.toString());
    }
}
