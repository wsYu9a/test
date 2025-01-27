package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.opos.mobad.b.a.ag;
import com.opos.mobad.b.a.f;
import com.opos.mobad.b.a.q;
import com.opos.mobad.b.a.s;
import com.opos.mobad.b.a.y;
import java.util.List;

/* loaded from: classes4.dex */
public class MaterialData extends a implements Parcelable, Comparable {
    public static final Parcelable.Creator<MaterialData> CREATOR = new Parcelable.Creator<MaterialData>() { // from class: com.opos.mobad.model.data.MaterialData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MaterialData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            MaterialData materialData = new MaterialData();
            materialData.a(parcel.readString());
            materialData.a(parcel.readInt());
            materialData.b(parcel.readInt());
            Parcelable.Creator<MaterialFileData> creator = MaterialFileData.CREATOR;
            materialData.a(parcel.createTypedArrayList(creator));
            materialData.b(parcel.readString());
            materialData.c(parcel.readString());
            materialData.b(parcel.createTypedArrayList(creator));
            materialData.a(parcel.readByte() != 0);
            materialData.d(parcel.readString());
            materialData.a(parcel.readLong());
            materialData.e(parcel.readString());
            materialData.c(parcel.createStringArrayList());
            materialData.d(parcel.createStringArrayList());
            materialData.e(parcel.createStringArrayList());
            materialData.f(parcel.readString());
            materialData.g(parcel.readString());
            materialData.c(parcel.readInt());
            materialData.b(parcel.readByte() != 0);
            materialData.h(parcel.readString());
            materialData.i(parcel.readString());
            materialData.b(parcel.readLong());
            materialData.d(parcel.readInt());
            materialData.j(parcel.readString());
            materialData.f(parcel.createStringArrayList());
            materialData.g(parcel.createStringArrayList());
            materialData.h(parcel.createStringArrayList());
            materialData.i(parcel.createStringArrayList());
            materialData.j(parcel.createStringArrayList());
            materialData.k(parcel.createStringArrayList());
            materialData.l(parcel.createStringArrayList());
            materialData.e(parcel.readInt());
            materialData.f(parcel.readInt());
            materialData.c(parcel.readByte() != 0);
            materialData.m(parcel.createTypedArrayList(creator));
            materialData.g(parcel.readInt());
            materialData.h(parcel.readInt());
            materialData.i(parcel.readInt());
            materialData.j(parcel.readInt());
            materialData.k(parcel.readInt());
            materialData.d(parcel.readByte() != 0);
            materialData.l(parcel.readInt());
            materialData.k(parcel.readString());
            materialData.e(parcel.readByte() != 0);
            materialData.f(parcel.readByte() != 0);
            materialData.m(parcel.readInt());
            materialData.a((AppDownloadData) parcel.readParcelable(AppDownloadData.class.getClassLoader()));
            materialData.n(parcel.createStringArrayList());
            materialData.o(parcel.createStringArrayList());
            materialData.p(parcel.createStringArrayList());
            materialData.l(parcel.readString());
            materialData.m(parcel.readString());
            materialData.n(parcel.readInt());
            materialData.a((FloatLayerData) parcel.readParcelable(FloatLayerData.class.getClassLoader()));
            materialData.o(parcel.readInt());
            materialData.p(parcel.readInt());
            materialData.g(parcel.readByte() != 0);
            materialData.n(parcel.readString());
            materialData.h(parcel.readByte() != 0);
            materialData.r(parcel.readInt());
            materialData.q(parcel.readInt());
            materialData.i(parcel.readByte() != 0);
            materialData.j(parcel.readByte() != 0);
            materialData.s(parcel.readInt());
            materialData.k(parcel.readByte() != 0);
            materialData.o(parcel.readString());
            materialData.aq = parcel.readByte() == 1;
            materialData.ar = (PendantData) parcel.readParcelable(PendantData.class.getClassLoader());
            materialData.as = parcel.readInt();
            materialData.q = parcel.createTypedArrayList(creator);
            materialData.at = parcel.readLong();
            materialData.au = parcel.readInt();
            materialData.av = parcel.readInt();
            materialData.aw = parcel.readString();
            materialData.ax = parcel.readString();
            return materialData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MaterialData[] newArray(int i2) {
            return new MaterialData[i2];
        }
    };
    private int A;
    private boolean B;
    private String C;
    private String D;
    private long E;
    private int F;
    private String G;
    private List<String> H;
    private List<String> I;
    private List<String> J;
    private List<String> K;
    private List<String> L;
    private List<String> M;
    private List<String> N;
    private int O;
    private int P;
    private boolean Q;
    private List<MaterialFileData> R;
    private int S;
    private int T;
    private int U;
    private int V;
    private int W;
    private boolean X;
    private int Y;
    private String Z;

