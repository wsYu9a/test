package com.opos.cmn.func.dl.base;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class DownloadConfig implements Parcelable {
    public static final Parcelable.Creator<DownloadConfig> CREATOR = new Parcelable.Creator<DownloadConfig>() { // from class: com.opos.cmn.func.dl.base.DownloadConfig.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadConfig createFromParcel(Parcel parcel) {
            return new DownloadConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadConfig[] newArray(int i2) {
            return new DownloadConfig[i2];
        }
    };

    /* renamed from: a */
    private int f17184a;

    /* renamed from: b */
    private int f17185b;

    /* renamed from: c */
    private int f17186c;

    /* renamed from: d */
    private boolean f17187d;

    /* renamed from: e */
    private float f17188e;

    /* renamed from: f */
    private int f17189f;

    /* renamed from: g */
    private int f17190g;

    /* renamed from: com.opos.cmn.func.dl.base.DownloadConfig$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<DownloadConfig> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadConfig createFromParcel(Parcel parcel) {
            return new DownloadConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public final DownloadConfig[] newArray(int i2) {
            return new DownloadConfig[i2];
        }
    }

    public DownloadConfig() {
        this.f17184a = 3;
        this.f17185b = 2;
        this.f17186c = 3;
        this.f17187d = true;
        this.f17188e = 0.02f;
        this.f17189f = 100;
        this.f17190g = 8192;
    }

    private DownloadConfig(Parcel parcel) {
        this.f17184a = 3;
        this.f17185b = 2;
        this.f17186c = 3;
        this.f17187d = true;
        this.f17188e = 0.02f;
        this.f17189f = 100;
        this.f17190g = 8192;
        this.f17184a = parcel.readInt();
        this.f17185b = parcel.readInt();
        this.f17186c = parcel.readInt();
        this.f17187d = parcel.readByte() != 0;
        this.f17188e = parcel.readFloat();
        this.f17189f = parcel.readInt();
        this.f17190g = parcel.readInt();
    }

    /* synthetic */ DownloadConfig(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    public int a() {
        return this.f17184a;
    }

    public DownloadConfig a(float f2, int i2, int i3) {
        this.f17188e = f2;
        this.f17189f = i2;
        this.f17190g = i3;
        return this;
    }

    public DownloadConfig a(int i2) {
        this.f17186c = i2;
        return this;
    }

    public DownloadConfig a(boolean z) {
        this.f17187d = z;
        return this;
    }

    public int b() {
        return this.f17185b;
    }

    public int c() {
        return this.f17186c;
    }

    public boolean d() {
        return this.f17187d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float e() {
        return this.f17188e;
    }

    public int f() {
        return this.f17189f;
    }

    public int g() {
        return this.f17190g;
    }

    public String toString() {
        return "DownloadConfig{, readThreadCountPerTask=" + this.f17184a + ", writeThreadCount=" + this.f17185b + ", maxDownloadNum=" + this.f17186c + ", listenOnUi=" + this.f17187d + ", notifyRatio=" + this.f17188e + ", notifyInterval=" + this.f17189f + ", notifyIntervalSize=" + this.f17190g + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f17184a);
        parcel.writeInt(this.f17185b);
        parcel.writeInt(this.f17186c);
        parcel.writeByte(this.f17187d ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.f17188e);
        parcel.writeInt(this.f17189f);
        parcel.writeInt(this.f17190g);
    }
}
