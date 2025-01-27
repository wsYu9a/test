package com.kwad.framework.filedownloader.message;

import android.os.Parcel;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* loaded from: classes3.dex */
public abstract class h extends MessageSnapshot {

    public static class a extends b implements com.kwad.framework.filedownloader.message.b {
        public a(int i10, boolean z10, int i11) {
            super(i10, true, i11);
        }
    }

    public static class e extends f {
        public e(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }

        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
        public final byte vd() {
            return (byte) -2;
        }
    }

    public static class f extends h {
        private final int akJ;
        private final int akK;

        public f(f fVar) {
            this(fVar.getId(), fVar.xg(), fVar.xh());
        }

        public byte vd() {
            return (byte) 1;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.akK);
            parcel.writeInt(this.akJ);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int xg() {
            return this.akK;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int xh() {
            return this.akJ;
        }

        public f(int i10, int i11, int i12) {
            super(i10);
            this.akK = i11;
            this.akJ = i12;
        }

        public f(Parcel parcel) {
            super(parcel);
            this.akK = parcel.readInt();
            this.akJ = parcel.readInt();
        }
    }

    public static class i extends j implements com.kwad.framework.filedownloader.message.b {
        public i(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }
    }

    public static class j extends f implements MessageSnapshot.a {
        public j(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }

        @Override // com.kwad.framework.filedownloader.message.h.f, com.kwad.framework.filedownloader.message.c
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

    public h(int i10) {
        super(i10);
        this.akz = false;
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long xi() {
        return xh();
    }

    @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
    public final long xk() {
        return xg();
    }

    public static class g extends h {
        private final int akK;

        public g(int i10, int i11) {
            super(i10);
            this.akK = i11;
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
            parcel.writeInt(this.akK);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int xg() {
            return this.akK;
        }

        public g(Parcel parcel) {
            super(parcel);
            this.akK = parcel.readInt();
        }
    }

    /* renamed from: com.kwad.framework.filedownloader.message.h$h */
    public static class C0471h extends d {
        private final int akd;

        public C0471h(int i10, int i11, Throwable th2, int i12) {
            super(i10, i11, th2);
            this.akd = i12;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.c
        public final byte vd() {
            return (byte) 5;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int vh() {
            return this.akd;
        }

        @Override // com.kwad.framework.filedownloader.message.h.d, com.kwad.framework.filedownloader.message.MessageSnapshot, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.akd);
        }

        public C0471h(Parcel parcel) {
            super(parcel);
            this.akd = parcel.readInt();
        }
    }

    public static class b extends h {
        private final int akJ;
        private final boolean akv;

        public b(int i10, boolean z10, int i11) {
            super(i10);
            this.akv = z10;
            this.akJ = i11;
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
            parcel.writeInt(this.akJ);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int xh() {
            return this.akJ;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final boolean xj() {
            return this.akv;
        }

        public b(Parcel parcel) {
            super(parcel);
            this.akv = parcel.readByte() != 0;
            this.akJ = parcel.readInt();
        }
    }

    public static class d extends h {
        private final int akK;
        private final Throwable aky;

        public d(int i10, int i11, Throwable th2) {
            super(i10);
            this.akK = i11;
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
            parcel.writeInt(this.akK);
            parcel.writeSerializable(this.aky);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int xg() {
            return this.akK;
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final Throwable xl() {
            return this.aky;
        }

        public d(Parcel parcel) {
            super(parcel);
            this.akK = parcel.readInt();
            this.aky = (Throwable) parcel.readSerializable();
        }
    }

    public h(Parcel parcel) {
        super(parcel);
    }

    public static class c extends h {
        private final String aiS;
        private final int akJ;
        private final boolean akw;
        private final String fileName;

        public c(int i10, boolean z10, int i11, String str, String str2) {
            super(i10);
            this.akw = z10;
            this.akJ = i11;
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
            parcel.writeInt(this.akJ);
            parcel.writeString(this.aiS);
            parcel.writeString(this.fileName);
        }

        @Override // com.kwad.framework.filedownloader.message.MessageSnapshot
        public final int xh() {
            return this.akJ;
        }

        public c(Parcel parcel) {
            super(parcel);
            this.akw = parcel.readByte() != 0;
            this.akJ = parcel.readInt();
            this.aiS = parcel.readString();
            this.fileName = parcel.readString();
        }
    }
}