    /* renamed from: a */
    public String f21716a;
    private boolean aa;
    private int ab;
    private boolean ac;

    /* renamed from: ad */
    private AppDownloadData f21717ad;
    private List<String> ae;
    private List<String> af;
    private List<String> ag;
    private String ah;
    private String ai;
    private int aj;
    private FloatLayerData ak;
    private int al;
    private int am;
    private boolean an;
    private boolean ao;
    private String ap;
    private boolean aq;
    private PendantData ar;
    private int as;
    private long at;
    private int au;
    private int av;
    private String aw;
    private String ax;

    /* renamed from: b */
    public boolean f21718b;

    /* renamed from: c */
    public int f21719c;

    /* renamed from: d */
    public int f21720d;

    /* renamed from: e */
    public boolean f21721e;

    /* renamed from: f */
    public boolean f21722f;

    /* renamed from: g */
    public int f21723g;

    /* renamed from: h */
    public List<String> f21724h;

    /* renamed from: i */
    public String f21725i;

    /* renamed from: j */
    private String f21726j;
    private int k;
    private int l;
    private List<MaterialFileData> m;
    private String n;
    private String o;
    private List<MaterialFileData> p;
    private List<MaterialFileData> q;
    private boolean r;
    private String s;
    private long t;
    private String u;
    private List<String> v;
    private List<String> w;
    private List<String> x;
    private String y;
    private String z;

    /* renamed from: com.opos.mobad.model.data.MaterialData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<MaterialData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MaterialData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            MaterialData materialData = new MaterialData();
            materialData.a(parcel.readString());
            materialData.a(parcel.readInt());
            materialData.b(parcel.readInt());
            Parcelable.Creator<MaterialFileData> creator = MaterialFileData.CREATOR;
            materialData.a(parcel.createTypedArrayList(creator));
            materialData.b(parcel.readString());
            materialData.c(parcel.readString());
            materialData.b(parcel.createTypedArrayList(creator));
            materialData.a(parcel.readByte() != 0);
            materialData.d(parcel.readString());
            materialData.a(parcel.readLong());
            materialData.e(parcel.readString());
            materialData.c(parcel.createStringArrayList());
            materialData.d(parcel.createStringArrayList());
            materialData.e(parcel.createStringArrayList());
            materialData.f(parcel.readString());
            materialData.g(parcel.readString());
            materialData.c(parcel.readInt());
            materialData.b(parcel.readByte() != 0);
            materialData.h(parcel.readString());
            materialData.i(parcel.readString());
            materialData.b(parcel.readLong());
            materialData.d(parcel.readInt());
            materialData.j(parcel.readString());
            materialData.f(parcel.createStringArrayList());
            materialData.g(parcel.createStringArrayList());
            materialData.h(parcel.createStringArrayList());
            materialData.i(parcel.createStringArrayList());
            materialData.j(parcel.createStringArrayList());
            materialData.k(parcel.createStringArrayList());
            materialData.l(parcel.createStringArrayList());
            materialData.e(parcel.readInt());
            materialData.f(parcel.readInt());
            materialData.c(parcel.readByte() != 0);
            materialData.m(parcel.createTypedArrayList(creator));
            materialData.g(parcel.readInt());
            materialData.h(parcel.readInt());
            materialData.i(parcel.readInt());
            materialData.j(parcel.readInt());
            materialData.k(parcel.readInt());
            materialData.d(parcel.readByte() != 0);
            materialData.l(parcel.readInt());
            materialData.k(parcel.readString());
            materialData.e(parcel.readByte() != 0);
            materialData.f(parcel.readByte() != 0);
            materialData.m(parcel.readInt());
            materialData.a((AppDownloadData) parcel.readParcelable(AppDownloadData.class.getClassLoader()));
            materialData.n(parcel.createStringArrayList());
            materialData.o(parcel.createStringArrayList());
            materialData.p(parcel.createStringArrayList());
            materialData.l(parcel.readString());
            materialData.m(parcel.readString());
            materialData.n(parcel.readInt());
            materialData.a((FloatLayerData) parcel.readParcelable(FloatLayerData.class.getClassLoader()));
            materialData.o(parcel.readInt());
            materialData.p(parcel.readInt());
            materialData.g(parcel.readByte() != 0);
            materialData.n(parcel.readString());
            materialData.h(parcel.readByte() != 0);
            materialData.r(parcel.readInt());
            materialData.q(parcel.readInt());
            materialData.i(parcel.readByte() != 0);
            materialData.j(parcel.readByte() != 0);
            materialData.s(parcel.readInt());
            materialData.k(parcel.readByte() != 0);
            materialData.o(parcel.readString());
            materialData.aq = parcel.readByte() == 1;
            materialData.ar = (PendantData) parcel.readParcelable(PendantData.class.getClassLoader());
            materialData.as = parcel.readInt();
            materialData.q = parcel.createTypedArrayList(creator);
            materialData.at = parcel.readLong();
            materialData.au = parcel.readInt();
            materialData.av = parcel.readInt();
            materialData.aw = parcel.readString();
            materialData.ax = parcel.readString();
            return materialData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MaterialData[] newArray(int i2) {
            return new MaterialData[i2];
        }
    }

    /* renamed from: com.opos.mobad.model.data.MaterialData$2 */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a */
        static final /* synthetic */ int[] f21727a;

