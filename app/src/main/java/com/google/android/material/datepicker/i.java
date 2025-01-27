package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.a;
import java.util.Arrays;

/* loaded from: classes.dex */
public class i implements a.c {
    public static final Parcelable.Creator<i> CREATOR = new a();

    /* renamed from: a */
    private final long f7039a;

    static class a implements Parcelable.Creator<i> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public i createFromParcel(@NonNull Parcel parcel) {
            return new i(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public i[] newArray(int i2) {
            return new i[i2];
        }
    }

    /* synthetic */ i(long j2, a aVar) {
        this(j2);
    }

    @NonNull
    public static i a(long j2) {
        return new i(j2);
    }

    @NonNull
    public static i b() {
        return a(w.t().getTimeInMillis());
    }

    @Override // com.google.android.material.datepicker.a.c
    public boolean c(long j2) {
        return j2 >= this.f7039a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f7039a == ((i) obj).f7039a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f7039a)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeLong(this.f7039a);
    }

    private i(long j2) {
        this.f7039a = j2;
    }
}
