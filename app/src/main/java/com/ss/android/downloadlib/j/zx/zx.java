package com.ss.android.downloadlib.j.zx;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class zx implements Parcelable {
    public static final Parcelable.Creator<zx> CREATOR = new Parcelable.Creator<zx>() { // from class: com.ss.android.downloadlib.j.zx.zx.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: j */
        public zx createFromParcel(Parcel parcel) {
            return new zx(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: j */
        public zx[] newArray(int i2) {
            return new zx[i2];
        }
    };

    /* renamed from: g */
    public int f24311g;
    public String gv;

    /* renamed from: i */
    public String f24312i;

    /* renamed from: j */
    public int f24313j;
    public String q;
    public int zx;

    /* renamed from: com.ss.android.downloadlib.j.zx.zx$1 */
    static class AnonymousClass1 implements Parcelable.Creator<zx> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: j */
        public zx createFromParcel(Parcel parcel) {
            return new zx(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: j */
        public zx[] newArray(int i2) {
            return new zx[i2];
        }
    }

    public zx() {
        this.f24312i = "";
        this.q = "";
        this.gv = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zx zxVar = (zx) obj;
            if (this.f24313j == zxVar.f24313j && this.zx == zxVar.zx) {
                String str = this.f24312i;
                if (str != null) {
                    return str.equals(zxVar.f24312i);
                }
                if (zxVar.f24312i == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.f24313j * 31) + this.zx) * 31;
        String str = this.f24312i;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f24313j);
        parcel.writeInt(this.zx);
        parcel.writeString(this.f24312i);
        parcel.writeString(this.q);
        parcel.writeString(this.gv);
        parcel.writeInt(this.f24311g);
    }

    protected zx(Parcel parcel) {
        this.f24312i = "";
        this.q = "";
        this.gv = "";
        this.f24313j = parcel.readInt();
        this.zx = parcel.readInt();
        this.f24312i = parcel.readString();
        this.q = parcel.readString();
        this.gv = parcel.readString();
        this.f24311g = parcel.readInt();
    }
}