        /* renamed from: b */
        static final /* synthetic */ int[] f21728b;

        /* renamed from: c */
        static final /* synthetic */ int[] f21729c;

        /* renamed from: d */
        static final /* synthetic */ int[] f21730d;

        /* renamed from: e */
        static final /* synthetic */ int[] f21731e;

        /* renamed from: f */
        static final /* synthetic */ int[] f21732f;

        /* renamed from: g */
        static final /* synthetic */ int[] f21733g;

        /* renamed from: h */
        static final /* synthetic */ int[] f21734h;

        /* renamed from: i */
        static final /* synthetic */ int[] f21735i;

        /* renamed from: j */
        static final /* synthetic */ int[] f21736j;
        static final /* synthetic */ int[] k;
        static final /* synthetic */ int[] l;

        static {
            int[] iArr = new int[s.values().length];
            l = iArr;
            try {
                iArr[s.TYPE_16_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                l[s.TYPE_16_9.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[y.g.values().length];
            k = iArr2;
            try {
                iArr2[y.g.OPEN_HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                k[y.g.OPEN_DETAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[y.b.values().length];
            f21736j = iArr3;
            try {
                iArr3[y.b.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f21736j[y.b.IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f21736j[y.b.TEXT_ICON.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f21736j[y.b.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f21736j[y.b.FULL_IMAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f21736j[y.b.TEXT_ICON_640X320.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f21736j[y.b.TEXT_ICON_320X210.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f21736j[y.b.TEXT_ICON_GROUP_320X210.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f21736j[y.b.VIDEO_HTML.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f21736j[y.b.VIDEO_TIP_BAR.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f21736j[y.b.FULL_VIDEO.ordinal()] = 11;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f21736j[y.b.POP_WINDOW_VIDEO.ordinal()] = 12;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f21736j[y.b.RAW_VIDEO.ordinal()] = 13;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f21736j[y.b.INTERACTIVE_MT.ordinal()] = 14;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr4 = new int[y.h.values().length];
            f21735i = iArr4;
            try {
                iArr4[y.h.SURFING.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f21735i[y.h.DOWNLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f21735i[y.h.MIDDLE_PAGE_DOWNLOAD.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f21735i[y.h.OPEN_HOME_PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f21735i[y.h.OPEN_DETAIL_PAGE.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f21735i[y.h.OPEN_INSTANT.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f21735i[y.h.OPEN_MINI_PROGRAM.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            int[] iArr5 = new int[y.f.values().length];
            f21734h = iArr5;
            try {
                iArr5[y.f.SHOW_REMINDER_TOAST.ordinal()] = 1;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f21734h[y.f.AUTO_OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused27) {
            }
            int[] iArr6 = new int[y.k.values().length];
            f21733g = iArr6;
            try {
                iArr6[y.k.WEBVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f21733g[y.k.SYSTEM_BROWSER.ordinal()] = 2;
            } catch (NoSuchFieldError unused29) {
            }
            int[] iArr7 = new int[y.l.values().length];
            f21732f = iArr7;
            try {
                iArr7[y.l.IMAGE_TIP_BAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f21732f[y.l.GRAPHIC_MIX_TIP_BAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused31) {
            }
            int[] iArr8 = new int[y.c.values().length];
            f21731e = iArr8;
            try {
                iArr8[y.c.SDK_APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f21731e[y.c.DEEPLINK_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f21731e[y.c.DOWNLOADER.ordinal()] = 3;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                f21731e[y.c.SAFE_DEEPLINK_APP.ordinal()] = 4;
            } catch (NoSuchFieldError unused35) {
            }
            int[] iArr9 = new int[y.m.values().length];
            f21730d = iArr9;
            try {
                iArr9[y.m.JUMP_LANDING_PAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f21730d[y.m.JUMP_FLOATING_LAYER.ordinal()] = 2;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f21730d[y.m.NO_JUMP_ACTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused38) {
            }
            int[] iArr10 = new int[y.d.values().length];
            f21729c = iArr10;
            try {
                iArr10[y.d.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f21729c[y.d.MODEL_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f21729c[y.d.MODEL_INTERACTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused41) {
            }
            int[] iArr11 = new int[ag.c.values().length];
            f21728b = iArr11;
            try {
                iArr11[ag.c.VIDEO_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f21728b[ag.c.VIDEO_PROCESS_25_PERCENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                f21728b[ag.c.VIDEO_PROCESS_50_PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f21728b[ag.c.VIDEO_PROCESS_75_PERCENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                f21728b[ag.c.VIDEO_COMPLETE.ordinal()] = 5;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f21728b[ag.c.VIDEO_CLICK.ordinal()] = 6;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f21728b[ag.c.VIDEO_CLOSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused48) {
            }
            int[] iArr12 = new int[q.b.values().length];
            f21727a = iArr12;
            try {
                iArr12[q.b.DOWNLOAD_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                f21727a[q.b.DOWNLOAD_COMPLETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f21727a[q.b.INSTALL_COMPLETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused51) {
            }
        }
    }

    public MaterialData() {
        this.B = true;
        this.P = 0;
    }

    public MaterialData(y yVar, List<MaterialFileData> list, List<MaterialFileData> list2, List<MaterialFileData> list3, List<MaterialFileData> list4, FloatLayerData floatLayerData, PendantData pendantData) {
        List<String> list5;
        List<String> list6;
        this.B = true;
        this.P = 0;
        String str = yVar.P;
        this.f21726j = str == null ? "" : str;
        this.k = a(yVar.Q);
        this.l = a(yVar.R);
        this.V = a(yVar.au);
        this.W = a(yVar.av);
        this.U = a(yVar.at);
        String str2 = yVar.T;
        this.n = str2 == null ? "" : str2;
        String str3 = yVar.U;
        this.o = str3 == null ? "" : str3;
        this.m = list;
        this.p = list2;
        this.R = list3;
        this.q = list4;
        Boolean bool = yVar.W;
        this.r = (bool == null ? y.f19911f : bool).booleanValue();
        String str4 = yVar.X;
        this.s = str4 == null ? "" : str4;
        Long l = yVar.Y;
        this.t = (l == null ? y.f19912g : l).longValue();
        String str5 = yVar.Z;
        this.u = str5 == null ? "" : str5;
        List<String> list7 = yVar.aa;
        if (list7 != null && list7.size() > 0) {
            this.v = list7;
        }
        List<String> list8 = yVar.ab;
        if (list8 != null && list8.size() > 0) {
            this.w = list8;
        }
        List<String> list9 = yVar.ac;
        if (list9 != null && list9.size() > 0) {
            this.x = list9;
        }
        String str6 = yVar.f19916ad;
        this.y = str6 == null ? "" : str6;
        String str7 = yVar.ae;
        this.z = str7 == null ? "" : str7;
        Integer num = yVar.af;
        this.A = (num == null ? y.f19913h : num).intValue();
        Boolean bool2 = yVar.ag;
        this.B = (bool2 == null ? y.f19914i : bool2).booleanValue();
        String str8 = yVar.ah;
        this.C = str8 == null ? "" : str8;
        String str9 = yVar.ai;
        this.D = str9 == null ? "" : str9;
        Long l2 = yVar.aj;
        this.E = (l2 == null ? y.f19915j : l2).longValue();
        Integer num2 = yVar.ak;
        this.F = (num2 == null ? y.k : num2).intValue();
        String str10 = yVar.al;
        this.G = str10 == null ? "" : str10;
        r(yVar.am);
        this.O = a(yVar.an);
        this.P = a(yVar.ao);
        Boolean bool3 = yVar.ap;
        this.Q = (bool3 == null ? y.n : bool3).booleanValue();
        this.S = a(yVar.ar);
        Integer num3 = yVar.as;
        this.T = (num3 == null ? y.p : num3).intValue();
        Boolean bool4 = yVar.aw;
        this.X = (bool4 == null ? y.t : bool4).booleanValue();
        this.Y = a(yVar.ax);
        String str11 = yVar.ay;
        this.Z = str11 == null ? "" : str11;
        String str12 = yVar.aF;
        this.ah = str12 == null ? "" : str12;
        String str13 = yVar.aE;
        this.ai = str13 == null ? "" : str13;
        this.aj = a(yVar.aG);
        Boolean bool5 = yVar.aK;
        this.an = (bool5 == null ? y.B : bool5).booleanValue();
        String str14 = yVar.aM;
        this.f21716a = str14 == null ? "" : str14;
        Boolean bool6 = yVar.aN;
        this.f21718b = (bool6 == null ? y.D : bool6).booleanValue();
        this.f21720d = a(yVar.aO);
        this.f21719c = a(yVar.aP);
        Boolean bool7 = yVar.aQ;
        this.f21721e = (bool7 == null ? y.G : bool7).booleanValue();
        Boolean bool8 = yVar.aR;
        this.f21722f = (bool8 == null ? y.H : bool8).booleanValue();
        Boolean bool9 = yVar.aB;
        this.aa = (bool9 == null ? y.x : bool9).booleanValue();
        Boolean bool10 = yVar.aA;
        this.ac = (bool10 == null ? y.w : bool10).booleanValue();
        Integer num4 = yVar.az;
        this.ab = (num4 == null ? y.v : num4).intValue();
        this.f21717ad = a(yVar.aC);
        q(yVar.aD);
        this.ak = floatLayerData;
        this.al = a(yVar.aI);
        this.am = a(yVar.aJ);
        this.f21725i = yVar.aS;
        this.f21724h = yVar.aT;
        this.f21723g = a(yVar.aV);
        Boolean bool11 = yVar.aW;
        this.ao = (bool11 == null ? y.J : bool11).booleanValue();
        String str15 = yVar.aU;
        this.ap = str15 == null ? "" : str15;
        Boolean bool12 = yVar.aX;
        this.aq = (bool12 == null ? y.K : bool12).booleanValue();
        this.ar = pendantData;
        Integer num5 = yVar.aZ;
        this.as = (num5 == null ? y.L : num5).intValue();
        List<String> list10 = this.x;
        if ((list10 == null || list10.size() <= 0) && (list5 = this.M) != null && list5.size() > 0) {
            this.x = this.M;
        }
        List<String> list11 = this.w;
        if ((list11 == null || list11.size() <= 0) && (list6 = this.N) != null && list6.size() > 0) {
            this.w = this.N;
        }
        Long l3 = yVar.bb;
        this.at = (l3 == null ? y.M : l3).longValue();
        Integer num6 = yVar.bd;
        this.au = (num6 == null ? y.O : num6).intValue();
        Integer num7 = yVar.bc;
        this.av = (num7 == null ? y.N : num7).intValue();
        String str16 = yVar.be;
        this.aw = str16 == null ? "" : str16;
        String str17 = yVar.bf;
        this.ax = str17 != null ? str17 : "";
    }

    private int a(s sVar) {
        return (sVar == null || AnonymousClass2.l[sVar.ordinal()] != 1) ? 1 : 0;
    }

    private static int a(y.b bVar) {
        if (bVar != null) {
            switch (AnonymousClass2.f21736j[bVar.ordinal()]) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
                case 8:
                    return 8;
                case 9:
                    return 9;
                case 10:
                    return 10;
                case 11:
                    return 11;
                case 12:
                    return 12;
                case 13:
                    return 13;
                case 14:
                    return 14;
            }
        }
        return 0;
    }

    private static int a(y.c cVar) {
        if (cVar != null) {
            int i2 = AnonymousClass2.f21731e[cVar.ordinal()];
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 3) {
                return 2;
            }
            if (i2 == 4) {
                return 3;
            }
        }
        return 0;
    }

    private static int a(y.d dVar) {
        if (dVar != null) {
            int i2 = AnonymousClass2.f21729c[dVar.ordinal()];
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 3) {
                return 2;
            }
        }
        return 0;
    }

    private static int a(y.f fVar) {
        if (fVar != null) {
            int i2 = AnonymousClass2.f21734h[fVar.ordinal()];
            if (i2 == 1) {
                return 1;
            }
            if (i2 == 2) {
                return 2;
            }
        }
        return 0;
    }

    private static int a(y.g gVar) {
        if (gVar != null) {
            int i2 = AnonymousClass2.k[gVar.ordinal()];
            if (i2 == 1) {
                return 1;
            }
            if (i2 == 2) {
                return 2;
            }
        }
        return 0;
    }

    public static int a(y.h hVar) {
        if (hVar != null) {
            switch (AnonymousClass2.f21735i[hVar.ordinal()]) {
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                    return 6;
                case 7:
                    return 7;
            }
        }
        return 0;
    }

    private static int a(y.k kVar) {
        return (kVar == null || AnonymousClass2.f21733g[kVar.ordinal()] != 2) ? 0 : 1;
    }

    private static int a(y.l lVar) {
        return (lVar == null || AnonymousClass2.f21732f[lVar.ordinal()] != 2) ? 0 : 1;
    }

    private static int a(y.m mVar) {
        if (mVar != null) {
            int i2 = AnonymousClass2.f21730d[mVar.ordinal()];
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 3) {
                return 2;
            }
        }
        return 0;
    }

    private AppDownloadData a(f fVar) {
        if (fVar == null) {
            return null;
        }
        AppDownloadData appDownloadData = new AppDownloadData();
        String str = fVar.f19697d;
        if (str == null) {
            str = "";
        }
        appDownloadData.a(str);
        String str2 = fVar.f19699f;
        if (str2 == null) {
            str2 = "";
        }
        appDownloadData.c(str2);
        String str3 = fVar.f19700g;
        if (str3 == null) {
            str3 = "";
        }
        appDownloadData.d(str3);
        String str4 = fVar.f19698e;
        appDownloadData.b(str4 != null ? str4 : "");
        return appDownloadData;
    }

    private void q(List<q> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (q qVar : list) {
            int i2 = AnonymousClass2.f21727a[qVar.f19845e.ordinal()];
            if (i2 == 1) {
                this.ae = qVar.f19846f;
            } else if (i2 == 2) {
                this.af = qVar.f19846f;
            } else if (i2 == 3) {
                this.ag = qVar.f19846f;
            }
        }
    }

    private void r(List<ag> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (ag agVar : list) {
            switch (AnonymousClass2.f21728b[agVar.f19581e.ordinal()]) {
                case 1:
                    this.H = agVar.f19582f;
                    break;
                case 2:
                    this.I = agVar.f19582f;
                    break;
                case 3:
                    this.J = agVar.f19582f;
                    break;
                case 4:
                    this.K = agVar.f19582f;
                    break;
                case 5:
                    this.L = agVar.f19582f;
                    break;
                case 6:
                    this.M = agVar.f19582f;
                    break;
                case 7:
                    this.N = agVar.f19582f;
                    break;
            }
        }
    }

    public List<String> A() {
        return this.K;
    }

    public List<String> B() {
        return this.L;
    }

    public int C() {
        return this.O;
    }

    public int D() {
        return this.P;
    }

    public boolean E() {
        return this.Q;
    }

    public List<MaterialFileData> F() {
        return this.R;
    }

    public int G() {
        return this.S;
    }

    public int H() {
        return this.T;
    }

    public int I() {
        return this.U;
    }

    public int J() {
        return this.V;
    }

    public int K() {
        return this.W;
    }

    public int L() {
        return this.Y;
    }

    public String M() {
        return this.Z;
    }

    public AppDownloadData N() {
        return this.f21717ad;
    }

    public List<String> O() {
        return this.ae;
    }

    public List<String> P() {
        return this.af;
    }

    public List<String> Q() {
        return this.ag;
    }

    public String R() {
        return this.ah;
    }

    public String S() {
        return this.ai;
    }

    public int T() {
        return this.aj;
    }

    public FloatLayerData U() {
        return this.ak;
    }

    public int V() {
        return this.al;
    }

    public int W() {
        return this.am;
    }

    public boolean X() {
        return this.an;
    }

    public String Y() {
        return this.f21716a;
    }

    public boolean Z() {
        return this.ao;
    }

    public void a(int i2) {
        this.k = i2;
    }

    public void a(long j2) {
        this.t = j2;
    }

    public void a(AppDownloadData appDownloadData) {
        this.f21717ad = appDownloadData;
    }

    public void a(FloatLayerData floatLayerData) {
        this.ak = floatLayerData;
    }

    public void a(String str) {
        this.f21726j = str;
    }

    public void a(List<MaterialFileData> list) {
        this.m = list;
    }

    public void a(boolean z) {
        this.r = z;
    }

    public boolean a() {
        return this.aq;
    }

    public String aa() {
        return this.ap;
    }

    public PendantData ab() {
        return this.ar;
    }

    public boolean ac() {
        return this.ar != null;
    }

    public long ad() {
        return this.at;
    }

    public int ae() {
        return this.au;
    }

    public int af() {
        return this.av;
    }

    public String ag() {
        return this.aw;
    }

    public String ah() {
        return this.ax;
    }

    public int b() {
        return this.as;
    }

    public void b(int i2) {
        this.l = i2;
    }

    public void b(long j2) {
        this.E = j2;
    }

    public void b(String str) {
        this.n = str;
    }

    public void b(List<MaterialFileData> list) {
        this.p = list;
    }

    public void b(boolean z) {
        this.B = z;
    }

    public String c() {
        return this.f21726j;
    }

    public void c(int i2) {
        this.A = i2;
    }

    public void c(String str) {
        this.o = str;
    }

    public void c(List<String> list) {
        this.v = list;
    }

    public void c(boolean z) {
        this.Q = z;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof AdItemData) {
            return this.A <= ((MaterialData) obj).A ? -1 : 1;
        }
        return 0;
    }

    public int d() {
        return this.k;
    }

    public void d(int i2) {
        this.F = i2;
    }

    public void d(String str) {
        this.s = str;
    }

    public void d(List<String> list) {
        this.w = list;
    }

    public void d(boolean z) {
        this.X = z;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.l;
    }

    public void e(int i2) {
        this.O = i2;
    }

    public void e(String str) {
        this.u = str;
    }

    public void e(List<String> list) {
        this.x = list;
    }

    public void e(boolean z) {
        this.aa = z;
    }

    public List<MaterialFileData> f() {
        return this.m;
    }

    public void f(int i2) {
        this.P = i2;
    }

    public void f(String str) {
        this.y = str;
    }

    public void f(List<String> list) {
        this.H = list;
    }

    public void f(boolean z) {
        this.ac = z;
    }

    public List<MaterialFileData> g() {
        return this.q;
    }

    public void g(int i2) {
        this.S = i2;
    }

    public void g(String str) {
        this.z = str;
    }

    public void g(List<String> list) {
        this.I = list;
    }

    public void g(boolean z) {
        this.an = z;
    }

    public String h() {
        return this.n;
    }

    public void h(int i2) {
        this.T = i2;
    }

    public void h(String str) {
        this.C = str;
    }

    public void h(List<String> list) {
        this.J = list;
    }

    public void h(boolean z) {
        this.f21718b = z;
    }

    public String i() {
        return this.o;
    }

    public void i(int i2) {
        this.U = i2;
    }

    public void i(String str) {
        this.D = str;
    }

    public void i(List<String> list) {
        this.K = list;
    }

    public void i(boolean z) {
        this.f21721e = z;
    }

    public List<MaterialFileData> j() {
        return this.p;
    }

    public void j(int i2) {
        this.V = i2;
    }

    public void j(String str) {
        this.G = str;
    }

    public void j(List<String> list) {
        this.L = list;
    }

    public void j(boolean z) {
        this.f21722f = z;
    }

    public String k() {
        return this.s;
    }

    public void k(int i2) {
        this.W = i2;
    }

    public void k(String str) {
        this.Z = str;
    }

    public void k(List<String> list) {
        this.M = list;
    }

    public void k(boolean z) {
        this.ao = z;
    }

    public long l() {
        return this.t;
    }

    public void l(int i2) {
        this.Y = i2;
    }

    public void l(String str) {
        this.ah = str;
    }

    public void l(List<String> list) {
        this.N = list;
    }

    public String m() {
        return this.u;
    }

    public void m(int i2) {
        this.ab = i2;
    }

    public void m(String str) {
        this.ai = str;
    }

    public void m(List<MaterialFileData> list) {
        this.R = list;
    }

    public List<String> n() {
        return this.v;
    }

    public void n(int i2) {
        this.aj = i2;
    }

    public void n(String str) {
        this.f21716a = str;
    }

    public void n(List<String> list) {
        this.ae = list;
    }

    public List<String> o() {
        return this.w;
    }

    public void o(int i2) {
        this.al = i2;
    }

    public void o(String str) {
        this.ap = str;
    }

    public void o(List<String> list) {
        this.af = list;
    }

    public List<String> p() {
        return this.x;
    }

    public void p(int i2) {
        this.am = i2;
    }

    public void p(List<String> list) {
        this.ag = list;
    }

    public String q() {
        return this.y;
    }

    public void q(int i2) {
        this.f21719c = i2;
    }

    public String r() {
        return this.z;
    }

    public void r(int i2) {
        this.f21720d = i2;
    }

    public String s() {
        return this.C;
    }

    public void s(int i2) {
        this.f21723g = i2;
    }

    public String t() {
        return this.D;
    }

    public String toString() {
        return "MaterialData{materialId='" + this.f21726j + "', creativeType=" + this.k + ", interactionType=" + this.l + ", imgFileList=" + this.m + ", interactiveFileList=" + this.q + ", title='" + this.n + "', desc='" + this.o + "', iconFileList=" + this.p + ", gbClick=" + this.r + ", downloadPkgName='" + this.s + "', apkSize=" + this.t + ", targetUrl='" + this.u + "', expStartUrls=" + this.v + ", expEndUrls=" + this.w + ", clickUrls=" + this.x + ", traceId='" + this.y + "', transparent='" + this.z + "', currentIndex=" + this.A + ", forceJsInit=" + this.B + ", extraUrl='" + this.C + "', dlChannel='" + this.D + "', videoDuration=" + this.E + ", showOffBnTime=" + this.F + ", landingPageUrl='" + this.G + "', videoStartUrls=" + this.H + ", video25PercentUrls=" + this.I + ", video50PercentUrls=" + this.J + ", video75PercentUrls=" + this.K + ", videoCompleteUrls=" + this.L + ", videoClickUrls=" + this.M + ", videoCloseUrls=" + this.N + ", installCompleteAction=" + this.O + ", surfingType=" + this.P + ", isGbClickToast=" + this.Q + ", videoFileList=" + this.R + ", tipBarType=" + this.S + ", rewardLimitTime=" + this.T + ", installedAction=" + this.U + ", extraActionType=" + this.V + ", videoActionType=" + this.W + ", isRemoveRepeatAd=" + this.X + ", downloadStyle=" + this.Y + ", downloadUrl=" + this.Z + ", maxDownloaderNums='" + this.ab + "', showDownloadNotification='" + this.ac + "', wifiRemindAtCellular='" + this.aa + "', trackContent=" + this.ah + ", trackReference=" + this.ai + ", appDownloadData=" + this.f21717ad + "', downloadStartUrls=" + this.ae + "', downloadCompleteUrls=" + this.af + "', downloadInstalledUrls=" + this.ag + "', videoCompleteAction=" + this.aj + "', floatLayerData=" + this.ak + "', floatLayerBtAction=" + this.al + "', floatLayerExtraAction=" + this.am + "', isMobileAutoPlay=" + this.an + "', buttonTitle=" + this.f21716a + "', isShowMediaInfo=" + this.f21718b + "', isShowConvertBar=" + this.f21721e + "', isDynamicPopUpConvert=" + this.f21722f + "', portEndPageModelType=" + this.f21720d + "', landEndPageModelType=" + this.f21719c + "', imgType=" + this.f21723g + "', isShowFeedBack=" + this.ao + "', isVertical=" + this.aq + "', pendantInfo=" + this.ar + "', templateId=" + this.as + "', apkDownloadTimes=" + this.at + "', specificationId=" + this.au + "'}";
    }

    public long u() {
        return this.E;
    }

    public int v() {
        return this.F;
    }

    public String w() {
        return this.G;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f21726j);
        parcel.writeInt(this.k);
        parcel.writeInt(this.l);
        parcel.writeTypedList(this.m);
        parcel.writeString(this.n);
        parcel.writeString(this.o);
        parcel.writeTypedList(this.p);
        parcel.writeByte(this.r ? (byte) 1 : (byte) 0);
        parcel.writeString(this.s);
        parcel.writeLong(this.t);
        parcel.writeString(this.u);
        parcel.writeStringList(this.v);
        parcel.writeStringList(this.w);
        parcel.writeStringList(this.x);
        parcel.writeString(this.y);
        parcel.writeString(this.z);
        parcel.writeInt(this.A);
        parcel.writeByte(this.B ? (byte) 1 : (byte) 0);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeLong(this.E);
        parcel.writeInt(this.F);
        parcel.writeString(this.G);
        parcel.writeStringList(this.H);
        parcel.writeStringList(this.I);
        parcel.writeStringList(this.J);
        parcel.writeStringList(this.K);
        parcel.writeStringList(this.L);
        parcel.writeStringList(this.M);
        parcel.writeStringList(this.N);
        parcel.writeInt(this.O);
        parcel.writeInt(this.P);
        parcel.writeByte(this.Q ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.R);
        parcel.writeInt(this.S);
        parcel.writeInt(this.T);
        parcel.writeInt(this.U);
        parcel.writeInt(this.V);
        parcel.writeInt(this.W);
        parcel.writeByte(this.X ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.Y);
        parcel.writeString(this.Z);
        parcel.writeByte(this.aa ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.ac ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.ab);
        parcel.writeParcelable(this.f21717ad, i2);
        parcel.writeStringList(this.ae);
        parcel.writeStringList(this.af);
        parcel.writeStringList(this.ag);
        parcel.writeString(this.ah);
        parcel.writeString(this.ai);
        parcel.writeInt(this.aj);
        parcel.writeParcelable(this.ak, i2);
        parcel.writeInt(this.al);
        parcel.writeInt(this.am);
        parcel.writeByte(this.an ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f21716a);
        parcel.writeByte(this.f21718b ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f21720d);
        parcel.writeInt(this.f21719c);
        parcel.writeByte(this.f21721e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f21722f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f21723g);
        parcel.writeByte(this.ao ? (byte) 1 : (byte) 0);
        parcel.writeString(this.ap);
        parcel.writeByte(this.aq ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.ar, i2);
        parcel.writeInt(this.as);
        parcel.writeTypedList(this.q);
        parcel.writeLong(this.at);
        parcel.writeInt(this.au);
        parcel.writeInt(this.av);
        parcel.writeString(this.aw);
        parcel.writeString(this.ax);
    }

    public List<String> x() {
        return this.H;
    }

    public List<String> y() {
        return this.I;
    }

    public List<String> z() {
        return this.J;
    }
}
