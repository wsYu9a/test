package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ca;
import java.util.Map;

/* loaded from: classes4.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new a();

    /* renamed from: a */
    public static String f22337a = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: b */
    public static String f22338b = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: c */
    public static String f22339c;

    /* renamed from: d */
    public long f22340d;

    /* renamed from: e */
    public long f22341e;

    /* renamed from: f */
    public boolean f22342f;

    /* renamed from: g */
    public boolean f22343g;

    /* renamed from: h */
    public boolean f22344h;

    /* renamed from: i */
    public boolean f22345i;

    /* renamed from: j */
    public boolean f22346j;

    /* renamed from: k */
    public boolean f22347k;

    /* renamed from: l */
    public boolean f22348l;

    /* renamed from: m */
    public boolean f22349m;

    /* renamed from: n */
    public boolean f22350n;

    /* renamed from: o */
    public long f22351o;

    /* renamed from: p */
    public long f22352p;

    /* renamed from: q */
    public String f22353q;

    /* renamed from: r */
    public String f22354r;

    /* renamed from: s */
    public String f22355s;

    /* renamed from: t */
    public Map<String, String> f22356t;

    /* renamed from: u */
    public int f22357u;

    /* renamed from: v */
    public long f22358v;

    /* renamed from: w */
    public long f22359w;

    public StrategyBean() {
        this.f22340d = -1L;
        this.f22341e = -1L;
        this.f22342f = true;
        this.f22343g = true;
        this.f22344h = true;
        this.f22345i = true;
        this.f22346j = false;
        this.f22347k = true;
        this.f22348l = true;
        this.f22349m = true;
        this.f22350n = true;
        this.f22352p = 30000L;
        this.f22353q = f22337a;
        this.f22354r = f22338b;
        this.f22357u = 10;
        this.f22358v = 300000L;
        this.f22359w = -1L;
        this.f22341e = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("S(");
        sb2.append("@L@L");
        sb2.append("@)");
        f22339c = sb2.toString();
        sb2.setLength(0);
        sb2.append("*^");
        sb2.append("@K#K");
        sb2.append("@!");
        this.f22355s = sb2.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f22341e);
        parcel.writeByte(this.f22342f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f22343g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f22344h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f22353q);
        parcel.writeString(this.f22354r);
        parcel.writeString(this.f22355s);
        ca.b(parcel, this.f22356t);
        parcel.writeByte(this.f22345i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f22346j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f22349m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f22350n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f22352p);
        parcel.writeByte(this.f22347k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f22348l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f22351o);
        parcel.writeInt(this.f22357u);
        parcel.writeLong(this.f22358v);
        parcel.writeLong(this.f22359w);
    }

    public StrategyBean(Parcel parcel) {
        this.f22340d = -1L;
        this.f22341e = -1L;
        boolean z10 = true;
        this.f22342f = true;
        this.f22343g = true;
        this.f22344h = true;
        this.f22345i = true;
        this.f22346j = false;
        this.f22347k = true;
        this.f22348l = true;
        this.f22349m = true;
        this.f22350n = true;
        this.f22352p = 30000L;
        this.f22353q = f22337a;
        this.f22354r = f22338b;
        this.f22357u = 10;
        this.f22358v = 300000L;
        this.f22359w = -1L;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("S(");
            sb2.append("@L@L");
            sb2.append("@)");
            f22339c = sb2.toString();
            this.f22341e = parcel.readLong();
            this.f22342f = parcel.readByte() == 1;
            this.f22343g = parcel.readByte() == 1;
            this.f22344h = parcel.readByte() == 1;
            this.f22353q = parcel.readString();
            this.f22354r = parcel.readString();
            this.f22355s = parcel.readString();
            this.f22356t = ca.b(parcel);
            this.f22345i = parcel.readByte() == 1;
            this.f22346j = parcel.readByte() == 1;
            this.f22349m = parcel.readByte() == 1;
            this.f22350n = parcel.readByte() == 1;
            this.f22352p = parcel.readLong();
            this.f22347k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z10 = false;
            }
            this.f22348l = z10;
            this.f22351o = parcel.readLong();
            this.f22357u = parcel.readInt();
            this.f22358v = parcel.readLong();
            this.f22359w = parcel.readLong();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
