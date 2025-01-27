package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.opos.cmn.an.a.b;
import com.opos.mobad.b.a.b;
import com.opos.mobad.b.a.e;
import com.opos.mobad.b.a.h;
import com.opos.mobad.b.a.t;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class AdItemData extends a implements Parcelable {
    private boolean A;
    private boolean B;
    private int C;
    private ActivatingData D;
    private int E;
    private boolean F;
    private String G;
    private String H;
    private int I;
    private volatile boolean J;
    private volatile boolean K;
    private long L;
    private AppPrivacyData M;
    private CustomInfoData N;
    private int O;
    private String P;
    private int Q;
    private int R;
    private String S;
    private String T;

    /* renamed from: d */
    List<MaterialData> f21688d;

    /* renamed from: e */
    private String f21689e;

    /* renamed from: f */
    private String f21690f;

    /* renamed from: g */
    private String f21691g;

    /* renamed from: h */
    private String f21692h;

    /* renamed from: i */
    private String f21693i;

    /* renamed from: j */
    private String f21694j;
    private String k;
    private boolean l;
    private int m;
    private MaterialFileData n;
    private int o;
    private String p;
    private long q;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private long w;
    private boolean x;
    private int y;
    private String z;

    /* renamed from: a */
    public static final String f21685a = b.a("b3Bwb19hZHg=");

    /* renamed from: b */
    public static final String f21686b = b.a("b3Bwb19mZWVk");

    /* renamed from: c */
    public static final String f21687c = b.a("b3Bwb19jcGQ=");
    public static final Parcelable.Creator<AdItemData> CREATOR = new Parcelable.Creator<AdItemData>() { // from class: com.opos.mobad.model.data.AdItemData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdItemData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            AdItemData adItemData = new AdItemData();
            adItemData.a(parcel.readString());
            adItemData.b(parcel.readString());
            adItemData.c(parcel.readString());
            adItemData.d(parcel.readString());
            adItemData.e(parcel.readString());
            adItemData.f(parcel.readString());
            adItemData.g(parcel.readString());
            adItemData.a(parcel.createTypedArrayList(MaterialData.CREATOR));
            adItemData.a(parcel.readByte() != 0);
            adItemData.a(parcel.readInt());
            adItemData.a((MaterialFileData) parcel.readParcelable(MaterialFileData.class.getClassLoader()));
            adItemData.b(parcel.readInt());
            adItemData.h(parcel.readString());
            adItemData.a(parcel.readLong());
            adItemData.b(parcel.readByte() != 0);
            adItemData.c(parcel.readInt());
            adItemData.d(parcel.readInt());
            adItemData.e(parcel.readInt());
            adItemData.f(parcel.readInt());
            adItemData.b(parcel.readLong());
            adItemData.c(parcel.readByte() != 0);
            adItemData.g(parcel.readInt());
            adItemData.i(parcel.readString());
            adItemData.e(parcel.readByte() != 0);
            adItemData.h(parcel.readInt());
            adItemData.i(parcel.readInt());
            adItemData.a((ActivatingData) parcel.readParcelable(ActivatingData.class.getClassLoader()));
            adItemData.j(parcel.readString());
            adItemData.H = parcel.readString();
            adItemData.I = parcel.readInt();
            adItemData.f(parcel.readByte() != 0);
            adItemData.g(parcel.readByte() != 0);
            adItemData.L = parcel.readLong();
            adItemData.a((AppPrivacyData) parcel.readParcelable(AppPrivacyData.class.getClassLoader()));
            adItemData.N = (CustomInfoData) parcel.readParcelable(CustomInfoData.class.getClassLoader());
            adItemData.O = parcel.readInt();
            adItemData.P = parcel.readString();
            adItemData.Q = parcel.readInt();
            adItemData.S = parcel.readString();
            adItemData.R = parcel.readInt();
            adItemData.T = parcel.readString();
            return adItemData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdItemData[] newArray(int i2) {
            return new AdItemData[i2];
        }
    };

    /* renamed from: com.opos.mobad.model.data.AdItemData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<AdItemData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdItemData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            AdItemData adItemData = new AdItemData();
            adItemData.a(parcel.readString());
            adItemData.b(parcel.readString());
            adItemData.c(parcel.readString());
            adItemData.d(parcel.readString());
            adItemData.e(parcel.readString());
            adItemData.f(parcel.readString());
            adItemData.g(parcel.readString());
            adItemData.a(parcel.createTypedArrayList(MaterialData.CREATOR));
            adItemData.a(parcel.readByte() != 0);
            adItemData.a(parcel.readInt());
            adItemData.a((MaterialFileData) parcel.readParcelable(MaterialFileData.class.getClassLoader()));
            adItemData.b(parcel.readInt());
            adItemData.h(parcel.readString());
            adItemData.a(parcel.readLong());
            adItemData.b(parcel.readByte() != 0);
            adItemData.c(parcel.readInt());
            adItemData.d(parcel.readInt());
            adItemData.e(parcel.readInt());
            adItemData.f(parcel.readInt());
            adItemData.b(parcel.readLong());
            adItemData.c(parcel.readByte() != 0);
            adItemData.g(parcel.readInt());
            adItemData.i(parcel.readString());
            adItemData.e(parcel.readByte() != 0);
            adItemData.h(parcel.readInt());
            adItemData.i(parcel.readInt());
            adItemData.a((ActivatingData) parcel.readParcelable(ActivatingData.class.getClassLoader()));
            adItemData.j(parcel.readString());
            adItemData.H = parcel.readString();
            adItemData.I = parcel.readInt();
            adItemData.f(parcel.readByte() != 0);
            adItemData.g(parcel.readByte() != 0);
            adItemData.L = parcel.readLong();
            adItemData.a((AppPrivacyData) parcel.readParcelable(AppPrivacyData.class.getClassLoader()));
            adItemData.N = (CustomInfoData) parcel.readParcelable(CustomInfoData.class.getClassLoader());
            adItemData.O = parcel.readInt();
            adItemData.P = parcel.readString();
            adItemData.Q = parcel.readInt();
            adItemData.S = parcel.readString();
            adItemData.R = parcel.readInt();
            adItemData.T = parcel.readString();
            return adItemData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AdItemData[] newArray(int i2) {
            return new AdItemData[i2];
        }
    }

    /* renamed from: com.opos.mobad.model.data.AdItemData$2 */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a */
        static final /* synthetic */ int[] f21695a;

        /* renamed from: b */
        static final /* synthetic */ int[] f21696b;

        /* renamed from: c */
        static final /* synthetic */ int[] f21697c;

        static {
            int[] iArr = new int[b.c.values().length];
            f21697c = iArr;
            try {
                iArr[b.c.PLAY_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21697c[b.c.PLAY_STREAM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[b.f.values().length];
            f21696b = iArr2;
            try {
                iArr2[b.f.TOP_RIGHT_CORNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21696b[b.f.MIDDLE_RIGHT_CORNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21696b[b.f.BOTTOM_RIGHT_CORNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr3 = new int[b.EnumC0424b.values().length];
            f21695a = iArr3;
            try {
                iArr3[b.EnumC0424b.SENSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f21695a[b.EnumC0424b.HORIZONTAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f21695a[b.EnumC0424b.VERTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public AdItemData() {
        this.z = "广告";
        this.A = false;
        this.B = false;
        this.F = false;
        this.J = false;
        this.K = false;
    }

    public AdItemData(com.opos.mobad.b.a.b bVar, List<MaterialData> list, MaterialFileData materialFileData, t tVar, long j2, String str, String str2, CustomInfoData customInfoData, int i2, String str3, String str4) {
        this.z = "广告";
        this.A = false;
        this.B = false;
        this.F = false;
        this.J = false;
        this.K = false;
        String str5 = bVar.x;
        this.f21693i = str5 == null ? "" : str5;
        String str6 = bVar.y;
        this.f21694j = str6 == null ? "" : str6;
        String str7 = bVar.z;
        this.k = str7 == null ? "" : str7;
        String str8 = bVar.F;
        this.p = str8 == null ? "" : str8;
        String str9 = bVar.R;
        this.f21689e = str9 == null ? "" : str9;
        this.f21688d = list;
        Integer num = bVar.C;
        this.m = (num == null ? com.opos.mobad.b.a.b.f19605e : num).intValue();
        this.n = materialFileData;
        Boolean bool = bVar.B;
        this.l = (bool == null ? com.opos.mobad.b.a.b.f19604d : bool).booleanValue();
        Integer num2 = bVar.E;
        this.o = (num2 == null ? com.opos.mobad.b.a.b.f19606f : num2).intValue();
        Long l = bVar.G;
        this.q = (l == null ? com.opos.mobad.b.a.b.f19607g : l).longValue();
        Boolean bool2 = bVar.H;
        this.r = (bool2 == null ? com.opos.mobad.b.a.b.f19608h : bool2).booleanValue();
        Integer num3 = bVar.I;
        this.s = (num3 == null ? com.opos.mobad.b.a.b.f19609i : num3).intValue();
        Integer num4 = bVar.J;
        this.t = (num4 == null ? com.opos.mobad.b.a.b.f19610j : num4).intValue();
        Integer num5 = bVar.L;
        this.u = (num5 == null ? com.opos.mobad.b.a.b.l : num5).intValue();
        b.c cVar = bVar.M;
        this.v = a(cVar == null ? com.opos.mobad.b.a.b.m : cVar);
        Boolean bool3 = bVar.N;
        this.x = (bool3 == null ? com.opos.mobad.b.a.b.n : bool3).booleanValue();
        Integer num6 = bVar.Z;
        this.y = (num6 == null ? com.opos.mobad.b.a.b.u : num6).intValue();
        String str10 = bVar.P;
        if (str10 != null) {
            this.z = str10;
        }
        Boolean bool4 = bVar.S;
        this.B = (bool4 == null ? com.opos.mobad.b.a.b.q : bool4).booleanValue();
        b.f fVar = bVar.T;
        this.C = a(fVar == null ? com.opos.mobad.b.a.b.r : fVar);
        this.E = a(bVar.V);
        if (tVar != null) {
            this.f21691g = tVar.f19873d;
            this.f21692h = tVar.f19874e;
        }
        this.w = j2;
        this.f21690f = str == null ? "" : str;
        String str11 = bVar.W;
        this.G = str11 != null ? str11 : "";
        this.H = str2;
        Integer num7 = bVar.X;
        this.I = (num7 == null ? com.opos.mobad.b.a.b.t : num7).intValue();
        a(bVar.U);
        this.L = SystemClock.elapsedRealtime();
        this.M = a(bVar);
        this.N = customInfoData;
        this.O = i2;
        this.P = str3;
        Integer num8 = bVar.aa;
        this.Q = (num8 == null ? com.opos.mobad.b.a.b.v : num8).intValue();
        Integer num9 = bVar.ab;
        this.R = (num9 == null ? com.opos.mobad.b.a.b.w : num9).intValue();
        this.S = str4;
    }

    private static int a(b.EnumC0424b enumC0424b) {
        if (enumC0424b != null) {
            int i2 = AnonymousClass2.f21695a[enumC0424b.ordinal()];
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 3) {
                return 2;
            }
        }
        return 0;
    }

    private static int a(b.c cVar) {
        if (cVar != null) {
            int i2 = AnonymousClass2.f21697c[cVar.ordinal()];
            if (i2 == 1) {
                return 1;
            }
            if (i2 == 2) {
                return 2;
            }
        }
        return 0;
    }

    private static int a(b.f fVar) {
        if (fVar != null) {
            int i2 = AnonymousClass2.f21696b[fVar.ordinal()];
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 3) {
                return 2;
            }
        }
        return 0;
    }

    private AppPrivacyData a(com.opos.mobad.b.a.b bVar) {
        h hVar = bVar.Y;
        if (hVar == null || TextUtils.isEmpty(hVar.f19714e) || TextUtils.isEmpty(hVar.f19713d) || TextUtils.isEmpty(hVar.f19716g) || TextUtils.isEmpty(hVar.f19715f)) {
            return null;
        }
        return new AppPrivacyData(hVar.f19713d, hVar.f19714e, hVar.f19716g, hVar.f19715f);
    }

    private void a(com.opos.mobad.b.a.a aVar) {
        ArrayList arrayList;
        if (aVar == null) {
            return;
        }
        if (aVar.f19520g == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (e eVar : aVar.f19520g) {
                arrayList.add(new ApkSignerData(eVar.f19690d, eVar.f19691e, eVar.f19692f));
            }
        }
        this.D = new ActivatingData(aVar.f19518e, aVar.f19519f, arrayList, aVar.f19521h.intValue());
    }

    public void a(AppPrivacyData appPrivacyData) {
        this.M = appPrivacyData;
    }

    public void b(long j2) {
        this.w = j2;
    }

    public boolean A() {
        return this.y == 0;
    }

    public String B() {
        return this.z;
    }

    public boolean C() {
        return this.A;
    }

    public boolean D() {
        return this.B;
    }

    public int E() {
        return this.C;
    }

    public int F() {
        return this.E;
    }

    public ActivatingData G() {
        return this.D;
    }

    public void H() {
        this.F = true;
    }

    public boolean I() {
        return this.F;
    }

    public String J() {
        return this.G;
    }

    public int K() {
        return this.I;
    }

    public boolean L() {
        return this.J;
    }

    public boolean M() {
        return this.K;
    }

    public long N() {
        return this.L;
    }

    public AppPrivacyData O() {
        return this.M;
    }

    public int P() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.c();
        }
        return 2;
    }

    public boolean Q() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.a();
        }
        return false;
    }

    public int R() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.d();
        }
        return 0;
    }

    public int S() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.e();
        }
        return 0;
    }

    public int T() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.f();
        }
        return 3000;
    }

    public int U() {
        CustomInfoData customInfoData = this.N;
        if (customInfoData != null) {
            return customInfoData.g();
        }
        return 2000;
    }

    public int V() {
        return this.O;
    }

    public String W() {
        return this.P;
    }

    public int X() {
        return this.Q;
    }

    public int Y() {
        return this.R;
    }

    public String Z() {
        return this.S;
    }

    public String a() {
        return this.H;
    }

    public void a(int i2) {
        this.m = i2;
    }

    public void a(long j2) {
        this.q = j2;
    }

    public void a(ActivatingData activatingData) {
        this.D = activatingData;
    }

    public void a(MaterialFileData materialFileData) {
        this.n = materialFileData;
    }

    public void a(String str) {
        this.f21689e = str;
    }

    public void a(List<MaterialData> list) {
        this.f21688d = list;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public String aa() {
        return this.T;
    }

    public String b() {
        return this.f21689e;
    }

    public void b(int i2) {
        this.o = i2;
    }

    public void b(String str) {
        this.f21690f = str;
    }

    public void b(boolean z) {
        this.r = z;
    }

    public String c() {
        return this.f21690f;
    }

    public void c(int i2) {
        this.s = i2;
    }

    public void c(String str) {
        this.f21691g = str;
    }

    public void c(boolean z) {
        this.x = z;
    }

    public String d() {
        return this.f21691g;
    }

    public void d(int i2) {
        this.t = i2;
    }

    public void d(String str) {
        this.f21692h = str;
    }

    public void d(boolean z) {
        this.A = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f21692h;
    }

    public void e(int i2) {
        this.u = i2;
    }

    public void e(String str) {
        this.f21693i = str;
    }

    public void e(boolean z) {
        this.B = z;
    }

    public String f() {
        return this.f21693i;
    }

    public void f(int i2) {
        this.v = i2;
    }

    public void f(String str) {
        this.f21694j = str;
    }

    public void f(boolean z) {
        this.J = z;
    }

    public String g() {
        return this.f21694j;
    }

    public void g(int i2) {
        this.y = i2;
    }

    public void g(String str) {
        this.k = str;
    }

    public void g(boolean z) {
        this.K = z;
    }

    public String h() {
        return this.k;
    }

    public void h(int i2) {
        this.C = i2;
    }

    public void h(String str) {
        this.p = str;
    }

    public List<MaterialData> i() {
        return this.f21688d;
    }

    public void i(int i2) {
        this.E = i2;
    }

    public void i(String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return;
        }
        this.z = str;
    }

    public void j(String str) {
        this.G = str;
    }

    public boolean j() {
        return this.l;
    }

    public int k() {
        return this.m;
    }

    public void k(String str) {
        this.T = str;
    }

    public MaterialFileData l() {
        return this.n;
    }

    public int m() {
        return this.o;
    }

    public String n() {
        return this.p;
    }

    public long o() {
        return this.q;
    }

    public int p() {
        return this.s;
    }

    public int q() {
        return this.t;
    }

    public int r() {
        return this.v;
    }

    public long s() {
        return this.w;
    }

    public boolean t() {
        return this.x;
    }

    public String toString() {
        return "AdItemData{adSource='" + this.f21689e + "', respId='" + this.f21690f + "', adId='" + this.f21693i + "', posId='" + this.f21694j + "', planId='" + this.k + "', materialDataList=" + this.f21688d + ", showLogo=" + this.l + ", closeBnStyle=" + this.m + ", logoFile=" + this.n + ", refreshTime=" + this.o + ", ext='" + this.p + "', countdown=" + this.q + ", showSkipBn=" + this.r + ", showInterval=" + this.s + ", clickInterval=" + this.t + ", reqInterval=" + this.u + ", playMode=" + this.v + ", expTime=" + this.w + ", playRemindAtCellular=" + this.x + ", rewardScene=" + this.y + ", logoText='" + this.z + "', hasReward='" + this.A + "', playVideoInSilence='" + this.B + "', splashSkipBtPosition='" + this.C + "', videoOrientation='" + this.E + "', activatingData='" + this.D + "', isDownloaderStartReport=" + this.J + ", isDownloaderCompleteReport=" + this.K + ", appPrivacyData=" + this.M + ", customInfo= " + this.N + ", posType= " + this.O + ", ageGrading= " + this.P + ", mKeyWords= " + this.T + '}';
    }

    public int u() {
        return this.y;
    }

    public boolean v() {
        return (this.y & 1) == 1;
    }

    public boolean w() {
        return (this.y & 2) == 2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f21689e);
        parcel.writeString(this.f21690f);
        parcel.writeString(this.f21691g);
        parcel.writeString(this.f21692h);
        parcel.writeString(this.f21693i);
        parcel.writeString(this.f21694j);
        parcel.writeString(this.k);
        parcel.writeTypedList(this.f21688d);
        parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.m);
        parcel.writeParcelable(this.n, i2);
        parcel.writeInt(this.o);
        parcel.writeString(this.p);
        parcel.writeLong(this.q);
        parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.s);
        parcel.writeInt(this.t);
        parcel.writeInt(this.u);
        parcel.writeInt(this.v);
        parcel.writeLong(this.w);
        parcel.writeByte(this.x ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.y);
        parcel.writeString(this.z);
        parcel.writeByte(this.B ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.C);
        parcel.writeInt(this.E);
        parcel.writeParcelable(this.D, i2);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.I);
        parcel.writeByte(this.J ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.K ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.L);
        parcel.writeParcelable(this.M, i2);
        parcel.writeParcelable(this.N, i2);
        parcel.writeInt(this.O);
        parcel.writeString(this.P);
        parcel.writeInt(this.Q);
        parcel.writeString(this.S);
        parcel.writeInt(this.R);
        parcel.writeString(this.T);
    }

    public boolean x() {
        return (this.y & 4) == 4;
    }

    public boolean y() {
        return (this.y & 8) == 8;
    }

    public boolean z() {
        return (this.y & 16) == 16;
    }
}
