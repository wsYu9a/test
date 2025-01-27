package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;
import com.google.android.material.datepicker.a;
import java.util.List;

/* loaded from: classes.dex */
public final class d implements a.c {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a */
    @NonNull
    private final List<a.c> f7032a;

    static class a implements Parcelable.Creator<d> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public d createFromParcel(@NonNull Parcel parcel) {
            return new d((List) Preconditions.checkNotNull(parcel.readArrayList(a.c.class.getClassLoader())), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public d[] newArray(int i2) {
            return new d[i2];
        }
    }

    /* synthetic */ d(List list, a aVar) {
        this(list);
    }

    @NonNull
    public static a.c a(@NonNull List<a.c> list) {
        return new d(list);
    }

    @Override // com.google.android.material.datepicker.a.c
    public boolean c(long j2) {
        for (a.c cVar : this.f7032a) {
            if (cVar != null && !cVar.c(j2)) {
                return false;
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            return this.f7032a.equals(((d) obj).f7032a);
        }
        return false;
    }

    public int hashCode() {
        return this.f7032a.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeList(this.f7032a);
    }

    private d(@NonNull List<a.c> list) {
        this.f7032a = list;
    }
}
