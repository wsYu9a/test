package com.ss.android.downloadad.api.a;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b implements a {
    private int A;
    private long B;
    private long C;
    private long D;
    private int E;
    private int F;
    private String G;
    private boolean H;
    private String I;
    private boolean J;
    private boolean K;
    private boolean L;
    private String M;
    private String N;
    private boolean O;
    private boolean P;
    private int Q;

    @AdBaseConstants.FunnelType
    private int R;
    private long S;
    private long T;
    private boolean U;
    private boolean V;
    private String W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a */
    protected boolean f21046a;

    /* renamed from: aa */
    private long f21047aa;

    /* renamed from: ab */
    private transient boolean f21048ab;

    /* renamed from: ac */
    private boolean f21049ac;

    /* renamed from: ad */
    private boolean f21050ad;

    /* renamed from: ae */
    private boolean f21051ae;

    /* renamed from: af */
    private boolean f21052af;

    /* renamed from: ag */
    private boolean f21053ag;

    /* renamed from: ah */
    private boolean f21054ah;

    /* renamed from: ai */
    private String f21055ai;

    /* renamed from: aj */
    private long f21056aj;

    /* renamed from: b */
    protected boolean f21057b;

    /* renamed from: c */
    public final AtomicBoolean f21058c;

    /* renamed from: d */
    public final AtomicBoolean f21059d;

    /* renamed from: e */
    public final AtomicBoolean f21060e;

    /* renamed from: f */
    private long f21061f;

    /* renamed from: g */
    private long f21062g;

    /* renamed from: h */
    private String f21063h;

    /* renamed from: i */
    private int f21064i;

    /* renamed from: j */
    private String f21065j;

    /* renamed from: k */
    private String f21066k;

    /* renamed from: l */
    private String f21067l;

    /* renamed from: m */
    private String f21068m;

    /* renamed from: n */
    private int f21069n;

    /* renamed from: o */
    private int f21070o;

    /* renamed from: p */
    private int f21071p;

    /* renamed from: q */
    private int f21072q;

    /* renamed from: r */
    private String f21073r;

    /* renamed from: s */
    private String f21074s;

    /* renamed from: t */
    private String f21075t;

    /* renamed from: u */
    private boolean f21076u;

    /* renamed from: v */
    private long f21077v;

    /* renamed from: w */
    private JSONObject f21078w;

    /* renamed from: x */
    private int f21079x;

    /* renamed from: y */
    private boolean f21080y;

    /* renamed from: z */
    private int f21081z;

    private b() {
        this.f21064i = 1;
        this.f21076u = true;
        this.f21080y = false;
        this.f21081z = 0;
        this.A = 0;
        this.H = false;
        this.J = false;
        this.K = true;
        this.L = true;
        this.f21046a = true;
        this.f21057b = true;
        this.f21058c = new AtomicBoolean(false);
        this.f21059d = new AtomicBoolean(false);
        this.f21060e = new AtomicBoolean(false);
        this.R = 1;
        this.U = true;
        this.f21047aa = -1L;
    }

    public synchronized void A() {
        this.A++;
    }

    public long B() {
        long j10 = this.B;
        return j10 == 0 ? this.f21077v : j10;
    }

    public long C() {
        return this.C;
    }

    public int D() {
        return this.E;
    }

    public int E() {
        return this.F;
    }

    public String F() {
        return this.G;
    }

    public int G() {
        return this.f21064i;
    }

    public long H() {
        return this.f21077v;
    }

    public int I() {
        return this.f21072q;
    }

    public String J() {
        return this.f21073r;
    }

    public int K() {
        return this.Q;
    }

    public boolean L() {
        return this.f21080y;
    }

    public long M() {
        return this.f21047aa;
    }

    public String N() {
        return this.f21074s;
    }

    public int O() {
        return this.f21070o;
    }

    public String P() {
        return this.W;
    }

    public boolean Q() {
        return this.Y;
    }

    public boolean R() {
        return this.P;
    }

    public boolean S() {
        return this.Z;
    }

    public long T() {
        return this.S;
    }

    public long U() {
        return this.T;
    }

    public boolean V() {
        return this.H;
    }

    public String W() {
        return this.I;
    }

    public boolean X() {
        return this.J;
    }

    public boolean Y() {
        return this.f21048ab;
    }

    public boolean Z() {
        return this.f21049ac;
    }

    public void a(int i10) {
        this.f21081z = i10;
    }

    public boolean aa() {
        return this.f21051ae;
    }

    public boolean ab() {
        return this.f21050ad;
    }

    public boolean ac() {
        return this.f21052af;
    }

    public boolean ad() {
        return this.f21053ag;
    }

    public boolean ae() {
        return this.f21054ah;
    }

    public String af() {
        return this.f21055ai;
    }

    public long ag() {
        return this.f21056aj;
    }

    public JSONObject ah() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.f21061f);
            jSONObject.put("mExtValue", this.f21062g);
            jSONObject.put("mLogExtra", this.f21063h);
            jSONObject.put("mDownloadStatus", this.f21064i);
            jSONObject.put("mPackageName", this.f21065j);
            jSONObject.put("mIsAd", this.f21076u);
            jSONObject.put("mTimeStamp", this.f21077v);
            jSONObject.put("mExtras", this.f21078w);
            jSONObject.put("mVersionCode", this.f21072q);
            jSONObject.put("mVersionName", this.f21073r);
            jSONObject.put("mDownloadId", this.f21079x);
            jSONObject.put("mIsV3Event", this.O);
            jSONObject.put("mScene", this.Q);
            jSONObject.put("mEventTag", this.M);
            jSONObject.put("mEventRefer", this.N);
            jSONObject.put("mDownloadUrl", this.f21066k);
            jSONObject.put("mEnableBackDialog", this.f21080y);
            jSONObject.put("hasSendInstallFinish", this.f21058c.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.f21059d.get());
            jSONObject.put("hasDoRebootMarketInstallFinishCheck", this.f21060e.get());
            jSONObject.put("mLastFailedErrCode", this.F);
            jSONObject.put("mLastFailedErrMsg", this.G);
            jSONObject.put("mOpenUrl", this.f21067l);
            jSONObject.put("mLinkMode", this.f21070o);
            jSONObject.put("mDownloadMode", this.f21071p);
            jSONObject.put("mModelType", this.f21069n);
            jSONObject.put("mAppName", this.f21074s);
            jSONObject.put("mAppIcon", this.f21075t);
            jSONObject.put("mDownloadFailedTimes", this.f21081z);
            long j10 = this.B;
            if (j10 == 0) {
                j10 = this.f21077v;
            }
            jSONObject.put("mRecentDownloadResumeTime", j10);
            jSONObject.put("mClickPauseTimes", this.A);
            jSONObject.put("mJumpInstallTime", this.C);
            jSONObject.put("mCancelInstallTime", this.D);
            jSONObject.put("mLastFailedResumeCount", this.E);
            jSONObject.put("mIsUpdateDownload", this.H);
            jSONObject.put("mOriginMimeType", this.I);
            jSONObject.put("mIsPatchApplyHandled", this.J);
            jSONObject.put("downloadFinishReason", this.W);
            jSONObject.put("clickDownloadTime", this.S);
            jSONObject.put("clickDownloadSize", this.T);
            jSONObject.put("installAfterCleanSpace", this.P);
            jSONObject.put(TTDownloadField.TT_FUNNEL_TYPE, this.R);
            jSONObject.put(TTDownloadField.TT_WEB_URL, this.f21068m);
            jSONObject.put(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG, this.U);
            jSONObject.put(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW, this.V);
            jSONObject.put("enable_new_activity", this.K ? 1 : 0);
            jSONObject.put("enable_pause", this.L ? 1 : 0);
            jSONObject.put("enable_ah", this.f21046a ? 1 : 0);
            jSONObject.put("enable_am", this.f21057b ? 1 : 0);
            jSONObject.putOpt("intent_jump_browser_success", Boolean.valueOf(this.f21054ah));
            jSONObject.put(DbJsonConstants.DBJSON_KEY_TASK_KEY, this.f21055ai);
            jSONObject.putOpt("market_install_finish_check_start_timestamp", Long.valueOf(this.f21056aj));
        } catch (Exception e10) {
            k.u().a(e10, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    public AdDownloadModel ai() {
        return new AdDownloadModel.Builder().setAdId(this.f21061f).setExtraValue(this.f21062g).setLogExtra(this.f21063h).setPackageName(this.f21065j).setExtra(this.f21078w).setIsAd(this.f21076u).setVersionCode(this.f21072q).setVersionName(this.f21073r).setDownloadUrl(this.f21066k).setModelType(this.f21069n).setMimeType(this.I).setAppName(this.f21074s).setAppIcon(this.f21075t).setTaskKey(this.f21055ai).setDeepLink(new DeepLink(this.f21067l, this.f21068m, null)).build();
    }

    public AdDownloadEventConfig aj() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.M).setRefer(this.N).setIsEnableV3Event(this.O).build();
    }

    public AdDownloadController ak() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.f21080y).setLinkMode(this.f21070o).setDownloadMode(this.f21071p).setEnableShowComplianceDialog(this.U).setEnableAH(this.f21046a).setEnableAM(this.f21057b).build();
    }

    public void b(int i10) {
        this.A = i10;
    }

    public void c(long j10) {
        this.D = j10;
    }

    public void d(int i10) {
        this.F = i10;
    }

    public void e(long j10) {
        this.f21062g = j10;
    }

    public void f(long j10) {
        if (j10 > 0) {
            this.f21077v = j10;
        }
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject g() {
        return this.f21078w;
    }

    public void h(int i10) {
        this.Q = i10;
    }

    public void i(int i10) {
        this.R = i10;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String j() {
        return this.M;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject k() {
        return null;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long l() {
        return this.f21062g;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean m() {
        return this.O;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public List<String> n() {
        return null;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public Object o() {
        return null;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject p() {
        return null;
    }

    public void q(boolean z10) {
        this.V = z10;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public JSONObject r() {
        return null;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int s() {
        return this.f21079x;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int t() {
        return -1;
    }

    public void u(boolean z10) {
        this.f21057b = z10;
    }

    public void v(boolean z10) {
        this.f21054ah = z10;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadController w() {
        return ak();
    }

    public int x() {
        return this.f21081z;
    }

    public synchronized void y() {
        this.f21081z++;
    }

    public int z() {
        return this.A;
    }

    public void a(long j10) {
        this.B = j10;
    }

    public void b(long j10) {
        this.C = j10;
    }

    public void c(int i10) {
        this.E = i10;
    }

    public void d(long j10) {
        this.f21061f = j10;
    }

    public void e(int i10) {
        this.f21064i = i10;
    }

    public void f(int i10) {
        this.f21072q = i10;
    }

    public void g(int i10) {
        this.f21079x = i10;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public int h() {
        return this.R;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String i() {
        return this.N;
    }

    public void j(String str) {
        this.f21074s = str;
    }

    public void k(String str) {
        this.f21075t = str;
    }

    public void l(int i10) {
        this.f21069n = i10;
    }

    public void m(String str) {
        this.I = str;
    }

    public void n(boolean z10) {
        this.f21052af = z10;
    }

    public void o(boolean z10) {
        this.f21053ag = z10;
    }

    public void p(boolean z10) {
        this.U = z10;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean q() {
        return this.K;
    }

    public void r(boolean z10) {
        this.K = z10;
    }

    public void s(boolean z10) {
        this.L = z10;
    }

    public void t(boolean z10) {
        this.f21046a = z10;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadModel u() {
        return ai();
    }

    @Override // com.ss.android.downloadad.api.a.a
    public DownloadEventConfig v() {
        return aj();
    }

    public void a(String str) {
        this.G = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public long b() {
        return this.f21061f;
    }

    public void c(String str) {
        this.f21063h = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String d() {
        return this.f21063h;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String e() {
        return this.f21065j;
    }

    public void f(String str) {
        this.M = str;
    }

    public void g(String str) {
        this.N = str;
    }

    public void h(String str) {
        this.f21066k = str;
    }

    public void i(String str) {
        this.f21067l = str;
    }

    public void j(int i10) {
        this.f21070o = i10;
    }

    public void k(int i10) {
        this.f21071p = i10;
    }

    public void l(String str) {
        this.W = str;
    }

    public void m(boolean z10) {
        this.f21050ad = z10;
    }

    public void n(String str) {
        this.f21055ai = str;
    }

    public void a(boolean z10) {
        this.f21076u = z10;
    }

    public void b(String str) {
        this.f21065j = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public boolean c() {
        return this.f21076u;
    }

    public void d(String str) {
        this.f21073r = str;
    }

    public void e(String str) {
        this.f21068m = str;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String f() {
        return this.f21067l;
    }

    public void g(long j10) {
        this.f21047aa = j10;
    }

    public void h(long j10) {
        this.S = j10;
    }

    public void i(long j10) {
        this.T = j10;
    }

    public void j(boolean z10) {
        this.f21048ab = z10;
    }

    public void k(boolean z10) {
        this.f21049ac = z10;
    }

    public void l(boolean z10) {
        this.f21051ae = z10;
    }

    public void a(JSONObject jSONObject) {
        this.f21078w = jSONObject;
    }

    public void b(boolean z10) {
        this.O = z10;
    }

    public void c(boolean z10) {
        this.f21080y = z10;
    }

    public void d(boolean z10) {
        this.X = z10;
    }

    public void e(boolean z10) {
        this.Y = z10;
    }

    public void f(boolean z10) {
        this.P = z10;
    }

    public void g(boolean z10) {
        this.Z = z10;
    }

    public void h(boolean z10) {
        this.H = z10;
    }

    public void i(boolean z10) {
        this.J = z10;
    }

    public void j(long j10) {
        this.f21056aj = j10;
    }

    public static b b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b bVar = new b();
        try {
            bVar.d(com.ss.android.download.api.c.b.a(jSONObject, "mId"));
            bVar.e(com.ss.android.download.api.c.b.a(jSONObject, "mExtValue"));
            bVar.c(jSONObject.optString("mLogExtra"));
            bVar.e(jSONObject.optInt("mDownloadStatus"));
            bVar.b(jSONObject.optString("mPackageName"));
            boolean z10 = true;
            bVar.a(jSONObject.optBoolean("mIsAd", true));
            bVar.f(com.ss.android.download.api.c.b.a(jSONObject, "mTimeStamp"));
            bVar.f(jSONObject.optInt("mVersionCode"));
            bVar.d(jSONObject.optString("mVersionName"));
            bVar.g(jSONObject.optInt("mDownloadId"));
            bVar.b(jSONObject.optBoolean("mIsV3Event"));
            bVar.h(jSONObject.optInt("mScene"));
            bVar.f(jSONObject.optString("mEventTag"));
            bVar.g(jSONObject.optString("mEventRefer"));
            bVar.h(jSONObject.optString("mDownloadUrl"));
            bVar.c(jSONObject.optBoolean("mEnableBackDialog"));
            bVar.f21058c.set(jSONObject.optBoolean("hasSendInstallFinish"));
            bVar.f21059d.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            bVar.f21060e.set(jSONObject.optBoolean("hasDoRebootMarketInstallFinishCheck"));
            bVar.d(jSONObject.optInt("mLastFailedErrCode"));
            bVar.a(jSONObject.optString("mLastFailedErrMsg"));
            bVar.i(jSONObject.optString("mOpenUrl"));
            bVar.j(jSONObject.optInt("mLinkMode"));
            bVar.k(jSONObject.optInt("mDownloadMode"));
            bVar.l(jSONObject.optInt("mModelType"));
            bVar.j(jSONObject.optString("mAppName"));
            bVar.k(jSONObject.optString("mAppIcon"));
            bVar.a(jSONObject.optInt("mDownloadFailedTimes", 0));
            bVar.a(com.ss.android.download.api.c.b.a(jSONObject, "mRecentDownloadResumeTime"));
            bVar.b(jSONObject.optInt("mClickPauseTimes"));
            bVar.b(com.ss.android.download.api.c.b.a(jSONObject, "mJumpInstallTime"));
            bVar.c(com.ss.android.download.api.c.b.a(jSONObject, "mCancelInstallTime"));
            bVar.c(jSONObject.optInt("mLastFailedResumeCount"));
            bVar.l(jSONObject.optString("downloadFinishReason"));
            bVar.i(jSONObject.optLong("clickDownloadSize"));
            bVar.h(jSONObject.optLong("clickDownloadTime"));
            bVar.h(jSONObject.optBoolean("mIsUpdateDownload"));
            bVar.m(jSONObject.optString("mOriginMimeType"));
            bVar.i(jSONObject.optBoolean("mIsPatchApplyHandled"));
            bVar.f(jSONObject.optBoolean("installAfterCleanSpace"));
            bVar.i(jSONObject.optInt(TTDownloadField.TT_FUNNEL_TYPE, 1));
            bVar.e(jSONObject.optString(TTDownloadField.TT_WEB_URL));
            bVar.p(jSONObject.optBoolean(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG, true));
            bVar.q(jSONObject.optBoolean(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW));
            bVar.r(jSONObject.optInt("enable_new_activity", 1) == 1);
            bVar.s(jSONObject.optInt("enable_pause", 1) == 1);
            bVar.t(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z10 = false;
            }
            bVar.u(z10);
            bVar.a(jSONObject.optJSONObject("mExtras"));
            bVar.v(jSONObject.optBoolean("intent_jump_browser_success"));
            bVar.n(jSONObject.optString(DbJsonConstants.DBJSON_KEY_TASK_KEY));
            bVar.j(jSONObject.optLong("market_install_finish_check_start_timestamp"));
        } catch (Exception e10) {
            k.u().a(e10, "NativeDownloadModel fromJson");
        }
        return bVar;
    }

    @Override // com.ss.android.downloadad.api.a.a
    public String a() {
        return this.f21066k;
    }

    public b(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public b(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i10) {
        this.f21064i = 1;
        this.f21076u = true;
        this.f21080y = false;
        this.f21081z = 0;
        this.A = 0;
        this.H = false;
        this.J = false;
        this.K = true;
        this.L = true;
        this.f21046a = true;
        this.f21057b = true;
        this.f21058c = new AtomicBoolean(false);
        this.f21059d = new AtomicBoolean(false);
        this.f21060e = new AtomicBoolean(false);
        this.R = 1;
        this.U = true;
        this.f21047aa = -1L;
        this.f21061f = downloadModel.getId();
        this.f21062g = downloadModel.getExtraValue();
        this.f21063h = downloadModel.getLogExtra();
        this.f21065j = downloadModel.getPackageName();
        this.f21078w = downloadModel.getExtra();
        this.f21076u = downloadModel.isAd();
        this.f21072q = downloadModel.getVersionCode();
        this.f21073r = downloadModel.getVersionName();
        this.f21066k = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.f21067l = downloadModel.getDeepLink().getOpenUrl();
            this.f21068m = downloadModel.getDeepLink().getWebUrl();
        }
        this.f21069n = downloadModel.getModelType();
        this.f21074s = downloadModel.getName();
        this.f21075t = downloadModel.getAppIcon();
        this.I = downloadModel.getMimeType();
        this.M = downloadEventConfig.getClickButtonTag();
        this.N = downloadEventConfig.getRefer();
        this.O = downloadEventConfig.isEnableV3Event();
        this.f21080y = downloadController.isEnableBackDialog();
        this.f21070o = downloadController.getLinkMode();
        this.f21071p = downloadController.getDownloadMode();
        this.U = downloadController.enableShowComplianceDialog();
        this.V = downloadController.isAutoDownloadOnCardShow();
        this.K = downloadController.enableNewActivity();
        this.f21046a = downloadController.enableAH();
        this.f21057b = downloadController.enableAM();
        this.f21079x = i10;
        long currentTimeMillis = System.currentTimeMillis();
        this.f21077v = currentTimeMillis;
        this.B = currentTimeMillis;
        this.J = downloadModel.shouldDownloadWithPatchApply();
        if (downloadModel instanceof AdDownloadModel) {
            this.f21055ai = ((AdDownloadModel) downloadModel).getTaskKey();
        }
    }
}
