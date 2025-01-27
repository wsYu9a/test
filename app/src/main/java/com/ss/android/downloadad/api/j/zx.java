package com.ss.android.downloadad.api.j;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.pa;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class zx implements j {

    /* renamed from: a */
    private boolean f24088a;
    private boolean az;

    /* renamed from: b */
    private boolean f24089b;
    private boolean bl;
    private long bw;

    /* renamed from: c */
    private transient boolean f24090c;
    private long cg;
    private long cm;
    private long db;

    /* renamed from: e */
    private String f24091e;
    private String ei;

    /* renamed from: f */
    private JSONObject f24092f;

    /* renamed from: g */
    public final AtomicBoolean f24093g;
    private long gg;
    private boolean gm;
    private boolean gs;
    private long gv;
    private boolean hk;
    private long hm;

    /* renamed from: i */
    public final AtomicBoolean f24094i;
    private boolean il;

    /* renamed from: j */
    protected boolean f24095j;
    private String jg;
    private String k;
    private int l;
    private String lg;
    private int lt;
    private boolean lv;
    private boolean m;

    /* renamed from: me */
    private String f24096me;
    private boolean mx;
    private String nt;
    private int p;
    private String pa;
    private long q;
    private long qo;
    private String qt;
    private int r;

    /* renamed from: rx */
    private boolean f24097rx;
    private int s;
    private String t;

    @AdBaseConstants.FunnelType
    private int tc;
    private int tf;
    private int ts;
    private String ty;
    private int u;
    private boolean um;
    private boolean up;
    private String v;
    private String vs;
    private boolean vy;
    private int w;
    private boolean xj;
    private boolean xl;
    private int y;
    private boolean yq;
    private int z;
    protected boolean zx;

    private zx() {
        this.y = 1;
        this.gm = true;
        this.mx = false;
        this.tf = 0;
        this.u = 0;
        this.up = false;
        this.xj = false;
        this.f24089b = true;
        this.hk = true;
        this.f24095j = true;
        this.zx = true;
        this.f24094i = new AtomicBoolean(false);
        this.f24093g = new AtomicBoolean(false);
        this.tc = 1;
        this.az = true;
        this.cm = -1L;
    }

    public String a() {
        return this.f24096me;
    }

    public long az() {
        return this.db;
    }

    public String b() {
        return this.ei;
    }

    public int bl() {
        return this.r;
    }

    public synchronized void bw() {
        this.u++;
    }

    public boolean c() {
        return this.yq;
    }

    public boolean cg() {
        return this.lv;
    }

    public boolean cm() {
        return this.xl;
    }

    public boolean db() {
        return this.bl;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public JSONObject e() {
        return null;
    }

    public void e(boolean z) {
        this.f24089b = z;
    }

    public void ei(boolean z) {
        this.vy = z;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public DownloadEventConfig f() {
        return hx();
    }

    public void g(int i2) {
        this.l = i2;
    }

    public long gg() {
        long j2 = this.bw;
        return j2 == 0 ? this.hm : j2;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public int gm() {
        return -1;
    }

    public void gm(boolean z) {
        this.f24095j = z;
    }

    public JSONObject gs() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mId", this.q);
            jSONObject.put("mExtValue", this.gv);
            jSONObject.put("mLogExtra", this.lg);
            jSONObject.put("mDownloadStatus", this.y);
            jSONObject.put("mPackageName", this.k);
            jSONObject.put("mIsAd", this.gm);
            jSONObject.put("mTimeStamp", this.hm);
            jSONObject.put("mExtras", this.f24092f);
            jSONObject.put("mVersionCode", this.s);
            jSONObject.put("mVersionName", this.ei);
            jSONObject.put("mDownloadId", this.z);
            jSONObject.put("mIsV3Event", this.um);
            jSONObject.put("mScene", this.ts);
            jSONObject.put("mEventTag", this.qt);
            jSONObject.put("mEventRefer", this.jg);
            jSONObject.put("mDownloadUrl", this.pa);
            jSONObject.put("mEnableBackDialog", this.mx);
            jSONObject.put("hasSendInstallFinish", this.f24094i.get());
            jSONObject.put("hasSendDownloadFailedFinally", this.f24093g.get());
            jSONObject.put("mLastFailedErrCode", this.l);
            jSONObject.put("mLastFailedErrMsg", this.vs);
            jSONObject.put("mOpenUrl", this.t);
            jSONObject.put("mLinkMode", this.r);
            jSONObject.put("mDownloadMode", this.w);
            jSONObject.put("mModelType", this.p);
            jSONObject.put("mAppName", this.f24091e);
            jSONObject.put("mAppIcon", this.v);
            jSONObject.put("mDownloadFailedTimes", this.tf);
            long j2 = this.bw;
            if (j2 == 0) {
                j2 = this.hm;
            }
            jSONObject.put("mRecentDownloadResumeTime", j2);
            jSONObject.put("mClickPauseTimes", this.u);
            jSONObject.put("mJumpInstallTime", this.gg);
            jSONObject.put("mCancelInstallTime", this.qo);
            jSONObject.put("mLastFailedResumeCount", this.lt);
            jSONObject.put("mIsUpdateDownload", this.up);
            jSONObject.put("mOriginMimeType", this.f24096me);
            jSONObject.put("mIsPatchApplyHandled", this.xj);
            jSONObject.put("downloadFinishReason", this.ty);
            jSONObject.put("clickDownloadTime", this.db);
            jSONObject.put("clickDownloadSize", this.cg);
            jSONObject.put("installAfterCleanSpace", this.bl);
            jSONObject.put("funnelType", this.tc);
            jSONObject.put("webUrl", this.nt);
            jSONObject.put("enableShowComplianceDialog", this.az);
            jSONObject.put("isAutoDownloadOnCardShow", this.vy);
            int i2 = 1;
            jSONObject.put("enable_new_activity", this.f24089b ? 1 : 0);
            jSONObject.put("enable_pause", this.hk ? 1 : 0);
            jSONObject.put("enable_ah", this.f24095j ? 1 : 0);
            if (!this.zx) {
                i2 = 0;
            }
            jSONObject.put("enable_am", i2);
        } catch (Exception e2) {
            pa.v().j(e2, "NativeDownloadModel toJson");
        }
        return jSONObject;
    }

    public void gv(long j2) {
        if (j2 > 0) {
            this.hm = j2;
        }
    }

    public AdDownloadController h() {
        return new AdDownloadController.Builder().setIsEnableBackDialog(this.mx).setLinkMode(this.r).setDownloadMode(this.w).setEnableShowComplianceDialog(this.az).setEnableAH(this.f24095j).setEnableAM(this.zx).build();
    }

    public int hk() {
        return this.ts;
    }

    public void hm(boolean z) {
        this.zx = z;
    }

    public AdDownloadEventConfig hx() {
        return new AdDownloadEventConfig.Builder().setClickButtonTag(this.qt).setRefer(this.jg).setIsEnableV3Event(this.um).build();
    }

    public void i(long j2) {
        this.qo = j2;
    }

    public AdDownloadModel il() {
        return new AdDownloadModel.Builder().setAdId(this.q).setExtraValue(this.gv).setLogExtra(this.lg).setPackageName(this.k).setExtra(this.f24092f).setIsAd(this.gm).setVersionCode(this.s).setVersionName(this.ei).setDownloadUrl(this.pa).setModelType(this.p).setMimeType(this.f24096me).setAppName(this.f24091e).setAppIcon(this.v).setDeepLink(new DeepLink(this.t, this.nt, null)).build();
    }

    public void j(int i2) {
        this.tf = i2;
    }

    public long jg() {
        return this.cm;
    }

    public void k(int i2) {
        this.tc = i2;
    }

    public int l() {
        return this.l;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public JSONObject lg() {
        return this.f24092f;
    }

    public int lt() {
        return this.lt;
    }

    public boolean lv() {
        return this.f24090c;
    }

    public boolean m() {
        return this.gs;
    }

    public long me() {
        return this.hm;
    }

    public int mx() {
        return this.tf;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public long nt() {
        return this.gv;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public boolean p() {
        return this.um;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public String pa() {
        return this.qt;
    }

    public void q(long j2) {
        this.gv = j2;
    }

    public long qo() {
        return this.gg;
    }

    public boolean qt() {
        return this.mx;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public List<String> r() {
        return null;
    }

    public void r(boolean z) {
        this.gs = z;
    }

    public boolean rx() {
        return this.xj;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public JSONObject s() {
        return null;
    }

    public void s(boolean z) {
        this.az = z;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public JSONObject t() {
        return null;
    }

    public void t(String str) {
        this.v = str;
    }

    public boolean tc() {
        return this.f24097rx;
    }

    public synchronized void tf() {
        this.tf++;
    }

    public String ts() {
        return this.ty;
    }

    public boolean ty() {
        return this.up;
    }

    public int u() {
        return this.u;
    }

    public String um() {
        return this.f24091e;
    }

    public int up() {
        return this.y;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public int v() {
        return this.z;
    }

    public String vs() {
        return this.vs;
    }

    public long vy() {
        return this.cg;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public Object w() {
        return null;
    }

    public void w(boolean z) {
        this.il = z;
    }

    public int xj() {
        return this.s;
    }

    public boolean xl() {
        return this.m;
    }

    public void y(int i2) {
        this.ts = i2;
    }

    public boolean yq() {
        return this.il;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public DownloadController z() {
        return h();
    }

    public void zx(int i2) {
        this.u = i2;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public boolean ei() {
        return this.f24089b;
    }

    public void g(long j2) {
        this.q = j2;
    }

    public void gv(int i2) {
        this.s = i2;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public DownloadModel hm() {
        return il();
    }

    public void i(int i2) {
        this.lt = i2;
    }

    public void j(long j2) {
        this.bw = j2;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public String k() {
        return this.jg;
    }

    public void lg(int i2) {
        this.z = i2;
    }

    public void nt(int i2) {
        this.p = i2;
    }

    public void p(String str) {
        this.f24096me = str;
    }

    public void pa(String str) {
        this.f24091e = str;
    }

    public void q(int i2) {
        this.y = i2;
    }

    public void t(int i2) {
        this.w = i2;
    }

    public void v(boolean z) {
        this.hk = z;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public int y() {
        return this.tc;
    }

    public void zx(long j2) {
        this.gg = j2;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public String g() {
        return this.lg;
    }

    public void gv(String str) {
        this.qt = str;
    }

    public void i(String str) {
        this.lg = str;
    }

    public void j(String str) {
        this.vs = str;
    }

    public void k(String str) {
        this.t = str;
    }

    public void lg(String str) {
        this.jg = str;
    }

    public void nt(String str) {
        this.ty = str;
    }

    public void p(boolean z) {
        this.m = z;
    }

    public void pa(int i2) {
        this.r = i2;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public String q() {
        return this.k;
    }

    public void t(boolean z) {
        this.xl = z;
    }

    public void y(String str) {
        this.pa = str;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public long zx() {
        return this.q;
    }

    public void g(String str) {
        this.ei = str;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public String gv() {
        return this.t;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public boolean i() {
        return this.gm;
    }

    public void j(boolean z) {
        this.gm = z;
    }

    public void k(long j2) {
        this.cg = j2;
    }

    public void lg(long j2) {
        this.cm = j2;
    }

    public void nt(boolean z) {
        this.yq = z;
    }

    public void pa(boolean z) {
        this.f24090c = z;
    }

    public void q(String str) {
        this.nt = str;
    }

    public void y(long j2) {
        this.db = j2;
    }

    public void zx(String str) {
        this.k = str;
    }

    public void g(boolean z) {
        this.f24088a = z;
    }

    public void gv(boolean z) {
        this.bl = z;
    }

    public void i(boolean z) {
        this.mx = z;
    }

    public void j(JSONObject jSONObject) {
        this.f24092f = jSONObject;
    }

    public void k(boolean z) {
        this.xj = z;
    }

    public void lg(boolean z) {
        this.lv = z;
    }

    public void q(boolean z) {
        this.f24097rx = z;
    }

    public void y(boolean z) {
        this.up = z;
    }

    public void zx(boolean z) {
        this.um = z;
    }

    public static zx zx(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        zx zxVar = new zx();
        try {
            zxVar.g(com.ss.android.download.api.i.zx.j(jSONObject, "mId"));
            zxVar.q(com.ss.android.download.api.i.zx.j(jSONObject, "mExtValue"));
            zxVar.i(jSONObject.optString("mLogExtra"));
            zxVar.q(jSONObject.optInt("mDownloadStatus"));
            zxVar.zx(jSONObject.optString("mPackageName"));
            boolean z = true;
            zxVar.j(jSONObject.optBoolean("mIsAd", true));
            zxVar.gv(com.ss.android.download.api.i.zx.j(jSONObject, "mTimeStamp"));
            zxVar.gv(jSONObject.optInt("mVersionCode"));
            zxVar.g(jSONObject.optString("mVersionName"));
            zxVar.lg(jSONObject.optInt("mDownloadId"));
            zxVar.zx(jSONObject.optBoolean("mIsV3Event"));
            zxVar.y(jSONObject.optInt("mScene"));
            zxVar.gv(jSONObject.optString("mEventTag"));
            zxVar.lg(jSONObject.optString("mEventRefer"));
            zxVar.y(jSONObject.optString("mDownloadUrl"));
            zxVar.i(jSONObject.optBoolean("mEnableBackDialog"));
            zxVar.f24094i.set(jSONObject.optBoolean("hasSendInstallFinish"));
            zxVar.f24093g.set(jSONObject.optBoolean("hasSendDownloadFailedFinally"));
            zxVar.g(jSONObject.optInt("mLastFailedErrCode"));
            zxVar.j(jSONObject.optString("mLastFailedErrMsg"));
            zxVar.k(jSONObject.optString("mOpenUrl"));
            zxVar.pa(jSONObject.optInt("mLinkMode"));
            zxVar.t(jSONObject.optInt("mDownloadMode"));
            zxVar.nt(jSONObject.optInt("mModelType"));
            zxVar.pa(jSONObject.optString("mAppName"));
            zxVar.t(jSONObject.optString("mAppIcon"));
            zxVar.j(jSONObject.optInt("mDownloadFailedTimes", 0));
            zxVar.j(com.ss.android.download.api.i.zx.j(jSONObject, "mRecentDownloadResumeTime"));
            zxVar.zx(jSONObject.optInt("mClickPauseTimes"));
            zxVar.zx(com.ss.android.download.api.i.zx.j(jSONObject, "mJumpInstallTime"));
            zxVar.i(com.ss.android.download.api.i.zx.j(jSONObject, "mCancelInstallTime"));
            zxVar.i(jSONObject.optInt("mLastFailedResumeCount"));
            zxVar.nt(jSONObject.optString("downloadFinishReason"));
            zxVar.k(jSONObject.optLong("clickDownloadSize"));
            zxVar.y(jSONObject.optLong("clickDownloadTime"));
            zxVar.y(jSONObject.optBoolean("mIsUpdateDownload"));
            zxVar.p(jSONObject.optString("mOriginMimeType"));
            zxVar.k(jSONObject.optBoolean("mIsPatchApplyHandled"));
            zxVar.gv(jSONObject.optBoolean("installAfterCleanSpace"));
            zxVar.k(jSONObject.optInt("funnelType", 1));
            zxVar.q(jSONObject.optString("webUrl"));
            zxVar.s(jSONObject.optBoolean("enableShowComplianceDialog", true));
            zxVar.ei(jSONObject.optBoolean("isAutoDownloadOnCardShow"));
            zxVar.e(jSONObject.optInt("enable_new_activity", 1) == 1);
            zxVar.v(jSONObject.optInt("enable_pause", 1) == 1);
            zxVar.gm(jSONObject.optInt("enable_ah", 1) == 1);
            if (jSONObject.optInt("enable_am", 1) != 1) {
                z = false;
            }
            zxVar.hm(z);
            zxVar.j(jSONObject.optJSONObject("mExtras"));
        } catch (Exception e2) {
            pa.v().j(e2, "NativeDownloadModel fromJson");
        }
        return zxVar;
    }

    @Override // com.ss.android.downloadad.api.j.j
    public String j() {
        return this.pa;
    }

    public zx(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        this(downloadModel, downloadEventConfig, downloadController, 0);
    }

    public zx(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, int i2) {
        this.y = 1;
        this.gm = true;
        this.mx = false;
        this.tf = 0;
        this.u = 0;
        this.up = false;
        this.xj = false;
        this.f24089b = true;
        this.hk = true;
        this.f24095j = true;
        this.zx = true;
        this.f24094i = new AtomicBoolean(false);
        this.f24093g = new AtomicBoolean(false);
        this.tc = 1;
        this.az = true;
        this.cm = -1L;
        this.q = downloadModel.getId();
        this.gv = downloadModel.getExtraValue();
        this.lg = downloadModel.getLogExtra();
        this.k = downloadModel.getPackageName();
        this.f24092f = downloadModel.getExtra();
        this.gm = downloadModel.isAd();
        this.s = downloadModel.getVersionCode();
        this.ei = downloadModel.getVersionName();
        this.pa = downloadModel.getDownloadUrl();
        if (downloadModel.getDeepLink() != null) {
            this.t = downloadModel.getDeepLink().getOpenUrl();
            this.nt = downloadModel.getDeepLink().getWebUrl();
        }
        this.p = downloadModel.getModelType();
        this.f24091e = downloadModel.getName();
        this.v = downloadModel.getAppIcon();
        this.f24096me = downloadModel.getMimeType();
        this.qt = downloadEventConfig.getClickButtonTag();
        this.jg = downloadEventConfig.getRefer();
        this.um = downloadEventConfig.isEnableV3Event();
        this.mx = downloadController.isEnableBackDialog();
        this.r = downloadController.getLinkMode();
        this.w = downloadController.getDownloadMode();
        this.az = downloadController.enableShowComplianceDialog();
        this.vy = downloadController.isAutoDownloadOnCardShow();
        this.f24089b = downloadController.enableNewActivity();
        this.f24095j = downloadController.enableAH();
        this.zx = downloadController.enableAM();
        this.z = i2;
        long currentTimeMillis = System.currentTimeMillis();
        this.hm = currentTimeMillis;
        this.bw = currentTimeMillis;
        this.xj = downloadModel.shouldDownloadWithPatchApply();
    }
}
