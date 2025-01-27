package com.opos.exoplayer.core.video;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class ColorInfo implements Parcelable {
    public static final Parcelable.Creator<ColorInfo> CREATOR = new Parcelable.Creator<ColorInfo>() { // from class: com.opos.exoplayer.core.video.ColorInfo.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ColorInfo createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ColorInfo[] newArray(int i2) {
            return new ColorInfo[0];
        }
    };

    /* renamed from: a */
    public final int f19200a;

    /* renamed from: b */
    public final int f19201b;

    /* renamed from: c */
    public final int f19202c;

    /* renamed from: d */
    public final byte[] f19203d;

    /* renamed from: e */
    private int f19204e;

    /* renamed from: com.opos.exoplayer.core.video.ColorInfo$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<ColorInfo> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ColorInfo createFromParcel(Parcel parcel) {
            return new ColorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ColorInfo[] newArray(int i2) {
            return new ColorInfo[0];
        }
    }

    public ColorInfo(int i2, int i3, int i4, byte[] bArr) {
        this.f19200a = i2;
        this.f19201b = i3;
        this.f19202c = i4;
        this.f19203d = bArr;
    }

    ColorInfo(Parcel parcel) {
        this.f19200a = parcel.readInt();
        this.f19201b = parcel.readInt();
        this.f19202c = parcel.readInt();
        this.f19203d = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || ColorInfo.class != obj.getClass()) {
                return false;
            }
            ColorInfo colorInfo = (ColorInfo) obj;
            if (this.f19200a != colorInfo.f19200a || this.f19201b != colorInfo.f19201b || this.f19202c != colorInfo.f19202c || !Arrays.equals(this.f19203d, colorInfo.f19203d)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.f19204e == 0) {
            this.f19204e = ((((((this.f19200a + 527) * 31) + this.f19201b) * 31) + this.f19202c) * 31) + Arrays.hashCode(this.f19203d);
        }
        return this.f19204e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ColorInfo(");
        sb.append(this.f19200a);
        sb.append(", ");
        sb.append(this.f19201b);
        sb.append(", ");
        sb.append(this.f19202c);
        sb.append(", ");
        sb.append(this.f19203d != null);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f19200a);
        parcel.writeInt(this.f19201b);
        parcel.writeInt(this.f19202c);
        parcel.writeInt(this.f19203d != null ? 1 : 0);
        byte[] bArr = this.f19203d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
