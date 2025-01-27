package com.opos.exoplayer.core.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.u;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new Parcelable.Creator<ApicFrame>() { // from class: com.opos.exoplayer.core.metadata.id3.ApicFrame.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApicFrame[] newArray(int i2) {
            return new ApicFrame[i2];
        }
    };

    /* renamed from: a */
    public final String f19115a;

    /* renamed from: b */
    public final String f19116b;

    /* renamed from: c */
    public final int f19117c;

    /* renamed from: d */
    public final byte[] f19118d;

    /* renamed from: com.opos.exoplayer.core.metadata.id3.ApicFrame$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<ApicFrame> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApicFrame createFromParcel(Parcel parcel) {
            return new ApicFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ApicFrame[] newArray(int i2) {
            return new ApicFrame[i2];
        }
    }

    ApicFrame(Parcel parcel) {
        super("APIC");
        this.f19115a = parcel.readString();
        this.f19116b = parcel.readString();
        this.f19117c = parcel.readInt();
        this.f19118d = parcel.createByteArray();
    }

    public ApicFrame(String str, String str2, int i2, byte[] bArr) {
        super("APIC");
        this.f19115a = str;
        this.f19116b = str2;
        this.f19117c = i2;
        this.f19118d = bArr;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || ApicFrame.class != obj.getClass()) {
                return false;
            }
            ApicFrame apicFrame = (ApicFrame) obj;
            if (this.f19117c != apicFrame.f19117c || !u.a(this.f19115a, apicFrame.f19115a) || !u.a(this.f19116b, apicFrame.f19116b) || !Arrays.equals(this.f19118d, apicFrame.f19118d)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i2 = this.f19117c;
        String str = this.f19115a;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.f19116b;
        return ((((hashCode + ((i2 + 527) * 31)) * 31) + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.f19118d);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f19115a);
        parcel.writeString(this.f19116b);
        parcel.writeInt(this.f19117c);
        parcel.writeByteArray(this.f19118d);
    }
}
