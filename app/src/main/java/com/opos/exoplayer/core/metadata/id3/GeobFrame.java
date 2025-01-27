package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.u;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new Parcelable.Creator<GeobFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.GeobFrame.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GeobFrame[] newArray(int i2) {
            return new GeobFrame[i2];
        }
    };

    /* renamed from: a */
    public final String f19134a;

    /* renamed from: b */
    public final String f19135b;

    /* renamed from: c */
    public final String f19136c;

    /* renamed from: d */
    public final byte[] f19137d;

    /* renamed from: com.opos.exoplayer.core.metadata.id3.GeobFrame$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<GeobFrame> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public GeobFrame[] newArray(int i2) {
            return new GeobFrame[i2];
        }
    }

    GeobFrame(Parcel parcel) {
        super("GEOB");
        this.f19134a = parcel.readString();
        this.f19135b = parcel.readString();
        this.f19136c = parcel.readString();
        this.f19137d = parcel.createByteArray();
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f19134a = str;
        this.f19135b = str2;
        this.f19136c = str3;
        this.f19137d = bArr;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || GeobFrame.class != obj.getClass()) {
                return false;
            }
            GeobFrame geobFrame = (GeobFrame) obj;
            if (!u.a(this.f19134a, geobFrame.f19134a) || !u.a(this.f19135b, geobFrame.f19135b) || !u.a(this.f19136c, geobFrame.f19136c) || !Arrays.equals(this.f19137d, geobFrame.f19137d)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.f19134a;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.f19135b;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.f19136c;
        return ((((hashCode2 + ((hashCode + 527) * 31)) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f19137d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19134a);
        parcel.writeString(this.f19135b);
        parcel.writeString(this.f19136c);
        parcel.writeByteArray(this.f19137d);
    }
}
