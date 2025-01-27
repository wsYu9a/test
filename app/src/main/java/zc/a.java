package zc;

import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a */
    public final int f33753a;

    /* renamed from: b */
    public final int f33754b;

    /* renamed from: c */
    @k
    public final String f33755c;

    /* renamed from: d */
    @k
    public final String f33756d;

    public a(int i10, int i11, @k String text, @k String desc) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.f33753a = i10;
        this.f33754b = i11;
        this.f33755c = text;
        this.f33756d = desc;
    }

    public static /* synthetic */ a f(a aVar, int i10, int i11, String str, String str2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = aVar.f33753a;
        }
        if ((i12 & 2) != 0) {
            i11 = aVar.f33754b;
        }
        if ((i12 & 4) != 0) {
            str = aVar.f33755c;
        }
        if ((i12 & 8) != 0) {
            str2 = aVar.f33756d;
        }
        return aVar.e(i10, i11, str, str2);
    }

    public final int a() {
        return this.f33753a;
    }

    public final int b() {
        return this.f33754b;
    }

    @k
    public final String c() {
        return this.f33755c;
    }

    @k
    public final String d() {
        return this.f33756d;
    }

    @k
    public final a e(int i10, int i11, @k String text, @k String desc) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new a(i10, i11, text, desc);
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f33753a == aVar.f33753a && this.f33754b == aVar.f33754b && Intrinsics.areEqual(this.f33755c, aVar.f33755c) && Intrinsics.areEqual(this.f33756d, aVar.f33756d);
    }

    @k
    public final String g() {
        return this.f33756d;
    }

    public final int h() {
        return this.f33753a;
    }

    public int hashCode() {
        return (((((this.f33753a * 31) + this.f33754b) * 31) + this.f33755c.hashCode()) * 31) + this.f33756d.hashCode();
    }

    @k
    public final String i() {
        return this.f33755c;
    }

    public final int j() {
        return this.f33754b;
    }

    @k
    public String toString() {
        return "GridItem(iconResId=" + this.f33753a + ", vipIconResId=" + this.f33754b + ", text=" + this.f33755c + ", desc=" + this.f33756d + ")";
    }
}
