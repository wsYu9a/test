package com.sigmob.sdk.nativead;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class b0 implements Parcelable {
    public static final Parcelable.Creator<b0> CREATOR = new a();

    /* renamed from: a */
    public int f19919a;

    /* renamed from: b */
    public int f19920b;

    /* renamed from: c */
    public int f19921c;

    /* renamed from: d */
    public int f19922d;

    public class a implements Parcelable.Creator<b0> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b0 createFromParcel(Parcel parcel) {
            return new b0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b0[] newArray(int i10) {
            return new b0[i10];
        }
    }

    public b0() {
    }

    public int a() {
        return this.f19922d;
    }

    public int b() {
        return this.f19921c;
    }

    public int c() {
        return this.f19919a;
    }

    public int d() {
        return this.f19920b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f19919a);
        parcel.writeInt(this.f19920b);
        parcel.writeInt(this.f19921c);
        parcel.writeInt(this.f19922d);
    }

    public b0(Parcel parcel) {
        this.f19919a = parcel.readInt();
        this.f19920b = parcel.readInt();
        this.f19921c = parcel.readInt();
        this.f19922d = parcel.readInt();
    }

    public void a(int i10) {
        this.f19922d = i10;
    }

    public void b(int i10) {
        this.f19921c = i10;
    }

    public void c(int i10) {
        this.f19919a = i10;
    }

    public void d(int i10) {
        this.f19920b = i10;
    }
}
