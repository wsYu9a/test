package com.opos.exoplayer.core.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.s;
import com.vivo.google.android.exoplayer3.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new Parcelable.Creator<SpliceInsertCommand>() { // from class: com.opos.exoplayer.core.metadata.scte35.SpliceInsertCommand.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpliceInsertCommand[] newArray(int i2) {
            return new SpliceInsertCommand[i2];
        }
    };

    /* renamed from: a */
    public final long f19153a;

    /* renamed from: b */
    public final boolean f19154b;

    /* renamed from: c */
    public final boolean f19155c;

    /* renamed from: d */
    public final boolean f19156d;

    /* renamed from: e */
    public final boolean f19157e;

    /* renamed from: f */
    public final long f19158f;

    /* renamed from: g */
    public final long f19159g;

    /* renamed from: h */
    public final List<a> f19160h;

    /* renamed from: i */
    public final boolean f19161i;

    /* renamed from: j */
    public final long f19162j;
    public final int k;
    public final int l;
    public final int m;

    /* renamed from: com.opos.exoplayer.core.metadata.scte35.SpliceInsertCommand$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<SpliceInsertCommand> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpliceInsertCommand createFromParcel(Parcel parcel) {
            return new SpliceInsertCommand(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SpliceInsertCommand[] newArray(int i2) {
            return new SpliceInsertCommand[i2];
        }
    }

    public static final class a {

        /* renamed from: a */
        public final int f19163a;

        /* renamed from: b */
        public final long f19164b;

        /* renamed from: c */
        public final long f19165c;

        private a(int i2, long j2, long j3) {
            this.f19163a = i2;
            this.f19164b = j2;
            this.f19165c = j3;
        }

        /* synthetic */ a(int i2, long j2, long j3, AnonymousClass1 anonymousClass1) {
            this(i2, j2, j3);
        }

        public static a b(Parcel parcel) {
            return new a(parcel.readInt(), parcel.readLong(), parcel.readLong());
        }

        public void a(Parcel parcel) {
            parcel.writeInt(this.f19163a);
            parcel.writeLong(this.f19164b);
            parcel.writeLong(this.f19165c);
        }
    }

    private SpliceInsertCommand(long j2, boolean z, boolean z2, boolean z3, boolean z4, long j3, long j4, List<a> list, boolean z5, long j5, int i2, int i3, int i4) {
        this.f19153a = j2;
        this.f19154b = z;
        this.f19155c = z2;
        this.f19156d = z3;
        this.f19157e = z4;
        this.f19158f = j3;
        this.f19159g = j4;
        this.f19160h = Collections.unmodifiableList(list);
        this.f19161i = z5;
        this.f19162j = j5;
        this.k = i2;
        this.l = i3;
        this.m = i4;
    }

    private SpliceInsertCommand(Parcel parcel) {
        this.f19153a = parcel.readLong();
        this.f19154b = parcel.readByte() == 1;
        this.f19155c = parcel.readByte() == 1;
        this.f19156d = parcel.readByte() == 1;
        this.f19157e = parcel.readByte() == 1;
        this.f19158f = parcel.readLong();
        this.f19159g = parcel.readLong();
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            arrayList.add(a.b(parcel));
        }
        this.f19160h = Collections.unmodifiableList(arrayList);
        this.f19161i = parcel.readByte() == 1;
        this.f19162j = parcel.readLong();
        this.k = parcel.readInt();
        this.l = parcel.readInt();
        this.m = parcel.readInt();
    }

    /* synthetic */ SpliceInsertCommand(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    static SpliceInsertCommand a(m mVar, long j2, s sVar) {
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
        long m = mVar.m();
        boolean z6 = (mVar.g() & 128) != 0;
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
            int g2 = mVar.g();
            boolean z7 = (g2 & 128) != 0;
            boolean z8 = (g2 & 64) != 0;
            boolean z9 = (g2 & 32) != 0;
            boolean z10 = (g2 & 16) != 0;
            long a2 = (!z8 || z10) ? C.TIME_UNSET : TimeSignalCommand.a(mVar, j2);
            if (!z8) {
                int g3 = mVar.g();
                ArrayList arrayList = new ArrayList(g3);
                for (int i5 = 0; i5 < g3; i5++) {
                    int g4 = mVar.g();
                    long a3 = !z10 ? TimeSignalCommand.a(mVar, j2) : C.TIME_UNSET;
                    arrayList.add(new a(g4, a3, sVar.b(a3)));
                }
                emptyList = arrayList;
            }
            if (z9) {
                long g5 = mVar.g();
                boolean z11 = (128 & g5) != 0;
                j5 = ((((g5 & 1) << 32) | mVar.m()) * 1000) / 90;
                z5 = z11;
            } else {
                z5 = false;
                j5 = C.TIME_UNSET;
            }
            i2 = mVar.h();
            z4 = z8;
            i3 = mVar.g();
            i4 = mVar.g();
            list = emptyList;
            long j6 = a2;
            z3 = z5;
            j4 = j5;
            z2 = z10;
            z = z7;
            j3 = j6;
        }
        return new SpliceInsertCommand(m, z6, z, z4, z2, j3, sVar.b(j3), list, z3, j4, i2, i3, i4);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f19153a);
        parcel.writeByte(this.f19154b ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f19155c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f19156d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f19157e ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f19158f);
        parcel.writeLong(this.f19159g);
        int size = this.f19160h.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            this.f19160h.get(i3).a(parcel);
        }
        parcel.writeByte(this.f19161i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f19162j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeInt(this.m);
    }
}
