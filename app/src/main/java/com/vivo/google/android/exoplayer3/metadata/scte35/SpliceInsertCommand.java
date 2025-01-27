package com.vivo.google.android.exoplayer3.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.C;
import com.vivo.google.android.exoplayer3.n6;
import com.vivo.google.android.exoplayer3.u6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new a();

    /* renamed from: a */
    public final long f27813a;

    /* renamed from: b */
    public final boolean f27814b;

    /* renamed from: c */
    public final boolean f27815c;

    /* renamed from: d */
    public final boolean f27816d;

    /* renamed from: e */
    public final boolean f27817e;

    /* renamed from: f */
    public final long f27818f;

    /* renamed from: g */
    public final long f27819g;

    /* renamed from: h */
    public final List<b> f27820h;

    /* renamed from: i */
    public final boolean f27821i;

    /* renamed from: j */
    public final long f27822j;
    public final int k;
    public final int l;
    public final int m;

    public static class a implements Parcelable.Creator<SpliceInsertCommand> {
        @Override // android.os.Parcelable.Creator
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SpliceInsertCommand[] newArray(int i2) {
            return new SpliceInsertCommand[i2];
        }
    }

    public static final class b {

        /* renamed from: a */
        public final int f27823a;

        /* renamed from: b */
        public final long f27824b;

        /* renamed from: c */
        public final long f27825c;

        public b(int i2, long j2, long j3) {
            this.f27823a = i2;
            this.f27824b = j2;
            this.f27825c = j3;
        }

        public static b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }
    }

    public SpliceInsertCommand(long j2, boolean z, boolean z2, boolean z3, boolean z4, long j3, long j4, List<b> list, boolean z5, long j5, int i2, int i3, int i4) {
        this.f27813a = j2;
        this.f27814b = z;
        this.f27815c = z2;
        this.f27816d = z3;
        this.f27817e = z4;
        this.f27818f = j3;
        this.f27819g = j4;
        this.f27820h = Collections.unmodifiableList(list);
        this.f27821i = z5;
        this.f27822j = j5;
        this.k = i2;
        this.l = i3;
        this.m = i4;
    }

    public SpliceInsertCommand(Parcel parcel) {
        this.f27813a = parcel.readLong();
        this.f27814b = parcel.readByte() == 1;
        this.f27815c = parcel.readByte() == 1;
        this.f27816d = parcel.readByte() == 1;
        this.f27817e = parcel.readByte() == 1;
        this.f27818f = parcel.readLong();
        this.f27819g = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(b.a(parcel));
        }
        this.f27820h = Collections.unmodifiableList(arrayList);
        this.f27821i = parcel.readByte() == 1;
        this.f27822j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }

    public static SpliceInsertCommand a(n6 n6Var, long j2, u6 u6Var) {
        List list;
        boolean z;
        boolean z2;
        long j3;
        boolean z3;
        long j4;
        int i2;
        int i3;
        int i4;
        boolean z4;
        boolean z5;
        long j5;
        long m = n6Var.m();
        boolean z6 = (n6Var.l() & 128) != 0;
        List emptyList = Collections.emptyList();
        if (z6) {
            list = emptyList;
            z = false;
            z2 = false;
            j3 = C.TIME_UNSET;
            z3 = false;
            j4 = C.TIME_UNSET;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            z4 = false;
        } else {
            int l = n6Var.l();
            boolean z7 = (l & 128) != 0;
            boolean z8 = (l & 64) != 0;
            boolean z9 = (l & 32) != 0;
            boolean z10 = (l & 16) != 0;
            long a2 = (!z8 || z10) ? C.TIME_UNSET : TimeSignalCommand.a(n6Var, j2);
            if (!z8) {
                int l2 = n6Var.l();
                ArrayList arrayList = new ArrayList(l2);
                for (int i5 = 0; i5 < l2; i5++) {
                    int l3 = n6Var.l();
                    long a3 = !z10 ? TimeSignalCommand.a(n6Var, j2) : C.TIME_UNSET;
                    arrayList.add(new b(l3, a3, u6Var.b(a3)));
                }
                emptyList = arrayList;
            }
            if (z9) {
                long l4 = n6Var.l();
                boolean z11 = (128 & l4) != 0;
                j5 = n6Var.m() | ((l4 & 1) << 32);
                z5 = z11;
            } else {
                z5 = false;
                j5 = C.TIME_UNSET;
            }
            i2 = n6Var.q();
            z4 = z8;
            i3 = n6Var.l();
            i4 = n6Var.l();
            list = emptyList;
            long j6 = a2;
            z3 = z5;
            j4 = j5;
            z2 = z10;
            z = z7;
            j3 = j6;
        }
        return new SpliceInsertCommand(m, z6, z, z4, z2, j3, u6Var.b(j3), list, z3, j4, i2, i3, i4);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f27813a);
        parcel.writeByte(this.f27814b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f27815c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f27816d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f27817e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f27818f);
        parcel.writeLong(this.f27819g);
        int size = this.f27820h.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f27820h.get(i3);
            parcel.writeInt(bVar.f27823a);
            parcel.writeLong(bVar.f27824b);
            parcel.writeLong(bVar.f27825c);
        }
        parcel.writeByte(this.f27821i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f27822j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
    }
}
