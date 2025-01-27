package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class BinaryFrame extends Id3Frame {
    public static final Parcelable.Creator<BinaryFrame> CREATOR = new Parcelable.Creator<BinaryFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.BinaryFrame.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BinaryFrame createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BinaryFrame[] newArray(int i2) {
            return new BinaryFrame[i2];
        }
    };

    /* renamed from: a */
    public final byte[] f19119a;

    /* renamed from: com.opos.exoplayer.core.metadata.id3.BinaryFrame$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<BinaryFrame> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BinaryFrame createFromParcel(Parcel parcel) {
            return new BinaryFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public BinaryFrame[] newArray(int i2) {
            return new BinaryFrame[i2];
        }
    }

    BinaryFrame(Parcel parcel) {
        super(parcel.readString());
        this.f19119a = parcel.createByteArray();
    }

    public BinaryFrame(String str, byte[] bArr) {
        super(str);
        this.f19119a = bArr;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || BinaryFrame.class != obj.getClass()) {
                return false;
            }
            BinaryFrame binaryFrame = (BinaryFrame) obj;
            if (!this.f19138f.equals(binaryFrame.f19138f) || !Arrays.equals(this.f19119a, binaryFrame.f19119a)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return ((this.f19138f.hashCode() + 527) * 31) + Arrays.hashCode(this.f19119a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19138f);
        parcel.writeByteArray(this.f19119a);
    }
}
