package com.tencent.bugly.beta.upgrade;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.AbstractC0909m;
import com.tencent.bugly.proguard.B;
import com.tencent.bugly.proguard.M;

/* loaded from: classes4.dex */
public class BetaGrayStrategy implements Parcelable, Parcelable.Creator<BetaGrayStrategy> {
    public static final Parcelable.Creator<BetaGrayStrategy> CREATOR = new BetaGrayStrategy();

    /* renamed from: a */
    public B f24634a;

    /* renamed from: b */
    public int f24635b;

    /* renamed from: c */
    public long f24636c;

    /* renamed from: d */
    public boolean f24637d;

    /* renamed from: e */
    public long f24638e;

    public BetaGrayStrategy(Parcel parcel) {
        this.f24635b = 0;
        this.f24636c = -1L;
        this.f24637d = false;
        this.f24638e = -1L;
        this.f24634a = (B) M.a(parcel.createByteArray(), B.class);
        this.f24635b = parcel.readInt();
        this.f24636c = parcel.readLong();
        this.f24637d = 1 == parcel.readByte();
        this.f24638e = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(M.a((AbstractC0909m) this.f24634a));
        parcel.writeInt(this.f24635b);
        parcel.writeLong(this.f24636c);
        parcel.writeByte(this.f24637d ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f24638e);
    }

    @Override // android.os.Parcelable.Creator
    public BetaGrayStrategy createFromParcel(Parcel parcel) {
        return new BetaGrayStrategy(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public BetaGrayStrategy[] newArray(int i2) {
        return new BetaGrayStrategy[i2];
    }

    public BetaGrayStrategy() {
        this.f24635b = 0;
        this.f24636c = -1L;
        this.f24637d = false;
        this.f24638e = -1L;
    }
}
