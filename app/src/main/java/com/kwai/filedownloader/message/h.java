package com.kwai.filedownloader.message;

import android.os.Parcel;
import com.kwai.filedownloader.message.MessageSnapshot;

/* loaded from: classes2.dex */
public abstract class h extends MessageSnapshot {

    public static class a extends b implements com.kwai.filedownloader.message.b {
        a(int i2, boolean z, int i3) {
            super(i2, true, i3);
        }
    }

    public static class b extends h {
        private final int aIF;
        private final boolean aIq;

        b(int i2, boolean z, int i3) {
            super(i2);
            this.aIq = z;
            this.aIF = i3;
        }

        b(Parcel parcel) {
            super(parcel);
            this.aIq = parcel.readByte() != 0;
            this.aIF = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) -3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Ip() {
            return this.aIF;
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
            parcel.writeInt(this.aIF);
        }
    }

    public static class c extends h {
        private final String aGO;
        private final int aIF;
        private final boolean aIr;
        private final String aIs;

        c(int i2, boolean z, int i3, String str, String str2) {
            super(i2);
            this.aIr = z;
            this.aIF = i3;
            this.aGO = str;
            this.aIs = str2;
        }

        c(Parcel parcel) {
            super(parcel);
            this.aIr = parcel.readByte() != 0;
            this.aIF = parcel.readInt();
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
        public final int Ip() {
            return this.aIF;
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
            parcel.writeInt(this.aIF);
            parcel.writeString(this.aGO);
            parcel.writeString(this.aIs);
        }
    }

    public static class d extends h {
        private final int aIG;
        private final Throwable aIu;

        d(int i2, int i3, Throwable th) {
            super(i2);
            this.aIG = i3;
            this.aIu = th;
        }

        d(Parcel parcel) {
            super(parcel);
            this.aIG = parcel.readInt();
            this.aIu = (Throwable) parcel.readSerializable();
        }

        @Override // com.kwai.filedownloader.message.c
        public byte Gq() {
            return (byte) -1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Io() {
            return this.aIG;
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
            parcel.writeInt(this.aIG);
            parcel.writeSerializable(this.aIu);
        }
    }

    public static class e extends f {
        e(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        @Override // com.kwai.filedownloader.message.h.f, com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) -2;
        }
    }

    public static class f extends h {
        private final int aIF;
        private final int aIG;

        f(int i2, int i3, int i4) {
            super(i2);
            this.aIG = i3;
            this.aIF = i4;
        }

        f(Parcel parcel) {
            super(parcel);
            this.aIG = parcel.readInt();
            this.aIF = parcel.readInt();
        }

        f(f fVar) {
            this(fVar.getId(), fVar.Io(), fVar.Ip());
        }

        public byte Gq() {
            return (byte) 1;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Io() {
            return this.aIG;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Ip() {
            return this.aIF;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.aIG);
            parcel.writeInt(this.aIF);
        }
    }

    public static class g extends h {
        private final int aIG;

        g(int i2, int i3) {
            super(i2);
            this.aIG = i3;
        }

        g(Parcel parcel) {
            super(parcel);
            this.aIG = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) 3;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Io() {
            return this.aIG;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.aIG);
        }
    }

    /* renamed from: com.kwai.filedownloader.message.h$h */
    public static class C0245h extends d {
        private final int aHZ;

        C0245h(int i2, int i3, Throwable th, int i4) {
            super(i2, i3, th);
            this.aHZ = i4;
        }

        C0245h(Parcel parcel) {
            super(parcel);
            this.aHZ = parcel.readInt();
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) 5;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot
        public final int Gu() {
            return this.aHZ;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwai.filedownloader.message.h.d, com.kwai.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.aHZ);
        }
    }

    public static class i extends j implements com.kwai.filedownloader.message.b {
        i(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }
    }

    public static class j extends f implements MessageSnapshot.a {
        j(int i2, int i3, int i4) {
            super(i2, i3, i4);
        }

        j(Parcel parcel) {
            super(parcel);
        }

        @Override // com.kwai.filedownloader.message.h.f, com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) -4;
        }

        @Override // com.kwai.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot Iu() {
            return new f(this);
        }
    }

    h(int i2) {
        super(i2);
        this.aIv = false;
    }

    h(Parcel parcel) {
        super(parcel);
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public final long Iq() {
        return Ip();
    }

    @Override // com.kwai.filedownloader.message.MessageSnapshot
    public final long Is() {
        return Io();
    }
}
