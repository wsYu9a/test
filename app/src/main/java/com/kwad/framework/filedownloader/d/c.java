package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.kwad.framework.filedownloader.f.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.kwad.framework.filedownloader.d.c.1
        private static c[] bF(int i10) {
            return new c[i10];
        }

        private static c c(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c[] newArray(int i10) {
            return bF(i10);
        }
    };
    private String Yx;
    private boolean akM;
    private final AtomicInteger akN;
    private final AtomicLong akO;
    private long akP;
    private String akQ;
    private String akR;
    private int akS;
    private boolean akz;
    private String filename;

    /* renamed from: id */
    private int f11965id;
    private String url;

    /* renamed from: com.kwad.framework.filedownloader.d.c$1 */
    public class AnonymousClass1 implements Parcelable.Creator<c> {
        private static c[] bF(int i10) {
            return new c[i10];
        }

        private static c c(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c[] newArray(int i10) {
            return bF(i10);
        }
    }

    public c() {
        this.akO = new AtomicLong();
        this.akN = new AtomicInteger();
    }

    private String xv() {
        return this.akQ;
    }

    public final void T(long j10) {
        this.akO.set(j10);
    }

    public final void U(long j10) {
        this.akO.addAndGet(j10);
    }

    public final void V(long j10) {
        this.akz = j10 > 2147483647L;
        this.akP = j10;
    }

    public final void bE(int i10) {
        this.akS = i10;
    }

    public final void br(String str) {
        this.akR = str;
    }

    public final void bs(String str) {
        this.akQ = str;
    }

    public final void bt(String str) {
        this.filename = str;
    }

    public final void d(String str, boolean z10) {
        this.Yx = str;
        this.akM = z10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final int getId() {
        return this.f11965id;
    }

    public final String getPath() {
        return this.Yx;
    }

    public final String getTargetFilePath() {
        return f.a(getPath(), uZ(), getFilename());
    }

    public final long getTotal() {
        return this.akP;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isChunked() {
        return this.akP == -1;
    }

    public final void setId(int i10) {
        this.f11965id = i10;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String toString() {
        return f.b("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.f11965id), this.url, this.Yx, Integer.valueOf(this.akN.get()), this.akO, Long.valueOf(this.akP), this.akR, super.toString());
    }

    public final boolean uZ() {
        return this.akM;
    }

    public final byte vd() {
        return (byte) this.akN.get();
    }

    public final boolean vj() {
        return this.akz;
    }

    public final String wL() {
        if (getTargetFilePath() == null) {
            return null;
        }
        return f.bx(getTargetFilePath());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f11965id);
        parcel.writeString(this.url);
        parcel.writeString(this.Yx);
        parcel.writeByte(this.akM ? (byte) 1 : (byte) 0);
        parcel.writeString(this.filename);
        parcel.writeByte((byte) this.akN.get());
        parcel.writeLong(this.akO.get());
        parcel.writeLong(this.akP);
        parcel.writeString(this.akQ);
        parcel.writeString(this.akR);
        parcel.writeInt(this.akS);
        parcel.writeByte(this.akz ? (byte) 1 : (byte) 0);
    }

    public final ContentValues xr() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(getId()));
        contentValues.put("url", getUrl());
        contentValues.put(t8.a.f30751f, getPath());
        contentValues.put("status", Byte.valueOf(vd()));
        contentValues.put("sofar", Long.valueOf(xt()));
        contentValues.put("total", Long.valueOf(getTotal()));
        contentValues.put("errMsg", xv());
        contentValues.put(com.sigmob.sdk.downloader.core.breakpoint.f.f19041c, xu());
        contentValues.put("connectionCount", Integer.valueOf(xw()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(uZ()));
        if (uZ() && getFilename() != null) {
            contentValues.put(com.sigmob.sdk.downloader.core.breakpoint.f.f19043e, getFilename());
        }
        return contentValues;
    }

    public final long xt() {
        return this.akO.get();
    }

    public final String xu() {
        return this.akR;
    }

    public final int xw() {
        return this.akS;
    }

    public final void xx() {
        this.akS = 1;
    }

    public final void d(byte b10) {
        this.akN.set(b10);
    }

    public c(Parcel parcel) {
        this.f11965id = parcel.readInt();
        this.url = parcel.readString();
        this.Yx = parcel.readString();
        this.akM = parcel.readByte() != 0;
        this.filename = parcel.readString();
        this.akN = new AtomicInteger(parcel.readByte());
        this.akO = new AtomicLong(parcel.readLong());
        this.akP = parcel.readLong();
        this.akQ = parcel.readString();
        this.akR = parcel.readString();
        this.akS = parcel.readInt();
        this.akz = parcel.readByte() != 0;
    }
}
