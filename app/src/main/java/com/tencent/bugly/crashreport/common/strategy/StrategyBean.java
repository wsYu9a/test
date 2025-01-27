package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ca;
import java.util.Map;

/* loaded from: classes4.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new a();

    /* renamed from: a */
    public static String f24763a = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: b */
    public static String f24764b = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: c */
    public static String f24765c;

    /* renamed from: d */
    public long f24766d;

    /* renamed from: e */
    public long f24767e;

    /* renamed from: f */
    public boolean f24768f;

    /* renamed from: g */
    public boolean f24769g;

    /* renamed from: h */
    public boolean f24770h;

    /* renamed from: i */
    public boolean f24771i;

    /* renamed from: j */
    public boolean f24772j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public long o;
    public long p;
    public String q;
    public String r;
    public String s;
    public Map<String, String> t;
    public int u;
    public long v;
    public long w;

    public StrategyBean() {
        this.f24766d = -1L;
        this.f24767e = -1L;
        this.f24768f = true;
        this.f24769g = true;
        this.f24770h = true;
        this.f24771i = true;
        this.f24772j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.p = 30000L;
        this.q = f24763a;
        this.r = f24764b;
        this.u = 10;
        this.v = com.alipay.mobilesecuritysdk.constant.a.k;
        this.w = -1L;
        this.f24767e = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(");
        sb.append("@L@L");
        sb.append("@)");
        f24765c = sb.toString();
        sb.setLength(0);
        sb.append("*^");
        sb.append("@K#K");
        sb.append("@!");
        this.s = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f24767e);
        parcel.writeByte(this.f24768f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f24769g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f24770h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        parcel.writeString(this.s);
        ca.b(parcel, this.t);
        parcel.writeByte(this.f24771i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f24772j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.p);
        parcel.writeByte(this.k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.o);
        parcel.writeInt(this.u);
        parcel.writeLong(this.v);
        parcel.writeLong(this.w);
    }

    public StrategyBean(Parcel parcel) {
        this.f24766d = -1L;
        this.f24767e = -1L;
        boolean z = true;
        this.f24768f = true;
        this.f24769g = true;
        this.f24770h = true;
        this.f24771i = true;
        this.f24772j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.p = 30000L;
        this.q = f24763a;
        this.r = f24764b;
        this.u = 10;
        this.v = com.alipay.mobilesecuritysdk.constant.a.k;
        this.w = -1L;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("S(");
            sb.append("@L@L");
            sb.append("@)");
            f24765c = sb.toString();
            this.f24767e = parcel.readLong();
            this.f24768f = parcel.readByte() == 1;
            this.f24769g = parcel.readByte() == 1;
            this.f24770h = parcel.readByte() == 1;
            this.q = parcel.readString();
            this.r = parcel.readString();
            this.s = parcel.readString();
            this.t = ca.b(parcel);
            this.f24771i = parcel.readByte() == 1;
            this.f24772j = parcel.readByte() == 1;
            this.m = parcel.readByte() == 1;
            this.n = parcel.readByte() == 1;
            this.p = parcel.readLong();
            this.k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.l = z;
            this.o = parcel.readLong();
            this.u = parcel.readInt();
            this.v = parcel.readLong();
            this.w = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
