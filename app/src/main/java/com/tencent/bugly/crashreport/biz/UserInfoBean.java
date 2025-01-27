package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.EnvironmentCompat;
import com.tencent.bugly.proguard.ca;
import java.util.Map;

/* loaded from: classes4.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new g();

    /* renamed from: a */
    public long f24707a;

    /* renamed from: b */
    public int f24708b;

    /* renamed from: c */
    public String f24709c;

    /* renamed from: d */
    public String f24710d;

    /* renamed from: e */
    public long f24711e;

    /* renamed from: f */
    public long f24712f;

    /* renamed from: g */
    public long f24713g;

    /* renamed from: h */
    public long f24714h;

    /* renamed from: i */
    public long f24715i;

    /* renamed from: j */
    public String f24716j;
    public long k;
    public boolean l;
    public String m;
    public String n;
    public int o;
    public int p;
    public int q;
    public Map<String, String> r;
    public Map<String, String> s;

    public UserInfoBean() {
        this.k = 0L;
        this.l = false;
        this.m = EnvironmentCompat.MEDIA_UNKNOWN;
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f24708b);
        parcel.writeString(this.f24709c);
        parcel.writeString(this.f24710d);
        parcel.writeLong(this.f24711e);
        parcel.writeLong(this.f24712f);
        parcel.writeLong(this.f24713g);
        parcel.writeLong(this.f24714h);
        parcel.writeLong(this.f24715i);
        parcel.writeString(this.f24716j);
        parcel.writeLong(this.k);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.m);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        ca.b(parcel, this.r);
        ca.b(parcel, this.s);
        parcel.writeString(this.n);
        parcel.writeInt(this.o);
    }

    public UserInfoBean(Parcel parcel) {
        this.k = 0L;
        this.l = false;
        this.m = EnvironmentCompat.MEDIA_UNKNOWN;
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
        this.f24708b = parcel.readInt();
        this.f24709c = parcel.readString();
        this.f24710d = parcel.readString();
        this.f24711e = parcel.readLong();
        this.f24712f = parcel.readLong();
        this.f24713g = parcel.readLong();
        this.f24714h = parcel.readLong();
        this.f24715i = parcel.readLong();
        this.f24716j = parcel.readString();
        this.k = parcel.readLong();
        this.l = parcel.readByte() == 1;
        this.m = parcel.readString();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = ca.b(parcel);
        this.s = ca.b(parcel);
        this.n = parcel.readString();
        this.o = parcel.readInt();
    }
}
