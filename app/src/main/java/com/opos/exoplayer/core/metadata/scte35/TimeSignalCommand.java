package com.opos.exoplayer.core.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.s;
import com.vivo.google.android.exoplayer3.C;

/* loaded from: classes4.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new Parcelable.Creator<TimeSignalCommand>() { // from class: com.opos.exoplayer.core.metadata.scte35.TimeSignalCommand.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeSignalCommand[] newArray(int i2) {
            return new TimeSignalCommand[i2];
        }
    };

    /* renamed from: a */
    public final long f19179a;

    /* renamed from: b */
    public final long f19180b;

    /* renamed from: com.opos.exoplayer.core.metadata.scte35.TimeSignalCommand$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<TimeSignalCommand> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public TimeSignalCommand[] newArray(int i2) {
            return new TimeSignalCommand[i2];
        }
    }

    private TimeSignalCommand(long j2, long j3) {
        this.f19179a = j2;
        this.f19180b = j3;
    }

    /* synthetic */ TimeSignalCommand(long j2, long j3, AnonymousClass1 anonymousClass1) {
        this(j2, j3);
    }

    static long a(m mVar, long j2) {
        long g2 = mVar.g();
        return (128 & g2) != 0 ? 8589934591L & ((((g2 & 1) << 32) | mVar.m()) + j2) : C.TIME_UNSET;
    }

    static TimeSignalCommand a(m mVar, long j2, s sVar) {
        long a2 = a(mVar, j2);
        return new TimeSignalCommand(a2, sVar.b(a2));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f19179a);
        parcel.writeLong(this.f19180b);
    }
}
