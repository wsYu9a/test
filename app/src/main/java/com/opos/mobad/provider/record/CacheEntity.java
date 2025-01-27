package com.opos.mobad.provider.record;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class CacheEntity implements Parcelable {
    public static final Parcelable.Creator<CacheEntity> CREATOR = new Parcelable.Creator<CacheEntity>() { // from class: com.opos.mobad.provider.record.CacheEntity.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CacheEntity createFromParcel(Parcel parcel) {
            return new CacheEntity(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CacheEntity[] newArray(int i2) {
            return new CacheEntity[0];
        }
    };

    /* renamed from: a */
    public final int f23139a;

    /* renamed from: b */
    public final int f23140b;

    /* renamed from: com.opos.mobad.provider.record.CacheEntity$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<CacheEntity> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CacheEntity createFromParcel(Parcel parcel) {
            return new CacheEntity(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CacheEntity[] newArray(int i2) {
            return new CacheEntity[0];
        }
    }

    public CacheEntity(int i2, int i3) {
        this.f23139a = i2;
        this.f23140b = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f23139a);
        parcel.writeInt(this.f23140b);
    }
}
