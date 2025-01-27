package zc;

import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a */
    public final int f33757a;

    /* renamed from: b */
    @k
    public final String f33758b;

    /* renamed from: c */
    @l
    public final String f33759c;

    /* renamed from: d */
    public final int f33760d;

    public b(int i10, @k String text, @l String str, int i11) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.f33757a = i10;
        this.f33758b = text;
        this.f33759c = str;
        this.f33760d = i11;
    }

    public static /* synthetic */ b f(b bVar, int i10, String str, String str2, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = bVar.f33757a;
        }
        if ((i12 & 2) != 0) {
            str = bVar.f33758b;
        }
        if ((i12 & 4) != 0) {
            str2 = bVar.f33759c;
        }
        if ((i12 & 8) != 0) {
            i11 = bVar.f33760d;
        }
        return bVar.e(i10, str, str2, i11);
    }

    public final int a() {
        return this.f33757a;
    }

    @k
    public final String b() {
        return this.f33758b;
    }

    @l
    public final String c() {
        return this.f33759c;
    }

    public final int d() {
        return this.f33760d;
    }

    @k
    public final b e(int i10, @k String text, @l String str, int i11) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new b(i10, text, str, i11);
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f33757a == bVar.f33757a && Intrinsics.areEqual(this.f33758b, bVar.f33758b) && Intrinsics.areEqual(this.f33759c, bVar.f33759c) && this.f33760d == bVar.f33760d;
    }

    public final int g() {
        return this.f33757a;
    }

    public final int h() {
        return this.f33760d;
    }

    public int hashCode() {
        int hashCode = ((this.f33757a * 31) + this.f33758b.hashCode()) * 31;
        String str = this.f33759c;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f33760d;
    }

    @l
    public final String i() {
        return this.f33759c;
    }

    @k
    public final String j() {
        return this.f33758b;
    }

    @k
    public String toString() {
        return "PaymentMethodItem(iconResId=" + this.f33757a + ", text=" + this.f33758b + ", periodTag=" + this.f33759c + ", method=" + this.f33760d + ")";
    }
}
