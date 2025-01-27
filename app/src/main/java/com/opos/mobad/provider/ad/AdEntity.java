package com.opos.mobad.provider.ad;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class AdEntity implements Parcelable {
    public static final Parcelable.Creator<AdEntity> CREATOR = new Parcelable.Creator<AdEntity>() { // from class: com.opos.mobad.provider.ad.AdEntity.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdEntity createFromParcel(Parcel parcel) {
            return new AdEntity(parcel.createByteArray(), parcel.createByteArray(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdEntity[] newArray(int i2) {
            return new AdEntity[i2];
        }
    };

    /* renamed from: a */
    public byte[] f23119a;

    /* renamed from: b */
    public byte[] f23120b;

    /* renamed from: c */
    public long f23121c;

    /* renamed from: com.opos.mobad.provider.ad.AdEntity$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<AdEntity> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdEntity createFromParcel(Parcel parcel) {
            return new AdEntity(parcel.createByteArray(), parcel.createByteArray(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdEntity[] newArray(int i2) {
            return new AdEntity[i2];
        }
    }

    public AdEntity(byte[] bArr, byte[] bArr2, long j2) {
        this.f23119a = bArr;
        this.f23120b = bArr2;
        this.f23121c = j2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByteArray(this.f23119a);
        parcel.writeByteArray(this.f23120b);
        parcel.writeLong(this.f23121c);
    }
}
