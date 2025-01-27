package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;

/* loaded from: classes2.dex */
public abstract class d extends MessageSnapshot {

    public static class a extends b implements com.kwai.filedownloader.message.b {
        a(int i2, boolean z, long j2) {
            super(i2, true, j2);
        }
    }

    public static class b extends d {
        private final boolean aIq;
        private final long totalBytes;

        b(int i2, boolean z, long j2) {
            super(i2);
            this.aIq = z;
            this.totalBytes = j2;
        }

        b(Parcel parcel) {
            super(parcel);
            this.aIq = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final long Iq() {
            return this.totalBytes;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final boolean Ir() {
            return this.aIq;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.aIq ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
        }
    }

    public static class c extends d {
        private final String aGO;
        private final boolean aIr;
        private final String aIs;
        private final long totalBytes;

        c(int i2, boolean z, long j2, String str, String str2) {
            super(i2);
            this.aIr = z;
            this.totalBytes = j2;
            this.aGO = str;
            this.aIs = str2;
        }

        c(Parcel parcel) {
            super(parcel);
            this.aIr = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
            this.aGO = parcel.readString();
            this.aIs = parcel.readString();
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) 2;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final boolean Ig() {
            return this.aIr;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final long Iq() {
            return this.totalBytes;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.aGO;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final String getFileName() {
            return this.aIs;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.aIr ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.aGO);
            parcel.writeString(this.aIs);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.d$d */
    public static class C0244d extends d {
        private final long aIt;
        private final Throwable aIu;

        C0244d(int i2, long j2, Throwable th) {
            super(i2);
            this.aIt = j2;
            this.aIu = th;
        }

        C0244d(Parcel parcel) {
            super(parcel);
            this.aIt = parcel.readLong();
            this.aIu = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte Gq() {
            return (byte) -1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final long Is() {
            return this.aIt;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final Throwable It() {
            return this.aIu;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.aIt);
            parcel.writeSerializable(this.aIu);
        }
    }

    public static class e extends f {
        e(int i2, long j2, long j3) {
            super(i2, j2, j3);
        }

        @Override // com.kwai.filedownloader.message.d.f, com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) -2;
        }
    }

    public static class f extends d {
        private final long aIt;
        private final long totalBytes;

        f(int i2, long j2, long j3) {
            super(i2);
            this.aIt = j2;
            this.totalBytes = j3;
        }

        f(Parcel parcel) {
            super(parcel);
            this.aIt = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }

        f(f fVar) {
            this(fVar.getId(), fVar.Is(), fVar.Iq());
        }

        public byte Gq() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final long Iq() {
            return this.totalBytes;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final long Is() {
            return this.aIt;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.aIt);
            parcel.writeLong(this.totalBytes);
        }
    }

    public static class g extends d {
        private final long aIt;

        g(int i2, long j2) {
            super(i2);
            this.aIt = j2;
        }

        g(Parcel parcel) {
            super(parcel);
            this.aIt = parcel.readLong();
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) 3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final long Is() {
            return this.aIt;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.aIt);
        }
    }

    public static class h extends C0244d {
        private final int aHZ;

        h(int i2, long j2, Throwable th, int i3) {
            super(i2, j2, th);
            this.aHZ = i3;
        }

        h(Parcel parcel) {
            super(parcel);
            this.aHZ = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.d.C0244d, com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Gu() {
            return this.aHZ;
        }

        @Override // com.kwai.filedownloader.message.d.C0244d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.d.C0244d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.aHZ);
        }
    }

    public static class i extends j implements com.kwai.filedownloader.message.b {
        i(int i2, long j2, long j3) {
            super(i2, j2, j3);
        }
    }

    public static class j extends f implements MessageSnapshot.a {
        j(int i2, long j2, long j3) {
            super(i2, j2, j3);
        }

        j(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwai.filedownloader.message.d.f, com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) -4;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot Iu() {
            return new f(this);
        }
    }

    d(int i2) {
        super(i2);
        this.aIv = true;
    }

    d(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public final int Io() {
        if (Is() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) Is();
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public final int Ip() {
        if (Iq() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) Iq();
    }
}
