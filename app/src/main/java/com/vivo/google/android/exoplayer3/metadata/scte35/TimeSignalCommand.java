package com.vivo.google.android.exoplayer3.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.C;
import com.vivo.google.android.exoplayer3.n6;

/* loaded from: classes4.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new a();

    /* renamed from: a */
    public final long f27839a;

    /* renamed from: b */
    public final long f27840b;

    public static class a implements Parcelable.Creator<TimeSignalCommand> {
        @Override // android.os.Parcelable.Creator
        public TimeSignalCommand createFromParcel(Parcel parcel) {
            return new TimeSignalCommand(parcel.readLong(), parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public TimeSignalCommand[] newArray(int i2) {
            return new TimeSignalCommand[i2];
        }
    }

    public TimeSignalCommand(long j2, long j3) {
        this.f27839a = j2;
        this.f27840b = j3;
    }

    public static long a(n6 n6Var, long j2) {
        long l = n6Var.l();
        return (128 & l) != 0 ? 8589934591L & ((((l & 1) << 32) | n6Var.m()) + j2) : C.TIME_UNSET;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f27839a);
        parcel.writeLong(this.f27840b);
    }
}
