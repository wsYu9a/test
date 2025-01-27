package com.opos.mobad.provider.strategy;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class AppInfo implements Parcelable {
    public static final Parcelable.Creator<AppInfo> CREATOR = new Parcelable.Creator<AppInfo>() { // from class: com.opos.mobad.provider.strategy.AppInfo.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppInfo createFromParcel(Parcel parcel) {
            long readLong = parcel.readLong();
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return new AppInfo(readLong, bArr);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppInfo[] newArray(int i2) {
            return new AppInfo[i2];
        }
    };

    /* renamed from: a */
    public final long f23160a;

    /* renamed from: b */
    public final byte[] f23161b;

    /* renamed from: com.opos.mobad.provider.strategy.AppInfo$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<AppInfo> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppInfo createFromParcel(Parcel parcel) {
            long readLong = parcel.readLong();
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            return new AppInfo(readLong, bArr);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppInfo[] newArray(int i2) {
            return new AppInfo[i2];
        }
    }

    public AppInfo(long j2, byte[] bArr) {
        this.f23160a = j2;
        this.f23161b = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f23160a);
        parcel.writeInt(this.f23161b.length);
        parcel.writeByteArray(this.f23161b);
    }
}
