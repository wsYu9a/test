package com.vivo.google.android.exoplayer3.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.n6;

/* loaded from: classes4.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new a();

    /* renamed from: a */
    public final long f27810a;

    /* renamed from: b */
    public final long f27811b;

    /* renamed from: c */
    public final byte[] f27812c;

    public static class a implements Parcelable.Creator<PrivateCommand> {
        @Override // android.os.Parcelable.Creator
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public PrivateCommand[] newArray(int i2) {
            return new PrivateCommand[i2];
        }
    }

    public PrivateCommand(long j2, byte[] bArr, long j3) {
        this.f27810a = j3;
        this.f27811b = j2;
        this.f27812c = bArr;
    }

    public PrivateCommand(Parcel parcel) {
        this.f27810a = parcel.readLong();
        this.f27811b = parcel.readLong();
        byte[] bArr = new byte[parcel.readInt()];
        this.f27812c = bArr;
        parcel.readByteArray(bArr);
    }

    public static PrivateCommand a(n6 n6Var, int i2, long j2) {
        long m = n6Var.m();
        int i3 = i2 - 4;
        byte[] bArr = new byte[i3];
        System.arraycopy(n6Var.f27874a, n6Var.f27875b, bArr, 0, i3);
        n6Var.f27875b += i3;
        return new PrivateCommand(m, bArr, j2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f27810a);
        parcel.writeLong(this.f27811b);
        parcel.writeInt(this.f27812c.length);
        parcel.writeByteArray(this.f27812c);
    }
}
