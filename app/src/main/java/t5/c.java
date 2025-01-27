package t5;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    public final int f30701a;

    /* renamed from: b */
    public final int f30702b;

    public c(int i10, int i11) {
        if (i10 < 0 || i11 < 0) {
            throw new IllegalArgumentException();
        }
        this.f30701a = i10;
        this.f30702b = i11;
    }

    public int a() {
        return this.f30702b;
    }

    public int b() {
        return this.f30701a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f30701a == cVar.f30701a && this.f30702b == cVar.f30702b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f30701a * 32713) + this.f30702b;
    }

    public String toString() {
        return this.f30701a + "x" + this.f30702b;
    }
}
