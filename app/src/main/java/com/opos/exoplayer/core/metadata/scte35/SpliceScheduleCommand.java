package com.opos.exoplayer.core.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.m;
import com.vivo.google.android.exoplayer3.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new Parcelable.Creator<SpliceScheduleCommand>() { // from class: com.opos.exoplayer.core.metadata.scte35.SpliceScheduleCommand.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpliceScheduleCommand[] newArray(int i2) {
            return new SpliceScheduleCommand[i2];
        }
    };

    /* renamed from: a */
    public final List<b> f19166a;

    /* renamed from: com.opos.exoplayer.core.metadata.scte35.SpliceScheduleCommand$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<SpliceScheduleCommand> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpliceScheduleCommand[] newArray(int i2) {
            return new SpliceScheduleCommand[i2];
        }
    }

    public static final class a {

        /* renamed from: a */
        public final int f19167a;

        /* renamed from: b */
        public final long f19168b;

        private a(int i2, long j2) {
            this.f19167a = i2;
            this.f19168b = j2;
        }

        /* synthetic */ a(int i2, long j2, AnonymousClass1 anonymousClass1) {
            this(i2, j2);
        }

        public static a b(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong());
        }

        public void c(Parcel parcel) {
            parcel.writeInt(this.f19167a);
            parcel.writeLong(this.f19168b);
        }
    }

    public static final class b {

        /* renamed from: a */
        public final long f19169a;

        /* renamed from: b */
        public final boolean f19170b;

        /* renamed from: c */
        public final boolean f19171c;

        /* renamed from: d */
        public final boolean f19172d;

        /* renamed from: e */
        public final long f19173e;

        /* renamed from: f */
        public final List<a> f19174f;

        /* renamed from: g */
        public final boolean f19175g;

        /* renamed from: h */
        public final long f19176h;

        /* renamed from: i */
        public final int f19177i;

        /* renamed from: j */
        public final int f19178j;
        public final int k;

        private b(long j2, boolean z, boolean z2, boolean z3, List<a> list, long j3, boolean z4, long j4, int i2, int i3, int i4) {
            this.f19169a = j2;
            this.f19170b = z;
            this.f19171c = z2;
            this.f19172d = z3;
            this.f19174f = Collections.unmodifiableList(list);
            this.f19173e = j3;
            this.f19175g = z4;
            this.f19176h = j4;
            this.f19177i = i2;
            this.f19178j = i3;
            this.k = i4;
        }

        private b(Parcel parcel) {
            this.f19169a = parcel.readLong();
            this.f19170b = parcel.readByte() == 1;
            this.f19171c = parcel.readByte() == 1;
            this.f19172d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                arrayList.add(a.b(parcel));
            }
            this.f19174f = Collections.unmodifiableList(arrayList);
            this.f19173e = parcel.readLong();
            this.f19175g = parcel.readByte() == 1;
            this.f19176h = parcel.readLong();
            this.f19177i = parcel.readInt();
            this.f19178j = parcel.readInt();
            this.k = parcel.readInt();
        }

        public static b b(m mVar) {
            ArrayList arrayList;
            boolean z;
            long j2;
            boolean z2;
            long j3;
            int i2;
            int i3;
            int i4;
            boolean z3;
            boolean z4;
            long j4;
            long m = mVar.m();
            boolean z5 = (mVar.g() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z5) {
                arrayList = arrayList2;
                z = false;
                j2 = C.TIME_UNSET;
                z2 = false;
                j3 = C.TIME_UNSET;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                z3 = false;
            } else {
                int g2 = mVar.g();
                boolean z6 = (g2 & 128) != 0;
                boolean z7 = (g2 & 64) != 0;
                boolean z8 = (g2 & 32) != 0;
                long m2 = z7 ? mVar.m() : C.TIME_UNSET;
                if (!z7) {
                    int g3 = mVar.g();
                    ArrayList arrayList3 = new ArrayList(g3);
                    for (int i5 = 0; i5 < g3; i5++) {
                        arrayList3.add(new a(mVar.g(), mVar.m()));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long g4 = mVar.g();
                    boolean z9 = (128 & g4) != 0;
                    j4 = ((((g4 & 1) << 32) | mVar.m()) * 1000) / 90;
                    z4 = z9;
                } else {
                    z4 = false;
                    j4 = C.TIME_UNSET;
                }
                int h2 = mVar.h();
                int g5 = mVar.g();
                z3 = z7;
                i4 = mVar.g();
                j3 = j4;
                arrayList = arrayList2;
                long j5 = m2;
                i2 = h2;
                i3 = g5;
                j2 = j5;
                boolean z10 = z6;
                z2 = z4;
                z = z10;
            }
            return new b(m, z5, z, z3, arrayList, j2, z2, j3, i2, i3, i4);
        }

        public void b(Parcel parcel) {
            parcel.writeLong(this.f19169a);
            parcel.writeByte(this.f19170b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f19171c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f19172d ? (byte) 1 : (byte) 0);
            int size = this.f19174f.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.f19174f.get(i2).c(parcel);
            }
            parcel.writeLong(this.f19173e);
            parcel.writeByte(this.f19175g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f19176h);
            parcel.writeInt(this.f19177i);
            parcel.writeInt(this.f19178j);
            parcel.writeInt(this.k);
        }

        public static b c(Parcel parcel) {
            return new b(parcel);
        }
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(b.c(parcel));
        }
        this.f19166a = Collections.unmodifiableList(arrayList);
    }

    /* synthetic */ SpliceScheduleCommand(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    private SpliceScheduleCommand(List<b> list) {
        this.f19166a = Collections.unmodifiableList(list);
    }

    static SpliceScheduleCommand a(m mVar) {
        int g2 = mVar.g();
        ArrayList arrayList = new ArrayList(g2);
        for (int i2 = 0; i2 < g2; i2++) {
            arrayList.add(b.b(mVar));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size = this.f19166a.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.f19166a.get(i3).b(parcel);
        }
    }
}
