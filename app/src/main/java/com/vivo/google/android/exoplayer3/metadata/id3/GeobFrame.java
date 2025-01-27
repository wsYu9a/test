package com.vivo.google.android.exoplayer3.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new a();

    /* renamed from: b */
    public final String f27799b;

    /* renamed from: c */
    public final String f27800c;

    /* renamed from: d */
    public final String f27801d;

    /* renamed from: e */
    public final byte[] f27802e;

    public static class a implements Parcelable.Creator<GeobFrame> {
        @Override // android.os.Parcelable.Creator
        public GeobFrame createFromParcel(Parcel parcel) {
            return new GeobFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public GeobFrame[] newArray(int i2) {
            return new GeobFrame[i2];
        }
    }

    public GeobFrame(Parcel parcel) {
        super("GEOB");
        this.f27799b = parcel.readString();
        this.f27800c = parcel.readString();
        this.f27801d = parcel.readString();
        this.f27802e = parcel.createByteArray();
    }

    public GeobFrame(String str, String str2, String str3, byte[] bArr) {
        super("GEOB");
        this.f27799b = str;
        this.f27800c = str2;
        this.f27801d = str3;
        this.f27802e = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GeobFrame.class != obj.getClass()) {
            return false;
        }
        GeobFrame geobFrame = (GeobFrame) obj;
        return Util.areEqual(this.f27799b, geobFrame.f27799b) && Util.areEqual(this.f27800c, geobFrame.f27800c) && Util.areEqual(this.f27801d, geobFrame.f27801d) && Arrays.equals(this.f27802e, geobFrame.f27802e);
    }

    public int hashCode() {
        String str = this.f27799b;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.f27800c;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f27801d;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Arrays.hashCode(this.f27802e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f27799b);
        parcel.writeString(this.f27800c);
        parcel.writeString(this.f27801d);
        parcel.writeByteArray(this.f27802e);
    }
}
