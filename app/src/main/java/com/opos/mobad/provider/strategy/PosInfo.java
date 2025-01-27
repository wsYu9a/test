package com.opos.mobad.provider.strategy;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class PosInfo implements Parcelable {
    public static final Parcelable.Creator<PosInfo> CREATOR = new Parcelable.Creator<PosInfo>() { // from class: com.opos.mobad.provider.strategy.PosInfo.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PosInfo createFromParcel(Parcel parcel) {
            long readLong = parcel.readLong();
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return new PosInfo(bArr, readLong);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PosInfo[] newArray(int i2) {
            return new PosInfo[i2];
        }
    };

    /* renamed from: a */
    public final byte[] f23162a;

    /* renamed from: b */
    public final long f23163b;

    /* renamed from: com.opos.mobad.provider.strategy.PosInfo$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<PosInfo> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PosInfo createFromParcel(Parcel parcel) {
            long readLong = parcel.readLong();
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return new PosInfo(bArr, readLong);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PosInfo[] newArray(int i2) {
            return new PosInfo[i2];
        }
    }

    public PosInfo(byte[] bArr, long j2) {
        this.f23162a = bArr;
        this.f23163b = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f23163b);
        parcel.writeInt(this.f23162a.length);
        parcel.writeByteArray(this.f23162a);
    }
}
