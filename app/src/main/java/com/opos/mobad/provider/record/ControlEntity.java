package com.opos.mobad.provider.record;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class ControlEntity implements Parcelable {
    public static final Parcelable.Creator<ControlEntity> CREATOR = new Parcelable.Creator<ControlEntity>() { // from class: com.opos.mobad.provider.record.ControlEntity.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ControlEntity createFromParcel(Parcel parcel) {
            return new ControlEntity(parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readLong(), parcel.readInt() == 1);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ControlEntity[] newArray(int i2) {
            return new ControlEntity[0];
        }
    };

    /* renamed from: a */
    public final boolean f23141a;

    /* renamed from: b */
    public final boolean f23142b;

    /* renamed from: c */
    public final boolean f23143c;

    /* renamed from: d */
    public final long f23144d;

    /* renamed from: e */
    public final boolean f23145e;

    /* renamed from: f */
    public final boolean f23146f;

    /* renamed from: g */
    public final boolean f23147g;

    /* renamed from: h */
    public final boolean f23148h;

    /* renamed from: com.opos.mobad.provider.record.ControlEntity$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<ControlEntity> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ControlEntity createFromParcel(Parcel parcel) {
            return new ControlEntity(parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readInt() == 1, parcel.readLong(), parcel.readInt() == 1);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ControlEntity[] newArray(int i2) {
            return new ControlEntity[0];
        }
    }

    public ControlEntity(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, long j2, boolean z7) {
        this.f23141a = z;
        this.f23142b = z2;
        this.f23143c = z3;
        this.f23144d = j2;
        this.f23145e = z4;
        this.f23146f = z5;
        this.f23147g = z6;
        this.f23148h = z7;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f23141a ? 1 : 0);
        parcel.writeInt(this.f23142b ? 1 : 0);
        parcel.writeInt(this.f23143c ? 1 : 0);
        parcel.writeLong(this.f23144d);
        parcel.writeInt(this.f23145e ? 1 : 0);
        parcel.writeInt(this.f23146f ? 1 : 0);
        parcel.writeInt(this.f23147g ? 1 : 0);
        parcel.writeInt(this.f23148h ? 1 : 0);
    }
}
