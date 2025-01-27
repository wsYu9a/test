package com.opos.exoplayer.core.drm;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.opos.exoplayer.core.i.u;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class DrmInitData implements Parcelable, Comparator<SchemeData> {
    public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator<DrmInitData>() { // from class: com.opos.exoplayer.core.drm.DrmInitData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DrmInitData[] newArray(int i2) {
            return new DrmInitData[i2];
        }
    };

    /* renamed from: a */
    @Nullable
    public final String f18367a;

    /* renamed from: b */
    public final int f18368b;

    /* renamed from: c */
    private final SchemeData[] f18369c;

    /* renamed from: d */
    private int f18370d;

    /* renamed from: com.opos.exoplayer.core.drm.DrmInitData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<DrmInitData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DrmInitData createFromParcel(Parcel parcel) {
            return new DrmInitData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public DrmInitData[] newArray(int i2) {
            return new DrmInitData[i2];
        }
    }

    public static final class SchemeData implements Parcelable {
        public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator<SchemeData>() { // from class: com.opos.exoplayer.core.drm.DrmInitData.SchemeData.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SchemeData[] newArray(int i2) {
                return new SchemeData[i2];
            }
        };

        /* renamed from: a */
        public final String f18371a;

        /* renamed from: b */
        public final byte[] f18372b;

        /* renamed from: c */
        public final boolean f18373c;

        /* renamed from: d */
        private int f18374d;

        /* renamed from: e */
        private final UUID f18375e;

        /* renamed from: com.opos.exoplayer.core.drm.DrmInitData$SchemeData$1 */
        static final class AnonymousClass1 implements Parcelable.Creator<SchemeData> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SchemeData createFromParcel(Parcel parcel) {
                return new SchemeData(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SchemeData[] newArray(int i2) {
                return new SchemeData[i2];
            }
        }

        SchemeData(Parcel parcel) {
            this.f18375e = new UUID(parcel.readLong(), parcel.readLong());
            this.f18371a = parcel.readString();
            this.f18372b = parcel.createByteArray();
            this.f18373c = parcel.readByte() != 0;
        }

        public SchemeData(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        public SchemeData(UUID uuid, String str, byte[] bArr, boolean z) {
            this.f18375e = (UUID) com.opos.exoplayer.core.i.a.a(uuid);
            this.f18371a = (String) com.opos.exoplayer.core.i.a.a(str);
            this.f18372b = bArr;
            this.f18373c = z;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof SchemeData)) {
                return false;
            }
            if (obj != this) {
                SchemeData schemeData = (SchemeData) obj;
                if (!this.f18371a.equals(schemeData.f18371a) || !u.a(this.f18375e, schemeData.f18375e) || !Arrays.equals(this.f18372b, schemeData.f18372b)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            if (this.f18374d == 0) {
                this.f18374d = (((this.f18375e.hashCode() * 31) + this.f18371a.hashCode()) * 31) + Arrays.hashCode(this.f18372b);
            }
            return this.f18374d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeLong(this.f18375e.getMostSignificantBits());
            parcel.writeLong(this.f18375e.getLeastSignificantBits());
            parcel.writeString(this.f18371a);
            parcel.writeByteArray(this.f18372b);
            parcel.writeByte(this.f18373c ? (byte) 1 : (byte) 0);
        }
    }

    DrmInitData(Parcel parcel) {
        this.f18367a = parcel.readString();
        SchemeData[] schemeDataArr = (SchemeData[]) parcel.createTypedArray(SchemeData.CREATOR);
        this.f18369c = schemeDataArr;
        this.f18368b = schemeDataArr.length;
    }

    private DrmInitData(@Nullable String str, boolean z, SchemeData... schemeDataArr) {
        this.f18367a = str;
        schemeDataArr = z ? (SchemeData[]) schemeDataArr.clone() : schemeDataArr;
        Arrays.sort(schemeDataArr, this);
        this.f18369c = schemeDataArr;
        this.f18368b = schemeDataArr.length;
    }

    public DrmInitData(@Nullable String str, SchemeData... schemeDataArr) {
        this(str, true, schemeDataArr);
    }

    public DrmInitData(List<SchemeData> list) {
        this(null, false, (SchemeData[]) list.toArray(new SchemeData[list.size()]));
    }

    public DrmInitData(SchemeData... schemeDataArr) {
        this(null, schemeDataArr);
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(SchemeData schemeData, SchemeData schemeData2) {
        UUID uuid = com.opos.exoplayer.core.b.f17711b;
        return uuid.equals(schemeData.f18375e) ? uuid.equals(schemeData2.f18375e) ? 0 : 1 : schemeData.f18375e.compareTo(schemeData2.f18375e);
    }

    public SchemeData a(int i2) {
        return this.f18369c[i2];
    }

    public DrmInitData a(@Nullable String str) {
        return u.a(this.f18367a, str) ? this : new DrmInitData(str, false, this.f18369c);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || DrmInitData.class != obj.getClass()) {
                return false;
            }
            DrmInitData drmInitData = (DrmInitData) obj;
            if (!u.a(this.f18367a, drmInitData.f18367a) || !Arrays.equals(this.f18369c, drmInitData.f18369c)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.f18370d == 0) {
            String str = this.f18367a;
            this.f18370d = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f18369c);
        }
        return this.f18370d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f18367a);
        parcel.writeTypedArray(this.f18369c, 0);
    }
}
