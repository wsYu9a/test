package k6;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a */
    public final int f27710a;

    /* renamed from: b */
    public final int f27711b;

    public b(int i10, int i11) {
        this.f27710a = i10;
        this.f27711b = i11;
    }

    public final int a() {
        return this.f27711b;
    }

    public final int b() {
        return this.f27710a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f27710a == bVar.f27710a && this.f27711b == bVar.f27711b;
    }

    public final int hashCode() {
        return this.f27710a ^ this.f27711b;
    }

    public final String toString() {
        return this.f27710a + "(" + this.f27711b + ')';
    }
}
