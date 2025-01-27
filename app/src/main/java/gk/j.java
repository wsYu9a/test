package gk;

/* loaded from: classes5.dex */
public final class j<T> {

    /* renamed from: a */
    public final long f26360a;

    /* renamed from: b */
    public final T f26361b;

    public j(long j10, T t10) {
        this.f26361b = t10;
        this.f26360a = j10;
    }

    public long a() {
        return this.f26360a;
    }

    public T b() {
        return this.f26361b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f26360a != jVar.f26360a) {
            return false;
        }
        T t10 = this.f26361b;
        if (t10 == null) {
            if (jVar.f26361b != null) {
                return false;
            }
        } else if (!t10.equals(jVar.f26361b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j10 = this.f26360a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) + 31) * 31;
        T t10 = this.f26361b;
        return i10 + (t10 == null ? 0 : t10.hashCode());
    }

    public String toString() {
        return String.format("Timestamped(timestampMillis = %d, value = %s)", Long.valueOf(this.f26360a), this.f26361b.toString());
    }
}
