package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ExecutorGroup;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.IChunkAdjustCalculator;
import com.ss.android.socialbase.downloader.downloader.IChunkCntCalculator;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f {
    private boolean A;
    private int C;
    private boolean D;
    private String E;
    private boolean G;
    private boolean H;
    private boolean I;
    private int L;
    private IDownloadMonitorDepend N;
    private IDownloadDepend O;
    private com.ss.android.socialbase.appdownloader.c.e P;
    private IDownloadFileUriProvider Q;
    private IDownloadDiskSpaceHandler R;
    private boolean S;
    private INotificationClickCallback T;
    private boolean U;
    private JSONObject V;
    private String W;
    private int Y;
    private long Z;

    /* renamed from: a */
    private Activity f21849a;

    /* renamed from: aa */
    private int f21850aa;

    /* renamed from: ab */
    private boolean f21851ab;

    /* renamed from: ad */
    private String f21853ad;

    /* renamed from: af */
    private String f21855af;

    /* renamed from: ag */
    private int[] f21856ag;

    /* renamed from: b */
    private Context f21857b;

    /* renamed from: c */
    private String f21858c;

    /* renamed from: d */
    private List<String> f21859d;

    /* renamed from: e */
    private String f21860e;

    /* renamed from: f */
    private String f21861f;

    /* renamed from: g */
    private String f21862g;

    /* renamed from: h */
    private List<HttpHeader> f21863h;

    /* renamed from: m */
    private IDownloadListener f21868m;

    /* renamed from: n */
    private IDownloadListener f21869n;

    /* renamed from: o */
    private String f21870o;

    /* renamed from: q */
    private boolean f21872q;

    /* renamed from: r */
    private IChunkAdjustCalculator f21873r;

    /* renamed from: s */
    private IChunkCntCalculator f21874s;

    /* renamed from: t */
    private IRetryDelayTimeCalculator f21875t;

    /* renamed from: u */
    private AbsNotificationItem f21876u;

    /* renamed from: v */
    private boolean f21877v;

    /* renamed from: w */
    private boolean f21878w;

    /* renamed from: x */
    private String f21879x;

    /* renamed from: y */
    private String f21880y;

    /* renamed from: z */
    private long f21881z;

    /* renamed from: i */
    private boolean f21864i = true;

    /* renamed from: j */
    private boolean f21865j = false;

    /* renamed from: k */
    private boolean f21866k = true;

    /* renamed from: l */
    private boolean f21867l = false;

    /* renamed from: p */
    private String f21871p = "application/vnd.android.package-archive";
    private int B = 5;
    private boolean F = true;
    private EnqueueType J = EnqueueType.ENQUEUE_NONE;
    private int K = 150;
    private boolean M = true;
    private List<IDownloadCompleteHandler> X = new ArrayList();

    /* renamed from: ac */
    private boolean f21852ac = true;

    /* renamed from: ae */
    private boolean f21854ae = true;

    public f(@NonNull Context context, @NonNull String str) {
        this.f21857b = context.getApplicationContext();
        this.f21858c = str;
    }

    public boolean A() {
        return this.D;
    }

    public String B() {
        return this.E;
    }

    public boolean C() {
        return this.F;
    }

    public boolean D() {
        return this.G;
    }

    public IRetryDelayTimeCalculator E() {
        return this.f21875t;
    }

    public int F() {
        return this.K;
    }

    public int G() {
        return this.L;
    }

    public boolean H() {
        return this.H;
    }

    public boolean I() {
        return this.I;
    }

    public boolean J() {
        return this.M;
    }

    public boolean K() {
        return this.S;
    }

    public EnqueueType L() {
        return this.J;
    }

    public boolean M() {
        return this.A;
    }

    public String N() {
        return this.f21861f;
    }

    public IDownloadMonitorDepend O() {
        return this.N;
    }

    public IDownloadDepend P() {
        return this.O;
    }

    public com.ss.android.socialbase.appdownloader.c.e Q() {
        return this.P;
    }

    public IDownloadFileUriProvider R() {
        return this.Q;
    }

    public INotificationClickCallback S() {
        return this.T;
    }

    public List<IDownloadCompleteHandler> T() {
        return this.X;
    }

    public String U() {
        return this.f21853ad;
    }

    public boolean V() {
        return this.U;
    }

    public int W() {
        return this.Y;
    }

    public long X() {
        return this.Z;
    }

    public boolean Y() {
        return this.f21854ae;
    }

    public String Z() {
        return this.f21855af;
    }

    public Activity a() {
        return this.f21849a;
    }

    public int[] aa() {
        return this.f21856ag;
    }

    public boolean ab() {
        return this.f21851ab;
    }

    public boolean ac() {
        return this.f21852ac;
    }

    public String ad() {
        return this.W;
    }

    public List<String> ae() {
        return this.f21859d;
    }

    public IDownloadDiskSpaceHandler af() {
        return this.R;
    }

    public JSONObject ag() {
        return this.V;
    }

    public Context b() {
        return this.f21857b;
    }

    public String c() {
        return this.f21858c;
    }

    public String d() {
        return this.f21860e;
    }

    public String e() {
        return this.f21862g;
    }

    public List<HttpHeader> f() {
        return this.f21863h;
    }

    public boolean g() {
        return this.f21864i;
    }

    public boolean h() {
        return this.f21865j;
    }

    public boolean i() {
        return this.f21866k;
    }

    public boolean j() {
        return this.f21867l;
    }

    public IDownloadListener k() {
        return this.f21868m;
    }

    public IDownloadListener l() {
        return this.f21869n;
    }

    public String m() {
        return this.f21870o;
    }

    public String n() {
        return this.f21871p;
    }

    public boolean o() {
        return this.f21872q;
    }

    public AbsNotificationItem p() {
        return this.f21876u;
    }

    public IChunkCntCalculator q() {
        return this.f21874s;
    }

    public IChunkAdjustCalculator r() {
        return this.f21873r;
    }

    public boolean s() {
        return this.f21877v;
    }

    public boolean t() {
        return this.f21878w;
    }

    public int u() {
        return this.f21850aa;
    }

    public String v() {
        return this.f21879x;
    }

    public String w() {
        return this.f21880y;
    }

    public long x() {
        return this.f21881z;
    }

    public int y() {
        return this.B;
    }

    public int z() {
        return this.C;
    }

    public void a(int i10) {
        this.f21850aa = i10;
    }

    public f b(String str) {
        this.f21861f = str;
        return this;
    }

    public f c(@NonNull String str) {
        this.f21862g = str;
        return this;
    }

    public f d(String str) {
        this.f21853ad = str;
        return this;
    }

    public f e(String str) {
        this.f21870o = str;
        return this;
    }

    public f f(String str) {
        this.f21871p = str;
        return this;
    }

    public f g(String str) {
        this.f21879x = str;
        return this;
    }

    public f h(String str) {
        this.f21880y = str;
        return this;
    }

    public f i(String str) {
        this.E = str;
        return this;
    }

    public f j(boolean z10) {
        this.G = z10;
        return this;
    }

    public f k(boolean z10) {
        this.H = z10;
        return this;
    }

    public f l(boolean z10) {
        this.I = z10;
        return this;
    }

    public f m(boolean z10) {
        this.M = z10;
        return this;
    }

    public f n(boolean z10) {
        this.A = z10;
        return this;
    }

    public f o(boolean z10) {
        this.f21851ab = z10;
        return this;
    }

    public f p(boolean z10) {
        this.f21852ac = z10;
        return this;
    }

    public f a(String str) {
        this.f21860e = str;
        return this;
    }

    public f b(boolean z10) {
        this.f21865j = z10;
        return this;
    }

    public f c(boolean z10) {
        this.f21867l = z10;
        return this;
    }

    public f d(boolean z10) {
        this.f21872q = z10;
        return this;
    }

    public f e(boolean z10) {
        this.f21877v = z10;
        return this;
    }

    public f f(boolean z10) {
        this.f21878w = z10;
        return this;
    }

    public f g(boolean z10) {
        this.D = z10;
        return this;
    }

    public f h(boolean z10) {
        this.S = z10;
        return this;
    }

    public f i(boolean z10) {
        this.F = z10;
        return this;
    }

    public f j(String str) {
        this.f21855af = str;
        return this;
    }

    public f k(String str) {
        this.W = str;
        return this;
    }

    public f a(List<HttpHeader> list) {
        this.f21863h = list;
        return this;
    }

    public f b(int i10) {
        this.B = i10;
        return this;
    }

    public f c(int i10) {
        this.C = i10;
        return this;
    }

    public f d(int i10) {
        this.K = i10;
        return this;
    }

    public f e(int i10) {
        this.L = i10;
        return this;
    }

    public f f(@ExecutorGroup int i10) {
        this.Y = i10;
        return this;
    }

    public f a(boolean z10) {
        this.f21864i = z10;
        return this;
    }

    public f b(List<String> list) {
        this.f21859d = list;
        return this;
    }

    public f a(IDownloadListener iDownloadListener) {
        this.f21868m = iDownloadListener;
        return this;
    }

    public f a(long j10) {
        this.f21881z = j10;
        return this;
    }

    public f a(EnqueueType enqueueType) {
        this.J = enqueueType;
        return this;
    }

    public f a(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.Q = iDownloadFileUriProvider;
        return this;
    }

    public f a(IDownloadDiskSpaceHandler iDownloadDiskSpaceHandler) {
        this.R = iDownloadDiskSpaceHandler;
        return this;
    }

    public f a(JSONObject jSONObject) {
        this.V = jSONObject;
        return this;
    }

    public f a(IDownloadCompleteHandler iDownloadCompleteHandler) {
        synchronized (this.X) {
            if (iDownloadCompleteHandler != null) {
                try {
                    if (!this.X.contains(iDownloadCompleteHandler)) {
                        this.X.add(iDownloadCompleteHandler);
                        return this;
                    }
                } finally {
                }
            }
            return this;
        }
    }
}
