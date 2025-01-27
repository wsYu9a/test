package com.vivo.google.android.exoplayer3.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new a();

    /* renamed from: b */
    public final String f27780b;

    /* renamed from: c */
    public final String f27781c;

    /* renamed from: d */
    public final int f27782d;

    /* renamed from: e */
    public final byte[] f27783e;

    public static class a implements Parcelable.Creator<ApicFrame> {
        @Override // android.os.Parcelable.Creator
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ApicFrame[] newArray(int i2) {
            return new ApicFrame[i2];
        }
    }

    public ApicFrame(Parcel parcel) {
        super("APIC");
        this.f27780b = parcel.readString();
        this.f27781c = parcel.readString();
        this.f27782d = parcel.readInt();
        this.f27783e = parcel.createByteArray();
    }

    public ApicFrame(String str, String str2, int i2, byte[] bArr) {
        super("APIC");
        this.f27780b = str;
        this.f27781c = str2;
        this.f27782d = i2;
        this.f27783e = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ApicFrame.class != obj.getClass()) {
            return false;
        }
        ApicFrame apicFrame = (ApicFrame) obj;
        return this.f27782d == apicFrame.f27782d && Util.areEqual(this.f27780b, apicFrame.f27780b) && Util.areEqual(this.f27781c, apicFrame.f27781c) && Arrays.equals(this.f27783e, apicFrame.f27783e);
    }

    public int hashCode() {
        int i2 = (this.f27782d + 527) * 31;
        String str = this.f27780b;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f27781c;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f27783e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f27780b);
        parcel.writeString(this.f27781c);
        parcel.writeInt(this.f27782d);
        parcel.writeByteArray(this.f27783e);
    }
}
