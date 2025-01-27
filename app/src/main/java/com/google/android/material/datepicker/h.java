package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.material.datepicker.a;
import java.util.Arrays;

/* loaded from: classes.dex */
public class h implements a.c {
    public static final Parcelable.Creator<h> CREATOR = new a();

    /* renamed from: a */
    private final long f7038a;

    static class a implements Parcelable.Creator<h> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: a */
        public h createFromParcel(@NonNull Parcel parcel) {
            return new h(parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        @NonNull
        /* renamed from: b */
        public h[] newArray(int i2) {
            return new h[i2];
        }
    }

    /* synthetic */ h(long j2, a aVar) {
        this(j2);
    }

    @NonNull
    public static h a(long j2) {
        return new h(j2);
    }

    @NonNull
    public static h b() {
        return a(w.t().getTimeInMillis());
    }

    @Override // com.google.android.material.datepicker.a.c
    public boolean c(long j2) {
        return j2 <= this.f7038a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && this.f7038a == ((h) obj).f7038a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f7038a)});
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i2) {
        parcel.writeLong(this.f7038a);
    }

    private h(long j2) {
        this.f7038a = j2;
    }
}
