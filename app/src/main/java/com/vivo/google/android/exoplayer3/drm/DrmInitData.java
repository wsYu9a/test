package com.vivo.google.android.exoplayer3.drm;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.C;
import com.vivo.google.android.exoplayer3.g1;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class DrmInitData implements Comparator<SchemeData>, Parcelable {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new a();

    /* renamed from: a */
    public final SchemeData[] f27299a;

    /* renamed from: b */
    public int f27300b;

    /* renamed from: c */
    public final int f27301c;

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new a();

        /* renamed from: a */
        public int f27302a;

        /* renamed from: b */
        public final UUID f27303b;

        /* renamed from: c */
        public final String f27304c;

        /* renamed from: d */
        public final byte[] f27305d;

        /* renamed from: e */
        public final boolean f27306e;

        public static class a implements Parcelable.Creator<SchemeData> {
            @Override // android.os.Parcelable.Creator
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SchemeData[] newArray(int i2) {
                return new SchemeData[i2];
            }
        }

        public SchemeData(Parcel parcel) {
            this.f27303b = new UUID(parcel.readLong(), parcel.readLong());
            this.f27304c = parcel.readString();
            this.f27305d = parcel.createByteArray();
            this.f27306e = parcel.readByte() != 0;
        }

        public SchemeData(UUID uuid, String str, byte[] bArr, boolean z) {
            this.f27303b = (UUID) g1.a(uuid);
            this.f27304c = (String) g1.a(str);
            this.f27305d = (byte[]) g1.a(bArr);
            this.f27306e = z;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            SchemeData schemeData = (SchemeData) obj;
            return this.f27304c.equals(schemeData.f27304c) && Util.areEqual(this.f27303b, schemeData.f27303b) && Arrays.equals(this.f27305d, schemeData.f27305d);
        }

        public int hashCode() {
            if (this.f27302a == 0) {
                this.f27302a = (((this.f27303b.hashCode() * 31) + this.f27304c.hashCode()) * 31) + Arrays.hashCode(this.f27305d);
            }
            return this.f27302a;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f27303b.getMostSignificantBits());
            parcel.writeLong(this.f27303b.getLeastSignificantBits());
            parcel.writeString(this.f27304c);
            parcel.writeByteArray(this.f27305d);
            parcel.writeByte(this.f27306e ? (byte) 1 : (byte) 0);
        }
    }

    public static class a implements Parcelable.Creator<DrmInitData> {
        @Override // android.os.Parcelable.Creator
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DrmInitData[] newArray(int i2) {
            return new DrmInitData[i2];
        }
    }

    public DrmInitData(Parcel parcel) {
        SchemeData[] schemeDataArr = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.f27299a = schemeDataArr;
        this.f27301c = schemeDataArr.length;
    }

    public DrmInitData(boolean z, SchemeData... schemeDataArr) {
        schemeDataArr = z ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        Arrays.sort(schemeDataArr, this);
        for (int i2 = 1; i2 < schemeDataArr.length; i2++) {
            if (schemeDataArr[i2 - 1].f27303b.equals(schemeDataArr[i2].f27303b)) {
                throw new IllegalArgumentException("Duplicate data for uuid: " + schemeDataArr[i2].f27303b);
            }
        }
        this.f27299a = schemeDataArr;
        this.f27301c = schemeDataArr.length;
    }

    @Override // java.util.Comparator
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        SchemeData schemeData3 = schemeData;
        SchemeData schemeData4 = schemeData2;
        UUID uuid = C.UUID_NIL;
        return uuid.equals(schemeData3.f27303b) ? uuid.equals(schemeData4.f27303b) ? 0 : 1 : schemeData3.f27303b.compareTo(schemeData4.f27303b);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DrmInitData.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f27299a, ((DrmInitData) obj).f27299a);
    }

    public int hashCode() {
        if (this.f27300b == 0) {
            this.f27300b = Arrays.hashCode(this.f27299a);
        }
        return this.f27300b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeTypedArray(this.f27299a, 0);
    }
}
