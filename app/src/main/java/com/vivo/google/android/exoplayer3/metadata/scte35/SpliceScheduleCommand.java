package com.vivo.google.android.exoplayer3.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.vivo.google.android.exoplayer3.C;
import com.vivo.google.android.exoplayer3.n6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new a();

    /* renamed from: a */
    public final List<c> f27826a;

    public static class a implements Parcelable.Creator<SpliceScheduleCommand> {
        @Override // android.os.Parcelable.Creator
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public SpliceScheduleCommand[] newArray(int i2) {
            return new SpliceScheduleCommand[i2];
        }
    }

    public static final class b {

        /* renamed from: a */
        public final int f27827a;

        /* renamed from: b */
        public final long f27828b;

        public b(int i2, long j2) {
            this.f27827a = i2;
            this.f27828b = j2;
        }

        public static /* synthetic */ b a(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }
    }

    public static final class c {

        /* renamed from: a */
        public final long f27829a;

        /* renamed from: b */
        public final boolean f27830b;

        /* renamed from: c */
        public final boolean f27831c;

        /* renamed from: d */
        public final boolean f27832d;

        /* renamed from: e */
        public final long f27833e;

        /* renamed from: f */
        public final List<b> f27834f;

        /* renamed from: g */
        public final boolean f27835g;

        /* renamed from: h */
        public final long f27836h;

        /* renamed from: i */
        public final int f27837i;

        /* renamed from: j */
        public final int f27838j;
        public final int k;

        public c(long j2, boolean z, boolean z2, boolean z3, List<b> list, long j3, boolean z4, long j4, int i2, int i3, int i4) {
            this.f27829a = j2;
            this.f27830b = z;
            this.f27831c = z2;
            this.f27832d = z3;
            this.f27834f = Collections.unmodifiableList(list);
            this.f27833e = j3;
            this.f27835g = z4;
            this.f27836h = j4;
            this.f27837i = i2;
            this.f27838j = i3;
            this.k = i4;
        }

        public c(Parcel parcel) {
            this.f27829a = parcel.readLong();
            this.f27830b = parcel.readByte() == 1;
            this.f27831c = parcel.readByte() == 1;
            this.f27832d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(b.a(parcel));
            }
            this.f27834f = Collections.unmodifiableList(arrayList);
            this.f27833e = parcel.readLong();
            this.f27835g = parcel.readByte() == 1;
            this.f27836h = parcel.readLong();
            this.f27837i = parcel.readInt();
            this.f27838j = parcel.readInt();
            this.k = parcel.readInt();
        }

        public static /* synthetic */ c a(Parcel parcel) {
            return new c(parcel);
        }
    }

    public SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(c.a(parcel));
        }
        this.f27826a = Collections.unmodifiableList(arrayList);
    }

    public SpliceScheduleCommand(List<c> list) {
        this.f27826a = Collections.unmodifiableList(list);
    }

    public static SpliceScheduleCommand a(n6 n6Var) {
        int i2;
        ArrayList arrayList;
        boolean z;
        boolean z2;
        long j2;
        boolean z3;
        long j3;
        int i3;
        int i4;
        int i5;
        boolean z4;
        boolean z5;
        long j4;
        int l = n6Var.l();
        ArrayList arrayList2 = new ArrayList(l);
        int i6 = 0;
        while (i6 < l) {
            long m = n6Var.m();
            boolean z6 = (n6Var.l() & 128) != 0;
            ArrayList arrayList3 = new ArrayList();
            if (z6) {
                i2 = l;
                arrayList = arrayList3;
                z = false;
                z2 = false;
                j2 = C.TIME_UNSET;
                z3 = false;
                j3 = C.TIME_UNSET;
                i3 = 0;
                i4 = 0;
                i5 = 0;
            } else {
                int l2 = n6Var.l();
                boolean z7 = (l2 & 128) != 0;
                boolean z8 = (l2 & 64) != 0;
                boolean z9 = (l2 & 32) != 0;
                long m2 = z8 ? n6Var.m() : C.TIME_UNSET;
                if (z8) {
                    i2 = l;
                    z2 = z7;
                    z4 = z8;
                } else {
                    int l3 = n6Var.l();
                    ArrayList arrayList4 = new ArrayList(l3);
                    int i7 = 0;
                    while (i7 < l3) {
                        arrayList4.add(new b(n6Var.l(), n6Var.m()));
                        i7++;
                        z7 = z7;
                        z8 = z8;
                        l = l;
                    }
                    i2 = l;
                    z2 = z7;
                    z4 = z8;
                    arrayList3 = arrayList4;
                }
                if (z9) {
                    long l4 = n6Var.l();
                    z5 = (l4 & 128) != 0;
                    j4 = ((l4 & 1) << 32) | n6Var.m();
                } else {
                    z5 = false;
                    j4 = C.TIME_UNSET;
                }
                i3 = n6Var.q();
                arrayList = arrayList3;
                z3 = z5;
                j2 = m2;
                j3 = j4;
                i4 = n6Var.l();
                i5 = n6Var.l();
                z = z4;
            }
            arrayList2.add(new c(m, z6, z2, z, arrayList, j2, z3, j3, i3, i4, i5));
            i6++;
            l = i2;
        }
        return new SpliceScheduleCommand(arrayList2);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size = this.f27826a.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            c cVar = this.f27826a.get(i3);
            parcel.writeLong(cVar.f27829a);
            parcel.writeByte(cVar.f27830b ? (byte) 1 : (byte) 0);
            parcel.writeByte(cVar.f27831c ? (byte) 1 : (byte) 0);
            parcel.writeByte(cVar.f27832d ? (byte) 1 : (byte) 0);
            int size2 = cVar.f27834f.size();
            parcel.writeInt(size2);
            for (int i4 = 0; i4 < size2; i4++) {
                b bVar = cVar.f27834f.get(i4);
                parcel.writeInt(bVar.f27827a);
                parcel.writeLong(bVar.f27828b);
            }
            parcel.writeLong(cVar.f27833e);
            parcel.writeByte(cVar.f27835g ? (byte) 1 : (byte) 0);
            parcel.writeLong(cVar.f27836h);
            parcel.writeInt(cVar.f27837i);
            parcel.writeInt(cVar.f27838j);
            parcel.writeInt(cVar.k);
        }
    }
}
