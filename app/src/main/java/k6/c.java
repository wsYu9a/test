package k6;

import t5.l;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    public final int f27712a;

    /* renamed from: b */
    public final int[] f27713b;

    /* renamed from: c */
    public final l[] f27714c;

    public c(int i10, int[] iArr, int i11, int i12, int i13) {
        this.f27712a = i10;
        this.f27713b = iArr;
        float f10 = i11;
        float f11 = i13;
        this.f27714c = new l[]{new l(f10, f11), new l(i12, f11)};
    }

    public l[] a() {
        return this.f27714c;
    }

    public int[] b() {
        return this.f27713b;
    }

    public int c() {
        return this.f27712a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.f27712a == ((c) obj).f27712a;
    }

    public int hashCode() {
        return this.f27712a;
    }
}
