package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.ca;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes4.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new c();
    public String A;
    public String B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public String I;
    public String J;
    public String K;
    public String L;
    public String M;
    public long N;
    public boolean O;
    public Map<String, String> P;
    public Map<String, String> Q;
    public int R;
    public int S;
    public Map<String, String> T;
    public Map<String, String> U;
    public byte[] V;
    public String W;
    public String X;

    /* renamed from: a */
    public long f22374a;

    /* renamed from: b */
    public int f22375b;

    /* renamed from: c */
    public String f22376c;

    /* renamed from: d */
    public boolean f22377d;

    /* renamed from: e */
    public String f22378e;

    /* renamed from: f */
    public String f22379f;

    /* renamed from: g */
    public String f22380g;

    /* renamed from: h */
    public Map<String, PlugInBean> f22381h;

    /* renamed from: i */
    public Map<String, PlugInBean> f22382i;

    /* renamed from: j */
    public boolean f22383j;

    /* renamed from: k */
    public boolean f22384k;

    /* renamed from: l */
    public int f22385l;

    /* renamed from: m */
    public String f22386m;

    /* renamed from: n */
    public String f22387n;

    /* renamed from: o */
    public String f22388o;

    /* renamed from: p */
    public String f22389p;

    /* renamed from: q */
    public String f22390q;

    /* renamed from: r */
    public long f22391r;

    /* renamed from: s */
    public String f22392s;

    /* renamed from: t */
    public int f22393t;

    /* renamed from: u */
    public String f22394u;

    /* renamed from: v */
    public String f22395v;

    /* renamed from: w */
    public String f22396w;

    /* renamed from: x */
    public String f22397x;

    /* renamed from: y */
    public byte[] f22398y;

    /* renamed from: z */
    public Map<String, String> f22399z;

    public CrashDetailBean() {
        this.f22374a = -1L;
        this.f22375b = 0;
        this.f22376c = UUID.randomUUID().toString();
        this.f22377d = false;
        this.f22378e = "";
        this.f22379f = "";
        this.f22380g = "";
        this.f22381h = null;
        this.f22382i = null;
        this.f22383j = false;
        this.f22384k = false;
        this.f22385l = 0;
        this.f22386m = "";
        this.f22387n = "";
        this.f22388o = "";
        this.f22389p = "";
        this.f22390q = "";
        this.f22391r = -1L;
        this.f22392s = null;
        this.f22393t = 0;
        this.f22394u = "";
        this.f22395v = "";
        this.f22396w = null;
        this.f22397x = null;
        this.f22398y = null;
        this.f22399z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = -1L;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = -1;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return 1;
        }
        long j10 = this.f22391r - crashDetailBean.f22391r;
        if (j10 > 0) {
            return 1;
        }
        return j10 < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22375b);
        parcel.writeString(this.f22376c);
        parcel.writeByte(this.f22377d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f22378e);
        parcel.writeString(this.f22379f);
        parcel.writeString(this.f22380g);
        parcel.writeByte(this.f22383j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f22384k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f22385l);
        parcel.writeString(this.f22386m);
        parcel.writeString(this.f22387n);
        parcel.writeString(this.f22388o);
        parcel.writeString(this.f22389p);
        parcel.writeString(this.f22390q);
        parcel.writeLong(this.f22391r);
        parcel.writeString(this.f22392s);
        parcel.writeInt(this.f22393t);
        parcel.writeString(this.f22394u);
        parcel.writeString(this.f22395v);
        parcel.writeString(this.f22396w);
        ca.b(parcel, this.f22399z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeLong(this.N);
        parcel.writeByte(this.O ? (byte) 1 : (byte) 0);
        ca.b(parcel, this.P);
        ca.a(parcel, this.f22381h);
        ca.a(parcel, this.f22382i);
        parcel.writeInt(this.R);
        parcel.writeInt(this.S);
        ca.b(parcel, this.T);
        ca.b(parcel, this.U);
        parcel.writeByteArray(this.V);
        parcel.writeByteArray(this.f22398y);
        parcel.writeString(this.W);
        parcel.writeString(this.X);
        parcel.writeString(this.f22397x);
    }

    public CrashDetailBean(Parcel parcel) {
        this.f22374a = -1L;
        this.f22375b = 0;
        this.f22376c = UUID.randomUUID().toString();
        this.f22377d = false;
        this.f22378e = "";
        this.f22379f = "";
        this.f22380g = "";
        this.f22381h = null;
        this.f22382i = null;
        this.f22383j = false;
        this.f22384k = false;
        this.f22385l = 0;
        this.f22386m = "";
        this.f22387n = "";
        this.f22388o = "";
        this.f22389p = "";
        this.f22390q = "";
        this.f22391r = -1L;
        this.f22392s = null;
        this.f22393t = 0;
        this.f22394u = "";
        this.f22395v = "";
        this.f22396w = null;
        this.f22397x = null;
        this.f22398y = null;
        this.f22399z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.N = -1L;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = -1;
        this.S = -1;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.f22375b = parcel.readInt();
        this.f22376c = parcel.readString();
        this.f22377d = parcel.readByte() == 1;
        this.f22378e = parcel.readString();
        this.f22379f = parcel.readString();
        this.f22380g = parcel.readString();
        this.f22383j = parcel.readByte() == 1;
        this.f22384k = parcel.readByte() == 1;
        this.f22385l = parcel.readInt();
        this.f22386m = parcel.readString();
        this.f22387n = parcel.readString();
        this.f22388o = parcel.readString();
        this.f22389p = parcel.readString();
        this.f22390q = parcel.readString();
        this.f22391r = parcel.readLong();
        this.f22392s = parcel.readString();
        this.f22393t = parcel.readInt();
        this.f22394u = parcel.readString();
        this.f22395v = parcel.readString();
        this.f22396w = parcel.readString();
        this.f22399z = ca.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readLong();
        this.O = parcel.readByte() == 1;
        this.P = ca.b(parcel);
        this.f22381h = ca.a(parcel);
        this.f22382i = ca.a(parcel);
        this.R = parcel.readInt();
        this.S = parcel.readInt();
        this.T = ca.b(parcel);
        this.U = ca.b(parcel);
        this.V = parcel.createByteArray();
        this.f22398y = parcel.createByteArray();
        this.W = parcel.readString();
        this.X = parcel.readString();
        this.f22397x = parcel.readString();
    }
}
