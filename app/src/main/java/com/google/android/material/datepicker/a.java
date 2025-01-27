package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.bytedance.pangle.ZeusPluginEventCallback;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C0089a();

    /* renamed from: a */
    @NonNull
    private final n f7005a;

    /* renamed from: b */
    @NonNull
    private final n f7006b;

    /* renamed from: c */
    @NonNull
    private final n f7007c;

    /* renamed from: d */
    private final c f7008d;

    /* renamed from: e */
    private final int f7009e;

    /* renamed from: f */
    private final int f7010f;

    /* renamed from: com.google.android.material.datepicker.a$a */
    static class C0089a implements Parcelable.Creator<a> {
        C0089a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public a createFromParcel(@NonNull Parcel parcel) {
            return new a((n) parcel.readParcelable(n.class.getClassLoader()), (n) parcel.readParcelable(n.class.getClassLoader()), (n) parcel.readParcelable(n.class.getClassLoader()), (c) parcel.readParcelable(c.class.getClassLoader()), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    }

    public interface c extends Parcelable {
        boolean c(long j2);
    }

    /* synthetic */ a(n nVar, n nVar2, n nVar3, c cVar, C0089a c0089a) {
        this(nVar, nVar2, nVar3, cVar);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f7005a.equals(aVar.f7005a) && this.f7006b.equals(aVar.f7006b) && this.f7007c.equals(aVar.f7007c) && this.f7008d.equals(aVar.f7008d);
    }

    n f(n nVar) {
        return nVar.compareTo(this.f7005a) < 0 ? this.f7005a : nVar.compareTo(this.f7006b) > 0 ? this.f7006b : nVar;
    }

    public c g() {
        return this.f7008d;
    }

    @NonNull
    n h() {
        return this.f7006b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7005a, this.f7006b, this.f7007c, this.f7008d});
    }

    int i() {
        return this.f7010f;
    }

    @NonNull
    n j() {
        return this.f7007c;
    }

    @NonNull
    n k() {
        return this.f7005a;
    }

    int l() {
        return this.f7009e;
    }

    boolean m(long j2) {
        if (this.f7005a.g(1) <= j2) {
            n nVar = this.f7006b;
            if (j2 <= nVar.g(nVar.f7076f)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f7005a, 0);
        parcel.writeParcelable(this.f7006b, 0);
        parcel.writeParcelable(this.f7007c, 0);
        parcel.writeParcelable(this.f7008d, 0);
    }

    private a(@NonNull n nVar, @NonNull n nVar2, @NonNull n nVar3, c cVar) {
        this.f7005a = nVar;
        this.f7006b = nVar2;
        this.f7007c = nVar3;
        this.f7008d = cVar;
        if (nVar.compareTo(nVar3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (nVar3.compareTo(nVar2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        this.f7010f = nVar.k(nVar2) + 1;
        this.f7009e = (nVar2.f7074d - nVar.f7074d) + 1;
    }

    public static final class b {

        /* renamed from: a */
        static final long f7011a = w.a(n.b(1900, 0).f7077g);

        /* renamed from: b */
        static final long f7012b = w.a(n.b(ZeusPluginEventCallback.EVENT_FINISH_LOAD, 11).f7077g);

        /* renamed from: c */
        private static final String f7013c = "DEEP_COPY_VALIDATOR_KEY";

        /* renamed from: d */
        private long f7014d;

        /* renamed from: e */
        private long f7015e;

        /* renamed from: f */
        private Long f7016f;

        /* renamed from: g */
        private c f7017g;

        public b() {
            this.f7014d = f7011a;
            this.f7015e = f7012b;
            this.f7017g = i.a(Long.MIN_VALUE);
        }

        @NonNull
        public a a() {
            if (this.f7016f == null) {
                long E = k.E();
                long j2 = this.f7014d;
                if (j2 > E || E > this.f7015e) {
                    E = j2;
                }
                this.f7016f = Long.valueOf(E);
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(f7013c, this.f7017g);
            return new a(n.d(this.f7014d), n.d(this.f7015e), n.d(this.f7016f.longValue()), (c) bundle.getParcelable(f7013c), null);
        }

        @NonNull
        public b b(long j2) {
            this.f7015e = j2;
            return this;
        }

        @NonNull
        public b c(long j2) {
            this.f7016f = Long.valueOf(j2);
            return this;
        }

        @NonNull
        public b d(long j2) {
            this.f7014d = j2;
            return this;
        }

        @NonNull
        public b e(c cVar) {
            this.f7017g = cVar;
            return this;
        }

        b(@NonNull a aVar) {
            this.f7014d = f7011a;
            this.f7015e = f7012b;
            this.f7017g = i.a(Long.MIN_VALUE);
            this.f7014d = aVar.f7005a.f7077g;
            this.f7015e = aVar.f7006b.f7077g;
            this.f7016f = Long.valueOf(aVar.f7007c.f7077g);
            this.f7017g = aVar.f7008d;
        }
    }
}
