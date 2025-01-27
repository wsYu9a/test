package com.opos.cmn.func.dl.base;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class DownloadResponse implements Parcelable {
    public static final Parcelable.Creator<DownloadResponse> CREATOR = new Parcelable.Creator<DownloadResponse>() { // from class: com.opos.cmn.func.dl.base.DownloadResponse.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadResponse createFromParcel(Parcel parcel) {
            return new DownloadResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadResponse[] newArray(int i2) {
            return new DownloadResponse[i2];
        }
    };

    /* renamed from: a */
    public int f17211a;

    /* renamed from: b */
    public long f17212b;

    /* renamed from: c */
    public long f17213c;

    /* renamed from: d */
    public long f17214d;

    /* renamed from: e */
    public long f17215e;

    /* renamed from: com.opos.cmn.func.dl.base.DownloadResponse$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<DownloadResponse> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadResponse createFromParcel(Parcel parcel) {
            return new DownloadResponse(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadResponse[] newArray(int i2) {
            return new DownloadResponse[i2];
        }
    }

    public DownloadResponse() {
        this.f17211a = 0;
    }

    private DownloadResponse(Parcel parcel) {
        this.f17211a = 0;
        this.f17211a = parcel.readInt();
        this.f17212b = parcel.readLong();
        this.f17213c = parcel.readLong();
        this.f17214d = parcel.readLong();
        this.f17215e = parcel.readLong();
    }

    /* synthetic */ DownloadResponse(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "StatusResponse{status=" + this.f17211a + ", startLen=" + this.f17212b + ", downloadedLen=" + this.f17213c + ", totalLen=" + this.f17214d + ", speed=" + this.f17215e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f17211a);
        parcel.writeLong(this.f17212b);
        parcel.writeLong(this.f17213c);
        parcel.writeLong(this.f17214d);
        parcel.writeLong(this.f17215e);
    }
}
