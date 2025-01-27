package com.opos.exoplayer.core.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.m;

/* loaded from: classes4.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new Parcelable.Creator<PrivateCommand>() { // from class: com.opos.exoplayer.core.metadata.scte35.PrivateCommand.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrivateCommand[] newArray(int i2) {
            return new PrivateCommand[i2];
        }
    };

    /* renamed from: a */
    public final long f19150a;

    /* renamed from: b */
    public final long f19151b;

    /* renamed from: c */
    public final byte[] f19152c;

    /* renamed from: com.opos.exoplayer.core.metadata.scte35.PrivateCommand$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<PrivateCommand> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrivateCommand createFromParcel(Parcel parcel) {
            return new PrivateCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PrivateCommand[] newArray(int i2) {
            return new PrivateCommand[i2];
        }
    }

    private PrivateCommand(long j2, byte[] bArr, long j3) {
        this.f19150a = j3;
        this.f19151b = j2;
        this.f19152c = bArr;
    }

    private PrivateCommand(Parcel parcel) {
        this.f19150a = parcel.readLong();
        this.f19151b = parcel.readLong();
        byte[] bArr = new byte[parcel.readInt()];
        this.f19152c = bArr;
        parcel.readByteArray(bArr);
    }

    /* synthetic */ PrivateCommand(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    static PrivateCommand a(m mVar, int i2, long j2) {
        long m = mVar.m();
        int i3 = i2 - 4;
        byte[] bArr = new byte[i3];
        mVar.a(bArr, 0, i3);
        return new PrivateCommand(m, bArr, j2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f19150a);
        parcel.writeLong(this.f19151b);
        parcel.writeInt(this.f19152c.length);
        parcel.writeByteArray(this.f19152c);
    }
}
