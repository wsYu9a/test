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
    public long f24787a;

    /* renamed from: b */
    public int f24788b;

    /* renamed from: c */
    public String f24789c;

    /* renamed from: d */
    public boolean f24790d;

    /* renamed from: e */
    public String f24791e;

    /* renamed from: f */
    public String f24792f;

    /* renamed from: g */
    public String f24793g;

    /* renamed from: h */
    public Map<String, PlugInBean> f24794h;

    /* renamed from: i */
    public Map<String, PlugInBean> f24795i;

    /* renamed from: j */
    public boolean f24796j;
    public boolean k;
    public int l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public long r;
    public String s;
    public int t;
    public String u;
    public String v;
    public String w;
    public String x;
    public byte[] y;
    public Map<String, String> z;

    public CrashDetailBean() {
        this.f24787a = -1L;
        this.f24788b = 0;
        this.f24789c = UUID.randomUUID().toString();
        this.f24790d = false;
        this.f24791e = "";
        this.f24792f = "";
        this.f24793g = "";
        this.f24794h = null;
        this.f24795i = null;
        this.f24796j = false;
        this.k = false;
        this.l = 0;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
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
        long j2 = this.r - crashDetailBean.r;
        if (j2 > 0) {
            return 1;
        }
        return j2 < 0 ? -1 : 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f24788b);
        parcel.writeString(this.f24789c);
        parcel.writeByte(this.f24790d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f24791e);
        parcel.writeString(this.f24792f);
        parcel.writeString(this.f24793g);
        parcel.writeByte(this.f24796j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.l);
        parcel.writeString(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeLong(this.r);
        parcel.writeString(this.s);
        parcel.writeInt(this.t);
        parcel.writeString(this.u);
        parcel.writeString(this.v);
        parcel.writeString(this.w);
        ca.b(parcel, this.z);
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
        ca.a(parcel, this.f24794h);
        ca.a(parcel, this.f24795i);
        parcel.writeInt(this.R);
        parcel.writeInt(this.S);
        ca.b(parcel, this.T);
        ca.b(parcel, this.U);
        parcel.writeByteArray(this.V);
        parcel.writeByteArray(this.y);
        parcel.writeString(this.W);
        parcel.writeString(this.X);
        parcel.writeString(this.x);
    }

    public CrashDetailBean(Parcel parcel) {
        this.f24787a = -1L;
        this.f24788b = 0;
        this.f24789c = UUID.randomUUID().toString();
        this.f24790d = false;
        this.f24791e = "";
        this.f24792f = "";
        this.f24793g = "";
        this.f24794h = null;
        this.f24795i = null;
        this.f24796j = false;
        this.k = false;
        this.l = 0;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.r = -1L;
        this.s = null;
        this.t = 0;
        this.u = "";
        this.v = "";
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
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
        this.f24788b = parcel.readInt();
        this.f24789c = parcel.readString();
        this.f24790d = parcel.readByte() == 1;
        this.f24791e = parcel.readString();
        this.f24792f = parcel.readString();
        this.f24793g = parcel.readString();
        this.f24796j = parcel.readByte() == 1;
        this.k = parcel.readByte() == 1;
        this.l = parcel.readInt();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.o = parcel.readString();
        this.p = parcel.readString();
        this.q = parcel.readString();
        this.r = parcel.readLong();
        this.s = parcel.readString();
        this.t = parcel.readInt();
        this.u = parcel.readString();
        this.v = parcel.readString();
        this.w = parcel.readString();
        this.z = ca.b(parcel);
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
        this.f24794h = ca.a(parcel);
        this.f24795i = ca.a(parcel);
        this.R = parcel.readInt();
        this.S = parcel.readInt();
        this.T = ca.b(parcel);
        this.U = ca.b(parcel);
        this.V = parcel.createByteArray();
        this.y = parcel.createByteArray();
        this.W = parcel.readString();
        this.X = parcel.readString();
        this.x = parcel.readString();
    }
}
