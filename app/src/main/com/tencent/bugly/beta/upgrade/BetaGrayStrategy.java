package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.AbstractC0868m;
import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.M;

/* loaded from: classes4.dex */
public class BetaGrayStrategy implements Parcelable, Parcelable.Creator<BetaGrayStrategy> {
    public static final Parcelable.Creator<BetaGrayStrategy> CREATOR = new BetaGrayStrategy();

    /* renamed from: a */
    public B f22135a;

    /* renamed from: b */
    public int f22136b;

    /* renamed from: c */
    public long f22137c;

    /* renamed from: d */
    public boolean f22138d;

    /* renamed from: e */
    public long f22139e;

    public BetaGrayStrategy(Parcel parcel) {
        this.f22136b = 0;
        this.f22137c = -1L;
        this.f22138d = false;
        this.f22139e = -1L;
        this.f22135a = (B) M.a(parcel.createByteArray(), B.class);
        this.f22136b = parcel.readInt();
        this.f22137c = parcel.readLong();
        this.f22138d = 1 == parcel.readByte();
        this.f22139e = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByteArray(M.a((AbstractC0868m) this.f22135a));
        parcel.writeInt(this.f22136b);
        parcel.writeLong(this.f22137c);
        parcel.writeByte(this.f22138d ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f22139e);
    }

    @Override // android.os.Parcelable.Creator
    public BetaGrayStrategy createFromParcel(Parcel parcel) {
        return new BetaGrayStrategy(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public BetaGrayStrategy[] newArray(int i10) {
        return new BetaGrayStrategy[i10];
    }

    public BetaGrayStrategy() {
        this.f22136b = 0;
        this.f22137c = -1L;
        this.f22138d = false;
        this.f22139e = -1L;
    }
}
