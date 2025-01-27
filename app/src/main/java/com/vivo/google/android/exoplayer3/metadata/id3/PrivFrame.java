package com.vivo.google.android.exoplayer3.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.util.Util;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new a();

    /* renamed from: b */
    public final String f27804b;

    /* renamed from: c */
    public final byte[] f27805c;

    public static class a implements Parcelable.Creator<PrivFrame> {
        @Override // android.os.Parcelable.Creator
        public PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PrivFrame[] newArray(int i2) {
            return new PrivFrame[i2];
        }
    }

    public PrivFrame(Parcel parcel) {
        super("PRIV");
        this.f27804b = parcel.readString();
        this.f27805c = parcel.createByteArray();
    }

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.f27804b = str;
        this.f27805c = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PrivFrame.class != obj.getClass()) {
            return false;
        }
        PrivFrame privFrame = (PrivFrame) obj;
        return Util.areEqual(this.f27804b, privFrame.f27804b) && Arrays.equals(this.f27805c, privFrame.f27805c);
    }

    public int hashCode() {
        String str = this.f27804b;
        return (((str != null ? str.hashCode() : 0) + 527) * 31) + Arrays.hashCode(this.f27805c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f27804b);
        parcel.writeByteArray(this.f27805c);
    }
}
