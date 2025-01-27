package com.vivo.google.android.exoplayer3.video;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator<ColorInfo> CREATOR = new a();

    /* renamed from: a */
    public final int f28166a;

    /* renamed from: b */
    public final int f28167b;

    /* renamed from: c */
    public final int f28168c;

    /* renamed from: d */
    public final byte[] f28169d;

    /* renamed from: e */
    public int f28170e;

    public static class a implements Parcelable.Creator<ColorInfo> {
        @Override // android.os.Parcelable.Creator
        public ColorInfo createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ColorInfo[] newArray(int i2) {
            return new ColorInfo[0];
        }
    }

    public ColorInfo(int i2, int i3, int i4, byte[] bArr) {
        this.f28166a = i2;
        this.f28167b = i3;
        this.f28168c = i4;
        this.f28169d = bArr;
    }

    public ColorInfo(Parcel parcel) {
        this.f28166a = parcel.readInt();
        this.f28167b = parcel.readInt();
        this.f28168c = parcel.readInt();
        this.f28169d = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ColorInfo.class == obj.getClass()) {
            ColorInfo colorInfo = (ColorInfo) obj;
            if (this.f28166a == colorInfo.f28166a && this.f28167b == colorInfo.f28167b && this.f28168c == colorInfo.f28168c && Arrays.equals(this.f28169d, colorInfo.f28169d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f28170e == 0) {
            this.f28170e = ((((((this.f28166a + 527) * 31) + this.f28167b) * 31) + this.f28168c) * 31) + Arrays.hashCode(this.f28169d);
        }
        return this.f28170e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.f28166a);
        sb.append(", ");
        sb.append(this.f28167b);
        sb.append(", ");
        sb.append(this.f28168c);
        sb.append(", ");
        sb.append(this.f28169d != null);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f28166a);
        parcel.writeInt(this.f28167b);
        parcel.writeInt(this.f28168c);
        parcel.writeInt(this.f28169d != null ? 1 : 0);
        byte[] bArr = this.f28169d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
