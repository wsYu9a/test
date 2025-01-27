package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.u;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new Parcelable.Creator<PrivFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.PrivFrame.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrivFrame[] newArray(int i2) {
            return new PrivFrame[i2];
        }
    };

    /* renamed from: a */
    public final String f19139a;

    /* renamed from: b */
    public final byte[] f19140b;

    /* renamed from: com.opos.exoplayer.core.metadata.id3.PrivFrame$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<PrivFrame> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrivFrame createFromParcel(Parcel parcel) {
            return new PrivFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrivFrame[] newArray(int i2) {
            return new PrivFrame[i2];
        }
    }

    PrivFrame(Parcel parcel) {
        super("PRIV");
        this.f19139a = parcel.readString();
        this.f19140b = parcel.createByteArray();
    }

    public PrivFrame(String str, byte[] bArr) {
        super("PRIV");
        this.f19139a = str;
        this.f19140b = bArr;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || PrivFrame.class != obj.getClass()) {
                return false;
            }
            PrivFrame privFrame = (PrivFrame) obj;
            if (!u.a(this.f19139a, privFrame.f19139a) || !Arrays.equals(this.f19140b, privFrame.f19140b)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.f19139a;
        return (((str != null ? str.hashCode() : 0) + 527) * 31) + Arrays.hashCode(this.f19140b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19139a);
        parcel.writeByteArray(this.f19140b);
    }
}
