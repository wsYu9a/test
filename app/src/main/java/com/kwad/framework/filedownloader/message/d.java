package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* loaded from: classes3.dex */
public abstract class d extends MessageSnapshot {

    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        public a(int i10, boolean z10, long j10) {
            super(i10, true, j10);
        }
    }

    public static class e extends f {
        public e(int i10, long j10, long j11) {
            super(i10, j10, j11);
        }

        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte vd() {
            return (byte) -2;
        }
    }

    public static class f extends d {
        private final long akx;
        private final long totalBytes;

        public f(f fVar) {
            this(fVar.getId(), fVar.xk(), fVar.xi());
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public byte vd() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeLong(this.akx);
            parcel.writeLong(this.totalBytes);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long xi() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long xk() {
            return this.akx;
        }

        public f(int i10, long j10, long j11) {
            super(i10);
            this.akx = j10;
            this.totalBytes = j11;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.akx = parcel.readLong();
            this.totalBytes = parcel.readLong();
        }
    }

    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        public i(int i10, long j10, long j11) {
            super(i10, j10, j11);
        }
    }

    public static class j extends f implements MessageSnapshot.a {
        public j(int i10, long j10, long j11) {
            super(i10, j10, j11);
        }

        @Override // com.kwad.framework.filedownloader.message.d.f, com.kwad.framework.filedownloader.message.c
        public final byte vd() {
            return (byte) -4;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot.a
        public final MessageSnapshot xm() {
            return new f(this);
        }

        public j(Parcel parcel) {
            super(parcel);
        }
    }

    public d(int i10) {
        super(i10);
        this.akz = true;
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int xg() {
        if (xk() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) xk();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final int xh() {
        if (xi() > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) xi();
    }

    public static class g extends d {
        private final long akx;

        public g(int i10, long j10) {
            super(i10);
            this.akx = j10;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte vd() {
            return (byte) 3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeLong(this.akx);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long xk() {
            return this.akx;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.akx = parcel.readLong();
        }
    }

    public static class h extends C0470d {
        private final int akd;

        public h(int i10, long j10, Throwable th2, int i11) {
            super(i10, j10, th2);
            this.akd = i11;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0470d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0470d, com.kwad.framework.filedownloader.message.c
        public final byte vd() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vh() {
            return this.akd;
        }

        @Override // com.kwad.framework.filedownloader.message.d.C0470d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.akd);
        }

        public h(Parcel parcel) {
            super(parcel);
            this.akd = parcel.readInt();
        }
    }

    public static class b extends d {
        private final boolean akv;
        private final long totalBytes;

        public b(int i10, boolean z10, long j10) {
            super(i10);
            this.akv = z10;
            this.totalBytes = j10;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte vd() {
            return (byte) -3;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.akv ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long xi() {
            return this.totalBytes;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean xj() {
            return this.akv;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.akv = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.d$d */
    public static class C0470d extends d {
        private final long akx;
        private final Throwable aky;

        public C0470d(int i10, long j10, Throwable th2) {
            super(i10);
            this.akx = j10;
            this.aky = th2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public byte vd() {
            return (byte) -1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeLong(this.akx);
            parcel.writeSerializable(this.aky);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long xk() {
            return this.akx;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable xl() {
            return this.aky;
        }

        public C0470d(Parcel parcel) {
            super(parcel);
            this.akx = parcel.readLong();
            this.aky = (Throwable) parcel.readSerializable();
        }
    }

    public d(Parcel parcel) {
        super(parcel);
    }

    public static class c extends d {
        private final String aiS;
        private final boolean akw;
        private final String fileName;
        private final long totalBytes;

        public c(int i10, boolean z10, long j10, String str, String str2) {
            super(i10);
            this.akw = z10;
            this.totalBytes = j10;
            this.aiS = str;
            this.fileName = str2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getEtag() {
            return this.aiS;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final String getFileName() {
            return this.fileName;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte vd() {
            return (byte) 2;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean wY() {
            return this.akw;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.akw ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.totalBytes);
            parcel.writeString(this.aiS);
            parcel.writeString(this.fileName);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final long xi() {
            return this.totalBytes;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.akw = parcel.readByte() != 0;
            this.totalBytes = parcel.readLong();
            this.aiS = parcel.readString();
            this.fileName = parcel.readString();
        }
    }
}
