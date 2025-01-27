package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ca;
import java.util.Map;

/* loaded from: classes4.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new g();

    /* renamed from: a */
    public long f22229a;

    /* renamed from: b */
    public int f22230b;

    /* renamed from: c */
    public String f22231c;

    /* renamed from: d */
    public String f22232d;

    /* renamed from: e */
    public long f22233e;

    /* renamed from: f */
    public long f22234f;

    /* renamed from: g */
    public long f22235g;

    /* renamed from: h */
    public long f22236h;

    /* renamed from: i */
    public long f22237i;

    /* renamed from: j */
    public String f22238j;

    /* renamed from: k */
    public long f22239k;

    /* renamed from: l */
    public boolean f22240l;

    /* renamed from: m */
    public String f22241m;

    /* renamed from: n */
    public String f22242n;

    /* renamed from: o */
    public int f22243o;

    /* renamed from: p */
    public int f22244p;

    /* renamed from: q */
    public int f22245q;

    /* renamed from: r */
    public Map<String, String> f22246r;

    /* renamed from: s */
    public Map<String, String> f22247s;

    public UserInfoBean() {
        this.f22239k = 0L;
        this.f22240l = false;
        this.f22241m = "unknown";
        this.f22244p = -1;
        this.f22245q = -1;
        this.f22246r = null;
        this.f22247s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22230b);
        parcel.writeString(this.f22231c);
        parcel.writeString(this.f22232d);
        parcel.writeLong(this.f22233e);
        parcel.writeLong(this.f22234f);
        parcel.writeLong(this.f22235g);
        parcel.writeLong(this.f22236h);
        parcel.writeLong(this.f22237i);
        parcel.writeString(this.f22238j);
        parcel.writeLong(this.f22239k);
        parcel.writeByte(this.f22240l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f22241m);
        parcel.writeInt(this.f22244p);
        parcel.writeInt(this.f22245q);
        ca.b(parcel, this.f22246r);
        ca.b(parcel, this.f22247s);
        parcel.writeString(this.f22242n);
        parcel.writeInt(this.f22243o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f22239k = 0L;
        this.f22240l = false;
        this.f22241m = "unknown";
        this.f22244p = -1;
        this.f22245q = -1;
        this.f22246r = null;
        this.f22247s = null;
        this.f22230b = parcel.readInt();
        this.f22231c = parcel.readString();
        this.f22232d = parcel.readString();
        this.f22233e = parcel.readLong();
        this.f22234f = parcel.readLong();
        this.f22235g = parcel.readLong();
        this.f22236h = parcel.readLong();
        this.f22237i = parcel.readLong();
        this.f22238j = parcel.readString();
        this.f22239k = parcel.readLong();
        this.f22240l = parcel.readByte() == 1;
        this.f22241m = parcel.readString();
        this.f22244p = parcel.readInt();
        this.f22245q = parcel.readInt();
        this.f22246r = ca.b(parcel);
        this.f22247s = ca.b(parcel);
        this.f22242n = parcel.readString();
        this.f22243o = parcel.readInt();
    }
}
