package gk;

/* loaded from: classes5.dex */
public class i<T> {

    /* renamed from: a */
    public final long f26358a;

    /* renamed from: b */
    public final T f26359b;

    public i(long j10, T t10) {
        this.f26359b = t10;
        this.f26358a = j10;
    }

    public long a() {
        return this.f26358a;
    }

    public T b() {
        return this.f26359b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f26358a != iVar.f26358a) {
            return false;
        }
        T t10 = this.f26359b;
        if (t10 == null) {
            if (iVar.f26359b != null) {
                return false;
            }
        } else if (!t10.equals(iVar.f26359b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        long j10 = this.f26358a;
        int i10 = (((int) (j10 ^ (j10 >>> 32))) + 31) * 31;
        T t10 = this.f26359b;
        return i10 + (t10 == null ? 0 : t10.hashCode());
    }

    public String toString() {
        return "TimeInterval [intervalInMilliseconds=" + this.f26358a + ", value=" + this.f26359b + "]";
    }
}
