package com.kwai.filedownloader.c;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.cdo.oaps.ad.OapsWrapper;
import com.kwai.filedownloader.e.f;
import com.vivo.ic.dm.Downloads;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public final class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.kwai.filedownloader.c.c.1
        AnonymousClass1() {
        }

        private static c c(Parcel parcel) {
            return new c(parcel);
        }

        private static c[] dc(int i2) {
            return new c[i2];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c[] newArray(int i2) {
            return dc(i2);
        }
    };
    private String RZ;
    private boolean aII;
    private final AtomicInteger aIJ;
    private final AtomicLong aIK;
    private long aIL;
    private String aIM;
    private String aIN;
    private int aIO;
    private boolean aIv;
    private String filename;
    private int id;
    private String url;

    /* renamed from: com.kwai.filedownloader.c.c$1 */
    static class AnonymousClass1 implements Parcelable.Creator<c> {
        AnonymousClass1() {
        }

        private static c c(Parcel parcel) {
            return new c(parcel);
        }

        private static c[] dc(int i2) {
            return new c[i2];
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c createFromParcel(Parcel parcel) {
            return c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ c[] newArray(int i2) {
            return dc(i2);
        }
    }

    public c() {
        this.aIK = new AtomicLong();
        this.aIJ = new AtomicInteger();
    }

    protected c(Parcel parcel) {
        this.id = parcel.readInt();
        this.url = parcel.readString();
        this.RZ = parcel.readString();
        this.aII = parcel.readByte() != 0;
        this.filename = parcel.readString();
        this.aIJ = new AtomicInteger(parcel.readByte());
        this.aIK = new AtomicLong(parcel.readLong());
        this.aIL = parcel.readLong();
        this.aIM = parcel.readString();
        this.aIN = parcel.readString();
        this.aIO = parcel.readInt();
        this.aIv = parcel.readByte() != 0;
    }

    private String Ai() {
        return this.aIM;
    }

    public final boolean Gm() {
        return this.aII;
    }

    public final byte Gq() {
        return (byte) this.aIJ.get();
    }

    public final boolean Gw() {
        return this.aIv;
    }

    public final String HT() {
        if (getTargetFilePath() == null) {
            return null;
        }
        return f.fB(getTargetFilePath());
    }

    public final long IB() {
        return this.aIK.get();
    }

    public final String IC() {
        return this.aIN;
    }

    public final int ID() {
        return this.aIO;
    }

    public final void IE() {
        this.aIO = 1;
    }

    public final ContentValues Iz() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(getId()));
        contentValues.put("url", getUrl());
        contentValues.put(OapsWrapper.KEY_PATH, getPath());
        contentValues.put("status", Byte.valueOf(Gq()));
        contentValues.put("sofar", Long.valueOf(IB()));
        contentValues.put("total", Long.valueOf(getTotal()));
        contentValues.put("errMsg", Ai());
        contentValues.put(Downloads.Column.ETAG, IC());
        contentValues.put("connectionCount", Integer.valueOf(ID()));
        contentValues.put("pathAsDirectory", Boolean.valueOf(Gm()));
        if (Gm() && getFilename() != null) {
            contentValues.put("filename", getFilename());
        }
        return contentValues;
    }

    public final void ao(long j2) {
        this.aIK.set(j2);
    }

    public final void ap(long j2) {
        this.aIK.addAndGet(j2);
    }

    public final void aq(long j2) {
        this.aIv = j2 > 2147483647L;
        this.aIL = j2;
    }

    public final void db(int i2) {
        this.aIO = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(byte b2) {
        this.aIJ.set(b2);
    }

    public final void fv(String str) {
        this.aIN = str;
    }

    public final void fw(String str) {
        this.aIM = str;
    }

    public final void fx(String str) {
        this.filename = str;
    }

    public final void g(String str, boolean z) {
        this.RZ = str;
        this.aII = z;
    }

    public final String getFilename() {
        return this.filename;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPath() {
        return this.RZ;
    }

    public final String getTargetFilePath() {
        return f.a(getPath(), Gm(), getFilename());
    }

    public final long getTotal() {
        return this.aIL;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean isChunked() {
        return this.aIL == -1;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String toString() {
        return f.j("id[%d], url[%s], path[%s], status[%d], sofar[%s], total[%d], etag[%s], %s", Integer.valueOf(this.id), this.url, this.RZ, Integer.valueOf(this.aIJ.get()), this.aIK, Long.valueOf(this.aIL), this.aIN, super.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeString(this.url);
        parcel.writeString(this.RZ);
        parcel.writeByte(this.aII ? (byte) 1 : (byte) 0);
        parcel.writeString(this.filename);
        parcel.writeByte((byte) this.aIJ.get());
        parcel.writeLong(this.aIK.get());
        parcel.writeLong(this.aIL);
        parcel.writeString(this.aIM);
        parcel.writeString(this.aIN);
        parcel.writeInt(this.aIO);
        parcel.writeByte(this.aIv ? (byte) 1 : (byte) 0);
    }
}
