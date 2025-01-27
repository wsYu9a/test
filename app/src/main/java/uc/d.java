package uc;

import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class d<T> {

    /* renamed from: a */
    @SerializedName(h3.e.f26408m)
    @l
    private final T f30978a;

    /* renamed from: b */
    @SerializedName("errcode")
    private final int f30979b;

    /* renamed from: c */
    @SerializedName("errmsg")
    @k
    private final String f30980c;

    /* renamed from: d */
    public long f30981d;

    public d(@l T t10, int i10, @k String errorMsg, long j10) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.f30978a = t10;
        this.f30979b = i10;
        this.f30980c = errorMsg;
        this.f30981d = j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ d f(d dVar, Object obj, int i10, String str, long j10, int i11, Object obj2) {
        T t10 = obj;
        if ((i11 & 1) != 0) {
            t10 = dVar.f30978a;
        }
        if ((i11 & 2) != 0) {
            i10 = dVar.f30979b;
        }
        int i12 = i10;
        if ((i11 & 4) != 0) {
            str = dVar.f30980c;
        }
        String str2 = str;
        if ((i11 & 8) != 0) {
            j10 = dVar.f30981d;
        }
        return dVar.e(t10, i12, str2, j10);
    }

    @l
    public final T a() {
        return this.f30978a;
    }

    public final int b() {
        return this.f30979b;
    }

    @k
    public final String c() {
        return this.f30980c;
    }

    public final long d() {
        return this.f30981d;
    }

    @k
    public final d<T> e(@l T t10, int i10, @k String errorMsg, long j10) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        return new d<>(t10, i10, errorMsg, j10);
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return Intrinsics.areEqual(this.f30978a, dVar.f30978a) && this.f30979b == dVar.f30979b && Intrinsics.areEqual(this.f30980c, dVar.f30980c) && this.f30981d == dVar.f30981d;
    }

    @l
    public final T g() {
        return this.f30978a;
    }

    public final int h() {
        return this.f30979b;
    }

    public int hashCode() {
        T t10 = this.f30978a;
        return ((((((t10 == null ? 0 : t10.hashCode()) * 31) + this.f30979b) * 31) + this.f30980c.hashCode()) * 31) + c.a(this.f30981d);
    }

    @k
    public final String i() {
        return this.f30980c;
    }

    public final long j() {
        return this.f30981d;
    }

    public final boolean k() {
        return this.f30979b == 0;
    }

    public final void l(long j10) {
        this.f30981d = j10;
    }

    @k
    public String toString() {
        return "HttpResult(data=" + this.f30978a + ", errorCode=" + this.f30979b + ", errorMsg=" + this.f30980c + ", serverTime=" + this.f30981d + ")";
    }

    public /* synthetic */ d(Object obj, int i10, String str, long j10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, i10, (i11 & 4) != 0 ? "" : str, (i11 & 8) != 0 ? System.currentTimeMillis() : j10);
    }
}
